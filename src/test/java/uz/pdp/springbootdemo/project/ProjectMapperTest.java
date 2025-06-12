package uz.pdp.springbootdemo.project;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;
import static uz.pdp.springbootdemo.project.ProjectMapper.PROJECT_MAPPER;

class ProjectMapperTest {

    @Test
    void toDTO() {
        Project project = new Project("1", "New Java Spring", Path.of("https//newspring.uz/mapstruct"));
        ProjectDTO dto = PROJECT_MAPPER.toDTO(project);
        System.out.println("dto = " + dto);
    }
}