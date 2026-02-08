package br.com.guimaraes.project.dto;

import org.springframework.beans.BeanUtils;

import br.com.guimaraes.project.entity.PermissionProfileResourceEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PermissionProfileResourceDTO {
	
	private Long id;
	private PerfilDTO profile;
	private ResourceDTO resource;
	
	public PermissionProfileResourceDTO(PermissionProfileResourceEntity permission) {
		BeanUtils.copyProperties(permission, this);
		if(permission != null && permission.getProfile() != null) {
			this.profile = new PerfilDTO(permission.getProfile());
		}
		if(permission != null && permission.getResource() != null) {
			this.resource = new ResourceDTO(permission.getResource());
		}
	}

}
