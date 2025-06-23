package uz.pdp.springbootdemo.projectColumn;

import lombok.*;


import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProjectColumnDTO {
    private String pc_name;
    private String pc_order;
    private String pc_createdAt;
}
