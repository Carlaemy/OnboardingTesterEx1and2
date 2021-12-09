package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyAccountSubscribe {

	WebDriver driver = null;
	@Given("User is on the Edit information page")
	public void user_is_on_the_Edit_information_page() throws InterruptedException {


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
		WebElement subscribe = driver.findElement(By.linkText("Subscribe / unsubscribe to newsletter"));
		subscribe.click();

	}

	@When("User enables the subscribe option")
	public void user_enables_the_subscribe_option() {
		
		WebElement checkBoxElement = driver.findElement(By.xpath("//label[@class='radio-inline'][normalize-space()='Yes']/input[@name='newsletter']"));
		boolean isSelected = checkBoxElement.isSelected();		
		//performing click operation if element is not checked
		if(isSelected == false) {
			checkBoxElement.click();
			
		WebElement button =  driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
		button.click();
		}
		
		else {
		WebElement checkBoxElement2 = driver.findElement(By.xpath("//label[@class='radio-inline'][normalize-space()='No']/input[@name='newsletter']"));
	
		checkBoxElement2.click();
		WebElement button =  driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
		button.click();
		
		}
		
			
		}
	
	@Then("The changes should be saved")
	public void the_changes_should_be_saved() {
		
		WebElement msg=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']/i[@class='fa fa-check-circle']"));
		String text=msg.getText();
		if (msg.isEnabled() && text.contains("Success: Your newsletter subscription has been successfully updated!"))
		{ 
		    System.out.println("Successfully completed");
		}
		else
		{
			System.out.println("No Completed");
		}
		

	}



}
