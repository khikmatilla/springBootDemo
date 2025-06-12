package uz.pdp.springbootdemo.person;

import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PersonDTO {
    private String name;
    private Integer age;
}
