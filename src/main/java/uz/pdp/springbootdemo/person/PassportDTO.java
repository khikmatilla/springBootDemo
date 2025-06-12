package uz.pdp.springbootdemo.person;

import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PassportDTO {
    private String serial;
    private String number;
}
