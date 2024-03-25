package cucumberpkg;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignIn {
	WebDriver driver;
    Object[][] loginData;
    int currentRow = 0;
	
	@Given("User is on the login page with valid credentials from Excel")
	public void user_is_on_the_login_page_with_valid_credentials_from_excel() throws IOException {
		loginData = ReadExcel.readData("D:\\\\WorldLine\\\\Softaware Testing\\\\TestData.xlsx", "Sheet1");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vinod\\eclipse-workspace\\Task4\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/login");
        String username = (String) loginData[currentRow][0];
        String password = (String) loginData[currentRow][1];
        driver.findElement(By.id("Email")).sendKeys(username);
        driver.findElement(By.id("Password")).sendKeys(password);
	}
	
	
	@When("User enters username and password")
	public void user_enters_username_and_password() throws IOException {
		Object[][] data = ReadExcel.readData("D:\\WorldLine\\Softaware Testing\\Task 4\\TestData.xlsx\"", "Sheet1");
        String username = (String) data[0][0];
        String password = (String) data[0][1];

        driver.findElement(By.id("Email")).sendKeys(username);
        driver.findElement(By.id("Password")).sendKeys(password);
	}
	
	@Then("User clicks on login button")
	public void user_clicks_on_login_button() {
		driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
	}
	
	@Then("User should be logged in")
	public void user_should_be_logged_in() throws InterruptedException {
		Thread.sleep(5000);
		  
		WebElement account = driver.findElement(By.xpath("//a[normalize-space()='Log out']"));
        Assert.assertTrue(account.isDisplayed(), "Login unsuccessful");
	}

}
