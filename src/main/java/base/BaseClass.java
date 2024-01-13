package base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.ExtentTest;

import pageActions.doctorDashboard.AppointmentAddPageActions;
import pageActions.doctorDashboard.CommonPageActions;
import pageActions.doctorDashboard.DoctorDashBoardPageActions;
import pages.doctorDashboard.DoctorDashBoardPage;
import pages.doctorDashboard.Login;
import utils.ConfigReader;
import utils.ExcelReader;
import utils.ExtentReportListener;

public class BaseClass extends ExtentReportListener {

	public static String browser;
	public static String appURL;
	public static String username;
	public static String password;
	public static WebDriver driver;
	public static ConfigReader config;
	public static ExcelReader excel;
	public static WebDriverWait wait;
	public static Wait<WebDriver> flWait;
	public static ExtentReportListener reporter;
	public static ExtentTest logger;
	public static boolean flag;

	@BeforeClass
	public void setup() throws Exception {
		config = new ConfigReader();
		launchBrowser();
		launchDoctorDashboard();
		doLogin();
//		doctorDashboardHomePage();

	}

	@BeforeTest
	public void configReport() {
		ExtentReportListener extent = new ExtentReportListener();

		logger = extent.getExtentTest();
		System.out.println("Test Class logger ---->" + logger);

	}

	public static void launchBrowser() {

		browser = config.getBrowser();

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		else if (browser.equalsIgnoreCase("ie") || (browser.equalsIgnoreCase("edge"))) {
			driver = new EdgeDriver();
		}

		else {
			System.out.println("Incorrect option - Launching Chrome browser for safety");
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	public static void launchDoctorDashboard() {

		appURL = config.getEnvURL();
		driver.get(appURL);

	}

	public static String getUsername() {

		username = config.getUserName();
		return username;
	}

	public static String getPassword() {

		password = config.getUserPassword();
		return password;
	}

	public static void doctorDashboardHomePage() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("dashBoardAppointmentAdd")));

		BaseClass.waitForSpinnerToDisappear();
		String actualTitle = driver.getTitle();
		if (actualTitle.contains("Doctor Dashboard")) {
			DoctorDashBoardPageActions.clickonAppointmentAdd();
		} else if (actualTitle.contains("Appointment")) {

			driver.navigate().refresh();
		} else if (actualTitle.contains("Appointment Scheduler Calender")) {
			CommonPageActions.backToDoctorDashbrd();
			DoctorDashBoardPageActions.clickonAppointmentAdd();
		} else {
			CommonPageActions.backToDoctorDashbrd();
			DoctorDashBoardPageActions.clickonAppointmentAdd();
		}
		AppointmentAddPageActions.toVerifyAppointmentHomePage();

	}

	public static void openAddAppointmentPage() {

		BaseClass.waitForSpinnerToDisappear();
		String actualTitle = driver.getTitle();
		if (actualTitle.contains("Doctor Dashboard")) {
			DoctorDashBoardPageActions.clickonAppointmentAdd();
		} else if (actualTitle.contains("Appointment")) {

			driver.navigate().refresh();
		} else if (actualTitle.contains("Appointment Scheduler Calender")) {
			CommonPageActions.backToDoctorDashbrd();
			DoctorDashBoardPageActions.clickonAppointmentAdd();
		} else {
			CommonPageActions.backToDoctorDashbrd();
			DoctorDashBoardPageActions.clickonAppointmentAdd();
		}
		AppointmentAddPageActions.toVerifyAppointmentHomePage();

	}

	public static void openPatientRegistrationHomePage() {
		if (CommonPageActions.verification().contains("Patient Registration")) {
			driver.navigate().refresh();
		} else if (CommonPageActions.verification().contains("Doctor Dashboard")) {
			DoctorDashBoardPageActions.clickOnPatientAdd();
		} else {
			CommonPageActions.backTODoctorDashboard();
			BaseClass.waitForSpinnerToDisappear();
			DoctorDashBoardPageActions.clickOnPatientAdd();
		}
	}

	/************************************************
	 * 
	 * Utils - Utilities
	 * 
	 ***********************************************/

	public static void pressTabKey(WebDriver driver) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).build().perform();

	}

	public static void verifyPageTitle(String expectTitle) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleIs(expectTitle));

	}

	public static String getCurrentTime() {
		// Get the current date and time in India
		LocalDateTime indiaTime = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));

		// Create a formatter for the time format you want (hh:mm a)
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");

		// Format the time with the formatter and print it
		String formattedTime = indiaTime.format(formatter);
		System.out.println("Current time in India: " + formattedTime);

		return formattedTime;
	}

	public static List<WebElement> getDropdwnOptions(WebElement ele) {
		waitForElementToBeClickable(ele);
		List<WebElement> allOptions = new Select(ele).getOptions();
		return allOptions;
	}

	public static void visibilityOfListLocated(List<WebElement> ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(ele));
	}

	public static void moveToElementAndClick(WebElement ele) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).click().build().perform();

	}

	public static void scrollPage(int height) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, " + height + ")");
	}

	public static void waitForModalOverlayToDisappear() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='modal overlay show']")));
	}

	public static void waitForUIWidgetOverlayToDisappear() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='ui-widget-overlay']")));
	}

	public static void uploadFile(String str) throws AWTException {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		StringSelection selection = new StringSelection(str);
		java.awt.datatransfer.Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(selection, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public static SoftAssert softAssert() {
		waitForPageLoad();
		SoftAssert soft = new SoftAssert();
		return soft;
	}

	public static void waitTillInvisiblityOfElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public static void waitForModalBackdropToDisappear() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='modal-backdrop fade in']")));
	}

	public static String convert24HourFormatTo12HourFormat(String time)
			throws java.text.ParseException, ParseException {
		final SimpleDateFormat sdf = new SimpleDateFormat("H:mm");
		final java.util.Date dateObj = sdf.parse(time);
		return new SimpleDateFormat("h:mm a").format(dateObj);
	}

	public static String convertFormatingDate(String conversionDate) throws java.text.ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date date = sdf.parse(conversionDate);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String dateText = date.toString().format(String.valueOf(dtf));
		return dateText;
	}

	public static void scrollToView(WebElement ele) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", ele);
	}

	public static void waitForElementToBeEnable(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public static void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	public static void switchToFrame(WebElement frame) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
	}

	public static String getCurrentLocalDateTimeStamp() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
	}

	public static void waitForPageToBecomeActive() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='modal-backdrop fade  in']")));
	}

	public static void selectFromDropDownByIndex(WebElement ele, int index) {
		waitForElementToBeClickable(ele);
		new Select(ele).selectByIndex(index);
	}

	public static void selectFromDropDownByValue(WebElement ele, String value) {
		waitForElementToBeClickable(ele);
		new Select(ele).selectByValue(value);
	}

	public static void waitForElementToDisappear(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	public static void WaitTillElementIsPresent(final WebElement ele) {
		Wait<WebDriver> flWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);
		flWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return ele;
			}
		});
	}

	public static String firstSelectedOption(WebElement ele) {
		waitForElementToBeClickable(ele);
		String name = new Select(ele).getFirstSelectedOption().getText();
		System.out.println(name);
		return name;
	}

	public static void hoverOnElement(WebElement ele) {
		Actions action = new Actions(driver);
		action.moveToElement(ele);
		action.perform();
	}

	public static void selectFromDropDownByVisibleText(WebElement ele, String value) {

		boolean isElementPresent = false;

		waitForElementVisibility(ele);
		new Select(ele).selectByVisibleText(value);
	}

	public static void waitForPageLoad() {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(pageLoadCondition);
	}

	public static void waitForSpinnerToDisappear() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[@class='spinner']")));

	}

	public static void waitForSpinnerToDisappearOnDoctorDashboard() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='ui-widget-overlay']")));
	}

	public static void waitForElementVisibility(WebElement ele, int secs) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static void waitForElementVisibility(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public static void waitToBeClickableAndSendKeys(WebElement element, String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.sendKeys(value);

	}

	public static void waitToBeClickableAndClick(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitForElementToBeClickable(WebElement ele) {
		WebElement element = ele;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void executeScript(WebElement ele) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ele);
	}

	/*
	 * DatePicker utils
	 */

	public static void selectDateofAppCal(String SelectDate, WebElement calenderWeb) {
		@SuppressWarnings("deprecation")
		Date d = new Date(SelectDate);
		Date now = new Date();
		SimpleDateFormat dt = new SimpleDateFormat("MMMM/dd/yyyy");
		String date = dt.format(d);
		String[] split = date.split("/");
		String month = split[0];
		String year = split[2];
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BaseClass.executeScript(calenderWeb);
//        calenderWeb.click();

		while (true) {
			WebElement next = driver.findElement(By.xpath(
					"//input[@id='date']//following-sibling::ul//table//i[contains(@class,'glyphicon glyphicon-chevron-right')]"));
			WebElement prev = driver.findElement(By.xpath(
					"//input[@id='date']//following-sibling::ul//table//i[@class='glyphicon glyphicon-chevron-left']"));
			if (!flag) {
				try {
					driver.findElement(
							By.xpath("//input[@id='date']//following-sibling::ul//table//strong[contains(text(),'"
									+ year + "')]"))
							.isDisplayed();
					System.out.println("year matches with the calender year==  " + year);
					flag = true;
				} catch (Exception e) {
					if (now.before(d)) {
						driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
						System.out.println("year do not matched with the calender year== " + year);
						next.click();
					} else {
						WaitTillElementIsPresent(prev);
						BaseClass.waitForElementToBeClickable(prev);
						prev.click();
					}
				}
			} else {
				try {
					WebElement monthele = driver.findElement(
							By.xpath("//input[@id='date']//following-sibling::ul//table//strong[contains(text(),'"
									+ month + "')]"));

					if (monthele.isDisplayed()) {
						System.out.println("month matches with calender month == " + month);
						String startstr = "//input[@id='date']//following-sibling::ul//table//tbody/tr//span[text()='";
						String endstr = "']";
						String finalpart = startstr + split[1] + endstr;
						WebElement dateEelment = driver.findElement(By.xpath(finalpart));
						BaseClass.hoverOnElement(dateEelment);
						BaseClass.waitForElementToBeClickable(dateEelment);
						dateEelment.click();
						Thread.sleep(3000);
						break;
					}
				} catch (Exception e) {
					if (now.before(d)) {
						System.out.print("Month do not match with calender month== " + month);
						driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
						next.click();
					} else {
						WaitTillElementIsPresent(prev);
						BaseClass.waitForElementToBeClickable(prev);
						prev.click();
					}
				}
			}
		}
	}

	public static void appointmentDate(String SelectDate, WebElement calenderWeb, String id) {
		@SuppressWarnings("deprecation")
		Date d = new Date(SelectDate);
		Date now = new Date();
		SimpleDateFormat dt = new SimpleDateFormat("MMMM/dd/yyyy");
		String date = dt.format(d);
		String[] split = date.split("/");
		String month = split[0];
		String year = split[2];
		calenderWeb.click();

		while (true) {
			WebElement next = driver.findElement(By.xpath("//input[@id='" + id
					+ "']//following::ul//table//i[contains(@class,'glyphicon glyphicon-chevron-right')]"));
			WebElement prev = driver.findElement(By.xpath("//input[@id='" + id
					+ "']//following::ul//table//i[contains(@class,'glyphicon glyphicon-chevron-left')]"));
			if (!flag) {
				try {
					driver.findElement(By.xpath("//input[@id='" + id
							+ "']//following-sibling::ul//table//strong[contains(text(),'" + year + "')]"))
							.isDisplayed();
					flag = true;
				} catch (Exception e) {
					if (now.before(d)) {
						driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
						next.click();

					} else {
						WaitTillElementIsPresent(prev);
						waitForElementToBeClickable(prev);
						prev.click();
					}
				}
			} else {
				try {
					WebElement monthEle = driver.findElement(By.xpath("//input[@id='" + id
							+ "']//following-sibling::ul//table//strong[contains(text(),'" + month + "')]"));
					if (monthEle.isDisplayed()) {
//                        String startStr = "//input[@id='"+ id +"']//following-sibling::ul//table//tbody/tr//span[text()='";
						String startStr = "//input[@id='" + id
								+ "']//following-sibling::ul//button[not(contains(@class,'prevDateDisabled'))]/span[text()='";
						String endStr = "']";
						String finalPart = startStr + split[1] + endStr;
						WebElement dateElement = driver.findElement(By.xpath(finalPart));
						hoverOnElement(dateElement);
						waitForElementToBeClickable(dateElement);
						dateElement.click();
						Thread.sleep(3000);
						break;
					}
				} catch (Exception e) {
					if (now.before(d)) {
						driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
						next.click();
					} else {
						WaitTillElementIsPresent(prev);
						waitForElementToBeClickable(prev);
						prev.click();
					}
				}
			}
		}
	}

	public static void doLogin() throws InterruptedException {

		Login login = PageFactory.initElements(driver, Login.class);

		username = config.getUserName();
		password = config.getUserPassword();
		waitToBeClickableAndSendKeys(login.getUnTxBx(), username);
		waitToBeClickableAndSendKeys(login.getPwdTxBx(), password);

//		waitForElementToBeClickable(login.getUnTxBx());
//		waitForElementToBeClickable(login.getPwdTxBx());

		// waitForElementToBeClickable(login.getLoginBtn());
		driver.findElement(By.xpath("//input[@id='loginButton']")).click();
		waitForSpinnerToDisappearOnDoctorDashboard();

		// waitForElementToBeClickable(login.getLoginBtn());
		// waitToBeClickableAndClick(login.getLoginBtn());

	}

	@AfterClass
	public void tearDown() throws Exception {

//		 driver.quit();

	}
}
