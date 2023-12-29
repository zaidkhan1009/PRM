package pageActions.patientDashboard;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import base.BaseClass;
import pages.patientDashboard.ReceiptListingPage;


public class ReceiptListingPageActions extends BaseClass {

	static ReceiptListingPage receiptListingPage = PageFactory.initElements(driver, ReceiptListingPage.class);

	public static void verifyPatientName(String patientName) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(receiptListingPage.getPatientNameReceiptListing());
		String str = receiptListingPage.getPatientNameReceiptListing().getText();
		String[] split = str.split(" : ");
		boolean flag = split[0].contains(patientName) && !(split[1].equals("NA") || split[1].equals("Null"));
		Assert.assertTrue(flag);
	}

	/*checking the header of the Receipt Listing page*/
	public static void headerOnListPage(String Header) {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(receiptListingPage.getHeaderReceiptListing(),5000);
		Assert.assertTrue(receiptListingPage.getHeaderReceiptListing().getText().contains(Header));
	}

//	public static void headerOnListPage(String Header) {
//		BaseClass.waitForPageLoad();
//		BaseClass.WaitTillElementIsPresent(receiptListingPage.getHeaderReceiptListing());
//		try {
//			Thread.sleep(5000);
//			Assert.assertTrue(receiptListingPage.getHeaderReceiptListing().getText().contains(Header));
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public static void noRecordMsgDisplayed() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(receiptListingPage.getNoRecordFoundMsg());
		Assert.assertTrue(checkedWebElementDisplayed(receiptListingPage.getNoRecordFoundMsg()));
	}

	public static void checkData() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedWebElementDisplayed(receiptListingPage.getSendReceiptBtn())&& checkedWebElementDisplayed(receiptListingPage.getSearchBtn())&& checkedWebElementDisplayed(receiptListingPage.getShowDetailsBtn())
				&& checkedWebElementDisplayed(receiptListingPage.getFromDateField())&& receiptListingPage.getFromDateField().getAttribute("placeholder").contains("» from (dd-mm-yy)") && checkedWebElementDisplayed(receiptListingPage.getDueAmount())
				&& checkedWebElementDisplayed(receiptListingPage.getToDateField())&& receiptListingPage.getToDateField().getAttribute("placeholder").contains("» to (dd-mm-yy)"));
	}

	public static void checkReceiptListingTableHead() {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(receiptListingPage.getDateHead(),4000);
		Assert.assertTrue(checkedWebElementDisplayed(receiptListingPage.getDateHead())&& checkedWebElementDisplayed(receiptListingPage.getReceiptHead())&& checkedWebElementDisplayed(receiptListingPage.getInvoiceHead())&& checkedWebElementDisplayed(receiptListingPage.getActionHead())
				&& checkedWebElementDisplayed(receiptListingPage.getAmountPaidHead())&& checkedWebElementDisplayed(receiptListingPage.getPaymentMethodHead())&& checkedWebElementDisplayed(receiptListingPage.getDoctorHead()));
	}

	//check Advance Amount shown on top in Receipt listing Page
	public static long checkAdvanceAmount(){
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(receiptListingPage.getAdvanceAmount(),40000);
		long amountAdvance = 0;
		try {
			amountAdvance = NumberFormat.getNumberInstance(Locale.US).parse(receiptListingPage.getAdvanceAmount().getText()).intValue();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return amountAdvance;
	}

	//check Due Amount shown on top in Receipt listing Page
	private long checkDueAmount(){
		BaseClass.waitForPageLoad();
		long amountDue = 0;
		try {
			amountDue = NumberFormat.getNumberInstance(Locale.US).parse(receiptListingPage.getDueAmount().getText()).intValue();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return amountDue;
	}

	//amount payable in coupon modal
	private static long amountPaidTabular(){
		BaseClass.waitForPageLoad();
		long amountPaid = 0,amountPaid1=0;
		// And iterate over them, getting the cells
		for (WebElement row : receiptListingPage.getRowTreatmentColumn()) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			String str = cells.get(4).getText().trim();
			String[] str1 = str.split("\\.");
			try {
				amountPaid = NumberFormat.getNumberInstance(Locale.US).parse(str1[0]).intValue();
				amountPaid1=amountPaid1+amountPaid;
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return amountPaid1;
	}

	public static void checkTotalAdvance() {
		BaseClass.waitForPageLoad();
		Assert.assertEquals(checkAdvanceAmount(), amountPaidTabular());
	}

	/*validating the invoice data*/
	public static void receiptDataTable(){
		BaseClass.waitForPageLoad();
		// And iterate over them, getting the cells
		for (WebElement row : receiptListingPage.getRowTreatmentColumn()) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			//receipt created date
			String createdDate = cells.get(1).getText();
			//receipt number
			WebElement receiptNumber = cells.get(2).findElement(By.cssSelector("span[class='dis-block']"));
			//invoice number
			String invoiceNumber = cells.get(3).getText().trim();
			//amount paid of receipt
			String[] amountPaid = cells.get(4).getText().trim().split("\\.");
			int amountPaidTabular = 0;
			//Payment Method
			String paymentMethod = cells.get(5).getText();
			String[] paymentMode = null;
			String actual_PaymentMethod = null;
			if(paymentMethod.contains("-")) {
				paymentMode=paymentMethod.split("-");
				Assert.assertTrue(!(paymentMode[0].contains("NA")||paymentMode[0].contains("null"))&&!(paymentMode[1].contains("NA")||paymentMode[1].contains("null")));
			}
			else {
				actual_PaymentMethod=paymentMethod;
				Assert.assertTrue(!(actual_PaymentMethod.contains("NA")||actual_PaymentMethod.contains("null")));
			}
			//	WebElement paymentMethod = cells.get(5).findElement(By.xpath("//span[@class='dis-block']/../following-sibling::td[3]"));
			//coupon amount of receipt
			WebElement ptrIdStatus = cells.get(5).findElement(By.xpath("//span[@class='dis-block']/../following-sibling::td[4]"));
			//doctor name at receipt
			String doctor=cells.get(6).getText().trim();
			try {
				amountPaidTabular = NumberFormat.getNumberInstance(Locale.US).parse(amountPaid[0]).intValue();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			//checking all the possible status of the treatment at invoices listing
			boolean flag1 = !(receiptNumber.getText().contains("null")||receiptNumber.getText().contains("NA"));
			//checking net amount validation
			boolean flag2= !(invoiceNumber.contains("null")||invoiceNumber.contains("NA")||invoiceNumber.contains(" "));
			//checking coupon amount validation
			//checking doctor name
			boolean flag6=!(doctor.contains("NA")||doctor.contains("null"));
			//checking correction notes
			boolean flag8=!(createdDate.contains("NA")||createdDate.contains("null"));
			//checking All data of table
//			Assert.assertTrue(flag1 && flag2   && flag6  && flag8);
		}
	}

	//checking the actions button of all the invoices on the basis of invoices created date
	public static void actionsButton_ReceiptsCreatedDate(){
		final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000L;
		for (WebElement row : receiptListingPage.getRowTreatmentColumn()) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			//Receipt created date
			String createdDate = cells.get(0).getText();
			//action buttons for every new Receipt
			WebElement viewBtn = cells.get(7).findElement(By.xpath("a[contains(@class,'patientReceiptViewCall')]"));
			WebElement editBtn = cells.get(7).findElement(By.xpath("a[contains(@class,'patientReceiptEditCall')]"));
			WebElement deleteBtn = cells.get(7).findElement(By.xpath("a[contains(@class,'deleteReciept')]"));
			WebElement printBtn = cells.get(7).findElement(By.xpath("a[contains(@class,'patientReceiptPrintCall')]"));
			//formatting the date according our requirement
			SimpleDateFormat simple = new SimpleDateFormat("dd-MM-yy");
			//current date
			String todayDate=null;
			Date date = new Date();
			//Receipt created date in date form
			Date receiptCreatedDate = null;
			try {
				//parsing String to Date
				receiptCreatedDate = simple.parse(createdDate);
				todayDate = simple.format(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			//checking if invoice created date is within 24 hr hour but not	on same day then delete,print,receipt,view only appear
			if((Math.abs(date.getTime() - receiptCreatedDate.getTime()) < MILLIS_PER_DAY)){
				Assert.assertTrue(checkedWebElementDisplayed(viewBtn)&&checkedWebElementDisplayed(printBtn)&&checkedWebElementDisplayed(editBtn)&&checkedWebElementDisplayed(deleteBtn));
				//checking actions button appear after the 24 hr.
			}else{
				Assert.assertTrue(checkedWebElementDisplayed(viewBtn)&&checkedWebElementDisplayed(printBtn)&&!checkedWebElementDisplayed(editBtn)&&!checkedWebElementDisplayed(deleteBtn));
			}
		}
	}

	//open the view modal which having Receipt created today
	public static void openViewModal(){
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(receiptListingPage.getPayInvoiceBtn(),4000);
		if(receiptListingPage.getRowTreatmentColumn().size()>0) {
			Random randomGenerator = new Random();
			int index = randomGenerator.nextInt(receiptListingPage.getRowTreatmentColumn().size());
			WebElement item = receiptListingPage.getRowTreatmentColumn().get(index);
			List<WebElement> cells = item.findElements(By.tagName("td"));
			String receiptNumber = cells.get(2).findElement(By.cssSelector("span[class='dis-block']")).getText();
			String receipt_Number_extentReport = receiptNumber + "-Receipt view Test cases executed";
			
			
			//changing LogStatus to Status for newer functionality
			logger.log(Status.PASS, receipt_Number_extentReport);
			WebElement viewBtn = cells.get(7).findElement(By.xpath("a[contains(@class,'patientReceiptViewCall')]"));
			viewBtn.click();
		}else{
			Assert.fail("There is no Receipt");
		}
	}

	public static void clickOnPayInvoice(){
		BaseClass.waitForSpinnerToDisappear();
		try {
			Thread.sleep(2200);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		BaseClass.waitForElementVisibility(receiptListingPage.getPayInvoiceBtn(),4000);
		receiptListingPage.getPayInvoiceBtn().click();
		try {
			Thread.sleep(2200);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
//		driver.navigate().refresh();
	}

	//closing the view modal
	public static void closeViewModal(){
		BaseClass.waitForPageLoad();
		receiptListingPage.getCloseViewModal().click();
		BaseClass.waitTillInvisiblityOfElement(receiptListingPage.getCloseViewModal());
	}

	//checking patient name and patient id at view modal
	public static void patientNamePatientId(String patientName){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(receiptListingPage.getPatientNameViewModal());
		String str = receiptListingPage.getPatientNameViewModal().getText();
		String str1=receiptListingPage.getPatientIdViewModal().getText();
		boolean flag = str.contains(patientName) && !(str1.equals("NA") || str1.equals(null));
		Assert.assertTrue(flag);
	}

	/*checking the header of the Receipt In view Modal*/
	public static void receiptHeaderInView(String Header) {
		BaseClass.waitForPageLoad();
		BaseClass.WaitTillElementIsPresent(receiptListingPage.getReceiptHeaderInView());
		try {
			Thread.sleep(5000);
			Assert.assertTrue(receiptListingPage.getReceiptHeaderInView().getText().contains(Header));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void checkDataInView() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedWebElementDisplayed(receiptListingPage.getInfoHeadInView())&& checkedWebElementDisplayed(receiptListingPage.getReceiptNoHeadInView())&& checkedWebElementDisplayed(receiptListingPage.getReceiptDateHeadInView())
				&& checkedWebElementDisplayed(receiptListingPage.getPaymentDetailsHeadInView())&&checkedWebElementDisplayed(receiptListingPage.getAmountReceivedHeadInView())&&checkedWebElementDisplayed(receiptListingPage.getModePaymentHeadInView())&& checkedWebElementDisplayed(receiptListingPage.getReceivedAsHeadInView())
				&& checkedWebElementDisplayed(receiptListingPage.getNotesHeadInView()));
	}

	//viewData
	public static void viewData(){
		BaseClass.waitForPageLoad();
		String receipt = receiptListingPage.getReceiptNumViewModal().getText().split("/")[1];
		String receipt_Date = receiptListingPage.getReceiptDate().getText();
		String amount_Received = receiptListingPage.getAmountReceive().getText();
		String mode_Payment = receiptListingPage.getModePayment().getText();
		String received_As = receiptListingPage.getReceivedAs().getText();
		//fetching cells from the receipt listing
		String receiptListingDAte = driver.findElement(By.xpath("//tbody[@id='"+receipt+"']/tr/td[2]")).getText().trim();
		String receiptListing_receipt = driver.findElement(By.xpath("//tbody[@id='"+receipt+"']/tr/td[3]")).getText().trim();
		String receiptListing_AmountPaid =  driver.findElement(By.xpath("//tbody[@id='"+receipt+"']/tr/td[5]")).getText().trim();
		String receiptListing_modePayment =  driver.findElement(By.xpath("//tbody[@id='"+receipt+"']/tr/td[6]")).getText().trim();
		String receiptListing_Doctor =  driver.findElement(By.xpath("//tbody[@id='"+receipt+"']/tr/td[7]")).getText().trim();
		boolean receipt_flag = receipt.equals(receiptListing_receipt);
		boolean ReceiptDate_flag=receipt_Date.equals(receiptListingDAte);
		boolean amount_flag=amount_Received.equals(receiptListing_AmountPaid);
		boolean modePayment_flag=mode_Payment.equals(receiptListing_modePayment);
		boolean note_flag=!(receiptListingPage.getNotes().getText().contains("NA")||receiptListingPage.getNotes().getText().contains("null"));
		boolean receivedAs_flag=!(received_As.contains("NA")||received_As.contains("null"));
		boolean doctor_flag=!(receiptListing_Doctor.contains("NA")||receiptListing_Doctor.contains("null"));
//		Assert.assertTrue(receipt_flag&&ReceiptDate_flag&&amount_flag&&modePayment_flag&&note_flag&&receivedAs_flag&&doctor_flag);
		System.out.println("receipt_flag"+receipt_flag);
		System.out.println("ReceiptDate_flag"+ReceiptDate_flag);
		System.out.println("amount_flag"+amount_flag);
		Assert.assertTrue(receipt_flag&&ReceiptDate_flag&&amount_flag);
	}

	public static void clickEditBtn(String mode) {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(receiptListingPage.getPayInvoiceBtn(),4000);
		WebElement ele = driver.findElement(By.xpath("//td[contains(text(),'"+mode+"')]/following-sibling::td/a[@class='patientReceiptEditCall btn']"));
		BaseClass.waitForModalBackdropToDisappear();
		ele.click();
	}

	public static void clickDeleteBtn(String mode) {
		BaseClass.waitForPageLoad();
		WebElement ele = driver.findElement(By.xpath("//td[contains(text(),'"+mode+"')]/following-sibling::td/a[@class='deleteReciept btn']"));
		ele.click();
	}

	/*checking all option in Reason Dropdown present in Additional details Panel*/
	public static void checkRequireDropDwn() {
		BaseClass.waitForPageLoad();
		boolean flag1,flag2, match= false;
		flag1=checkedWebElementDisplayed(receiptListingPage.getReasonDrpDwn());
		String[] exp = { "Select a reason", "Advance refund", "Change in treatment plan", "Incorrect payment received","Incorrect treatment plan","Payment refund","Others"};
		Select select = new Select(receiptListingPage.getReasonDrpDwn());
		List<WebElement> options = select.getOptions();
		for (WebElement we : options) {
			for (int i = 0; i < exp.length; i++) {
				if (flag2 = we.getText().equals(exp[i])) {
					match = flag1 && flag2;
				}
			}
			Assert.assertTrue(match);
		}
	}

	/*Select the Reason after click on ReTreat button from Reason Dropdown field*/
	public static void selectRequire(String reasonValue) {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(3000);
			BaseClass.selectFromDropDownByVisibleText(receiptListingPage.getReasonDrpDwn(), reasonValue);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void clickSaveBtnOnReasonPopUp() {
		BaseClass.waitForPageLoad();
		receiptListingPage.getReasonSaveBtn().click();
	}

	/*-- Validate the Successfull Msg --*/
	public static void verifySuccessfullMessage(){
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(5000);
			BaseClass.softAssert().assertTrue(checkedWebElementDisplayed(receiptListingPage.getSuccessfullMsg()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//Select the Show Details checkbox
	public static void clickShowDetails(){
		BaseClass.waitForPageLoad();
		receiptListingPage.getShowDetailsBtn().click();
	}

	//click the Search button
	public static void clickSearchBtn(){
		BaseClass.waitForPageLoad();
		receiptListingPage.getSearchBtn().click();
	}

	private static boolean checkedWebElementDisplayed(WebElement webElement) {
		return (webElement.isDisplayed());
	}


}
