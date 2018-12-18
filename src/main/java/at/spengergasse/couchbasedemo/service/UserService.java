package at.spengergasse.couchbasedemo.service;

import at.spengergasse.couchbasedemo.domain.Item;
import at.spengergasse.couchbasedemo.domain.User;
import at.spengergasse.couchbasedemo.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public void createUser(String username) {userRepository.save(User.builder().username(username).id(UUID.randomUUID().toString()).build());}

    public Item getItemFromUser(String username, Long item){
        var user = getUserByUsername(username);
        //HACK: Yes. This is a horrible hack. Until I use Couchbase in production, I'll figure this out.
        return user.getItems().stream().filter(x -> x.getId().equals(item)).findFirst().orElse(null);
    }

    public void createItemForUser(String name, Long item, String itemName, String itemDescription) throws Exception {
        var user = getUserByUsername(name);

        if (user == null){
            throw new Exception("Could not find user!");
        }

        var newItem = Item.builder().id(item).name(itemName).description(itemDescription).build();
        var items = user.getItems();
        items.add(newItem);
        user.setItems(items);
        userRepository.save(user);
    }
}
