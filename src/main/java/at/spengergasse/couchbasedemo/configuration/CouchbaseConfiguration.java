package at.spengergasse.couchbasedemo.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableCouchbaseRepositories
public class CouchbaseConfiguration extends AbstractCouchbaseConfiguration {

    @Value("${spring.couchbase.host:db.simulevski.at}")
    private String host;

    @Value("${spring.couchbase.bucketname:usersAndItems}")
    private String bucketname;

    @Value("${spring.couchbase.username:demo}")
    private String username;

    @Value("${spring.couchbase.password:demo123}")
    private String password;

    @Override
    protected List<String> getBootstrapHosts() {
        return Arrays.asList(host);
    }

    @Override
    protected String getBucketName() {
        return bucketname;
    }

    @Override
    protected String getUsername(){
        return username;
    }

    @Override
    protected String getBucketPassword() {
        return password;
    }
}
