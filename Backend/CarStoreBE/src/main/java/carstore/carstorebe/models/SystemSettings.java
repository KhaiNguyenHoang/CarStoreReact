package carstore.carstorebe.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
@Table(name = "dbo.system_settings")
public class SystemSettings implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "key_name", nullable = false)
    private String keyName;

    @Column(name = "value")
    private String value;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type = "string";

    @Column(name = "is_public")
    private Boolean publicField = Boolean.FALSE;

    @Column(name = "updated_at")
    private String updatedAt = "getdate()";

}
