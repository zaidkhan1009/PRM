package pageActions.doctorDashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import base.BaseClass;
import pages.doctorDashboard.AppointmentAddPage;
import pages.doctorDashboard.Login;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
 * @author Mohd-Umar
 * @version 0.1
 * @since 2023-12-01
 */

public class AppointmentAddPageActions extends BaseClass {

	static AppointmentAddPage appointmentPage = PageFactory.initElements(driver, AppointmentAddPage.class);

	public static void checkAppointmentInClinic() {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(appointmentPage.getAppointmentTab(), 4000);
		System.out.println(checkWebElementDisplayed(appointmentPage.getAppointmentTab()));
		System.out.println(appointmentPage.getAppointmentTab().getAttribute("class").contains("active"));
		System.out.println(checkWebElementDisplayed(appointmentPage.getInClinicAppointment()));
		System.out.println(appointmentPage.geteConsultAppointment().getAttribute("class").contains("selected"));
		Assert.assertTrue(checkWebElementDisplayed(appointmentPage.getAppointmentTab())
				&& appointmentPage.getAppointmentTab().getAttribute("class").contains("active")
				&& checkWebElementDisplayed(appointmentPage.getInClinicAppointment())
				&& appointmentPage.getInClinicAppointment().getAttribute("class").contains("selected"));
	}

	public static void checkAppointmenteConsult() {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(appointmentPage.getAppointmentTab(), 4000);
		Assert.assertTrue(checkWebElementDisplayed(appointmentPage.getAppointmentTab())
				&& appointmentPage.getAppointmentTab().getAttribute("class").contains("active")
				&& checkWebElementDisplayed(appointmentPage.geteConsultAppointment())
				&& appointmentPage.geteConsultAppointment().getAttribute("class").contains("selected"));
	}

//    public void checkAppointmentInClinic() {
////        BaseClass.waitForPageLoad();
//        BaseClass.waitForSpinnerToDisappear();
//        try {
//        	Thread.sleep(3000);
//        }
//        catch(Exception e) {
//        	e.printStackTrace();
//        }
//        Assert.assertTrue(checkWebElementDisplayed(appointmentPage.getAppointmentTab()) && appointmentPage.getAppointmentTab().getAttribute("class").contains("active") && checkWebElementDisplayed(appointmentPage.getInClinicAppointment()) && appointmentPage.getInClinicAppointment().getAttribute("class").contains("selected"));
//    }

	public static void selectInClinic() {
		BaseClass.waitForPageLoad();
		if (!appointmentPage.getInClinicAppointment().getAttribute("class").contains("selected")) {
			appointmentPage.getInClinicAppointment().click();
		}
	}

	public static void selectEConsult() {
		BaseClass.waitForSpinnerToDisappear();
		if (!appointmentPage.geteConsultAppointment().getAttribute("class").contains("selected")) {
			JavascriptExecutor j = (JavascriptExecutor) driver;
			j.executeScript("arguments[0].click();", appointmentPage.geteConsultAppointment());
		}
		BaseClass.waitForSpinnerToDisappear();
	}

	public static void selectScan() {
		BaseClass.waitForSpinnerToDisappear();
		if (!appointmentPage.geteConsultAppointment().getAttribute("class").contains("selected")) {
			JavascriptExecutor j = (JavascriptExecutor) driver;
			j.executeScript("arguments[0].click();", appointmentPage.getScanAppointment());
			BaseClass.waitForSpinnerToDisappear();
		}
	}

	public static void selectClinicServiceType() {
		appointmentPage.getClinicServiceType().click();
		BaseClass.waitForElementVisibility(appointmentPage.getServiceClinic(), 4000);
	}

	public static void verifyServiceType(String serviceType) {
		switch (serviceType) {
		case "Home":
			Assert.assertTrue(appointmentPage.getHomeServiceType().isSelected());
			Assert.assertTrue(checkWebElementDisplayed(appointmentPage.getServiceAddress()));
			Assert.assertTrue(checkWebElementDisplayed(appointmentPage.getServiceCity()));
			Assert.assertTrue(checkWebElementDisplayed(appointmentPage.getServicePincode()));
			Assert.assertTrue(checkWebElementDisplayed(appointmentPage.getServiceState()));
			break;

		case "Clinic":
			selectClinicServiceType();
			BaseClass.waitForElementVisibility(appointmentPage.getServiceClinic(), 4000);
			Assert.assertTrue(checkWebElementDisplayed(appointmentPage.getServiceClinic()));
			break;
		}
	}

	public static void validateServiceTypeMandatoryFieldsMessages(String serviceType) {
		switch (serviceType) {
		case "Home":
			Assert.assertTrue(appointmentPage.getHomeServiceType().isSelected());
			Assert.assertTrue(checkWebElementDisplayed(appointmentPage.getServiceAddressErrMsg()));
			Assert.assertTrue(checkWebElementDisplayed(appointmentPage.getServiceCityErrMsg()));
			Assert.assertTrue(checkWebElementDisplayed(appointmentPage.getServicePincodeErrMsg()));
			Assert.assertTrue(checkWebElementDisplayed(appointmentPage.getServiceStateErrMsg()));
			break;
		case "Clinic":
			appointmentPage.getClinicServiceType().click();
			BaseClass.waitForElementVisibility(appointmentPage.getServiceClinicErrMsg(), 4000);
			Assert.assertTrue(checkWebElementDisplayed(appointmentPage.getServiceClinicErrMsg()));
			break;
		}
	}

	public static void addHomeServiceAddress(String address) {
		appointmentPage.getServiceAddress().sendKeys(address);
	}

	public static void addHomeServiceCity(String city) {
		appointmentPage.getServiceCity().sendKeys(city);
	}

	public static void addHomeServicePincode(String pincode) {
		appointmentPage.getServicePincode().sendKeys(pincode);
	}

	public static void selectServiceState(String state) {
		BaseClass.selectFromDropDownByVisibleText(appointmentPage.getServiceState(), state);
	}

	public static void selectServiceClinic(String clinic) {
		BaseClass.selectFromDropDownByVisibleText(appointmentPage.getServiceClinic(), clinic);
	}

//    public void selectEConsult() {
////        BaseClass.waitForPageLoad();
//        BaseClass.waitForSpinnerToDisappear();
//        if (!appointmentPage.geteConsultAppointment().getAttribute("class").contains("selected")) {
//        	System.out.println("Jai Hind");
////         	loginPage.waitForElementToBeClickable(appointmentPage.geteConsultAppointment());
//         	appointmentPage.geteConsultAppointment().click();
//        }
//    }

	public static void enterMobileNoMsg() {
		BaseClass.waitForElementToBeClickable(appointmentPage.getEnterMobileNoMsg());
		Assert.assertTrue(checkWebElementDisplayed(appointmentPage.getEnterMobileNoMsg()));
	}

	public static void enterTenDigitMobileNoMsg() {
		BaseClass.waitForElementToBeClickable(appointmentPage.getEnterTenDigitMobileNoMsg());
		Assert.assertTrue(checkWebElementDisplayed(appointmentPage.getEnterTenDigitMobileNoMsg()));
	}

	public static void enterValidMobileNoMsg() {
		BaseClass.waitForElementToBeClickable(appointmentPage.getEnterValidMobileNoMsg());
		Assert.assertTrue(checkWebElementDisplayed(appointmentPage.getEnterValidMobileNoMsg()));
	}

	public static void selectPatientSuggestion(String patient) {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(4000);
			WebElement web = driver.findElement(By.xpath("//a[contains(text(),'" + patient + "')]"));
			BaseClass.hoverOnElement(web);
			web.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void covidStatusUpdate() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementToBeClickable(appointmentPage.getCovidUpdateSuccessMsg());
		Assert.assertTrue(checkWebElementDisplayed(appointmentPage.getCovidUpdateSuccessMsg()));
	}

	public static void patientCovidGreen() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(appointmentPage.getGreenCovidPatient());
		Assert.assertTrue(checkWebElementDisplayed(appointmentPage.getGreenCovidPatient()));
		BaseClass.waitForSpinnerToDisappear();
	}

	public static void patientCovidRed() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(appointmentPage.getRedCovidPatient());
		Assert.assertTrue(checkWebElementDisplayed(appointmentPage.getRedCovidPatient()));
	}

	public static void openCovidForm() {
		BaseClass.waitForModalOverlayToDisappear();
		try {
			BaseClass.waitForElementToBeClickable(appointmentPage.getCovidFormBtn());
			appointmentPage.getCovidFormBtn().click();
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void checkPatientCovidStatus() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(appointmentPage.getHeaderCovid());
		Assert.assertTrue(
				checkWebElementDisplayed(appointmentPage.getGreyFlag()) && checkWebElementDisplayed(appointmentPage.getNotAvailableGrey())
						&& checkWebElementDisplayed(appointmentPage.getCovidFormBtn()));
	}

	public static void covidOption() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(appointmentPage.getPatientCovidStatus());
		Assert.assertTrue(checkWebElementDisplayed(appointmentPage.getHeaderCovid())
				&& appointmentPage.getPatientCovidStatus().getText().contains("Status not known"));
	}

	public static void covidAlertMsgGrey() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(appointmentPage.getCovidFlagAlertMsg());
		Assert.assertTrue(appointmentPage.getCovidFlagAlertMsg().getText().contains(
				"Appointment Booking is blocked for grey status, please fill the Covid-19 Declaration to update the patient status!"));
	}

	public static void covidAlertMsgRed() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(appointmentPage.getCovidFlagAlertMsg());
		Assert.assertTrue(appointmentPage.getCovidFlagAlertMsg().getText()
				.contains("Appointment Booking is blocked for (red) status till"));
	}

	public static void clickOnTentative() {
		BaseClass.waitForPageLoad();
		try {
		BaseClass.waitForModalOverlayToDisappear();
		BaseClass.waitForElementToBeClickable(appointmentPage.getTentativeBtn());
		appointmentPage.getTentativeBtn().click();
		} catch(NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	public static void covidAlertMsgRedAutoSuggestion() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(appointmentPage.getCovidFlagAlertMsg());
		Assert.assertTrue(appointmentPage.getCovidFlagAlertMsg().getText()
				.contains("Appointment Booking is blocked for"));
	}

	public static void verifyTentativeAfterClickOnEditBtn() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(appointmentPage.getTentativeCheckbox().isSelected());
		BaseClass.waitForPageLoad();
	}

	public static void patientNameTextFields() {
		BaseClass.waitForElementToBeClickable(appointmentPage.getPatientName());
		Assert.assertTrue(checkWebElementDisplayed(appointmentPage.getPatientName())
				&& appointmentPage.getPatientName().getAttribute("placeholder").contains("patient name"));
	}

	public static void patientMobileTextFields() {
		BaseClass.waitForElementToBeClickable(appointmentPage.getPatientMobile());
		Assert.assertTrue(checkWebElementDisplayed(appointmentPage.getPatientMobile())
				&& appointmentPage.getPatientMobile().getAttribute("placeholder").contains("enter 10 digit mobile no"));
	}

	public static void patientIdTextFields() {
		BaseClass.waitForElementToBeClickable(appointmentPage.getPatientId());
		Assert.assertTrue(checkWebElementDisplayed(appointmentPage.getPatientId())
				&& appointmentPage.getPatientId().getAttribute("placeholder").contains("patient id"));
	}

	public static void patientEmailIdTextFields() {
		BaseClass.waitForElementToBeClickable(appointmentPage.getPatientEmail());
		Assert.assertTrue(checkWebElementDisplayed(appointmentPage.getPatientEmail())
				&& appointmentPage.getPatientEmail().getAttribute("placeholder").contains("email"));
	}

	public static void clinicDrpDwn() {
		BaseClass.waitForElementToBeClickable(appointmentPage.getPatientEmail());
		Assert.assertTrue(checkWebElementDisplayed(appointmentPage.getPatientEmail()));
	}

	public static void dateCalender() {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(appointmentPage.getDateAppointment(), 4000);
//        loginPage.waitForElementToBeClickable(appointmentPage.getDateAppointment());
		Assert.assertTrue(checkWebElementDisplayed(appointmentPage.getDateAppointment()));
	}

	public static void timeSlotDrpDwn() {
		BaseClass.waitForElementVisibility(appointmentPage.getTimeSlot());
		Assert.assertTrue(checkWebElementDisplayed(appointmentPage.getTimeSlot()) && defaultSlotSelection());
	}

	public static void timeDurationTextFields() {
		BaseClass.waitForElementVisibility(appointmentPage.getFormDuration());
		Assert.assertTrue(checkWebElementDisplayed(appointmentPage.getFormDuration()) && byDefaultDuration());
	}

	public static void doctorDrpDwn() {
		BaseClass.waitForElementVisibility(appointmentPage.getDoctor());
		Assert.assertTrue(checkWebElementDisplayed(appointmentPage.getDoctor())
				&& BaseClass.firstSelectedOption(appointmentPage.getDoctor()).equalsIgnoreCase("Select Doctor"));

	}

	public static void referralDrpDwn() {
		BaseClass.waitForElementVisibility(appointmentPage.getReferral());
		Assert.assertTrue(checkWebElementDisplayed(appointmentPage.getReferral())
				&& BaseClass.firstSelectedOption(appointmentPage.getReferral()).equalsIgnoreCase("Select Referral"));
	}

	public static void sourceDrpDwn() {
		BaseClass.waitForElementVisibility(appointmentPage.getSource());
		Assert.assertTrue(checkWebElementDisplayed(appointmentPage.getSource())
				&& BaseClass.firstSelectedOption(appointmentPage.getSource()).equalsIgnoreCase("Select Source"));
	}

	public static void notesFields() {
		BaseClass.waitForElementVisibility(appointmentPage.getNotes());
		Assert.assertTrue(checkWebElementDisplayed(appointmentPage.getNotes())
				&& appointmentPage.getNotes().getAttribute("placeholder").contains("notes"));
	}

	public static void tentativeCheckBox() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(!appointmentPage.getTentativeCheckbox().isSelected());
	}

	public static void chiefComplaints() {
//        BaseClass.waitForPageLoad();
		Assert.assertTrue(checkWebElementDisplayed(appointmentPage.getChiefComplaints())
				&& checkWebElementDisplayed(appointmentPage.getPain()) && checkWebElementDisplayed(appointmentPage.getSensitivity())
				&& checkWebElementDisplayed(appointmentPage.getSwollenGums())
				&& checkWebElementDisplayed(appointmentPage.getChewingDifficulty())
				&& checkWebElementDisplayed(appointmentPage.getBadBreath()) && checkWebElementDisplayed(appointmentPage.getBleedingGums())
				&& checkWebElementDisplayed(appointmentPage.getDiscoloredTooth()) && checkWebElementDisplayed(appointmentPage.getPlaque())
				&& checkWebElementDisplayed(appointmentPage.getToothDecay())
				&& checkWebElementDisplayed(appointmentPage.getTeethGrinding())
				&& checkWebElementDisplayed(appointmentPage.getLooseTeeth()));
	}

	public static void clickOnChiefComplaints(String chiefComplaint) {
		BaseClass.waitForPageLoad();
		WebElement element = driver.findElement(By.xpath("//span[text()='" + chiefComplaint + "']"));
		BaseClass.waitForElementToBeClickable(element);
		element.click();
	}

	public static void otherChiefComplaint() {
//        BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(appointmentPage.getOtherChiefComplaintBox());
		Assert.assertTrue(checkWebElementDisplayed(appointmentPage.getOtherChiefComplaintBox())
				&& appointmentPage.getOtherChiefComplaintBox().getAttribute("placeholder").contains("other chief complaint"));
	}

	public static void actionsBtnAppointmentAdd() {
//        BaseClass.waitForPageLoad();
		Assert.assertTrue(
				checkWebElementDisplayed(appointmentPage.getSaveBtn()) && checkWebElementDisplayed(appointmentPage.getCancelBtn())
						&& checkWebElementDisplayed(appointmentPage.getAppResetBtn()));
	}

	public static void getTextPatientName(String expected) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForSpinnerToDisappear();
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		Object obj = javascriptExecutor.executeScript("return document.getElementById('patientname').value;");
		String actual = (String) obj;
		Assert.assertEquals(actual, expected);
	}

//    public void getTextPatientName(String expected) {
//        BaseClass.waitForPageLoad();
//        try {
//            Thread.sleep(10000);
//            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
//            Object obj = javascriptExecutor.executeScript("return document.getElementById('patientname').value;");
//            String actual = (String) obj;
//            Assert.assertEquals(actual, expected);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

	public static void verifyMandatoryFieldsOnEdit() {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(10000);
			Assert.assertTrue(!fieldReadOnly(appointmentPage.getPatientName()) && !fieldReadOnly(appointmentPage.getPatientId())
					&& !fieldReadOnly(appointmentPage.getPatientMobile()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void patientIDAfterAutoSelect() {
		BaseClass.waitForPageLoad();
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		Object obj = javascriptExecutor.executeScript("return document.getElementById('patientid').value;");
		String actual = (String) obj;
		Assert.assertTrue(actual != null);
	}

	public static void getTextPatientMobile(String expected) {
		BaseClass.waitForSpinnerToDisappear();
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		Object obj = javascriptExecutor.executeScript("return document.getElementById('mobile').value;");
		String actual = (String) obj;
		System.out.println("The Heo iS" + actual);
		Assert.assertEquals(actual, expected);
	}

	public static void toVerifyAppointmentHomePage() {
		try {
			Thread.sleep(6000);
			BaseClass.waitForPageLoad();
			Assert.assertTrue(driver.getTitle().contains("Appointment"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void enterPatientName(String name) {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(appointmentPage.getPatientName(), 4000);
		appointmentPage.getPatientName().clear();
		appointmentPage.getPatientName().sendKeys(name);
	}

//    public void enterPatientName(String name) {
//        BaseClass.waitForPageLoad();
//        loginPage.waitForElementToBeClickable(appointmentPage.getPatientName());
//        appointmentPage.getPatientName().clear();
//        appointmentPage.getPatientName().sendKeys(name);
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//    
	public static void enterMobileNumber(String mobileNum) {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(appointmentPage.getPatientMobile(), 4000);
		appointmentPage.getPatientMobile().clear();
		appointmentPage.getPatientMobile().sendKeys(mobileNum);
	}

//    public void enterMobileNumber(String mobileNum) {
//        BaseClass.waitForPageLoad();
//        loginPage.waitForElementToBeClickable(appointmentPage.getPatientMobile());
//        appointmentPage.getPatientMobile().clear();
//        appointmentPage.getPatientMobile().sendKeys(mobileNum);
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

	public static void enterEmailAddress(String email) {
		BaseClass.waitForSpinnerToDisappear();
		;
		appointmentPage.getPatientEmail().clear();
		appointmentPage.getPatientEmail().sendKeys(email);
	}

//    public void enterEmailAddress(String email) {
//        BaseClass.waitForPageLoad();
//        loginPage.WaitTillElementIsPresent(appointmentPage.getPatientEmail());
//        appointmentPage.getPatientEmail().clear();
//        appointmentPage.getPatientEmail().sendKeys(email);
//        try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//    }

	public static void enterTimeDuration(String duration) {
		BaseClass.waitForPageLoad();
		appointmentPage.getFormDuration().clear();
		appointmentPage.getFormDuration().sendKeys(duration);
	}

	public static void selectClinicFromDropdown(String clinic) {
		BaseClass.waitForElementToBeClickable(appointmentPage.getClinicDropDown());
		appointmentPage.getClinicDropDown().clear();
		appointmentPage.getClinicDropDown().sendKeys(clinic);
		BaseClass.waitForSpinnerToDisappear();
		WebElement centreList = driver.findElement(By.xpath("//li[contains(text(),'" + clinic + "')]"));
		BaseClass.waitForElementVisibility(centreList, 4000);
		centreList.click();
//    	loginPage.getDriver().findElement(By.xpath("//li[contains(text(),'"+clinic+"')]")).click();
//        loginPage.selectFromDropDownByVisibleText(appointmentPage.getPatientEmail(), clinic);
	}

	public static void selectDateofAppointment(String Date) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(appointmentPage.getDateAppointment());
		BaseClass.selectDateofAppCal(Date, appointmentPage.getDateAppointment());
	}

	public static void appointmentDate(String Date) {
//        BaseClass.waitForPageLoad();
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementToBeClickable(appointmentPage.getDateAppointment());
		BaseClass.appointmentDate(Date, appointmentPage.getDateAppointment(), "date");
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).perform();
	}

	public static void selectDoctorFromDropdown(String doctorName) {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.WaitTillElementIsPresent(appointmentPage.getDoctor());
		
		//test block to handle the overlay element
		
		try {
		
		boolean isElementPresent = 
				(driver.findElements(By.xpath("//div[contains(@class='ui-widget-overlay')]")).size()>0);
		
		if(isElementPresent)
		{
			BaseClass.waitForElementToDisappear((By.xpath("//div[contains(@class='ui-widget-overlay')]")));
		}

		}
		
		catch(InvalidSelectorException e) {
			
			Robot robot = null;
			try {
				robot = new Robot();
			} catch (AWTException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			robot.keyPress(KeyEvent.VK_TAB);
			
			
		}
		
		//commenting the below to handle it in above block
		
		//BaseClass.waitForElementToDisappear((By.xpath("//div[contains(@class='ui-widget-overlay')]")));


//        try {
//			Thread.sleep(4000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		appointmentPage.getDoctor().click();
		BaseClass.selectFromDropDownByVisibleText(appointmentPage.getDoctor(), doctorName.trim());
	}

	public static void doctorSelected(String doctor_selected) {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(BaseClass.firstSelectedOption(appointmentPage.getDoctor()).contains(doctor_selected));
	}

	public static void clinicSelected(String clinic_Selected) {
		BaseClass.waitForSpinnerToDisappear();
		String selectedCentreName = driver.findElement(By.xpath("//div[@class='drpdwnLabel ng-binding']")).getText();
		Assert.assertTrue(selectedCentreName.contains(clinic_Selected));
	}

//    public void clinicSelected(String clinic_Selected) {
//        BaseClass.waitForPageLoad();
//        Assert.assertTrue(loginPage.firstSelectedOption(appointmentPage.getPatientEmail()).contains(clinic_Selected));
//    }

	public static void slotSelected(String slot_Selected) {
		BaseClass.waitForSpinnerToDisappear();
		;
		WebElement firstOption = driver.findElement(
				By.xpath("//label[@for='slot']/..//select[@data-ng-model='value']/option[@selected='selected']"));
		Assert.assertEquals(firstOption.getText().trim(), slot_Selected);
	}

//    public void slotSelected(String slot_Selected) {
//        BaseClass.waitForPageLoad();
//        appointmentPage.getTimeSlot().click();
//        WebElement firstOption = loginPage.getDriver().findElement(By.xpath("//label[@for='slot']/..//select[@data-ng-model='value']/option[@selected='selected']"));
//        loginPage.hoverOnElement(firstOption);
//        Assert.assertEquals(firstOption.getText().trim(), slot_Selected);
//        appointmentPage.getTimeSlot().click();
//    }

	public static void sourceSelected(String source_Selected) {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(BaseClass.firstSelectedOption(appointmentPage.getSource()).contains(source_Selected));
	}

	public static void referralSelected(String referral_Selected) {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(BaseClass.firstSelectedOption(appointmentPage.getReferral()).contains(referral_Selected));
	}

	public static void getReferralDetails(String expected) {
		BaseClass.waitForPageLoad();
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		Object obj = javascriptExecutor.executeScript("return document.getElementById('refDetails').value;");
		String actual = (String) obj;
		Assert.assertEquals(actual, expected);
	}

	public static void getNotes(String expected) {
		BaseClass.waitForPageLoad();
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		Object obj = javascriptExecutor.executeScript("return document.getElementById('appointment_note').value;");
		String actual = (String) obj;
		Assert.assertEquals(actual, expected);
	}

	public static void selectDoctorFromDropdownByIndex(int index) {
		BaseClass.waitForPageLoad();
		BaseClass.WaitTillElementIsPresent(appointmentPage.getDoctor());
		BaseClass.selectFromDropDownByIndex(appointmentPage.getDoctor(), index);
	}

	public static void selectTimeSlotFromDropdown(String timeslt) {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.selectFromDropDownByVisibleText(appointmentPage.getTimeSlot(), timeslt);
	}
	
	public static String getTimeSlotFromDropdown() {
		
		String time;
		BaseClass.waitForSpinnerToDisappear();
		Select select = new Select(appointmentPage.getTimeSlot());
		time = select.getFirstSelectedOption().getText();
		System.out.println(time);
		return time;
	}

	public static void enterNote(String note) {
		BaseClass.waitForPageLoad();
		appointmentPage.getNotes().clear();
		appointmentPage.getNotes().sendKeys(note);
	}

	public static void enterPatientNameMsg() {
		BaseClass.WaitTillElementIsPresent(appointmentPage.getEnterPatientNameMsg());
		Assert.assertTrue(checkWebElementDisplayed(appointmentPage.getEnterPatientNameMsg()));
	}

	public static void pleaseSelectDoctorMsg() {
		BaseClass.WaitTillElementIsPresent(appointmentPage.getPleaseSelectDoctorMsg());
		Assert.assertTrue(appointmentPage.getPleaseSelectDoctorMsg().isDisplayed());
	}

	public static void selectReferralFromDropdown(String referralName) {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForPageToBecomeActive();
		BaseClass.waitForElementVisibility(appointmentPage.getReferral(), 4000);
		BaseClass.selectFromDropDownByVisibleText(appointmentPage.getReferral(), referralName);
	}

//    public void selectReferralFromDropdown(String referralName) {
//       BaseClass.waitForPageLoad();
//       loginPage.waitForElementToBeClickable(referral);
//        BaseClass.waitForElementVisibility(referral, 4000);
//       try {
//		Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//        loginPage.selectFromDropDownByVisibleText(referral, referralName);
//    }

	public static void referralDetails() {
//        BaseClass.waitForPageLoad();
		Assert.assertTrue(checkWebElementDisplayed(appointmentPage.getReferralDetails())
				&& appointmentPage.getReferralDetails().getAttribute("placeholder").contains("referral details"));
	}

	public static void enterReferralDetails(String referral_Details) {
		BaseClass.waitForPageLoad();
		appointmentPage.getReferralDetails().sendKeys(referral_Details);
	}

	public static void selectSourceFromDropdown(String sourceName) {
		BaseClass.waitForElementToBeClickable(appointmentPage.getSource());
		BaseClass.selectFromDropDownByVisibleText(appointmentPage.getSource(), sourceName);
	}

	public static void clickOnSaveBtn() {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.WaitTillElementIsPresent(appointmentPage.getSaveBtn());
		appointmentPage.getSaveBtn().click();
		BaseClass.waitForPageToBecomeActive();
//        loginPage.waitForElementToDisappear((By.xpath("//div[contains(text(),'Appointment added successfully!')]")));
		BaseClass.waitForElementToDisappear(By.xpath("//div[text()='Patient Covid-19 Declaration saved successfully!']"));
		BaseClass.waitForElementToBeClickable(appointmentPage.getSaveBtn());
		appointmentPage.getSaveBtn().click();
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForUIWidgetOverlayToDisappear();
//		BaseClass.waitForElementToDisappear((By.xpath("//div[contains(text(),'Appointment added successfully!')]")));

	}

	public static void clickOnCancelBtn() {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(appointmentPage.getCancelBtn(), 4000);
		BaseClass.waitForElementToBeClickable(appointmentPage.getCancelBtn());
		appointmentPage.getCancelBtn().click();
	}

	public static void clickOnAppResetBtn() {
		BaseClass.waitForSpinnerToDisappear();
//    	loginPage.waitForElementToDisappear((By.xpath("//div[contains(@class='modal overlay show')]")));
		BaseClass.waitForElementToBeClickable(appointmentPage.getAppResetBtn());
//        loginPage.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		appointmentPage.getAppResetBtn().click();
	}

	public static void clickOnAddApptBtn() {
		BaseClass.waitForPageLoad();
		BaseClass.WaitTillElementIsPresent(appointmentPage.getApptBtn());
		try {
			Thread.sleep(4000);
			appointmentPage.getApptBtn().click();
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

//    public void clickOnAddApptBtn() {
//        BaseClass.waitForPageLoad();
//        loginPage.WaitTillElementIsPresent(appointmentPage.getApptBtn());
//        try {
//            Thread.sleep(4000);
//            appointmentPage.getApptBtn().click();
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

	public static boolean defaultSlotSelection() {
		BaseClass.waitForPageLoad();
		BaseClass.WaitTillElementIsPresent(appointmentPage.getTimeSlot());
		String slot;
		String currentTime = BaseClass.getCurrentLocalDateTimeStamp();
		String[] time = currentTime.split(":");
		String hour = time[0];
		int hr = Integer.parseInt(hour.trim());
		int nxt_slot = ++hr;
		String nxt_slotAsString = Integer.toString(nxt_slot);
		String date2 = nxt_slotAsString + ":00";
		String date1 = time[0] + ":30";
		if (currentTime.compareTo(date1) < 0) {
			slot = date1;
		} else {
			slot = date2;
		}

		BaseClass.selectFromDropDownByVisibleText(appointmentPage.getSelectSlot(), slot);
		WebElement slotElement = driver.findElement(By.xpath("//option[contains(@value,'" + slot + "')]"));
//        loginPage.hoverOnElement(slotElement);
		BaseClass.waitForElementVisibility(slotElement, 3000);
		String slotTime = slotElement.getText();
		String expected = slot.trim();
		String actual = slotTime.trim();
		return actual.equalsIgnoreCase(expected);
	}

	public static void selectingFutureDateAndVerifyStartTime(int days) {
		BaseClass.waitForElementToDisappear((By.xpath("//div[contains(@class='modal overlay show')]")));
//       loginPage.waitForElementToDisappear((By.xpath("//div[contains(@class='ui-widget-overlay')]")));
		String startingTime = "09:00";
		BaseClass.waitForElementToDisappear((By.xpath("//div[contains(@class='modal overlay show')]")));
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, days);
//       datepicker.appointmentDate(simpleDateFormat.format(c.getTime()), d);
		// appointmentPage.getTimeSlot().click();
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.selectFromDropDownByVisibleText(appointmentPage.getSelectSlot(), startingTime);
		WebElement firstOption = driver
				.findElement(By.xpath("//custom-combo-new[@id='TimeSlot']//option[@selected='selected']"));
//        loginPage.hoverOnElement(firstOption);
		BaseClass.waitForElementVisibility(firstOption, 3000);
		Assert.assertEquals(firstOption.getText().trim(), startingTime);
	}

	public static boolean byDefaultDuration() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(appointmentPage.getFormDuration());
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		String actual = javascriptExecutor.executeScript(
				"return angular.element(document.getElementById('duration')).scope().patient.appointmentData.slot_duration;")
				.toString();
		return actual.equalsIgnoreCase("30");
	}

	public static void autoSelectMobile(String mobileNum) {
		BaseClass.WaitTillElementIsPresent(appointmentPage.getPatientMobile());
		appointmentPage.getPatientMobile().sendKeys(mobileNum);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		BaseClass.WaitTillElementIsPresent(appointmentPage.getAutoSeletwb());
		BaseClass.hoverOnElement(appointmentPage.getAutoSeletwb());
		appointmentPage.getAutoSeletwb().click();
	}

	public static void autoSelectPatientName(String PatientName) {
		BaseClass.WaitTillElementIsPresent(appointmentPage.getPatientName());
		appointmentPage.getPatientName().sendKeys(PatientName);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		BaseClass.WaitTillElementIsPresent(appointmentPage.getAutoSeletwb());
		BaseClass.hoverOnElement(appointmentPage.getAutoSeletwb());
		appointmentPage.getAutoSeletwb().click();
	}

	public static void enterValidEmailAddressMsg() {
		BaseClass.waitForPageLoad();
		BaseClass.WaitTillElementIsPresent(appointmentPage.getEnterValidEmailAddressMsg());
		Assert.assertTrue(checkWebElementDisplayed(appointmentPage.getEnterValidEmailAddressMsg()));
	}

	public static void checkFirstOperatoriesIsSelected() {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		BaseClass.waitForElementToBeClickable(appointmentPage.getFirstOperatory());
		Assert.assertTrue(appointmentPage.getOperatory().size() > 0
				&& appointmentPage.getFirstOperatory().getAttribute("class").contains("selected"));
	}

	public static void slectOperatory() {
		BaseClass.waitForPageLoad();
		appointmentPage.getFirstOperatory().click();
		Assert.assertTrue(appointmentPage.getOperatory().size() > 0
				&& appointmentPage.getFirstOperatory().getAttribute("class").contains("selected"));
	}

	public static void operatories() {
//        BaseClass.waitForPageLoad();
		if (checkWebElementDisplayed(appointmentPage.getRooms())) {
			Assert.assertTrue(appointmentPage.getOperatory().size() > 0);
		}
	}

	public static void rooms() {
//        BaseClass.waitForPageLoad();
		if (checkWebElementDisplayed(appointmentPage.getRooms())) {
			Assert.assertTrue(appointmentPage.getTotalRooms().size() > 0
					&& appointmentPage.getTotalRooms().get(0).getAttribute("class").contains("selected"));
		}
	}

	public static void scanners() {
		if (checkWebElementDisplayed(appointmentPage.getScanners())) {
			int getTotalScanners = appointmentPage.getTotalScanners().size();
			if (getTotalScanners == 1) {
				Assert.assertTrue(appointmentPage.getTotalScanners().get(0).getAttribute("class").contains("selected"));
			} else {
				Assert.assertTrue(appointmentPage.getTotalScanners().size() > 0
						&& appointmentPage.getTotalScanners().get(0).getAttribute("class").contains("selected"));
			}
		}
	}

	public static void roomSelected() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(appointmentPage.getTotalRooms().get(0).getAttribute("class").contains("selected"));
	}

	public static void checkingFirstOperatoryIsDisable() {
		BaseClass.waitForPageLoad();
		BaseClass.WaitTillElementIsPresent(appointmentPage.getFirstOperatory());
		Assert.assertTrue(appointmentPage.getFirstOperatory().getAttribute("class").contains("booked"));
	}

	public static void checkSchedulerOptions() {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementToBeClickable(appointmentPage.getGoToSchedularBtn());
		appointmentPage.getGoToSchedularBtn().click();
		BaseClass.waitForElementVisibility(appointmentPage.getSchedularTextMsg(), 4000);
		Assert.assertTrue(appointmentPage.getSchedularTextMsg().isDisplayed() && appointmentPage.getYesBtn().isDisplayed()
				&& appointmentPage.getNoBtn().isDisplayed());
		appointmentPage.getNoBtn().click();
		BaseClass.waitForPageToBecomeActive();
	}

//    public void checkSchedulerOptions() {
//        BaseClass.waitForPageLoad();
//        loginPage.waitForElementToBeClickable(appointmentPage.getGoToSchedularBtn());
//        appointmentPage.getGoToSchedularBtn().click();
//        BaseClass.waitForElementVisibility(appointmentPage.getSchedularTextMsg(), 4000);
////       loginPage.WaitTillElementIsPresent(appointmentPage.getSchedularTextMsg());   
////        try {
////			Thread.sleep(3000);
////		} catch (InterruptedException e) {
////			e.printStackTrace();
////		}
//        Assert.assertTrue(appointmentPage.getSchedularTextMsg().isDisplayed() && appointmentPage.getYesBtn().isDisplayed() && appointmentPage.getNoBtn().isDisplayed());
//        appointmentPage.getNoBtn().click();
//        loginPage.waitForElementToDisappear((By.xpath("//div[@class='modal-backdrop fade  in']")));
//    }

	public static void clickOnGoToSchedulerYesBtn() {
		BaseClass.waitForSpinnerToDisappear();
		appointmentPage.getGoToSchedularBtn().click();
		BaseClass.waitForElementVisibility(appointmentPage.getSchedularTextMsg(), 4000);
		BaseClass.waitForElementToBeClickable(appointmentPage.getYesBtn());
		appointmentPage.getYesBtn().click();
	}

//    public void clickOnGoToSchedulerYesBtn() {
////        BaseClass.waitForPageLoad();
////        loginPage.waitForElementToDisappear((By.xpath("//div[contains(@class='modal-backdrop fade  in")));
//        loginPage.waitForElementToBeClickable(appointmentPage.getGoToSchedularBtn());
////        try {
////			Thread.sleep(3000);
////		} catch (InterruptedException e) {
////			e.printStackTrace();
////		}
//        appointmentPage.getGoToSchedularBtn().click();
////        loginPage.WaitTillElementIsPresent(appointmentPage.getSchedularTextMsg());
//        BaseClass.waitForElementVisibility(appointmentPage.getSchedularTextMsg(), 4000);
//        loginPage.waitForElementToBeClickable(appointmentPage.getYesBtn());
//        appointmentPage.getYesBtn().click();
//    }

	public static void getOperatoryErrMsg() {
		BaseClass.WaitTillElementIsPresent(appointmentPage.getOperatoriesDisableMsg());
		appointmentPage.getOperatoriesDisableMsg().isDisplayed();
	}

	public static void verifyAppointmentUpdateText(String text) {
		BaseClass.waitForElementVisibility(appointmentPage.getUpdateAppnmntTxt(), 4000);
		String getUpdateAppnmntTxt = appointmentPage.getUpdateAppnmntTxt().getText();
		System.out.println(getUpdateAppnmntTxt);
		Assert.assertEquals(text, getUpdateAppnmntTxt);
	}

	public static void verifyrRestrictAppointmentUpdateText(String text) {
		BaseClass.waitForElementVisibility(appointmentPage.getRestrictUpdateAppnmntTxt(), 4000);
		String getUpdateAppnmntTxt = appointmentPage.getRestrictUpdateAppnmntTxt().getText();
		Assert.assertEquals(text, getUpdateAppnmntTxt);
	}

	public static void selectChiefComplaints(String chiefComplaints) {
		BaseClass.waitForPageLoad();
		WebElement webElement = driver.findElement(By.xpath("//span[text()='" + chiefComplaints + "']"));
		BaseClass.WaitTillElementIsPresent(webElement);
		webElement.click();
	}

	private static boolean checkWebElementDisplayed(WebElement webElement) {
		return (webElement.isDisplayed());
	}

	private static boolean fieldReadOnly(WebElement webElement) {
		return (webElement.isEnabled());
	}

	public static void clickOnLastPagePatientListing() {
		// TODO Auto-generated method stub	
	}
}
