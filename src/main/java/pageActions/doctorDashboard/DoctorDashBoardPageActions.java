package pageActions.doctorDashboard;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import base.BaseClass;
import pages.doctorDashboard.AppointmentAddPage;
import pages.doctorDashboard.AppointmentsLisitngPage;
import pages.doctorDashboard.DoctorDashBoardPage;

/*
* @author Mohd-Umar
* @version 0.1
* @since 2023-12-01
*/

public class DoctorDashBoardPageActions extends BaseClass {

	private static DoctorDashBoardPage docDashPage = PageFactory.initElements(driver, DoctorDashBoardPage.class);

	public static void clickSubscriber() {
		try {
			BaseClass.waitForPageLoad();
			Thread.sleep(5000);
			docDashPage.getSubscriberBtn().click();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void clickCampSubscriberAdd() {
		try {
			BaseClass.waitForPageLoad();
			Thread.sleep(5000);
			docDashPage.getDashBoardCampSubs().click();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void doctorDashboardHomePage() {
		BaseClass.waitForElementToBeClickable(docDashPage.getAppAddBtn());
		Assert.assertTrue(driver.getTitle().contains("Doctor Dashboard"));
	}

	public static void clickOnSchedular() {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BaseClass.executeScript(docDashPage.getScheduler());
	}

	public static void clickonAppointmentAdd() {
		BaseClass.waitForElementToDisappear((By.xpath("//div[@class='ui-widget-overlay']")));
		BaseClass.waitForSpinnerToDisappear();

		BaseClass.waitForElementVisibility(docDashPage.getAppAddBtn(), 4000);
		docDashPage.getAppAddBtn().click();
	}

	public static void clickOnAppListBtn() {
	
		//BaseClass.waitForElementToDisappear((By.xpath("//div[@class='ui-widget-overlay']")));
		BaseClass.waitForSpinnerToDisappear();

		try {

			List<WebElement> pendingActionsReminder = driver
					.findElements(By.xpath("//h4[contains(text(),'Pending Actions')]"));
			List<WebElement> closePendingActionsReminder = driver
					.findElements(By.xpath("//a[@class='close notActiveSec ui-link']"));
			List<WebElement> savePendingActionsReminder = driver
					.findElements(By.xpath("//a[@class='close btn-act-save dueApptSaveDataBtn ui-link']"));

			boolean isNotificationDisplayed = pendingActionsReminder.get(0).isDisplayed();
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			
			boolean isNotificationPresent = pendingActionsReminder.size() > 0;
			boolean isSnoozePresent = closePendingActionsReminder.size() > 0;
			boolean isSavePresent = savePendingActionsReminder.size() > 0;

			if (isNotificationDisplayed) {

				if (isSavePresent) {

					CommonPageActions.selectNoShowPendingActions();

				}

				else {

					CommonPageActions.closePendingActionsReminder();

//					BaseClass.hoverOnElement(closePendingActionsReminder.get(0));
//					closePendingActionsReminder.get(0).click();
				}
			}

		} catch (NoSuchElementException e) {

			System.out.println("Pending actions notification appeared and couldn't be closed");

		}

		BaseClass.waitForElementVisibility(docDashPage.getAppListBtn(), 4000);
		BaseClass.waitForUIWidgetOverlayToDisappear();
		docDashPage.getAppListBtn().click();
	}

//	public static void clickOnAppListBtn() {
//		loginPage.waitForPageLoad();
//		try {
//			Thread.sleep(12000);
//			docDashPage.getAppListBtn().click();
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}

	public static void clickOnPatientAdd() {
		BaseClass.waitForPageLoad();
		BaseClass.executeScript(docDashPage.getPatientAdd());
	}

	public static void verifyMiscCalls() {
		BaseClass.WaitTillElementIsPresent(docDashPage.getMiscCallsListBtn());

	}

	public static void clickOnMiscCallsList() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForSpinnerToDisappearOnDoctorDashboard();
		BaseClass.waitForUIWidgetOverlayToDisappear();
		BaseClass.waitForElementToBeClickable(docDashPage.getMiscCallsListBtn());
		docDashPage.getMiscCallsListBtn().click();
		BaseClass.waitForSpinnerToDisappear();
	}

	public static void clickOnMiscCallsAdd() {
		BaseClass.waitForSpinnerToDisappearOnDoctorDashboard();
		BaseClass.waitForElementToBeClickable(docDashPage.getMiscCallsAddBtn());
		docDashPage.getMiscCallsAddBtn().click();
		BaseClass.waitForSpinnerToDisappear();
	}

	public static void clickFeedBackListing() {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(10000);
			docDashPage.getFeedbackListing().click();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void clickOnProductSales() {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementToBeClickable(docDashPage.getDashboardProductSale());
		docDashPage.getDashboardProductSale().click();
		BaseClass.waitForSpinnerToDisappear();
	}
}
