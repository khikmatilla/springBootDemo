package uz.pdp.springbootdemo.project;

import lombok.*;
import uz.pdp.springbootdemo.projectColumn.ProjectColumnDTO;

import java.nio.file.Path;
import java.util.List;

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
    private List<ProjectColumnDTO> projectColumns;
    private String createdAt;
}
