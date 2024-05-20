package stepDefintion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSteps {
	WebDriver driver; //instance of WebDriver
	
	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
		
		WebDriverManager.edgedriver().setup();
		//WebDriverManager.chromedriver().setup();
		
		driver = new EdgeDriver(); // browser will open
		//driver = new ChromeDriver();
		
		driver.manage().window().maximize(); // screen gets maximize
		
		driver.get("https://practicetestautomation.com/practice-test-login/");//is my practice website
		//driver.get("https://www.google.com");

	}

	@When("user enters valid username and password")
	public void user_enters_valid_username_and_password() {
		
		driver.findElement(By.xpath("//*[@ name='username']")).sendKeys("student");	// input values in the text box	
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("Password123");			
		
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		driver.findElement(By.xpath("//*[@id='submit']")).click();  // clicking the button

	
	}

	@Then("user is navigated to the dashboard page")
	public void user_is_navigated_to_the_dashboard_page() {
		
		String expectedResult = "https://practicetestautomation.com/logged-in-successfully/"; //expected URL
		String actualUrl = driver.getCurrentUrl();     //actual URL
		Assert.assertEquals(actualUrl, expectedResult, "Not matching"); // validating with TestNG class.method(expected,current,indication ifit failed) 
	    
	    //driver.quit();
		driver.close();
	}

}
