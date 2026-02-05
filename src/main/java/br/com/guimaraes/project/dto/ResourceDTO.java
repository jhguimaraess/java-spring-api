package br.com.guimaraes.project.dto;

import java.util.Objects;

import org.springframework.beans.BeanUtils;

import br.com.guimaraes.project.entity.ResourceEntity;

public class ResourceDTO {
	
	private Long id;
	private String name;
	private String key;
	
	public ResourceDTO(){
		
	}
	
	public ResourceDTO(ResourceEntity resource) {
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
		ResourceDTO other = (ResourceDTO) obj;
		return Objects.equals(id, other.id);
	}

	
	
}
