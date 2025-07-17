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
@Table(name = "dbo.Addresses")
public class Addresses implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "AddressId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;

    @Column(name = "UserId", nullable = false)
    private Integer userId;

    @Column(name = "AddressName", nullable = false)
    private String addressName;

    @Column(name = "AddressLine1", nullable = false)
    private String addressLine1;

    @Column(name = "AddressLine2")
    private String addressLine2;

    @Column(name = "City", nullable = false)
    private String city;

    @Column(name = "State")
    private String state;

    @Column(name = "PostalCode")
    private String postalCode;

    @Column(name = "Country", nullable = false)
    private String country = "Vietnam";

    @Column(name = "IsDefault", nullable = false)
    private Boolean isDefault = Boolean.FALSE;

    @Column(name = "CreatedAt", nullable = false)
    private Date createdAt;

    @Column(name = "UpdatedAt", nullable = false)
    private Date updatedAt;

}
