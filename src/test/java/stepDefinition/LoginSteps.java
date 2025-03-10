package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	WebDriver d;
	@Given("I am on the login page")
	public void i_am_on_the_login_page() {

		d=new ChromeDriver();
		d.get("https://opensource-demo.orangehrmlive.com");
		//throw new io.cucumber.java.PendingException();
	}
	@When("I enter valid credentials")
	public void i_enter_valid_credentials() throws InterruptedException {
		
		Thread.sleep(3000);
		d.findElement(By.name("username")).sendKeys("Admin");
		Thread.sleep(3000);
		d.findElement(By.name("password")).sendKeys("admin123");
		Thread.sleep(3000);
		//throw new io.cucumber.java.PendingException();
	}
	@When("I click on the login button")
	public void i_click_on_the_login_button() {
		d.findElement(By.className("orangehrm-login-button")).click();
		//d.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]")).click();
		//throw new io.cucumber.java.PendingException();
	}
	@Then("I should be redirected to the dashboard")
	public void i_should_be_redirected_to_the_dashboard() throws InterruptedException {
		
		Thread.sleep(5000);
		String actualURL = d.getCurrentUrl();
		String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		Assert.assertEquals(actualURL, expectedURL);
		//throw new io.cucumber.java.PendingException();

//		Thread.sleep(5000);
//		d.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/div/form/div[1]/div/div[2]/input"));
		//throw new io.cucumber.java.PendingException();
		
	}
	@After
    public void Close() throws InterruptedException {
		Thread.sleep(2000);
        d.quit();
    }
	
	

}