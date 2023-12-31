package pageActions.patientDashboard;

import com.aventstack.extentreports.Status;
import base.BaseClass;
import pages.patientDashboard.InvoiceListingPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 * @Author:-Ajit Yadav
 * email:-ajit.yadav@instantsys.com
 * Date:-15-05-20
 */
public class InvoiceListingPageActions extends BaseClass {
	
	static InvoiceListingPage invoiceListingPage = PageFactory.initElements(driver, InvoiceListingPage.class);


	//selecting the collect by payment
//	public static void collectPayment(){
//		BaseClass.waitForPageLoad();
//		try {
//			BaseClass.waitForElementToBeClickable(invoiceListingPage.getCollectPaymentBtn());
//			invoiceListingPage.getCollectPaymentBtn().click();
//			Thread.sleep(8000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
	public static void collectPayment(){
		BaseClass.waitForElementVisibility(invoiceListingPage.getCollectPaymentBtn(),4000);
		BaseClass.waitForModalOverlayToDisappear();
		invoiceListingPage.getCollectPaymentBtn().click();
	}

	//selecting the collect by payment
	public static void collectAdvancePayment(){
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(invoiceListingPage.getCollectAdvanceBtn(),4000);
		BaseClass.waitForModalOverlayToDisappear();
		invoiceListingPage.getCollectAdvanceBtn().click();
	}

	//	public static void collectAdvancePayment(){
//		BaseClass.waitForPageLoad();
//		try {
//			BaseClass.waitForElementToBeClickable(invoiceListingPage.getCollectAdvanceBtn());
//			invoiceListingPage.getCollectAdvanceBtn().click();
//			Thread.sleep(8000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
	//selecting the show details button
	public static void selectShowDetails(){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(invoiceListingPage.getShowDetailCheckBox());
		BaseClass.waitForModalOverlayToDisappear();
		invoiceListingPage.getShowDetailCheckBox().click();
	}
	//selecting the show details button
	public static void clickOnSearch(){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(invoiceListingPage.getInvoiceListSearchBtn());
		try {
			invoiceListingPage.getInvoiceListSearchBtn().click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/*Checking at invoice listing page invoices data column names*/

//	public static void invoiceListTableColumnName() {
//		BaseClass.waitForPageLoad();
//		try {
//			Thread.sleep(4000);
//			BaseClass.waitForElementToBeClickable(date);
//			Assert.assertTrue(checkedWebElementDisplayed(date) && checkedWebElementDisplayed(invoice) && checkedWebElementDisplayed(treatmentStatus) && checkedWebElementDisplayed(netAmount)
//					&& checkedWebElementDisplayed(couponAmount) && checkedWebElementDisplayed(amountDue) && checkedWebElementDisplayed(amountPaid)
//					&& checkedWebElementDisplayed(doctor) && checkedWebElementDisplayed(actionBtn));
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}

	public static void invoiceListTableColumnName() {
		BaseClass.waitForElementToBeClickable(invoiceListingPage.getDate());
		Assert.assertTrue(checkedWebElementDisplayed(invoiceListingPage.getDate()) && checkedWebElementDisplayed(invoiceListingPage.getInvoice()) && checkedWebElementDisplayed(invoiceListingPage.getNetAmount())
				&& checkedWebElementDisplayed(invoiceListingPage.getCouponAmount()) && checkedWebElementDisplayed(invoiceListingPage.getAmountDue()) && checkedWebElementDisplayed(invoiceListingPage.getAmountPaid())
				&& checkedWebElementDisplayed(invoiceListingPage.getDoctor()) && checkedWebElementDisplayed(invoiceListingPage.getActionBtn()));
	}

	//checking collect advace payment button at invoice listing
	public static void checkCollectAdvacePaymentBtn(){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(invoiceListingPage.getCollectAdvanceBtn());
		Assert.assertTrue(checkedWebElementDisplayed(invoiceListingPage.getCollectAdvanceBtn()));
	}

	//checking collect advace payment button at invoice listing
	public static void checkCollectPaymentBtn(){
		BaseClass.waitForPageLoad();
//		BaseClass.waitForElementToBeClickable(invoiceListingPage.getCollectPaymentBtn());
		Assert.assertTrue(checkedWebElementDisplayed(invoiceListingPage.getCollectPaymentBtn()));
	}

	/*Checking header on invoice listing page*/
	public static void headerPage(String headerInvoiceList) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(invoiceListingPage.getHeaderPage());
		Assert.assertTrue(invoiceListingPage.getHeaderPage().getText().contains(headerInvoiceList));
	}

	/*Checking patient name and patient id*/
	public static void verifyUserName(String patientName) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(invoiceListingPage.getUserName());
		String str = invoiceListingPage.getUserName().getText();
		String[] split = str.split(" : ");
		boolean flag = split[0].equalsIgnoreCase(patientName) && !(split[1].equals("NA") || split[1].equals(null));
		Assert.assertTrue(flag);
	}

	/*Checking treatment status dropdown at invoice listing page*/
	public static void treatmentStatusDropDown(String defaultTreatmentStatusSelected) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(invoiceListingPage.getTreatmentStatusDropDown());
		boolean flag1, flag2, match = false;
		flag1 = checkedWebElementDisplayed(invoiceListingPage.getTreatmentStatusDropDown()) && BaseClass.firstSelectedOption(invoiceListingPage.getTreatmentStatusDropDown()).contains(defaultTreatmentStatusSelected);
		String[] exp = {"Select Status", "In-Progress", "Complete"};
		Select select = new Select(invoiceListingPage.getTreatmentStatusDropDown());
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

	/*Checking invoices status dropdown at invoice listing page*/
	public static void invoiceStatusDropDown(String defaultInvoiceStatusSelected) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(invoiceListingPage.getInvoiceStatusDropDown());
		boolean flag1, flag2, match = false;
		flag1 = checkedWebElementDisplayed(invoiceListingPage.getInvoiceStatusDropDown()) && BaseClass.firstSelectedOption(invoiceListingPage.getInvoiceStatusDropDown()).contains(defaultInvoiceStatusSelected);
		String[] exp = {"Select Invoice Status", "New, Pending", "Close"};
		Select select = new Select(invoiceListingPage.getInvoiceStatusDropDown());
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

	/*checking checkbox and "Show Details" text for show details*/
	public static void showDetailsCheckBox() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(invoiceListingPage.getShowDetailCheckBox());
		Assert.assertTrue(checkedWebElementDisplayed(invoiceListingPage.getShowDetailCheckBox()));
	}

	/*Checking invoice search button and "Search" text at invoice listing page */
	public static void checkSearchBtn() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(invoiceListingPage.getInvoiceListSearchBtn());
		Assert.assertTrue(checkedWebElementDisplayed(invoiceListingPage.getInvoiceListSearchBtn()));
	}

	public static void checkResetBtn() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(invoiceListingPage.getResetBtn());
		Assert.assertTrue(checkedWebElementDisplayed(invoiceListingPage.getResetBtn()));
	}

	/*checking total due amount text
	 * without invoices total due amount at invoices listing
	 *total advance amount text
	 * without invoices total amount at invoice listing  */

	public static void amountSection() {
		boolean isdueAmtDisplayed = invoiceListingPage.getDueAmnt().isDisplayed();
		boolean isAdvAmtDisplayed = invoiceListingPage.getAdvAmt().isDisplayed();
		Assert.assertTrue(isdueAmtDisplayed && isAdvAmtDisplayed);
	}


//	public static void amountSection(int total_Due_Amount,int total_Advance_Amount) {
//		BaseClass.waitForPageLoad();
//		BaseClass.waitForElementToBeClickable(invoiceListingPage.getTotalDueAmount());
//		Assert.assertTrue( invoiceListingPage.getTotalDueAmount().getText().contains(Integer.toString(total_Due_Amount)) && totalAdvanceAmount.getText().contains(Integer.toString(total_Advance_Amount)));
//	}

	/*Checking no record found at invoice listing page */
	public static void noRecordFound() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(invoiceListingPage.getNoRecordFoundText());
		Assert.assertTrue(checkedWebElementDisplayed(invoiceListingPage.getNoRecordFoundText()));
	}

	/*checking receipts list button and text at receipt listing button*/
	public static void checkReceiptBtn() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(invoiceListingPage.getReceiptsListBtn());
		Assert.assertTrue(checkedWebElementDisplayed(invoiceListingPage.getReceiptsListBtn()));
	}

	/*validating the invoice data*/

	public static void invoiceDataTable(){
		BaseClass.waitForPageLoad();
		// And iterate over them, getting the cells
		BaseClass.visibilityOfListLocated(invoiceListingPage.getAllRowsInvoices());
		for (WebElement row : invoiceListingPage.getAllRowsInvoices()) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			//invoice created date
			String createdDate = cells.get(1).getText();
			//invoice number and invoice status
			WebElement invoiceStatus = cells.get(2).findElement(By.xpath("//span[contains(@data-ng-class,'invoiceDataList.invoiceStatus')]"));
			WebElement invoiceNumber =  driver.findElement(By.xpath("(//table[@class='table table-striped']/tbody/tr//td//span[@class='pd-lft-5 ng-binding'])"));
			//treatment status
			WebElement invoiceTreatmentStatus = cells.get(3).findElement(By.xpath("//span[contains(@data-ng-show,'invoiceDataList.treatmentStatus') and not(contains(@class,'ng-hide'))]"));
			//net amount of invoice
			String[] netAmount = cells.get(4).getText().trim().split("\\.");
			int netAmountPrice = 0;
			//coupon amount of invoice
			String[] couponAmount = cells.get(5).getText().trim().split("\\.");
			int couponAmountTabuler = 0;
			//amount Due of invoices
			String[] amountDue = cells.get(6).getText().trim().split("\\.");
			int amountDueTabular = 0;
			//amount paid of invoice
			String[] amountPaid = cells.get(7).getText().trim().split("\\.");
			int amountPaidTabular = 0;
			//doctor name at invoice
			String doctor=cells.get(8).getText().trim();
			//correction note at invoice
			String correctionNote = cells.get(9).getText().trim();
			try {
				netAmountPrice = NumberFormat.getNumberInstance(Locale.US).parse(netAmount[0]).intValue();
				couponAmountTabuler = NumberFormat.getNumberInstance(Locale.US).parse(couponAmount[0]).intValue();
				amountDueTabular = NumberFormat.getNumberInstance(Locale.US).parse(amountDue[0].trim()).intValue();
				amountPaidTabular = NumberFormat.getNumberInstance(Locale.US).parse(amountPaid[0]).intValue();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			//checking invoices All possible status of invoice
			if (amountPaidTabular == 0) {
				Assert.assertTrue(!invoiceNumber.getText().contains("null")||invoiceNumber.getText().contains("NA"));
			} else if(amountPaidTabular!=0 && amountDueTabular!=0){
				Assert.assertTrue(!invoiceNumber.getText().contains("null")||invoiceNumber.getText().contains("NA"));
			}else{
				Assert.assertTrue(!invoiceNumber.getText().contains("null")||invoiceNumber.getText().contains("NA"));
			}
			//checking all the possible status of the treatment at invoices listing
			boolean flag1 = invoiceTreatmentStatus.getAttribute("class").contains("partially-progress") || invoiceTreatmentStatus.getAttribute("title").contains("Treatment(s) partially completed");
			//checking net amount validation
			boolean flag2=(netAmountPrice==(amountDueTabular+couponAmountTabuler+amountPaidTabular));
			//checking coupon amount validation
			boolean flag3=(couponAmountTabuler==(netAmountPrice-(amountDueTabular+amountPaidTabular)));
			//checking amount due validation
			boolean flag4=(amountDueTabular==(netAmountPrice-(couponAmountTabuler+amountPaidTabular)));
			//checking amount paid validation
			boolean flag5=(amountPaidTabular==(netAmountPrice-(amountDueTabular+couponAmountTabuler)));
			//checking doctor name
			boolean flag6=!(doctor.contains("NA")||doctor.contains("null"));
			//checking correction notes
			boolean flag7=correctionNote.contains("NA")||(!correctionNote.contains("null"));
			//checking invoice created date
			boolean flag8=!(createdDate.contains("NA")||createdDate.contains("null"));
			//checking all the possible invoice status at invoices listing
			boolean flag9 = invoiceStatus.getAttribute("data-ng-class").contains("pending") || invoiceStatus.getAttribute("class").contains("new");
			//checking All data of table
			Assert.assertTrue(flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag7 && flag8 && flag9);
		}
	}

	//checking the actions button of all the invoices on the basis of invoices created date
	public static void actionsButton_InvoicesCreatedDate(){
		final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000L;
		for (WebElement row : invoiceListingPage.getAllRowsInvoices()) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			//invoice created date
			String createdDate = cells.get(1).getText();
			//action buttons for every new invoice
			WebElement viewBtn = cells.get(10).findElement(By.xpath("a[contains(@data-ng-click,'invoiceView')]"));
			WebElement couponBtn = cells.get(10).findElement(By.xpath("a[contains(@data-ng-click,'couponView')]"));
			WebElement receiptBtn = cells.get(10).findElement(By.xpath("a[contains(@data-ng-click,'getReceipt')]"));
			WebElement deleteBtn = cells.get(10).findElement(By.xpath("a[contains(@data-ng-click,'deleteInvoice')]"));
			WebElement printBtn = cells.get(10).findElement(By.xpath("a[contains(@data-ng-click,'getPrint')]"));
			//formatting the date according our requirement
			SimpleDateFormat simple = new SimpleDateFormat("dd-MM-yy");
			//current date
			String todayDate=null;
			Date date = new Date();
			//invoice created date in date form
			Date invoiceCreatedDate = null;
			try {
				//parsing String to Date
				invoiceCreatedDate = simple.parse(createdDate);
				todayDate = simple.format(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			//checking coupon button should only appear on the invoice created date with other like print,view,receipt,delete
			if((Math.abs(date.getTime() - invoiceCreatedDate.getTime()) < MILLIS_PER_DAY)&&createdDate.equals(todayDate)){
				Assert.assertTrue(checkedWebElementDisplayed(viewBtn)&&checkedWebElementDisplayed(receiptBtn)&&checkedWebElementDisplayed(printBtn)&&checkedWebElementDisplayed(couponBtn)&&checkedWebElementDisplayed(deleteBtn));
				//checking if invoice created date is within 24 hr hour but not	on same day then delete,print,receipt,view only appear
			}else if((Math.abs(date.getTime() - invoiceCreatedDate.getTime()) < MILLIS_PER_DAY)&&!createdDate.equals(todayDate)){
				Assert.assertTrue(checkedWebElementDisplayed(viewBtn)&&checkedWebElementDisplayed(receiptBtn)&&checkedWebElementDisplayed(printBtn)&&!checkedWebElementDisplayed(couponBtn)&&checkedWebElementDisplayed(deleteBtn));
				//checking actions button appear after the 24 hr.
			}else{
//				Assert.assertTrue(checkedWebElementDisplayed(viewBtn)&&checkedWebElementDisplayed(receiptBtn)&&checkedWebElementDisplayed(printBtn)&!checkedWebElementDisplayed(couponBtn)&&!checkedWebElementDisplayed(deleteBtn));
				Assert.assertTrue(checkedWebElementDisplayed(viewBtn)&&checkedWebElementDisplayed(receiptBtn)&&checkedWebElementDisplayed(printBtn)&&checkedWebElementDisplayed(couponBtn)&&checkedWebElementDisplayed(deleteBtn));
			}
		}
	}

	//checking the total net amount calculation
	public static void netAmountAllInvoices(){
		Assert.assertEquals(totalNetAmount(),(totalAmountPaid()+totalAmountDueAllInvoices()+totalCouponAmount()));
	}

	//checking the total coupon amount calculation
	public static void couponAmountAllInvoices(){
		Assert.assertEquals(totalCouponAmount(),(totalNetAmount()-(totalAmountPaid()+totalAmountDueAllInvoices())));
	}

	//checking the total amount due calculation
	public static void amountDueAllInvoices(){
		if(totalAmountDue()==totalAmountDueAllInvoices()){
			Assert.assertEquals(totalAmountDueAllInvoices(),(totalNetAmount()-(totalAmountPaid()+totalCouponAmount())));
		}else {
			Assert.fail();
		}
	}

	//checking the total amount paid calculation
	public static void amountPaidAllInvoices(){
		Assert.assertEquals(totalAmountPaid(),(totalNetAmount()-(totalCouponAmount()+totalAmountDueAllInvoices())));
	}

	//calculating sum of net amount of all the invoices together
	private static long totalNetAmount() {
		BaseClass.waitForPageLoad();
		long netAmountPrice = 0,netAmountPrice1 = 0;
		// And iterate over them, getting the cells
		BaseClass.visibilityOfListLocated(invoiceListingPage.getAllRowsInvoices());
		for (WebElement row : invoiceListingPage.getAllRowsInvoices()) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			String str = cells.get(4).getText().trim();
			String[] str1 = str.split("\\.");
			try {
				netAmountPrice = NumberFormat.getNumberInstance(Locale.US).parse(str1[0]).intValue();
				netAmountPrice1=netAmountPrice1+netAmountPrice;
				System.out.println("Net Amount Price"+netAmountPrice1);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return netAmountPrice1;
	}

	//calculating sum of amount paid of all the invoices together
	private static long totalAmountPaid() {
		BaseClass.waitForPageLoad();
		long amountPaidPrice = 0,amountPaidPrice1=0;
		// And iterate over them, getting the cells
		BaseClass.visibilityOfListLocated(invoiceListingPage.getAllRowsInvoices());
		for (WebElement row : invoiceListingPage.getAllRowsInvoices()) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			String str = cells.get(7).getText().trim();
			String[] str1 = str.split("\\.");
			try {
				amountPaidPrice = NumberFormat.getNumberInstance(Locale.US).parse(str1[0]).intValue();
				amountPaidPrice1=amountPaidPrice1+amountPaidPrice;
				System.out.println("Amount Paid Price"+amountPaidPrice1);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return amountPaidPrice1;
	}

	//calculating sum of amount due of all the invoices together
	private static long totalAmountDueAllInvoices() {
		BaseClass.waitForPageLoad();
		long amountDue = 0,amountDue1=0;
		// And iterate over them, getting the cells
		BaseClass.visibilityOfListLocated(invoiceListingPage.getAllRowsInvoices());
		for (WebElement row : invoiceListingPage.getAllRowsInvoices()) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			String str = cells.get(6).getText().trim();
			String[] str1 = str.split("\\.");
			try {
				amountDue = NumberFormat.getNumberInstance(Locale.US).parse(str1[0].trim()).intValue();
				amountDue1=amountDue1+amountDue;
				System.out.println("Total Amount Due All Invoice"+amountDue1);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return amountDue1;
	}

	//calculating sum of coupon amount of all the invoices together
	private static long totalCouponAmount() {
		BaseClass.waitForPageLoad();
		long couponAmountTabuler = 0,couponAmountTabuler1=0;
		// And iterate over them, getting the cells
		BaseClass.visibilityOfListLocated(invoiceListingPage.getAllRowsInvoices());
		for (WebElement row : invoiceListingPage.getAllRowsInvoices()) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			String str = cells.get(5).getText().trim();
			String[] str1 = str.split("\\.");
			try {
				couponAmountTabuler = NumberFormat.getNumberInstance(Locale.US).parse(str1[0]).intValue();
				couponAmountTabuler1=couponAmountTabuler1+couponAmountTabuler;
				System.out.println("Total Coupon Amount"+couponAmountTabuler1);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return couponAmountTabuler1;
	}

	//converting the string into integer
	private static long totalAmountDue() {
		long totalAmountDue = 0;
		try {
			totalAmountDue = NumberFormat.getNumberInstance(Locale.US).parse(invoiceListingPage.getTotalDueAmount().getText().trim()).intValue();
			System.out.println("Hello total amount due"+totalAmountDue);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return totalAmountDue;
	}

	//open the view modal which having invoice created today
	public static void openViewModal(){
		BaseClass.visibilityOfListLocated(invoiceListingPage.getAllRowsInvoices());
		if(invoiceListingPage.getAllRowsInvoices().size()>0) {
			Random randomGenerator = new Random();
			int index = randomGenerator.nextInt(invoiceListingPage.getAllRowsInvoices().size());
			WebElement item = invoiceListingPage.getAllRowsInvoices().get(index);
			List<WebElement> cells = item.findElements(By.tagName("td"));
			String invoiceNumber = cells.get(2).findElement(By.xpath("//span[@class='pd-lft-5 ng-binding']")).getText();
			String invoice_Number_extentReport = invoiceNumber + "-invoice view Test cases executed";
			
			//changing LogStatus to Status for newer functionality
			logger.log(Status.PASS, invoice_Number_extentReport);
			WebElement viewBtn = cells.get(10).findElement(By.xpath("a[contains(@data-ng-click,'invoiceView')]"));
			viewBtn.click();
		}else{
			Assert.fail("There is no invoice");
		}
	}

	//closing the view modal
	public static void closeViewModal(){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(invoiceListingPage.getViewModalCloseModal());
		invoiceListingPage.getViewModalCloseModal().click();
	}
	//checking patient name and patient id at view modal
	public static void patientNamePatientId(String patientName){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(invoiceListingPage.getPatientNameViewModal());
		String str = invoiceListingPage.getPatientNameViewModal().getText();
		String str1=invoiceListingPage.getPatientIdViewModal().getText();
		boolean flag = str.contains(patientName) && !(str1.equals("NA") || str1.equals(null));
		Assert.assertTrue(flag);
	}
	//validating total due for an invoice at the view modal
	public static void totalDueViewModal(){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(invoiceListingPage.getTotalDueViewModal());
		String[] split = invoiceListingPage.getTotalDueViewModal().getText().split("\\r?\\n");
		String[] totalDue_viewModal = split[1].split("\\.");
		String[] invoiceNumber = invoiceListingPage.getInvoiceNoViewModal().getText().split("/");
		String invoice_tabular = invoiceNumber[1];
		WebElement paidAmount = driver.findElement(By.xpath("(//span[contains(text(),'" + invoice_tabular + "')]/ancestor::td/following-sibling::td)[5]"));
		String[] amountPaid=paidAmount.getText().trim().split("\\.");
		String[] totalPayableAmountView = invoiceListingPage.getTotalPayableAmountViewModal().getText().split("\\.");
		long totalDue_viewModal_price=0,amountPaid_price=0,totalPayableAmountView_price=0;
		try {
			totalDue_viewModal_price = NumberFormat.getNumberInstance(Locale.US).parse(totalDue_viewModal[0]).intValue();
			amountPaid_price = NumberFormat.getNumberInstance(Locale.US).parse(amountPaid[0]).intValue();
			totalPayableAmountView_price = NumberFormat.getNumberInstance(Locale.US).parse(totalPayableAmountView[0]).intValue();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(totalPayableAmountView_price==(totalDue_viewModal_price+amountPaid_price));
	}
	//checking column name at invoice view modal
	public static void columnNameInvoiceViewModal(){
		BaseClass.waitForPageLoad();
//		BaseClass.waitForElementToBeClickable(headerItemDetails);
		Assert.assertTrue(checkedWebElementDisplayed(invoiceListingPage.getTreatmentNameColumnViewModal())&&checkedWebElementDisplayed(invoiceListingPage.getUnitCostColumnViewModal())&&checkedWebElementDisplayed(invoiceListingPage.getSourceColumnViewModal())&&checkedWebElementDisplayed(invoiceListingPage.getNetAmtColumnViewModal())&&checkedWebElementDisplayed(invoiceListingPage.getCpnValColumnViewModal())
				&&checkedWebElementDisplayed(invoiceListingPage.getCouponBasisColumnViewModal())&&checkedWebElementDisplayed(invoiceListingPage.getAmtPayColumnViewModal()));
	}
	//checking the treatment table in view modal
	public static void itemDetails_CorrectionDetails(){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(invoiceListingPage.getHeaderViewModal());
		boolean headerView_flag = checkedWebElementDisplayed(invoiceListingPage.getHeaderViewModal());
		boolean invoiceNum_flag = !(invoiceListingPage.getInvoiceNoViewModal().getText().contains("NA") || invoiceListingPage.getInvoiceNoViewModal().getText().contains("null"));
		boolean invoiceDate_flag = !(invoiceListingPage.getInvoiceDateViewModal().getText().contains("NA") || invoiceListingPage.getInvoiceDateViewModal().getText().contains("null"));
		if(headerView_flag&&invoiceNum_flag&&invoiceDate_flag) {
			for (WebElement row : invoiceListingPage.getItemDetailTreatmentViewModal()) {
				//getting total cell count
				List<WebElement> cells = row.findElements(By.tagName("td"));
				//fetching the treatment name from the view modal of the invoice
				String treatment = cells.get(0).getText();
				//fetching the unit cost from the view modal of the invoice
				String[] unitCost = cells.get(1).getText().split("\\.");
				//fetching the source from the view modal of the invoice
				String source = cells.get(3).getText();
				//fetching the net amount from the view modal of the invoice
				String[] netAmount = cells.get(4).getText().split("\\.");
				//fetching the coupon amount from the view modal of the invoice
				String[] couponAmount = cells.get(5).findElement(By.xpath("span[@class='ng-binding']")).getText().split("\\.");
				//fetching coupon basis
				String couponBasis = cells.get(7).findElement(By.xpath("span[@class='ng-binding']")).getText();
				//fetching the amount payable from the view modal of the invoice
				String[] amountPayable = cells.get(8).findElement(By.xpath("span[@class='ng-binding']")).getText().split("\\.");
				long unit_Cost = 0, net_Amount = 0, coupon_Amount = 0, amount_Payable = 0;
				try {
					unit_Cost = NumberFormat.getNumberInstance(Locale.US).parse(unitCost[0]).intValue();
					net_Amount = NumberFormat.getNumberInstance(Locale.US).parse(netAmount[0]).intValue();
					coupon_Amount = NumberFormat.getNumberInstance(Locale.US).parse(couponAmount[0]).intValue();
					amount_Payable = NumberFormat.getNumberInstance(Locale.US).parse(amountPayable[0]).intValue();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				//validating treatment should not be NA or null
				boolean flag1 = !(treatment.contains("NA") || treatment.contains("null"));
				//unit cost can not 0 and null
				boolean flag2 = !(unit_Cost == 0);
				//checking source
				boolean flag3 = !(source.contains("NA") || source.contains("null"));
				//checking net Amount
				boolean flag4 = (net_Amount == (coupon_Amount + amount_Payable));
				//checking coupon amount
				boolean flag5 = (coupon_Amount == (net_Amount - amount_Payable));
				//checking the amount payable
				boolean flag6 = (amount_Payable == (net_Amount - coupon_Amount));
				//checking treatment in invoices not deleted or no coupon Applied
				if ((!row.getAttribute("class").contains("deleted")) && couponBasis.contains("No Remarks")) {
					//checking coupon basis
					boolean flag7 = couponBasis.contains("No Remarks");
					Assert.assertTrue(flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag7);
				} else if (row.getAttribute("class").contains("deleted")) {
					//checking coupon basis
					boolean flag7 = !(couponBasis.contains("NA") || couponBasis.contains("null"));
					//checking the treatment details in the item details
					if (flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag7) {
						//checking the correction header after correction note entry
						boolean headerDisplayed = checkedWebElementDisplayed(invoiceListingPage.getHeaderCorrectionDetails());
						//iterating correction entry on the basis of the treatment
						for (WebElement correctionRow : invoiceListingPage.getRowCorrectionDetailsTreatment()) {
							long treatment_Deleted_Amount = 0, amount_Payable_deletion_all = 0;
							List<WebElement> correctionCells = correctionRow.findElements(By.tagName("td"));
							String treatmentName = correctionCells.get(0).getText();
							String negativeUnitCostDeletion = correctionCells.get(1).getText().split(" ")[0];
							//checking same treatment deleted in items details in the correction details
							if (treatment.equalsIgnoreCase(treatmentName)&&negativeUnitCostDeletion.contains("-")) {
								//checking the negative sign before the unit cost and unit cost price
								String UnitCostDeletion = correctionCells.get(1).getText().split(" ")[1].split("\\.")[0];
								//checking the source from deletion
								String sourceDeletion = correctionCells.get(2).getText();
								//checking the negative sign before the net Amount and net Amount price
								String negativeNetAmount = correctionCells.get(4).getText().split(" ")[0];
								String netAmountDeletion = correctionCells.get(4).getText().split(" ")[1].split("\\.")[0];
								//checking the negative sign before the coupon amount and coupon amount price
								String[] negativeCouponAmount = correctionCells.get(6).getText().split("-");
								String couponAmountDeletion = negativeCouponAmount[1].split("\\.")[0];
								//checking coupon basis on the deletion notes
								String couponBasisDeletion = correctionCells.get(8).getText();
								//checking the negative sign before the amount payable and amount payable price
								System.out.println(correctionCells.get(10).getText()+" payable amount");
								String negativeAmountPayable = correctionCells.get(10).getText().split(" ")[0];
								String amountPayableDeletion = correctionCells.get(10).getText().split(" ")[1].split("\\.")[0];
								//checking correction invoice number
								String correctionInvoiceNumber = driver.findElement(By.xpath("//td[contains(text(),'" + treatmentName + "')]/ancestor::div[@class='brdr_drk_gry whtBox nogap table-responsive']/preceding-sibling::div//b[text()='Correction Invoice No.']/../following-sibling::span")).getText();
								//checking correction invoice created date
								String correctionInvoiceDate = driver.findElement(By.xpath("//td[contains(text(),'" + treatmentName + "')]/ancestor::div[@class='brdr_drk_gry whtBox nogap table-responsive']/preceding-sibling::div//b[text()='Correction Invoice Date']/../following-sibling::span")).getText();
								//checking correction action
								String correctionAction = driver.findElement(By.xpath("//td[contains(text(),'" + treatmentName + "')]/ancestor::div[@class='brdr_drk_gry whtBox nogap table-responsive']/preceding-sibling::div//b[text()='Correction Action']/../following-sibling::span")).getText();
								//checking deletion reason
								String deletionReason = driver.findElement(By.xpath("//td[contains(text(),'" + treatmentName + "')]/ancestor::div[@class='brdr_drk_gry whtBox nogap table-responsive']/preceding-sibling::div//b[text()='Deletion Reason']/../following-sibling::span")).getText();
								//treatment deleted price
								String treatmentDeletedAmount = driver.findElement(By.xpath("//td[contains(text(),'" + treatmentName + "')]/../../following-sibling::tfoot//strong[text()='Treatment Deleted for Amount:']/../following-sibling::td")).getText().split(" ")[1];
								long unit_Cost_deletion = 0, net_Amount_deletion = 0, coupon_Amount_deletion = 0, amount_Payable_deletion = 0;
								try {
									unit_Cost_deletion = NumberFormat.getNumberInstance(Locale.US).parse(UnitCostDeletion).intValue();
									net_Amount_deletion = NumberFormat.getNumberInstance(Locale.US).parse(netAmountDeletion).intValue();
									coupon_Amount_deletion = NumberFormat.getNumberInstance(Locale.US).parse(couponAmountDeletion).intValue();
									amount_Payable_deletion = NumberFormat.getNumberInstance(Locale.US).parse(amountPayableDeletion).intValue();
									treatment_Deleted_Amount = NumberFormat.getNumberInstance(Locale.US).parse(treatmentDeletedAmount).intValue();
								} catch (ParseException e) {
									e.printStackTrace();
								}
								amount_Payable_deletion_all = amount_Payable_deletion_all + amount_Payable_deletion;
								boolean correctionInvoice_flag = !(correctionInvoiceNumber.contains("NA") || correctionInvoiceNumber.contains("null"));
								boolean correctionDate_flag = !(correctionInvoiceDate.contains("NA") || correctionInvoiceDate.contains("null"));
								boolean correctionAction_flag = !(correctionAction.contains("NA") || correctionAction.contains("null"));
								boolean correctionReason_flag = !(deletionReason.contains("NA") || deletionReason.contains("null"));
								boolean unit_cost_flag = negativeUnitCostDeletion.contains("-") && !(unit_Cost_deletion == 0);
								boolean source_flag = !(sourceDeletion.contains("NA") || sourceDeletion.contains("null"));
								boolean net_Amount_flag = negativeNetAmount.contains("-") && (net_Amount_deletion == (coupon_Amount_deletion + amount_Payable_deletion));
								boolean coupon_Amount_flag = (coupon_Amount_deletion == (net_Amount_deletion - amount_Payable_deletion));
								boolean coupon_basis_flag = !(couponBasisDeletion.contains("NA") || couponBasisDeletion.contains("null"));
								boolean amount_Payable_flag = negativeAmountPayable.contains("-") && (amount_Payable_deletion == (net_Amount_deletion - coupon_Amount_deletion));
								Assert.assertTrue(correctionInvoice_flag && correctionDate_flag && correctionAction_flag && correctionReason_flag && unit_cost_flag && source_flag && net_Amount_flag && coupon_Amount_flag && coupon_basis_flag && amount_Payable_flag);
							} else {
								continue;
							}
							Assert.assertEquals(treatment_Deleted_Amount, amount_Payable_deletion_all);
						}
					}
				} else {
					boolean flag7 = !couponBasis.contains("No Remarks");
					//checking the treatment details in the item details
					if (flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag7) {
						//checking the correction header after correction note entry
						boolean headerDisplayed = checkedWebElementDisplayed(invoiceListingPage.getHeaderCorrectionDetails());
						//iterating correction entry on the basis of the treatment
						for (WebElement correctionRow : invoiceListingPage.getRowCorrectionDetailsTreatment()) {
							List<WebElement> correctionCells = correctionRow.findElements(By.tagName("td"));
							String treatmentName = correctionCells.get(0).getText();
							//checking same treatment deleted in items details in the correction details
							if (treatment.equalsIgnoreCase(treatmentName)) {
								//checking the negative sign before the unit cost and unit cost price
								String UnitCostCouponAdjust = correctionCells.get(1).getText().split("\\.")[0];
								//checking the source from coupon adjusted
								String sourceCouponAdjust = correctionCells.get(3).getText();
								//checking the net Amount price
								String netAmountCouponAdjust = correctionCells.get(4).getText().split("\\.")[0];
								//checking the coupon amount price
								String couponAmountCouponAdjust = correctionCells.get(5).getText().split("\\r?\\n")[0];
								String couponAmountPrevious = correctionCells.get(5).getText().split("\\r?\\n")[1];
								//checking coupon basis
								String couponBasisText = correctionCells.get(8).getText();
								//checking the  amount payable price
								String amountPayableDeletion = correctionCells.get(9).getText().split("\\r?\\n")[0];
								String amountPayablePrevious = correctionCells.get(9).getText().split("\\r?\\n")[1];
								//checking correction invoice number
								String correctionInvoiceNumber = driver.findElement(By.xpath("//td[contains(text(),'" + treatmentName + "')]/ancestor::div[@class='brdr_drk_gry whtBox nogap table-responsive']/preceding-sibling::div//b[text()='Correction Invoice No.']/../following-sibling::span")).getText();
								//checking correction invoice created date
								String correctionInvoiceDate = driver.findElement(By.xpath("//td[contains(text(),'" + treatmentName + "')]/ancestor::div[@class='brdr_drk_gry whtBox nogap table-responsive']/preceding-sibling::div//b[text()='Correction Invoice Date']/../following-sibling::span")).getText();
								//checking correction action
								String correctionAction = driver.findElement(By.xpath("//td[contains(text(),'" + treatmentName + "')]/ancestor::div[@class='brdr_drk_gry whtBox nogap table-responsive']/preceding-sibling::div//b[text()='Correction Action']/../following-sibling::span")).getText();
								//coupon adjustment notes
								List<WebElement> couponAdjustmentNotes = driver.findElements(By.xpath("//td[contains(text(),'" + treatmentName + "')]/ancestor::div[@class='brdr_drk_gry whtBox nogap table-responsive']/preceding-sibling::div//b[text()='Coupon Adjustment Notes']/following-sibling::span"));
								//treatment deleted price
								String amountPayableDecreased = driver.findElement(By.xpath("//td[contains(text(),'" + treatmentName + "')]/../../following-sibling::tfoot//strong[text()='Amount Payable Decreased By:']/../following-sibling::td")).getText().split("\\.")[0];
								long unit_Cost_deletion = 0, net_Amount_deletion = 0, coupon_Amount_deletion = 0, amount_Payable_deletion = 0, treatment_Deleted_Amount = 0;
								try {
									unit_Cost_deletion = NumberFormat.getNumberInstance(Locale.US).parse(UnitCostCouponAdjust).intValue();
									net_Amount_deletion = NumberFormat.getNumberInstance(Locale.US).parse(netAmountCouponAdjust).intValue();
									coupon_Amount_deletion = NumberFormat.getNumberInstance(Locale.US).parse(couponAmountCouponAdjust).intValue();
									amount_Payable_deletion = NumberFormat.getNumberInstance(Locale.US).parse(amountPayableDeletion).intValue();
									treatment_Deleted_Amount = NumberFormat.getNumberInstance(Locale.US).parse(amountPayableDeletion).intValue();
								} catch (ParseException e) {
									e.printStackTrace();
								}
								boolean correctionInvoice_flag = !(correctionInvoiceNumber.contains("NA") || correctionInvoiceNumber.contains("null"));
								boolean correctionDate_flag = !(correctionInvoiceDate.contains("NA") || correctionInvoiceDate.contains("null"));
								boolean correctionAction_flag = !(correctionAction.contains("NA") || correctionAction.contains("null"));
								boolean couponAdjustmentNotes_flag = false;
								if (couponAdjustmentNotes.size() > 0) {
									for (int i = 0; couponAdjustmentNotes.size() > i; i++) {
										couponAdjustmentNotes_flag = !(couponAdjustmentNotes.get(i).getText().contains("NA") || couponAdjustmentNotes.get(i).getText().contains("null"));
									}
								} else {
									couponAdjustmentNotes_flag = true;
								}
								boolean unit_cost_flag = !(unit_Cost_deletion == 0);
								boolean source_flag = !(sourceCouponAdjust.contains("NA") || sourceCouponAdjust.contains("null"));
								boolean net_Amount_flag = (net_Amount_deletion == (coupon_Amount_deletion + amount_Payable_deletion));
								boolean coupon_Amount_flag = !(couponAmountPrevious.contains("NA") || couponAmountPrevious.contains("null")) && (coupon_Amount_deletion == (net_Amount_deletion - amount_Payable_deletion));
								boolean coupon_basis_flag = !(couponBasisText.contains("No Remarks") || couponBasisText.contains("null") || couponBasisText.contains("NA"));
								boolean amount_Payable_flag = !(amountPayablePrevious.contains("NA") || amountPayablePrevious.contains("null")) && (amount_Payable_deletion == (net_Amount_deletion - coupon_Amount_deletion));
								boolean treatment_Deleted_Amount_flag = !(treatment_Deleted_Amount == 0);
								Assert.assertTrue(correctionInvoice_flag && correctionDate_flag && correctionAction_flag && couponAdjustmentNotes_flag && unit_cost_flag && source_flag && net_Amount_flag && coupon_Amount_flag && coupon_basis_flag && amount_Payable_flag && treatment_Deleted_Amount_flag);
							} else {
								continue;
							}
						}
					}
				}
			}
		}else {
			Assert.fail();
		}
	}
	//checking notes fields at invoice view

	public static void noteBehaviorViewModal(){
		if(invoiceListingPage.getNotesRow().size()==0){
			boolean flag1=invoiceListingPage.getNoteHeader().get(0).getText().contains("Notes")&&checkedWebElementDisplayed(invoiceListingPage.getNoteTextFields())&&checkedWebElementDisplayed(invoiceListingPage.getMaxCharMsg())&&invoiceListingPage.getNoteTextFields().getAttribute("placeholder").contains("enter invoice notes");
			Assert.assertTrue(flag1);
			invoiceListingPage.getSaveBtnViewModal().click();
			Assert.assertTrue(flag1&&checkedWebElementDisplayed(invoiceListingPage.getErrorNoteMsg()));
		}else if(invoiceListingPage.getNoteHeader_entered().size()==1){
			boolean flag1=invoiceListingPage.getNoteHeader_entered().get(0).getText().contains("Notes and Notes History")&&checkedWebElementDisplayed(invoiceListingPage.getNoteTextFields())&&checkedWebElementDisplayed(invoiceListingPage.getMaxCharMsg())&&invoiceListingPage.getNoteTextFields().getAttribute("placeholder").contains("enter invoice notes");
			for (WebElement web:invoiceListingPage.getNotesRow()) {
				List<WebElement> cells = web.findElements(By.tagName("td"));
				String noteCreatedDate = cells.get(0).getText();
				String noteCreatedBy = cells.get(1).getText();
				String notesNotes = cells.get(2).getText();
				boolean notesColumn_flag=checkedWebElementDisplayed(invoiceListingPage.getNotesDateColumn())&&checkedWebElementDisplayed(invoiceListingPage.getNotesCreatedByColumn())&&checkedWebElementDisplayed(invoiceListingPage.getNotesNotesColumn());
				boolean noteCreatedDate_flag =!(noteCreatedDate.contains("NA") || noteCreatedDate.contains("null"));
				boolean noteCreatedBy_flag = !(noteCreatedBy.contains("NA") || noteCreatedBy.contains("null"));
				boolean notesNotes_flag = !(notesNotes.contains("NA") || notesNotes.contains("null"));
				Assert.assertTrue(flag1&&notesColumn_flag&&noteCreatedDate_flag&&noteCreatedBy_flag&&notesNotes_flag);
			}
		}else{
			Assert.fail();
		}
	}
	//function for coupon modal
	public static void checkPatientNameCouponModal(String patientName){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(invoiceListingPage.getPatientNameCoupon());
		String[] split=invoiceListingPage.getPatientNameCoupon().getText().split(":");
		Assert.assertTrue(split[0].contains(patientName)&&!(split[1].contains("NA")||split[1].contains("null")));
	}
	//open the coupon modal
	public static void openCouponModal(String invoiceCreatedDate){
		    BaseClass.waitForSpinnerToDisappear();
		    BaseClass.waitForElementVisibility(invoiceListingPage.getCupn(),4000);
			WebElement web = driver.findElement(By.xpath("//td[contains(text(),'" + invoiceCreatedDate + "')]/following-sibling::td/a[contains(@data-ng-click,'couponView')]"));
			BaseClass.waitForElementVisibility(web,4000);
			BaseClass.waitForElementToBeClickable(web);
			BaseClass.waitForModalOverlayToDisappear();
			web.click();
			BaseClass.waitForSpinnerToDisappear();
	}

//	public static void openCouponModal(String invoiceCreatedDate){
//		BaseClass.waitForPageLoad();
//		try {
//			WebElement web = driver.findElement(By.xpath("//td[contains(text(),'" + invoiceCreatedDate + "')]/following-sibling::td/a[contains(@data-ng-click,'couponView')]"));
//			BaseClass.waitForElementToBeClickable(web);
//			web.click();
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
	//open delete modal
public static void openDeleteModal(String invoiceCreatedDate){
	BaseClass.waitForSpinnerToDisappear();
    BaseClass.waitForElementVisibility(invoiceListingPage.getCollectPaymentBtn(),4000);
	BaseClass.waitForElementVisibility(invoiceListingPage.getDeleteBtn(),4000);
	WebElement web = driver.findElement(By.xpath("//td[contains(text(),'"+invoiceCreatedDate+"')]/following-sibling::td/a[contains(@data-ng-click,'deleteInvoice')]/span[@class='actn-icn delete']"));
	BaseClass.waitForElementVisibility(web,4000);
	BaseClass.waitForModalOverlayToDisappear();
	BaseClass.waitForElementToBeClickable(web);
	web.click();

}

//	public static void openDeleteModal(String invoiceCreatedDate){
//		BaseClass.waitForSpinnerToDisappear();
//		BaseClass.waitForElementVisibility(invoiceListingPage.getCollectPaymentBtn(),4000);
//		try {
//			WebElement web = driver.findElement(By.xpath("//td[contains(text(),'" + invoiceCreatedDate + "')]/following-sibling::td/a[contains(@data-ng-click,'deleteInvoice')]"));
//			BaseClass.waitForElementToBeClickable(web);
//			web.click();
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
	//close the coupon modal
	public static void closeModal(){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(invoiceListingPage.getCloseBtnBtn());
		try {
			invoiceListingPage.getCloseBtnBtn().click();
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
//	public static void closeModal(){
//		BaseClass.waitForPageLoad();
//		BaseClass.waitForElementToBeClickable(invoiceListingPage.getCloseBtnBtn());
//		try {
//			invoiceListingPage.getCloseBtnBtn().click();
//			Thread.sleep(1500);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}

	//header of coupon popup
	public static void headerCouponPopup(){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(invoiceListingPage.getHeaderCouponModal());
		Assert.assertTrue(checkedWebElementDisplayed(invoiceListingPage.getHeaderCouponModal())&&checkedWebElementDisplayed(invoiceListingPage.getHeaderInfo()));
	}
	//invoice Number at coupon popup
	public static void invoiceNumberInvoiceDate(String invoiceCreatedDate){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(invoiceListingPage.getInvoiceDateCouponModal());
		System.out.println("This is a Message"+invoiceListingPage.getInvoiceDateCouponModal().getText());
		Assert.assertTrue(invoiceListingPage.getInvoiceDateCouponModal().getText().contains(invoiceCreatedDate)&&!(invoiceListingPage.getInvoiceNoCouponModal().getText().contains("NA")||invoiceListingPage.getInvoiceNoCouponModal().getText().contains("null")));

	}

	//total amount due in coupon modal
	public static void totalDueCouponModal(){
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(invoiceListingPage.getRemainingAmountDueCouponModal(),4000);
		try {
			long amountDueCouponModal = NumberFormat.getNumberInstance(Locale.US).parse(invoiceListingPage.getRemainingAmountDueCouponModal().getText()).intValue();
			Assert.assertEquals(amountDueCouponModal,amountPayableCouponTabular());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

//	public static void totalDueCouponModal(){
//		BaseClass.waitForPageLoad();
//		BaseClass.waitForElementToBeClickable(invoiceListingPage.getRemainingAmountDueCouponModal());
//		try {
//			long amountDueCouponModal = NumberFormat.getNumberInstance(Locale.US).parse(invoiceListingPage.getRemainingAmountDueCouponModal().getText()).intValue();
//			Assert.assertEquals(amountDueCouponModal,amountPayableCouponTabular());
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//	}

	//amount payable in coupon modal
	public static long amountPayableCouponTabular(){
		BaseClass.waitForPageLoad();
		long amountPayCouponModal = 0,amountPayCouponModal1=0;
		// And iterate over them, getting the cells
		BaseClass.visibilityOfListLocated(invoiceListingPage.getRowTreatmentColumn());
		for (WebElement row : invoiceListingPage.getRowTreatmentColumn()) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			String str = cells.get(6).getText().trim();
			String[] str1 = str.split("\\.");
			try {
				amountPayCouponModal = NumberFormat.getNumberInstance(Locale.US).parse(str1[0]).intValue();
				amountPayCouponModal1=amountPayCouponModal1+amountPayCouponModal;
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return amountPayCouponModal1;
	}
	//treatment name and it all prices at coupon modal
	public static void treatmentTable(String coupon,long amount){
		//checking the column name at coupon popup
		boolean flag = checkedWebElementDisplayed(invoiceListingPage.getTreatmentCouponModal()) && checkedWebElementDisplayed(invoiceListingPage.getTreatmentCouponColumn()) && checkedWebElementDisplayed(invoiceListingPage.getUnitCostCouponColumn()) && checkedWebElementDisplayed(invoiceListingPage.getNetAmountCouponColumn())
				&& checkedWebElementDisplayed(invoiceListingPage.getTypeCouponColumn()) && checkedWebElementDisplayed(invoiceListingPage.getCpnValCouponColumn()) && checkedWebElementDisplayed(invoiceListingPage.getAmtPayCouponColumn()) && checkedWebElementDisplayed(invoiceListingPage.getCouponBasisCouponColumn());
		if(flag){
			//iterating the row at coupon popup
			BaseClass.visibilityOfListLocated(invoiceListingPage.getRowTreatmentColumn());
			for (WebElement row:invoiceListingPage.getRowTreatmentColumn()) {
				List<WebElement> cells = row.findElements(By.tagName("td"));
				int count = cells.size();
				//fetching source name from the table
				String source = cells.get(0).getText();
				//fetching treatment name from the table
				String treatmentName = cells.get(1).getText();
				//fetching unit cost from the table
				String[] unitCost = cells.get(2).getText().split("\\.");
				//fetching net amount from the table
				String[] netAmount = cells.get(3).getText().split("\\.");
				//fetching previous coupon discount amount
				String[] prevDiscount = cells.get(5).getText().split("\\.");
				//selecting the coupon type amount or percentage
				WebElement couponType = driver.findElement(By.xpath("//td[@class='wrd-brk-wrd ng-binding'][normalize-space()='"+treatmentName+"']/following-sibling::td[@class='comboChangeTBView']/span/custom-combo/div/select"));
				BaseClass.selectFromDropDownByVisibleText(couponType,coupon);
				//entering the value in the text fileds
				WebElement couponValue=driver.findElement(By.xpath("(//td[@class='wrd-brk-wrd ng-binding'][normalize-space()='"+treatmentName+"']/following-sibling::td//span[@class='pull-left cpn_amt_adjust_alignment ng-scope']/input)[1]"));
				couponValue.clear();
				couponValue.sendKeys(Long.toString(amount));
				//fetching the amount payable from the table after applying the discount
				String[] amountPayable = cells.get(6).getText().split("\\.");
//				//selecting coupon type discount popup
//				WebElement couponBasis=driver.findElement(By.xpath("//td[contains(text(),'"+treatmentName+"')]/following-sibling::td//select[@id='basis']"));
//				BaseClass.selectFromDropDownByIndex(couponBasis,2);
				long unitCostCoupon=0,netAmountCoupon=0,amountPayableCoupon=0,previousCouponDiscount=0;
				try {
					unitCostCoupon = NumberFormat.getNumberInstance(Locale.US).parse(unitCost[0]).intValue();
					netAmountCoupon=NumberFormat.getNumberInstance(Locale.US).parse(netAmount[0]).intValue();
					amountPayableCoupon=NumberFormat.getNumberInstance(Locale.US).parse(amountPayable[0]).intValue();
					previousCouponDiscount=NumberFormat.getNumberInstance(Locale.US).parse(prevDiscount[0]).intValue();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				//calculating effective amount after appling the coupon
				if(coupon.equalsIgnoreCase("%")) {
					long amount_Pay = (netAmountCoupon * amount) / 100;
					Assert.assertEquals((netAmountCoupon-amount_Pay),amountPayableCoupon);
				}else if(coupon.equalsIgnoreCase("Amt")){
					Assert.assertEquals((netAmountCoupon-amount),amountPayableCoupon);
				}else {
					Assert.assertEquals((netAmountCoupon-(amount+previousCouponDiscount)),amountPayableCoupon);
//					Assert.fail();
				}
				//validating source and unit cost
				boolean flag1=!(unitCostCoupon==0);
				boolean flag2=!(source.contains("NA")||source.contains("null"));
				Assert.assertTrue(flag1&&flag2);
			}
		}else {
			Assert.fail();
		}
	}
	//treatment name and it all prices at coupon modal
	public static void treatmentTableAfterCouponApplied(String coupon,long amount){
		//checking the column name at coupon popup
		boolean flag = checkedWebElementDisplayed(invoiceListingPage.getTreatmentCouponModal()) && checkedWebElementDisplayed(invoiceListingPage.getSourceCouponColumn()) && checkedWebElementDisplayed(invoiceListingPage.getTreatmentCouponColumn()) && checkedWebElementDisplayed(invoiceListingPage.getUnitCostCouponColumn()) && checkedWebElementDisplayed(invoiceListingPage.getNetAmountCouponColumn())
				&& checkedWebElementDisplayed(invoiceListingPage.getTypeCouponColumn()) && checkedWebElementDisplayed(invoiceListingPage.getCpnValCouponColumn()) && checkedWebElementDisplayed(invoiceListingPage.getAmtPayCouponColumn()) && checkedWebElementDisplayed(invoiceListingPage.getCouponBasisCouponColumn());
		if(flag){
			//iterating the row at coupon popup
			BaseClass.visibilityOfListLocated(invoiceListingPage.getRowTreatmentColumn());
			for (WebElement row:invoiceListingPage.getRowTreatmentColumn()) {
				List<WebElement> cells = row.findElements(By.tagName("td"));
				//fetching source name from the table
				String source = cells.get(0).getText();
				//fetching treatment name from the table
				String treatmentName = cells.get(1).getText();
				//fetching unit cost from the table
				String[] unitCost = cells.get(2).getText().split("\\.");
				//fetching net amount from the table
				String[] netAmount = cells.get(3).getText().split("\\.");
				//selecting the coupon type amount or percentage
				WebElement couponType = driver.findElement(By.xpath("//td[contains(text(),'"+treatmentName+"')]/following-sibling::td//select[@id='Type']"));
				BaseClass.selectFromDropDownByVisibleText(couponType,coupon);
				//entering the value in the text fileds
				WebElement couponValue=driver.findElement(By.xpath("//td[contains(text(),'"+treatmentName+"')]/following-sibling::td//input[contains(@ng-change,'calculateAmountPayPerTreatmen')]"));
				//fetching the amount payable from the table after applying the discount
				String[] amountPayable = cells.get(6).getText().split("\\.");
				//selecting coupon type discount popup
				WebElement couponBasis=driver.findElement(By.xpath("//td[contains(text(),'"+treatmentName+"')]/following-sibling::td//select[@id='basis']"));
				BaseClass.selectFromDropDownByIndex(couponBasis,2);
				long unitCostCoupon=0,netAmountCoupon=0,amountPayableCoupon=0;
				try {
					unitCostCoupon = NumberFormat.getNumberInstance(Locale.US).parse(unitCost[0]).intValue();
					netAmountCoupon=NumberFormat.getNumberInstance(Locale.US).parse(netAmount[0]).intValue();
					amountPayableCoupon=NumberFormat.getNumberInstance(Locale.US).parse(amountPayable[0]).intValue();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				//calculating effective amount after appling the coupon
				if(coupon.equalsIgnoreCase("%")) {
					long amount_Pay = (netAmountCoupon * amount) / 100;
					Assert.assertEquals((netAmountCoupon-amount_Pay),amountPayableCoupon);
				}else if(coupon.equalsIgnoreCase("Amt")){
					Assert.assertEquals((netAmountCoupon-amount),amountPayableCoupon);
				}else {
					Assert.fail();
				}
				//validating source and unit cost
				boolean flag1=!(unitCostCoupon==0);
				boolean flag2=!(source.contains("NA")||source.contains("null"));
				Assert.assertTrue(flag1&&flag2);
			}
		}else {
			Assert.fail();
		}
	}
	//save the coupon modal details
	public static void saveModalDetails(){
		BaseClass.waitForElementVisibility(invoiceListingPage.getSaveBtnModal(),4000);
		BaseClass.waitForElementToBeClickable(invoiceListingPage.getSaveBtnModal());
		invoiceListingPage.getSaveBtnModal().click();
		 try{
			 Thread.sleep(3000);
		 } catch (InterruptedException e) {
			 throw new RuntimeException(e);
		 }
	}
//	public static void saveModalDetails(){
//		BaseClass.waitForPageLoad();
//		BaseClass.waitForElementToBeClickable(invoiceListingPage.getSaveBtnModal());
//		try {
//			invoiceListingPage.getSaveBtnModal().click();
//			Thread.sleep(1500);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
	//validating the message we tap on save button without changing any data
public static void withoutChangeCouponMsg(){
	BaseClass.waitForElementVisibility(invoiceListingPage.getMsgWithoutChanges(),4000);
	Assert.assertTrue(checkedWebElementDisplayed(invoiceListingPage.getMsgWithoutChanges()));
	BaseClass.waitTillInvisiblityOfElement(invoiceListingPage.getMsgWithoutChanges());
}

//	public static void withoutChangeCouponMsg(){
//		BaseClass.waitForPageLoad();
//		try {
//			Thread.sleep(1000);
//			Assert.assertTrue(checkedWebElementDisplayed(invoiceListingPage.getMsgWithoutChanges()));
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
	//validating the message we tap on save button without changing any data
public static void updateCouponValueCouponBasAddCouponAdjustmentNotes(){
		Assert.assertTrue(checkedWebElementDisplayed(invoiceListingPage.getUpdateCouponValueCouponBasAddCouponAdjustmentNotes()));
}
//	public static void updateCouponValueCouponBasAddCouponAdjustmentNotes(){
//		BaseClass.waitForPageLoad();
//		try {
//			Thread.sleep(1000);
//			Assert.assertTrue(checkedWebElementDisplayed(invoiceListingPage.getUpdateCouponValueCouponBasAddCouponAdjustmentNotes()));
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
	//checking mandatory web element coupon adjustment notes and entering the notes
	public static void couponAdjustmentNotes(String adjustment_notes){
		BaseClass.waitForPageLoad();
		if(checkedWebElementDisplayed(invoiceListingPage.getCouponAdjustmentNotes())&&checkedWebElementDisplayed(invoiceListingPage.getCouponNoteTextFields())&&checkedWebElementDisplayed(invoiceListingPage.getCouponNoteTextFields())&&invoiceListingPage.getCouponNoteTextFields().getAttribute("placeholder").contains("enter notes")){
			invoiceListingPage.getCouponNoteTextFields().sendKeys(adjustment_notes);
		}else {
			Assert.fail();
		}
	}
	//function for coupon modal
	public static void checkPatientNameDeleteModal(String patientName){
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementToBeClickable(invoiceListingPage.getPatientNameDelete());
		String[] split=invoiceListingPage.getPatientNameDelete().getText().split(":");
		Assert.assertTrue(split[0].contains(patientName)&&!(split[1].contains("NA")||split[1].contains("null")));
	}
	public static void checkHeaderDeleteModal(){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(invoiceListingPage.getHeaderDelete());
		Assert.assertTrue(checkedWebElementDisplayed(invoiceListingPage.getHeaderDelete())&&checkedWebElementDisplayed(invoiceListingPage.getHeaderInfoDeleteModal()));
	}
	//amount payable in Delete modal
	public static long amountDueDeleteTabular(){
		BaseClass.waitForPageLoad();
		long amountPayCouponModal = 0,amountPayCouponModal1=0;
		// And iterate over them, getting the cells
		BaseClass.visibilityOfListLocated(invoiceListingPage.getRowDeleteModal());
		for (WebElement row : invoiceListingPage.getRowDeleteModal()) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			String str = cells.get(7).getText().trim();
			String[] str1 = str.split("\\.");
			try {
				amountPayCouponModal = NumberFormat.getNumberInstance(Locale.US).parse(str1[0]).intValue();
				amountPayCouponModal1=amountPayCouponModal1+amountPayCouponModal;
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return amountPayCouponModal1;
	}
	//total amount due in coupon modal
	public static void totalDueDeleteModal(){
		BaseClass.waitForPageLoad();
		try {
			long amountDueCouponModal = NumberFormat.getNumberInstance(Locale.US).parse(invoiceListingPage.getTotalDueInvoiceDeleteModal().getText()).intValue();
			Assert.assertEquals(amountDueCouponModal,amountDueDeleteTabular());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/*Checking invoices delete reason dropdown at invoice delete modal*/
	public static void invoiceDeleteReason(String defaultInvoiceStatusSelected) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(invoiceListingPage.getReasonDrpDwnHeader());
		if(checkedWebElementDisplayed(invoiceListingPage.getReasonDrpDwnHeader())&&checkedWebElementDisplayed(invoiceListingPage.getHeaderDeletionReason())) {
			boolean flag1, flag2, match = false;
			flag1 = checkedWebElementDisplayed(invoiceListingPage.getReasonDrpdwn()) && BaseClass.firstSelectedOption(invoiceListingPage.getReasonDrpdwn()).contains(defaultInvoiceStatusSelected);
			String[] exp = {"Select Reasons", "Change in treatment plan", "Incorrect treatment plan", "Invoice cancel", "Receipt delete reasons", "Others"};
			Select select = new Select(invoiceListingPage.getReasonDrpdwn());
			List<WebElement> options = select.getOptions();
			for (WebElement we : options) {
				for (int i = 0; i < exp.length; i++) {
					if (flag2 = we.getText().equals(exp[i])) {
						match = flag1 && flag2;
					}
				}
				Assert.assertTrue(match);
			}
		}else{
			Assert.fail();
		}
	}
	//selecting treatment in delete modal for delete
	public static void selectTreatment(String treatment){
		BaseClass.waitForElementToBeClickable(invoiceListingPage.getInvoiceDeleteCheckbox());
		boolean flag=checkedWebElementDisplayed(invoiceListingPage.getInvoiceDeleteCheckbox())&&checkedWebElementDisplayed(invoiceListingPage.getNameColumnDeleteModal())&&checkedWebElementDisplayed(invoiceListingPage.getUnitCostColumnDeleteModal())&&checkedWebElementDisplayed(invoiceListingPage.getSourceColumnDeleteModal())&&checkedWebElementDisplayed(invoiceListingPage.getNetAmountColumnDeleteModal())&&checkedWebElementDisplayed(invoiceListingPage.getCpnAmountColumnDeleteModal())&&checkedWebElementDisplayed(invoiceListingPage.getCpnBasisColumnDeleteModal())&&checkedWebElementDisplayed(invoiceListingPage.getAmountPayColumnDeleteModal());
		//deleting the invoice
		if(treatment.equalsIgnoreCase("all")){
			if(flag){
				invoiceListingPage.getInvoiceDeleteCheckbox().click();
			}else {
				Assert.fail();
			}
		}else{
			//iterating the treatment row of delete modal
			for (WebElement row:invoiceListingPage.getRowDeleteModal()) {
				List<WebElement> cells = row.findElements(By.tagName("td"));
				//fetching the treatment name
				String treatmentName = cells.get(1).getText();
				//fetching the checkbox
				WebElement checkbox = driver.findElement(By.xpath("//td[normalize-space()=('Consultation with Chief Clinical Officer')]/..//label"));
				//fetching the unit cost
				String[] unitCost = cells.get(2).getText().split("\\.");
				//fetching the source number
				String source = cells.get(3).getText();
				//fetching the net amount
				String[] netAmount = cells.get(4).getText().split("\\.");
				//fetching the coupon amount
				String[] cpnAmount = cells.get(5).getText().split("\\.");
				//fetching the coupon basis text
				String couponBasis = cells.get(6).getText();
				//fetching the amount payable
				String[] amountPayable = cells.get(7).getText().split("\\.");
				long unit_Cost=0,net_Amount=0,cpn_Amount=0,amount_Payable=0;
				try {
					unit_Cost = NumberFormat.getNumberInstance(Locale.US).parse(unitCost[0]).intValue();
					net_Amount = NumberFormat.getNumberInstance(Locale.US).parse(netAmount[0]).intValue();
					cpn_Amount = NumberFormat.getNumberInstance(Locale.US).parse(cpnAmount[0]).intValue();
					amount_Payable = NumberFormat.getNumberInstance(Locale.US).parse(amountPayable[0]).intValue();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				boolean flag1=!(treatmentName.contains("NA")||treatmentName.contains("null"));
				boolean flag2=checkedWebElementDisplayed(checkbox);
				boolean flag3=!(source.contains("NA")||source.contains("null"));
				boolean flag4=!(unit_Cost==0);
				boolean flag5=(net_Amount==(cpn_Amount+amount_Payable));
				boolean flag6=(cpn_Amount==(net_Amount-amount_Payable));
				boolean flag7=(amount_Payable==(net_Amount-cpn_Amount));
				boolean flag8=!(couponBasis.contains("NA")||couponBasis.contains("null"));
				//selecting the treatment
				if(flag&&flag1&&flag2&&flag3&&flag4&&flag5&&flag6&&flag7&&flag8&&treatmentName.contains(treatment)){
					checkbox.click();
					break;
				}else {
					Assert.fail();
				}
			}
		}
	}

	//error if no reason is selected
	public static void errorNoReasonSelected(){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(invoiceListingPage.getReasonErrorMsg());
		Assert.assertTrue(checkedWebElementDisplayed(invoiceListingPage.getReasonErrorMsg()));
	}
	//error message if treatment
	public static void errorMsgTreatmentNotSelected(){
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(1000);
			Assert.assertTrue(checkedWebElementDisplayed(invoiceListingPage.getMsgTreatmentNotSelected()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//select reason for deleteing the treatment
	public static void selectDeleteReason(String reason){
		BaseClass.waitForPageLoad();
		BaseClass.selectFromDropDownByVisibleText(invoiceListingPage.getReasonDrpdwn(),reason);
	}

	//validating correction notes at invoice listing
	public static void correctionNotes(String invoiceCreatedDate,String correctionNotes){
		BaseClass.waitForPageLoad();
		WebElement web = driver.findElement(By.xpath("//td[contains(text(),'" + invoiceCreatedDate + "')]/following-sibling::td[contains(text(),'" + correctionNotes + "')]"));
		BaseClass.waitForElementToBeClickable(web);
		Assert.assertTrue(checkedWebElementDisplayed(web));
	}

	//validating invoice deleted and checked after selecting the show details button
	public static void invoiceDeleted(String invoiceCreatedDate){
		BaseClass.waitForPageLoad();
		WebElement web = driver.findElement(By.xpath("//td[contains(text(),'" + invoiceCreatedDate + "')]/following-sibling::td[contains(@class,'deleted')]"));
		BaseClass.waitForElementToBeClickable(web);
		Assert.assertTrue(checkedWebElementDisplayed(web));
	}

	//validated all cases after delete at invoice listing like coupon adjusted,treatment deleted,invoice deleted and both treatment deleted and invoice deleted
	public static void negativeInvoiceAfterDelete(String invoiceCreatedDate){
		BaseClass.waitForPageLoad();
		WebElement invoiceDelete = driver.findElement(By.xpath("//td[contains(text(),'" + invoiceCreatedDate + "')]/following-sibling::td[contains(text(),'Invoice Deleted')]"));
//		WebElement invoiceDeleteCouponAdjusted = driver.findElement(By.xpath("//td[contains(text(),'" + invoiceCreatedDate + "')]/following-sibling::td[contains(text(),'Both trt deleted and Cpn. value adjusted')]"));
		List<WebElement> couponAdjusted = driver.findElements(By.xpath("//td[contains(text(),'" + invoiceCreatedDate + "')]/following-sibling::td[contains(text(),'Cpn. value Adjusted')]"));
		WebElement treatmentDeleted = driver.findElement(By.xpath("//td[contains(text(),'" + invoiceCreatedDate + "')]/following-sibling::td[contains(text(),'Treatment Deleted')]"));
		Assert.assertTrue(checkedWebElementDisplayed(invoiceDelete)&&checkedWebElementDisplayed(treatmentDeleted));
	}
	private static boolean checkedWebElementDisplayed(WebElement webElement) {
		return (webElement.isDisplayed());
	}
}
