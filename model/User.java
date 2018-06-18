package br.com.luisFernando.restapi.model;

public class User {
	
	private long id;
	private String nome;
	private Integer age;
	
	public User() {
		
	}
	
	public User (Long id, String nome, Integer age) { 
		this.id = id;
		this.nome = nome;
		this.age = age;		
	}
	

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Integer getAge() {
		return age;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
