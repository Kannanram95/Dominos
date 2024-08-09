package org.base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class BaseClass {
	public static WebDriver driver;
	public static Actions ac;
	
	public static void toChromelaunch() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public static void toEdgelaunch() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
	}
	
	public static void tolaunchUrl(String s) {
		driver.get(s);
	}
	
	public static void toClick(By b) {
		driver.findElement(b).click();
	}
	
	public static void tofillText(By b,String s) throws InterruptedException {
		for(char c:s.toCharArray()) {
			driver.findElement(b).sendKeys(Character.toString(c));
			Thread.sleep(100);
		}
		//driver.findElement(b).sendKeys(s);
	}
	
	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	public static void scroll(By b) {
		ac = new Actions(driver);
		WebElement wb = driver.findElement(b);
		ac.scrollToElement(wb).perform();
		ac.scrollByAmount(0,1200).perform();
	}
	
	@SuppressWarnings("finally")
	public static int get(By b) {
		int rate=0;
		String s = driver.findElement(b).getText();
		try {
			rate = Integer.parseInt(s);
		}catch (Exception e){
			rate = (int)Float.parseFloat(s);
		}finally {
			return rate;
		}
		
	}
	
	public static void toScrollDown(By b) {
		WebElement w = driver.findElement(b);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",w);
	}
	
	public static void screenShot(String s) throws IOException {
		TakesScreenshot tk = (TakesScreenshot)driver;
		File source = tk.getScreenshotAs(OutputType.FILE);
		//String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		//s = s+timestamp+".jpg";
		File dest = new File(System.getProperty("user.dir")+"\\target\\Screenshots\\"+s+".jpg");
		FileUtils.copyFile(source, dest);
	}

	
	
}
