package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class CartTest {
	WebDriver driver;
	@Given("User has registered to TestMeApp")
	public void user_has_registered_to_TestMeApp() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		System.out.println("User is on TestMeApp Home Page");
		driver.findElement(By.linkText("SignIn")).click();
		driver.findElement(By.id("userName")).sendKeys("Lalitha");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.name("Login")).click();
	}

	@When("User searches for a particular product like Headphone")
	public void user_searches_for_a_particular_product_like_Headphone() {
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//span[contains(.,'All\n" + 
				"										Categories')]"))).click().pause(2000).perform();
		a.moveToElement(driver.findElement(By.xpath("//span[contains(.,'Electronics')]"))).click().pause(2000).perform();
		a.moveToElement(driver.findElement(By.xpath("//span[contains(.,'Head Phone')]"))).click().pause(2000).perform();
	}

	@When("Try to proceed to payment without adding any item in the cart")
	public void try_to_proceed_to_payment_without_adding_any_item_in_the_cart() {
	    String cart = driver.findElement(By.className("shop-menu")).getText();
	    System.out.println(cart);
	    Assert.assertFalse(cart.contains("Cart"));
	}

	@Then("TestMeApp doesnt display cart icon")
	public void testmeapp_doesnt_display_cart_icon() {
	    driver.findElement(By.xpath("//a[contains(@class,'btn btn-success btn-product')]")).click();
	    String cart = driver.findElement(By.className("shop-menu")).getText();
	    Assert.assertTrue(cart.contains("Cart"));
	    System.out.println(cart);
	}
}
