package uz.pdp.springbootdemo.project;

import lombok.*;
import uz.pdp.springbootdemo.projectColumn.ProjectColumn;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Project {
    private String id;
    private String name;
    private Path documentPath;
    private List<ProjectColumn> projectColumns;
    private LocalDateTime createdAt;
}
