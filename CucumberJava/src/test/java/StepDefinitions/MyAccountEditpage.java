package StepDefinitions;



import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyAccountEditpage {
	WebDriver driver = null;
	
	@Given("User is logged into the application")
	public void user_is_logged_into_the_application() throws InterruptedException {
		
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

	@When("User updates the account information from the Edit page")
	public void user_updates_the_account_information_from_the_Edit_page() {
		WebElement firstname = driver.findElement(By.id("input-firstname"));
		firstname.clear();
		firstname.sendKeys("pamela1");
		WebElement lastname =driver.findElement(By.id("input-lastname"));
		lastname.clear();
		lastname.sendKeys("rojas1");
		WebElement element =  driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
		element.click(); 

	   
	}

	@Then("Friendly message detailing “Success: Your account has been successfully updated”")
	public void friendly_message_detailing_Success_Your_account_has_been_successfully_updated() throws InterruptedException {
		Thread.sleep(5000);
		
		WebElement msg=driver.findElement(By.xpath("//i[@class='fa fa-check-circle']"));
		String text=msg.getText();
	      
		if (msg.isDisplayed() && text.contains("Success: Your account has been successfully updated."))
		{ 
		    System.out.println("Successfully completed");
		}
		else
		{
			System.out.println("No Completed");
		}

	}

}
