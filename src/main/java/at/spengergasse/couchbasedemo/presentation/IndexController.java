package at.spengergasse.couchbasedemo.presentation;

import at.spengergasse.couchbasedemo.domain.Item;
import at.spengergasse.couchbasedemo.domain.User;
import at.spengergasse.couchbasedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/user/{name}")
    public HttpEntity createUser(@PathVariable("name") String username){
        return userService.createUser(username) ? new ResponseEntity(HttpStatus.CREATED) : new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/user/{name}/{item}")
    public @ResponseBody Item getUserItem(@PathVariable("name") String name, @PathVariable("item") Long item){
        return userService.getItemFromUser(name,item);
    }

    @PostMapping("/user/{name}/{item}")
    public @ResponseBody void createUserItem(@PathVariable("name") String name, @PathVariable("item") Long item, @RequestParam("itemName") String itemName, @RequestParam("itemDescription") String itemDescription) throws Exception {
        userService.createItemForUser(name,item,itemName,itemDescription);
    }
}
