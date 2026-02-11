package br.com.guimaraes.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.guimaraes.project.dto.UserDTO;
import br.com.guimaraes.project.entity.UserEntity;
import br.com.guimaraes.project.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public List<UserDTO> listAll(){
		List<UserEntity> users = userRepository.findAll();
		return users.stream().map(UserDTO::new).toList();
	}

	public void insert(UserDTO user) {
		UserEntity userEntity = new UserEntity(user);
		userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(userEntity);
	}
	
	public UserDTO update(UserDTO user) {
		UserEntity userEntity = new UserEntity(user);
		userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
		return new UserDTO(userRepository.save(userEntity));
	}
	
	public void delete(Long id) {
		UserEntity user = userRepository.findById(id).get();
		userRepository.delete(user);
	}
	
	public UserDTO searchForId(Long id) {
		return new UserDTO(userRepository.findById(id).get());
	}
	
}
