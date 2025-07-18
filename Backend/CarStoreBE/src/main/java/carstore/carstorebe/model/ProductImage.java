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
@Table(name = "ProductImages", indexes = {
        @Index(name = "IX_ProductImages_ProductId", columnList = "ProductId"),
        @Index(name = "IX_ProductImages_IsMain", columnList = "IsMain")
})
public class ProductImage {
    @Id
    @Column(name = "ImageId", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ProductId", nullable = false)
    private Product product;

    @Size(max = 500)
    @NotNull
    @Nationalized
    @Column(name = "ImageUrl", nullable = false, length = 500)
    private String imageUrl;

    @Size(max = 255)
    @Nationalized
    @Column(name = "AltText")
    private String altText;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "IsMain", nullable = false)
    private Boolean isMain = false;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "DisplayOrder", nullable = false)
    private Integer displayOrder;

    @NotNull
    @ColumnDefault("getdate()")
    @Column(name = "CreatedAt", nullable = false)
    private Instant createdAt;

}