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
@Table(name = "dbo.sysdiagrams")
public class Sysdiagrams implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "principal_id", nullable = false)
    private Integer principalId;

    @Id
    @Column(name = "diagram_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer diagramId;

    @Column(name = "version")
    private Integer version;

    @Column(name = "definition")
    private String definition;

}
