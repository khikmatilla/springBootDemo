package uz.pdp.springbootdemo.person;

import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AddressDTO {
    private String city;
    private String apartment;
}
