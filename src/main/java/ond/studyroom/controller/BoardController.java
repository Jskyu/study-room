package ond.studyroom.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ond.studyroom.entity.BoardEntity;
import ond.studyroom.entity.dto.BoardDto;
import ond.studyroom.entity.dto.Result;
import ond.studyroom.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/api/board/getBoardList")
    public Result<List<BoardDto>> getBoardList() {
        log.info("Board API : getBoardList.");
        List<BoardDto> findList = boardService.getBoardList().stream()
                .map(BoardDto::EntityToDto)
                .collect(Collectors.toList());
        return new Result<>(findList, HttpStatus.OK);
    }

    @GetMapping("/api/board/getBoard/{id}")
    public Result<BoardDto> getBoard(@PathVariable("id") Long boardId) {
        log.info("Board API : getBoard. Request ID : " + boardId);
        BoardEntity findBoard = boardService.findById(boardId);
        if (findBoard == null) return new Result<>(new BoardDto(), HttpStatus.BAD_REQUEST);
        return new Result<>(BoardDto.EntityToDto(findBoard), HttpStatus.OK);
    }

    @PostMapping("/api/board/createBoard")
    public Result<String> createBoard(
            @RequestParam(value = "userId", required = false) String userId,
            @RequestParam(value = "cateIdStr", required = false) String cateIdStr,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "content", required = false) String content) {
        log.info(String.format("Board API : createBoard. Request Param : %s, %s, %s, %s"
                , userId, cateIdStr, title, content));
        Long cateId = null;
        try {
            cateId = Long.parseLong(cateIdStr);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>("failed", HttpStatus.BAD_REQUEST);
        }
        Long boardId = boardService.createBoard(
                BoardDto.builder()
                        .userId(userId)
                        .categoryId(cateId)
                        .title(title)
                        .content(content)
                        .build()
        );
        log.info("Board Save. ID : " + boardId);

        return new Result<>(boardId.toString(), HttpStatus.OK);
    }
}