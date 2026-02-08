package br.com.guimaraes.project.entity;

import org.springframework.beans.BeanUtils;

import br.com.guimaraes.project.dto.PermissionProfileResourceDTO;
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
@Table(name = "GMR_PERMISSION_PROFILE_RESOURCE")
@Getter
@Setter
@NoArgsConstructor
public class PermissionProfileResourceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "ID_PROFILE")
	private PerfilEntity profile;
	
	@ManyToOne
	@JoinColumn(name = "ID_RESOURCE")
	private ResourceEntity resource;
	
	public PermissionProfileResourceEntity(PermissionProfileResourceDTO permission) {
		BeanUtils.copyProperties(permission, this);
		if(permission != null && permission.getProfile() != null) {
			this.profile = new PerfilEntity(permission.getProfile());
		}
		if(permission != null && permission.getResource() != null) {
			this.resource = new ResourceEntity(permission.getResource());
		}
	}
	
}
