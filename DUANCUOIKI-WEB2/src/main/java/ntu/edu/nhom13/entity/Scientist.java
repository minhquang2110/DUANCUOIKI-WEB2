package ntu.edu.nhom13.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "scientists")
public class Scientist {

    @Id
    @Column(name = "id")
    private Integer id;  

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id", referencedColumnName = "account_id") 
    private Account account;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birth_year")
    private Integer birthYear;

    @Column(name = "image")
    private String image;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "degree_id")
    private Degree degree;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rank_id")
    private Rank rank;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "title_id")
    private Title title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "field_id")
    private ResearchField researchField;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "language_level_id")
    private LanguageLevel languageLevel;

    @Column(name = "major")
    private String major;

    @Column(name = "sub_major")
    private String subMajor;

    @Column(name = "teaching_specialty")
    private String teachingSpecialty;
    
    @OneToMany(mappedBy = "scientist", fetch = FetchType.LAZY)
    private List<BookAuthor> bookAuthors;

    @OneToMany(mappedBy = "scientist", fetch = FetchType.LAZY)
    private List<ArticleAuthor> articleAuthors;

    @OneToMany(mappedBy = "scientist", fetch = FetchType.LAZY)
    private List<ProjectParticipant> projectParticipants;

    @OneToMany(mappedBy = "scientist", fetch = FetchType.EAGER)
    private List<WorkHistory> workHistories;

    @OneToMany(mappedBy = "scientist", fetch = FetchType.EAGER)
    private List<EducationHistory> educationHistories;
    
    // Getters & Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public Integer getBirthYear() {
        return birthYear;
    }
    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Degree getDegree() {
        return degree;
    }
    public void setDegree(Degree degree) {
        this.degree = degree;
    }
    public Rank getRank() {
        return rank;
    }
    public void setRank(Rank rank) {
        this.rank = rank;
    }
    public Title getTitle() {
        return title;
    }
    public void setTitle(Title title) {
        this.title = title;
    }
    public ResearchField getResearchField() {
        return researchField;
    }
    public void setResearchField(ResearchField researchField) {
        this.researchField = researchField;
    }
    public Organization getOrganization() {
        return organization;
    }
    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
    public LanguageLevel getLanguageLevel() {
        return languageLevel;
    }
    public void setLanguageLevel(LanguageLevel languageLevel) {
        this.languageLevel = languageLevel;
    }
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    public String getSubMajor() {
        return subMajor;
    }
    public void setSubMajor(String subMajor) {
        this.subMajor = subMajor;
    }
    public String getTeachingSpecialty() {
        return teachingSpecialty;
    }
    public void setTeachingSpecialty(String teachingSpecialty) {
        this.teachingSpecialty = teachingSpecialty;
    }
    
    /**
   	 * @return the bookAuthors
   	 */
   	public List<BookAuthor> getBookAuthors() {
   		return bookAuthors;
   	}
   	/**
   	 * @param bookAuthors the bookAuthors to set
   	 */
   	public void setBookAuthors(List<BookAuthor> bookAuthors) {
   		this.bookAuthors = bookAuthors;
   	}
   	/**
   	 * @return the articleAuthors
   	 */
   	public List<ArticleAuthor> getArticleAuthors() {
   		return articleAuthors;
   	}
   	/**
   	 * @param articleAuthors the articleAuthors to set
   	 */
   	public void setArticleAuthors(List<ArticleAuthor> articleAuthors) {
   		this.articleAuthors = articleAuthors;
   	}
   	/**
   	 * @return the projectParticipants
   	 */
   	public List<ProjectParticipant> getProjectParticipants() {
   		return projectParticipants;
   	}
   	/**
   	 * @param projectParticipants the projectParticipants to set
   	 */
   	public void setProjectParticipants(List<ProjectParticipant> projectParticipants) {
   		this.projectParticipants = projectParticipants;
   	}
   	/**
   	 * @return the workHistories
   	 */
   	public List<WorkHistory> getWorkHistories() {
   		return workHistories;
   	}
   	/**
   	 * @param workHistories the workHistories to set
   	 */
   	public void setWorkHistories(List<WorkHistory> workHistories) {
   		this.workHistories = workHistories;
   	}
   	/**
   	 * @return the educationHistories
   	 */
   	public List<EducationHistory> getEducationHistories() {
   		return educationHistories;
   	}
   	/**
   	 * @param educationHistories the educationHistories to set
   	 */
   	public void setEducationHistories(List<EducationHistory> educationHistories) {
   		this.educationHistories = educationHistories;
   	}
}

