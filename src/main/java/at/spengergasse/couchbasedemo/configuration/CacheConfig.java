package at.spengergasse.couchbasedemo.configuration;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.env.DefaultCouchbaseEnvironment;
import com.couchbase.client.spring.cache.CacheBuilder;
import com.couchbase.client.spring.cache.CouchbaseCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableCaching
@Configuration
public class CacheConfig {
    @Autowired
    private CouchbaseConfiguration couchbaseConfiguration;

    public static final String CACHE_NAME = "item";

    @Bean(destroyMethod = "disconnect")
    public Cluster cluster() {
        // connect to the couchbase-server running on your local machine
        /*return CouchbaseCluster.create(
                DefaultCouchbaseEnvironment.builder().build(),
                couchbaseConfiguration.getBootstrapHosts());*/
        return CouchbaseCluster.create(
                DefaultCouchbaseEnvironment.builder().build(),
                "db.simulevski.at");
    }

    @Bean(destroyMethod = "close")
    public Bucket bucket() {
        // connect to the bucket named 'default' (which must exist on your Couchbase server)
        // every cache related element will use this bucket
        return cluster().openBucket(couchbaseConfiguration.getBucketName(), couchbaseConfiguration.getBucketPassword());
    }

    @Bean
    public CacheManager cacheManager() {
        CacheBuilder cacheBuilder = CacheBuilder.newInstance(bucket()).withExpiration(0);
        return new CouchbaseCacheManager(cacheBuilder, CACHE_NAME);
    }
}
