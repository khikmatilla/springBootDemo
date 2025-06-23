package uz.pdp.springbootdemo.currentUser;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SomeService {

    private final CurrentUserProperties currentUserProperties;

    public void doSomething() {
        CurrentUser currentUser = currentUserProperties.getCurrentUser();
        System.out.println(currentUser.getFirstName());
    }
}


