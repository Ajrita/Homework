package selenium;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SadPath {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://the-internet.herokuapp.com/login");

		WebElement user = driver.findElement(By.id("username"));
		user.click();
		user.clear();
		user.sendKeys("tomsmit");
		Thread.sleep(2000);

		WebElement pass = driver.findElement(By.id("password"));
		pass.click();
		pass.clear();
		pass.sendKeys("SuperSecretPassword");
		Thread.sleep(2000);

		WebElement log = driver.findElement(By.cssSelector(".fa"));
		log.click();
		Thread.sleep(2000);

		WebElement error = driver.findElement(By.id("flash"));
		String poruka = error.getText();

		if (poruka.contains("Your username/password is invalid!")) {
			System.out.println("Niste se ulogovali.");

		}
	}
}