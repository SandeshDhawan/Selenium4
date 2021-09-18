package Features.Selenium4;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;

public class executeCDPCommand {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dhawan\\chromedriver_win32\\chromedriver.exe");

		
		ChromiumDriver driver = new ChromeDriver();
//		ChromeDriver driver = new ChromeDriver();

		DevTools devtools = driver.getDevTools();

		devtools.createSession();

		Map values = new HashMap();
		values.put("width", 375);
		values.put("height", 812);
		values.put("deviceScaleFactor", 65);
		values.put("mobile", true);

		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", values);

		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.findElement(By.xpath("//a[@class='cart-icon']/img")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='empty-cart']/h2")).getText());
		driver.quit();

	}

}
