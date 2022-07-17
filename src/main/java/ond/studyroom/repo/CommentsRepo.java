package ond.studyroom.repo;

import ond.studyroom.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepo extends JpaRepository<CommentEntity, Long> {
}
