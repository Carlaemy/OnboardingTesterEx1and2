package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyAccountOrderHistory {
	WebDriver driver = null;
	
	@Given("User is authenticated to the application")
	public void user_is_authenticated_to_the_application() {
		
		System.setProperty("webdriver.chrome.driver","/Users/carlaperez/Downloads/Chrome/ChromeDriver");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.opencart.com/index.php?route=account/register");
	    
	}

	@When("User navigates to the order page")
	public void user_navigates_to_the_order_page() {
		
		driver.findElement(By.id("input-firstname")).sendKeys("user1");
		driver.findElement(By.id("input-lastname")).sendKeys("lastname1");
		//use a new email
		driver.findElement(By.id("input-email")).sendKeys("seccion@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("71421356");
		driver.findElement(By.id("input-password")).sendKeys("Prueba");
		driver.findElement(By.id("input-confirm")).sendKeys("Prueba");
		WebElement checkbagree = driver.findElement(By.name("agree"));
		checkbagree.click();
		WebElement element =  driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
		element.click(); 
		driver.findElement(By.linkText("Continue")).click();
		WebElement history = driver.findElement(By.linkText("Modify your wish list"));
		history.click();
	  
	}

	@Then("A message should be displayed saying “You have not made any previous orders”")
	public void a_message_should_be_displayed_saying_You_have_not_made_any_previous_orders() throws InterruptedException {
		
		Thread.sleep(2000);
		WebElement msg=driver.findElement(By.xpath("//div[@class='col-sm-9']//p"));
		String text=msg.getText();
		if (msg.isEnabled() && text.contains("You have not made any previous orders!"))
		{ 
		    System.out.println("Successfully completed");
		}
		else
		{
			System.out.println("No Completed");
		}
	  
	}




}
