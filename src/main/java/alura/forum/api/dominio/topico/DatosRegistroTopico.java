package alura.forum.api.dominio.topico;

import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
		@NotNull String titulo,@NotNull String autor,@NotNull String mensaje,@NotNull String curso
		) {

}
