package uz.pdp.springbootdemo.post;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostDTO {

    private Integer userId;
    private String title;
}
