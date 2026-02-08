package br.com.guimaraes.project.dto;

import org.springframework.beans.BeanUtils;

import br.com.guimaraes.project.entity.UserProfileEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserProfileDTO {

	private Long id;
	private UserDTO user;
	private PerfilDTO profile;
	
	private void UserProfileDTO(UserProfileEntity userProfile) {
		BeanUtils.copyProperties(userProfile, this);
		if(userProfile != null && userProfile.getUser() != null) {
			this.user = new UserDTO(userProfile.getUser());
		}
		if(userProfile != null && userProfile.getProfile() != null) {
			this.profile = new PerfilDTO(userProfile.getProfile());
		}
	}
	
}
