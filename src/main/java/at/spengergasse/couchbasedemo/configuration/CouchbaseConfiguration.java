package at.spengergasse.couchbasedemo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableCouchbaseRepositories
public class CouchbaseConfiguration extends AbstractCouchbaseConfiguration {
    @Override
    protected List<String> getBootstrapHosts() {
        return Arrays.asList("db.simulevski.at");
    }

    @Override
    protected String getBucketName() {
        return "users";
    }

    @Override
    protected String getUsername(){
        return "guest";
    }

    @Override
    protected String getBucketPassword() {
        return "bardh&benny";
    }
}
