package br.com.guimaraes.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guimaraes.project.dto.PermissionProfileResourceDTO;
import br.com.guimaraes.project.entity.PermissionProfileResourceEntity;
import br.com.guimaraes.project.repository.PermissionProfileResourceRepository;

@Service
public class PermissionProfiileResourceService {
	
	@Autowired
	private PermissionProfileResourceRepository profileeResourceRepository;
	
	
	public List<PermissionProfileResourceDTO> listAll(){
		List<PermissionProfileResourceEntity> profileeResource = profileeResourceRepository.findAll();
		return profileeResource.stream().map(PermissionProfileResourceDTO::new).toList();
	}

	public void insert(PermissionProfileResourceDTO profileeResource) {
		PermissionProfileResourceEntity profileeResourceEntity = new PermissionProfileResourceEntity(profileeResource);
		profileeResourceRepository.save(profileeResourceEntity);
	}
	
	public PermissionProfileResourceDTO update(PermissionProfileResourceDTO profileeResource) {
		PermissionProfileResourceEntity profileeResourceEntity = new PermissionProfileResourceEntity(profileeResource);
		return new PermissionProfileResourceDTO(profileeResourceRepository.save(profileeResourceEntity));
	}
	
	public void delete(Long id) {
		PermissionProfileResourceEntity profileeResource = profileeResourceRepository.findById(id).get();
		profileeResourceRepository.delete(profileeResource);
	}
	
	public PermissionProfileResourceDTO searchForId(Long id) {
		return new PermissionProfileResourceDTO(profileeResourceRepository.findById(id).get());
	}

}
