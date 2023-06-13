package alura.forum.api.dominio.topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(@NotNull Long id,String titulo,String autor,String mensaje,String curso) {

}
