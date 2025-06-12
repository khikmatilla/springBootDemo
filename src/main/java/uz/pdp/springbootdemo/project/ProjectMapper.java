package uz.pdp.springbootdemo.project;

import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.nio.file.Path;

@Mapper
public interface ProjectMapper {
    ProjectMapper PROJECT_MAPPER = Mappers.getMapper(ProjectMapper.class);

    @Mapping(target = "documentPath", source = "documentPath", qualifiedByName = "pathToString")
    ProjectDTO toDTO(Project project);

    @Named("pathToString")
    default String pathToString(Path path) {
        if (path == null) {
            return null;
        }
        return path.toString();
    }
}
