package ond.studyroom.repo;

import ond.studyroom.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, Long>, UserRepoCustom {
}
