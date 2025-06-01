package uz.pdp.springbootdemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.lang.NonNull;
import uz.pdp.springbootdemo.project.Project;

import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Integer>, JpaSpecificationExecutor<Project> {

  Optional<Project> findByNameIgnoreCase(@NonNull String name);
}