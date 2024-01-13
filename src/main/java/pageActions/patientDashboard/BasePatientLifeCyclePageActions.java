package pageActions.patientDashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.sikuli.script.Pattern;
import org.testng.Assert;
import utils.TestData;
import base.BaseClass;
import pageActions.doctorDashboard.PatientDashboardPageActions;
import pages.doctorDashboard.PatientDashboardPage;
import pages.patientDashboard.BasePatientLifeCyclePage;

/*
* @author Mohd-Umar
* @version 0.1
* @since 2023-12-01
*/

public class BasePatientLifeCyclePageActions extends BaseClass {

	static BasePatientLifeCyclePage basePatientLifeCyclePage = PageFactory.initElements(driver, BasePatientLifeCyclePage.class);

	

	/*checked at all listing page if there is no data*/
	public static void noRecordMsgDisplayed() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(basePatientLifeCyclePage.getNoRecordFoundMsg());
		Assert.assertTrue(checkedElementDisplayed(basePatientLifeCyclePage.getNoRecordFoundMsg()));
	}

	/*closing the view modal from the listing page*/
	public static void closeViewPopup() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(basePatientLifeCyclePage.getCloseBtnViewPop());
		basePatientLifeCyclePage.getCloseBtnViewPop().click();
	}

	/*closing the alert popup*/
	public static void clickOnAlert() {
		BaseClass.waitForPageLoad();

		try {
		boolean isAlertDisplayed = basePatientLifeCyclePage.getAlert().isDisplayed();
		System.out.println(isAlertDisplayed);
		if (isAlertDisplayed) {
		BaseClass.waitForElementToBeClickable(basePatientLifeCyclePage.getAlert());
//		WebElement web= driver.findElement(By.xpath("//div[@class='modal-backdrop fade']"));
//		if(web.isDisplayed()) {
//			System.out.println("Modal backdrop fade "+web.isDisplayed());
//		BaseClass.waitForElementToDisappear((By.xpath("//div[@class='modal-backdrop fade']")));
//		}
//		BaseClass.waitForElementToDisappear((By.xpath("//div[contains(@class='ui-widget-overlay')]")));
		BaseClass.waitForUIWidgetOverlayToDisappear();
		
//		WebElement ele = driver.findElement(By.xpath("//div[@class='modal fade']"));
//		if(driver.findElement(By.xpath("//div[@class='modal fade']")).isDisplayed()==true) {
//		BaseClass.waitForElementToDisappear(By.xpath("//div[@class='modal fade']"));
//		}
		basePatientLifeCyclePage.getAlert().click();
		BaseClass.waitForUIWidgetOverlayToDisappear();
		Thread.sleep(1000);

		//BaseClass.waitForElementToDisappear((By.xpath("//div[@class='ui-widget-overlay']")));
		}
		}
		catch(NoSuchElementException | InterruptedException e) {
//			basePatientLifeCyclePage.getAlert().click();
			System.out.println("Alert not clicked");
		}
	}
	
//	public static void clickOnAlert() {
//		BaseClass.waitForPageLoad();
//		BaseClass.waitForElementToDisappear(By.xpath("//div[@class='modal overlay']"));
//		try {
//			Thread.sleep(8000);
//			basePatientLifeCyclePage.getAlert().click();
//			Thread.sleep(2000);
//		} catch (InterruptedException| NoSuchElementException e) {
//			// TODO Auto-generated catch block
//			try {
//				Thread.sleep(8000);
//			} catch (InterruptedException interruptedException) {
//				interruptedException.printStackTrace();
//			}
//		}
//	}
//	
	/*checked the dashboard button present*/
	public static void dashBoardBtnVerify() {
		BaseClass.waitForElementVisibility(basePatientLifeCyclePage.getDashboardBtn(),4000);
		Assert.assertTrue(checkedElementDisplayed(basePatientLifeCyclePage.getDashboardBtn()));
	}
	
	public static void commonDashBoardBtnVerify() {
		BaseClass.waitForElementVisibility(basePatientLifeCyclePage.getCommonDashboardBtn(),4000);
		Assert.assertTrue(checkedElementDisplayed(basePatientLifeCyclePage.getCommonDashboardBtn()));
	}


	/*clicking on the dashboard button*/
	
	public static void clickOnDashBoard() {
		if(basePatientLifeCyclePage.getDashboardBtn().isDisplayed()==true) {
			BaseClass.waitForElementToBeClickable(basePatientLifeCyclePage.getDashboardBtn());
			BaseClass.executeScript(basePatientLifeCyclePage.getDashboardBtn());
			BaseClass.waitForModalOverlayToDisappear();
		    BaseClass.waitForSpinnerToDisappear();
		    try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		else {
			BaseClass.waitForElementVisibility(basePatientLifeCyclePage.getDashboardBtn(), 4000);
			BaseClass.waitForElementToBeClickable(basePatientLifeCyclePage.getDashboardBtn());
			BaseClass.executeScript(basePatientLifeCyclePage.getDashboardBtn());
			BaseClass.waitForModalOverlayToDisappear();
		    BaseClass.waitForSpinnerToDisappear();
		    try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void clickOnDashBoardReceiptPage() {
		BaseClass.waitForElementVisibility(basePatientLifeCyclePage.getDashboardBtnReceipt(), 4000);
		BaseClass.waitForElementToBeClickable(basePatientLifeCyclePage.getDashboardBtnReceipt());
		BaseClass.executeScript(basePatientLifeCyclePage.getDashboardBtnReceipt());
		BaseClass.waitForModalOverlayToDisappear();
		BaseClass.waitForSpinnerToDisappear();
		 try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	public static void clickOnDashBoardCommon() {
		BaseClass.waitForElementVisibility(basePatientLifeCyclePage.getCommonDashboardBtn(), 4000);
		BaseClass.waitForElementToBeClickable(basePatientLifeCyclePage.getCommonDashboardBtn());
		BaseClass.executeScript(basePatientLifeCyclePage.getCommonDashboardBtn());
		BaseClass.waitForModalOverlayToDisappear();
		BaseClass.waitForSpinnerToDisappear();
		 try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	
//	public static void clickOnDashBoard() {
//		BaseClass.waitForPageLoad();
//		BaseClass.waitForElementToBeClickable(basePatientLifeCyclePage.getDashboardBtn());
//		BaseClass.executeScript(basePatientLifeCyclePage.getDashboardBtn());
//		try {
//			Thread.sleep(4000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}

	/*checked add new button at listing page*/
	public static void verifyAddNewBtn() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(basePatientLifeCyclePage.getAddNewBtn());
		Assert.assertTrue(checkedElementDisplayed(basePatientLifeCyclePage.getAddNewBtn()));
	}

	/*checked add new button at old listing page*/
	public static void verifyAddNewBtnOldUi() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(basePatientLifeCyclePage.getAddNewBtnOldUi());
		Assert.assertTrue(checkedElementDisplayed(basePatientLifeCyclePage.getAddNewBtnOldUi()));
	}

	/*clicking at the add new button*/
	public static void clickOnAddNewBtn() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForModalOverlayToDisappear();
		BaseClass.waitForElementToBeClickable(basePatientLifeCyclePage.getAddNewBtn());
		basePatientLifeCyclePage.getAddNewBtn().click();
		BaseClass.waitForSpinnerToDisappear();
			
	
	}

	/*open the side navigation module*/
//	public static void openCloseLeftNavigator() {
//		BaseClass.waitForPageLoad();
//		try {
//			Thread.sleep(4000);
//			BaseClass.waitForElementToBeClickable(openLeftNavigationBtn);
//			openLeftNavigationBtn.click();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	/*open the side navigation module*/
	
	public static void openCloseLeftNavigator() {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(basePatientLifeCyclePage.getOpenLeftNavigationBtn(),4000);
//		BaseClass.waitForPageToBecomeActive();
		BaseClass.waitForModalOverlayToDisappear();
		BaseClass.waitForUIWidgetOverlayToDisappear();
		basePatientLifeCyclePage.getOpenLeftNavigationBtn().click();
	}
	
//	public static void openCloseLeftNavigator() {
//		BaseClass.waitForPageLoad();
//		try {
//			Thread.sleep(4000);
//			BaseClass.waitForElementToBeClickable(basePatientLifeCyclePage.getOpenLeftNavigationBtn());
//			basePatientLifeCyclePage.getOpenLeftNavigationBtn().click();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	/*Close the side navigation module*/
	public static void closeLeftNavigator() {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(4000);
			BaseClass.waitForElementToBeClickable(basePatientLifeCyclePage.getCloseLeftNavigationBtn());
			basePatientLifeCyclePage.getCloseLeftNavigationBtn().click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*checking the all the module name present at left navigation bar*/
	public static void webElementOfLeftNavigator() {
//		BaseClass.waitForPageLoad();
		BaseClass.waitForPageToBecomeActive();;
		BaseClass.waitForElementToBeClickable(basePatientLifeCyclePage.getOralExam());
		Assert.assertTrue(checkedElementDisplayed(basePatientLifeCyclePage.getOralExam()) && checkedElementDisplayed(basePatientLifeCyclePage.getDiagnostics())
				&& checkedElementDisplayed(basePatientLifeCyclePage.getTreatments()) && checkedElementDisplayed(basePatientLifeCyclePage.getWorksDone())
				&& checkedElementDisplayed(basePatientLifeCyclePage.getPrescriptions()) && checkedElementDisplayed(basePatientLifeCyclePage.getFilesList())
				&& checkedElementDisplayed(basePatientLifeCyclePage.getInvoicesList()));
	}

	/*closing the side navigation in the old ui*/
	public static void clickOnLeftNavigatorCloseBtnOldUi() {
		BaseClass.waitForPageLoad();
		Screen screen = new Screen();
		Pattern pattern = new Pattern(".\\sikuliImages\\treatmentCloseSideNavigation.png");
		try {
			screen.click(pattern);
		} catch (FindFailed  e) {
			e.printStackTrace();
		}
	}

	/*checking the header of the page at listing pages*/
	
	public static void headerOnListPage(String Header) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForSpinnerToDisappear();
//		BaseClass.WaitTillElementIsPresent(basePatientLifeCyclePage.getListPageHeader());
		BaseClass.waitForElementVisibility(basePatientLifeCyclePage.getListPageHeader(), 4000);
		Assert.assertTrue(basePatientLifeCyclePage.getListPageHeader().getText().contains(Header));
	}
	
	
	
//	public static void headerOnListPage(String Header) {
//		BaseClass.waitForPageLoad();
//		BaseClass.WaitTillElementIsPresent(basePatientLifeCyclePage.getListPageHeader());
//		try {
//			Thread.sleep(5000);
//			Assert.assertTrue(basePatientLifeCyclePage.getListPageHeader().getText().contains(Header));
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	/*checking the header of the page at Add pages*/
	public static void headerOnAddPage(String Header) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementToBeClickable(basePatientLifeCyclePage.getAddPageHeader());
		Assert.assertTrue(basePatientLifeCyclePage.getAddPageHeader().getText().contains(Header));
	}

	/*checking the header of the view modal*/
	public static void headerViewPopup(String Header) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(basePatientLifeCyclePage.getViewPopupHeader());
		Assert.assertTrue(basePatientLifeCyclePage.getViewPopupHeader().getText().contains(Header));
	}

	/*checking the patient name and patient id is not null*/
	public static void verifyPatientName(String patientName) {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(basePatientLifeCyclePage.getUserName(),4000);
		String str = basePatientLifeCyclePage.getUserName().getText();
		String[] split = str.split(" : ");
		boolean flag = split[0].contains(patientName) && !(split[1].equals("NA") || split[1].equals("Null"));
		Assert.assertTrue(flag);
	}

	/*checking the dates at listing page*/
	public static void verifyDates() {
		    BaseClass.waitForSpinnerToDisappear();
		    BaseClass.waitForElementVisibility(basePatientLifeCyclePage.getAddNewBtn(),4000);
    		String actualDate = basePatientLifeCyclePage.getGetDate().getText().trim();
    		System.out.println("Actual Date "+actualDate);
//			Date dat = new Date();
//			String expectedDate = new SimpleDateFormat("dd-MM-yy").format(dat);
    		String expectedDate = TestData.getInstance().getTodayDate().trim();
    		System.out.println("Expected Date "+expectedDate);
			Assert.assertTrue(expectedDate.equals(actualDate));
	}
		
//	public static void verifyDates() {
//		BaseClass.waitForPageLoad();
//		try {
//			Thread.sleep(4000);
//			WebElement web = driver.findElement(By.xpath("(//div[@class='fnt_avgR dateClnc']/span)[1]"));
//			String actualDate = web.getText().trim();
//			Date dat = new Date();
//			String expectedDate = new SimpleDateFormat("dd-MM-yy").format(dat);
//			Assert.assertTrue(expectedDate.equals(actualDate));
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
	/*validating all action button present listing page when just added the items*/
	
	public static void actionBtnMainList(String clinicName) {
		BaseClass.waitForModalOverlayToDisappear();
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(basePatientLifeCyclePage.getAddNewBtn(),4000);
		WebElement viewBtn = driver
				.findElement(By.xpath("//div[@class='fnt_avgR dateClnc']//span[contains(text(),'" + clinicName
						+ "')]/../following-sibling::div//span[@class='actn-icn view']"));
		WebElement editBtn = driver
				.findElement(By.xpath("//div[@class='fnt_avgR dateClnc']//span[contains(text(),'" + clinicName
						+ "')]/../following-sibling::div//span[@class='actn-icn edit']"));
		WebElement deleteBtn = driver
				.findElement(By.xpath("//div[@class='fnt_avgR dateClnc']//span[contains(text(),'" + clinicName
						+ "')]/../following-sibling::div//span[@class='actn-icn delete']"));
		WebElement printBtn = driver
				.findElement(By.xpath("//div[@class='fnt_avgR dateClnc']//span[contains(text(),'" + clinicName
						+ "')]/../following-sibling::div//span[@class='actn-icn print']"));
		Assert.assertTrue(checkedElementDisplayed(viewBtn) && checkedElementDisplayed(editBtn)
				&& checkedElementDisplayed(deleteBtn) && checkedElementDisplayed(printBtn));
	}

	/*opening the view modal at the listing  page*/
	public static void clickViewBtn(String clinicName) {
		BaseClass.waitForPageLoad();
		WebElement element = driver
				.findElement(By.xpath("//div[@class='fnt_avgR dateClnc']//span[contains(text(),'" + clinicName
						+ "')]/../following-sibling::div//span[@class='actn-icn view']"));
		element.click();
		try {
			Thread.sleep(2000);
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*Editing the items from the listing page*/
	public static void clickEditBtn(String clinicName) {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(2000);
			WebElement ele = driver
					.findElement(By.xpath("//div[@class='fnt_avgR dateClnc']//span[contains(text(),'" + clinicName
							+ "')]/../following-sibling::div//span[@class='actn-icn edit']"));
			ele.click();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*Deleting the item from listing page*/
	public static void clickDeleteBtn(String clinicName) {
		BaseClass.waitForPageLoad();
		WebElement element = driver
				.findElement(By.xpath("//div[@class='fnt_avgR dateClnc']//span[contains(text(),'" + clinicName
						+ "')]/../following-sibling::div//span[@class='actn-icn delete']"));
		element.click();
	}

	/*checking webelement present at webpage*/
	private static boolean checkedElementDisplayed(WebElement webelement) {
		return (webelement.isDisplayed());
	}

}
