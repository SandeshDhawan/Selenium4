package Features.Selenium4;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindowFunctionality {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dhawan\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/angularpractice/");

		String ParentWindow = driver.getWindowHandle();

//		driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.WINDOW);

		driver.get("https://courses.rahulshettyacademy.com/courses");

		Set<String> allwindows = driver.getWindowHandles();

		for (String window : allwindows) {
			if (window != ParentWindow)
				driver.switchTo().window(window);
		}

		String coursetext = driver.findElement(By.xpath("//div[@title='All-Access Membership']")).getText();

		driver.switchTo().window(ParentWindow);

		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(coursetext);

		driver.quit();

	}

}
