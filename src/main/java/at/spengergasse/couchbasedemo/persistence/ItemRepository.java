package at.spengergasse.couchbasedemo.persistence;

import at.spengergasse.couchbasedemo.domain.Item;
import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//Not currently working
public interface ItemRepository extends CrudRepository<Item, Long> {
    @Query("SELECT item FROM `users` AS users UNNEST users.items AS item WHERE users.username=$1 AND item.id=$1;")
    List<Item> findItemByUsernameAndId(String username, Long id);
}
