package StepDefinitions;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OpenCartInvalidEmail {
	WebDriver driver = null;
	@Given("User fills an invalid email")
	public void user_fills_an_invalid_email() {

		System.setProperty("webdriver.chrome.driver","/Users/carlaperez/Downloads/Chrome/ChromeDriver");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.opencart.com/index.php?route=account/register");
	}


	@When("User submits the changes")
	public void user_submits_the_changes() {
		driver.findElement(By.id("input-firstname")).sendKeys("Teresa");
		driver.findElement(By.id("input-lastname")).sendKeys("Gonzales");
		//enter an invalid email without .
		WebElement Email =driver.findElement(By.id("input@emailcom"));
		Email.sendKeys ("teg.com");
		driver.findElement(By.id("input-telephone")).sendKeys("71421356");
		driver.findElement(By.id("input-password")).sendKeys("Prueba");
		driver.findElement(By.id("input-confirm")).sendKeys("Prueba");
		WebElement checkbagree = driver.findElement(By.name("agree"));
		checkbagree.click();
		WebElement element =  driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
		element.click();	

	}
	
	@Then("Error message detailing “Please include an @ in the e-mail address”")
	public void error_message_detailing_Please_include_an_in_the_e_mail_address() throws InterruptedException {
		
		    System.out.println("Successfully completed");
		

	}












}
