package ond.studyroom.entity;

import lombok.*;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity(name = "TN_BOARD_FILE")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class BoardFileEntity {

    @Id
    @GeneratedValue
    @Column(name = "FILE_ID")
    @Comment("파일 ID")
    private Long fileId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "BOARD_ID")
    private BoardEntity board;

    @Column(name = "ORG_FILENAME", length = 300)
    @Comment("파일 원본명")
    private String orgFilename;

    @Column(name = "CNG_FILENAME", length = 300)
    @Comment("파일 변경명")
    private String cngFilename;

    @Column(name = "FILE_SIZE", length = 19)
    @Comment("파일 용량 크기")
    private int fileSize;

    @Column(name = "FILE_PATH", length = 600)
    @Comment("파일 저장 경로")
    private String filePath;

    @Column(name = "FILE_EXT", length = 10)
    @Comment("파일 확장자")
    private String fileExt;
}