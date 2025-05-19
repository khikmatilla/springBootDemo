package uz.pdp.springbootdemo.objectMapper;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Datasource {
    private String username;
    private String password;
    private String url;
    private String database;
}
