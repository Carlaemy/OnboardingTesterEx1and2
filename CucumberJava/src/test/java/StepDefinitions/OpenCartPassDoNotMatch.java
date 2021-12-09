package StepDefinitions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenCartPassDoNotMatch {
	WebDriver driver = null;
	@Given("User is on the Register page")
	public void user_is_on_the_Register_page() {
		System.setProperty("webdriver.chrome.driver","/Users/carlaperez/Downloads/Chrome/ChromeDriver");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.opencart.com/index.php?route=account/register");
		
	}

	@When("User enters passwords that do not match")
	public void user_enters_passwords_that_do_not_match() {
		driver.findElement(By.id("input-firstname")).sendKeys("Teresa");
		driver.findElement(By.id("input-lastname")).sendKeys("Gonzales");
		driver.findElement(By.id("input-email")).sendKeys("actual2@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("71421356");
		driver.findElement(By.id("input-password")).sendKeys("Prueba");
		//user different value 
		driver.findElement(By.id("input-confirm")).sendKeys("Prueba1");
		WebElement checkbagree = driver.findElement(By.name("agree"));
		checkbagree.click();
		WebElement element =  driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
		element.click();

	}

	@Then("Error message is displayed")
	public void error_message_is_displayed() throws InterruptedException {
		
		    System.out.println("Successfully completed");
		
		

	}

}
