package pageActions.patientDashboard;


import base.BaseClass;
import pages.patientDashboard.NewReceiptPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.Random;


public class NewReceiptPageActions extends BaseClass {
	
	static NewReceiptPage newReceiptPage = PageFactory.initElements(driver, NewReceiptPage.class);

	
	/*-------Functions------------*/

	public static void headerOfPage(String Header) {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(newReceiptPage.getModeHead(),4000);
		BaseClass.WaitTillElementIsPresent(newReceiptPage.getHeaderNewReceipt());
			if(Header.equals("New Receipts"))
				Assert.assertTrue(newReceiptPage.getHeaderNewReceipt().getText().contains(Header));
			else if(Header.equals("Edit Receipts"))
				Assert.assertTrue(newReceiptPage.getHeaderEditReceipt().getText().trim().contains(Header));
			else
				Assert.assertTrue(newReceiptPage.getHeaderAdvanceNewReceipt().getText().contains(Header));
	}

//	public static void headerOfPage(String Header) {
//		BaseClass.waitForPageLoad();
//		BaseClass.WaitTillElementIsPresent(newReceiptPage.getHeaderNewReceipt());
//		try {
//			Thread.sleep(5000);
//			if(Header.equals("New Receipts"))
//				Assert.assertTrue(newReceiptPage.getHeaderNewReceipt().getText().contains(Header));
//			else if(Header.equals("Edit Receipts (Advance)"))
//				Assert.assertTrue(newReceiptPage.getHeaderEditReceipt().getText().contains(Header));
//			else
//				Assert.assertTrue(newReceiptPage.getHeaderAdvanceNewReceipt().getText().contains(Header));
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public static void checkActionBtnForAdvance() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedWebElementDisplayed(newReceiptPage.getSaveBtn())&&
				checkedWebElementDisplayed(newReceiptPage.getCancelBtn()) && checkedWebElementDisplayed(newReceiptPage.getDashboardBtn()));
	}

	public static void collectAdvancePayment(){
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(newReceiptPage.getCollectAdvanceBtn(),4000);
		BaseClass.waitForModalOverlayToDisappear();
		newReceiptPage.getCollectAdvanceBtn().click();
	}

	public static void checkModesAndTextFields() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedWebElementDisplayed(newReceiptPage.getModeHead()) && checkedWebElementDisplayed(newReceiptPage.getCashBtn())&& checkedWebElementDisplayed(newReceiptPage.getCardBtn())
				&& checkedWebElementDisplayed(newReceiptPage.getOthersBtn()) && checkedWebElementDisplayed(newReceiptPage.getWalletBtn())
				&& checkedWebElementDisplayed(newReceiptPage.getAmountHead()) && checkedWebElementDisplayed(newReceiptPage.getAmountTextField()) && newReceiptPage.getAmountTextField().getAttribute("placeholder").contains("» enter amount")
				&& checkedWebElementDisplayed(newReceiptPage.getNotesHead()) && checkedWebElementDisplayed(newReceiptPage.getNotesTextField())&& newReceiptPage.getNotesTextField().getAttribute("placeholder").contains("» notes")&& newReceiptPage.getNotesTextField().getAttribute("maxlength").contains("768"));
	}

//	public static void checkModesAndTextFields() {
//		BaseClass.waitForPageLoad();
//		Assert.assertTrue(checkedWebElementDisplayed(newReceiptPage.getModeHead()) && checkedWebElementDisplayed(newReceiptPage.getCashBtn())&& checkedWebElementDisplayed(newReceiptPage.getCardBtn())
//				&& checkedWebElementDisplayed(newReceiptPage.getChequeBtn()) && checkedWebElementDisplayed(newReceiptPage.getNetBankingBtn()) && checkedWebElementDisplayed(newReceiptPage.getWalletBtn())
//				&& checkedWebElementDisplayed(newReceiptPage.getAmountHead()) && checkedWebElementDisplayed(newReceiptPage.getAmountTextField()) && newReceiptPage.getAmountTextField().getAttribute("placeholder").contains("enter amount")
//				&& checkedWebElementDisplayed(newReceiptPage.getNotesHead()) && checkedWebElementDisplayed(newReceiptPage.getNotesTextField())&& newReceiptPage.getNotesTextField().getAttribute("placeholder").contains("notes")&& newReceiptPage.getNotesTextField().getAttribute("maxlength").contains("768"));
//	}


	public static void checkCash() {
		BaseClass.waitForPageLoad();
		newReceiptPage.getCashBtn().click();
		Assert.assertTrue(checkedWebElementDisplayed(newReceiptPage.getCashBtn()) && checkedWebElementDisplayed(newReceiptPage.getAmountHead()) && checkedWebElementDisplayed(newReceiptPage.getAmountTextField()));
	}

	public static void checkSubTypeOfModes(String mode) {
		List<WebElement> subType = driver.findElements(By.xpath("//label[contains(text(),'"+mode+"')]/../../../../..//div[@class='checkbox-inline cstm_rdb_ckb chkbType2 subMode_multi_line']//label"));
		switch (mode){
			case "Card":
				String[] expCard = { "Card", "EMI", "Bajaj Finance", "Kotak Finance", "HDFC Paper Fin", "ShopSe EMI"};
				for(int i=0;i< expCard.length;i++){
					Assert.assertEquals(subType.get(i).getText(),expCard[i]);
				}
				break;

			case "Wallet":
				String[] expWallet = { "UPI", "PayTm", "Religare Insurance", "Collect@LMS", "PNB MetLife", "Cashless"};
				for(int i=0;i< expWallet.length;i++){
					Assert.assertEquals(subType.get(i).getText(),expWallet[i]);
				}
				break;

			case "Others":
				String[] expOthers = { "Cheque", "NetBanking"};
				for(int i=0;i< expOthers.length;i++){
					Assert.assertEquals(subType.get(i).getText(),expOthers[i]);
				}
				break;
		}
	}

//	public static void checkSubTypeDropDown(String mode) {
//		BaseClass.waitForPageLoad();
//		boolean flag1, flag2, match = false;
//		flag1 = checkedWebElementDisplayed(subTypeDrpDwn);
//		if(mode.equals("Card")) {
//			String[] exp = { "Select Type", "Card", "Bajaj Finance", "EMI", "Card Direct"};
//			Select select = new Select(subTypeDrpDwn);
//			List<WebElement> options = select.getOptions();
//			for (WebElement we : options) {
//				for (int i = 0; i < exp.length; i++) {
//					if (flag2 = we.getText().equals(exp[i])) {
//						match = flag1 && flag2;
//					}
//				}
//				Assert.assertTrue(match);
//			}
//		}
//		else {
//			String[] exp = { "Select Type", "PayTm", "UPI", "Airtel", "PhonePe", "Clove DHP Card" };
//			Select select = new Select(subTypeDrpDwn);
//			List<WebElement> options = select.getOptions();
//			for (WebElement we : options) {
//				for (int i = 0; i < exp.length; i++) {
//					if (flag2 = we.getText().equals(exp[i])) {
//						match = flag1 && flag2;
//					}
//				}
//				Assert.assertTrue(match);
//			}
//		}
//	}

		public static void selectSubType(String subTypeValue) {
			WebElement subMode = driver.findElement(By.xpath("(//label[contains(text(),'"+subTypeValue+"')])[1]"));
			subMode.click();
	}

//	public static void selectSubType(String subTypeValue) {
//		BaseClass.waitForPageLoad();
//		BaseClass.selectFromDropDownByVisibleText(subTypeDrpDwn, subTypeValue);
//	}

	public static void checkTxnIdOfSubType(String subType) {
		BaseClass.waitForPageLoad();
		if(subType.equalsIgnoreCase("Bajaj Finance")|| subType.equalsIgnoreCase("Kotak Finance") || subType.equalsIgnoreCase("HDFC Paper Fin") || subType.equalsIgnoreCase("ShopSe EMI"))
			Assert.assertTrue(checkedWebElementDisplayed(newReceiptPage.getTxnIdHead()) && checkedWebElementDisplayed(newReceiptPage.getTxnIdTextField())&& newReceiptPage.getTxnIdTextField().getAttribute("placeholder").contains("» enter txn id"));
		else{
			Assert.assertTrue(checkedWebElementDisplayed(newReceiptPage.getPtrIdHead()));
			Assert.assertTrue(checkedWebElementDisplayed(newReceiptPage.getPtrIdTextField()));
		}
	}

	public static void enterTxnId(String txnId) {
		BaseClass.waitForPageLoad();
		newReceiptPage.getTxnIdTextField().clear();
		newReceiptPage.getTxnIdTextField().sendKeys(txnId);
	}

	public static void checkCheque() {
		BaseClass.waitForPageLoad();
		newReceiptPage.getChequeBtn().click();
		Assert.assertTrue(checkedWebElementDisplayed(newReceiptPage.getChequeNumberHead()) && checkedWebElementDisplayed(newReceiptPage.getChequeNoAndTxnRefIdTextfield()) && newReceiptPage.getChequeNoAndTxnRefIdTextfield().getAttribute("placeholder").contains("enter cheque number")
				&& checkedWebElementDisplayed(newReceiptPage.getBankNameHead()) && checkedWebElementDisplayed(newReceiptPage.getBankNameTextfield()) && newReceiptPage.getBankNameTextfield().getAttribute("placeholder").contains("enter bank name") && checkedWebElementDisplayed(newReceiptPage.getAmountHead())
				&& checkedWebElementDisplayed(newReceiptPage.getAmountTextField()));
	}

	public static void addAmountInDraft(){
       newReceiptPage.getAddBtn().click();
	   BaseClass.waitForSpinnerToDisappear();
	   WebElement alert = driver.findElement(By.xpath("//span[contains(text(),'Payment mode added successfully!')]"));
	   BaseClass.waitForElementVisibility(alert,4000);
	   Assert.assertTrue(alert.isDisplayed());
	   BaseClass.waitTillInvisiblityOfElement(alert);
	}

	public static void verifyDraftAdded(String amount){
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(newReceiptPage.getDraftPaymentHeading(),4000);
		Assert.assertEquals(newReceiptPage.getDraftPaymentHeading().getText(),"Payment(s) Collected in Draft (Needs to be adjusted on invoice(s) before save!)");
		Assert.assertEquals(newReceiptPage.getAddedDraftAmount().getText(),amount);
	}


	public static void checkNetBanking() {
		BaseClass.waitForPageLoad();
		newReceiptPage.getNetBankingBtn().click();
		Assert.assertTrue(checkedWebElementDisplayed(newReceiptPage.getTxnRefIdHead()) && checkedWebElementDisplayed(newReceiptPage.getChequeNoAndTxnRefIdTextfield()) && newReceiptPage.getChequeNoAndTxnRefIdTextfield().getAttribute("placeholder").contains("enter transaction id")
				&& checkedWebElementDisplayed(newReceiptPage.getBankNameHead()) && checkedWebElementDisplayed(newReceiptPage.getBankNameTextfield()) && newReceiptPage.getBankNameTextfield().getAttribute("placeholder").contains("enter bank name") && checkedWebElementDisplayed(newReceiptPage.getAmountHead())
				&& checkedWebElementDisplayed(newReceiptPage.getAmountTextField()));

	}

	public static void checkAndSelectAllModes(String mode,String amount,String cheqAndTxnNo,String bankName) {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(newReceiptPage.getCashBtn(),4000);
		switch(mode) {
		case "Cash":
			newReceiptPage.getCashBtn().click();
			break;
		case "Card":
			newReceiptPage.getCardBtn().click();
			break;
		case "Cheque":
			newReceiptPage.getChequeBtn().click();
			newReceiptPage.getChequeNoAndTxnRefIdTextfield().clear();
			newReceiptPage.getChequeNoAndTxnRefIdTextfield().sendKeys(cheqAndTxnNo);
			newReceiptPage.getBankNameTextfield().clear();
			newReceiptPage.getBankNameTextfield().sendKeys(bankName);
			break;
		case "NetBanking":
			newReceiptPage.getNetBankingBtn().click();
			newReceiptPage.getChequeNoAndTxnRefIdTextfield().clear();
			newReceiptPage.getChequeNoAndTxnRefIdTextfield().sendKeys(cheqAndTxnNo);
			newReceiptPage.getBankNameTextfield().clear();
			newReceiptPage.getBankNameTextfield().sendKeys(bankName);
			break;
		case "Wallet":
			newReceiptPage.getWalletBtn().click();
			break;

			case "Others":
				newReceiptPage.getOthersBtn().click();
				break;
		}
		newReceiptPage.getAmountTextField().clear();
		newReceiptPage.getAmountTextField().sendKeys(amount);
	}

	public static void enterCheckOrNetBankTxn(String number, String bankName){
		newReceiptPage.getChequeNoAndTxnRefIdTextfield().clear();
		newReceiptPage.getChequeNoAndTxnRefIdTextfield().sendKeys(number);
		newReceiptPage.getBankNameTextfield().clear();
		newReceiptPage.getBankNameTextfield().sendKeys(bankName);
	}





	public static void selectModes(String mode) {
		BaseClass.waitForPageLoad();
		switch(mode) {
		case "Cash":
			newReceiptPage.getCashBtn().click();
			break;

		case "Card":
			newReceiptPage.getCardBtn().click();
			break;

		case "Cheque":
			newReceiptPage.getChequeBtn().click();
			break;

		case "NetBanking":
			newReceiptPage.getNetBankingBtn().click();
			break;

		case "Wallet":
			newReceiptPage.getWalletBtn().click();
			break;
			case "Others":
				newReceiptPage.getOthersBtn().click();
				break;

		}

	}
	public static void enterNotes(String notes) {
		BaseClass.waitForPageLoad();
		newReceiptPage.getNotesTextField().clear();
		newReceiptPage.getNotesTextField().sendKeys(notes);
	}

	public static void checkCollectAdvanceAndAddPaymentBtn() {
		BaseClass.waitForPageLoad();
		if(newReceiptPage.getAddButton().isDisplayed()) {
			WebElement element = driver.findElement(By.xpath("//label[@class='statLabel' and contains(text(),'Collect from Advance')]"));
			Assert.assertTrue(checkedWebElementDisplayed(element)&& checkedWebElementDisplayed(newReceiptPage.getAddButton()));
		}
		else {
			Assert.assertFalse(checkedWebElementDisplayed(newReceiptPage.getAddButton()));
			WebElement element = driver.findElement(By.xpath("//label[@class='statLabel ng-binding' and contains(text(),'Collect from Advance')]"));
			Assert.assertTrue(checkedWebElementDisplayed(element));
		}
	}

	public static void clickDashboardBtn() {
		BaseClass.waitForPageLoad();
		newReceiptPage.getDashboardBtn().click();
	}

	public static void clickSaveBtn() {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(newReceiptPage.getSaveBtn(),4000);
		BaseClass.waitForModalOverlayToDisappear();
		newReceiptPage.getSaveBtn().click();
	}

//	public static void clickSaveBtn() {
//		BaseClass.waitForPageLoad();
//		try {
//			newReceiptPage.getSaveBtn().click();
//			Thread.sleep(4000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}

	public static void clickSaveContinueBtn() {
		BaseClass.waitForPageLoad();
		newReceiptPage.getSaveContinueBtn().click();
	}

	/*-- Validate the Successfull Msg --*/
	public static void verifySuccessfullMessage(){
		BaseClass.waitForSpinnerToDisappear();
    	BaseClass.waitForElementVisibility(newReceiptPage.getSuccessfullMsg(),4000);
		BaseClass.softAssert().assertTrue(checkedWebElementDisplayed(newReceiptPage.getSuccessfullMsg()));
		BaseClass.waitTillInvisiblityOfElement(newReceiptPage.getSuccessfullMsg());
	}



//	public static void verifySuccessfullMessage(){
//		BaseClass.waitForPageLoad();
//		try {
//			Thread.sleep(1000);
//			BaseClass.softAssert().assertTrue(checkedWebElementDisplayed(newReceiptPage.getSuccessfullMsg()));
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}

	/*Checking Error Mode Validation Msg---*/
	public static void checkedErrorMode(String errorMsg) {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(newReceiptPage.getErrorModeMsg().getText().contains(errorMsg));
	}

	/*Checking Error Amount Validation Msg---*/
	public static void checkedErrorAmount(String errorMsg) {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(newReceiptPage.getErrorAmountMsg().getText().contains(errorMsg));
	}

	/*Checking Error Sub Type Validation Msg---*/
	public static void checkedErrorSubType(String errorMsg) {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(newReceiptPage.getErrorSubTypeMsg().getText().contains(errorMsg));
	}

	/*Checking Error Cheque No Validation Msg---*/
	public static void checkedErrorChequeNo(String errorMsg) {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(newReceiptPage.getErrorChequeNoMsg().getText().contains(errorMsg));
	}

	/*Checking Error Bank Name Validation Msg---*/
	public static void checkedErrorBankName(String errorMsg) {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(newReceiptPage.getErrorBankNameMsg().getText().contains(errorMsg));
	}

	/*Checking Error TxnRefId Validation Msg---*/
	public static void checkedErrorTxnRefId(String errorMsg) {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(newReceiptPage.getErrorTransactionNoMsg().getText().contains(errorMsg));
	}

	/*Checking Error TxnId Validation Msg---*/
	public static void checkedErrorTxnId(String errorMsg) {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(newReceiptPage.getErrorTxnIdMsg().getText().contains(errorMsg));
	}

	public static void checkEditReceiptData(String mode,String subType) {
		BaseClass.waitForPageLoad();
		String str = newReceiptPage.getReceiptNoInEdit().getText();
		WebElement ele = driver.findElement(By.xpath("//label[text()='"+mode+"']/preceding-sibling::input"));
		if(mode.equals("Card")||mode.equals("Wallet")) {
			boolean flag2 = ele.isSelected();
			boolean flag3 = driver.findElement(By.xpath("//label[text()='"+subType+"']/preceding-sibling::input")).isSelected();
			Assert.assertTrue(flag2 && flag3);
		}
		else
			Assert.assertTrue(ele.isSelected());
		Assert.assertFalse(newReceiptPage.getAmountTextField().isEnabled());
		Assert.assertTrue(newReceiptPage.getNotesTextField().getText().contains("NA")||!newReceiptPage.getNotesTextField().getText().contains("null"));
	}

//	public static void checkEditReceiptData(String mode,String subType) {
//		BaseClass.waitForPageLoad();
//		String str = newReceiptPage.getReceiptNoInEdit().getText();
//		String[] split = str.split("-");
//		try {
//			String actual_rec=split[0].trim();
//			boolean flag1 = actual_rec.contains("Receipt No.:") && !(split[1].equals("NA") || split[1].equals("Null"));
//			Assert.assertTrue(flag1);
//		}
//		catch(ArrayIndexOutOfBoundsException object1) {
//		}
//		WebElement ele = driver.findElement(By.xpath("//label[text()='"+mode+"']/preceding-sibling::input"));
//		if(mode.equals("Card")||mode.equals("Wallet")) {
//			boolean flag2 = ele.isSelected();
//			boolean flag3 = BaseClass.firstSelectedOption(subTypeDrpDwn).contains(subType);
//			Assert.assertTrue(flag2 && flag3);
//		}
//		else
//			Assert.assertTrue(ele.isSelected());
//		Assert.assertFalse(newReceiptPage.getAmountTextField().isEnabled());
//		Assert.assertTrue(newReceiptPage.getNotesTextField().getText().contains("NA")||!newReceiptPage.getNotesTextField().getText().contains("null"));
//	}



	public static void makePayment(String paymentType, String mode, String tranxNo, String bankName) {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(newReceiptPage.getModeHead(),4000);
		for(WebElement invoices:newReceiptPage.getInvoiceNumber()){
			String invoiceNumber=invoices.getText().split("»")[0].trim();
			//fetching cells on the basis of the invoice number
			List<WebElement> invoiceDetailsCells = driver.findElements(By.xpath("//*[text()[contains(.,'" + invoiceNumber + "')]]/following-sibling::div"));
			String collectedAmt = invoiceDetailsCells.get(0).getText().split("\\.")[0];
			String amtDue = invoiceDetailsCells.get(1).getText().split("\\.")[0];
			String amtPaid = invoiceDetailsCells.get(2).getText().split("\\.")[0];
			String totalAmtToBePaid = invoiceDetailsCells.get(3).getText().split("\\.")[0];
			String couponAmt = invoiceDetailsCells.get(4).getText().split("\\.")[0];
			String totalInvoiceAmt = invoiceDetailsCells.get(5).getText().split("\\.")[0];
			long collectedAmount=0,amountDue=0,amountPaid=0,totalAmountToBePaid=0,couponAmount=0,totalInvoiceAmount=0;
			try {
				collectedAmount = NumberFormat.getNumberInstance(Locale.US).parse(collectedAmt).intValue();
				amountDue = NumberFormat.getNumberInstance(Locale.US).parse(amtDue).intValue();
				amountPaid =  NumberFormat.getNumberInstance(Locale.US).parse(amtPaid).intValue();
				totalAmountToBePaid = NumberFormat.getNumberInstance(Locale.US).parse(totalAmtToBePaid).intValue();
				couponAmount = NumberFormat.getNumberInstance(Locale.US).parse(couponAmt).intValue();
				totalInvoiceAmount = NumberFormat.getNumberInstance(Locale.US).parse(totalInvoiceAmt).intValue();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			String amountToBePaid;
			switch(paymentType){
				case "Full":
					amountToBePaid = Long.toString(amountDue);
					checkAndSelectAllModes(mode, amountToBePaid, tranxNo,bankName);
					enterNotes("Amount Fully Paid");
					saveDraftAmount();
					verifyDraftAdded(amountToBePaid+".00");
					clickSaveBtn();
					break;

				case "Partial":
					amountToBePaid = Long.toString(amountDue/10);
					checkAndSelectAllModes(mode, amountToBePaid, tranxNo,bankName);
					enterNotes("Amount Patially Paid");
					saveDraftAmount();
					verifyDraftAdded(amountToBePaid+".00");
					clickSaveBtn();
					break;
			}
		}
	}

	public static void invoiceTable(){
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForPageLoad();
		//checking the invoice prices column name
		boolean flag=checkedWebElementDisplayed(newReceiptPage.getInvoiceNumberColumnName())&&checkedWebElementDisplayed(newReceiptPage.getTotalAmountColumnName())&&checkedWebElementDisplayed(newReceiptPage.getCouponColumnName())&&checkedWebElementDisplayed(newReceiptPage.getAmountPayableColumnName())&&checkedWebElementDisplayed(newReceiptPage.getAmtPaidColumnName())&&checkedWebElementDisplayed(newReceiptPage.getAmountDueColumnName())&&checkedWebElementDisplayed(newReceiptPage.getCollectedAmount());
		if (flag){
			//iterating on the basis of invoices present at new receipt
			for(WebElement invoices:newReceiptPage.getInvoiceNumber()){
				String invoiceNumber=invoices.getText().split("»")[0].trim();
				//fetching cells on the basis of the invoice number
				List<WebElement> invoiceDetailsCells = driver.findElements(By.xpath("//*[text()[contains(.,'" + invoiceNumber + "')]]/following-sibling::div"));
				String collectedAmt = invoiceDetailsCells.get(0).getText().split("\\.")[0];
				String amtDue = invoiceDetailsCells.get(1).getText().split("\\.")[0];
				String amtPaid = invoiceDetailsCells.get(2).getText().split("\\.")[0];
				String totalAmtToBePaid = invoiceDetailsCells.get(3).getText().split("\\.")[0];
				String couponAmt = invoiceDetailsCells.get(4).getText().split("\\.")[0];
				String totalInvoiceAmt = invoiceDetailsCells.get(5).getText().split("\\.")[0];
				long collectedAmount=0,amountDue=0,amountPaid=0,totalAmountToBePaid=0,couponAmount=0,totalInvoiceAmount=0;
				try {
					collectedAmount = NumberFormat.getNumberInstance(Locale.US).parse(collectedAmt).intValue();
					amountDue = NumberFormat.getNumberInstance(Locale.US).parse(amtDue).intValue();
					amountPaid =  NumberFormat.getNumberInstance(Locale.US).parse(amtPaid).intValue();
					totalAmountToBePaid = NumberFormat.getNumberInstance(Locale.US).parse(totalAmtToBePaid).intValue();
					couponAmount = NumberFormat.getNumberInstance(Locale.US).parse(couponAmt).intValue();
					totalInvoiceAmount = NumberFormat.getNumberInstance(Locale.US).parse(totalInvoiceAmt).intValue();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				//treatment column name for same invoices
				WebElement sourceColumnName=driver.findElement(By.xpath("//*[text()[contains(.,'" + invoiceNumber + "')]]/../following-sibling::div//table/thead/tr/th[text()='Source']"));
				WebElement treatmentNameColumnName=driver.findElement(By.xpath("//*[text()[contains(.,'" + invoiceNumber + "')]]/../following-sibling::div//table/thead/tr/th[text()='Treatment Name']"));
				WebElement treatmentStatusColumnName=driver.findElement(By.xpath("//*[text()[contains(.,'" + invoiceNumber + "')]]/../following-sibling::div//table/thead/tr/th[text()='Status']"));
				WebElement unitCostColumnName=driver.findElement(By.xpath("//*[text()[contains(.,'" + invoiceNumber + "')]]/../following-sibling::div//table/thead/tr/th[text()='Unit (INR)']"));
				WebElement netAmtColumnName=driver.findElement(By.xpath("//*[text()[contains(.,'" + invoiceNumber + "')]]/../following-sibling::div//table/thead/tr/th[text()='Net Amt.']"));
				WebElement couponColumnName=driver.findElement(By.xpath("//*[text()[contains(.,'" + invoiceNumber + "')]]/../following-sibling::div//table/thead/tr/th[text()='Coupon']"));
				WebElement amtPayColumnName=driver.findElement(By.xpath("//*[text()[contains(.,'" + invoiceNumber + "')]]/../following-sibling::div//table/thead/tr/th[text()='Amt. Pay.']"));
				WebElement recdAmtColumnName=driver.findElement(By.xpath("//*[text()[contains(.,'" + invoiceNumber + "')]]/../following-sibling::div//table/thead/tr/th[text()='Recd. Amt.']"));
				WebElement dueColumnName=driver.findElement(By.xpath("//*[text()[contains(.,'" + invoiceNumber + "')]]/../following-sibling::div//table/thead/tr/th[text()='Due']"));
				WebElement byTrtColumnName=driver.findElement(By.xpath("//*[text()[contains(.,'" + invoiceNumber + "')]]/../following-sibling::div//table/thead/tr/th[text()='By Trt.']"));
				//variable used for the calculation the amount for the invoices
				long totalAmount=0,totalCouponAmount=0,totalAmountPayable=0,totalAmountPaid=0,totalAmountDue=0,totalAmountCollected = 0;
				//checking the treatment column name at the every invoice
				if(checkedWebElementDisplayed(sourceColumnName)&&checkedWebElementDisplayed(treatmentNameColumnName)&&checkedWebElementDisplayed(treatmentStatusColumnName)&&checkedWebElementDisplayed(unitCostColumnName)
						&&checkedWebElementDisplayed(netAmtColumnName)&&checkedWebElementDisplayed(couponColumnName)&&checkedWebElementDisplayed(amtPayColumnName)&&checkedWebElementDisplayed(recdAmtColumnName)&&checkedWebElementDisplayed(dueColumnName)&&checkedWebElementDisplayed(byTrtColumnName)){
					//treatment row for a particular invoice
					List<WebElement> treatmentRow = driver.findElements(By.xpath("//*[text()[contains(.,'" + invoiceNumber + "')]]/../following-sibling::div//table/tbody/tr"));
					//iterating for all treatment  for same invoice
					for (WebElement trtRow:treatmentRow) {
						//fetching the cells for the treatment
						List<WebElement> cells = trtRow.findElements(By.tagName("td"));
						//fetching the source from the treatment
						String source = cells.get(0).getText().trim();
						//fetching the  treatment
						String treatment = cells.get(1).getText().trim();
						//fetching the treatment status
						WebElement treatmentStatus = cells.get(2).findElement(By.tagName("span"));
						//fetching unit cost of the treatment
						String[] unitCost = cells.get(3).getText().trim().split("\\.");
						//fetching net amount of the treatment
						String[] netAmount = cells.get(4).getText().trim().split("\\.");
						//fetching coupon amount of the treatment
						String[] coupAmount = cells.get(5).getText().trim().split("\\.");
						//fetching amount payable of the treatment
						String[] amtPay = cells.get(6).getText().trim().split("\\.");
						//fetching recd amount of the treatment
						String[] recdAmt= cells.get(7).getText().trim().split("\\.");
						//fetching due amount of the treatment
						String[] dueAmt = cells.get(8).getText().trim().split("\\.");
						//fetching collected amount by trt
						List<WebElement> web = cells.get(9).findElements(By.xpath("div//input[@name='collpayment00']"));
						long notCollected_Amount_cost=0,collectedAmt_cost=0;
						if(web.size()>0){
							try {
								//if payment has been taken against the treatment then getting amount
								String colltdAmt = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", web.get(0));
								collectedAmt_cost = NumberFormat.getNumberInstance(Locale.US).parse(colltdAmt).intValue();
							} catch (ParseException e) {
								e.printStackTrace();
							}
						}else{
							try {
								//if payment has not been taken against treatment
								String[] notCollectedAmount = cells.get(9).getText().split("\\.");
								String notCollected_Amount = notCollectedAmount[0];
								notCollected_Amount_cost = NumberFormat.getNumberInstance(Locale.US).parse(notCollected_Amount).intValue();
							} catch (ParseException e) {
								e.printStackTrace();
							}
						}
						//calculating the the amount in inr
						long unitCost_cost=0,netAmount_cost=0,couponAmount_cost=0,amtPay_cost=0,recdAmt_cost=0,dueAmt_cost=0;
						try {
							unitCost_cost = NumberFormat.getNumberInstance(Locale.US).parse(unitCost[0]).intValue();
							netAmount_cost = NumberFormat.getNumberInstance(Locale.US).parse(netAmount[0]).intValue();
							couponAmount_cost = NumberFormat.getNumberInstance(Locale.US).parse(coupAmount[0]).intValue();
							amtPay_cost = NumberFormat.getNumberInstance(Locale.US).parse(amtPay[0]).intValue();
							recdAmt_cost = NumberFormat.getNumberInstance(Locale.US).parse(recdAmt[0]).intValue();
							dueAmt_cost = NumberFormat.getNumberInstance(Locale.US).parse(dueAmt[0]).intValue();
						} catch (ParseException e) {
							e.printStackTrace();
						}
						//checking source should not "null" and "NA"
						boolean source_flag = !(source.contains("NA") || source.contains("null"));
						//checking treatment should not "null" and "NA"
						boolean treatment_flag = !(treatment.contains("NA") || treatment.contains("null"));
						//checking all possible treatment status
						boolean treatmentStatus_flag = treatmentStatus.getAttribute("class").contains("in-progress") || treatmentStatus.getAttribute("class").contains("start");
						//checking unit cost can not be equal to zero
						boolean unitCost_cost_flag = !(unitCost_cost == 0);
						//checking net amount calculation
						boolean netAmount_flag = (netAmount_cost == (couponAmount_cost + amtPay_cost));
						//checking coupon amount calculation
						boolean couponAmount_flag = (couponAmount_cost == (netAmount_cost - amtPay_cost));
						//checking amount payable  calculation
						boolean amountPayable_flag = (amtPay_cost == (netAmount_cost - couponAmount_cost));
						boolean recdAmt_flag=false,amountDue_flag=false,byTrt_flag=false;
						//checking if payment has been taken against the treatment
						if(web.size()>0){
							recdAmt_flag = (recdAmt_cost == (netAmount_cost - (couponAmount_cost + dueAmt_cost + collectedAmt_cost)));
							amountDue_flag = (dueAmt_cost == (netAmount_cost - (couponAmount_cost + recdAmt_cost + collectedAmt_cost)));
							byTrt_flag = (collectedAmt_cost == (netAmount_cost - (couponAmount_cost + recdAmt_cost + dueAmt_cost)));
						}else{
							//checking if payment has been taken against the treatment
							recdAmt_flag = (recdAmt_cost == (netAmount_cost - (couponAmount_cost + dueAmt_cost + notCollected_Amount_cost)));
							amountDue_flag = (dueAmt_cost == (netAmount_cost - (couponAmount_cost + recdAmt_cost + notCollected_Amount_cost)));
							byTrt_flag = (notCollected_Amount_cost == (netAmount_cost - (couponAmount_cost + recdAmt_cost + dueAmt_cost)));
						}
						//checking all the line items mentioned below
						Assert.assertTrue(source_flag&&treatment_flag&&treatmentStatus_flag&&unitCost_cost_flag&&netAmount_flag&&couponAmount_flag&&amountPayable_flag&&recdAmt_flag&&amountDue_flag&&byTrt_flag);
						//calculating sum of  net Amount of all the treatment present in the invoices
						totalAmount=totalAmount+netAmount_cost;
						//calculating sum of  coupon Amount of all the treatment present in the invoices
						totalCouponAmount=totalCouponAmount+couponAmount_cost;
						//calculating sum of  payable Amount of all the treatment present in the invoices
						totalAmountPayable=totalAmountPayable+amtPay_cost;
						//calculating sum of  paid Amount of all the treatment present in the invoices
						totalAmountPaid=totalAmountPaid+recdAmt_cost;
						//calculating sum of  recd Amount of all the treatment present in the invoices
						totalAmountDue=totalAmountDue+dueAmt_cost;
						//calculating sum of  total collected Amount of all the treatment present in the invoices
						totalAmountCollected=totalAmountCollected+notCollected_Amount_cost+collectedAmt_cost;
					}
				}else {
					Assert.fail();
				}
				//checking total amount of the invoice
				boolean totalAmount_flag=(totalAmount==totalInvoiceAmount)&&(totalInvoiceAmount==(couponAmount+totalAmountToBePaid));
				//checking total coupon amount of the invoice
				boolean totalCouponAmount_flag=(totalCouponAmount==couponAmount)&&(couponAmount==(totalInvoiceAmount-totalAmountToBePaid));
				//checking total amount payable of the invoice
				boolean totalAmountPayable_flag=(totalAmountPayable==totalAmountToBePaid)&&(totalAmountToBePaid==(totalInvoiceAmount-couponAmount));
				//checking total amount paid of the invoice
				boolean totalAmountPaid_flag=(totalAmountPaid==amountPaid)&&(amountPaid==(totalInvoiceAmount-(couponAmount+amountDue+collectedAmount)));
				//checking total amount due of the invoice
				boolean totalAmountDue_flag=(totalAmountDue==amountDue)&&(amountDue==(totalInvoiceAmount-(couponAmount+amountPaid+collectedAmount)));
				//checking total collected amount of the invoice
				boolean totalAmountCollected_flag=(totalAmountCollected==collectedAmount)&&(collectedAmount==(totalInvoiceAmount-(couponAmount+amountPaid+amountDue)));
				//validating invoice line item mentioned below
//				Assert.assertTrue(totalAmount_flag&&totalCouponAmount_flag&&totalAmountPayable_flag&&totalAmountPaid_flag&&totalAmountDue_flag&&totalAmountCollected_flag);
			}
		}
	}
	//
	public static void alertMessages(){
		BaseClass.waitForPageLoad();
		//fetching total invoices at the new receipt page
		if(newReceiptPage.getInvoiceNumber().size()>0) {
			Random randomGenerator = new Random();
			int index = randomGenerator.nextInt(newReceiptPage.getInvoiceNumber().size());
			//getting random invoice from new receipt page
			WebElement invoices = newReceiptPage.getInvoiceNumber().get(index);
			String invoice_Number = invoices.getText().split("»")[0].trim();
			WebElement web = driver.findElement(By.xpath("//*[text()[contains(.,'" + invoice_Number + "')]]//input[@type='checkbox']"));
			//checking if only one invoice is present then it must be selected
			if(newReceiptPage.getInvoiceNumber().size()==1){
				WebElement webElement = driver.findElement(By.xpath("//*[text()[contains(.,'"+invoice_Number+"')]]//input[@type='checkbox']"));
				//now invoice selected but there is no payment details and user try save receipt the it will show Payment not applied message
				if (newReceiptPage.getPaymentDetailsRow().size()==0&&webElement.isSelected()){
					newReceiptPage.getSaveBtn().click();
					try {
						Thread.sleep(1000);
						Assert.assertTrue(checkedWebElementDisplayed(newReceiptPage.getPaymentNotAppliedMsg()));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else {
					Assert.assertTrue(webElement.isSelected());
				}
				//if invoices are more then one
			}else {
				int i = 0;
				//checking total deselected invoices at the new receipt page
				for (WebElement webElement : newReceiptPage.getInvoiceNumber()) {
					String invoiceNumber = webElement.getText().split("»")[0].trim();
					WebElement webElement1 = driver.findElement(By.xpath("//*[text()[contains(.,'" + invoiceNumber + "')]]//input[@type='checkbox']"));
					if (!webElement1.isSelected()) {
						i++;
					}
				}
				//if all invoices are deselected then try save the receipt it will show an error message please selected the invoice validated
				if(i==newReceiptPage.getInvoiceNumber().size()){
					newReceiptPage.getSaveBtn().click();
//					try {
//						Thread.sleep(1000);
//						BaseClass.executeScript(web);
//						Assert.assertTrue(checkedWebElementDisplayed(msgInvoiceNotSelected));
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
					//now invoice selected but there is no payment details and user try save receipt the it will show Payment not applied message
					if (newReceiptPage.getPaymentDetailsRow().size()==0){
						newReceiptPage.getSaveBtn().click();
						try {
							Thread.sleep(1000);
							Assert.assertTrue(checkedWebElementDisplayed(newReceiptPage.getPaymentNotAppliedMsg()));
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}else {
					Reporter.log("Invoice Selected and payment Applied at the treatment");
				}
			}
		}else{
			Reporter.log("There is no invoice");
		}
	}
	//validating the total payment receipt
	public static void totalReceipt_RemainingAmountDue(){
		BaseClass.waitForPageLoad();
		BaseClass.waitForSpinnerToDisappear();
		//Parsing the total payment receipt and amount due string to long
		String[] totalAmountReceipt = newReceiptPage.getTotalReceiptsAmount().getText().trim().split("\\.");
		String[] remainingAmount = newReceiptPage.getRemainingAmountDueInvoice().getText().trim().split("\\.");
		long totalAmountReceipt_cost=0,remainingAmount_cost=0;
		try {
			totalAmountReceipt_cost = NumberFormat.getNumberInstance(Locale.US).parse(totalAmountReceipt[0]).intValue();
			remainingAmount_cost = NumberFormat.getNumberInstance(Locale.US).parse(remainingAmount[0]).intValue();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//verification of total new receipt amount and calculating the total amount from the table
		//verification of total amount due of all the invoice and  the remaining amount due at payment details
		if(totalAmountReceipt_cost==totalPaymentNewReceipt()&&totalDueInvoices()>totalAmountReceipt_cost){
			Assert.assertEquals(remainingAmount_cost,(totalAmountPayableInvoices()-(totalAmountPaidInvoices()+totalAmountReceipt_cost)));
		}else if(totalAmountReceipt_cost==totalPaymentNewReceipt()&&(totalDueInvoices()<totalAmountReceipt_cost||totalDueInvoices()==totalAmountReceipt_cost)){
			Assert.assertEquals(remainingAmount_cost,0);
		}else {
			Assert.fail();
		}
	}
	//calculating the total payment taken
	private static long totalPaymentNewReceipt(){
		BaseClass.waitForPageLoad();
		//checking column name of payment details
		boolean flag =  checkedWebElementDisplayed(newReceiptPage.getTypeColumnName()) && checkedWebElementDisplayed(newReceiptPage.getAmountColumnName())
				&& checkedWebElementDisplayed(newReceiptPage.getStatusColumnName()) && checkedWebElementDisplayed(newReceiptPage.getOtherInfoColumnName()) && checkedWebElementDisplayed(newReceiptPage.getNotesColumnName()) && checkedWebElementDisplayed(newReceiptPage.getActionColumnName());
		long totalPayment =0;
		//if payment row and  column name present
		if(newReceiptPage.getPaymentDetailsRow().size()>0&&flag){
			//iterating on the basis of the payments row present
			for (WebElement rowPayment:newReceiptPage.getPaymentDetailsRow()) {
				List<WebElement> cells = rowPayment.findElements(By.tagName("td"));
				String[] amount = cells.get(2).getText().trim().split("\\.");
				long amountPayment =0;
				try{
					amountPayment = NumberFormat.getNumberInstance(Locale.US).parse(amount[0]).intValue();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				totalPayment=totalPayment+amountPayment;
			}
		}
		return totalPayment;
	}
	//total amount due on invoices
	private static long totalDueInvoices(){
		BaseClass.waitForPageLoad();
		long totalAmountDue =0;
		for (WebElement invoices:newReceiptPage.getInvoiceNumber()) {
			String invoiceNumber=invoices.getText().split("» Clove Dental")[0].trim();
			//fetching cells on the basis of the invoice number
			List<WebElement> invoiceDetailsCells = driver.findElements(By.xpath("//*[text()[contains(.,'" + invoiceNumber + "')]]/following-sibling::div"));
			//fetching total amount due for the same invoice
			String[] totalAmountDueInvoice = invoiceDetailsCells.get(1).getText().split("\\.");
			long totalAmountDueInvoice_cost=0;
			try {
				totalAmountDueInvoice_cost = NumberFormat.getNumberInstance(Locale.US).parse(totalAmountDueInvoice[0]).intValue();
			}catch (ParseException e){
				e.printStackTrace();
			}
			totalAmountDue = totalAmountDue+totalAmountDueInvoice_cost;
		}
		return totalAmountDue;
	}
	//total amount payable on invoices
	private static long totalAmountPayableInvoices(){
		BaseClass.waitForPageLoad();
		long totalAmountPayable =0;
		for (WebElement invoices:newReceiptPage.getInvoiceNumber()) {
			String invoiceNumber=invoices.getText().split("» Clove Dental")[0].trim();
			//fetching cells on the basis of the invoice number
			List<WebElement> invoiceDetailsCells = driver.findElements(By.xpath("//*[text()[contains(.,'" + invoiceNumber + "')]]/following-sibling::div"));
			//fetching total amount due for the same invoice
			System.out.println("invoiceDetailsCells"+invoiceDetailsCells.get(2).getText());
			String[] totalAmountPayInvoice = invoiceDetailsCells.get(3).getText().split("\\.");
			long amtPay_cost=0;
			try {
				amtPay_cost = NumberFormat.getNumberInstance(Locale.US).parse(totalAmountPayInvoice[0]).intValue();
			}catch (ParseException e){
				e.printStackTrace();
			}
			totalAmountPayable=totalAmountPayable+amtPay_cost;
		}
		return totalAmountPayable;
	}
	//total amount paid on invoices
	private static long totalAmountPaidInvoices(){
		BaseClass.waitForPageLoad();
		long totalAmountPaid =0;
		for (WebElement invoices:newReceiptPage.getInvoiceNumber()) {
			String invoiceNumber=invoices.getText().split("» Clove Dental")[0].trim();
			//fetching cells on the basis of the invoice number
			List<WebElement> invoiceDetailsCells = driver.findElements(By.xpath("//*[text()[contains(.,'" + invoiceNumber + "')]]/following-sibling::div"));
			//fetching total amount paid for the same invoice
			String[] totalAmountPaidInvoice = invoiceDetailsCells.get(2).getText().split("\\.");
			long totalAmountPaidInvoice_cost=0;
			try {
				totalAmountPaidInvoice_cost = NumberFormat.getNumberInstance(Locale.US).parse(totalAmountPaidInvoice[0]).intValue();
			}catch (ParseException e){
				e.printStackTrace();
			}
			//calculating sum of  paid Amount of all the treatment present in the invoices
			totalAmountPaid=totalAmountPaid+totalAmountPaidInvoice_cost;
		}
		return totalAmountPaid;
	}
	//total amount collected on invoices
	private static long totalAmountCollectedInvoices(){
		BaseClass.waitForPageLoad();
		long totalAmountCollected =0;
		for (WebElement invoices:newReceiptPage.getInvoiceNumber()) {
			String invoiceNumber=invoices.getText().split("» Clove Dental")[0].trim();
			//fetching cells on the basis of the invoice number
			List<WebElement> invoiceDetailsCells = driver.findElements(By.xpath("//*[text()[contains(.,'" + invoiceNumber + "')]]/following-sibling::div"));
			//fetching total amount due for the same invoice
			String[] totalAmountCollectedInvoice = invoiceDetailsCells.get(0).getText().split("\\.");
			long totalAmountCollectedInvoice_cost=0;
			try {
				totalAmountCollectedInvoice_cost = NumberFormat.getNumberInstance(Locale.US).parse(totalAmountCollectedInvoice[0]).intValue();
			}catch (ParseException e){
				e.printStackTrace();
			}
			totalAmountCollected=totalAmountCollected+totalAmountCollectedInvoice_cost;
		}
		return totalAmountCollected;
	}
	//validate apply payment button in payment details and apply payment just below the all invoices
	public static void checkApplyPaymentButton(){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(newReceiptPage.getApplyPaymentButton());
		Assert.assertTrue(checkedWebElementDisplayed(newReceiptPage.getApplyPaymentButton())&&checkedWebElementDisplayed(newReceiptPage.getApplyPaymentBTn_invoiceFoot()));
	}
	//clicking on apply button
	public static void applyPayment(){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(newReceiptPage.getApplyPaymentButton());
		newReceiptPage.getApplyPaymentButton().click();
	}
	//save the draft amount
	public static void saveDraftAmount(){
		newReceiptPage.getAddBtn().click();
		BaseClass.waitForSpinnerToDisappear();
		WebElement alert = driver.findElement(By.xpath("//span[contains(text(),'Payment mode added successfully!')]"));
		Assert.assertTrue(alert.isDisplayed());
		BaseClass.waitTillInvisiblityOfElement(alert);
	}
	//validation of the payment details
	public static void paymentDetailsTable(String mode,String amountValue,String bankName,String cheqAndTxnNo){
		BaseClass.waitForPageLoad();
		boolean flag = checkedWebElementDisplayed(newReceiptPage.getModeColumnName()) && checkedWebElementDisplayed(newReceiptPage.getTypeColumnName()) && checkedWebElementDisplayed(newReceiptPage.getAmountColumnName())
				&& checkedWebElementDisplayed(newReceiptPage.getStatusColumnName()) && checkedWebElementDisplayed(newReceiptPage.getOtherInfoColumnName()) && checkedWebElementDisplayed(newReceiptPage.getNotesColumnName()) && checkedWebElementDisplayed(newReceiptPage.getActionColumnName());
		if(flag){
			for (WebElement row:newReceiptPage.getPaymentDetailsRow()) {
				List<WebElement> cells = row.findElements(By.tagName("td"));
				String modePayment = cells.get(0).getText().trim();
				String modeSubType = cells.get(1).getText().trim();
				String[] amount = cells.get(2).getText().trim().split("\\.");
				String status = cells.get(3).getText().trim();
				String otherInfo = cells.get(4).getText().trim();
				String note = cells.get(5).getText().trim();
				WebElement deleteBtn = cells.get(6).findElement(By.xpath("a[contains(@data-ng-click,'deletePaymentMode')]"));
				boolean b = otherInfo.contains(bankName) && otherInfo.contains(cheqAndTxnNo);
				boolean mode_flag,modeSubType_flag,amount_flag,status_flag,otherInfo_flag,note_flag,deleteFlag;
				if(modePayment.equals(mode)) {
					switch (mode) {
						case "Cash":
							mode_flag = modePayment.equals(mode);
							modeSubType_flag = modeSubType.contains("NA");
							amount_flag = (amount[0].equals(amountValue));
							otherInfo_flag = otherInfo.contains("NA");
							note_flag = !(note.contains("NA") || note.contains("null"));
							deleteFlag = checkedWebElementDisplayed(deleteBtn);
							Assert.assertTrue(mode_flag && modeSubType_flag && amount_flag && otherInfo_flag && note_flag && deleteFlag);
							break;
						case "Card":
							mode_flag = modePayment.equals(mode);
							modeSubType_flag = !(modeSubType.contains("NA") || modeSubType.contains("null"));
							amount_flag = (amount[0].equals(amountValue));
							otherInfo_flag = otherInfo.contains(cheqAndTxnNo);
							note_flag = !(note.contains("NA") || note.contains("null"));
							deleteFlag = checkedWebElementDisplayed(deleteBtn);
							Assert.assertTrue(mode_flag && modeSubType_flag && amount_flag && otherInfo_flag && note_flag && deleteFlag);

							break;
						case "Wallet":
							mode_flag = modePayment.equals(mode);
							modeSubType_flag = !(modeSubType.contains("NA") || modeSubType.contains("null"));
							amount_flag = (amount[0].equals(amountValue));
							otherInfo_flag = otherInfo.contains("NA");
							note_flag = !(note.contains("NA") || note.contains("null"));
							deleteFlag = checkedWebElementDisplayed(deleteBtn);
							Assert.assertTrue(mode_flag && modeSubType_flag && amount_flag && note_flag && deleteFlag);
							break;
						case "Others":
							mode_flag = modePayment.equals(mode);
							modeSubType_flag = modeSubType.contains("NA");
							amount_flag = (amount[0].equals(amountValue));
							otherInfo_flag = b;
							note_flag = !(note.contains("NA") || note.contains("null"));
							deleteFlag = checkedWebElementDisplayed(deleteBtn);
							Assert.assertTrue(mode_flag && modeSubType_flag && amount_flag && otherInfo_flag && note_flag && deleteFlag);
							break;
					}
				}else {
					continue;
				}
			}
		}else{
			Assert.fail();
		}
	}
	//validating amount bottom overall amount due and overall collected
	public static void totalDue_totalCollection(){
		BaseClass.waitForPageLoad();
		String[] str = newReceiptPage.getTotalDue_TotalCollection().getText().trim().split("/");
		String[] totalInvoiceDue = str[0].trim().split("\\.");
		String[] totalCollected = str[1].trim().split("\\.");
		long totalInvoiceDueBottom=0,totalCollectedBottom=0;
		try {
			totalInvoiceDueBottom = NumberFormat.getNumberInstance(Locale.US).parse(totalInvoiceDue[0]).intValue();
			totalCollectedBottom = NumberFormat.getNumberInstance(Locale.US).parse(totalCollected[0]).intValue();
		}catch (ParseException e){
			e.printStackTrace();
		}
		Assert.assertEquals(totalInvoiceDueBottom,totalDueInvoices());
		Assert.assertEquals(totalCollectedBottom,totalAmountCollectedInvoices());
	}
//clicking on the delete button on the basis on mode and amount of the receipt
	public static void deleteReceipt(String mode,String amount){
		BaseClass.waitForPageLoad();
		WebElement deleteBtn = driver.findElement(By.xpath("//td[contains(text(),'" + mode + "')]/following-sibling::td[contains(text(),'" + amount + "')]/following-sibling::td//span[@class='actn-icn delete']"));
		deleteBtn.click();

	}
//authenticating to delete the receipt

	public static void yesDeleteReceipt(){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementVisibility(newReceiptPage.getYesDeleteReceipt(),4000);
		newReceiptPage.getYesDeleteReceipt().click();
		BaseClass.waitForSpinnerToDisappear();
	}
	//Cancel to delete the receipt
	public static void noDeleteReceipt(){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementVisibility(newReceiptPage.getNoDeleteReceipt(),4000);
		newReceiptPage.getNoDeleteReceipt().click();
	}

	public static void acceptExitNewReceiptListing(){
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementVisibility(newReceiptPage.getNoDeleteReceipt(),4000);
		newReceiptPage.getNoDeleteReceipt().click();
	}
	//verifying receipt after deleting
	public static void checkDeletedReceipt(String mode,String amount){
		BaseClass.waitForPageLoad();
		List<WebElement> web = driver.findElements(By.xpath("//td[contains(text(),'" + mode + "')]/following-sibling::td[contains(text(),'" + amount + "')]/following-sibling::td//span[@class='actn-icn delete']"));
		Assert.assertEquals(web.size(),0);
	}
	//applying payment equal to the remaining amount
	public static void addingReceiptEqualRemainingAmount(){
		BaseClass.waitForPageLoad();
		String[] remainingAmount = newReceiptPage.getRemainingAmountDueInvoice().getText().trim().split("\\.");
		long totalDueInvoice = totalDueInvoices();
		newReceiptPage.getAmountTextField().sendKeys(Long.toString(totalDueInvoice));
		System.out.println("remainingAmount"+remainingAmount[0]);
		try {
			newReceiptPage.getCashBtn().click();
			newReceiptPage.getDraftButton().click();
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//selecting all invoices
	public static void selectInvoices(){
		if(newReceiptPage.getInvoiceNumber().size()>1) {
			for (WebElement webElement : newReceiptPage.getInvoiceNumber()) {
				String invoiceNumber = webElement.getText().trim();
				WebElement webElement1 = driver.findElement(By.xpath("//*[text()[contains(.,'" + invoiceNumber + "')]]//input[@type='checkbox']"));
				if (webElement1.isSelected()) {
					continue;
				} else {
					BaseClass.executeScript(webElement1);

				}
			}
		}else {
			for (WebElement webElement : newReceiptPage.getInvoiceNumber()) {
				String invoiceNumber = webElement.getText().trim();
				WebElement webElement1 = driver.findElement(By.xpath("//*[text()[contains(.,'" + invoiceNumber + "')]]//input[@type='checkbox']"));
				Assert.assertTrue(webElement1.isSelected());
			}
		}
	}
	//validating if receipt amount is more then the invoice amount then advance receipt should be created for extra amount
	public static void advanceCreatedNewReceipt(){
		BaseClass.waitForPageLoad();
		String[] amount = newReceiptPage.getAdvaceToBeCreated().getText().trim().split("\\.");
		String[] totalAmountReceipt = newReceiptPage.getTotalReceiptsAmount().getText().trim().split("\\.");
		long totalAmountReceipt_cost = Long.parseLong(totalAmountReceipt[0]);
		long advanceCreatedAmonut=0;
		try {
			advanceCreatedAmonut = NumberFormat.getNumberInstance(Locale.US).parse(amount[0]).intValue();
		}catch (ParseException e){
			e.printStackTrace();
		}
		Assert.assertEquals(advanceCreatedAmonut,(totalAmountReceipt_cost+totalAmountPaidInvoices())-totalAmountPayableInvoices());
	}
	private static boolean checkedWebElementDisplayed(WebElement webElement) {
		return (webElement.isDisplayed());
	}
}
