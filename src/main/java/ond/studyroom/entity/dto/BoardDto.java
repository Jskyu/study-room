package ond.studyroom.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ond.studyroom.entity.BoardEntity;
import ond.studyroom.entity.CategoryEntity;
import ond.studyroom.entity.UserEntity;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {

    private Long id;
    private String userId;
    private Long categoryId;
    private String title;
    private String content;

    public static BoardDto EntityToDto(BoardEntity entity) {
        return BoardDto.builder()
                .id(entity.getBoardId())
                .userId(entity.getUser().getUserId())
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

    public BoardEntity toEntity(BoardDto dto, UserEntity user, CategoryEntity category) {
        return BoardEntity.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .user(user)
                .category(category)
                .build();
    }
}