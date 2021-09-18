package Features.Selenium4;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v90.emulation.Emulation;

public class setGeoLocations {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"//home//sandeshd//Downloads//chromedriver_linux64//chromedriver");

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		DevTools devtools = driver.getDevTools();
		devtools.createSession();

		HashMap<String, Object> details = new HashMap<String, Object>();

		details.put("latitude", 40);
		details.put("longitude", 3);
		details.put("accuracy", 0);

		driver.executeCdpCommand("Emulation.setGeolocationOverride", details);

		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Netflix");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//h3[@class='LC20lb DKV0Md']")).click();

		System.out.println(driver.findElement(By.id("our-story-card-title")).getText());

		driver.quit();

	}

}
