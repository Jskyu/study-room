package ond.studyroom.service;

import ond.studyroom.entity.BoardEntity;
import ond.studyroom.entity.dto.BoardDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
@Transactional
public class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Test
    public void createBoard() throws Exception {
        //given
        String userId = "seoma";
        Long cateId = 12345678L;
        String title = "test Title";
        String content = "test Content";

        BoardDto boardDto = new BoardDto(userId, cateId, title, content);

        //when
        Long boardId = -1L;
        try {
            boardId = boardService.createBoard(boardDto);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //then
        assertNotEquals(-1L, boardId);
    }

    @Test
    public void findById() throws Exception {
        //given
        BoardDto boardDto = BoardDto.builder()
                .userId("seoma")
                .categoryId(12345678L)
                .title("test Title")
                .content("test Content")
                .build();

        Long boardId = boardService.createBoard(boardDto);

        //when
        BoardEntity data = boardService.findById(boardId);

        //then
        assertEquals(boardId, data.getBoardId());
    }
}
