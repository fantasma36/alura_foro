package alura.forum.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import alura.forum.api.dominio.topico.DatosActualizarTopico;
import alura.forum.api.dominio.topico.DatosListadoTopico;
import alura.forum.api.dominio.topico.DatosRegistroTopico;
import alura.forum.api.dominio.topico.DatosRespuestaTopico;
import alura.forum.api.dominio.topico.Topico;
import alura.forum.api.dominio.topico.TopicoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
	@Autowired
	private TopicoRepository topicoRepository;
	public String mensajeTopicos() {
		return "Este es un mensaje desde topicos";
	}
	@GetMapping
	public List<DatosListadoTopico> listadoTopicos() {
		return topicoRepository.findAll().stream().map(elemento-> new DatosListadoTopico(elemento)).toList();
	}
	@PostMapping
	public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody DatosRegistroTopico datosRegistroTopico) {
		Topico topico=topicoRepository.save(new Topico(datosRegistroTopico));
		DatosRespuestaTopico datosRespuestaTopico = new  DatosRespuestaTopico(topico);
		return ResponseEntity.ok(datosRespuestaTopico);
	}
	@GetMapping("/{id}")
	public ResponseEntity<DatosRespuestaTopico> respuestaTopico(@PathVariable Long id){
		Topico topico = topicoRepository.getReferenceById(id);
		DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getTitulo(),topico.getAutor(),topico.getMensaje(),topico.getFecha_creacion(),topico.getCurso());
		return ResponseEntity.ok(datosRespuestaTopico);
	}
	@PutMapping
	@Transactional
	public ResponseEntity<DatosRespuestaTopico> actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
		Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
		topico.actualizarTopico(datosActualizarTopico);
		return ResponseEntity.ok(new DatosRespuestaTopico(topico));
	}
	@DeleteMapping("{id}")
	@Transactional
	public ResponseEntity<?> eliminarTopico(@PathVariable Long id) {
		Topico topico = topicoRepository.getReferenceById(id);
		topico.desactivarTopico(topico);
		return ResponseEntity.noContent().build();
	}
}
