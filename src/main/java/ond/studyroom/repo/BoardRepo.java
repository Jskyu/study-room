package ond.studyroom.repo;

import ond.studyroom.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepo extends JpaRepository<BoardEntity, Long>, BoardRepoCustom {
}
