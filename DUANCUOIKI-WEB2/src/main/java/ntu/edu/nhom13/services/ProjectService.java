package ntu.edu.nhom13.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ntu.edu.nhom13.entity.Project;
import ntu.edu.nhom13.repositories.ProjectRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> getProjectById(Integer id) {
        return projectRepository.findById(id);
    }

    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    public void deleteProject(Integer id) {
        projectRepository.deleteById(id);
    }

    // Phương thức tìm dự án theo nhà khoa học
    public List<Project> findByScientistId(Integer scientistId) {
        return projectRepository.findByScientistId(scientistId);
    }

    // Phương thức đếm số lượng dự án theo nhà khoa học
    public int countByScientistId(Integer scientistId) {
        return projectRepository.countByScientistId(scientistId);
    }

}
