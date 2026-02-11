package br.com.guimaraes.project.service;

import java.util.ArrayList;
import java.util.Collection;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.guimaraes.project.entity.UserEntity;

public class UserDetailsImpl implements UserDetails{

	private Long id;
	
	private String name;
	
	private String username;
	
	private String email;
	
	private String password;
	
	
	public UserDetailsImpl(Long id, String name, String username, String email,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(UserEntity user) {
		return new UserDetailsImpl(user.getId(), user.getName(), user.getLogin(), user.getEmail(), new ArrayList<>());
	}
	
	private Collection<? extends GrantedAuthority> authorities;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public @Nullable String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

}
