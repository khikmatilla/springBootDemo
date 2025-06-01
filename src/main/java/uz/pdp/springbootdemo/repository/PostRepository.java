package uz.pdp.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootdemo.post.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
}