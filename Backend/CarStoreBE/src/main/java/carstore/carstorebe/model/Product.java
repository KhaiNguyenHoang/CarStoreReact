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

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "Products", indexes = {
        @Index(name = "IX_Products_CategoryId", columnList = "CategoryId"),
        @Index(name = "IX_Products_Status", columnList = "Status"),
        @Index(name = "IX_Products_SKU", columnList = "SKU"),
        @Index(name = "IX_Products_Price", columnList = "Price"),
        @Index(name = "IX_Products_StockQuantity", columnList = "StockQuantity"),
        @Index(name = "IX_Products_IsFeatured", columnList = "IsFeatured"),
        @Index(name = "IX_Products_CreatedAt", columnList = "CreatedAt")
}, uniqueConstraints = {
        @UniqueConstraint(name = "UQ__Products__CA1ECF0D47AA36FE", columnNames = {"SKU"})
})
public class Product {
    @Id
    @Column(name = "ProductId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "CategoryId", nullable = false)
    private Category category;

    @Size(max = 100)
    @NotNull
    @Nationalized
    @Column(name = "ProductName", nullable = false, length = 100)
    private String productName;

    @Nationalized
    @Lob
    @Column(name = "Description")
    private String description;

    @Size(max = 255)
    @Nationalized
    @Column(name = "ShortDescription")
    private String shortDescription;

    @NotNull
    @Column(name = "Price", nullable = false, precision = 18, scale = 2)
    private BigDecimal price;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "StockQuantity", nullable = false)
    private Integer stockQuantity;

    @NotNull
    @ColumnDefault("5")
    @Column(name = "MinStockLevel", nullable = false)
    private Integer minStockLevel;

    @Column(name = "Weight", precision = 10, scale = 2)
    private BigDecimal weight;

    @Size(max = 50)
    @Nationalized
    @Column(name = "Dimensions", length = 50)
    private String dimensions;

    @Size(max = 50)
    @Nationalized
    @Column(name = "SKU", length = 50)
    private String sku;

    @Size(max = 100)
    @Nationalized
    @Column(name = "Brand", length = 100)
    private String brand;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @ColumnDefault("'Available'")
    @Column(name = "Status", nullable = false, length = 50)
    private String status;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "IsFeatured", nullable = false)
    private Boolean isFeatured = false;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "ViewCount", nullable = false)
    private Integer viewCount;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "SoldCount", nullable = false)
    private Integer soldCount;

    @NotNull
    @ColumnDefault("getdate()")
    @Column(name = "CreatedAt", nullable = false)
    private Instant createdAt;

    @NotNull
    @ColumnDefault("getdate()")
    @Column(name = "UpdatedAt", nullable = false)
    private Instant updatedAt;

}