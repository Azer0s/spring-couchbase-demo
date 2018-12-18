package at.spengergasse.couchbasedemo;

import at.spengergasse.couchbasedemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CouchbaseDemoApplication {

    //1. Create bucket
    //2. Create primary index (CREATE PRIMARY INDEX `usersIndex` ON `users`;) - Not gonna worry what indexer (GSI or View) we use

    public static void main(String[] args) {
        SpringApplication.run(CouchbaseDemoApplication.class, args);
    }
}

