package ond.studyroom.repo;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static ond.studyroom.entity.QHomeEntity.homeEntity;

@Repository
@RequiredArgsConstructor
public class HomeRepoImpl implements HomeRepoCustom {

    private final JPAQueryFactory query;

    public String test() {
        return query.select(homeEntity.str).from(homeEntity).fetch().toString();
    }
}