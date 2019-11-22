package com.afra.rest.countries;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.arfa.rest.countries.FetchCountryCapital;

public class TestFetchCountriesCapital {

	static FetchCountryCapital fetchCountryCapital ;
	String expectedErrorMessage = "";
	@BeforeClass
	public static void before() {
		fetchCountryCapital = new FetchCountryCapital();
	}
	
	@Test
	public void getCurrencyWithValidCountryFullName() {
		String countryName = "Denmark";
		String expectedCapital = "Copenhagen";
		String actualCapital = fetchCountryCapital.getCapital(countryName);
		Assert.assertEquals(expectedCapital, actualCapital);
	}
	
	@Test
	public void getCurrencyWithValidCountryFullName_AllLowerCase() {
		String countryName = "denmark";
		String expectedCapital = "Copenhagen";
		String actualCapital = fetchCountryCapital.getCapital(countryName);
		Assert.assertEquals(expectedCapital, actualCapital);
	}
	
	@Test
	public void getCurrencyWithValidCountryFullName_AllUpperCase() {
		String countryName = "DENMARK";
		String expectedCapital = "Copenhagen";
		String actualCapital = fetchCountryCapital.getCapital(countryName);
		Assert.assertEquals(expectedCapital, actualCapital);
	}
	
	@Test
	public void getCurrencyWithValidCountryFullName_UpperAndLowerCase() {
		String countryName = "DeNmArK";
		String expectedCapital = "Copenhagen";
		String actualCapital = fetchCountryCapital.getCapital(countryName);
		Assert.assertEquals(expectedCapital, actualCapital);
	}
	
	@Test
	public void getCurrencyWithInValidCountryFullName() {
		String countryName = "denmarkkkk";
		String actualCapital = fetchCountryCapital.getCapital(countryName);
		Assert.assertEquals(expectedErrorMessage, actualCapital);
	}

	@Test
	public void getCurrencyWithInValidCountryFullName2() {
		String countryName = "  denmark";
		String actualCapital = fetchCountryCapital.getCapital(countryName);
		Assert.assertEquals(expectedErrorMessage, actualCapital);
	}

	@Test
	public void getCurrencyWithInValidCountryFullName3() {
		String countryName = "denmark  ";
		String actualCapital = fetchCountryCapital.getCapital(countryName);
		Assert.assertEquals(expectedErrorMessage, actualCapital);
	}

	@Test
	public void getCurrencyWithInValidCountryFullName4() {
		String countryName = "den  mark";
		String actualCapital = fetchCountryCapital.getCapital(countryName);
		Assert.assertEquals(expectedErrorMessage, actualCapital);
	}

	@Test
	public void getCurrencyWithInValidCountryFullName5() {
		String countryName = "denmarkdenmark";
		String actualCapital = fetchCountryCapital.getCapital(countryName);
		Assert.assertEquals(expectedErrorMessage, actualCapital);
	}

	@Test
	public void getCurrencyWithInValidCountryFullName6() {
		String countryName = "DENMARK*";
		String actualCapital = fetchCountryCapital.getCapital(countryName);
		Assert.assertEquals(expectedErrorMessage, actualCapital);
	}
	
	@Test
	public void getCurrencyWithValidCountryAlpha2Code() {
		String countryName = "IN";
		String expectedCapital = "New Delhi";
		String actualCapital = fetchCountryCapital.getCapital(countryName);
		Assert.assertEquals(expectedCapital, actualCapital);
	}
	
	@Test
	public void getCurrencyWithInValidCountryAlpha2Code() {
		String countryName = "if";
		String actualCapital = fetchCountryCapital.getCapital(countryName);
		Assert.assertEquals(expectedErrorMessage, actualCapital);
	}

	@Test
	public void getCurrencyWithValidCountryAlpha3Code() {
		String countryName = "NLD";
		String expectedCapital = "Amsterdam";
		String actualCapital = fetchCountryCapital.getCapital(countryName);
		Assert.assertEquals(expectedCapital, actualCapital);
	}
	
	@Test
	public void getCurrencyWithInValidCountryAlpha3Code() {
		String countryName = "NLDN";
		String actualCapital = fetchCountryCapital.getCapital(countryName);
		Assert.assertEquals(expectedErrorMessage, actualCapital);
	}
	
	@Test
	public void getCurrencyWithValidCountriesCallingCode() {
		String countryName = "1";
		String expectedCapital = "Ottawa,Washington, D.C.";
		String actualCapital = fetchCountryCapital.getCapital(countryName);
		Assert.assertEquals(expectedCapital, actualCapital);
	}
	
	@Test
	public void getCurrencyWithValidCountryCallingCode() {
		String countryName = "65";
		String expectedCapital = "Singapore";
		String actualCapital = fetchCountryCapital.getCapital(countryName);
		Assert.assertEquals(expectedCapital, actualCapital);
	}
	
	@Test
	public void getCurrencyWithInValidCountryCallingCode() {
		String countryName = "12312";
		String actualCapital = fetchCountryCapital.getCapital(countryName);
		Assert.assertEquals(expectedErrorMessage, actualCapital);
	}
}
