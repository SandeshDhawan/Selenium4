package Features.Selenium4;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementScreenshot {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dhawan\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/angularpractice/");

		WebElement nameTextBox = driver.findElement(By.xpath("//input[@name='name']"));

		nameTextBox.sendKeys("Java Coures for Automation");

		File file = nameTextBox.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(file, new File("nametextbox.png"));

		driver.quit();
	}

}
