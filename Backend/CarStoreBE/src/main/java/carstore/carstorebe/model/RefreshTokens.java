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
@Table(name = "dbo.RefreshTokens")
public class RefreshTokens implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "TokenId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tokenId;

    @Column(name = "UserId", nullable = false)
    private Integer userId;

    @Column(name = "Token", nullable = false)
    private String token;

    @Column(name = "ExpiryDate", nullable = false)
    private Date expiryDate;

    @Column(name = "CreatedAt", nullable = false)
    private Date createdAt;

    @Column(name = "IsRevoked", nullable = false)
    private Boolean isRevoked = Boolean.FALSE;

}
