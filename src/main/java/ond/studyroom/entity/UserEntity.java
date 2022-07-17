package ond.studyroom.entity;

import lombok.*;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Entity(name = "TN_USER")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    @Comment("유저 ID")
    private Long userId;

    @Column(name = "USERNAME", unique = true)
    @Comment("유저 명")
    private String username;

    @Column(name = "PHONE_NUM")
    @Comment("유저 휴대폰 번호")
    private String phoneNum;

    @Column(name = "USER_EMAIL")
    @Comment("유저 이메일")
    private String userEmail;
}