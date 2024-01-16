package pageActions.doctorDashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;
import pages.doctorDashboard.AppointmentAddPage;
import pages.doctorDashboard.CommonPage;
import pages.doctorDashboard.Login;

import java.time.Duration;
import java.util.List;

/*
* @author Mohd-Umar
* @version 0.1
* @since 2023-12-01
*/

public class CommonPageActions extends BaseClass {

	static CommonPage commonPage = PageFactory.initElements(driver, CommonPage.class);
    
    public static void verifyPageTitle(String expectedTitle) {
    	BaseClass.verifyPageTitle(expectedTitle);
    }
    
    public static void closePendingActionsReminder() {
    	
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.elementToBeClickable(commonPage.getSnoozePendingActionsNotification()));
    	
    	clickSnoozePendingActionsNotification();
    }
    
    
    public static void selectNoShowPendingActions() {
    	
    	List<WebElement> tableBlock = driver.findElements(By.xpath("//table[@id='dueAppointmentTable']"));
    	List<WebElement> totalNoShow = driver.findElements(By.xpath("//span[@class='mdlTableIcn noShow']"));
    	List<WebElement> noShowReason = driver.findElements(By.xpath("//span[@class='mdlTableIcn noShow']/../../../../td[@class='form-group']/div/select"));
    	
    	int noShowSize = totalNoShow.size();
    	System.out.println("Total no. of pending appointments "+noShowSize);
    	
    	int noShowReasonSize = noShowReason.size();
    	boolean noShowMatch = (noShowSize==noShowReasonSize);
    	System.out.println("No show matches? "+noShowMatch);
    	
    	for(WebElement noShowIterator:totalNoShow) {
    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    		wait.until(ExpectedConditions.elementToBeClickable(noShowIterator));
    		noShowIterator.click();
    	}
    	
    	for(int i=0;i<noShowReasonSize;i=i+2) {
    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    		wait.until(ExpectedConditions.elementToBeClickable(noShowReason.get(i)));
    		
    		Select select = new Select(noShowReason.get(i));
    		select.selectByVisibleText("Already interacted");
    	}
    	
    	noShowSize = totalNoShow.size();
    	System.out.println("Total no. of pending appointments "+noShowSize);
    	clickSavePendingActionsNotification();
    	
    }
    
    
    public static void clickSnoozePendingActionsNotification() {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.elementToBeClickable(commonPage.getSnoozePendingActionsNotification()));
    	commonPage.getSnoozePendingActionsNotification().click();
    	
    	
    }
    
    public static void clickSavePendingActionsNotification() {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.elementToBeClickable(commonPage.getSavePendingActionsNotification()));
    	commonPage.getSavePendingActionsNotification().click();
    	BaseClass.waitForSpinnerToDisappear();
    }
    
    
    
    public static void selectClinicFrmHeader(String clinic) {
    	BaseClass.waitForSpinnerToDisappear();
    	BaseClass.waitForElementToDisappear((By.xpath("//div[@class='ui-widget-overlay']")));
        BaseClass.waitForElementVisibility(commonPage.getSearchClinicDropdown(),4000);
        commonPage.getSearchClinicDropdown().clear();
        BaseClass.waitForPageToBecomeActive();
        BaseClass.waitForElementVisibility(commonPage.getSearchClinicDropdown(),4000);
        commonPage.getSearchClinicDropdown().sendKeys(clinic);
        BaseClass.waitForSpinnerToDisappear();
        BaseClass.waitForElementVisibility(commonPage.getSearchClinicDropdown(),4000);
        BaseClass.waitForPageToBecomeActive();
        WebElement element = driver.findElement(By.xpath("//a[contains(text(),'" + clinic + "')]"));
        BaseClass.waitForElementVisibility(element, 4000);
        BaseClass.hoverOnElement(element);
        element.click();
        BaseClass.waitForPageToBecomeActive();
        
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
				}
			}
		} catch (NoSuchElementException e) {
			System.out.println("Pending actions notification appeared and couldn't be closed");
		}
    }

//    public static void selectClinicFrmHeader(String clinic) {
//        BaseClass.waitForPageLoad();
//        BaseClass.waitForElementToDisappear((By.xpath("//div[contains(@class='ui-widget-overlay')]")));
//        commonPage.getSearchClinicDropdown().clear();
//        commonPage.getSearchClinicDropdown().sendKeys(clinic);
//        try {
//            Thread.sleep(6000);
//            WebElement element = driver.findElement(By.xpath("//a[contains(text(),'" + clinic + "')]"));
//            BaseClass.hoverOnElement(element);
//            element.click();
//            Thread.sleep(6000);
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
    
    public static void backToDoctorDashbrd(){
    	BaseClass.waitForSpinnerToDisappear();
        BaseClass.waitForElementVisibility(commonPage.getLogo(), 4000);
        BaseClass.waitForModalOverlayToDisappear();
        //BaseClass.waitForModalBackdropToDisappear();
        try {
        	Thread.sleep(2000);
        	commonPage.getLogo().click();
        }
        catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        
    }

    public static void backTODoctorDashboard() {
    	BaseClass.waitForSpinnerToDisappear();
        BaseClass.waitForElementVisibility(commonPage.getLogo(), 4000);
    	BaseClass.waitForSpinnerToDisappearOnDoctorDashboard();
        BaseClass.waitForElementVisibility(commonPage.getLogo(), 6000);
        BaseClass.waitForElementToBeClickable(commonPage.getLogo());
        commonPage.getLogo().click();
//        try {
//            BaseClass.waitForElementToBeClickable(commonPage.getLogo());
//            Thread.sleep(4000);
//            commonPage.getLogo().click();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public static void clickOnlogOut() {
        BaseClass.waitForPageLoad();
        try {
            Thread.sleep(6000);
            commonPage.getLogout().click();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
//    public static void clickOnSearchBtn() {
//        BaseClass.waitForPageLoad();
//        BaseClass.waitForSpinnerToDisappear();
//        BaseClass.waitForElementVisibility(commonPage.getSearchBtn(), 4000);
////        BaseClass.waitForElementToBeClickable(commonPage.getSearchBtn());
//        commonPage.getSearchBtn().click();
//    }

    public static void clickOnSearchBtn() {
        BaseClass.waitForPageLoad();
        BaseClass.waitForSpinnerToDisappear();
        BaseClass.waitForElementToBeClickable(commonPage.getSearchBtn());
        try {
            Thread.sleep(4000);
            BaseClass.waitForUIWidgetOverlayToDisappear();
            commonPage.getSearchBtn().click();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
  
    public static void enterMobileNo(String patientMobileNum) {
        BaseClass.waitForPageLoad();
        BaseClass.waitForElementToBeClickable(commonPage.getSearchBox());
        commonPage.getSearchBox().sendKeys(patientMobileNum);
    }
    
//    public static void clickOnPatient(String mobile_no, String patient_name) {
//        BaseClass.waitForSpinnerToDisappear();
//        WebElement patientName =   driver.findElement(By.xpath("//td[contains(text(),'" + mobile_no
//                    + "')]/preceding-sibling::td//a[contains(text(),'" + patient_name + "')]"));
//        BaseClass.waitForElementVisibility(patientName, 4000);
//        patientName.click();
//       }
    

    public static void clickOnPatient(String mobile_no, String patient_name) {
        BaseClass.waitForSpinnerToDisappear();
        BaseClass.waitForElementVisibility(commonPage.getLogo(), 4000);
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
           WebElement patientElement = driver.findElement(By.xpath("//td[contains(text(),'" + mobile_no
                    + "')]/preceding-sibling::td//a[contains(text(),'" + patient_name + "')]"));
           BaseClass.waitForElementVisibility(patientElement, 4000);
           BaseClass.waitForModalOverlayToDisappear();
           patientElement.click();
try {
	Thread.sleep(2000);
}catch (InterruptedException e) {
    e.printStackTrace();
}
    }

    public static void editPatient(String patient, String mobile) {
        BaseClass.waitForPageLoad();
        try {
            Thread.sleep(7000);
            driver.findElement(By.xpath("//a[contains(text(),'" + patient + "')]/ancestor::td/following-sibling::td[contains(text(),'" + mobile + "')]/following-sibling::td//span[@class='actn-icn edit']")).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static String verification() {
//        BaseClass.waitForSpinnerToDisappear();
        return driver.getTitle();
    }
    
//    public static void verifyPageTitle(String expectedTitle) {
//    	BaseClass.verifyPageTitle(expectedTitle);
//    }
    
//    public String verification() {
//        BaseClass.waitForPageLoad();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return BaseClass.getTitle();
//    }


}
