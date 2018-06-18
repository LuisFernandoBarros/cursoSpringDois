package br.com.luisFernando.restapi.model;

import java.sql.Date;
import java.util.Calendar;

public class CreditCard {

	private long id;
	private String number;
	private Date expirationDAte;
	
	public CreditCard() {
		
	}
	
	@SuppressWarnings("deprecation")
	public CreditCard(Long id, String number) {
		this.id = id;
		this.number = number;
		this.expirationDAte = new Date(id);
		this.expirationDAte.setYear(this.expirationDAte.getYear() +1);		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getExpirationDAte() {
		return expirationDAte;
	}

	public void setExpirationDAte(Date expirationDAte) {
		this.expirationDAte = expirationDAte;
	}
	
	
	
}
