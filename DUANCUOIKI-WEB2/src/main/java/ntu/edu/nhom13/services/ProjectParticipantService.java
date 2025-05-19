package ntu.edu.nhom13.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ntu.edu.nhom13.entity.Project;
import ntu.edu.nhom13.entity.ProjectParticipant;
import ntu.edu.nhom13.repositories.ProjectParticipantRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectParticipantService {

    @Autowired
    private ProjectParticipantRepository projectParticipantRepository;

    public List<ProjectParticipant> getAllProjectParticipants() {
        return projectParticipantRepository.findAll();
    }

    public Optional<ProjectParticipant> getProjectParticipantById(Integer id) {
        return projectParticipantRepository.findById(id);
    }

    public ProjectParticipant saveProjectParticipant(ProjectParticipant projectParticipant) {
        return projectParticipantRepository.save(projectParticipant);
    }

    public void deleteProjectParticipant(Integer id) {
        projectParticipantRepository.deleteById(id);
    }
    
    public List<Project> findByScientistId(Integer id) {
   	 return projectParticipantRepository.findProjectsByScientistId(id);
   }
}
