package uz.pdp.springbootdemo.auditing;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<TODO, Integer> {
}
