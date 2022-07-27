package ond.studyroom.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ond.studyroom.entity.BoardEntity;
import ond.studyroom.entity.dto.BoardDto;
import ond.studyroom.entity.dto.Result;
import ond.studyroom.service.BoardService;
import ond.studyroom.util.OndUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;

//    @CrossOrigin
    @GetMapping("/api/board/getBoardList")
    public Result<?> getBoardList() {
        log.info("Board API : getBoardList.");
        List<BoardDto> boardList = boardService.getBoardList();
        if (boardList.size() > 0) {
            return new Result<>(boardList);
        }

        return new Result<>("");
    }

//    @CrossOrigin
    @GetMapping("/api/board/getBoard/{id}")
    public Result<?> getBoard(@PathVariable("id") String boardId) {
        log.info("Board API : getBoard. Request ID : " + boardId);
        Long id = OndUtil.stringToLong(boardId);
        if (id == null) {
            return new Result<>(new BoardDto());
        }
        BoardEntity findBoard = boardService.findById(id);
        if (findBoard == null) return new Result<>(new BoardDto());
        return new Result<>(BoardDto.EntityToDto(findBoard));
    }

//    @CrossOrigin
    @PostMapping("/api/board/createBoard")
    public Result<String> createBoard(
            @RequestBody Map<String, Object> paramMap) {
        log.info("Board API : createBoard. Request Param : " + paramMap);
        Long cateId = OndUtil.stringToLong(paramMap.get("cateId").toString());

        if (cateId == null) return new Result<>("failed");

        Long boardId = boardService.createBoard(
                BoardDto.builder()
                        .userId(paramMap.get("userId").toString())
                        .categoryId(cateId)
                        .title(paramMap.get("title").toString())
                        .content(paramMap.get("content").toString())
                        .build()
        );
        log.info("Board Save. ID : " + boardId);

        return new Result<>(boardId.toString());
    }
}