package ond.studyroom.service;

import ond.studyroom.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void findByUserId() throws Exception {
        //given
        String userId = "seoma"; //temp.InitTestData 에서 initService.testUserInit 로 임시 데이터 저장함.

        //when
        UserEntity findUser = userService.findByUserId(userId);

        //then
        assertNotNull(findUser);
        assertEquals(findUser.getUserId(), userId);
    }
}
