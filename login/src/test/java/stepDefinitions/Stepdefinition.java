package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefinition {
	protected WebDriver driver;
	
	 @Before
	    public void setup() {
		 System.setProperty("webdriver.chrome.driver","E:\\SeleniumJARs\\chromedriver.exe");
		 driver=new ChromeDriver();
	}
		
	 @Given("I open Google")
	public void I_open_google() {
		//Set implicit wait of 10 seconds and launch google
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.google.co.in");
	}
	
	 @When("^I enter \"([^\"]*)\" in search textbox$")

	public void I_enter_in_search_textbox(String additionTerms) {
		//Write term in google textbox
		WebElement googleTextBox = driver.findElement(By.name("q"));
		googleTextBox.sendKeys(additionTerms);
					
		//Click on searchButton
		WebElement searchButton = driver.findElement(By.name("btnK"));
		searchButton.click();
	}
	
	 @Then("^I should get result as \"([^\"]*)\"$")
	public void I_should_get_correct_result(String expectedResult) {
		//Get result from calculator
		WebElement calculatorTextBox = driver.findElement(By.id("cwos"));
		String result = calculatorTextBox.getText();
				
		//Verify that result of 2+2 is 4
		Assert.assertEquals(result, expectedResult);
		
		driver.close();
	}
	
	 @After
	    public void closeBrowser() {
	        driver.quit();
	 }
}
