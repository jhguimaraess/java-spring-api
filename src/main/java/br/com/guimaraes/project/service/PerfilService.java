package br.com.guimaraes.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guimaraes.project.dto.PerfilDTO;
import br.com.guimaraes.project.entity.PerfilEntity;
import br.com.guimaraes.project.repository.PerfilRepository;

@Service
public class PerfilService {

	@Autowired
	private PerfilRepository perfilRepository;
	
	public List<PerfilDTO> listAll(){
		List<PerfilEntity> perfil = perfilRepository.findAll();
		return perfil.stream().map(PerfilDTO::new).toList();
	}
	
	public void insert(PerfilDTO perfil) {
		PerfilEntity perfilEntity = new PerfilEntity(perfil);
		perfilRepository.save(perfilEntity);
	}
	
	public PerfilDTO update(PerfilDTO  perfil) {
		PerfilEntity perfilEntity = new PerfilEntity(perfil);
		return new PerfilDTO(perfilRepository.save(perfilEntity));
	}
	
	public void delete(Long id) {
		PerfilEntity perfil = perfilRepository.findById(id).get();
		perfilRepository.delete(perfil);
	}
	
	public PerfilDTO searchForId(Long id) {
		return new PerfilDTO(perfilRepository.findById(id).get());
	}
	
}
