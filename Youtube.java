package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Youtube {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*
		 * Pomocu jave i selenijuma 1) otici na sajt youtube 2) u search-u pronaci Rick
		 * Astley i pustiti pesmu Never gonna give you up // voditi racuna da ako
		 * postoje reklame da ih preskocite3) Nakon sto je pustena pesma, iz liste sa
		 * desne strane (watch next) pustiti drugi predlozen video
		 */

		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://www.youtube.com/");
		driver.manage().window().maximize();

		WebElement searchBox = driver.findElement(By.xpath(
				"/html[1]/body[1]/ytd-app[1]/div[1]/div[1]/ytd-masthead[1]/div[3]/div[2]/ytd-searchbox[1]/form[1]/div[1]/div[1]/input[1]")); // (By.name("search_query"));
		searchBox.clear();
		searchBox.sendKeys("Rick Astley");
		Thread.sleep(2000);

		WebElement searchButton = driver.findElement(By.id("search-icon-legacy"));
		searchButton.click();
		Thread.sleep(2000);

		WebElement pesma = driver.findElement(By.cssSelector("#video-title > yt-formatted-string"));
		pesma.click();
		Thread.sleep(50000);

		// WebDriverWait wait = new WebDriverWait(driver, 20);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("skip-button:s"))).click();
		WebElement drugaPesma = driver.findElement(By.xpath(
				"/html[1]/body[1]/ytd-app[1]/div[1]/ytd-page-manager[1]/ytd-watch-flexy[1]/div[5]/div[2]/div[1]/div[3]/ytd-watch-next-secondary-results-renderer[1]/div[2]/ytd-compact-video-renderer[2]/div[1]/div[1]/div[1]/a[1]/h3[1]/span[1]")); // (By.xpath("//*[@id=\"dismissible\"]/div/div[1]/a"));
		drugaPesma.click();

	}

}
