package br.com.guimaraes.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.guimaraes.project.entity.UserProfileEntity;

public interface UserProfileRepository extends JpaRepository<UserProfileEntity, Long>{

}
