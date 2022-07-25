package ond.studyroom.service;

import lombok.RequiredArgsConstructor;
import ond.studyroom.entity.BoardEntity;
import ond.studyroom.entity.dto.BoardDto;
import ond.studyroom.entity.dto.Result;
import ond.studyroom.repo.BoardRepo;
import ond.studyroom.repo.CategoryRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepo boardRepo;
    private final UserService userService;
    private final CategoryRepo cateRepo;

    public List<BoardDto> getBoardList(){
        return boardRepo.getBoardList();
    }

    public BoardEntity findById(Long boardId){
        return boardRepo.findById(boardId)
                .orElseThrow(() -> new NoSuchElementException("Not found Item. ID : " + boardId));
    }

    @Transactional
    public Long createBoard(BoardDto dto){
        BoardEntity entity = dto.toEntity(
                dto,
                userService.findByUserId(dto.getUserId()),
                cateRepo.findById(dto.getCategoryId()).orElseThrow(() -> new NoSuchElementException("Not found Category. ID : " + dto.getCategoryId()))
        );
        if (entity.getRegDate() == null) {
            entity.setRegAndModDate();
        }
        return boardRepo.save(entity).getBoardId();
    }
}
