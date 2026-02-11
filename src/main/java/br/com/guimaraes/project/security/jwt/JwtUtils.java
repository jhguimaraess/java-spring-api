package br.com.guimaraes.project.security.jwt;

import java.nio.charset.MalformedInputException;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.guimaraes.project.service.UserDetailsImpl;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


@Component
public class JwtUtils {

	@Value("${project.jwtSecret}")
	private String jwtSecret;
	
	@Value("${project.jwtExpirationMs}")
	private int jwtExpirationMs;
	
	public String generateTokenFromUserDetailsImpl(UserDetailsImpl userDetail) {
		return Jwts.builder().setSubject(userDetail.getUsername())
				.setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime() + jwtExpirationMs))
				.signWith(getSigninKey(), io.jsonwebtoken.SignatureAlgorithm.HS512).compact();
	}
	
	public java.security.Key getSigninKey() {
		SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
		return key;
	}
	
	public String getUsernameToken(String token) {
		return Jwts.parser().setSigningKey(getSigninKey()).build().parseClaimsJws(token).getBody().getSubject();
	}
	
	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(getSigninKey()).build().parseClaimsJws(authToken);
			return true;
			
		}catch(MalformedJwtException e){
			System.out.println("Token inválido " + e.getMessage());
		}catch(ExpiredJwtException e){
			System.out.println("Token expirado " + e.getMessage());
		}catch(UnsupportedJwtException e){
			System.out.println("Token não suportado " + e.getMessage());
		}catch(IllegalArgumentException e){
			System.out.println("Token argumento inválido " + e.getMessage());
		}
		
		return false;
	}
	
}
