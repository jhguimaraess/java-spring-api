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

import br.com.guimaraes.project.dto.PermissionProfileResourceDTO;
import br.com.guimaraes.project.service.PermissionProfiileResourceService;

@RestController
@RequestMapping(value = "/profileResouce")
@CrossOrigin
public class PermissionProfileResourceController {
	
	@Autowired
	private PermissionProfiileResourceService profileResourceServices;
	
	@GetMapping
	public List<PermissionProfileResourceDTO> listAll(){
		return profileResourceServices.listAll();
	}
	
	@PostMapping
	public void insert(@RequestBody PermissionProfileResourceDTO profileResource) {
		profileResourceServices.insert(profileResource);
	}
	
	@PutMapping
	public PermissionProfileResourceDTO update(@RequestBody PermissionProfileResourceDTO profileResource) {
		return profileResourceServices.update(profileResource);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		profileResourceServices.delete(id);
		return ResponseEntity.ok().build();
	}

}
