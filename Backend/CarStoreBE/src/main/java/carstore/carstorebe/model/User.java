package carstore.carstorebe.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Users", indexes = {
        @Index(name = "IX_Users_Email", columnList = "Email"),
        @Index(name = "IX_Users_Status", columnList = "Status"),
        @Index(name = "IX_Users_CreatedAt", columnList = "CreatedAt")
}, uniqueConstraints = {
        @UniqueConstraint(name = "UQ__Users__A9D10534C9B2CA40", columnNames = {"Email"})
})
public class User {
    @Id
    @Column(name = "UserId", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Nationalized
    @Column(name = "Email", nullable = false)
    private String email;

    @Size(max = 255)
    @NotNull
    @Nationalized
    @Column(name = "PasswordHash", nullable = false)
    private String passwordHash;

    @Size(max = 100)
    @NotNull
    @Nationalized
    @Column(name = "FullName", nullable = false, length = 100)
    private String fullName;

    @Size(max = 20)
    @Nationalized
    @Column(name = "Phone", length = 20)
    private String phone;

    @Column(name = "DateOfBirth")
    private LocalDate dateOfBirth;

    @Size(max = 10)
    @Nationalized
    @Column(name = "Gender", length = 10)
    private String gender;

    @Size(max = 255)
    @Nationalized
    @Column(name = "Avatar")
    private String avatar;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "IsEmailVerified", nullable = false)
    private Boolean isEmailVerified = false;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @ColumnDefault("'Active'")
    @Column(name = "Status", nullable = false, length = 50)
    private String status;

    @Column(name = "LastLoginAt")
    private Instant lastLoginAt;

    @NotNull
    @ColumnDefault("getdate()")
    @Column(name = "CreatedAt", nullable = false)
    private Instant createdAt;

    @NotNull
    @ColumnDefault("getdate()")
    @Column(name = "UpdatedAt", nullable = false)
    private Instant updatedAt;

}