package ond.studyroom.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity(name = "TN_BOARD")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
public class BoardEntity {

    @Id
    @GeneratedValue
    @Column(name = "BOARD_ID")
    @Comment("보드 ID")
    private Long boardId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "USER_INDEX")
    private UserEntity user;

    @ManyToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "CTGR_ID")
    private CategoryEntity category;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private final List<BoardFileEntity> fileList = new ArrayList<>();

    @Column(name = "TITLE", length = 100)
    @Comment("보드 제목")
    private String title;

    @Column(name = "CONTENT", length = 1000)
    @Comment("보드 내용")
    private String content;

    @Column(name = "REG_IP", length = 15)
    @Comment("보드 작성자 IP")
    private String regIp;

    @Column(name = "GOOD_CNT", length = 10)
    @Comment("좋아요 수")
    private int goodCnt;

    @Column(name = "BAD_COT", length = 10)
    @Comment("싫어요 수")
    private int badCnt;

    @Column(name = "REG_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Comment("등록일자")
    private LocalDateTime regDate;

    @Column(name = "MOD_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Comment("수정일자")
    private LocalDateTime modDate;

    @Column(name = "DEL_YN", length = 1)
    @ColumnDefault("'N'")
    @Comment("삭제여부YN")
    private String delYn;
}
