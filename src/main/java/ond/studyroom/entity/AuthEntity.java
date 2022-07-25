package ond.studyroom.entity;

import lombok.*;
import org.hibernate.annotations.Comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "TN_AUTH")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
public class AuthEntity {

    @Id
    @Column(name = "USER_LEVEL", length = 2)
    @Comment("권한레벨")
    private String userLevel;
    
    @Column(name = "LEVEL_NAME")
    @Comment("권한이름")
    private String levelName;
}
