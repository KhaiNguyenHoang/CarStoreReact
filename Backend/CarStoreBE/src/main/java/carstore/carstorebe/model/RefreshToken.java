package carstore.carstorebe.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "RefreshTokens")
public class RefreshToken {
    @Id
    @Column(name = "TokenId", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "UserId", nullable = false)
    private User user;

    @Size(max = 512)
    @NotNull
    @Nationalized
    @Column(name = "Token", nullable = false, length = 512)
    private String token;

    @NotNull
    @Column(name = "ExpiryDate", nullable = false)
    private Instant expiryDate;

    @NotNull
    @ColumnDefault("getdate()")
    @Column(name = "CreatedAt", nullable = false)
    private Instant createdAt;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "IsRevoked", nullable = false)
    private Boolean isRevoked = false;

}