package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchTest {
	WebDriver driver;
	@Given("User is logged in")
	public void user_is_logged_in() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		System.out.println("User is on Home Page");
	}

	@When("user enters four characters on search page")
	public void user_enters_four_characters_on_search_page() {
		WebElement search= driver.findElement(By.xpath("//input[@type='text']"));
		  
		  Actions act=new Actions(driver);
		  act.click(search).sendKeys("h").pause(2000).sendKeys("e").pause(2000).sendKeys("a").pause(2000).sendKeys("d").perform();
		  
		  
	}

	@Then("Product should be displayed in the drop down")
	public void product_should_be_displayed_in_the_drop_down() {
		String text=driver.findElement(By.xpath("//*[@id=\"myInputautocomplete-list\"]/div")).getText();
		System.out.println(text);
		Assert.assertTrue(text.contains("Head"));
	}
}
