package uz.pdp.springbootdemo.post;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@NamedQuery(
        name = "getAllPostsByUserId",
        query = "select p from Post p where p.userId = ?1")
@NamedNativeQuery(
        name = "Post.getAllPostsByUserId.Native",
        query = "select p.* from post p where p.user_id = ?1",
        resultClass = Post.class)
public class Post {
    @Id
    private Integer id;

    @Column(nullable = false)
    private Integer userId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String body;

}
