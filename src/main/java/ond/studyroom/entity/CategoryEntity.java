package ond.studyroom.entity;

import lombok.*;
import org.hibernate.annotations.Comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "TN_CATEGORY")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
public class CategoryEntity {

    @Id
    @GeneratedValue
    @Column(name = "CTGR_ID")
    @Comment("카테고리 ID")
    private Long ctgrId;

    @Column(name = "UP_CTGR_ID", length = 19)
    @Comment("상위 카테고리 ID")
    private Long upCtgrId;

    @Column(name = "CTGR_NAME", length = 100)
    @Comment("카테고리 명")
    private String ctgrName;

    @Column(name = "DEPTH", length = 1)
    @Comment("뎁스")
    private int depth;
}