package steps;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {
	
	WebDriver driver;
	
	By loginUserBtn = By.xpath("//span[text()='Login']/ancestor::button");
	By userNameTextField = By.xpath("//input[@formcontrolname='username']");
	By passwordTextField = By.xpath("//input[@formcontrolname='password']");
	By loginBtn = By.xpath("(//span[text()='Login']/ancestor::button)[last()]");
	By pageTitle = By.xpath("//div[@class='brand-title']");
	By profileName = By.xpath("//button[contains(@class,'mat-focus-indicator mat-menu-trigger')]/span[1]");
	By alertMessage = By.xpath("//mat-error[@role='alert']");
	By bookTitle = By.xpath("//div[@class='card-title']/..//strong");

	@Given("I navigates to the Bookcart application")
	public void iNavigatesToTheBookcartApplication() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		Options manage = driver.manage();
		manage.window().maximize();
		driver.get("https://bookcart.azurewebsites.net/");
		manage.timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		System.out.println((driver.getTitle()));
	}

	@Given("I click on login user")
	public void iClickOnLoginUser() {
		 driver.findElement(loginUserBtn).click();		 
	}

	@Given("I enter the {string} and {string}")
	public void iEnterTheUsernameAndPassword(String userName, String password) throws InterruptedException {
		 driver.findElement(userNameTextField).sendKeys(userName);
		 Thread.sleep(4000);
		 driver.findElement(passwordTextField).sendKeys(password);
		 Thread.sleep(4000);
	}

	@When("I click on login button")
	public void iClickOnLoginButton() {
		 driver.findElement(loginBtn).click();		 
	}

	@Then("Login should be successful")
	public void loginShouldBeSuccessful() {
		 boolean value = driver.findElement(pageTitle).isDisplayed();
		 Assert.assertTrue(value);
	}
	
	@Then("I verify the profile name as {string}")
	public void verifyProfileName(String expectedProfileName) {
		String actualProfileName = driver.findElement(profileName).getText();
		boolean verifyProfileName = actualProfileName.contains(expectedProfileName);
		Assert.assertTrue(verifyProfileName);
	}
	
	@Given("I enter wrong {string} and {string}")
	public void iEnterWrongUsernameAndPassword(String userName, String password) throws InterruptedException {
		 driver.findElement(userNameTextField).sendKeys(userName);
		 Thread.sleep(4000);
		 driver.findElement(passwordTextField).sendKeys(password);
		 Thread.sleep(4000);
	}
	
	@Then("Login should fail")
	public void loginShouldFail() {
		boolean value = driver.findElement(alertMessage).isDisplayed();
		Assert.assertTrue(value);
		
	}
	
	@Then("I verify the error message contains {string}")
	public void verifyErrorMessage(String expectedErrorMessage) {
		String actualErrorMessage = driver.findElement(alertMessage).getText();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
//		boolean verifyErrorMessage = expectedErrorMessage.contains(actualErrorMessage);
//		Assert.assertTrue(verifyErrorMessage);
		driver.quit();
	}
	
	@Then("I can see list of books available")
	public void listOfBooks() {
		List<WebElement> booklist = driver.findElements(bookTitle);
		for(int i=0;i<booklist.size();i++) {
			String bookList = booklist.get(i).getText();
			System.out.println(bookList);
		}		
	}
	
	@Then("I close the browser")
	public void closeBrowser() {
		driver.quit();
	}

}
