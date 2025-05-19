package uz.pdp.springbootdemo.uploadDownload.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootdemo.uploadDownload.entitys.Store;
import uz.pdp.springbootdemo.uploadDownload.repository.Repository;

import java.util.List;

@RestController
@RequestMapping("/api/stores")
public class StoreController {

    @Autowired
    private Repository.StoreRepository storeRepository;

    @GetMapping
    public List<Store> getAll() {
        return storeRepository.findAll();
    }

    @PostMapping
    public Store create(@RequestBody Store store) {
        return storeRepository.save(store);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Store> update(@PathVariable Long id, @RequestBody Store store) {
        return storeRepository.findById(id).map(s -> {
            s.setName(store.getName());
            s.setDesc(store.getDesc());
            return ResponseEntity.ok(storeRepository.save(s));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        storeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
