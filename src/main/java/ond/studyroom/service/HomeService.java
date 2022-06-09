package ond.studyroom.service;

import lombok.RequiredArgsConstructor;
import ond.studyroom.entity.HomeEntity;
import ond.studyroom.repo.HomeRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HomeService {

    private final HomeRepo homeRepo;

    public HomeEntity findById(Long id){
        return homeRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Not Found Entity. ID : " + id));
    }

    @Transactional
    public String test(){
        HomeEntity findEntity = homeRepo.findById(0L).orElse(new HomeEntity());
        if (findEntity.getId() == null) {
            findEntity.setId(0L);
            findEntity.setStr("string");
            findEntity = homeRepo.save(findEntity);
        }
        return findEntity.toString();
    }

}
