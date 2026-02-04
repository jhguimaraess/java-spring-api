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

import br.com.guimaraes.project.dto.UserDTO;
import br.com.guimaraes.project.service.UserService;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userServices;
	
	@GetMapping
	public List<UserDTO> listAll(){
		return userServices.listAll();
	}
	
	@PostMapping
	public void insert(@RequestBody UserDTO user) {
		userServices.insert(user);
	}
	
	@PutMapping
	public UserDTO update(@RequestBody UserDTO user) {
		return userServices.update(user);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		userServices.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
