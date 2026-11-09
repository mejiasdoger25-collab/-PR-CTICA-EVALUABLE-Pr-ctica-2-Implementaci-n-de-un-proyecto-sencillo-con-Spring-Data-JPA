package model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Pelicula {

    @Id @GeneratedValue
    private Long id;

    private String titulo;
    private int anioEstreno;


    @ManyToMany(cascade = CascadeType.PERSIST)
    @Builder.Default
    private List<Genero> listaGeneros = new ArrayList<>();


    @OneToMany(mappedBy = "listaPeliculas")
    @Builder.Default
    private Collection<Critica> listaCritica;

    public Collection<Critica> getListaCritica() {
        return listaCritica;
    }

    public void setListaCritica(Collection<Critica> listaCritica) {
        this.listaCritica = listaCritica;
    }

    // addCritica(...) y removeCritica(...)
}
