package uz.pdp.springbootdemo.projectColumn;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProjectColumn {
    private String id;
    private String name;
    private Integer order;
    private LocalDateTime createdAt;
}
