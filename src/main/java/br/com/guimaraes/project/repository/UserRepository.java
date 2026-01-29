	package br.com.guimaraes.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.guimaraes.project.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
