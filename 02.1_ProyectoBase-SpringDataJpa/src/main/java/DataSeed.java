import jakarta.annotation.PostConstruct;
import lombok.Builder;
import model.Critica;
import model.Genero;
import model.Pelicula;
import org.springframework.stereotype.Component;
import tools.jackson.databind.json.JsonMapper;

@Component
@Builder
public class DataSeed {

    @PostConstruct
    public void executeWithoutResult(){
        Pelicula  pelicula = Pelicula.builder()
                .titulo("Test")
                .anioEstreno(1900)
                .listaGeneros()
                .listaCritica()
                .build();

        Pelicula  pelicula2 = Pelicula.builder()
                .titulo("Test3")
                .anioEstreno(1900)
                .listaGeneros()
                .listaCritica()
                .build();

        Critica critica1 = Critica.builder()
                .autor("Pepe")
                .texto("Muy mala")
                .puntuacion(3)
                .build(); //a1

        Critica critica2 = Critica.builder()
                .autor("Pepe")
                .texto("Muy mala")
                .puntuacion(3)
                .build(); //a1

        Critica critica3 = Critica.builder()
                .autor("Pepe")
                .texto("Muy mala")
                .puntuacion(3)
                .build(); //a1

        Genero.builder();
        Genero.builder();

    }

}

    /*
    * 2 películas.
    3 críticas: dos de ellas para la primera película y una para la segunda.
    2 géneros: uno de ellos compartido por ambas películas.

    * */

