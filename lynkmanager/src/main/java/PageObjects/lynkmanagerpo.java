package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class lynkmanagerpo {
	
	WebDriver driver;
	
	public lynkmanagerpo(WebDriver cdriver) {
		driver = cdriver;
		PageFactory.initElements(cdriver, this);
	}
	
	@FindBy(xpath = "//input[@type='email']")
	@CacheLookup
	WebElement email;
	
	@FindBy(xpath = "//input[@type='password']")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	@CacheLookup
	WebElement signInbtn;
	
	@FindBy(xpath = "//tr[@class='ng-star-inserted']")
	@CacheLookup
	WebElement list;
	
	@FindBy(xpath = "//button[@class='btn btn-alter btn-font-sm ng-star-inserted']")
	@CacheLookup
	WebElement addprogrambtn;
	
	@FindBy(xpath = "//input[@id='name-property']")
	@CacheLookup
	WebElement programname;
	
	@FindBy(xpath = "//input[@id='price-property']")
	@CacheLookup
	WebElement price;
	
	@FindBy(xpath = "//input[@id='apartmentsCount-property']")
	@CacheLookup
	  WebElement lotname;
	
	@FindBy(xpath = "//input[@formcontrolname='buildingPrice']")
	@CacheLookup
	WebElement noofbuildings;
	
	@FindBy(xpath = "(//button[@class='btn btn-brand btn-elevate kt-font-transform-u next-btn'])[2]")
	@CacheLookup
	WebElement savebtn;
	
	@FindBy(xpath = "//i[contains(@class,'btn btn-clean btn-sm btn-icon btn-icon-md')]")
	@CacheLookup
	WebElement closebtn;
	
	@FindBy(xpath ="//input[@id='generalSearch']")
	@CacheLookup
	WebElement searchbox;
	
	@FindBy(xpath ="//div[@class='property-name']//a")
	@CacheLookup
	WebElement programnameinlist;
	
	public void mailId(String mail) {
		WebDriverWait wait = new WebDriverWait(driver,99);
		wait.until(ExpectedConditions.visibilityOf(email));
		wait.until(ExpectedConditions.visibilityOf(email));
		email.sendKeys(mail);
	}
	
	public void passworD(String passwrd) {
		WebDriverWait wait = new WebDriverWait(driver,99);
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys(passwrd);
	}
	
	public void signIn() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,99);
		wait.until(ExpectedConditions.visibilityOf(signInbtn));
		signInbtn.click();
		Thread.sleep(5000);
	}
	
	public void listvalidate() {
		WebDriverWait wait = new WebDriverWait(driver,99);
		wait.until(ExpectedConditions.visibilityOf(list));
	}
	
	public void viewlist() {
		List<WebElement> lists =  driver.findElements(By.xpath("//tr[@class='ng-star-inserted']"));
		for(int i=0;i<lists.size();i++) {
			String listtxt = lists.get(i).getText();
			System.out.print(listtxt);
		}
	}
	
	public void addProgramBtn() {
		WebDriverWait wait = new WebDriverWait(driver,99);
		wait.until(ExpectedConditions.elementToBeClickable(addprogrambtn));
		addprogrambtn.click();
	}
	
	public void programName() {
		WebDriverWait wait = new WebDriverWait(driver,99);
		wait.until(ExpectedConditions.visibilityOf(programname));
		programname.sendKeys("New Program");
	}
	
	public void addPrice() {
		WebDriverWait wait = new WebDriverWait(driver,99);
		wait.until(ExpectedConditions.visibilityOf(price));
		price.sendKeys("200");
	}
	
	public void addLotname() {
		WebDriverWait wait = new WebDriverWait(driver,99);
		wait.until(ExpectedConditions.visibilityOf(lotname));
		lotname.sendKeys("30");;
	}
	
	public void noOfBuildings() {
		WebDriverWait wait = new WebDriverWait(driver,99);
		wait.until(ExpectedConditions.visibilityOf(noofbuildings));
		noofbuildings.sendKeys("100");
	}
	
	public void clickSaveBtn() {
		
		WebDriverWait wait = new WebDriverWait(driver,99);
		wait.until(ExpectedConditions.elementToBeClickable(savebtn));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", savebtn);
	}
	
	public void clickCloseBtn() {
		WebDriverWait wait = new WebDriverWait(driver,99);
		wait.until(ExpectedConditions.elementToBeClickable(closebtn));
		closebtn.click();
	}
	
	public void searchBox() {
		searchbox.sendKeys("New Program");
	}
	
	public void clickEnter() {
		searchbox.sendKeys(Keys.RETURN);
	}
	
	public void programNameinList(String actualname,String expectedname) {
		WebDriverWait wait = new WebDriverWait(driver,99);
		wait.until(ExpectedConditions.visibilityOf(programnameinlist));		
		actualname = "New Program";
		expectedname = programnameinlist.getText();
	}


	
}