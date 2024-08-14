package Steps;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.service.DriverFinder;
import org.openqa.selenium.support.ui.Select;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchFunctionality {
	
	WebDriver driver;
	
	//Navigate to the eBay website.
	@Given("Open browser, enter ebay url")
	public void open_browser_enter_ebay_url() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
	}

	//Access Advanced Search
	@Given("select the Advanced link")
	public void select_the_advanced_link() {
		driver.findElement(By.linkText("Advanced")).click();
	  
	}
	//Fill details
	@When("user enter all the details in advanced search")
	public void user_enter_all_the_details_in_advanced_search() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.cssSelector("[data-marko-key=\"@input s0-1-17-4[0]-5[0]\"]")).sendKeys("shoes adidas");
		WebElement dropdown = driver.findElement(By.cssSelector("[aria-label=\"Keyword options\"]"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Exact words, exact order");
		
		driver.findElement(By.cssSelector("[data-marko-key='@input s0-1-17-4[0]-5[2]']")).sendKeys("adidas, S, L, M");
		WebElement dropdown1 = driver.findElement(By.cssSelector("[data-testid=\"s0-1-17-4[0]-7[3]-_sacat\"]"));
		Select s = new Select(dropdown1);
		s.selectByVisibleText("Collectibles");
		
	}
	// Using advanced search option link
	//Assert customer service
	@When("click on using advanced search option")
	public void click_on_using_advanced_search_option() {
		String parentid = driver.getWindowHandle();
		driver.findElement(By.linkText("using advanced search options")).click();
		//String parentid = driver.getWindowHandle();
		
		// due to capta this test should not be assert
		//String actualteext = driver.findElement(By.xpath("//td[@id=\"gh-title\"][h2]")).getText();
		//String expectedtext = "Customer Service";
		//org.testng.Assert.assertEquals(actualteext, expectedtext);
		driver.switchTo().window(parentid);
	   
	}

	//Enter the search details
	@Then("Enter the input")
	public void enter_the_input() {
		driver.findElement(By.xpath("(//input[@name=\"s0-1-17-6[4]\"])[3]")).click();
		driver.findElement(By.cssSelector("[data-testid=\"s0-1-17-5[5]-[1]-LH_RPA\"]")).click();
		driver.findElement(By.cssSelector("[id=\"s0-1-17-5[5]-[0]-LH_FR\"]")).click();
		driver.findElement(By.cssSelector("[data-testid=\"s0-1-17-5[5]-[2]-LH_AS\"]")).click();
		driver.findElement(By.cssSelector("[data-testid=\"s0-1-17-5[5]-[3]-LH_Savings\"]")).click();
		driver.findElement(By.cssSelector("[data-testid=\"s0-1-17-5[5]-[4]-LH_SaleItems\"]")).click();
		driver.findElement(By.cssSelector("[data-testid=\"s0-1-17-5[5]-[5]-LH_Lots\"]")).click();
		driver.findElement(By.cssSelector("[data-testid=\"s0-1-17-5[5]-[6]-LH_Charity\"]")).click();
		driver.findElement(By.cssSelector("[data-testid=\"s0-1-17-5[5]-[7]-LH_AV\"]")).click();
		driver.findElement(By.cssSelector("[data-testid=\"s0-1-17-5[5]-[8]-LH_Time\"]")).click();
		driver.findElement(By.cssSelector("[data-testid=\"s0-1-17-5[5]-[9]-LH_NOB\"]")).click();
		driver.findElement(By.cssSelector("[data-testid=\"s0-1-17-5[5]-[10]-LH_MIL\"]")).click();
		driver.findElement(By.cssSelector("[data-testid=\"s0-1-17-5[6]-[1]-LH_LPickup\"]")).click();
		
		driver.findElement(By.cssSelector("[data-marko-key=\"@input s0-1-17-7[8]-9[0[@adv-seller]]\"]")).sendKeys("Ambani");
		
		WebElement sortBy = driver.findElement(By.cssSelector("[data-testid=\"s0-1-17-8[9]-1[0]-_sop\"]"));
		Select sB = new Select(sortBy);
		sB.selectByVisibleText("Time: newly listed");
		
		WebElement viewResult = driver.findElement(By.cssSelector("[data-testid=\"s0-1-17-8[9]-1[1]-_dmd\"]"));
		Select Vr = new Select(viewResult);
		Vr.selectByVisibleText("List view");
		
		WebElement rpp = driver.findElement(By.cssSelector("[data-testid=\"s0-1-17-8[9]-1[2]-_ipg\"]"));
		Select rp = new Select(rpp);
		rp.selectByVisibleText("120");
	}
	
	//Enter search button
	@Then("click on search button")
	public void click_on_search_button() {
		driver.findElement(By.xpath("(//button[@class=\"btn btn--primary\"])[2]")).click();
	   
	}

	//Assert No exact match found
	@Then("assert search result")
	public void assert_search_result() {
		String acceptText1 = driver.findElement(By.cssSelector("[class=\"srp-save-null-search__heading\"]")).getText();
		String expectedR = "No exact matches found";
		assertEquals(acceptText1, expectedR);
		
		driver.close();
	  
	}

}
