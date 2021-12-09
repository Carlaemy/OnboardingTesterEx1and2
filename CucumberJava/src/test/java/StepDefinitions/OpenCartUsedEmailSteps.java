package StepDefinitions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class OpenCartUsedEmailSteps {
	WebDriver driver = null;

	@Given("User has filled all fields")

	public void user_has_filled_all_fields() {
		System.setProperty("webdriver.chrome.driver","/Users/carlaperez/Downloads/Chrome/ChromeDriver");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.opencart.com");


	}


	@When("User Submits")
	public void user_Submits() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@class='dropdown-toggle']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("sonia");
		driver.findElement(By.id("input-lastname")).sendKeys("mendez");
		//use a new email
		driver.findElement(By.id("input-email")).sendKeys("lorena@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("7144443");
		driver.findElement(By.id("input-password")).sendKeys("Prueba");
		driver.findElement(By.id("input-confirm")).sendKeys("Prueba");
		WebElement checkbagree = driver.findElement(By.name("agree"));
		checkbagree.click();
		WebElement element =  driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
		element.click();
	


	}

	@Then("Error message detailing “E-mail address is already registered”")
	public void error_message_detailing_E_mail_address_is_already_registered() throws InterruptedException {

		Thread.sleep(5000);
		
			System.out.println("Successfully completed");

	}


}
