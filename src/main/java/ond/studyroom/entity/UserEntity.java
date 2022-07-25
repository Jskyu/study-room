package ond.studyroom.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "TN_USER")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
public class UserEntity {

    @Id
    @GeneratedValue
    @Column(name = "USER_INDEX")
    @Comment("유저 인덱스")
    private Long userIndex;

    @Column(name = "USER_ID", unique = true, length = 15, nullable = false)
    @Comment("유저 ID")
    private String userId;

    @Column(name = "USER_NICK", unique = true, length = 20, nullable = false)
    @Comment("유저 닉네임")
    private String userNick;

    @Column(name = "USER_NAME", length = 10, nullable = false)
    @Comment("유저 명")
    private String username;

    @Column(name = "USER_HP", length = 13, nullable = false)
    @Comment("유저 휴대폰 번호")
    private String userHp;

    @Column(name = "USER_MAIL", length = 50, nullable = false)
    @Comment("유저 이메일")
    private String userMail;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_LEVEL")
    @Comment("유저 권한 레벨")
    private AuthEntity auth;

    @Column(name = "USER_IMG", length = 255)
    @Comment("유저 대표이미지")
    private String userImg;

    @Column(name = "AUTH_YN", length = 1)
    @ColumnDefault("'N'")
    @Comment("본인인증 여부")
    private String authYn;

    @Column(name = "REG_DATE")
    @Comment("가입일")
    private LocalDateTime regDate;

    @Column(name = "DEL_YN", length = 1)
    @ColumnDefault("'N'")
    @Comment("탈퇴여부")
    private String delYn;

    @Column(name = "FAIL_PW_CNT", length = 1)
    @ColumnDefault("0")
    @Comment("비밀번호 실패 횟수")
    private int failPwCnt;

    public UserEntity(String userId, String userNick, String username, String userHp, String userMail, AuthEntity auth, String authYn, LocalDateTime regDate) {
        this.userId = userId;
        this.userNick = userNick;
        this.username = username;
        this.userHp = userHp;
        this.userMail = userMail;
        this.auth = auth;
        this.authYn = authYn;
        this.regDate = regDate;
    }
}