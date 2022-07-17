package ond.studyroom.repo;

import ond.studyroom.entity.BoardFileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardFileRepo extends JpaRepository<BoardFileEntity, Long> {
}
