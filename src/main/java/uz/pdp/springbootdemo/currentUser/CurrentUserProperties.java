package uz.pdp.springbootdemo.currentUser;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@ConfigurationProperties(prefix = "example.current-user")
@Data
public class CurrentUserProperties {
    private UUID id;
    private String firstName;
    private String lastName;
    private String middleName;
    private UserType userType;

    public CurrentUser getCurrentUser() {
        return new CurrentUser(id, firstName, lastName, middleName, userType);
    }
}

