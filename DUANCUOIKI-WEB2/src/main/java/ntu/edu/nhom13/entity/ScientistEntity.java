package ntu.edu.nhom13.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Scientists")
public class ScientistEntity {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private AccountEntity accountEntity;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String gender;

    @Column(name = "birth_year", nullable = false)
    private Integer birthYear;

    private String image;
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "degree_id")
    private DegreeEntity degreeEntity;

    @ManyToOne
    @JoinColumn(name = "rank_id")
    private RankEntity rankEntity;

    @ManyToOne
    @JoinColumn(name = "title_id")
    private TitleEntity titleEntity;

    @ManyToOne
    @JoinColumn(name = "field_id")
    private ResearchFieldEntity researchFieldEntity;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private OrganizationEntity organizationEntity;

    @ManyToOne
    @JoinColumn(name = "language_level_id")
    private LanguageLevelEntity languageLevelEntity;

    private String major;

    @Column(name = "sub_major")
    private String subMajor;

    @Column(name = "teaching_specialty")
    private String teachingSpecialty;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AccountEntity getAccountEntity() {
        return accountEntity;
    }

    public void setAccountEntity(AccountEntity accountEntity) {
        this.accountEntity = accountEntity;
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

    public DegreeEntity getDegreeEntity() {
        return degreeEntity;
    }

    public void setDegreeEntity(DegreeEntity degreeEntity) {
        this.degreeEntity = degreeEntity;
    }

    public RankEntity getRankEntity() {
        return rankEntity;
    }

    public void setRankEntity(RankEntity rankEntity) {
        this.rankEntity = rankEntity;
    }

    public TitleEntity getTitleEntity() {
        return titleEntity;
    }

    public void setTitleEntity(TitleEntity titleEntity) {
        this.titleEntity = titleEntity;
    }

    public ResearchFieldEntity getResearchFieldEntity() {
        return researchFieldEntity;
    }

    public void setResearchFieldEntity(ResearchFieldEntity researchFieldEntity) {
        this.researchFieldEntity = researchFieldEntity;
    }

    public OrganizationEntity getOrganizationEntity() {
        return organizationEntity;
    }

    public void setOrganizationEntity(OrganizationEntity organizationEntity) {
        this.organizationEntity = organizationEntity;
    }

    public LanguageLevelEntity getLanguageLevelEntity() {
        return languageLevelEntity;
    }

    public void setLanguageLevelEntity(LanguageLevelEntity languageLevelEntity) {
        this.languageLevelEntity = languageLevelEntity;
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

}
