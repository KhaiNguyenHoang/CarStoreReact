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
@Table(name = "dbo.ProductImages")
public class ProductImages implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ImageId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer imageId;

    @Column(name = "ProductId", nullable = false)
    private Integer productId;

    @Column(name = "ImageUrl", nullable = false)
    private String imageUrl;

    @Column(name = "AltText")
    private String altText;

    @Column(name = "IsMain", nullable = false)
    private Boolean isMain = Boolean.FALSE;

    @Column(name = "DisplayOrder", nullable = false)
    private Integer displayOrder = 1;

    @Column(name = "CreatedAt", nullable = false)
    private Date createdAt;

}
