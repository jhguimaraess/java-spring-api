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

import br.com.guimaraes.project.dto.UserProfileDTO;
import br.com.guimaraes.project.service.UserProfileService;

@RestController
@RequestMapping(value = "/userProfile")
@CrossOrigin
public class UserProfileController {
	
	@Autowired
	private UserProfileService userProfileServices;
	
	@GetMapping
	public List<UserProfileDTO> listAll(){
		return userProfileServices.listAll();
	}
	
	@PostMapping
	public void insert(@RequestBody UserProfileDTO userProfile) {
		userProfileServices.insert(userProfile);
	}
	
	@PutMapping
	public UserProfileDTO update(@RequestBody UserProfileDTO userProfile) {
		return userProfileServices.update(userProfile);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		userProfileServices.delete(id);
		return ResponseEntity.ok().build();
	}

}
