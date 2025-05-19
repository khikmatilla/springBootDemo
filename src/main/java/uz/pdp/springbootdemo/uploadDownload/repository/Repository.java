package uz.pdp.springbootdemo.uploadDownload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootdemo.uploadDownload.entitys.Item;
import uz.pdp.springbootdemo.uploadDownload.entitys.Store;

public class Repository {
    public interface ItemRepository extends JpaRepository<Item, Long> {}
    public interface StoreRepository extends JpaRepository<Store, Long> {}

}
