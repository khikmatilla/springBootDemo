package uz.pdp.springbootdemo.project;

import lombok.*;

import java.nio.file.Path;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ProjectDTO {
    private String id;
    private String name;
    private String documentPath;
    //private List<ProjectColumn> projectColumns;
}
