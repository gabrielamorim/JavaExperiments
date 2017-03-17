package com.gabrielamorim.order;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 *
 * @author Gabriel Amorim
 * 
 * Classe que define todos os steps presentes no arquivo de features LineActivationDeactivation.feature.
 *
 */
public class OrderActivationDeactivationTestDefs {
	
	OrderItem orderItem;
	
	@Before
	public void initialize()  {
	    orderItem = new OrderItem();
	}
	
	@Given("I have an order to (.+) a line with the (.+) number")
	public void addItem(String operation, String number) {		
		orderItem.number = orderItem.number + number;
		assertThat(orderItem.number.substring(2).equals(number), equalTo(true));
	}
	
	@When("the order is received")
	public void orderReceived() {		
		//TODO validar a ordem
	}
	
	@Then("the service invoked must be (.+)")
	public void validateServiceInvoked(String serviceName) {		
		//TODO validar o service invocado
	}
	
	@And("the input to the legacy system should contains (.+)")
	public void validateLegacyPauload(String xpath) {		
		//TODO validar o pauload para o legado
	}
	
	@Given("the country code is (.+)")
	public void setCountryCode(String countryCode) {		
		orderItem.number = countryCode;
	}
}