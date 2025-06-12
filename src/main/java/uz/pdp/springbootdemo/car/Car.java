package uz.pdp.springbootdemo.car;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private String id;
    private String name;
    private String maker;
    private double price;
}
