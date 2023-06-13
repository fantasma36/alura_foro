package alura.forum.api.dominio.topico;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="topicos")
@Entity(name = "Topico")
//@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String mensaje;
	private LocalDate fecha_creacion;
	private Boolean estatus;
	private String autor;
	private String curso;
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public void setFecha_creacion(LocalDate fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public LocalDate getFecha_creacion() {
		return fecha_creacion;
	}

	public Boolean getEstatus() {
		return estatus;
	}

	public String getAutor() {
		return autor;
	}

	public String getCurso() {
		return curso;
	}
	@Override
	public String toString() {
		return titulo;
	}

	public Topico(DatosRegistroTopico datosRegistrooTopico) {
		this.titulo=datosRegistrooTopico.titulo();
		this.mensaje=datosRegistrooTopico.mensaje();
		this.fecha_creacion=LocalDate.now();
		this.autor=datosRegistrooTopico.autor();
		this.estatus=true;
		this.curso=datosRegistrooTopico.curso();
	}

	public void actualizarTopico(DatosActualizarTopico datosActualizarTopico) {
		if(datosActualizarTopico.titulo()!=null) {
			this.titulo=datosActualizarTopico.titulo();
		}
		if(datosActualizarTopico.mensaje()!=null) {
			this.mensaje=datosActualizarTopico.mensaje();
		}
		if(datosActualizarTopico.autor()!=null) {
			this.autor=datosActualizarTopico.autor();
		}
		if(datosActualizarTopico.curso()!=null) {
			this.curso=datosActualizarTopico.curso();
		}
	}

	public void desactivarTopico(Topico topico) {
		this.estatus=false;
	}


}
