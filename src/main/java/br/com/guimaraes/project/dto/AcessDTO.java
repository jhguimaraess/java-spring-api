package br.com.guimaraes.project.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class AcessDTO {

	private String token;
	
	//TODO implementar retornar usiario e liberações (authorities)
	
	public AcessDTO(String token) {
		super();
		this.token = token;
	}
	
}
