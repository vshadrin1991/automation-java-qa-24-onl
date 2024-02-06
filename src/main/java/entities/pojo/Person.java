package entities.pojo;

import lombok.Getter;

import java.util.List;

@Getter
public class Person {
    private String name;
    private Integer age;
    private Boolean available;
    private List<Family> family;
    private Work work;
}
