package pageActions.patientDashboard;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import base.BaseClass;
import pages.patientDashboard.LabWorkOrderListingPage;

public class LabWorkOrderListingPageActions extends BaseClass {
	
	static LabWorkOrderListingPage labWorkOrderListingPage = PageFactory.initElements(driver, LabWorkOrderListingPage.class);

	
	/*-----------------------Functions-----------------------*/

	/*-- Checking the clinic Name in Main List --*/
	public static void checkClinicNameMainList(String teethNo,String clinicName) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'"+teethNo+"')]/ancestor::div[@class='labListDetailsTable ng-scope']/preceding-sibling::div//span[@class='col-xs-12 col-sm-3 nogap ng-binding']"));
		Assert.assertTrue(checkedWebElementDisplayed(ele));
		String str = ele.getText();
		String[] split = str.split(":");
		String clinic_Name = split[1].trim();
		Assert.assertEquals(clinic_Name, clinicName);
	}

	/*-- Checking the Order Type in Main List --*/
	public static void checkOrderTypeMainList(String teethNo,String orderType) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'"+teethNo+"')]/ancestor::div[@class='labListDetailsTable ng-scope']//span[text()='Order Type:']/.."));
		Assert.assertTrue(checkedWebElementDisplayed(ele));
		String str = ele.getText();
		String[] split = str.split(":");
		String order_Type = split[1].trim();
		Assert.assertEquals(order_Type, orderType);
	}

	/*-- Checking the only Date in Main List --*/
	public static void checkDateMainList(String teethNo,String date) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'"+teethNo+"')]/ancestor::div[@class='labListDetailsTable ng-scope']/preceding-sibling::div//span[@class='col-xs-12 col-sm-3 nogap text-right ng-binding']"));
		String str = ele.getText();
		String[] split = str.split(":");
		String newDate = split[1].trim();
		Assert.assertEquals(newDate, date);
	}

	/*-- Checking the Lab Name in Main List --*/
	public static void checkLabNameMainList(String teethNo,String labName) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'"+teethNo+"')]/ancestor::div[@class='labListDetailsTable ng-scope']/preceding-sibling::div//span[@class='col-xs-12 col-sm-6 text-center ng-binding']"));
		Assert.assertTrue(checkedWebElementDisplayed(ele));
		String[] split = ele.getText().split(":");
		String lab_Name = split[1].trim();
		Assert.assertEquals(lab_Name, labName);
	}

	/*-- Checking the LWO no. is not equals to NA or Null but except intially(When we Start LWO enable Trt) it is NA in Main List --*/
	public static void checkLabWorkOrderNo(String teethNo) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'"+teethNo+"')]/ancestor::div[@class='labListDetailsTable ng-scope']//span[text()='Lab Work Order No:']/.."));
		Assert.assertTrue(checkedWebElementDisplayed(ele));
		String[] split = ele.getText().split(":");
		String lab_WNO = split[1].trim();
		if(lab_WNO.equals("NA"))
			Assert.assertEquals(lab_WNO, "NA");
		else {
			boolean flag = !(lab_WNO.equals("NA") || lab_WNO.equals("Null"));
			Assert.assertTrue(flag);
		}
	}

	/*Check for previously entry which is InActive due to LWO updated */
	public static void checkInActiveEntry(String teethNo,String revision,String reason) {
		BaseClass.waitForPageLoad();
		if(reason.equals("Reworked")) {
			WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'"+teethNo+"')]/../../following-sibling::td//span[contains(text(),'"+revision+"')]/ancestor::tr[@class='ng-scope labInActive']//span[@class='inactiveArrow']"));
			Assert.assertTrue(checkedWebElementDisplayed(ele));
		}
		else {
			//WebElement ele = driver.findElement(By.xpath("//div[@class='textDataVisualizer tdvTooth ng-binding'][contains(text(),'"+teethNo+"')]/../../td/div/span/span[contains(text(),'"+revision+"')]/../../../../../tr/td/span[contains(@class,'inactiveArrow')]"));							
		// "//div[contains(text(),'"+teethNo+"')]/../following-sibling::td//span[contains(text(),'"+revision+"')]/ancestor::tr[@class='ng-scope labInActive']//span[@class='inactiveArrow']"));
			WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'"+teethNo+"')]/../following-sibling::td//span[contains(text(),'"+revision+"')]/ancestor::tr[@class='ng-scope labInActive']//span[@class='inactiveArrow']"));
			Assert.assertTrue(checkedWebElementDisplayed(ele));
		}
	}

	/*-- Checking the Date and Time show in Main List --*/
	public static void checkDateTimeMainList(String teethNo,String startDateTime,String endDateTime) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'"+teethNo+"')]/ancestor::table[@class='table labTable ng-scope']//th[text()='Date/Time']"));
		WebElement ele1 = driver.findElement(By.xpath("//div[contains(text(),'"+teethNo+"')]/ancestor::tr[@class='ng-scope']//td[@class='wrd-brk-all ng-binding']/preceding-sibling::td/div[@class='text-center ng-binding']"));
		String str = ele1.getText();
		String split = str.substring(0,8);
		String split1 = str.substring(9);
		String revisionDateTime = split+" "+split1.trim();
		Assert.assertTrue(checkedWebElementDisplayed(ele));
		System.out.println("revisionDateTime : "+ revisionDateTime);
		System.out.println("startDateTime : "+ startDateTime);
		System.out.println("endDateTime : "+ endDateTime);
		

//		String split1 = str.substring(8);
//		String revisionDateTime = split+" "+split1.trim();
//		Assert.assertTrue(checkedWebElementDisplayed(ele));

		try {
			SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yy H:mm a");
			Date dateTime = fmt.parse(revisionDateTime);
			Date fromDate = fmt.parse(startDateTime);
			Date toDate = fmt.parse(endDateTime);
			if (dateTime.after(fromDate) && dateTime.before(toDate)) {
				System.out.println("Date and Time of main list verified:- "+revisionDateTime);
			}
			else
				Assert.assertFalse(true);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*-- Checking the Work Details in Main List --*/
	public static void checkWorkDetailsMainlist(String teethNo,String workdetails) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'"+teethNo+"')]/ancestor::table[@class='table labTable ng-scope']//th[text()='Work Details']"));
		WebElement ele1 = driver.findElement(By.xpath("//div[contains(text(),'"+teethNo+"')]/ancestor::tr[@class='ng-scope']//td[text()='"+workdetails+"']"));
		String str = ele1.getText();
		Assert.assertTrue(checkedWebElementDisplayed(ele));
		Assert.assertEquals(str, workdetails);
	}

	/*-- Checking the Source in Main List --*/
	public static void checkSourceMainList(String teethNo) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'"+teethNo+"')]"));
		// changeing the xpath from driver.findElement(By.xpath("//div[contains(text(),'"+teethNo+"')]/ancestor::table[@class='table labTable ng-scope']//th[text()='Source']"));
		//WebElement ele1 = driver.findElement(By.xpath("//tr[@class='ng-scope']//td[contains(@class,'wrd-brk-all')]/div[contains(text(),'"+teethNo+"')]"));
		//String str = ele.getText();
		//WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'"+teethNo+"')]/ancestor::table[@class='table labTable ng-scope']//th[text()='Source']"));
		WebElement ele1 = driver.findElement(By.xpath("//tr[@class='ng-scope']//td[contains(@class,'wrd-brk-all')]/div[contains(text(),'"+teethNo+"')]"));
		String str = ele1.getText();

		Assert.assertTrue(checkedWebElementDisplayed(ele));
		Assert.assertTrue(str.contains(teethNo));
	}

	/*-- Checking the Source for Suspended and retreated Teeth in Main List --*/
	public static void checkSourceForSuspAndRetreatMainList(String teethNo) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'"+teethNo+"')]/ancestor::table[@class='table labTable ng-scope']//th[text()='Source']"));

		WebElement ele1 = driver.findElement(By.xpath("//span[@class='txtRed txt_strikeOff ng-binding'][contains(text(),'12')]"));
				
		// changing the xpath of the locator to identify the source ("//tr[@class='ng-scope']//td[contains(@class,'wrd-brk-all')]//span[contains(text(),'"+teethNo+"')]"));

		//WebElement ele1 = driver.findElement(By.xpath("//tr[@class='ng-scope']//td[contains(@class,'wrd-brk-all')]//span[contains(text(),'"+teethNo+"')]"));

		String str = ele1.getText();
		Assert.assertTrue(checkedWebElementDisplayed(ele));
		if(ele1.getAttribute("class").contains("txtRed")) {
			Assert.assertTrue(ele1.getAttribute("class").contains("txtRed"));
			Assert.assertEquals(str, teethNo);
		}
		else {
			Assert.assertTrue(ele1.getAttribute("class").contains("txtGrn"));
			Assert.assertEquals(str, teethNo);
		}
	}

	/*-- Checking the Doctor Name in Main List --*/
	public static void checkDoctorMainList(String teethNo,String doctor) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'"+teethNo+"')]/ancestor::table[@class='table labTable ng-scope']//th[text()='Doctor']"));
		WebElement ele1 = driver.findElement(By.xpath("//div[contains(text(),'"+teethNo+"')]/ancestor::tr[@class='ng-scope']//td[text()='"+doctor+"']"));
		String str = ele1.getText();
		Assert.assertTrue(checkedWebElementDisplayed(ele));
		Assert.assertEquals(str, doctor);
	}

	/*-- Checking the ItemSent in Main List --*/
	public static void checkItemSentMainList(String teethNo,String itemsent) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'"+teethNo+"')]/ancestor::table[@class='table labTable ng-scope']//th[text()='Item(s) Sent']"));
		WebElement ele1 = driver.findElement(By.xpath("//div[contains(text(),'"+teethNo+"')]/ancestor::tr[@class='ng-scope']/td[@class='pre hidden-xs hidden-sm wrd-brk-wrd']"));
		String str = ele1.getText();
		Assert.assertTrue(checkedWebElementDisplayed(ele));
		if(str.equals("NA"))
			Assert.assertEquals(str, itemsent);
		else if(str.contains(","))
			Assert.assertTrue(str.contains(itemsent));
		else {
			String[] split = str.split(":");
			Assert.assertEquals(split[0], itemsent);
		}
	}

	/*-- Checking the Revision and Reason in Main List --*/
	public static void checkRevisionReasonMainList(String teethNo,String revision,String reason) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'"+teethNo+"')]/ancestor::table[@class='table labTable ng-scope']//th[text()='Revision/Reason']"));
		WebElement ele1 = driver.findElement(By.xpath("//div[contains(text(),'"+teethNo+"')]/ancestor::tr[@class='ng-scope']//div[@class='revisionBlock text-center ng-binding']"));
		String str = ele1.getText();
		String split = str.substring(0,10);
		String split1 = str.substring(10);
		String exp_reason = split1.trim();
		Assert.assertTrue(checkedWebElementDisplayed(ele));
		Assert.assertEquals(split, revision);
		Assert.assertEquals(exp_reason, reason);
	}

	/*-- Checking the InActive Revision and Reason in Main List --*/
	public static void checkInActiveRevisionReasonMainList(String teethNo,String revision,String reason) {
		BaseClass.waitForPageLoad();

		WebElement ele = driver.findElement(By.xpath("(//div[contains(text(),'"+teethNo+"')]/../../td/div/span/span[contains(text(),'"+revision+"')]/../..)[1]"));
				
		// "//div[contains(text(),'"+teethNo+"')]/../following-sibling::td//span[contains(text(),'"+revision+"')]/ancestor::tr[@class='ng-scope labInActive']//div[@class='revisionBlock text-center ng-binding']"));
		
		//WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'"+teethNo+"')]/../following-sibling::td//span[contains(text(),'"+revision+"')]/ancestor::tr[@class='ng-scope labInActive']//div[@class='revisionBlock text-center ng-binding']"));
		String str = ele.getText();
		String split = str.substring(0,10);
		String split1 = str.substring(10);
		String exp_reason = split1.trim();
		Assert.assertEquals(split, revision);
		Assert.assertEquals(exp_reason, reason);
	}

	/*-- Checking the InActive Revision and Reason For rework in Main List --*/
	public static void checkInActiveRevisionReasonMainListForRework(String teethNo,String revision,String reason) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'"+teethNo+"')]/../../following-sibling::td//span[contains(text(),'"+revision+"')]/ancestor::tr[@class='ng-scope labInActive']//div[@class='revisionBlock text-center ng-binding']"));
		String str = ele.getText();
		String split = str.substring(0,10);
		String split1 = str.substring(10);
		String exp_reason = split1.trim();
		Assert.assertEquals(split, revision);
		Assert.assertEquals(exp_reason, reason);
	}

	/*-- Checking the Status and Date in Main List --*/
	public static void checkStatusDateMainList(String teethNo,String status,String startDateTime,String endDateTime ) {
		BaseClass.waitForPageLoad();
		
		WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'"+teethNo+"')]/../../td/div/span[text()='"+status+"']/.."));
		String str = ele.getText();
//		changed the xpath of the locator from below line
//		WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'"+teethNo+"')]/ancestor::table[@class='table labTable ng-scope']//th[text()='Status/Date']"));
//		WebElement ele1 = driver.findElement(By.xpath("//div[contains(text(),'"+teethNo+"')]/ancestor::tr[@class='ng-scope']//div[@class='text-center ng-binding']//span[text()='"+status+"']/.."));
//		String str = ele1.getText();
		String[] split = str.split("\\n");

		//WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'"+teethNo+"')]/ancestor::table[@class='table labTable ng-scope']//th[text()='Status/Date']"));
		//WebElement ele1 = driver.findElement(By.xpath("//div[contains(text(),'"+teethNo+"')]/ancestor::tr[@class='ng-scope']//div[@class='text-center ng-binding']//span[text()='"+status+"']/.."));
		//String str = ele1.getText();
		//String[] split = str.split("\\R");

		Assert.assertEquals(split[0],status);
		String actual_DateTime = split[1];
		Assert.assertTrue(checkedWebElementDisplayed(ele));

		try {
			SimpleDateFormat fmt = new SimpleDateFormat("dd-mm-yy h:mm a");
			Date dateTime = fmt.parse(actual_DateTime);
			Date fromDate = fmt.parse(startDateTime);
			Date toDate = fmt.parse(endDateTime);
			if (dateTime.after(fromDate) && dateTime.before(toDate)) {
				System.out.println(status+" as a status Date and Time of main list verified:- "+actual_DateTime);
			}
			else
				Assert.assertFalse(true);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*-- Checking the InActive Status and Date in Main List --*/
	public static void checkInActiveStatusDateMainList(String teethNo,String status,String startDateTime,String endDateTime ) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'"+teethNo+"')]/ancestor::tr[@class='ng-scope labInActive']//div[@class='text-center ng-binding']//span[text()='"+status+"']/.."));
		String str = ele.getText();
		String[] split = str.split("\\R");
		Assert.assertEquals(split[0],status);
		String actual_DateTime = split[1];

		try {
			SimpleDateFormat fmt = new SimpleDateFormat("dd-mm-yy h:mm a");
			Date dateTime = fmt.parse(actual_DateTime);
			Date fromDate = fmt.parse(startDateTime);
			Date toDate = fmt.parse(endDateTime);
			if (dateTime.after(fromDate) && dateTime.before(toDate)) {
				System.out.println(status+" as a status Date and Time of InActive main list verified:- "+actual_DateTime);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*-- Checking the Action heading name in Main List --*/
	public static void checkActionMainList(String teethNo) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'"+teethNo+"')]/ancestor::table[@class='table labTable ng-scope']//th[text()='Action']"));
		Assert.assertTrue(checkedWebElementDisplayed(ele));
	}

	/*click View button present in LWO listing*/
	public static void clickOnView(String teethNo) {
		BaseClass.waitForPageLoad();
		WebElement viewBtn = driver.findElement(By.xpath("//div[contains(text(),'"+teethNo+"')]/ancestor::tr[@class='ng-scope']//span[@class='actn-icn view']"));
		Assert.assertTrue(checkedWebElementDisplayed(viewBtn));
		viewBtn.click();
		BaseClass.waitForSpinnerToDisappear();
	}

	/*click on View When Rework button is present in LWO listing*/
	public static void clickOnViewAtTimeForRework(String teethNo) {
		BaseClass.waitForPageLoad();
		WebElement viewBtnAtTimeRework = driver.findElement(By.xpath("//span[contains(text(),'"+teethNo+"')]/ancestor::tr[@class='ng-scope']//span[@class='actn-icn view']"));
		Assert.assertTrue(checkedWebElementDisplayed(viewBtnAtTimeRework));
		viewBtnAtTimeRework.click();
	}

	/*click edit button present in LWO listing*/
	public static void clickOnEdit(String teethNo) {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(6000);
			WebElement editBtn = driver.findElement(By.xpath("//div[contains(text(),'"+teethNo+"')]/ancestor::tr[@class='ng-scope']//span[@class='actn-icn edit']"));
			Assert.assertTrue(checkedWebElementDisplayed(editBtn));
			editBtn.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*Check Edit button present in LWO listing*/
	public static void checkEditBtnMainList(String teethNo,String status) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'"+teethNo+"')]/ancestor::tr[@class='ng-scope']//span[@class='actn-icn edit']"));
		if(status.equals("Draft")||status.equals("Submitted To Lab")||status.equals("Payment Completed"))
			Assert.assertTrue(checkedWebElementDisplayed(ele));
		else
			Assert.assertFalse(checkedWebElementDisplayed(ele));
	}

	/*Check View button for InActive LWO show in LWO listing*/
	public static void checkInActiveViewBtn(String teethNo,String revision) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'"+teethNo+"')]/../following-sibling::td//span[contains(text(),'"+revision+"')]/../../../../../tr/td/div/a[@data-ng-click='view(labRecords.LabWorkOrder.id, labRecords.lwostage)']"));		
		// "//div[contains(text(),'"+teethNo+"')]/../following-sibling::td//span[contains(text(),'"+revision+"')]/ancestor::tr[@class='ng-scope labInActive']//span[@class='actn-icn view']"));
		//WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'"+teethNo+"')]/../following-sibling::td//span[contains(text(),'"+revision+"')]/ancestor::tr[@class='ng-scope labInActive']//span[@class='actn-icn view']"));
		Assert.assertTrue(checkedWebElementDisplayed(ele));
	}

	/*Check View button for InActive LWO in case for Rework show in LWO listing*/
	public static void checkInActiveViewBtnForRework(String teethNo,String revision) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'"+teethNo+"')]/../../following-sibling::td//span[contains(text(),'"+revision+"')]/ancestor::tr[@class='ng-scope labInActive']//span[@class='actn-icn view']"));
		Assert.assertTrue(checkedWebElementDisplayed(ele));
	}

	/*click Rework button present in LWO listing*/
	public static void clickOnRework(String teethNo) {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(3000);
			WebElement reWorkBtn = driver.findElement(By.xpath("//span[contains(text(),'"+teethNo+"')]/ancestor::tr[@class='ng-scope']//span[@class='actn-icn retreat']"));
			Assert.assertTrue(checkedWebElementDisplayed(reWorkBtn));
			reWorkBtn.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*Check Print button present in LWO listing*/
	public static void checkPrintBtn(String teethNo) {
		BaseClass.waitForPageLoad();
		WebElement printBtn = driver.findElement(By.xpath("//div[contains(text(),'"+teethNo+"')]/ancestor::tr[@class='ng-scope']//span[@class='actn-icn print']"));
		Assert.assertTrue(checkedWebElementDisplayed(printBtn));
	}

	/*----Functions in View Modal-----*/
	public static void checkedViewDataName() {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(3000);
			Assert.assertTrue(checkedWebElementDisplayed(labWorkOrderListingPage.getHeadingView()) &&checkedWebElementDisplayed(labWorkOrderListingPage.getLabNoView())&&
					checkedWebElementDisplayed(labWorkOrderListingPage.getWorkDeatilHeadView()) && checkedWebElementDisplayed(labWorkOrderListingPage.getLabView()) &&
					checkedWebElementDisplayed(labWorkOrderListingPage.getOrderTypeView()) && checkedWebElementDisplayed(labWorkOrderListingPage.getWorkDeatilView()) &&
					checkedWebElementDisplayed(labWorkOrderListingPage.getOtherInfoView()) && checkedWebElementDisplayed(labWorkOrderListingPage.getSourceView()) &&
					checkedWebElementDisplayed(labWorkOrderListingPage.getItemSentView()) && checkedWebElementDisplayed(labWorkOrderListingPage.getRequireView()) &&
					checkedWebElementDisplayed(labWorkOrderListingPage.getAdditionalDeatilsHeadView()) && checkedWebElementDisplayed(labWorkOrderListingPage.getShadeView()) &&
					checkedWebElementDisplayed(labWorkOrderListingPage.getStainsInternalView()) && checkedWebElementDisplayed(labWorkOrderListingPage.getStainsExternalView()) &&
					checkedWebElementDisplayed(labWorkOrderListingPage.getTranslucencyView()) && checkedWebElementDisplayed(labWorkOrderListingPage.getTextureView()) &&
					checkedWebElementDisplayed(labWorkOrderListingPage.getConfigurationView()) && checkedWebElementDisplayed(labWorkOrderListingPage.getSurfaceDetailsView()) &&
					checkedWebElementDisplayed(labWorkOrderListingPage.getNotesView()) && checkedWebElementDisplayed(labWorkOrderListingPage.getNotesAttachView()) &&
					checkedWebElementDisplayed(labWorkOrderListingPage.getTimelineView()) && checkedWebElementDisplayed(labWorkOrderListingPage.getDraftView()) &&
					checkedWebElementDisplayed(labWorkOrderListingPage.getTreatmentNameView()) && checkedWebElementDisplayed(labWorkOrderListingPage.getDraftView()) &&
					checkedWebElementDisplayed(labWorkOrderListingPage.getSubmittedView()) && checkedWebElementDisplayed(labWorkOrderListingPage.getTreatCompletedView())&&
					checkedWebElementDisplayed(labWorkOrderListingPage.getPayCompletedView()) && checkedWebElementDisplayed(labWorkOrderListingPage.getPayableView()));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*-- Checking the Header in LWO view Screen--*/
	public static void verifyHeaderInView(String header) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(labWorkOrderListingPage.getHeadingView());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(labWorkOrderListingPage.getHeadingView().getText().contains(header));
	}

	/*-- Checking the Patient Name in View --*/
	public static void verifyPatientNameView(String patientName) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(labWorkOrderListingPage.getPatientNameInView());
		String str = labWorkOrderListingPage.getPatientNameInView().getText();
		String[] split = str.split(" : ");
		boolean flag = split[0].trim().contains(patientName) && !(split[1].equals("NA") || split[1].equals("Null"));
		Assert.assertTrue(flag);
	}

	/*-- Checking the LWO No in View --*/
	public static void verifyLabWorkOrderNoView() {
		BaseClass.waitForPageLoad();
		String str = labWorkOrderListingPage.getLabNoView().getText();
		String[] split =str.split(":");
		String lab_WNO = split[1].trim();
		if(lab_WNO.equals("NA"))
			Assert.assertEquals(lab_WNO, "NA");
		else {
			boolean flag = !(lab_WNO.equals("NA") || lab_WNO.equals("Null"));
			Assert.assertTrue(flag);
		}
	}

	/*-- Checking the Date and Time in View --*/
	public static void verifyDateTimeInView(String startDateTime,String endDateTime) {
		BaseClass.waitForPageLoad();
		String str = labWorkOrderListingPage.getDateInView().getText();
		String split = str.substring(6);
		String exp_Date = split.trim();
		try {
			SimpleDateFormat fmt = new SimpleDateFormat("dd-mm-yy h:mm a");
			Date dateTime = fmt.parse(exp_Date);
			Date fromDate = fmt.parse(startDateTime);
			Date toDate = fmt.parse(endDateTime);
			if (dateTime.after(fromDate) && dateTime.before(toDate)) {
				System.out.println(" Date and Time In View Modal is verified "+exp_Date);
			}
			else
				Assert.assertFalse(true);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*-- Checking the Lab Name in View --*/
	public static void checkLabNameViewList(String labName) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//b[text()='Lab']/../following-sibling::div"));
		String actualLab = ele.getText();
		Assert.assertEquals(actualLab,labName);
	}
	
	/*-- Checking the Updation Reason in View --*/
	public static void checkUpdationReasonViewList(String reason) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//b[text()='Updation Reason']/../following-sibling::div"));
		String actualLab = ele.getText();
		Assert.assertEquals(actualLab,reason);
	}
	
	/*-- Checking the Order Type in View --*/
	public static void checkOrderTypeViewList(String orderType) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//b[text()='Order Type']/../following-sibling::div"));
		String actOrderType = ele.getText();
		Assert.assertEquals(actOrderType,orderType);
	}

	/*-- Checking the Work Details in View --*/
	public static void checkWorkDetailViewList(String workDetail) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//b[text()='Work Details']/../following-sibling::div"));
		String actWorkDetail = ele.getText();
		Assert.assertEquals(actWorkDetail,workDetail);
	}

	/*-- Checking the Other Info in View --*/
	public static void checkOtherInfoViewList(String otherInfo) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//b[text()='Other Info']/../following-sibling::div"));
		String actOtherInfo = ele.getText();
		Assert.assertEquals(actOtherInfo,otherInfo);
	}

	/*-- Checking the Source in View --*/
	public static void checkSourceViewList(String source,String Reason) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//b[text()='Source']/../following-sibling::div"));
		String actSource = ele.getText();
		if(actSource.contains("/"))
		{
			String[] split = actSource.split("/");
			Assert.assertEquals(split[0].trim(),source);
			Assert.assertEquals(split[1].trim(),Reason);
		}
		else
			Assert.assertEquals(actSource,source);
	}

	/*-- Checking the Source for Suspend in View --*/
	public static void checkSourceForSuspendedViewList(String source,String Reason) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//b[text()='Source']/../following-sibling::div//span[@class='txtRed ng-binding']"));
		String actSource = ele.getText();
		if(actSource.contains("/"))
		{
			String[] split = actSource.split("/");
			Assert.assertEquals(split[0].trim(),source);
			Assert.assertEquals(split[1].trim(),Reason);
		}
		else
			Assert.assertEquals(actSource,source);
	}

	/*-- Checking the Source For Reopen and Treatment Completed in View --*/
	public static void checkSourceForReopenAndTrtCompleteViewList(String source,String Reason) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//b[text()='Source']/../following-sibling::div//span[@class='txtGrn ng-binding']"));
		String actSource = ele.getText();
		if(actSource.contains("/"))
		{
			String[] split = actSource.split("/");
			Assert.assertEquals(split[0].trim(),source);
			Assert.assertEquals(split[1].trim(),Reason);
		}
		else
			Assert.assertEquals(actSource,source);
	}

	/*-- Checking the Item Sent in View --*/
	public static void checkItemSentViewList(String itemSent) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//b[text()='Item(s) Sent']/../following-sibling::div"));
		String actItemSent = ele.getText();
		Assert.assertTrue(checkedWebElementDisplayed(ele));
		if(actItemSent.equals("NA"))
			Assert.assertEquals(actItemSent, itemSent);
		else if(actItemSent.contains(","))
			Assert.assertTrue(actItemSent.contains(itemSent));
		else {
			String[] split = actItemSent.split(":");
			Assert.assertEquals(split[0], itemSent);
		}
	}

	/*-- Checking the Require in View --*/
	public static void checkRequireViewList(String require) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//b[text()='Require']/../following-sibling::div"));
		String actualLab = ele.getText();
		Assert.assertEquals(actualLab,require);
	}

	/*-- Checking the Shade in View --*/
	public static void checkShadeViewList(String shade,String shadeOption) {
		BaseClass.waitForPageLoad();
		if(shade.equals("NA")) {
			WebElement ele = driver.findElement(By.xpath("(//b[text()='Shade']/../following-sibling::div)[1]"));
			String actShade = ele.getText();
			Assert.assertEquals(actShade,shade);
		}
		else if(shade.equals("NA ")) {
			WebElement ele = driver.findElement(By.xpath("(//b[text()='Shade']/../following-sibling::div)[2]"));
			String actShade = ele.getText();
			String exp_shade = shade.trim();
			Assert.assertEquals(actShade,exp_shade);
		}
		else{
			WebElement ele = driver.findElement(By.xpath("(//b[text()='Shade']/../following-sibling::div)[2]"));
			String actShade = ele.getText();
			String actual_shade = shade+" "+":"+" "+shadeOption;
			Assert.assertEquals(actShade,actual_shade);
		}
	}

	/*-- Checking the Stains Internal in View --*/
	public static void checkStainsInternalViewList(String stainsInternal) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//b[text()='Stains Internal']/../following-sibling::div"));
		String actStainsInternal = ele.getText();
		Assert.assertEquals(actStainsInternal,stainsInternal);
	}

	/*-- Checking the Stains External in View --*/
	public static void checkStainsExternalViewList(String stainsExternal) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//b[text()='Stains External']/../following-sibling::div"));
		String actStainsExternal = ele.getText();
		Assert.assertEquals(actStainsExternal,stainsExternal);
	}

	/*-- Checking the Translucency in View --*/
	public static void checkTranslucencyViewList(String translucency) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//b[text()='Translucency']/../following-sibling::div"));
		String actTranslucency = ele.getText();
		Assert.assertEquals(actTranslucency,translucency);
	}

	/*-- Checking the Texture in View --*/
	public static void checkTextureViewList(String texture) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//b[text()='Texture']/../following-sibling::div"));
		String actTexture= ele.getText();
		Assert.assertEquals(actTexture,texture);
	}

	/*-- Checking the Configuration in View --*/
	public static void checkConfigurationsViewList(String configurations,String config_Option) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//b[text()='Configurations']/../following-sibling::span"));
		String actConfiguration= ele.getText().trim();
		if(actConfiguration.equals("Individual")||actConfiguration.equals("NA"))
			Assert.assertEquals(actConfiguration,configurations);
		else {
			String exp_configuration = configurations+":"+" "+config_Option;
			Assert.assertEquals(actConfiguration,exp_configuration);
		}
	}

	/*-- Checking the Surface Details in View --*/
	public static void checkSurfaceDetailsViewList(String surface_Details,String surface_Option) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//b[text()='Surface Details']/../following-sibling::div"));
		String actSurface_Details= ele.getText().trim();
		if(actSurface_Details.equals("NA"))
			Assert.assertEquals(actSurface_Details,surface_Details);
		else
			Assert.assertTrue(actSurface_Details.contains(surface_Details+": "+surface_Option));
	}

	/*-- Checking the Notes in View --*/
	public static void checkNotesViewList(String notes) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//b[text()='Notes']/../following-sibling::div"));
		String actNotes= ele.getText();
		Assert.assertEquals(actNotes,notes);
	}

	/*-- Checking the Attachment in View --*/
	public static void checkAttachmentViewList(String fileName) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//span[text()='"+fileName+"']"));
		Assert.assertTrue(checkedWebElementDisplayed(ele));
	}

	/*-- Close the View Screen --*/
	public static void clickViewScreenClose() {
		BaseClass.waitForPageLoad();
		labWorkOrderListingPage.getCloseViewScreen().click();
	}

	/*-- Checking the Revision Details Data in View --*/
	public static void checkedRevisionDetailsDataNameView() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedWebElementDisplayed(labWorkOrderListingPage.getRevisionDetailsHeadView()) &&checkedWebElementDisplayed(labWorkOrderListingPage.getRevisionNoHeadView())&&
				checkedWebElementDisplayed(labWorkOrderListingPage.getRevisionDateHeadView()) && checkedWebElementDisplayed(labWorkOrderListingPage.getCurrentStatusHeadView()));
	}

	/*-- Checking All Status whose are Enable in View --*/
	public static void checkStatusEnableInView(String statusName) {
		BaseClass.waitForPageLoad();
		try {
			if(statusName.equalsIgnoreCase("Payable To Lab")) {
				statusName="Payable";
			}
			Thread.sleep(3000);
			WebElement ele = driver.findElement(By.xpath("(//div[text()='"+statusName+"']/..//div[@class='glyphicon glyphicon-ok'])[1]"));
			Assert.assertTrue(checkedWebElementDisplayed(ele));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*-- Verifying All Status whose are Enable in View --*/
	public static void verifyStatusInView(String statusName,String startDateTime,String endDateTime) {
		BaseClass.waitForPageLoad();
		//WebElement ele = driver.findElement(By.xpath("((//div[text()='"+statusName+"']/../following-sibling::div[@class='pos three'])[1]/div)[3]"));		
			if(statusName.equalsIgnoreCase("Payable To Lab")) {
				statusName="Payable";
			}
		WebElement ele = driver.findElement(By.xpath("(//div[text()='"+statusName+"']/following-sibling::div[@class='graphTxtBtm ng-binding'])[1]"));
		String str = ele.getText();
		try {
			SimpleDateFormat fmt = new SimpleDateFormat("dd-mm-yy h:mm a");
			Date dateTime = fmt.parse(str);
			Date fromDate = fmt.parse(startDateTime);
			Date toDate = fmt.parse(endDateTime);
			if (dateTime.after(fromDate) && dateTime.before(toDate)) {
				System.out.println(statusName+" Date and Time In View Modal is verified:- "+str);
			}
			else
				Assert.assertFalse(true);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*-- Check Revision No. in View --*/
	public static void checkRevisionNoViewList(String revisionNo) {
		BaseClass.waitForPageLoad();
		String actRevisionNo = labWorkOrderListingPage.getRevisionNoView().getText();
		Assert.assertEquals(actRevisionNo,revisionNo);
	}

	/*-- Check Treatment name in View --*/
	public static void verifyTreatmentNameView(String treatmentName,int count) {
		BaseClass.waitForPageLoad();
		String ele = labWorkOrderListingPage.getTreatmentNameView().getText();
		String treatmentHead = ele.substring(0, 14);
		String actual_TreatmentName = ele.substring(17);
		Assert.assertTrue(treatmentHead.trim().contains("Treatment Name"));
		String actual_trt = actual_TreatmentName.trim();
		if(actual_trt.contains("Bridge"))
			Assert.assertEquals(actual_trt, treatmentName+" (" +count+ " unit(s) Bridge)");
		else
			Assert.assertEquals(actual_trt, treatmentName);

	}

	/*-- Check Revision Date in View --*/
	public static void verifyRevisionDateInView(String startDateTime,String endDateTime) {
		BaseClass.waitForPageLoad();
		String str=labWorkOrderListingPage.getRevisionDateView().getText();
		try {
			SimpleDateFormat fmt = new SimpleDateFormat("dd-mm-yy h:mm a");
			Date dateTime = fmt.parse(str);
			Date fromDate = fmt.parse(startDateTime);
			Date toDate = fmt.parse(endDateTime);
			if (dateTime.after(fromDate) && dateTime.before(toDate)) {
				System.out.println("Revision Date and Time In View Modal is verified "+str);
			}
			else
				Assert.assertFalse(true);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*-- Check Current Status in View --*/
	public static void checkCurrentStatusViewList(String statusName) {
		BaseClass.waitForPageLoad();
		String actRevisionNo = labWorkOrderListingPage.getCurrentStatusView().getText();
		Assert.assertEquals(actRevisionNo,statusName);
	}

	/*-- Validate the Successfull Msg --*/
	public static void verifySuccessfullMessage(){
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(3000);
			BaseClass.softAssert().assertTrue(checkedWebElementDisplayed(labWorkOrderListingPage.getSuccessfullMsg()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*-- Validate the Successfull Msg For rework --*/
	public static void verifySuccessfullMessageForRework(){
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(3000);
			BaseClass.softAssert().assertTrue(checkedWebElementDisplayed(labWorkOrderListingPage.getSuccessfullMsgForReWork()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static boolean checkedWebElementDisplayed(WebElement webelement) {
		return (webelement.isDisplayed());
	}
}
