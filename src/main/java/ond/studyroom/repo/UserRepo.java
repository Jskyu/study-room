package ond.studyroom.repo;

import ond.studyroom.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEntity, Long>, UserRepoCustom {

    public Optional<UserEntity> findByUserId(String userId);
}
