package pageActions.doctorDashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import base.BaseClass;
import pages.doctorDashboard.AppointmentAddPage;
import pages.doctorDashboard.AppointmentsLisitngPage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/*
* @author Mohd-Umar
* @version 0.1
* @since 2023-12-01
*/

public class AppointmentsLisitngPageActions extends BaseClass {

	static AppointmentsLisitngPage clinicAppointmentsPage = PageFactory.initElements(driver,
			AppointmentsLisitngPage.class);

	public static void openGreenFlag(String patient) {
		BaseClass.waitForPageLoad();
		try {
			WebElement web = driver.findElement(By.xpath("//span[contains(@data-pname,'" + patient + "')]"));
			web.click();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void verifyErrorMessage() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(clinicAppointmentsPage.getReasonErrorMsg());
		Assert.assertTrue(checkIfElementDisplayed(clinicAppointmentsPage.getReasonErrorMsg()));
	}

	public static void intiateData() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(clinicAppointmentsPage.getFirstButton());
		clinicAppointmentsPage.getFirstButton().click();
	}

	public static void enterFromDate(String SelectDate) {
//        loginPage.waitForPageLoad();
		// New code start
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementVisibility(clinicAppointmentsPage.getFromDateTxt());
		String[] split_date = SelectDate.split("/");
		String year = split_date[2].substring(2);
		String select_date = split_date[1] + "-" + split_date[0] + "-" + year;
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("document.getElementById('fromDate').removeAttribute('readonly',0);"); // Enables
																												// the
																												// from
																												// date
																												// box
		BaseClass.waitForElementToBeClickable(clinicAppointmentsPage.getFromDateTxt());
		clinicAppointmentsPage.getFromDateTxt().clear();
		BaseClass.waitForElementToBeClickable(clinicAppointmentsPage.getFromDateTxt());
		clinicAppointmentsPage.getFromDateTxt().sendKeys(select_date); // Enter date in required format
		BaseClass.waitForElementToBeClickable(clinicAppointmentsPage.getFromDateTxt());

		String fromValue = (String) javascriptExecutor.executeScript("return arguments[0].value;",
				clinicAppointmentsPage.getFromDateTxt());
		if (fromValue == null) {
			clinicAppointmentsPage.getFromDateTxt().clear();
			BaseClass.waitForElementToBeClickable(clinicAppointmentsPage.getFromDateTxt());
			clinicAppointmentsPage.getFromDateTxt().sendKeys(select_date);
		}

		BaseClass.waitForPageToBecomeActive();
// New Code End
		// datepicker.selectDateofAppCal(SelectDate,
		// clinicAppointmentsPage.getFromDateTxt());
	}

	public static void enterToDate(String SelectDate) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementVisibility(clinicAppointmentsPage.getToDateTxt());
//New code start 
		String[] split_date = SelectDate.split("-");
		String year = split_date[2].substring(2);
		String select_date = split_date[1] + "-" + split_date[0] + "-" + year;
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("document.getElementById('toDate').removeAttribute('readonly',0);"); // Enables
																												// the
																												// To
																												// date
																												// box
		BaseClass.waitForElementToBeClickable(clinicAppointmentsPage.getToDateTxt());
		clinicAppointmentsPage.getToDateTxt().clear();
		BaseClass.waitForElementToBeClickable(clinicAppointmentsPage.getToDateTxt());
		clinicAppointmentsPage.getToDateTxt().sendKeys(select_date); // Enter date in required format
		BaseClass.waitForPageToBecomeActive();

		String toValue = (String) javascriptExecutor.executeScript("return arguments[0].value;",
				clinicAppointmentsPage.getToDateTxt());
		if (toValue == null) {
			clinicAppointmentsPage.getFromDateTxt().clear();
			BaseClass.waitForElementToBeClickable(clinicAppointmentsPage.getToDateTxt());
			clinicAppointmentsPage.getFromDateTxt().sendKeys(select_date);
		}

// New Code End
		// datepicker.selectDateofAppCal(SelectDate, toDateCalenderIcon);
	}

	public static void selectAppType(String AppType) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForUIWidgetOverlayToDisappear();
		BaseClass.waitForElementToBeClickable(clinicAppointmentsPage.getAppTypeDrpDwn());
		BaseClass.selectFromDropDownByVisibleText(clinicAppointmentsPage.getAppTypeDrpDwn(), AppType);
		BaseClass.waitForPageLoad();
	}
    
public static void clickOnLastPagePatientListing() {
    	
    	clinicAppointmentsPage = PageFactory.initElements(driver, AppointmentsLisitngPage.class);
    	
    	BaseClass.waitForSpinnerToDisappear();
    	 try {
    		 Thread.sleep(2500);
    		
    		 
    	 } catch (InterruptedException e1) {
             // TODO Auto-generated catch block
             e1.printStackTrace();
         }
    	 BaseClass.waitForPageToBecomeActive();
//    	 BaseClass.waitForElementToDisappear((By.xpath("//div[contains(@class='modal overlay show')]")));
    	 WebElement element = driver.findElement(By.xpath("//div[@class='clearfix topPagination pagingUI']//a[@class='last']"));
    	 BaseClass.WaitTillElementIsPresent(element);
	     element.click();
    }

	public static void selectAppStatusType(String AppStatusType) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(clinicAppointmentsPage.getApptStatusDropdownList());
		BaseClass.selectFromDropDownByVisibleText(clinicAppointmentsPage.getApptStatusDropdownList(), AppStatusType);
		BaseClass.waitForPageLoad();
	}

	public static void clickOnSearchBtn() {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementToBeClickable(clinicAppointmentsPage.getSearchBtn());
		clinicAppointmentsPage.getSearchBtn().click();
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForPageLoad();
		BaseClass.waitForPageToBecomeActive();
	}


//    public static void clickOnSearchBtn() {
//        loginPage.waitForPageLoad();
//        loginPage.waitForElementToBeClickable(clinicAppointmentsPage.getSearchBtn());
//        try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e1) {
//			e1.printStackTrace();
//		}
//        clinicAppointmentsPage.getSearchBtn().click();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

	public static boolean verifiyAppListHP() {
		BaseClass.waitForPageLoad();
		boolean flag = driver.getTitle().contains("Clinic Appointments") || driver.getTitle().contains("Appointment/Event Listing");
		return flag;
	}

	public static void selectDoctorFRmDrpDwn(String doctorName) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(clinicAppointmentsPage.getDocDropDoownBtn());
		BaseClass.selectFromDropDownByVisibleText(clinicAppointmentsPage.getDocDropDoownBtn(), doctorName);
	}

	public static void selectDoctor(String doctorName) {

		try {
			Thread.sleep(3000);
			BaseClass.waitForPageLoad();
			BaseClass.waitForElementToBeClickable(clinicAppointmentsPage.getDocDropDoownBtn());
			clinicAppointmentsPage.getDocDropDoownBtn().clear();
			Thread.sleep(2000);
			clinicAppointmentsPage.getDocDropDoownBtn().sendKeys(doctorName);

			WebElement selectedDoctor = driver.findElement(By
					.xpath("//li[@class='listingData ng-pristine ng-untouched ng-valid ng-binding ng-scope active']"));
			Actions action = new Actions(driver);
			action.moveToElement(selectedDoctor).perform();
			selectedDoctor.click();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void verifiyAppointmentListElements() {
		BaseClass.waitForPageLoad();
		System.out.println("-----------------------------");
		BaseClass.waitForElementVisibility(clinicAppointmentsPage.getPatientName());
		boolean flag = clinicAppointmentsPage.getPatientName().isDisplayed()
				&& clinicAppointmentsPage.getPatientId().isDisplayed() && clinicAppointmentsPage.getType().isDisplayed()
				&& clinicAppointmentsPage.getDoctor().isDisplayed()
				&& clinicAppointmentsPage.getAppTypeDrpDwn().isDisplayed()
				&& clinicAppointmentsPage.getClinic().isDisplayed()
				&& clinicAppointmentsPage.getActionBtn().isDisplayed()
				&& clinicAppointmentsPage.getDocDropDoownBtn().isDisplayed()
				&& clinicAppointmentsPage.getFromDateTxt().isDisplayed()
				&& clinicAppointmentsPage.getToDateTxt().isDisplayed()
				&& clinicAppointmentsPage.getSearchBtn().isDisplayed();
		Assert.assertTrue(flag);
	}

	public static void appointmentTypeFilter(String AppType) {
		BaseClass.waitForElementToBeEnable(By.id("appLis")); // changed the xpath from clinicApptAllListTable_next
		List<WebElement> webElement = driver.findElements(By.xpath("//span[contains(text(),'" + AppType + "')]")); // //span[contains(text(),'Tentative')]
		List<WebElement> timeSlot = driver
				.findElements(By.xpath("//td[contains(@class,'text-left revisionBlock ng-scope')]"));

		// timeSlot = clinicAppointmentsPage.getTimeSlotApp()
		// webElement = appointment.type()

		int typeCount = webElement.size() / 2;
		System.out.println(typeCount);
		int slotCount = timeSlot.size();
		System.out.println(slotCount);

		boolean flag = true;
		while (flag) {
			try {
				boolean flag1;
				if (flag1 = (slotCount == typeCount)) // changed the condition after locator change (flag1 =
														// (clinicAppointmentsPage.getTimeSlotApp().size() ==
														// ((webElement.size()/2) - 1)))
				{
					if (!clinicAppointmentsPage.getNextBtn().getAttribute("class").contains("disabled")) {
						for (int i = 0; (timeSlot.size() / 2) > i; i++) {
							Assert.assertTrue(clinicAppointmentsPage.getTentative().get(i + 1).isDisplayed()
									&& clinicAppointmentsPage.getViewBtn().get(i).isDisplayed()
									&& clinicAppointmentsPage.getEditBtn().get(i).isDisplayed());
						}
					}
				} else {
					Assert.assertTrue(flag1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			flag = false;
		}
	}

	public static void doctorTypeFilter(String DoctorName) {

		boolean noRecords = true;
		try {
			Thread.sleep(2000);
			WebElement noRecordFound = driver
					.findElement(By.xpath("//i[@class='ng-binding'][text()='No Record Found!']"));
			noRecords = noRecordFound.isDisplayed();

		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (!noRecords) {

			BaseClass.waitForElementToBeEnable(By.id("clinicApptAllListTable_next"));
			int appointments_Size = clinicAppointmentsPage.getTimeSlotApp().size();
			List<WebElement> filterDoctor = driver
					.findElements(By.xpath("//td[contains(text(),'" + DoctorName + "')]"));
			int input_Doctor_Filter = filterDoctor.size();
			boolean flag = true;
			while (flag) {
				try {
					boolean flag1;
					if (flag1 = (appointments_Size == input_Doctor_Filter)) {
						if (!clinicAppointmentsPage.getNextBtn().getAttribute("class").contains("disabled")) {
							clinicAppointmentsPage.getNextBtn().click();
							BaseClass.waitForElementToBeEnable(By.id("clinicApptAllListTable_next"));
						}
					} else {
						Assert.assertTrue(flag1);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				flag = !clinicAppointmentsPage.getNextBtn().getAttribute("class").contains("disabled");
				if (!flag) {
					List<WebElement> filterDoctor1 = driver
							.findElements(By.xpath("//td[contains(text(),'" + DoctorName + "')]"));
					int input_Doctor_Filter1 = filterDoctor1.size();
					Assert.assertTrue(clinicAppointmentsPage.getTimeSlotApp().size() == input_Doctor_Filter1);
				}
			}
		}
	}

	public static void checkingFromDateIsBeforeAfterDate(String frmDate, String toDate) {
		SimpleDateFormat dt = new SimpleDateFormat("MM/dd/yyyy");
		try {
			Date Date1 = dt.parse(frmDate);
			Date Date2 = dt.parse(toDate);
			Assert.assertTrue(Date1.before(Date2));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public static void dateFilter(String frmDate, String toDate) {

		boolean noRecords = true;
		try {
			Thread.sleep(2000);
			WebElement noRecordFound = driver
					.findElement(By.xpath("//i[@class='ng-binding'][text()='No Record Found!']"));
			noRecords = noRecordFound.isDisplayed();

		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (!noRecords) {

			WebElement lastPage = driver.findElement(By.xpath("//a[@class='next']/preceding-sibling::a[1]"));
			String lastPageNumber = lastPage.getText();
			System.out.println(lastPageNumber);
			BaseClass.waitToBeClickableAndClick(clinicAppointmentsPage.getLastPage());

			BaseClass.waitForElementToBeClickable(clinicAppointmentsPage.getSearchBtn());
			SimpleDateFormat dt = new SimpleDateFormat("MM/dd/yyyy");
			SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yy HH:mm");
			Date date1, date2;
			try {
				date1 = dt.parse(frmDate);
				date2 = dt.parse(toDate);
				boolean flag = true;
				while (flag) {
					for (int i = 0; clinicAppointmentsPage.getTimeSlotApp().size() > i; i++) {
						String Apptime = clinicAppointmentsPage.getTimeSlotApp().get(i).getText();
						Date AppDate = dt1.parse(Apptime);
						boolean flag1;
						if (flag1 = AppDate.before(date2) && AppDate.after(date1)) {
							Assert.assertTrue(flag1);
						} else {
							Assert.assertTrue(flag1);
						}
					}
					flag = false;
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}

	public static void verifyBehaviourOfViewBtn() {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		WebElement view = driver.findElement(By.xpath("(//th[text()='Action']/../../..//tbody//a[@class='listBtn viewAppointment'])[1]"));
//		BaseClass.waitForElementToBeClickable(view);
//		view.click();
//		loginPage.switchToFrame(frameView);

		BaseClass.waitToBeClickableAndClick(clinicAppointmentsPage.getViewAction());
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForPageLoad();

		BaseClass.waitForElementToBeClickable(clinicAppointmentsPage.getPatientIdView());
		boolean flag;
		if (flag = clinicAppointmentsPage.getPatientIdView().isDisplayed()
				&& clinicAppointmentsPage.getPatientNameView().isDisplayed()
				&& clinicAppointmentsPage.getEmailIdView().isDisplayed()
				&& clinicAppointmentsPage.getMobileNumView().isDisplayed()
				&& clinicAppointmentsPage.getClinicNameView().isDisplayed()
				&& clinicAppointmentsPage.getDateOfAppView().isDisplayed()
				&& clinicAppointmentsPage.getDurationView().isDisplayed()
				&& clinicAppointmentsPage.getDoctorView().isDisplayed()
				&& clinicAppointmentsPage.getOperatoriesView().isDisplayed()
				&& clinicAppointmentsPage.getReferralView().isDisplayed()
				&& clinicAppointmentsPage.getChiefComplaintView().isDisplayed()
				&& clinicAppointmentsPage.getSourceView().isDisplayed()
				&& clinicAppointmentsPage.getNotesView().isDisplayed()) {
			if (clinicAppointmentsPage.getPatientIdView().getText() != "NA"
					|| clinicAppointmentsPage.getMobileNumView().getText() != "NA"
					|| clinicAppointmentsPage.getPatientNameView().getText() != "NA"
					|| clinicAppointmentsPage.getDateOfAppView().getText() != "NA"
					|| clinicAppointmentsPage.getDoctorView().getText() != "NA"
					|| clinicAppointmentsPage.getOperatoriesView().getText() != "NA") {
			}
			Assert.assertTrue(flag);
		} else {
			Assert.assertTrue(false);
		}
		// BaseClass.switchToDefaultContent();
		// ---------sikuli here------
		clinicAppointmentsPage.getCloseViewModal().click();
	}

	public static void tentativeHeaderView() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkIfElementDisplayed(clinicAppointmentsPage.getTentativeHeaderView()));
	}

	public static void patientIdView() {
//        loginPage.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(clinicAppointmentsPage.getHeaderView());
		Assert.assertTrue(checkIfElementDisplayed(clinicAppointmentsPage.getHeaderView())
				&& !(clinicAppointmentsPage.getPatientIdView().getText().contains("NA")
						|| clinicAppointmentsPage.getPatientIdView().getText().contains("null")));
	}

	public static void patientNameView(String patient) {
		BaseClass.waitForPageLoad();
//        loginPage.waitForElementToBeClickable(clinicAppointmentsPage.getPatientNameView());
		System.out.println("Before logic w/o trim " + clinicAppointmentsPage.getPatientNameView().getText());
		System.out.println("Before logic with trim " + clinicAppointmentsPage.getPatientNameView().getText().trim());
		System.out.println("--------------------------------------------------------");
		if (clinicAppointmentsPage.getPatientNameView().getText() == null) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			BaseClass.waitForElementVisibility(clinicAppointmentsPage.getPatientNameView(), 4000);

		}

		System.out.println("After logic w/o trim " + clinicAppointmentsPage.getPatientNameView().getText());
		System.out.println("After logic with trim " + clinicAppointmentsPage.getPatientNameView().getText().trim());
		Assert.assertEquals(clinicAppointmentsPage.getPatientNameView().getText().trim(), patient.trim());
	}

	public static void emailIdView(String email) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(clinicAppointmentsPage.getEmailIdView());
		Assert.assertEquals(clinicAppointmentsPage.getEmailIdView().getText().trim(), email.trim());
	}

	public static void mobileNumView(String mobile) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(clinicAppointmentsPage.getMobileNumView());
		Assert.assertEquals(clinicAppointmentsPage.getMobileNumView().getText().trim(), mobile);
	}

	public static void clinicNameView(String clinic) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(clinicAppointmentsPage.getClinicNameView());
		Assert.assertEquals(clinicAppointmentsPage.getClinicNameView().getText().trim(), clinic);
	}

	public static void DateOfAppView() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(clinicAppointmentsPage.getDateOfAppView());
		Assert.assertTrue(!clinicAppointmentsPage.getDateOfAppView().getText().contains("NA")
				|| clinicAppointmentsPage.getDateOfAppView().getText().contains("null"));
	}

	public static void durationView(String duration) {
		BaseClass.waitForSpinnerToDisappear();
		;
		BaseClass.waitForElementToBeClickable(clinicAppointmentsPage.getDurationView());
		System.out.println("Jai Ho" + clinicAppointmentsPage.getDurationView().getText().trim());
		System.out.println("Jai Hind" + duration);
		Assert.assertTrue(clinicAppointmentsPage.getDurationView().getText().trim().contains(duration));
	}

	public static void doctorView(String doctor) {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BaseClass.waitForElementToBeClickable(clinicAppointmentsPage.getDoctorView());
		Assert.assertEquals(clinicAppointmentsPage.getDoctorView().getText().trim(), doctor);
	}

	public static void operatoriesView() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(clinicAppointmentsPage.getOperatoriesView());
		Assert.assertTrue(!clinicAppointmentsPage.getOperatoriesView().getText().contains("NA")
				|| clinicAppointmentsPage.getOperatoriesView().getText().contains("null"));
	}

	public static void roomsView() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(clinicAppointmentsPage.getRoomsView());
		Assert.assertTrue(!clinicAppointmentsPage.getRoomsView().getText().contains("NA")
				|| clinicAppointmentsPage.getRoomsView().getText().contains("null"));
	}

	public static void roomsViewEconsult() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(clinicAppointmentsPage.getRoomsView());
		Assert.assertTrue(!clinicAppointmentsPage.getRoomsView().getText().contains("NA")
				|| clinicAppointmentsPage.getRoomsView().getText().contains("1"));
	}

	public static void referralView(String referral) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(clinicAppointmentsPage.getReferralView());
		Assert.assertEquals(clinicAppointmentsPage.getReferralView().getText().trim(), referral);
	}

	public static void referralDetails(String referral) {
		BaseClass.waitForPageLoad();
		Assert.assertEquals(clinicAppointmentsPage.getReferralDetailsView().getText().trim(), referral);
	}

	public static void sourceView(String source) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(clinicAppointmentsPage.getSourceView());
		Assert.assertEquals(clinicAppointmentsPage.getSourceView().getText().trim(), source);
	}

	public static void chiefComplaintView(String chiefComplaint) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(clinicAppointmentsPage.getChiefComplaintView());
		Assert.assertEquals(clinicAppointmentsPage.getChiefComplaintView().getText().trim(), chiefComplaint);
	}

	public static void notesView(String note) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(clinicAppointmentsPage.getNotesView());
		Assert.assertEquals(clinicAppointmentsPage.getNotesView().getText().trim(), note);
	}

	public static void closeViewModal() {
		BaseClass.waitForElementVisibility(clinicAppointmentsPage.getCloseViewModal(), 4000);
		clinicAppointmentsPage.getCloseViewModal().click();
	}

//    public static void closeViewModal() {
//        loginPage.switchToDefaultContent();
//        closeViewModal.click();
//    }

	public static void clickOnLastPage() {

		clinicAppointmentsPage = PageFactory.initElements(driver, AppointmentsLisitngPage.class);

		BaseClass.waitForSpinnerToDisappear();
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// BaseClass.waitForElementToDisappear((By.xpath("//div[contains(@class='modal
		// overlay show')]")));
		BaseClass.WaitTillElementIsPresent(clinicAppointmentsPage.getLastPage());
		clinicAppointmentsPage.getLastPage().click();
	}

	public static void confirmWithConfirmed() {

		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeEnable(By.id("appLis"));
		clinicAppointmentsPage.getLastPage().click();
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForPageLoad();

		List<WebElement> timeSlot = driver.findElements(By.xpath("//td[contains(@class,'text-left revisionBlock ng-scope')]"));
		System.out.println("------------------------------------------------");
		
		int timeSlotCount = timeSlot.size();
		System.out.println("timeSlotCount " + timeSlotCount);
		
		int confirmedCount = (clinicAppointmentsPage.getConfirmed().size()/2);
		System.out.println("confirmedCount :" + confirmedCount);

		System.out.println("------------------------------------------------");

		int noShowCount = (clinicAppointmentsPage.getNoShowStatus().size() / 2);
		System.out.println("noShowCount " + noShowCount);
		
		int newShowCount = (clinicAppointmentsPage.getNewStatus().size()/2);
		System.out.println("newShowCount " + newShowCount);

		int followOnCount = (clinicAppointmentsPage.getFollowOnStatus().size()/2);
		System.out.println("followOnCount " + followOnCount);

		int repeatCount = (clinicAppointmentsPage.getRepeatOnStatus().size()/2);
		System.out.println("repeatCount " + repeatCount);

		System.out.println("------------------------------------------------");

		try {
			Thread.sleep(500);

			boolean flag = true;
			while (flag) {
				boolean flag1, flag2;

				//if (flag1 = (clinicAppointmentsPage.getTimeSlotApp().size() == (clinicAppointmentsPage.getConfirmed().size() - 1))
						
				if (flag1 = (timeSlotCount==confirmedCount)
						&& (clinicAppointmentsPage.getConfirmed().size() == (clinicAppointmentsPage.getNewStatus().size()
							+ clinicAppointmentsPage.getFollowOnStatus().size()
							+ clinicAppointmentsPage.getRepeatOnStatus().size()))) {
					for (int i = 0; i < confirmedCount; i++) {

						BaseClass.highlightElement(clinicAppointmentsPage.getConfirmed().get(i));
						BaseClass.highlightElement(clinicAppointmentsPage.getViewBtn().get(i));
						
						flag2 = checkIfElementDisplayed(clinicAppointmentsPage.getViewBtn().get(i))
								&& checkIfElementDisplayed(clinicAppointmentsPage.getConfirmed().get(i));
						Assert.assertTrue(flag2);
					}
					Assert.assertTrue(flag1);
					flag = false;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void verifyConfirmWithNoShow() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeEnable(By.id("appLis"));
		clinicAppointmentsPage.getLastPage().click();
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForPageLoad();

		List<WebElement> timeSlot = driver
				.findElements(By.xpath("//td[contains(@class,'text-left revisionBlock ng-scope')]"));
		int timeSlotCount = timeSlot.size();
		System.out.println("------------------------------------------------");
		System.out.println("timeSlotCount " + timeSlotCount);
		int noShowCount = (clinicAppointmentsPage.getNoShowStatus().size() / 2);
		System.out.println("noShowCount " + noShowCount);
		System.out.println("------------------------------------------------");

		int newShowCount = clinicAppointmentsPage.getNewStatus().size();
		System.out.println("newShowCount " + newShowCount);

		int followOnCount = clinicAppointmentsPage.getFollowOnStatus().size();
		System.out.println("followOnCount " + followOnCount);

		int repeatCount = clinicAppointmentsPage.getRepeatOnStatus().size();
		System.out.println("repeatCount " + repeatCount);

		System.out.println("------------------------------------------------");

		try {

			Thread.sleep(5000);

			boolean flag = true;
			while (flag) {
				boolean flag1;
				if (flag1 = (timeSlotCount == noShowCount) // ((flag1 = clinicAppointmentsPage.getTimeSlotApp().size()
															// == (clinicAppointmentsPage.getNoShowStatus().size()/2))
						&& (clinicAppointmentsPage.getNoShowStatus()
								.size() == (clinicAppointmentsPage.getNewStatus().size()
										+ clinicAppointmentsPage.getFollowOnStatus().size()
										+ clinicAppointmentsPage.getRepeatOnStatus().size()))) {
					for (int i = 0; i < noShowCount; i++) { // changed the condition from
															// "clinicAppointmentsPage.getNoShowStatus().size() > i" to
															// "noShowCount"
						System.out.println("Value is :" + i);

						Thread.sleep(500);
						int confirmedCount = clinicAppointmentsPage.getConfirmed().size();
						System.out.println("confirmedCount :" + confirmedCount);
						int viewButtonSize = clinicAppointmentsPage.getViewBtn().size();
						System.out.println("viewButtonSize :" + viewButtonSize);
						int noShowButtonSize = clinicAppointmentsPage.getDashboardNoShowIcon().size();
						System.out.println("noShowButtonSize :" + noShowButtonSize);

						System.out.println("________________________________________________________");

						BaseClass.highlightElement(clinicAppointmentsPage.getConfirmed().get(i));
						BaseClass.highlightElement(clinicAppointmentsPage.getNoShowStatus().get(i));
						BaseClass.highlightElement(clinicAppointmentsPage.getViewBtn().get(i));
						BaseClass.highlightElement(clinicAppointmentsPage.getDashboardNoShowIcon().get(i));

						Assert.assertTrue(clinicAppointmentsPage.getConfirmed().get(i).isDisplayed()
								&& clinicAppointmentsPage.getNoShowStatus().get(i).isDisplayed()
								&& clinicAppointmentsPage.getViewBtn().get(i).isDisplayed()
								&& clinicAppointmentsPage.getDashboardNoShowIcon().get(i).isDisplayed());
						Thread.sleep(500);
					}
					Assert.assertTrue(flag1);
					flag = false;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void confirmWithShow() {

		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeEnable(By.id("appLis"));
		clinicAppointmentsPage.getLastPage().click();
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForPageLoad();

		List<WebElement> timeSlot = driver
				.findElements(By.xpath("//td[contains(@class,'text-left revisionBlock ng-scope')]"));
		int timeSlotCount = timeSlot.size();
		System.out.println("------------------------------------------------");
		System.out.println("timeSlotCount " + timeSlotCount);

		int confirmedCount = (clinicAppointmentsPage.getConfirmed().size() / 2);
		System.out.println("noShowCount " + confirmedCount);
		System.out.println("================================================");

		int newShowCount = clinicAppointmentsPage.getNewStatus().size();
		System.out.println("newShowCount " + newShowCount);

		int followOnCount = clinicAppointmentsPage.getFollowOnStatus().size();
		System.out.println("followOnCount " + followOnCount);

		int repeatCount = clinicAppointmentsPage.getRepeatOnStatus().size();
		System.out.println("repeatCount " + repeatCount);

		System.out.println("------------------------------------------------");

		try {

			Thread.sleep(500);

			boolean flag = true;
			while (flag) {
				boolean flag1;

				// if ((flag1=clinicAppointmentsPage.getTimeSlotApp().size() ==
				// (clinicAppointmentsPage.getConfirmed().size() -1))

				if ((flag1 = (timeSlotCount == confirmedCount)) && ((clinicAppointmentsPage.getConfirmed()
						.size()) == (clinicAppointmentsPage.getNewStatus().size()
								+ clinicAppointmentsPage.getFollowOnStatus().size()
								+ clinicAppointmentsPage.getRepeatOnStatus().size()))) {
					for (int i = 0; clinicAppointmentsPage.getTimeSlotApp().size() > i; i++) {

						BaseClass.highlightElement(clinicAppointmentsPage.getConfirmed().get(i));
						BaseClass.highlightElement(clinicAppointmentsPage.getViewBtn().get(i));

						Assert.assertTrue(clinicAppointmentsPage.getConfirmed().get(i).isDisplayed()
								&& clinicAppointmentsPage.getViewBtn().get(i).isDisplayed());
					}
					Assert.assertTrue(flag1);
					flag = false;
				}

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void confirmWithCheckIn() {

		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeEnable(By.id("appLis"));
		clinicAppointmentsPage.getLastPage().click();
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForPageLoad();

		List<WebElement> timeSlot = driver
				.findElements(By.xpath("//td[contains(@class,'text-left revisionBlock ng-scope')]"));

		System.out.println("------------------------------------------------");
		int timeSlotCount = timeSlot.size();
		System.out.println("timeSlotCount " + timeSlotCount);
		int checkINCount = (clinicAppointmentsPage.getCheckinStatus().size() / 2);
		System.out.println("checkINCount " + checkINCount);

		System.out.println("------------------------------------------------");

		int newShowCount = clinicAppointmentsPage.getNewStatus().size();
		System.out.println("newShowCount " + newShowCount / 2);

		int followOnCount = clinicAppointmentsPage.getFollowOnStatus().size();
		System.out.println("followOnCount " + followOnCount / 2);

		int repeatCount = clinicAppointmentsPage.getRepeatOnStatus().size();
		System.out.println("repeatCount " + repeatCount / 2);

		int viewButtonCount = clinicAppointmentsPage.getViewBtn().size();
		System.out.println("viewButtonCount " + viewButtonCount);

		System.out.println("================================================");
		try {

			Thread.sleep(500);

			boolean flag = true;
			while (flag) {
				boolean flag1;

				// if ((flag1 = clinicAppointmentsPage.getTimeSlotApp().size() ==
				// clinicAppointmentsPage.getCheckinStatus().size())

				if ((flag1 = timeSlotCount == checkINCount) && (clinicAppointmentsPage.getCheckinStatus()
						.size() == (clinicAppointmentsPage.getNewStatus().size()
								+ clinicAppointmentsPage.getFollowOnStatus().size()
								+ clinicAppointmentsPage.getRepeatOnStatus().size()))) {
					for (int i = 0; i < checkINCount; i++) {

						System.out.println("Value of i :" + i);

						int confirmedCount = clinicAppointmentsPage.getConfirmed().size();
						System.out.println("confirmedCount :" + confirmedCount / 2);
						int viewButtonSize = clinicAppointmentsPage.getViewBtn().size();
						System.out.println("viewButtonSize :" + viewButtonSize);

						System.out.println("________________________________________________________");

						BaseClass.highlightElement(clinicAppointmentsPage.getConfirmed().get(i));
						BaseClass.highlightElement(clinicAppointmentsPage.getCheckinStatus().get(i));
						BaseClass.highlightElement(clinicAppointmentsPage.getViewBtn().get(i));

						Assert.assertTrue(clinicAppointmentsPage.getConfirmed().get(i).isDisplayed()
								&& clinicAppointmentsPage.getCheckinStatus().get(i).isDisplayed()
								&& clinicAppointmentsPage.getViewBtn().get(i).isDisplayed());
					}
					Assert.assertTrue(flag1);
					flag = false;
				}

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void confirmWithExpired() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeEnable(By.id("clinicApptAllListTable_next"));
		boolean flag = true;
		while (flag) {
			boolean flag1;
			if ((flag1 = clinicAppointmentsPage.getTimeSlotApp()
					.size() == (clinicAppointmentsPage.getExpiredStatus().size() - 1))
					&& ((clinicAppointmentsPage.getExpiredStatus().size()
							- 1) == (clinicAppointmentsPage.getNewStatus().size()
									+ clinicAppointmentsPage.getFollowOnStatus().size()
									+ clinicAppointmentsPage.getRepeatOnStatus().size()))) {
				for (int i = 0; (clinicAppointmentsPage.getExpiredStatus().size() - 1) > i; i++) {
					Assert.assertTrue(clinicAppointmentsPage.getConfirmed().get(i + 1).isDisplayed()
							&& clinicAppointmentsPage.getExpiredStatus().get(i + 1).isDisplayed()
							&& clinicAppointmentsPage.getViewBtn().get(i).isDisplayed()
							&& clinicAppointmentsPage.getExpired().get(i).isDisplayed());
				}
				flag = !clinicAppointmentsPage.getNextBtn().getAttribute("class").contains("disabled");
				if (flag) {
					clinicAppointmentsPage.getNextBtn().click();
				} else {
					if ((flag1 = clinicAppointmentsPage.getTimeSlotApp()
							.size() == (clinicAppointmentsPage.getExpiredStatus().size() - 1))
							&& ((clinicAppointmentsPage.getExpiredStatus().size()
									- 1) == (clinicAppointmentsPage.getNewStatus().size()
											+ clinicAppointmentsPage.getFollowOnStatus().size()
											+ clinicAppointmentsPage.getRepeatOnStatus().size()))) {
						for (int i = 0; (clinicAppointmentsPage.getExpiredStatus().size() - 1) > i; i++) {
							Assert.assertTrue(clinicAppointmentsPage.getConfirmed().get(i).isDisplayed()
									&& clinicAppointmentsPage.getExpiredStatus().get(i + 1).isDisplayed()
									&& clinicAppointmentsPage.getViewBtn().get(i).isDisplayed()
									&& clinicAppointmentsPage.getExpired().get(i).isDisplayed());
						}
					} else {
						Assert.assertTrue(flag1);
					}
				}
			} else {
				Assert.assertTrue(flag1);
			}
		}
	}

	public static void behaviourOfNoShowBtn(String reason) {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (!clinicAppointmentsPage.getNoRecordFoundMsg().isDisplayed()) {
			for (int i = 0; i < clinicAppointmentsPage.getNoShowBtn().size(); i++) {
				if (clinicAppointmentsPage.getNoShowBtn().get(i).isDisplayed()) {
					clinicAppointmentsPage.getNoShowBtn().get(i).click();
					BaseClass.waitForPageLoad();
					BaseClass.selectFromDropDownByVisibleText(clinicAppointmentsPage.getNoShowVisibleText(), reason);
					clinicAppointmentsPage.getNoShowVisibleText().click();
				}
				break;
			}
		} else {
			Reporter.log("There is No NoShowBtn", true);
		}
	}

	public static void noRecordFoundMsg() {
		BaseClass.waitForElementVisibility(clinicAppointmentsPage.getNoRecordFoundMsg());
		Assert.assertTrue(clinicAppointmentsPage.getNoRecordFoundMsg().isDisplayed());
	}

	public static void clickOnPatient(String patient) {
		BaseClass.waitForPageToBecomeActive();
		WebElement element = driver.findElement(
				By.xpath("//span[@class='dis-inline-blk ng-scope']//span[contains(text(),'" + patient + "')]"));
		BaseClass.waitForElementToBeClickable(element);
		element.click();
		BaseClass.waitForPageToBecomeActive();
	}

//    public static void clickOnPatient(String patient) {
//        loginPage.waitForPageLoad();
//        try {
//            Thread.sleep(3000);
//            WebElement element = loginPage.getDriver().findElement(By.xpath("//span[contains(text(),'" + patient + "')]"));
//            loginPage.waitForElementToBeClickable(element);
//            element.click();
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }

	public static void verifyWebElementDeletePopup() {
		BaseClass.waitForPageLoad();
		boolean flag = checkIfElementDisplayed(clinicAppointmentsPage.getTextOnDelete())
				&& checkIfElementDisplayed(clinicAppointmentsPage.getYesForDeleteBtn())
				&& checkIfElementDisplayed(clinicAppointmentsPage.getNoBtn());
		Assert.assertTrue(flag);
	}

	public static void clickNoDeletePopup() {
//        loginPage.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(clinicAppointmentsPage.getNoBtn());
		clinicAppointmentsPage.getNoBtn().click();
	}

	public static void selectReasonDelete() {
//        loginPage.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(clinicAppointmentsPage.getReasonOfDelApp());
		BaseClass.selectFromDropDownByIndex(clinicAppointmentsPage.getReasonOfDelApp(), 2);
	}

	public static void clickYesDeletePopup() {
//        loginPage.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(clinicAppointmentsPage.getYesForDeleteBtn());
		clinicAppointmentsPage.getYesForDeleteBtn().click();
	}

	public static void strikeOff(String patient) {
		BaseClass.waitForPageToBecomeActive();
		clickOnLastPage();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + patient + "')]/../.."));
		BaseClass.waitForElementVisibility(element, 4000);
		System.out.println("The Attribute Class Name Is" + " " + element.getAttribute("class"));
		Assert.assertTrue(element.getAttribute("class").contains("dis-inline-blk ng-scope deleted"));
	}

//    public static void strikeOff(String patient) {
//        loginPage.waitForPageLoad();
//        try {
//            Thread.sleep(3500);
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        WebElement element = loginPage.getDriver().findElement(By.xpath("//span[contains(text(),'" + patient + "')]"));
//        loginPage.waitForElementToBeClickable(element);
//        Assert.assertTrue(element.getAttribute("class").contains("strikeOff"));
//    }

	public static void appointmentStatus(String patient, String status) {
		BaseClass.waitForSpinnerToDisappear();
		try {
			WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + patient
					+ "')]/../../../../../following-sibling::td//span[contains(@class,'repeat')]"));
			// WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" +
			// patient +
			// "')]/../../../following-sibling::td//span[contains(@class,'repeat']"));
			BaseClass.waitForElementToBeClickable(element);
			System.out.println(element.getText());
			Assert.assertTrue(element.getText().contains(status));
		} catch (NoSuchElementException e) {
			List<WebElement> pagination = driver
					.findElements(By.xpath("//a[@id='clinicApptAllListTable_first']/../span//a"));
			for (int i = 0; pagination.size() > i; i++) {
				clinicAppointmentsPage.getNextBtn().click();
				List<WebElement> element = driver.findElements(By.xpath(
						"//span[contains(text(),'\" + patient + \"')]/../../../../../following-sibling::td//span[contains(@class,'repeat')]"));
				if (element.size() > 0) {
					element.get(0).click();
					break;
				} else {
					continue;
				}
			}
		}
	}

	public static void appointmentType(String patient, String appointmentType) {
		BaseClass.waitForSpinnerToDisappear();
		WebElement element = driver
				.findElement(By.xpath("//span[@class='dis-inline-blk ng-scope']" + "//span[contains(text(),'" + patient
						+ "')]" + "/../../../../../..//span[contains(text(),'" + appointmentType + "')]"));
		BaseClass.waitForElementToBeClickable(element);
		Assert.assertTrue(element.isDisplayed());
	}

	public static void patientFlag(String patient, String flag) {
		BaseClass.waitForPageLoad();
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + patient
				+ "')]/../../following-sibling::span/span[contains(@class,'" + flag + "')]"));
		BaseClass.waitForElementToBeClickable(element);
		Assert.assertTrue(element.isDisplayed());
	}

	public static void type(String patient, String appointmentType) {
		BaseClass.waitForSpinnerToDisappear();
		WebElement element = driver
				.findElement(By.xpath("//span[@class='dis-inline-blk ng-scope']" + "//span[contains(text(),'" + patient
						+ "')]" + "/../../../../../..//span[contains(text(),'" + appointmentType + "')]"));
		BaseClass.scrollToView(element);
		BaseClass.waitForElementVisibility(element, 4000);
		BaseClass.waitForElementToBeClickable(element);
		Assert.assertTrue(element.isDisplayed());
	}

//    public static void type(String patient, String appointmentType) {
//        loginPage.waitForPageLoad();
//        WebElement element = loginPage.getDriver().findElement(By.xpath("//span[contains(text(),'" + patient
//                + "')]/../../..//following-sibling::td/span[contains(text(),'" + appointmentType + "')]"));
//        loginPage.waitForElementToBeClickable(element);
//        Assert.assertTrue(element.isDisplayed());
//    }

	public static void verifyClinic(String patient, String clinic) {
		WebElement element = driver
				.findElement(By.xpath("//span[@class='dis-inline-blk ng-scope']" + "//span[contains(text(),'" + patient
						+ "')]" + "/../../../../../..//td[contains(text(),'" + clinic + "')]"));
		Assert.assertTrue(element.isDisplayed());
	}

//    public static void verifyClinic(String patient, String clinic) {
//        loginPage.waitForPageLoad();
//        WebElement element = loginPage.getDriver().findElement(By.xpath("//span[contains(text(),'" + patient
//                + "')]/../../..//following-sibling::td[contains(text(),'" + clinic + "')]"));
//        Assert.assertTrue(element.isDisplayed());
//    }

	public static void verifyServiceType(String patient, String servicename) {
		WebElement element = driver
				.findElement(By.xpath("//span[@class='dis-inline-blk ng-scope']" + "//span[contains(text(),'" + patient
						+ "')]" + "/../../../../../..//td[contains(text(),'" + servicename + "')]"));
		BaseClass.waitForElementToBeClickable(element);
		Assert.assertTrue(element.isDisplayed());
	}

	public static void verifyServiceLocation(String patient, String address) {
		WebElement element = driver
				.findElement(By.xpath("//span[@class='dis-inline-blk ng-scope']" + "//span[contains(text(),'" + patient
						+ "')]" + "/../../../../../..//span[contains(text(),'" + address + "')]"));
		BaseClass.waitForElementToBeClickable(element);
		Assert.assertTrue(element.isDisplayed());
	}

	public static void checkDoctorName(String patient, String doctor) {
		WebElement element = driver
				.findElement(By.xpath("//span[@class='dis-inline-blk ng-scope']" + "//span[contains(text(),'" + patient
						+ "')]" + "/../../../../../..//td[contains(text(),'" + doctor + "')]"));
		BaseClass.waitForElementToBeClickable(element);
		Assert.assertTrue(element.isDisplayed());
	}

//    public static void checkDoctorName(String patient, String doctor) {
//        loginPage.waitForPageLoad();
//        WebElement element = loginPage.getDriver().findElement(By.xpath("//span[@class='dis-inline-blk ng-scope']"
//        		+ "//span[contains(text(),'"+patient+"')]"
//        		+ "/../../../../../..//span[contains(text(),'"+doctor+"')]"));
//        loginPage.waitForElementToBeClickable(web);
//        Assert.assertTrue(web.isDisplayed());
//    }

//    public static void checkDoctorName(String patient, String doctor) {
//        loginPage.waitForPageLoad();
//        WebElement web = loginPage.getDriver().findElement(By.xpath("//span[contains(text(),'" + patient + "')]/../../../following-sibling::td[contains(text(),'" + doctor + "')]"));
//        loginPage.waitForElementToBeClickable(web);
//        Assert.assertTrue(web.isDisplayed());
//    }

	public static void viewButton(String patient) {
		WebElement element = driver
				.findElement(By.xpath("//span[@class='dis-inline-blk ng-scope']" + "//span[contains(text(),'" + patient
						+ "')]" + "/../../../../../..//span[contains(@class,'actn-icn view')]"));
		BaseClass.waitForElementToBeClickable(element);
		Assert.assertTrue(element.isDisplayed());
	}

//    public static void viewButton(String patient) {
//        loginPage.waitForPageLoad();
//        WebElement element = loginPage.getDriver().findElement(By.xpath("//span[contains(text(),'" + patient
//                + "')]/../../..//following-sibling::td//span[contains(@class,'actn-icn view')]"));
//        loginPage.waitForElementToBeClickable(element);
//        Assert.assertTrue(element.isDisplayed());
//    }

	public static void openViewModal(String patient, String time) throws bsh.ParseException, ParseException {
		String twelveHourTime = BaseClass.convert24HourFormatTo12HourFormat(time).split(" ")[0];
		WebElement element = driver.findElement(By.xpath("//span[@class='dis-inline-blk ng-scope']"
				+ "//span[contains(text(),'" + patient + "') and //span[contains(text(),'" + twelveHourTime + "')]]"
				+ "/../../../../../..//span[contains(@class,'actn-icn view')]"));
		element.click();
	}

//    public static void openViewModal(String patient) {
//        loginPage.waitForPageLoad();
//        WebElement element = loginPage.getDriver().findElement(By.xpath("//span[contains(text(),'" + patient + "')]/../../..//following-sibling::td//span[contains(@class,'actn-icn view')]"));
//        loginPage.waitForElementToBeClickable(element);
//        element.click();
////      loginPage.switchToFrame(viewFrame);
//    }

	public static void editButton(String patient) {
		BaseClass.waitForSpinnerToDisappear();
		WebElement element = driver
				.findElement(By.xpath("//span[@class='dis-inline-blk ng-scope']" + "//span[contains(text(),'" + patient
						+ "')]" + "/../../../../../..//span[contains(@class,'actn-icn edit')]"));
		BaseClass.waitForElementVisibility(element, 4000);
		Assert.assertTrue(element.isDisplayed());
	}

//    public static void editButton(String patient) {
//        loginPage.waitForPageLoad();
//        WebElement element = loginPage.getDriver().findElement(By.xpath("//span[contains(text(),'" + patient
//                + "')]/../../../following-sibling::td//span[contains(@class,'actn-icn edit')]"));
//        loginPage.waitForElementToBeClickable(element);
//        Assert.assertTrue(element.isDisplayed());
//    }

	public static void clickEditButton(String patient) {
		BaseClass.waitForSpinnerToDisappear();
		WebElement element = driver
				.findElement(By.xpath("//span[@class='dis-inline-blk ng-scope']" + "//span[contains(text(),'" + patient
						+ "')]" + "/../../../../../..//span[contains(@class,'actn-icn edit')]"));
		BaseClass.waitForElementToBeClickable(element);
		element.click();

	}

//    public static void clickEditButton(String patient) {
//        loginPage.waitForPageLoad();
//        try {
//            Thread.sleep(1500);
//            WebElement element = loginPage.getDriver().findElement(By.xpath("//span[contains(text(),'" + patient
//                    + "')]/../../../following-sibling::td//span[contains(@class,'actn-icn edit')]"));
//            loginPage.waitForElementToBeClickable(element);
//            element.click();
//            Thread.sleep(3500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

	public static void deleteButton(String patient) {
		BaseClass.waitForPageLoad();
		WebElement element = driver
				.findElement(By.xpath("//span[@class='dis-inline-blk ng-scope']" + "//span[contains(text(),'" + patient
						+ "')]" + "/../../../../../..//span[contains(@class,'actn-icn delete')]"));
		BaseClass.waitForElementToBeClickable(element);
		Assert.assertTrue(element.isDisplayed());
	}

//    public static void deleteButton(String patient) {
//        loginPage.waitForPageLoad();
//        WebElement element = loginPage.getDriver().findElement(By.xpath("//span[contains(text(),'" + patient
//                + "')]/../../../following-sibling::td//span[contains(@class,'actn-icn delete')]"));
//        loginPage.waitForElementToBeClickable(element);
//        Assert.assertTrue(element.isDisplayed());
//    }

	public static void clickDeleteButton(String patient) {
		BaseClass.waitForSpinnerToDisappear();
		WebElement element = driver
				.findElement(By.xpath("//span[@class='dis-inline-blk ng-scope']" + "//span[contains(text(),'" + patient
						+ "')]" + "/../../../../../..//span[contains(@class,'actn-icn delete')]"));
		BaseClass.waitForElementToBeClickable(element);
		element.click();
	}

//    public static void clickDeleteButton(String patient) {
//        loginPage.waitForPageLoad();
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        WebElement element = loginPage.getDriver().findElement(By.xpath("//span[contains(text(),'" + patient
//                + "')]/../../../following-sibling::td//span[contains(@class,'actn-icn delete')]"));
//        loginPage.waitForElementToBeClickable(element);
//        element.click();
//    }

	public static void verifyAfterEditAtAppList(String patient, String timeSlot) {
		BaseClass.waitForPageLoad();
		String slotDate=null;
		String slotTime=null;
		
		String slot[] = timeSlot.split(" ");
		
		//WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + patient + "')]/../../../preceding-sibling::td"));
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + patient + "')]/../../../../../td[@class='text-left revisionBlock ng-scope deleted']/span"));
		BaseClass.waitForElementToBeClickable(element);
		
		System.out.println("sheet time :"+timeSlot);
		System.out.println("appl. time :"+element.getText());
		
		
		Assert.assertTrue(element.getText().trim().contains(timeSlot));
	}

	public static void verifyAppointmentDateTimeOnListing(String patientName, String date, String time) {
		BaseClass.waitForSpinnerToDisappear();
		WebElement getDate = driver
				.findElement(By.xpath("(//span[@class='dis-inline-blk ng-scope']" + "//span[contains(text(),'"
						+ patientName + "')]" + "/../../../../../..//span[@class='legendOriginal ng-binding'])[1]"));
		WebElement getTime = driver.findElement(
				By.xpath("//span[@class='dis-inline-blk ng-scope']" + "//span[contains(text(),'" + patientName + "')]"
						+ "/../../../../../..//div[@class='text-center lineHght12 dis-inline-blk ng-binding']"));
		String getDateText = getDate.getText();
		String getTimeText = getTime.getText();
		String timeText = (getTimeText.split("2023")[1]).trim();
		try {
			String getTimein12hrFormat = BaseClass.convert24HourFormatTo12HourFormat(time);
			boolean Flag = getTimein12hrFormat.equalsIgnoreCase(timeText);
			Assert.assertEquals(true, Flag);
			System.out.println(getDateText);
//			String getddFormat = loginPage.convertFormatingDate(date);
//			Assert.assertEquals(getDateText, getddFormat);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public static void clickFeedbackBtn(String patientName) {
		BaseClass.waitForSpinnerToDisappear();
		try {
			Thread.sleep(5000);
			WebElement feedbackButton = driver.findElement(By.xpath("//td//span[contains(text(),'" + patientName
					+ "')]//../../../../../following-sibling::td//div//span[@class='actn-icn feedback']"));
			feedbackButton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void checkFeedbackBtnDisable(String toDate) {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(2000);
			Assert.assertTrue(driver.findElements(By.xpath(
					"//td[contains(text(),'" + toDate + "')]/following-sibling::td//span[@id='dashBoardFBList']"))
					.size() == 0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static boolean checkIfNoShow(WebElement noShowButton, WebElement iconExpiredButton,
			WebElement checkInButton) {
		return (checkIfElementDisplayed(noShowButton)
				&& (checkIfElementDisplayed(iconExpiredButton) || checkIfElementDisplayed(checkInButton)));
	}

	private static boolean checkIfConfirmed(WebElement deleteButton, WebElement editButton) {
		return (checkIfElementDisplayed(deleteButton) && checkIfElementDisplayed(editButton));
	}

	private static boolean checkIfElementDisplayed(WebElement webElement) {
		return (webElement != null && webElement.isDisplayed());
	}

}
