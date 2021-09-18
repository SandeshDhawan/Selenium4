package Features.Selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocators {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dhawan\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/angularpractice/");

		WebElement nameEditBox = driver.findElement(By.xpath("//input[@name='name']"));

		System.out.println(driver.findElement(RelativeLocator.with(By.tagName("label")).above(nameEditBox)).getText());

		WebElement dateOfBirthLabel = driver.findElement(By.xpath("//label[@for='dateofBirth']"));

		System.out.println(driver.findElement(RelativeLocator.with(By.tagName("input")).below(dateOfBirthLabel))
				.getAttribute("name"));

		driver.findElement(RelativeLocator.with(By.tagName("input")).below(dateOfBirthLabel)).sendKeys("02/02/2021");

		WebElement icecreamtext = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));

		driver.findElement(RelativeLocator.with(By.tagName("input")).toLeftOf(icecreamtext)).click();

		WebElement studentradio = driver.findElement(By.id("inlineRadio1"));
		System.out.println(
				driver.findElement(RelativeLocator.with(By.tagName("label")).toRightOf(studentradio)).getText());
		
		driver.quit();
	}

}
