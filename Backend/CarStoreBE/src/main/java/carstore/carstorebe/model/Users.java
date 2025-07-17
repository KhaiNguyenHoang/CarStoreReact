package carstore.carstorebe.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
@Table(name = "dbo.Users")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "UserId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "Email", nullable = false)
    private String email;

    @Column(name = "PasswordHash", nullable = false)
    private String passwordHash;

    @Column(name = "FullName", nullable = false)
    private String fullName;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "DateOfBirth")
    private Date dateOfBirth;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "Avatar")
    private String avatar;

    @Column(name = "IsEmailVerified", nullable = false)
    private Boolean isEmailVerified = Boolean.FALSE;

    @Column(name = "Status", nullable = false)
    private String status = "Active";

    @Column(name = "LastLoginAt")
    private Date lastLoginAt;

    @Column(name = "CreatedAt", nullable = false)
    private Date createdAt;

    @Column(name = "UpdatedAt", nullable = false)
    private Date updatedAt;

}
