package ntu.edu.nhom13.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Ranks")
public class Rank {
    @Id
    private Integer id;

    @Column(nullable = false)
    private String name;

    // Getters, Setters
}
