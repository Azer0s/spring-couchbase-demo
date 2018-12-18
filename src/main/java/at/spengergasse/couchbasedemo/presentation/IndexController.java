package at.spengergasse.couchbasedemo.presentation;

import at.spengergasse.couchbasedemo.domain.Item;
import at.spengergasse.couchbasedemo.domain.User;
import at.spengergasse.couchbasedemo.service.ItemService;
import at.spengergasse.couchbasedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public @ResponseBody Item getUserItem(@PathVariable("name") String name, @PathVariable("item") Long item){
        return userService.getItemFromUser(name,item);
    }

    @PutMapping("/user/{name}/{item}")
    public @ResponseBody void createUserItem(@PathVariable("name") String name, @PathVariable("item") Long item, @RequestParam("itemName") String itemName, @RequestParam("itemDescription") String itemDescription) throws Exception {
        userService.createItemForUser(name,item,itemName,itemDescription);
    }
}
