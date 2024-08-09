package org.pom;

import org.openqa.selenium.By;

public class DomPo {
	public String s;
	//main page
	public By btnOrderOnline = By.xpath("//button[text()='ORDER ONLINE NOW']");  // order online button
	//address page
	public By selectAddr = By.xpath("//input[@placeholder='Enter your delivery address']"); // delivery address button
	public By enterAddr = By.xpath("//input[@placeholder='Enter Area / Locality']"); 
	public By locSuggest = By.xpath("//div[@class = 'sc-fBuWsC eMOfwp']/ul/li[1]");
	public By dontloc = By.xpath("//button[@onclick='moeRemoveBanner()']");
	//menu page
	public By noThanks = By.xpath("//div[@data-label='add extra cheese']//button[@data-label='Add button']");
	public By chkout = By.xpath("//button[@data-label='miniCartCheckout']");
	//checkout page
	public By subTotal = By.xpath("//span[@data-label='total-minicart']");
	public By expMenu = By.xpath("//button[@datalabel='Explore Menu']");
	
	// menu page
	public By category(String s) {
		By prod = By.xpath("//div[text()='"+s.toUpperCase()+"']");
		return prod;
	}
	
	
	public By prodSelect(String s,String s1) {
			By prod = By.xpath("//div[@data-label='"+s+"']//div[@data-label='"+s1+"']//button[@data-label='addTocart']");
			return prod;
		
		}
	
	public By qtyalter(String s, String s1) {
		By inc = By.xpath("//div[@class='menu-right']//span[text()='"+s+"']/../../..//div[@data-label='"+s1+"']");
		return inc;
	}
	
	public By getrate(String s) {
		By rate = By.xpath("//div[@data-label='"+s+"']//span[@class='rupee']");
		return rate;
	}
	
	public By getqty(String s) {
		By qty = By.xpath("//div[@class='menu-right']//span[text()='"+s+"']/../../..//span[@class='cntr-val']");
		return qty;
	}
}