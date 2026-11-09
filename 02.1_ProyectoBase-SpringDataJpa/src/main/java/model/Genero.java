package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Genero {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    @ManyToMany
    @Builder.Default
    private List<Pelicula> listaPeliculas = new ArrayList<>();
}
