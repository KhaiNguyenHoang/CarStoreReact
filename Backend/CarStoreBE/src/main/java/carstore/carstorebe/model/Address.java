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
@Table(name = "Addresses", indexes = {
        @Index(name = "IX_Addresses_UserId", columnList = "UserId"),
        @Index(name = "IX_Addresses_IsDefault", columnList = "IsDefault")
})
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AddressId", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "UserId", nullable = false)
    private User user;

    @Size(max = 100)
    @NotNull
    @Nationalized
    @Column(name = "AddressName", nullable = false, length = 100)
    private String addressName;

    @Size(max = 255)
    @NotNull
    @Nationalized
    @Column(name = "AddressLine1", nullable = false)
    private String addressLine1;

    @Size(max = 255)
    @Nationalized
    @Column(name = "AddressLine2")
    private String addressLine2;

    @Size(max = 100)
    @NotNull
    @Nationalized
    @Column(name = "City", nullable = false, length = 100)
    private String city;

    @Size(max = 100)
    @Nationalized
    @Column(name = "State", length = 100)
    private String state;

    @Size(max = 20)
    @Nationalized
    @Column(name = "PostalCode", length = 20)
    private String postalCode;

    @Size(max = 100)
    @NotNull
    @Nationalized
    @ColumnDefault("'Vietnam'")
    @Column(name = "Country", nullable = false, length = 100)
    private String country;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "IsDefault", nullable = false)
    private Boolean isDefault = false;

    @NotNull
    @ColumnDefault("getdate()")
    @Column(name = "CreatedAt", nullable = false)
    private Instant createdAt;

    @NotNull
    @ColumnDefault("getdate()")
    @Column(name = "UpdatedAt", nullable = false)
    private Instant updatedAt;

}