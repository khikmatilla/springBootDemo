package uz.pdp.springbootdemo.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootdemo.exeptions.ItemNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class TodoController {

    AtomicInteger counter = new AtomicInteger(1);
    List<ToDo> toDos = new ArrayList<>() {{
        add(new ToDo(counter.getAndIncrement(), "Spring Boot", "High"));
        add(new ToDo(counter.getAndIncrement(), "Spring framework", "Medium"));
    }};

    @GetMapping(value = "/todos", consumes = "application/json", produces = {"application/xml", "application/json"})
    public ResponseEntity<List<ToDo>> getAll() {
        return ResponseEntity.ok(toDos);
    }

    @GetMapping(value = "/todos/{id}")
    public ResponseEntity<ToDo> getById(@PathVariable Integer id) throws ItemNotFoundException {
        return ResponseEntity.ok(toDos.stream().filter(t -> t.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ItemNotFoundException("Todo Not Found"))
        );
    }

    @PostMapping("/todos")
    public ResponseEntity<ToDo> create(@Valid @RequestBody ToDo toDo){
        toDo.setId(counter.getAndIncrement());
        toDos.add(toDo);
        return ResponseEntity.status(HttpStatus.CREATED).body(toDo);
    }

}
