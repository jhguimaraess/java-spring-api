package br.com.guimaraes.project.entity;

import java.util.Objects;

import org.springframework.beans.BeanUtils;

import br.com.guimaraes.project.dto.ResourceDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "GMR_RESOURCE")
public class ResourceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String key;
	
	public ResourceEntity() {
		
	}
	
	public ResourceEntity(ResourceDTO resource) {
		BeanUtils.copyProperties(resource, this);
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResourceEntity other = (ResourceEntity) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
