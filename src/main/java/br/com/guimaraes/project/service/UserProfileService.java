package br.com.guimaraes.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guimaraes.project.dto.UserProfileDTO;
import br.com.guimaraes.project.entity.UserProfileEntity;
import br.com.guimaraes.project.repository.UserProfileRepository;

@Service
public class UserProfileService {
	
	@Autowired
	private UserProfileRepository userProfileRepository;
	
	
	public List<UserProfileDTO> listAll(){
		List<UserProfileEntity> usersProfile = userProfileRepository.findAll();
		return usersProfile.stream().map(UserProfileDTO::new).toList();
	}

	public void insert(UserProfileDTO userProfile) {
		UserProfileEntity userProfileEntity = new UserProfileEntity(userProfile);
		userProfileRepository.save(userProfileEntity);
	}
	
	public UserProfileDTO update(UserProfileDTO userProfile) {
		UserProfileEntity userProfileEntity = new UserProfileEntity(userProfile);
		return new UserProfileDTO(userProfileRepository.save(userProfileEntity));
	}
	
	public void delete(Long id) {
		UserProfileEntity userProfile = userProfileRepository.findById(id).get();
		userProfileRepository.delete(userProfile);
	}
	
	public UserProfileDTO searchForId(Long id) {
		return new UserProfileDTO(userProfileRepository.findById(id).get());
	}

}
