package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyAccountPageDisplays {
	
	WebDriver driver = null;
	
	@Given("I am logged to the page")
	public void i_am_logged_to_the_page()  {
	

			System.setProperty("webdriver.chrome.driver","/Users/carlaperez/Downloads/Chrome/ChromeDriver");
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://demo.opencart.com/index.php?route=account/login");
			driver.findElement(By.id("input-email")).sendKeys("pamela@gmail.com");
			driver.findElement(By.id("input-password")).sendKeys("Prueba");
			
	}
		
		@When("the page opens")
		public void the_page_opens() throws InterruptedException {
			Thread.sleep(1000);
			WebElement login = driver.findElement(By.cssSelector("input[class='btn btn-primary']"));
			login.click();
		}

	@Then("the correct title and options on the menu should be displayed")
	public void the_correct_title_and_options_on_the_menu_should_be_displayed() {
		
		driver.findElement(By.linkText("Your Store")).isDisplayed();
		driver.findElement(By.linkText("Edit your account information")).isDisplayed();
		driver.findElement(By.linkText("Change your password")).isDisplayed();
		driver.findElement(By.linkText("Modify your address book entries")).isDisplayed();
		driver.findElement(By.linkText("Modify your wish list")).isDisplayed();
		System.out.println("Sucessfully Completed");
	}

}
