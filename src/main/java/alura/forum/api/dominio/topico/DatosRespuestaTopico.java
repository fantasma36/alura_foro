package alura.forum.api.dominio.topico;

import java.time.LocalDate;

public record DatosRespuestaTopico(String titulo,String autor,String mensaje,LocalDate fecha_creacion,String curso) {
	public DatosRespuestaTopico(Topico topico) {
		this(topico.getTitulo(),topico.getAutor(),topico.getMensaje(),topico.getFecha_creacion(),topico.getCurso());
	}
}
