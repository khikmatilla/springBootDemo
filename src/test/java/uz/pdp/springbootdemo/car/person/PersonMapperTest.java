package uz.pdp.springbootdemo.car.person;

import org.junit.jupiter.api.Test;
import uz.pdp.springbootdemo.person.AddressDTO;
import uz.pdp.springbootdemo.person.PassportDTO;
import uz.pdp.springbootdemo.person.Person;
import uz.pdp.springbootdemo.person.PersonDTO;

import static uz.pdp.springbootdemo.person.PersonMapper.PERSON_MAPPER;

class PersonMapperTest {

    @Test
    void toEntity() {
        PersonDTO personDTO = new PersonDTO("Hikmatilla Habibullayev", 25);
        AddressDTO addressDTO = new AddressDTO("Tashkent", "Guliston");
        PassportDTO passportDTO = new PassportDTO("AB", "5006281");

        Person person = PERSON_MAPPER.toEntity(personDTO, addressDTO, passportDTO);
        System.out.println("person = " + person);

    }
}