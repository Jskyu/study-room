package ond.studyroom.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class Result<T> {
    private T data;
    private HttpStatus status;
}
