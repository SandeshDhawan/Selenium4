package Features.Selenium4;

import java.util.Optional;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v90.emulation.Emulation;

public class MobileEmulation {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dhawan\\chromedriver_win32\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();

		DevTools devTools = driver.getDevTools();

		devTools.createSession();

		devTools.send(Emulation.setDeviceMetricsOverride(375, 812, 65, true, Optional.empty(), Optional.empty(),
				Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(),
				Optional.empty(), Optional.empty()));

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		driver.findElement(By.xpath("//a[@class='cart-icon']/img")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='empty-cart']/h2")).getText());
		driver.quit();
	}

}
