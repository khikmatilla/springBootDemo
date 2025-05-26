package uz.pdp.springbootdemo.post;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    //@Query(value = "from Post p where p.userId = ?1")
    @Query(nativeQuery = true, name = "Post.getAllPostsByUserId.Native")
    List<Post> findAllPostsById(Integer userId);

    @Query(value = "select p from Post p")
    List<Post> getAllPostsWithSortedColumn(Sort sort);

    //@Query(value = "select p from Post p")
    @Query(
            nativeQuery = true,
            value = "select p.* from post p",
            countQuery = "select count(1) from post p"
    )
    Page<Post> getAllPostWithQuery(Pageable pageable);

    @Query(value = "from Post p where p.userId in (?1)")
    List<Post> getAllPostsByUserIds(Collection<Integer> usersIds);

    @Transactional
    @Modifying
    @Query(value = "delete Post p where p.userId = ?1")
    void deleteByIdCustom(Integer userId);
}
