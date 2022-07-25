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
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;

    @CrossOrigin
    @GetMapping("/api/board/getBoardList")
    public Result<?> getBoardList() {
        log.info("Board API : getBoardList.");
        List<BoardDto> boardList = boardService.getBoardList();
        if(boardList.size() > 0) return new Result<>(boardList, HttpStatus.OK);
        else return new Result<>("", HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/api/board/getBoard/{id}")
    public Result<BoardDto> getBoard(@PathVariable("id") Long boardId) {
        log.info("Board API : getBoard. Request ID : " + boardId);
        BoardEntity findBoard = boardService.findById(boardId);
        if (findBoard == null) return new Result<>(new BoardDto(), HttpStatus.BAD_REQUEST);
        return new Result<>(BoardDto.EntityToDto(findBoard), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/api/board/createBoard")
    public Result<String> createBoard(
            @RequestBody Map<String, Object> paramMap) {
        log.info(String.format("Board API : createBoard. Request Param : " + paramMap));
        Long cateId = null;
        try {
            cateId = Long.parseLong(paramMap.get("cateId").toString());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>("failed", HttpStatus.BAD_REQUEST);
        }
        Long boardId = boardService.createBoard(
                BoardDto.builder()
                        .userId(paramMap.get("userId").toString())
                        .categoryId(cateId)
                        .title(paramMap.get("title").toString())
                        .content(paramMap.get("content").toString())
                        .build()
        );
        log.info("Board Save. ID : " + boardId);

        return new Result<>(boardId.toString(), HttpStatus.OK);
    }

    /*
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
     */
}