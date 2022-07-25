package ond.studyroom.repo;

import ond.studyroom.entity.AuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepo extends JpaRepository<AuthEntity, String> {

}
