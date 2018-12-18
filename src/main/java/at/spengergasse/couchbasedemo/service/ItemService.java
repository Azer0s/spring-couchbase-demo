package at.spengergasse.couchbasedemo.service;

import at.spengergasse.couchbasedemo.domain.Item;
import at.spengergasse.couchbasedemo.persistence.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//Not currently working
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getItemFromUser(String username, Long item){
        return itemRepository.findItemByUsernameAndId(username,item);
    }
}
