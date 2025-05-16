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
public class ResearchFieldEntity {
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_field_id")
    private ResearchFieldEntity parentFieldEntity;

    private String description;

    @Column(unique = true)
    private String code;

    // Getters, Setters, Constructors
}
