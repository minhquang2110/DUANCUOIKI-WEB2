package ntu.edu.nhom13.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "project_code")
    private String projectCode;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_level")
    private String projectLevel;

    @Column(name = "host_organization")
    private String hostOrganization;

    @Column(name = "implementing_org")
    private String implementingOrg;

    @Column(name = "project_type")
    private String projectType;

    @Column(name = "research_fields")
    private String researchFields;

    @Column(name = "objective")
    private String objective;

    @Column(name = "content")
    private String content;

    @Column(name = "result")
    private String result;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "evaluation")
    private String evaluation;

    @Column(name = "status")
    private String status;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "application_address")
    private String applicationAddress;

    @Column(name = "budget")
    private Double budget;

    @Column(name = "attachment", columnDefinition = "TEXT")
    private String attachment;

    // Quan hệ 1-n với bảng trung gian project_participants
    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private List<ProjectParticipant> projectParticipants;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "project_participants",
        joinColumns = @JoinColumn(name = "project_id"),
        inverseJoinColumns = @JoinColumn(name = "scientist_id")
    )
    private List<Scientist> participants;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the projectCode
	 */
	public String getProjectCode() {
		return projectCode;
	}

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @return the projectLevel
	 */
	public String getProjectLevel() {
		return projectLevel;
	}

	/**
	 * @return the hostOrganization
	 */
	public String getHostOrganization() {
		return hostOrganization;
	}

	/**
	 * @return the implementingOrg
	 */
	public String getImplementingOrg() {
		return implementingOrg;
	}

	/**
	 * @return the projectType
	 */
	public String getProjectType() {
		return projectType;
	}

	/**
	 * @return the researchFields
	 */
	public String getResearchFields() {
		return researchFields;
	}

	/**
	 * @return the objective
	 */
	public String getObjective() {
		return objective;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @return the startDate
	 */
	public LocalDate getStartDate() {
		return startDate;
	}

	/**
	 * @return the endDate
	 */
	public LocalDate getEndDate() {
		return endDate;
	}

	/**
	 * @return the evaluation
	 */
	public String getEvaluation() {
		return evaluation;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @return the productType
	 */
	public String getProductType() {
		return productType;
	}

	/**
	 * @return the applicationAddress
	 */
	public String getApplicationAddress() {
		return applicationAddress;
	}

	/**
	 * @return the budget
	 */
	public Double getBudget() {
		return budget;
	}

	/**
	 * @return the attachment
	 */
	public String getAttachment() {
		return attachment;
	}

	/**
	 * @return the projectParticipants
	 */
	public List<ProjectParticipant> getProjectParticipants() {
		return projectParticipants;
	}

	/**
	 * @return the participants
	 */
	public List<Scientist> getParticipants() {
		return participants;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param projectCode the projectCode to set
	 */
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @param projectLevel the projectLevel to set
	 */
	public void setProjectLevel(String projectLevel) {
		this.projectLevel = projectLevel;
	}

	/**
	 * @param hostOrganization the hostOrganization to set
	 */
	public void setHostOrganization(String hostOrganization) {
		this.hostOrganization = hostOrganization;
	}

	/**
	 * @param implementingOrg the implementingOrg to set
	 */
	public void setImplementingOrg(String implementingOrg) {
		this.implementingOrg = implementingOrg;
	}

	/**
	 * @param projectType the projectType to set
	 */
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	/**
	 * @param researchFields the researchFields to set
	 */
	public void setResearchFields(String researchFields) {
		this.researchFields = researchFields;
	}

	/**
	 * @param objective the objective to set
	 */
	public void setObjective(String objective) {
		this.objective = objective;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	/**
	 * @param evaluation the evaluation to set
	 */
	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @param productType the productType to set
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}

	/**
	 * @param applicationAddress the applicationAddress to set
	 */
	public void setApplicationAddress(String applicationAddress) {
		this.applicationAddress = applicationAddress;
	}

	/**
	 * @param budget the budget to set
	 */
	public void setBudget(Double budget) {
		this.budget = budget;
	}

	/**
	 * @param attachment the attachment to set
	 */
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	/**
	 * @param projectParticipants the projectParticipants to set
	 */
	public void setProjectParticipants(List<ProjectParticipant> projectParticipants) {
		this.projectParticipants = projectParticipants;
	}

	/**
	 * @param participants the participants to set
	 */
	public void setParticipants(List<Scientist> participants) {
		this.participants = participants;
	}
}
