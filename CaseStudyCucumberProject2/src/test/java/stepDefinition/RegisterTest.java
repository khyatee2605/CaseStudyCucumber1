package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterTest {
	WebDriver driver;
	@Given("User is on TestMeApp Page")
	public void user_is_on_TestMeApp_Page() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		System.out.println("User is on Home Page");
	}

	@When("User enters {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string}")
	public void user_enters_and_and_and_and_and_and_and_and_and(String user, String fname, String lname, String pass, String cpass, String email, String phno, String dob, String address, String ans, io.cucumber.datatable.DataTable credentials) {
		List<String> data=credentials.asList();
		driver.findElement(By.partialLinkText("SignUp")).click();
		driver.findElement(By.id("userName")).sendKeys(data.get(0));
		driver.findElement(By.id("firstName")).sendKeys(data.get(1));
		driver.findElement(By.id("lastName")).sendKeys(data.get(2));
		driver.findElement(By.id("password")).sendKeys(data.get(3));
		driver.findElement(By.id("pass_confirmation")).sendKeys(data.get(4));
		driver.findElement(By.xpath("//input[contains(@value,'Female')]")).click();
		driver.findElement(By.id("emailAddress")).sendKeys(data.get(5));
		driver.findElement(By.id("mobileNumber")).sendKeys(data.get(6));
		driver.findElement(By.id("dob")).sendKeys(data.get(7));
		driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys(data.get(8));
		Select obj=new Select(driver.findElement(By.xpath("//select[@name='securityQuestion']")));
		obj.selectByIndex(0);
		driver.findElement(By.xpath("//input[@name='answer']")).sendKeys(data.get(9));
		

	}

	@Then("Select Register button")
	public void select_Register_button() {
		driver.findElement(By.xpath("//input[@name='Submit']")).submit();
	}

	@Then("Display Message Registered Successfully")
	public void display_Message_Registered_Successfully() {
		System.out.println("Registered Successfully");
	}
}
