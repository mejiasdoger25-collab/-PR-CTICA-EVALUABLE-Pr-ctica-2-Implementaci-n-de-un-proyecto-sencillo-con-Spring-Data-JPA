import Repositorios.CriticaRepository;
import Repositorios.GeneroRepository;
import Repositorios.PeliculaRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;


@Component
@DependsOn("DataSeed")
@AllArgsConstructor
@Getter
@Setter
public class DataCheck {

    private final TransactionTemplate transactionTemplate;
    private final PeliculaRepository peliculaRepository;
    private final CriticaRepository criticaRepository;
    private final GeneroRepository generoRepository;


    public DataCheck(PlatformTransactionManager transactionManager, PeliculaRepository peliculaRepository, CriticaRepository criticaRepository, GeneroRepository generoRepository) {
        this.transactionTemplate = new TransactionTemplate(transactionManager);

        this.peliculaRepository = peliculaRepository;
        this.criticaRepository = criticaRepository;
        this.generoRepository = generoRepository;
    }

    @PostConstruct
    public void comprobarDatos() {

        transactionTemplate.executeWithoutResult(status -> {
            // Comprobación A: consultas y acceso a las asociaciones
            peliculaRepository.findAll();
            peliculaRepository.findById(001);
            //peliculaRepository.

            // Comprobación B: borrado y consulta de los nuevos totales
            criticaRepository.count();
        });

    }

}

