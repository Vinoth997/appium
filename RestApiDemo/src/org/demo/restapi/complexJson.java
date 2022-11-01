package org.demo.restapi;

import org.testng.Assert;

import files.payload;
import io.restassured.path.json.JsonPath;

public class complexJson {

	public static void main(String[] args) {
		
		JsonPath jp = new JsonPath(payload.CoursePrice());
		
		//1.Print No of courses returned by API
		int count = jp.getInt("courses.size()");
		System.out.println(count);
		
		//2.Print purchase amount
		int purchaseamount = jp.getInt("dashboard.purchaseAmount");
		System.out.println(purchaseamount);
		
		//3.Print the title of the first course
		String title1 = jp.get("courses[0].title");
		System.out.println(title1);
		String title2 = jp.get("courses[2].title");
		System.out.println(title2);
		
		//4.Print all course titles and their repective prices
		for(int i=0;i<count;i++) {
			String courseTitles = jp.get("courses["+i+"].title");
			System.out.println(courseTitles);
			System.out.println(jp.get("courses["+i+"].price").toString());
		}
		
		//5.Print No of copies sold by RPA course
		for(int i=0;i<count;i++) {
			String courseTitl = jp.get("courses["+i+"].title");
			if(courseTitl.equalsIgnoreCase("RPA")) {
				int soldcopies = jp.get("courses["+i+"].copies");
				System.out.println("No of copies sold by RPA :"+soldcopies);
				break;
			}
		}
		
		//6.Verify if sum of all course prices matches with purchase amount
		int actualprice =0;
		int expectedprice = jp.getInt("dashboard.purchaseAmount");
		for(int i=0;i<count;i++) {
			int price = jp.get("courses["+i+"].price");
			int copies = jp.getInt("courses["+i+"].copies");
			int total = price*copies;
			System.out.println("Total :"+total);
			actualprice = actualprice + total;
			//System.out.println("s :"+actualprice);
		}
		System.out.println(actualprice);
		
		Assert.assertEquals(expectedprice, actualprice);
	}

}
 