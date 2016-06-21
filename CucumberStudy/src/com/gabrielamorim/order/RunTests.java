package com.gabrielamorim.order;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;

/**
 * 
 * @author Gabriel Amorim
 * 
 * 
 * JUnit Runner uses the JUnit Framework to run Cucumber:
 * @RunWith(Cucumber.class)
 * 
 * You can run this test in the same way you run your other JUnit tests, 
 * using your IDE or your build tool (for example mvn test).
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber"})
public class RunTests {
}