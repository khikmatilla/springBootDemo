package uz.pdp.springbootdemo.person;

import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Person {

    private String fullName;
    private String age;

    private String personAddressCity;
    private String personAddressApartment;

    private String personPassportSerial;
    private String personPassportNumber;
}
