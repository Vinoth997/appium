package testclass;

import java.util.Date;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BaseClass.Base;
import mainclass.demofirst;

public class demofirsttest extends Base{
	demofirst df;
	@BeforeTest
	public void open() {
		Date d = new Date();
		BrowserOpen("https://demoqa.com/");
		df = new demofirst(driver);
		System.out.println("Session Started");
		System.out.println(d);
	}
		
	@Test(priority = 0)
	public void elementlist() throws InterruptedException {
		df.elements();
	}
	
	@Test(priority = 1)
	public void textvalidate() throws InterruptedException {
		df.textboxValidation();
	}
	
	@Test(priority = 2)
	public void assertText() {
		df.addressValidation();
	}
	
	@Test(priority = 3)
	public void checkBox() throws InterruptedException {
		df.checkboxValidation();
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("Session Ended");
		Date d = new Date();
		System.out.println(d);
		//driver.close();
	}
}
