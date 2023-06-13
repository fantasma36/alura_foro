package alura.forum.api.dominio.topico;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
	Topico findByAutor(String autor);
	
}
