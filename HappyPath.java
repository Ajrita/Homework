package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HappyPath {

	public String username;
	public String password;

	public HappyPath(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://the-internet.herokuapp.com/login");

		WebElement username = driver.findElement(By.id("username"));
		username.click();
		username.clear();
		username.sendKeys("tomsmith");
		Thread.sleep(2000);

		WebElement password = driver.findElement(By.id("password"));
		password.click();
		password.clear();
		password.sendKeys("SuperSecretPassword!");
		Thread.sleep(2000);

		WebElement log = driver.findElement(By.cssSelector(".fa"));
		log.click();
		Thread.sleep(2000);

		String newplace = "https://the-internet.herokuapp.com/secure";
		String url = driver.getCurrentUrl();
		if (url.equals(newplace)) {
			System.out.println("Uspešan login.");

		}

	}
}
