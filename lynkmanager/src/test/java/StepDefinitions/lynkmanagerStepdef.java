package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.lynkmanagerpo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class lynkmanagerStepdef {
	static WebDriver driver;
	lynkmanagerpo lkm;
	@Given("User open LynkManager url {string} in browser")
	public void user_open_lynk_manager_url_in_browser(String url) {
	    //WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    lkm =  new lynkmanagerpo(driver);
	    driver.get(url);
	   
	}
	
	@Given("Wait for login page.")
	public void wait_for_login_page() {
	    String expectedtitle = "Lynk Manager - Admin";
		String actualtitle = driver.getTitle();
	    System.out.println(actualtitle);
	    Assert.assertEquals(expectedtitle, actualtitle);
	}

	@When("User enter mailid {string} and password {string}")
	public void user_enter_mailid_and_password(String mail, String password) {
		lkm.mailId(mail);
	    lkm.passworD(password);
	}

	@When("Click on SignIn button")
	public void click_on_sign_in_button() throws InterruptedException {
	    lkm.signIn();
	}

	@Then("User should navigate to homepage")
	public void user_should_navigate_to_homepage() {
	    lkm.listvalidate();
	}
	
	@Then("Validate the list of programs")
	public void validate_the_list_of_programs() {
	    lkm.viewlist();
	}
	
	
	@Given("User click addprogram button")
	public void user_click_addprogram_button() {
		lkm =  new lynkmanagerpo(driver); 
		lkm.addProgramBtn();
	}

	@And("User enters the program name")
	public void user_enters_the_program_name() {
		lkm = new lynkmanagerpo(driver);
		lkm.programName();
	}
	
	@And("Enter the Price")
	public void enter_the_price() {
	    lkm.addPrice();
	}

	@And("Enter the lots number")
	public void enter_the_lots_number() {
		lkm.addLotname();
	}

	@And("Enter number of buildings")
	public void enter_number_of_buildings() {
	    lkm.noOfBuildings();
	}
	
	@Then("Click save\\(safe guard) button")
	public void click_save_safe_guard_button() {
	   lkm.clickSaveBtn();
	}

	@Then("Click close\\(X) button")
	public void click_close_x_button() {
	   lkm.clickCloseBtn();
	}
	
	@Given("User enter program name in search box")
	public void user_enter_program_name_in_search_box() {
	    lkm = new lynkmanagerpo(driver);
		lkm.searchBox();
	}

	@Given("Click Enter key")
	public void click_enter_key() {
	    lkm.clickEnter();
	}

	@Then("Program list should be displayed")
	public void program_list_should_be_displayed() {
	    String actualname = null;
		String expectedname = null;
		lkm.programNameinList(actualname, expectedname);
	    Assert.assertEquals(actualname,expectedname);
	}
}
