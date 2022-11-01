package BaseClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	protected WebDriver driver;
	
	@SuppressWarnings("deprecation")
	public WebDriver BrowserOpen(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		return driver;
	}
	
	public static void scrollUp(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-200)");
	}
	
	public static void scrollDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,350)");
	}
	
	public static void waitforelementTobeClickable(WebDriver driver,WebElement element) {
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver,99);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void waitForElementTobeVisible(WebDriver driver,WebElement element) {
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver,99);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForClick(By  locator) {
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver,90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void assertEquals(String actual,String expected) {
		Assert.assertEquals(actual,expected);
	}
	
	public WebElement findById(String data) {
		WebElement byid = driver.findElement(By.id(data));
		return byid;
	}
	
	public  WebElement findByXpath(String data) {
		WebElement byxpath = driver.findElement(By.xpath(data));
		return byxpath;
	}
	
	public  List<WebElement> listByXpath(String data) {
		List<WebElement> byxpath = driver.findElements(By.xpath(data));
		return byxpath;
	}
	
	public WebElement findByCss(String data) {
		WebElement bycss = driver.findElement(By.cssSelector(data));
		return bycss;
	}
	
	public static void btnclick(WebElement element) {
		element.click();
	}
}
