package at.spengergasse.couchbasedemo.presentation;

import at.spengergasse.couchbasedemo.domain.Item;
import at.spengergasse.couchbasedemo.domain.User;
import at.spengergasse.couchbasedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{name}")
    public @ResponseBody User getUser(@PathVariable("name") String name){
        return userService.getUserByUsername(name);
    }

    @PutMapping("/user/{name}")
    public @ResponseBody void createUser(@PathVariable("name") String username){
        userService.createUser(username);
    }

    @GetMapping("/user/{name}/{item}")
    private @ResponseBody List<Item> getUserItem(@PathVariable("name") String name, @PathVariable("item") Long item){
        return userService.getItemFromUser(name,item);
    }
}
