package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyAccountWithoutWishList {
	WebDriver driver = null;
	@Given("User is new and logged")
	public void user_is_new_and_logged() {
		
		System.setProperty("webdriver.chrome.driver","/Users/carlaperez/Downloads/Chrome/ChromeDriver");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.opencart.com/index.php?route=account/register");
	}
	   

	@When("User navigates to wishlist page")
	public void user_navigates_to_wishlist_page() {
		
		driver.findElement(By.id("input-firstname")).sendKeys("user1");
		driver.findElement(By.id("input-lastname")).sendKeys("lastname1");
		//use a new email
		driver.findElement(By.id("input-email")).sendKeys("pedro@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("71421356");
		driver.findElement(By.id("input-password")).sendKeys("Prueba");
		driver.findElement(By.id("input-confirm")).sendKeys("Prueba");
		WebElement checkbagree = driver.findElement(By.name("agree"));
		checkbagree.click();
		WebElement element =  driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
		element.click(); 
		driver.findElement(By.linkText("Continue")).click();
		WebElement wish = driver.findElement(By.linkText("Modify your wish list"));
		wish.click();
	}

	@Then("Message detailing “Your wish list is empty”")
	public void message_detailing_Your_wish_list_is_empty() throws InterruptedException {

		Thread.sleep(5000);
		WebElement msg=driver.findElement(By.xpath("//div[@class='col-sm-9']//p"));
		String text=msg.getText();
		if (msg.isEnabled() && text.contains("Your wish list is empty."))
		{ 
		    System.out.println("Successfully completed");
		}
		else
		{
			System.out.println("No Completed");
		}
}
}
