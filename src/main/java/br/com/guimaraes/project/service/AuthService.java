package br.com.guimaraes.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.guimaraes.project.dto.AcessDTO;
import br.com.guimaraes.project.dto.AuthenticationDTO;
import br.com.guimaraes.project.security.jwt.JwtUtils;

@Service
public class AuthService {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtils jwtUtils;

	public AcessDTO login(AuthenticationDTO authDto) {
		
		try {
			//Cria mecanismo de credencial para o spring
			UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(authDto.getUsername(), authDto.getPassword());
		
			//prepara mecanismo para autenticacao
			Authentication authentication = authenticationManager.authenticate(userAuth);
		
			//busca usuario logado
			UserDetailsImpl userAuthenticate = (UserDetailsImpl)authentication.getPrincipal();
			
			String token = jwtUtils.generateTokenFromUserDetailsImpl(userAuthenticate);
			
			AcessDTO acessDto = new AcessDTO(token);
			
			return acessDto;
		}catch(BadCredentialsException e) {
			//TODO login ou senha invalida
		}
		return new AcessDTO("Acesso Negado");
	}
	
}
