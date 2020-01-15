package common;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
//import org.testng.annotations.AfterClass;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class commonTestcase {
	WebDriver driver;

	public WebDriver openBrowser(String browser, String version, String url) {
//		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
//		ChromeDriverManager.getInstance().version(version).setup();
//		driver = new ChromeDriver();

		if (browser.equals("chrome")) {
			ChromeDriverManager.getInstance().version(version).setup();
			driver = new ChromeDriver();

		} else if (browser.equals("firefox")) {
			FirefoxDriverManager.getInstance().version(version).setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}

	public void closeBrowser() {
		driver.quit();
	}

	public void verifyEquals(String actual, String expected) {
		Assert.assertEquals(actual, expected);

	}

	public void verifyTrue(boolean condition) {
		Assert.assertTrue(condition);
	}

	public void verifyFalse(boolean condition) {
		Assert.assertFalse(condition);
	}

	public int randomNumber() {
		return new Random().nextInt(999999999);

	}

	public String getTextRegex(String regex, String text) {
		String textRegex = "";
		Pattern patternRegex = Pattern.compile(regex);
		Matcher m = patternRegex.matcher(text);

		if (m.find()) {
			textRegex = m.group(1);
		}
		return textRegex;
	}
}
