package common;
	import java.awt.Robot;
	import java.awt.Toolkit;
	import java.awt.datatransfer.StringSelection;
	import java.awt.event.KeyEvent;
	import java.util.List;
	import java.util.Set;

	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Action;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class commonFunctions {

		public WebDriver driver;
		WebDriverWait wait;
		
		public commonFunctions(WebDriver driver) {
			this.driver =driver;
		}

		private int timeouts = 20;

		public void openUrl(String url) {
			driver.get(url);

		}

		public String getTitle() {

			return driver.getTitle();

		}

		public String getCurrentUrl() {
			return driver.getCurrentUrl();
		}

		public String getPageSource() {
			return driver.getPageSource();
		}

		public void backToPage() {
			driver.navigate().back();
		}

		public void forwardToPage() {
			driver.navigate().forward();
		}

		public void refreshPage() {
			driver.navigate().refresh();
		}

		public void clickToElement(String locator) {
			WebElement element = driver.findElement(By.xpath(locator));
			element.click();
		}

		public String getTextElement(String locator) {
			WebElement element = driver.findElement(By.xpath(locator));
			return element.getText();

		}

		public void clearElement(String locator) {
			WebElement element = driver.findElement(By.xpath(locator));
			element.clear();
		}

		public void inputElement(String locator, String value) {
			WebElement element = driver.findElement(By.xpath(locator));
			element.sendKeys(value);

		}

		public void selectCombobox(String locator, String value) {
			Select select = new Select(driver.findElement(By.xpath(locator)));
			select.selectByVisibleText(value);
		}

		public String getTextComboboxSelected(String locator) {
			Select select = new Select(driver.findElement(By.xpath(locator)));
			return select.getFirstSelectedOption().getText();
		}

		public String getAtribute(String locator, String attribute) {
			WebElement element = driver.findElement(By.xpath(locator));
			return element.getAttribute(attribute);

		}

//		public int getSizeOfList(String locator) {
//			WebElement element = driver.findElement(By.xpath(locator));
//			return element.getSize()
//		}

		public int getSizeOfList(String locator) {
			List<WebElement> list = driver.findElements(By.xpath(locator));
			return list.size();
		}
		
		public boolean isElementDisplayed(String locator) {
			WebElement element = driver.findElement(By.xpath(locator));
			return element.isDisplayed();

		}

		public boolean isElementSelected (String locator) {
			WebElement element = driver.findElement(By.xpath(locator));
			return element.isSelected();
		}
		public boolean isElementEnabled(String locator){
			WebElement element = driver.findElement(By.xpath(locator));
			return element.isEnabled();
		}
		
		public void acceptAlert(){
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
		
		public void cancelAlert(){
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
			
		}
		
		
		public String getTextAlert(){
			Alert alert = driver.switchTo().alert();
			return alert.getText();
			
		}
		
		
		public void inputAlert(String value){
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(value);
		}
		
//		public void switchWindowByTitle(String title)
		public void switchWindowByTitle(String title) {
			Set<String> allWindows = driver.getWindowHandles();
			for (String childWindows : allWindows) {
				driver.switchTo().window(childWindows);
				String childTitle = driver.getTitle();
				if (childTitle.equals(title)) {
					break;
				}
			}
		}
		
//		public String getWindow()
		
		public String getWindow() {
			return driver.getWindowHandle();
		}
		
//		public void switchToIframe(String locator)
		public void switchToIframe(String locator) {
			WebElement element = driver.findElement(By.xpath(locator));
			driver.switchTo().frame(element);
		}
		
//		public void switchToDefaultContent()
		public void switchToDefaultContent() {
			driver.switchTo().defaultContent();
		}
		
//		public void hoverMouse(String locator)
		public void hoverMouse(String locator) {
			WebElement element = driver.findElement(By.xpath(locator));
			Actions action = new Actions(driver);
			action.moveToElement(element).perform();
		}
		
//		public void doubleClick(String locator)
		public void doubleClick(String locator) {
			WebElement element = driver.findElement(By.xpath(locator));
			Actions action = new Actions(driver);
			action.doubleClick(element).perform();
		}
//		public void rightClick(String locator)
		public void rightClick(String locator) {
			WebElement element = driver.findElement(By.xpath(locator));
			Actions action = new Actions(driver).contextClick(element);
			action.build().perform();
		}
//		public void dragAndDrop(String locatorFrom, String locatorTarget)
		public void dragAndDrop(String locatorFrom, String locatorTarget) {
			WebElement dragFrom = driver.findElement(By.xpath(locatorFrom));
			WebElement target = driver.findElement(By.xpath(locatorTarget));
			Actions action = new Actions(driver);
			Action dragAndDrop = action.clickAndHold(dragFrom).moveToElement(target).release(target).build();
			dragAndDrop.perform();
		}
		
//		public void clickAndHold(String locator, int itemFrom, int itemTarget)
		public void clickAndHold(String locator, int itemFrom, int itemTarget) {
			List<WebElement> listItems = driver.findElements(By.xpath(locator));
			Actions action = new Actions(driver);
			action.clickAndHold(listItems.get(itemFrom)).clickAndHold(listItems.get(itemTarget)).click().perform();
			action.release();
		}
//		public void sendKeyPress(String locator, Keys key)
		public void sendKeyPress(String locator, Keys key) {
			WebElement element = driver.findElement(By.xpath(locator));
			element.sendKeys(key);
		}
		
//		public void uploadBySendKeys(String locator, String value)
		public void uploadBySendKeys(String locator, String value) {
			WebElement element = driver.findElement(By.xpath(locator));
			element.sendKeys(value);
		}
//		public Object executeScriptBrowser(String javaScript)
		public void uploadByRobot(String path) throws Exception {
			StringSelection select = new StringSelection(path);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);

			Robot robot = new Robot(); // mở trang window (trang chứa ảnh)
			Thread.sleep(2000);

//			robot.keyPress(KeyEvent.VK_ENTER);
//			robot.keyRelease(KeyEvent.VK_ENTER);

			robot.keyPress(KeyEvent.VK_CONTROL); // keyPress: nhấn nút
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_CONTROL); // keyRelease: nhả ra
			robot.keyRelease(KeyEvent.VK_V);
			Thread.sleep(1000);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}
//		public Object executeScriptElement(String locator)
		public void executeScriptElement(String locator) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(By.xpath(locator));
			js.executeScript("arguments[0].click();", element);
		}
		
//		public Object scrollToBottomPage()
		
//		public Object scrollToElement(String locator)
//		public void highlightElement(String locator)
//		public Object removeAttributeElement(String locator, String attribute)
		
//		public void waitForElementPresence(String locator)
		public void waitForElementPresence(String locator) {
			WebDriverWait wait = new WebDriverWait(driver, timeouts);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));

		}
//		public void waitForElementVisible(String locator)
		public void waitForElementVisible(String locator) {
			WebDriverWait wait = new WebDriverWait(driver, timeouts);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		}
		public void waitForElementInvisible(String locator) {
			WebDriverWait wait = new WebDriverWait(driver, timeouts);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
		}
//		public void waitForAlertPresence()
		public void waitForAlertPresence() {
			WebDriverWait wait = new WebDriverWait(driver, timeouts);
			wait.until(ExpectedConditions.alertIsPresent());
		}

	}


