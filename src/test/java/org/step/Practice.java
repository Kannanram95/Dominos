package org.step;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.base.BaseClass;
import org.pom.DomPo;

public class Practice extends BaseClass{
	public static void main(String[] args) throws InterruptedException {
		toChromelaunch();
		tolaunchUrl("https://www.dominos.co.in/");
		DomPo dom = new DomPo();
	//	WebElement w = driver.findElement(By.xpath("//button[text()='ORDER ONLINE NOW']"));
	//	w.click();
		toClick(dom.btnOrderOnline);
		toClick(dom.selectAddr);
		implicitWait();
		tofillText(dom.enterAddr,"600100");
		Thread.sleep(Duration.ofSeconds(5));
		implicitWait();
		toClick(dom.locSuggest);
		Thread.sleep(Duration.ofSeconds(2));
		implicitWait();
		implicitWait();
		toClick(dom.dontloc);
		implicitWait();
		toScrollDown(dom.category("Veg Pizza"));
		implicitWait();
		toClick(dom.prodSelect("Veg Pizza","Farmhouse"));
		implicitWait();
		toClick(dom.noThanks);
		implicitWait();
		int ratefarm = get(dom.getrate("Farmhouse"));
		toClick(dom.qtyalter("Farmhouse","increase"));
		int qtyfarm = get(dom.getqty("Farmhouse"));
		toClick(dom.prodSelect("Veg Pizza","Margherita"));
		implicitWait();
		int rateMarg = get(dom.getrate("Margherita"));
		toClick(dom.qtyalter("Margherita","increase"));
		int qtyMarg = get(dom.getqty("Margherita"));
		toClick(dom.prodSelect("Veg Pizza","Peppy Paneer"));
		implicitWait();
		int ratepaneer = get(dom.getrate("Peppy Paneer"));
		toScrollDown(dom.qtyalter("Peppy Paneer","increase"));
		implicitWait();
		toClick(dom.qtyalter("Peppy Paneer","increase"));
		int qtypaneer = get(dom.getqty("Peppy Paneer"));
		int farm = qtyfarm*ratefarm;
		int marg = qtyMarg*rateMarg;
		int pepp = qtypaneer*ratepaneer;
		int total = farm + marg + pepp;
		System.out.println(ratefarm);
		System.out.println(qtyfarm);
		System.out.println(rateMarg);
		System.out.println(qtyMarg);
		System.out.println(ratepaneer);
		System.out.println(qtypaneer);
		toClick(dom.chkout);
		implicitWait();
		//String s = driver.findElement(dom.subTotal).getText();
		//s.replace("\"", "");
		//int subTotal = (int)Float.parseFloat(s);
		//System.out.println(subTotal);
		int subTotal ;
		subTotal= get(dom.subTotal);
		assertTrue("It is not equal",subTotal == total);
		implicitWait();
		// Adding Beverage
		toClick(dom.expMenu);
		implicitWait();
		toScrollDown(dom.category("Beverages"));
		toClick(dom.prodSelect("Beverages","Pepsi 475ml"));
		int peprate = get(dom.getrate("Pepsi 475ml"));
		System.out.println(peprate);
		toScrollDown(dom.qtyalter("Pepsi 475ml","increase"));
		while(get(dom.getqty("Pepsi 475ml"))<12) {
			toClick(dom.qtyalter("Pepsi 475ml","increase"));
		}
		int pepqty = get(dom.getqty("Pepsi 475ml"));
		int pepsi = peprate*pepqty;
		total = total + pepsi;
		toClick(dom.chkout);
		implicitWait();
		subTotal = get(dom.subTotal);
		try {
		assertEquals(subTotal, total);
		}catch(AssertionError e) {
			System.out.println("It is not equal");
		}
		toClick(dom.expMenu);
		implicitWait();
		toScrollDown(dom.qtyalter("Margherita","increase"));
		toClick(dom.qtyalter("Margherita","decrease"));
		qtyMarg = get(dom.getqty("Margherita"));
		toScrollDown(dom.qtyalter("Pepsi 475ml","increase"));
		while(get(dom.getqty("Pepsi 475ml"))>6) {
			toClick(dom.qtyalter("Pepsi 475ml","decrease"));
		}
		pepqty = get(dom.getqty("Pepsi 475ml"));
		pepsi = peprate*pepqty;
		marg = qtyMarg*rateMarg;
		total = marg+farm+pepp+pepsi;
		
		toClick(dom.chkout);
		implicitWait();
		subTotal = get(dom.subTotal);
		try {
		assertEquals(subTotal, total);
		}catch(AssertionError e) {
			System.out.println("It is not equal");
		}
		
		
		
		
}
}
	
