package uz.pdp.springbootdemo.auditing;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class ToDoController {

    private final ToDoRepository toDoRepository;

    public ToDoController(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @PostMapping("/save")
    public ResponseEntity<TODO> save(@RequestBody TODO todo){
        toDoRepository.save(todo);
        return ResponseEntity.ok(todo);
    }

    @GetMapping("/alltodo")
    public List<TODO> findAll(){
        return toDoRepository.findAll();
    }

    @PutMapping("/updatetodo")
    public TODO updateById(@RequestBody TODO todo){
        return toDoRepository.save(todo);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        toDoRepository.deleteById(id);
       return ResponseEntity.noContent().build();
    }
}
