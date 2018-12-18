package at.spengergasse.couchbasedemo.service;

import at.spengergasse.couchbasedemo.domain.Item;
import at.spengergasse.couchbasedemo.domain.User;
import at.spengergasse.couchbasedemo.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public void createUser(String username) {userRepository.save(User.builder().username(username).id(UUID.randomUUID().toString()).build());}

    public List<Item> getItemFromUser(String username, Long item){
        return userRepository.findItemByUsernameAndId(username,item);
    }
}
