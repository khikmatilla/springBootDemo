package uz.pdp.springbootdemo.car;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;
import static uz.pdp.springbootdemo.car.CarMapper.CAR_MAPPER;

class CarMapperTest {

    @Test
    void toDto() {
        Car car = new Car("123","Jentra","GM", 14000);

        CarDTO carDTO = CAR_MAPPER.toDto(car);
        System.out.println("carDTO = " + carDTO);

        Car car1 = CAR_MAPPER.toEntity(carDTO);
        System.out.println("car1 = " + car1);
    }
}