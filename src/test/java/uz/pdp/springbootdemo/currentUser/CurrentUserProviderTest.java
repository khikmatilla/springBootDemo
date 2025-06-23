package uz.pdp.springbootdemo.currentUser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrentUserProviderTest {

    @Test
    void getCurrentUser() {
        CurrentUser currentUser = CurrentUserProvider.getSystemUser();
        System.out.println(currentUser);
    }

}