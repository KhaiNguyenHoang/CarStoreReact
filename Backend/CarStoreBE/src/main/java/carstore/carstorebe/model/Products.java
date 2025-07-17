package carstore.carstorebe.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
@Table(name = "dbo.Products")
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ProductId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(name = "CategoryId", nullable = false)
    private Integer categoryId;

    @Column(name = "ProductName", nullable = false)
    private String productName;

    @Column(name = "Description")
    private String description;

    @Column(name = "ShortDescription")
    private String shortDescription;

    @Column(name = "Price", nullable = false)
    private BigDecimal price;

    @Column(name = "StockQuantity", nullable = false)
    private Integer stockQuantity = 0;

    @Column(name = "MinStockLevel", nullable = false)
    private Integer minStockLevel = 5;

    @Column(name = "Weight")
    private BigDecimal weight;

    @Column(name = "Dimensions")
    private String dimensions;

    @Column(name = "SKU")
    private String sku;

    @Column(name = "Brand")
    private String brand;

    @Column(name = "Status", nullable = false)
    private String status = "Available";

    @Column(name = "IsFeatured", nullable = false)
    private Boolean isFeatured = Boolean.FALSE;

    @Column(name = "ViewCount", nullable = false)
    private Integer viewCount = 0;

    @Column(name = "SoldCount", nullable = false)
    private Integer soldCount = 0;

    @Column(name = "CreatedAt", nullable = false)
    private Date createdAt;

    @Column(name = "UpdatedAt", nullable = false)
    private Date updatedAt;

}
