package carstore.carstorebe.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
@Table(name = "dbo.cars")
public class Cars implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "seller_id", nullable = false)
    private Long sellerId;

    @Column(name = "category_id", nullable = false)
    private Integer categoryId;

    @Column(name = "brand_id", nullable = false)
    private Integer brandId;

    @Column(name = "model_id", nullable = false)
    private Integer modelId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "slug", nullable = false)
    private String slug;

    @Column(name = "description")
    private String description;

    @Column(name = "year_manufacture", nullable = false)
    private Integer yearManufacture;

    @Column(name = "color")
    private String color;

    @Column(name = "fuel_type_id", nullable = false)
    private Integer fuelTypeId;

    @Column(name = "transmission_id", nullable = false)
    private Integer transmissionId;

    @Column(name = "engine_capacity")
    private BigDecimal engineCapacity;

    @Column(name = "mileage")
    private Integer mileage;

    @Column(name = "condition_type")
    private String conditionType;

    @Column(name = "vin")
    private String vin;

    @Column(name = "warranty_info")
    private String warrantyInfo;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "original_price")
    private BigDecimal originalPrice;

    @Column(name = "currency_id", nullable = false)
    private Integer currencyId;

    @Column(name = "status_id", nullable = false)
    private Integer statusId;

    @Column(name = "is_featured")
    private Boolean featured = Boolean.FALSE;

    @Column(name = "is_active")
    private Boolean active = Boolean.TRUE;

    @Column(name = "view_count")
    private Integer viewCount = 0;

    @Column(name = "favorite_count")
    private Integer favoriteCount = 0;

    @Column(name = "created_at")
    private String createdAt = "getdate()";

    @Column(name = "updated_at")
    private String updatedAt = "getdate()";

}
