package lecture_14.entity;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private String model;
    private String type;
    private Integer year;
    private Double engine;
}
