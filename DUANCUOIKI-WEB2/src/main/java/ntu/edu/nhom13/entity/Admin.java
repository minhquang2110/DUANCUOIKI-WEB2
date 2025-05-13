package ntu.edu.nhom13.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminId;

    @OneToOne
    @JoinColumn(name = "accountId", nullable = false, unique = true)
    private Account account;

    @Column(nullable = false)
    private String fullName;

    private String email;
    private String phoneNumber;

    // Getters, Setters, Constructors
}
