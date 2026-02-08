package br.com.guimaraes.project.entity;

import org.springframework.beans.BeanUtils;

import br.com.guimaraes.project.dto.UserProfileDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "GMR_PROFILE_USER")
@Getter
@Setter
@NoArgsConstructor
public class UserProfileEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "ID_USER")
	private UserEntity user;
	
	@ManyToOne
	@JoinColumn(name = "ID_PROFILE")
	private PerfilEntity profile;
	
	public UserProfileEntity(UserProfileDTO userProfile) {
		BeanUtils.copyProperties(userProfile, this);
		if(userProfile != null && userProfile.getUser() != null) {
			this.user = new UserEntity(userProfile.getUser());
		}
		if(userProfile != null && userProfile.getProfile() != null) {
			this.profile = new PerfilEntity(userProfile.getProfile());
		}
	}

}
