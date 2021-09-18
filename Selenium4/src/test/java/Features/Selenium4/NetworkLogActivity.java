package Features.Selenium4;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v90.network.Network;
import org.openqa.selenium.devtools.v90.network.model.Request;
import org.openqa.selenium.devtools.v90.network.model.Response;

public class NetworkLogActivity {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dhawan\\chromedriver_win32\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		DevTools devTools = driver.getDevTools();

		devTools.createSession();
		

		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

		devTools.addListener(Network.requestWillBeSent(), request ->

		{
			Request req = request.getRequest();
			System.out.println(req.getUrl());

		});

		devTools.addListener(Network.responseReceived(), response ->

		{
			Response res = response.getResponse();
			System.out.println(res.getStatus());
			System.out.println(res.getUrl());
		});

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.findElement(By.xpath("//a[text()='Top Deals']")).click();
		driver.quit();
	}

}
