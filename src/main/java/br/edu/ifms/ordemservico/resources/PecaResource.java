package br.edu.ifms.ordemservico.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.ifms.ordemservico.dto.PecaDTO;
import br.edu.ifms.ordemservico.services.PecaService;

@RestController
@RequestMapping(value = "/pecas")
public class PecaResource {

	@Autowired
	private PecaService service;
	
	@GetMapping
	public ResponseEntity<List<PecaDTO>> findAll() {
		List<PecaDTO> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping(value = "/id")
	public ResponseEntity<PecaDTO> findById(@PathVariable Long id) {
		PecaDTO dto = service.findByID(id);
		return ResponseEntity.ok().body(dto);
	}

	@PostMapping
	public ResponseEntity<PecaDTO> insert(@Valid @RequestBody PecaDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping(value = "/id")
	public ResponseEntity<PecaDTO> update(@Valid @PathVariable Long id, @RequestBody PecaDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping(value = "/id")
	public ResponseEntity<PecaDTO> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
