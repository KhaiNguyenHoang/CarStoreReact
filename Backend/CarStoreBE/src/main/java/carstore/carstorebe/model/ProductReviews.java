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
@Table(name = "dbo.ProductReviews")
public class ProductReviews implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ReviewId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reviewId;

    @Column(name = "ProductId", nullable = false)
    private Integer productId;

    @Column(name = "UserId", nullable = false)
    private Integer userId;

    @Column(name = "Rating", nullable = false)
    private Integer rating;

    @Column(name = "Title")
    private String title;

    @Column(name = "Comment")
    private String comment;

    @Column(name = "IsVerifiedPurchase", nullable = false)
    private Boolean isVerifiedPurchase = Boolean.FALSE;

    @Column(name = "HelpfulCount", nullable = false)
    private Integer helpfulCount = 0;

    @Column(name = "Status", nullable = false)
    private String status = "Pending";

    @Column(name = "CreatedAt", nullable = false)
    private Date createdAt;

    @Column(name = "UpdatedAt", nullable = false)
    private Date updatedAt;

}
