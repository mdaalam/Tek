package com.arfa.rest.countries;

/**
 * 
 * To save the country details
 *
 */
public class Country {
	private String name;
	private String alpha2Code;
	private String alpha3Code;
	String[] callingCodes ;
	

	private String capital;

	public String[] getCallingCodes() {
		return callingCodes;
	}

	public void setCallingCodes(String[] callingCodes) {
		this.callingCodes = callingCodes;
	}
	// Getter Methods

	public String getName() {
		return name;
	}

	public String getAlpha2Code() {
		return alpha2Code;
	}

	public String getAlpha3Code() {
		return alpha3Code;
	}

	public String getCapital() {
		return capital;
	}

	// Setter Methods

	public void setName(String name) {
		this.name = name;
	}

	public void setAlpha2Code(String alpha2Code) {
		this.alpha2Code = alpha2Code;
	}

	public void setAlpha3Code(String alpha3Code) {
		this.alpha3Code = alpha3Code;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	@Override
	public String toString() {
		return "Country [name=" + name + ", alpha2Code=" + alpha2Code + ", alpha3Code=" + alpha3Code + ", callingCodes="
				+ callingCodes + ", capital=" + capital + "]";
	}
}