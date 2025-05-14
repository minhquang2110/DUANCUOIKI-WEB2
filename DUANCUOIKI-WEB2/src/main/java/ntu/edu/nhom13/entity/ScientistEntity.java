package ntu.edu.nhom13.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Scientists")
public class ScientistEntity {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "accountId")
    private AccountEntity accountEntity;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private Long birthYear;

    private String image;
    private String address;
    private String phoneNumber;

    @Column(nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "degreeID")
    private DegreeEntity degreeEntity;

    @ManyToOne
    @JoinColumn(name = "rankID")
    private RankEntity rankEntity;

    @ManyToOne
    @JoinColumn(name = "titleID")
    private TitleEntity titleEntity;

    @ManyToOne
    @JoinColumn(name = "fieldID")
    private ResearchFieldEntity researchFieldEntity;

    @ManyToOne
    @JoinColumn(name = "organizationID")
    private OrganizationEntity organizationEntity;

    @ManyToOne
    @JoinColumn(name = "languageLevelID")
    private LanguageLevelEntity languageLevelEntity;

    private String major;
    private String subMajor;
    private String teachingSpecialty;

    // Getters, Setters, Constructors
}
