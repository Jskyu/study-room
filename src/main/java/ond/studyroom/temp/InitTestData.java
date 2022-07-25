package ond.studyroom.temp;

import lombok.RequiredArgsConstructor;
import ond.studyroom.entity.AuthEntity;
import ond.studyroom.entity.CategoryEntity;
import ond.studyroom.entity.UserEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class InitTestData {

    private final InitService initService;

    @PostConstruct
    public void init(){
        initService.testAuthInit();
        initService.testUserInit();
        initService.testCategoryInit();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final EntityManager em;

        public void testAuthInit(){
            AuthEntity auth = new AuthEntity("A", "Administrator");
            em.persist(auth);
        }
        public void testUserInit() {
            AuthEntity auth = (AuthEntity) em.createQuery("select A from TN_AUTH A" +
                    " where A.userLevel = :userLevel").setParameter("userLevel", "A").getSingleResult();

            em.persist(UserEntity.builder()
                    .userId("seoma")
                    .userNick("서마")
                    .username("서마")
                    .userHp("010-8193-7533")
                    .userMail("hisunggyu@gmail.com")
                    .auth(auth)
                    .authYn("Y")
                    .delYn("N")
                    .regDate(LocalDateTime.now())
                    .build());
        }

        public void testCategoryInit() {
            em.persist(CategoryEntity.builder()
                    .ctgrName("테스트 카테고리")
                    .depth(0).build());

            em.createQuery("update TN_CATEGORY set ctgrId =:ctgrId where ctgrName=:name")
                    .setParameter("ctgrId", 12345678L)
                    .setParameter("name", "테스트 카테고리").executeUpdate();
        }
    }
}
