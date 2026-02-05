package br.com.guimaraes.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.guimaraes.project.dto.ResourceDTO;
import br.com.guimaraes.project.entity.ResourceEntity;
import br.com.guimaraes.project.repository.ResourceRepository;

public class ResourceService {
	
	@Autowired
	private ResourceRepository resourceRepository;
	
	public List<ResourceDTO> listAll(){
		List<ResourceEntity> resource = resourceRepository.findAll();
		return resource.stream().map(ResourceDTO::new).toList();
	}
	
	public void insert(ResourceDTO resource) {
		ResourceEntity resourceEntity = new ResourceEntity(resource);
		resourceRepository.save(resourceEntity);
	}
	
	public ResourceDTO update(ResourceDTO resource) {
		ResourceEntity resourceEntity = new ResourceEntity(resource);
		return new ResourceDTO(resourceRepository.save(resourceEntity));
	}
	
	public void delete(Long id) {
		ResourceEntity resource = resourceRepository.findById(id).get();
		resourceRepository.delete(resource);
	}
	
	public ResourceDTO searchForId(Long id) {
		return new ResourceDTO(resourceRepository.findById(id).get());
	}
	
}
