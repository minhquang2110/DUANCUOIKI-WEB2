package ntu.edu.nhom13.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

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

    // Getters & Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getProjectCode() {
        return projectCode;
    }
    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }
    public String getProjectName() {
        return projectName;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public String getProjectLevel() {
        return projectLevel;
    }
    public void setProjectLevel(String projectLevel) {
        this.projectLevel = projectLevel;
    }
    public String getHostOrganization() {
        return hostOrganization;
    }
    public void setHostOrganization(String hostOrganization) {
        this.hostOrganization = hostOrganization;
    }
    public String getImplementingOrg() {
        return implementingOrg;
    }
    public void setImplementingOrg(String implementingOrg) {
        this.implementingOrg = implementingOrg;
    }
    public String getProjectType() {
        return projectType;
    }
    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }
    public String getResearchFields() {
        return researchFields;
    }
    public void setResearchFields(String researchFields) {
        this.researchFields = researchFields;
    }
    public String getObjective() {
        return objective;
    }
    public void setObjective(String objective) {
        this.objective = objective;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public String getEvaluation() {
        return evaluation;
    }
    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getProductType() {
        return productType;
    }
    public void setProductType(String productType) {
        this.productType = productType;
    }
    public String getApplicationAddress() {
        return applicationAddress;
    }
    public void setApplicationAddress(String applicationAddress) {
        this.applicationAddress = applicationAddress;
    }
    public Double getBudget() {
        return budget;
    }
    public void setBudget(Double budget) {
        this.budget = budget;
    }
    public String getAttachment() {
        return attachment;
    }
    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }
}
