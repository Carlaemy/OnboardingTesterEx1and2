package StepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class OpenCartReqFieldsSteps {
	WebDriver driver = null;

	@Given("User is on the register page")
	public void user_is_on_the_register_page() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/carlaperez/Downloads/Chrome/ChromeDriver");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.opencart.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@class='dropdown-toggle']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Register")).click();

	}

	@When("User submits")
	public void user_submits() {

	}

	@Then("Error messages should be displayed on the fields")
	public void error_messages_should_be_displayed_on_the_fields() throws InterruptedException {
		Thread.sleep(2000);

		WebElement checkbagree = driver.findElement(By.name("agree"));
		checkbagree.click();
		WebElement element =  driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
		element.click();
		
		    System.out.println("Successfully completed");
		
			
		


	}



}
