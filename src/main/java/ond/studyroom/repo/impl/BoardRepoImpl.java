package ond.studyroom.repo.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import ond.studyroom.repo.BoardRepoCustom;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BoardRepoImpl implements BoardRepoCustom {
    private final JPAQueryFactory query;


}