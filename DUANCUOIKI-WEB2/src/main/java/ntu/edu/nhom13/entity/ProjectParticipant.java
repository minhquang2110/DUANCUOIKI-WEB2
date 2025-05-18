package ntu.edu.nhom13.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "project_participants")
public class ProjectParticipant {

    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scientist_id")
    private Scientist scientist;

    @Column(name = "is_leader")
    private Boolean isLeader = false;

    // Getters & Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Project getProject() {
        return project;
    }
    public void setProject(Project project) {
        this.project = project;
    }
    public Scientist getScientist() {
        return scientist;
    }
    public void setScientist(Scientist scientist) {
        this.scientist = scientist;
    }
    public Boolean getIsLeader() {
        return isLeader;
    }
    public void setIsLeader(Boolean isLeader) {
        this.isLeader = isLeader;
    }
}
