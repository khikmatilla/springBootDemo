package uz.pdp.springbootdemo.project;

import org.junit.jupiter.api.Test;
import uz.pdp.springbootdemo.projectColumn.ProjectColumn;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.*;
import static uz.pdp.springbootdemo.project.ProjectMapper.PROJECT_MAPPER;

class ProjectMapperTest {

    @Test
    void toDTO() {
        Project project = new Project("1", "New Java Spring", Path.of("https//newspring.uz/mapstruct"),null,null);
        ProjectDTO dto = PROJECT_MAPPER.toDTO(project);
        System.out.println("dto = " + dto);
    }

    @Test
    void toDtoWithProjectColumn() {

        List<ProjectColumn> projectColumns = List.of(
                new ProjectColumn("1", "TODO", 1, LocalDateTime.now()),
                new ProjectColumn("2", "Doing", 2, LocalDateTime.now()),
                new ProjectColumn("3", "Done", 3, LocalDateTime.now()),
                new ProjectColumn("4", "Teach", 4, LocalDateTime.now())
        );
        Project project = new Project(
                "1", "Java Spring",
                Path.of("https//newspring.uz/mapstruct"),
                projectColumns,
                LocalDateTime.now());
        ProjectDTO dto = PROJECT_MAPPER.toDTO(project);
        System.out.println("dto = " + dto);
    }
}