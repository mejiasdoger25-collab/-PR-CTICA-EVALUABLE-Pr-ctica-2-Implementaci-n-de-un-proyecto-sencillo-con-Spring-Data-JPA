package model;

import jakarta.persistence.*;
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
public class Critica {

    @Id
    @GeneratedValue
    private Long id;

    private String autor;
    private String texto;
    private float puntuacion;

    @ManyToOne(cascade = CascadeType.ALL)
    @Builder.Default
    private ArrayList<Pelicula> listaPeliculas = new ArrayList<>();

}
