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
public class Scientist {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private Integer birthYear;

    private String image;
    private String address;
    private String phoneNumber;

    @Column(nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "degreeID")
    private Degree degree;

    @ManyToOne
    @JoinColumn(name = "rankID")
    private Rank rank;

    @ManyToOne
    @JoinColumn(name = "titleID")
    private Title title;

    @ManyToOne
    @JoinColumn(name = "fieldID")
    private ResearchField researchField;

    @ManyToOne
    @JoinColumn(name = "organizationID")
    private Organization organization;

    @ManyToOne
    @JoinColumn(name = "languageLevelID")
    private LanguageLevel languageLevel;

    private String major;
    private String subMajor;
    private String teachingSpecialty;

    // Getters, Setters, Constructors
}
