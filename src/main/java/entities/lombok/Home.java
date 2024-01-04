package entities.lombok;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "with", buildMethodName = "done", builderMethodName = "create")
public class Home {
    private String address;
    private String color;
    private Integer age;
}

