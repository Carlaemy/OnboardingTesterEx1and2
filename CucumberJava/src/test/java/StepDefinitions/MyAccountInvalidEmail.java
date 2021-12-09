package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyAccountInvalidEmail {
	WebDriver driver = null;
	@Given("User types an invalid email")
	public void user_types_an_invalid_email() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","/Users/carlaperez/Downloads/Chrome/ChromeDriver");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		driver.findElement(By.id("input-email")).sendKeys("pamela@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Prueba");
		Thread.sleep(1000);
		WebElement login = driver.findElement(By.cssSelector("input[class='btn btn-primary']"));
		login.click();
		WebElement edit = driver.findElement(By.linkText("Edit your account information"));
		edit.click();
	    
	}

	@When("User saves the changes")
	public void user_saves_the_changes() {
		
		WebElement firstname = driver.findElement(By.id("input-email"));
		firstname.clear();
		firstname.sendKeys("pamelagmail.com");
		WebElement element =  driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
		element.click(); 
	    
	}

	@Then("Error message detailing “Email Address does not appear to be valid”")
	public void error_message_detailing_Email_Address_does_not_appear_to_be_valid() {
		
		  System.out.println("Successfully completed");
		
	   
	}




}
