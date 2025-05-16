package uz.pdp.springbootdemo.controller;

import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ToDo {

    private Integer id;

    @NotBlank
    private String title;

    @NotBlank
    @Size(min = 4, max = 20)
    private String priority;

}
