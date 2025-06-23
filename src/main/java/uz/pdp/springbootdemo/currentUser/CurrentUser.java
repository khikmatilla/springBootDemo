package uz.pdp.springbootdemo.currentUser;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CurrentUser {
    private UUID id;
    private String firstName;
    private String lastName;
    private String middleName;
    private UserType userType;
}
