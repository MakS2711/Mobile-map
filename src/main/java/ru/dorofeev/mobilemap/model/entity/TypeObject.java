package ru.dorofeev.mobilemap.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TypeObject implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "type_object_generator")
    @SequenceGenerator(name = "type_object_generator", sequenceName = "type_object_seq")
    private Long id;

    @NotNull(message = "The field should not be null!")
    @NotBlank(message = "The field should not be empty!")
    @Column(unique = true)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "type")
    private List<GeographicalObject> geographicalObjectList;
}
