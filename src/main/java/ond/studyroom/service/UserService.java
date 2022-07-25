package ond.studyroom.service;

import lombok.RequiredArgsConstructor;
import ond.studyroom.entity.UserEntity;
import ond.studyroom.repo.AuthRepo;
import ond.studyroom.repo.UserRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final AuthRepo authRepo;

    public UserEntity findById(Long userId) {
        return userRepo.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("Not Found User. Index : " + userId));
    }

    public UserEntity findByUserId(String userId) {
        return userRepo.findByUserId(userId).orElseThrow(() -> new NoSuchElementException("Not Found User. ID : " + userId));
    }
}
