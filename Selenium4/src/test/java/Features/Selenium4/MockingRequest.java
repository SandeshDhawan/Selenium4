package Features.Selenium4;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v90.fetch.Fetch;

public class MockingRequest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dhawan\\chromedriver_win32\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		DevTools devTools = driver.getDevTools();

		devTools.createSession();

		devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));

		devTools.addListener(Fetch.requestPaused(), request ->

		{
			if (request.getRequest().getUrl().contains("shetty")) {
				String mockurl = request.getRequest().getUrl().replace("=shetty", "=BadGuy");

				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(mockurl),
						Optional.of(request.getRequest().getMethod()), Optional.empty(), Optional.empty()));
			} else {
				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(request.getRequest().getUrl()),
						Optional.of(request.getRequest().getMethod()), Optional.empty(), Optional.empty()));
			}
		});

		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//button[text()=' Virtual Library ']")).click();

		System.out.println(driver.findElement(By.tagName("p")).getText());

		driver.quit();

	}

}
