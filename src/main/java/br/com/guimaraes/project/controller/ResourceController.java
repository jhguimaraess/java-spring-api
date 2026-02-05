package br.com.guimaraes.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.guimaraes.project.dto.ResourceDTO;
import br.com.guimaraes.project.service.ResourceService;

@RestController
@RequestMapping(value = "/resource")
@CrossOrigin
public class ResourceController {

	@Autowired
	private ResourceService resourceService;
	
	@GetMapping
	public List<ResourceDTO> listAll(){
		return resourceService.listAll();
	}
	
	@PostMapping
	public void insert(@RequestBody ResourceDTO resource) {
		resourceService.insert(resource);
	}
	
	@PutMapping
	public ResourceDTO update(@RequestBody ResourceDTO resource) {
		return resourceService.update(resource);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		resourceService.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
