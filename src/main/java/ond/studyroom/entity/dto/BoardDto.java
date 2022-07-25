package ond.studyroom.entity.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.*;
import ond.studyroom.entity.BoardEntity;
import ond.studyroom.entity.CategoryEntity;
import ond.studyroom.entity.UserEntity;
import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor @ToString
public class BoardDto {

    private Long id;
    private String userId;
    private String userNick;
    private Long categoryId;
    private String title;
    private String content;
    private String regDate;

    public static BoardDto EntityToDto(BoardEntity entity) {
        return BoardDto.builder()
                .id(entity.getBoardId())
                .userId(entity.getUser().getUserNick())
                .categoryId(entity.getCategory().getCtgrId())
                .title(entity.getTitle())
                .content(entity.getContent()).build();
    }

    public BoardDto(String userId, Long categoryId, String title, String content) {
        this.userId = userId;
        this.categoryId = categoryId;
        this.title = title;
        this.content = content;
    }

    @QueryProjection
    public BoardDto(Long id, String userNick, Long categoryId, String title, LocalDateTime regDate) {
        this.id = id;
        this.userNick = userNick;
        this.categoryId = categoryId;
        this.title = title;
        this.regDate = regDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public BoardEntity toEntity(BoardDto dto, UserEntity user, CategoryEntity category) {
        return BoardEntity.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .user(user)
                .category(category)
                .build();
    }
}