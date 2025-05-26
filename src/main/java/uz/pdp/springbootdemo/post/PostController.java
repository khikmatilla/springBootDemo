package uz.pdp.springbootdemo.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostRepository postRepository;
    private final CustomPostRepository customPostRepository;

    public PostController(PostRepository postRepository, CustomPostRepository customPostRepository) {
        this.postRepository = postRepository;
        this.customPostRepository = customPostRepository;
    }

    @GetMapping
    public Page<Post> getPosts(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size
    ) {
        Sort sort = Sort.by(Sort.Order.desc("title"), Sort.Order.asc("id"));
        Pageable pageable = PageRequest.of(page, size, sort);
        return postRepository.findAll(pageable);
    }

    @GetMapping("/paged")
    public Page<Post> getAllPosts(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size
    ) {
        Sort sort = Sort.by(Sort.Order.desc("title"), Sort.Order.asc("user_id"));
        Pageable pageable = PageRequest.of(page, size, sort);
        return postRepository.getAllPostWithQuery(pageable);
    }

    @GetMapping("/byUsers/{usersIds}")
    public List<Post> getAllPosts(@PathVariable Collection<Integer> usersIds) {
        return postRepository.getAllPostsByUserIds(usersIds);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deletePost(@PathVariable Integer userId) {
        postRepository.deleteByIdCustom(userId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/save")
    public ResponseEntity<Post> savePost(@RequestBody Post post) {
        return ResponseEntity.ok(customPostRepository.savePost(post));
    }


//    @GetMapping("/{userId}")
//    public List<Post> getPostsByUserId(@PathVariable Integer userId) {
//        return postRepository
//                .findById(userId)
//                .stream()
//                .filter(post -> post.getUserId().equals(userId))
//                .toList();
//    }

    @GetMapping("/{userId}")
    public List<Post> getPostsByUserId(@PathVariable Integer userId) {
        return postRepository.findAllPostsById(userId);

    }

    @GetMapping("/sorted")
    public List<Post> getAllPostsWithSortedColumns() {
//        Sort sort = Sort.by(Sort.Direction.DESC, "id");
//        return postRepository.getAllPostsWithSortedColumn(sort);

//        Sort sort = Sort.by(Sort.Direction.DESC, "title")
//                .and(Sort.by(Sort.Direction.ASC, "id")
//                );

        Sort.Order title = Sort.Order.desc("title");
        Sort.Order id = Sort.Order.asc("id");
        Sort sort = Sort.by(title, id);
        return postRepository.findAll(sort);
    }

    @GetMapping("/query/{title}/{userId}")
    public Post getPostByTitleAndUserId(@PathVariable String title, @PathVariable Integer userId) {
        return postRepository.findByTitleIgnoreCaseAndUserId(title, userId);
    }

    @GetMapping("/query/{title}")
    public Optional<Post> getPostByTitle(@PathVariable String title) {
        return postRepository.findByTitle(title);
    }

    @GetMapping("/query-startWith/{title}")
    public List<Post> getAllPostByTitle(@PathVariable String title) {
        return postRepository.findAllByTitleStartingWith(title);
    }


    @GetMapping("/interface-projection/{userId}")
    public List<IPostDto> interfaceProjection(@PathVariable Integer userId) {
        return postRepository.findAllByUserIdLessThanEqual(userId);
    }

    @GetMapping("/class-projection/{userId}")
    public List<PostDTO> classProjection(@PathVariable Integer userId) {
        return postRepository.findAllByUserIdGreaterThanEqual(userId);
    }


    @GetMapping("/class-projectionWithNamedQuery")
    public List<PostDTO> classProjectionWithNamedQuery() {
        return postRepository.findAllByUserId();
    }


}

