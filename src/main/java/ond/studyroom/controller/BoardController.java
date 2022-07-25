package ond.studyroom.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ond.studyroom.entity.dto.BoardDto;
import ond.studyroom.entity.dto.Result;
import ond.studyroom.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/api/board/getBoardList")
    public Result<List<BoardDto>> getBoardList(){
        log.info("Board API : getBoardList.");
        return new Result<>(
                boardService.getBoardList().stream()
                        .map(BoardDto::EntityToDto)
                        .collect(Collectors.toList()));
    }

    @GetMapping("/api/board/getBoard/{id}")
    public Result<BoardDto> getBoard(@PathVariable("id") Long boardId){
        log.info("Board API : getBoard. Request ID : " + boardId);
        return new Result<>(BoardDto.EntityToDto(boardService.findById(boardId)));
    }

    @PostMapping("/api/board/createBoard")
    public Result<String> createBoard(
            @RequestParam(value = "userId", required = false) String userId,
            @RequestParam(value = "cateIdStr", required = false) String cateIdStr,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "content", required = false) String content){
        log.info(String.format("Board API : createBoard. Request Param : %s, %s, %s, %s"
                , userId, cateIdStr, title, content));
        Long cateId = null;
        try {
            cateId = Long.parseLong(cateIdStr);
        } catch (Exception e){
            e.printStackTrace();
        }
        Long boardId = boardService.createBoard(new BoardDto(userId, cateId, title, content));
        log.info("Board Save. ID : " + boardId);

        return new Result<>(boardId.toString());
    }
}