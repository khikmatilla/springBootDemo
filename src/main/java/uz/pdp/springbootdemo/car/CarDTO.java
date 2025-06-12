package uz.pdp.springbootdemo.car;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {
    private String carName;
    private double carPrice;
}
