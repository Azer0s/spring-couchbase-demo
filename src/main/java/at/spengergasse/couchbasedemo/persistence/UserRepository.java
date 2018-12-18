package at.spengergasse.couchbasedemo.persistence;

import at.spengergasse.couchbasedemo.domain.Item;
import at.spengergasse.couchbasedemo.domain.User;
import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, String> {
    User findByUsername(String username);

    @Query("SELECT item FROM `users` AS users UNNEST users.items AS item WHERE users.username=$1 AND item.id=$1;")
    List<Item> findItemByUsernameAndId(String username, Long id);
}
