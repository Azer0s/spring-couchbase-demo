package at.spengergasse.couchbasedemo.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter

@Data
public class Item {
    private Long id;
    private String name;
    private String description;
}
