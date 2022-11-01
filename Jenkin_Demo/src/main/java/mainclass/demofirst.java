package mainclass;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import BaseClass.Base;

public class demofirst extends Base{
	
	public demofirst(WebDriver driver) {
		this.driver = driver;
	}
	
	public void elements() throws InterruptedException {
		 Thread.sleep(4000);
		 scrollDown(driver);
		 btnclick(findByXpath("//h5[text()='Elements']"));
		 List<WebElement> elementList = listByXpath("//div[@class='element-list collapse show']//span");
		 for(int i = 0; i < elementList.size(); i++) {
			 String elelist = elementList.get(i).getText();
			 System.out.println("Element List : "+elelist);
			 if(elelist.equalsIgnoreCase("Text Box")) {
				 elementList.get(i).click();
			 }
		 }
	 }
	 
	 public void textboxValidation() throws InterruptedException {
		 Thread.sleep(3000);
		 findByCss("#userName").sendKeys("Varma");
		 findByCss("#userEmail").sendKeys("toolsqa@gmail.com");
		 findByCss("#currentAddress").sendKeys("current address");
		 findByCss("#permanentAddress").sendKeys("Permanant Address");
		 Thread.sleep(3000);
		 scrollDown(driver);
		 WebElement submit = findByCss(".btn.btn-primary");
		 waitforelementTobeClickable(driver, submit);
		 btnclick(submit);
	 }
	 
	 
	 public void addressValidation() {
		 String expected = "Name:Varma";
		 String actual = findByCss("#name.mb-1").getText();
		 assertEquals(actual, expected);
	 }
	 
	 
	 public void checkboxValidation() throws InterruptedException {
		 Thread.sleep(3000);
		 scrollUp(driver);
		 WebElement chkbox = findByXpath("(//li[@id='item-1'])[1]");
		 Thread.sleep(3000);
		 btnclick(chkbox);
		 WebElement chkboxbtn = findByCss(".rct-text>button");
		 waitForElementTobeVisible(driver, chkboxbtn);
		 chkboxbtn.click();
		 Thread.sleep(3000);
		 btnclick(findByXpath("//label[@for='tree-node-desktop']//span[@class='rct-checkbox']"));
		 btnclick(findByXpath("(//span[@class='rct-checkbox'])[4]"));
	 }
	 
		 
}

