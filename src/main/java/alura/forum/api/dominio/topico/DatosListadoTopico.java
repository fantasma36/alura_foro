package alura.forum.api.dominio.topico;

import java.time.LocalDate;

public record DatosListadoTopico(String titulo,String autor,String mensaje,LocalDate fecha_creacion) {
	public DatosListadoTopico(Topico topico) {
		this(topico.getTitulo(),topico.getAutor(), topico.getMensaje(),topico.getFecha_creacion());
	}
}
