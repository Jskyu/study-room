package ond.studyroom.entity;

import lombok.*;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Entity(name = "TN_BOARD_COMMENTS")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CommentEntity {

    @Id
    @GeneratedValue
    @Column(name = "COMMENTS_ID")
    @Comment("댓글 ID")
    private Long commentsId;

    @Column(name = "UP_COMMENTS_ID")
    @Comment("상위 댓글 ID")
    private Long upCommentsId;

    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    @Comment("작성자 ID")
    private UserEntity user;

    @Column(name = "COMMENTS_CONTENT", length = 500)
    @Comment("댓글 내용")
    private String commentsContent;

    @Column(name = "comments_depth", length = 1)
    @Comment("뎁스")
    private int commentsDepth;

    @Column(name = "REG_DATE")
    @Comment("등록 일자")
    private LocalDateTime regDate;

    @Column(name = "REG_IP", length = 15)
    @Comment("댓글 등록 IP")
    private String regIp;

    @Column(name = "GOOD_CNT", length = 10)
    private int goodCnt;

    @Column(name = "BAD_CNT", length = 10)
    private int badCnt;

    @Column(name = "DEL_YN", length = 1)
    private String delYn;
}
