package br.com.guimaraes.project.dto;


public class AcessDTO {

	private String token;
	
	//TODO implementar retornar usiario e liberações (authorities)
	
	public AcessDTO(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
	
}
