package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class amazonSteps {

	WebDriver driver = new ChromeDriver();
	
	@Given("User goes to Website")
	public void user_goes_to_website() {
		System.out.println("I'm in Given");
		
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		System.out.println(driver.getTitle());
		//driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
	}

	@SuppressWarnings("deprecation")
	@When("Go to cart menu on main landing page")
	public void go_to_cart_menu_on_main_landing_page() {
		System.out.println("I'm in When");
		//*[@id="nav-cart-count-container"]
		driver.findElement(By.xpath("//*[@id='nav-cart-count-container']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Then("Print the title of page")
	public void print_the_title_of_page() {
		System.out.println("I'm in Then");
		System.out.println(driver.getTitle());
		driver.quit();
	}
}
