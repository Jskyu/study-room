package ond.studyroom.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "home")
@Getter @Setter
@NoArgsConstructor
@ToString
public class HomeEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "str")
    private String str;
}
