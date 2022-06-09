package ond.studyroom.repo;

import ond.studyroom.entity.HomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepo extends JpaRepository<HomeEntity, Long> {
}
