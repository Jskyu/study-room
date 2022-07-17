package ond.studyroom.service;

import lombok.RequiredArgsConstructor;
import ond.studyroom.repo.BoardRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepo boardRepo;

}
