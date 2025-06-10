package uz.pdp.springbootdemo.todo;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springdoc.core.annotations.ParameterObject;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@ParameterObject
public class TodoCriteria {

    private String title;

    @Parameter(required = true)
    private boolean completed;

    private Type type;

    @Parameter(required = true, example = "2025-01-06")
    private LocalDate createdDate;

    @Min(value = 1)
    @Parameter(required = true)
    private Integer userId;
}
enum Type {
    BUSSiNESS, FOOTBALL, IT, SPORT
}

