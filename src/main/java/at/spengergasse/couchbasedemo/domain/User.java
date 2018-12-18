package at.spengergasse.couchbasedemo.domain;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import lombok.*;
import org.springframework.data.couchbase.core.mapping.Document;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter

@Document
@Data
public class User {
    @Id
    private String id;

    @NotNull
    @Field
    private String username;

    @Field
    private List<Item> items = new ArrayList<>();
}
