package uz.pdp.springbootdemo.uploadDownload.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.springbootdemo.uploadDownload.entitys.Item;
import uz.pdp.springbootdemo.uploadDownload.entitys.Upload;
import uz.pdp.springbootdemo.uploadDownload.repository.Repository;
import uz.pdp.springbootdemo.uploadDownload.service.FileService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private Repository.ItemRepository itemRepository;

    @Autowired
    private FileService fileService;

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestParam("name") String name,
                                           @RequestParam("description") String description,
                                           @RequestParam("price") Double price,
                                           @RequestParam("file") MultipartFile file) throws IOException {
        Upload upload = fileService.uploadFile(file);

        Item item = new Item();
        item.setName(name);
        item.setDescription(description);
        item.setPrice(price);
        item.setPath(upload.getUploadedPath());

        return ResponseEntity.ok(itemRepository.save(item));
    }

    @GetMapping
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable Long id) {
        return itemRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id,
                                           @RequestBody Item newItem) {
        return itemRepository.findById(id).map(item -> {
            item.setName(newItem.getName());
            item.setDescription(newItem.getDescription());
            item.setPrice(newItem.getPrice());
            return ResponseEntity.ok(itemRepository.save(item));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        itemRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
