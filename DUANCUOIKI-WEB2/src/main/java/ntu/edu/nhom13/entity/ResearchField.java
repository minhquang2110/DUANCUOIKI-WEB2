package ntu.edu.nhom13.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ResearchFields")
public class ResearchField {
    @Id
    private Integer id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "parentFieldID")
    private ResearchField parentField;

    private String description;

    @Column(unique = true)
    private String code;

    // Getters, Setters, Constructors
}
