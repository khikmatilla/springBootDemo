package uz.pdp.springbootdemo.currentUser;

import java.util.UUID;

public class CurrentUserProvider {
    public static CurrentUser getSystemUser() {
        return new CurrentUser(
            UUID.randomUUID(),
            "system",
            "system",
            "system",
            UserType.INTERNAL
        );
    }
}
