package uz.pdp.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import uz.pdp.springbootdemo.post.Post;

@RepositoryRestResource(path = "maqolalar", collectionResourceRel = "maqolalar")
public interface PostRepository extends JpaRepository<Post, Integer> {
}