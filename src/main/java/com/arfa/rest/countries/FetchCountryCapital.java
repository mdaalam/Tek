package com.arfa.rest.countries;

import static io.restassured.RestAssured.given;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import io.restassured.response.Response;

public class FetchCountryCapital {

	private String URL = "https://restcountries.eu/rest/v2/all?fields=name;capital;alpha2Code;alpha3Code;callingCodes";
	private List<Country> listOfCountries = null;

	/*
	 * Constructor to initialize the countries and capitals.
	 */
	public FetchCountryCapital() {
		Response response = given().header("Content-Type", "application/json").get(URL);
		Country[] countries = response.as(Country[].class);
		listOfCountries = Arrays.asList(countries);
	}

	public String getCapital(String countryOrCapital) {

		String capital = "";

		for (Country country : listOfCountries) {
			if (country.getName().toLowerCase().equals(countryOrCapital.toLowerCase())
					|| country.getAlpha2Code().toLowerCase().equals(countryOrCapital.toLowerCase())
					|| country.getAlpha3Code().toLowerCase().equals(countryOrCapital.toLowerCase())
					|| country.getCallingCodes()[0].toLowerCase().equals(countryOrCapital.toLowerCase())) {

				String temp = country.getCapital().toString();
				if (capital.equals("")) {
					capital = temp;
				} else {
					capital = capital + "," + temp;
				}
			}

		}

		return capital;
	}

	public static void main(String[] args) {
		System.out.println("Please Wait -- loading all countries and capitals...");
		FetchCountryCapital fcc = new FetchCountryCapital();
		System.out.println("Please enter Country Name or Short Code or Calling code to get Capital");

		while (true) {
			Scanner in = new Scanner(System.in);
			String countryNameOrCode = in.nextLine();
			// System.out.println("You entered " + countryNameOrCode);
			String value = fcc.getCapital(countryNameOrCode);

			if (value != null && !value.equals("") && !value.equals("[]")) {
				System.out.println(countryNameOrCode + " : " + value);
			} else {
				System.out.println(countryNameOrCode
						+ " is not valid country name or code, goto https://restcountries.eu/#similar-projects for list of countries or codes.\n");
			}

			System.out.println("Enter one more country name or code or Terminate program");
		}

	}
}
