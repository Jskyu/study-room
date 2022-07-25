package ond.studyroom.repo.impl;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import ond.studyroom.entity.dto.BoardDto;
import ond.studyroom.repo.BoardRepoCustom;
import org.springframework.stereotype.Repository;

import java.util.List;

import static ond.studyroom.entity.QBoardEntity.boardEntity;

@Repository
@RequiredArgsConstructor
public class BoardRepoImpl implements BoardRepoCustom {
    private final JPAQueryFactory query;

    /*
    this.userId = userId;
        this.categoryId = categoryId;
        this.title = title;
        this.content = content;
*/
    @Override
    public List<BoardDto> getBoardList() {
        return query.select(Projections.constructor(
                BoardDto.class,
                boardEntity.boardId,
                boardEntity.user.userNick,
                boardEntity.category.ctgrId,
                boardEntity.title,
                boardEntity.regDate))
                .from(boardEntity)
                .orderBy(boardEntity.boardId.asc())
                .fetch();
    }
}