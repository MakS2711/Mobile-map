package ru.dorofeev.mobilemap.model.entity;


import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name", "region_id"})
})
public class Locality implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "locality_generator")
    @SequenceGenerator(name = "locality_generator", sequenceName = "locality_seq")
    private Long id;

    @NotNull(message = "The field should not be null!")
    @NotBlank(message = "The field should not be empty!")
    private String name;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private Region region;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "locality_street",
            joinColumns = @JoinColumn(name = "locality_id"),
            inverseJoinColumns = @JoinColumn(name = "street_id"))
    private Collection<Street> streets;
}
