package uz.pdp.springbootdemo.controller;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootdemo.post.Post;
import uz.pdp.springbootdemo.repository.PostRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/{id}")
    public EntityModel<Post> getPosts(@PathVariable Integer id) {
        Post post =  postRepository.findById(id).orElseThrow(()-> new RuntimeException("Post not found"));
        Link link = Link.of("http://localhost:8080/api/posts/" + post.getId());
        return EntityModel.of(post,link);
    }
}
