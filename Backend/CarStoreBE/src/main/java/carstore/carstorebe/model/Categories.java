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
@Table(name = "dbo.Categories")
public class Categories implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CategoryId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    @Column(name = "CategoryName", nullable = false)
    private String categoryName;

    @Column(name = "Description")
    private String description;

    @Column(name = "ParentCategoryId")
    private Integer parentCategoryId;

    @Column(name = "ImageUrl")
    private String imageUrl;

    @Column(name = "DisplayOrder", nullable = false)
    private Integer displayOrder = 1;

    @Column(name = "Status", nullable = false)
    private String status = "Active";

    @Column(name = "CreatedAt", nullable = false)
    private Date createdAt;

    @Column(name = "UpdatedAt", nullable = false)
    private Date updatedAt;

}
