package pageActions.patientDashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BaseClass;
import pages.patientDashboard.TreatmentPlanListingPage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.lang.Float;


public class TreatmentPlanListingPageActions extends BaseClass{

	static TreatmentPlanListingPage treatmentPlansListingPage = PageFactory.initElements(driver, TreatmentPlanListingPage.class);

	public static void setCovidUpdateAlert(){
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(100);
			Assert.assertTrue(treatmentPlansListingPage.getCovidUpdateAlert().size()==1||driver.getTitle().contains("Treatment Plan Listing"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void checkedDataNameMainList() {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedWebElementDisplayed(treatmentPlansListingPage.getWdMainList()) && checkedWebElementDisplayed(treatmentPlansListingPage.getSourceMainList())
				&& checkedWebElementDisplayed(treatmentPlansListingPage.getUnitCostMainList()) && checkedWebElementDisplayed(treatmentPlansListingPage.getNetAmtMainList())
				&& checkedWebElementDisplayed(treatmentPlansListingPage.getCpnValueMainList()) && checkedWebElementDisplayed(treatmentPlansListingPage.getAmtPayMainList())
				&& checkedWebElementDisplayed(treatmentPlansListingPage.getCreatedByMainList()) && checkedWebElementDisplayed(treatmentPlansListingPage.getCpnBasisByMainList()));
	}

	public static void verifyHeaderOfPage(String header) {
//		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansListingPage.getHeaderOfPage());
		Assert.assertTrue(treatmentPlansListingPage.getHeaderOfPage().getText().contains(header));
	}

	public static void verifyNoRecordMsg() {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(3000);
			Assert.assertTrue(checkedWebElementDisplayed(treatmentPlansListingPage.getNoRecordMsg()));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void selectedTreatmentInTreatmentList(String fullName,String companyName) {
		BaseClass.waitForPageLoad();
		WebElement web, checkBox, sourceName;
		List<WebElement> unitCostNetAmtCpnValueBasisAmtPay, creatByRemarks;
		web = driver.findElement(By.xpath("//span[contains(text(),'" + fullName + "')]"));
		String string = driver.findElement(By.xpath("//span[contains(text(),'"+fullName+"')]//span[contains(@class,'company_txt')]")).getText().trim();
		String[] excat_companyName = string.split(" ");
		checkBox = driver
				.findElement(By.xpath("//span[contains(text(),'" + fullName + "')]/../preceding-sibling::td//label"));
		sourceName = driver.findElement(By.xpath("//span[contains(text(),'" + fullName
				+ "')]/../preceding-sibling::td[contains(@class,'wrd-brk-wrd')]"));
		unitCostNetAmtCpnValueBasisAmtPay = driver
				.findElements(By.xpath("//span[contains(text(),'" + fullName + "')]/../following-sibling::td/span"));
		creatByRemarks = driver.findElements(
				By.xpath("//span[contains(text(),'" + fullName + "')]/../following-sibling::td[@class='ng-binding']"));
		Assert.assertTrue(checkedWebElementDisplayed(web) && checkedWebElementDisplayed(checkBox)
				&& checkedWebElementDisplayed(sourceName));
		Assert.assertEquals(excat_companyName[1], companyName);
		for (int i = 0; unitCostNetAmtCpnValueBasisAmtPay.size() > i; i++) {
			Assert.assertTrue(!(unitCostNetAmtCpnValueBasisAmtPay.get(i).getText() == null));
		}
		for (int j = 0; creatByRemarks.size() > j; j++) {
			Assert.assertTrue(!(creatByRemarks.get(j).getText() == null));
		}
	}

	public static void afterCopyTreatmentInMainList(String fullName) {
		BaseClass.waitForElementToDisappear((By.xpath("//span[contains(text(),'Treatment plan copied successfully!'])")));
		List<WebElement> web = driver.findElements(By.xpath("//span[contains(text(),'" + fullName + "')]"));
		BaseClass.visibilityOfListLocated(web);
		for(int i=0;i<web.size();i++) {
			boolean result = (web.size() == 2);
			Assert.assertTrue(result);
		}
	}
	
	public static void verifyDatesTreatmentPlanList() {
		BaseClass.waitForModalOverlayToDisappear();
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementToBeClickable(treatmentPlansListingPage.getDateInTreatmentList());
		String str = treatmentPlansListingPage.getDateInTreatmentList().getText();
		SimpleDateFormat date = new SimpleDateFormat("dd-MM-yy");
		Date dat = new Date();
		String currentDate = date.format(dat);
		Assert.assertTrue(str.contains(currentDate));
	}

//	public static void verifyDatesTreatmentPlanList() {
//		BaseClass.waitForPageLoad();
//		try {
//			Thread.sleep(2500);
//			BaseClass.waitForElementToBeClickable(treatmentPlansListingPage.getDateInTreatmentList());
//			String str = treatmentPlansListingPage.getDateInTreatmentList().getText();
//			SimpleDateFormat date = new SimpleDateFormat("dd-MM-yy");
//			Date dat = new Date();
//			String currentDate = date.format(dat);
//			Assert.assertTrue(str.contains(currentDate));
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public static void verifyCopyBtn(String currentDate) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansListingPage.getDateInTreatmentList());
		WebElement web = driver.findElement(By.xpath(
				"//span[text()='"+currentDate+"']/../following-sibling::div//span[@class='trtNewIcons trt_copy_icn']/following-sibling::span[text()='Copy']"));
		Assert.assertTrue(web.isDisplayed());
	}
	
	public static void clickOnCopyBtn(String currentDate) {
		BaseClass.waitForElementToBeClickable(treatmentPlansListingPage.getDateInTreatmentList());
			WebElement web = driver.findElement(By.xpath(
			"//span[text()='"+currentDate+"']/../following-sibling::div//span[@class='trtNewIcons trt_copy_icn']/following-sibling::span[text()='Copy']"));
			web.click();
			boolean isSuccMsgDisplayed = treatmentPlansListingPage.getCopyPlanAlrtTxt().isDisplayed();
			Assert.assertEquals(true, isSuccMsgDisplayed);
	}

//	public static void clickOnCopyBtn(String currentDate) {
//		BaseClass.waitForPageLoad();
//		BaseClass.waitForElementToBeClickable(treatmentPlansListingPage.getDateInTreatmentList());
//		try {
//			Thread.sleep(1500);
//			WebElement web = driver.findElement(By.xpath(
//					"//span[text()='"+currentDate+"']/../following-sibling::div//span[@class='trtNewIcons trt_copy_icn']/following-sibling::span[text()='Copy']"));
//			web.click();
//			Thread.sleep(1500);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}

	public static void verifyStartBtn(String currentDate) {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(treatmentPlansListingPage.getAddNewBtn(), 3000);
		WebElement web = driver.findElement(By.xpath("//span[text()='"+currentDate+"']/../..//span[@class='trtNewIcons trt_book_icn']"));
		Assert.assertTrue(web.isDisplayed());
	} 

	public static void clickOnStartBtn(String currentDate) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansListingPage.getDateInTreatmentList());
		try {
			Thread.sleep(3000);
			WebElement web = driver.findElement(By.xpath("//span[text()='"+currentDate+"']/../following-sibling::div//span[@class='trtNewIcons trt_strt_icn']/following-sibling::span[text()='Start']"));
			web.click();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
					
	public static void checkStartBtnNotPresent(String currentDate) {
		BaseClass.waitForPageLoad();
		List<WebElement> web = driver.findElements(By.xpath("//span[text()='" + currentDate + "']/../following-sibling::div//span[@class='trtNewIcons trt_strt_icn']/following-sibling::span[text()='Start']"));
		Assert.assertTrue(web.size() == 0);
	}

	public static void verifyMarkBtn(String currentDate) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansListingPage.getDateInTreatmentList());
		WebElement web = driver.findElement(
				By.xpath("//span[text()='"+currentDate+"']/../following-sibling::div//span[@class='trtNewIcons trt_book_icn']/following-sibling::span[text()='Mark']"));
		Assert.assertTrue(web.isDisplayed());
	}

	public static void clickOnMarkBtn(String currentDate) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansListingPage.getDateInTreatmentList());
		WebElement web = driver.findElement(
				By.xpath("//span[text()='"+currentDate+"']/../following-sibling::div//span[@class='trtNewIcons trt_book_icn']/following-sibling::span[text()='Mark']"));
		web.click();
	}

	public static void verifyViewBtn(String currentDate) {
		BaseClass.waitForElementToBeClickable(treatmentPlansListingPage.getDateInTreatmentList());
		WebElement web = driver.findElement(By.xpath(
				"//span[text()='"+currentDate+"']/../../..//td[@class='wrd-brk-wrd ng-binding']/../../../../..//span[contains(text(),'View')]"));
		Assert.assertTrue(web.isDisplayed());
	}
	
	public static void clickOnViewBtn(String currentDate) {
		BaseClass.waitForModalOverlayToDisappear();
		BaseClass.waitForElementVisibility(treatmentPlansListingPage.getAddNewBtn(), 4000);
		WebElement web = driver.findElement(By.xpath(
				"//span[text()='"+currentDate+"']/../../../../.././/span[contains(text(),'View')]"));
    		web.click();
    		BaseClass.waitForElementVisibility(treatmentPlansListingPage.getCloseBtnViewPopup(),4000);
	}

//	public static void clickOnViewBtn(String currentDate) {
//		BaseClass.waitForPageLoad();
//		try {
//			Thread.sleep(2000);
//			WebElement web = driver.findElement(By.xpath(
//					"//span[text()='"+currentDate+"']/../following-sibling::div//span[@class='actn-icn view']/following-sibling::span[text()='View']"));
//			web.click();
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public static void verifyEditBtn(String currentDate) {
		BaseClass.waitForElementVisibility(treatmentPlansListingPage.getAddNewBtn(), 4000);
		WebElement web = driver.findElement(By.xpath(
						"//span[text()='"+currentDate+"']/../../..//td[@class='wrd-brk-wrd ng-binding']/../../../../..//span[contains(text(),'Edit')]"));
		Assert.assertTrue(web.isDisplayed());
	}
	
	public static void clickOnEditBtn(String currentDate) {
		BaseClass.waitForModalOverlayToDisappear();
		BaseClass.waitForElementVisibility(treatmentPlansListingPage.getAddNewBtn(), 4000);
        BaseClass.waitForElementVisibility(treatmentPlansListingPage.getDateInTreatmentList(),4000);
        	WebElement web = driver.findElement(By.xpath(
					"//span[text()='"+currentDate+"']/../../..//td[@class='wrd-brk-wrd ng-binding']/../../../../..//span[contains(text(),'Edit')]"));
			BaseClass.waitForElementToBeClickable(web);
			web.click();	
         	BaseClass.waitForSpinnerToDisappear();
	}
	


//	public static void clickOnEditBtn(String currentDate) {
//		BaseClass.waitForPageLoad();
//		try {
//			Thread.sleep(4000);
//			BaseClass.waitForElementToBeClickable(treatmentPlansListingPage.getDateInTreatmentList());
//			WebElement web = driver.findElement(By.xpath(
//					"//span[text()='"+currentDate+"']/../following-sibling::div//span[@class='actn-icn edit']/following-sibling::span[text()='Edit']"));
//
//			web.click();
//			Thread.sleep(4000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public static void verifyDeleteBtn(String currentDate) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansListingPage.getDateInTreatmentList());
		WebElement web = driver.findElement(By.xpath(
				"//span[text()='"+currentDate+"']/../following-sibling::div//span[@class='actn-icn delete']/following-sibling::span[text()='Delete']"));
		Assert.assertTrue(web.isDisplayed());
	}

	public static void clickOnDeleteBtn(String currentDate) {
		
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansListingPage.getDateInTreatmentList());
		WebElement web = driver.findElement(By.xpath(
				"//span[text()='"+currentDate+"']/../following-sibling::div//span[@class='actn-icn delete']/following-sibling::span[text()='Delete']"));
		web.click();
	}

	public static void verifyPrintBtn(String currentDate) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansListingPage.getDateInTreatmentList());
		WebElement web = driver.findElement(By.xpath(
				"//span[text()='"+currentDate+"']/../following-sibling::div//span[@class='actn-icn print']/following-sibling::span[text()='Print']"));
		Assert.assertTrue(web.isDisplayed());
	}

	public static void clickOnPrintBtn(String currentDate) {
		BaseClass.waitForModalOverlayToDisappear();
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(treatmentPlansListingPage.getDateInTreatmentList(), 4000);
		BaseClass.waitForElementToBeClickable(treatmentPlansListingPage.getDateInTreatmentList());
		WebElement web = driver.findElement(By.xpath(
				"//span[text()='"+currentDate+"']/../following-sibling::div//span[@class='actn-icn print']/following-sibling::span[text()='Print']"));
		web.click();
	}

	public static void verifyHeaderInViewPopup(String header) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansListingPage.getHeaderViewPopup());
		Assert.assertTrue(treatmentPlansListingPage.getHeaderViewPopup().getText().contains(header));
	}

	public static void verifyTreatmentInViewPopup(String treatment) {
		BaseClass.waitForSpinnerToDisappear();
	    BaseClass.waitForElementVisibility(treatmentPlansListingPage.getCloseBtnViewPopup(),4000); 
		WebElement web = driver.findElement(By.xpath("//td[contains(text(),'" + treatment + "')]"));
		Assert.assertTrue(web.isDisplayed());
	}
	
	public static void clickOnCloseBtnViewPopup() {
	    BaseClass.waitForElementVisibility(treatmentPlansListingPage.getCloseBtnViewPopup(),4000); 
		BaseClass.waitForElementToBeClickable(treatmentPlansListingPage.getCloseBtnViewPopup());
		treatmentPlansListingPage.getCloseBtnViewPopup().click();
		BaseClass.waitForModalOverlayToDisappear();
		BaseClass.waitForPageToBecomeActive();
}

//	public static void clickOnCloseBtnViewPopup() {
//		try {
//			Thread.sleep(3000);
//			BaseClass.waitForElementToBeClickable(treatmentPlansListingPage.getCloseBtnViewPopup());
//			treatmentPlansListingPage.getCloseBtnViewPopup().click();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}

	public static void verifyAfterDeleteInTreatmentList(String treatment) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansListingPage.getHeaderOfPage());
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'" + treatment + "')]/../.."))
				.getAttribute("class").contains("deleted"));
	}

	public static void checkNotDeletedTreatment(String treatment) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansListingPage.getHeaderOfPage());
		Assert.assertTrue(!driver.findElement(By.xpath("//span[contains(text(),'" + treatment + "')]/../.."))
				.getAttribute("class").contains("deleted"));
	}

	public static void verifyAfterDeleteInTreatmentListViewPopup(String treatment) {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(treatmentPlansListingPage.getHeaderViewPopup(),4000);
		Assert.assertTrue(driver.findElement(By.xpath("//td[contains(text(),'" + treatment + "')]/.."))
				.getAttribute("class").contains("deleted"));
	}

	public static void notDeletedTreatmentInView(String treatment) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansListingPage.getHeaderViewPopup());
		Assert.assertTrue(!driver.findElement(By.xpath("//td[contains(text(),'" + treatment + "')]/.."))
				.getAttribute("class").contains("deleted"));
	}

	public static void verifyAfterMarked(String treatment) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansListingPage.getHeaderOfPage());
		Assert.assertTrue(driver.findElement(By.xpath(
				"//span[contains(text(),'" + treatment + "')]/preceding-sibling::span[@popover-trigger='mouseenter']"))
				.isDisplayed());
	}

	public static void couponDiscountInViewPopup(String fullname) {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(treatmentPlansListingPage.getCloseBtnViewPopup(),4000);
		BaseClass.waitForPageLoad();
		WebElement netAmount = driver.findElement(By.xpath("(//td[contains(text(),'" + fullname
				+ "')]/following-sibling::td/span[contains(@ng-class,'trviews.Treatment.fee')])[1]"));
		BaseClass.waitForElementToBeClickable(netAmount);
		String actualAmount = netAmount.getText();
		WebElement payAmount = driver.findElement(By.xpath("(//td[contains(text(),'" + fullname
				+ "')]/following-sibling::td/span[contains(@ng-class,'trviews.Treatment.fee')])[2]"));
		BaseClass.waitForElementToBeClickable(payAmount);
		String amountPay = payAmount.getText();
		WebElement couponAmount = driver.findElement(By.xpath("//td[contains(text(),'" + fullname
				+ "')]/following-sibling::td/span[contains(@ng-class,'trviews.Treatment.invoiceOldDiscount')]"));
		BaseClass.waitForElementToBeClickable(couponAmount);
		String amountCoupon = couponAmount.getText();
		float actual;
		if (actualAmount.contains(",")) {
			String[] str = actualAmount.split(",");
			String actualStr1 = str[0];
			String actualStr2 = str[1];
			int indexOfLast = actualStr2.lastIndexOf(".");
			String newString = actualStr2;
			if (indexOfLast >= 0)
				newString = actualStr2.substring(0, indexOfLast);
			String actualStr3 = actualStr1 + newString;
			actual = Float.parseFloat(actualStr3);
		} else {
			actual = Float.parseFloat(actualAmount);
		}
		float discount;
		if (amountCoupon.contains(",")) {
			String[] discountStr = amountCoupon.split(",");
			String discountStr1 = discountStr[0];
			String discountStr2 = discountStr[1];
			int indexOfLast1 = discountStr2.lastIndexOf(".");
			String newString1 = discountStr2;
			if (indexOfLast1 >= 0)
				newString1 = discountStr2.substring(0, indexOfLast1);
			String discountStr3 = discountStr1 + newString1;
			discount = Float.parseFloat(discountStr3);
		} else {
			discount = Float.parseFloat(amountCoupon);
		}
		float AmountPayValue;
		if (amountPay.contains(",")) {
			String[] effectivePriceStr = amountPay.split(",");
			String effectivePriceStrStr1 = effectivePriceStr[0];
			String effectivePriceStrStr2 = effectivePriceStr[1];
			int indexOfLast1 = effectivePriceStrStr2.lastIndexOf(".");
			String newString1 = effectivePriceStrStr2;
			if (indexOfLast1 >= 0)
				newString1 = effectivePriceStrStr2.substring(0, indexOfLast1);
			String effectivePriceStr3 = effectivePriceStrStr1 + newString1;
			AmountPayValue = Float.parseFloat(effectivePriceStr3);
		} else {
			AmountPayValue = Float.parseFloat(amountPay);
		}
		float effectivePrice = actual - discount;
		Assert.assertTrue(AmountPayValue == effectivePrice);
	}

	public static void verifyMarkedMsg() {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.softAssert().assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Selected treatment(s) marked as patient preferred!')]")).isDisplayed());
	}

	public static void selectTreatmentInTreatmentListPage(String treatment) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansListingPage.getHeaderOfPage());
		try {
			Thread.sleep(1000);
			List<WebElement> web = driver.findElements(By.xpath("//span[contains(text(),'" + treatment + "')]/../preceding-sibling::td//label"));
			for(int i=0;i<web.size();i++) {
				web.get(i).click();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void verifyUnbookBtn(String currentDate) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansListingPage.getDateInTreatmentList());
		WebElement web = driver.findElement(
				By.xpath("//span[text()='"+currentDate+"']/../following-sibling::div//span[@class='trtNewIcons trt_unbook_icn']/following-sibling::span[text()='Un-Mark']"));
		Assert.assertTrue(web.isDisplayed());
	}
	
	public static void checkedWithoutTreatmentStart() {
	        BaseClass.waitForElementVisibility(treatmentPlansListingPage.getSelectTreatmentMessage(),4000);
			Assert.assertTrue(checkedWebElementDisplayed(treatmentPlansListingPage.getSelectTreatmentMessage()));
			BaseClass.waitForElementToDisappear((By.xpath("//span[contains(text(),'Please select treatment(s) for starting Workdone')]")));

	}

//	public static void checkedWithoutTreatmentStart() {
//		BaseClass.waitForPageLoad();
//		try {
//			Thread.sleep(1500);
//			Assert.assertTrue(checkedWebElementDisplayed(treatmentPlansListingPage.getSelectTreatmentMessage()));
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public static void verifyDeleteSuccessMsg() {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(1500);
			Assert.assertTrue(checkedWebElementDisplayed(treatmentPlansListingPage.getDeleteSuccessMsg()));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void clickOnYesBtnForDelete() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansListingPage.getYesBtnForDelete());
		treatmentPlansListingPage.getYesBtnForDelete().click();
	}

	public static void clickOnSaveBtnInDoctorList() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansListingPage.getSaveBtnInDoctorList());
		try {
			treatmentPlansListingPage.getSaveBtnInDoctorList().click();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void verifyHeaderOfDoctorListPopup() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansListingPage.getHeaderOfDoctorLsit());
		Assert.assertTrue(treatmentPlansListingPage.getHeaderOfDoctorLsit().getText().contains("Doctors"));
	}

	public static void selectDoctor(String doctorName) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansListingPage.getHeaderOfDoctorLsit());
		WebElement web = driver.findElement(By.xpath("//label[contains(text(),'" + doctorName + "')]"));
		web.click();
	}

	public static void actionBtn() {
		   BaseClass.waitForSpinnerToDisappear();
		   BaseClass.waitForElementToDisappear((By.xpath("//span[contains(text(),'Treatment plan copied successfully!'])")));
			List<WebElement> web = driver
					.findElements(By.xpath("//div[@id='treatmentlistingtable']//a[contains(@class,'btn btn-wrp')]"));
			BaseClass.visibilityOfListLocated(web);
			for(int i=0;i<web.size();i++){
			boolean result = web.get(i).isDisplayed();
			Assert.assertTrue(result);
		} 
	}

	public static void afterCopyPlan() {
		BaseClass.waitForPageLoad();
		List<WebElement> web = driver
				.findElements(By.xpath("//div[contains(@class,'fnt_avgR dateClnc')]/span[@class='ng-binding']"));
		for (int i=0;web.size()>i;i++){
			Assert.assertTrue(web.get(i).getText().contains("Plan 1")||web.get(i).getText().contains("Plan 2"));
		}
	}

	public static void verifyCouponImpactInMainList(String fullname) {
		BaseClass.waitForModalOverlayToDisappear();
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(treatmentPlansListingPage.getAddNewBtn(), 4000);
		WebElement netCost = driver.findElement(By.xpath("(//span[contains(text(),'"+fullname+"')]/../..//span[@class='ng-binding'])[3]"));
		BaseClass.waitForElementToBeClickable(netCost);
		String ActualPrice = netCost.getText();
		System.out.println("The amount Actuual is"+ActualPrice);
		WebElement couponValue = driver.findElement(By.xpath("//span[contains(text(),'"+fullname+"')]/../following-sibling::td/span[contains(@ng-class,'tretListChild.Treatment.invoiceOldDiscount')]"));
		BaseClass.waitForElementToBeClickable(couponValue);
		String discountPrice = couponValue.getText();
		System.out.println("The amount Discount is"+discountPrice);
		WebElement AmountPay = driver.findElement(By.xpath("(//span[contains(text(),'" + fullname
				+ "')]/../following-sibling::td/span[contains(@ng-class,'tretListChild.Treatment.fee')])[1]"));
		BaseClass.waitForElementToBeClickable(AmountPay);
		String effectivePrice = AmountPay.getText();
		float actual;
		if (ActualPrice.contains(",")) {
			String[] str = ActualPrice.split(",");
			String actualStr1 = str[0];
			String actualStr2 = str[1];
			int indexOfLast = actualStr2.lastIndexOf(".");
			String newString = actualStr2;
			if (indexOfLast >= 0)
				newString = actualStr2.substring(0, indexOfLast);
			String actualStr3 = actualStr1 + newString;
			actual = Float.parseFloat(actualStr3);
		} else {
			actual = Float.parseFloat(ActualPrice);
		}
		float discount;
		if (discountPrice.contains(",")) {
			String[] discountStr = discountPrice.split(",");
			String discountStr1 = discountStr[0];
			String discountStr2 = discountStr[1];
			int indexOfLast1 = discountStr2.lastIndexOf(".");
			String newString1 = discountStr2;
			if (indexOfLast1 >= 0)
				newString1 = discountStr2.substring(0, indexOfLast1);
			String discountStr3 = discountStr1 + newString1;
			discount = Float.parseFloat(discountStr3);
		} else {
			discount = Float.parseFloat(discountPrice);
		}
		float AmountPayValue;
		if (effectivePrice.contains(",")) {
			String[] effectivepriceStr = effectivePrice.split(",");
			String effectivePriceStrStr1 = effectivepriceStr[0];
			String effectivePriceStrStr2 = effectivepriceStr[1];
			int indexOfLast1 = effectivePriceStrStr2.lastIndexOf(".");
			String newString1 = effectivePriceStrStr2;
			if (indexOfLast1 >= 0)
				newString1 = effectivePriceStrStr2.substring(0, indexOfLast1);
			String effectivePriceStr3 = effectivePriceStrStr1 + newString1;
			AmountPayValue = Float.parseFloat(effectivePriceStr3);
		} else {
			AmountPayValue = Float.parseFloat(effectivePrice);
		}
		float effecttivePrice = actual - discount;
		System.out.println("The Amount Pay Value "+AmountPayValue);
		System.out.println("The Discount Pay Value "+discount);
		System.out.println("The Actual Pay Value "+actual);
		System.out.println("The Effective Value "+effecttivePrice);
		Assert.assertTrue(AmountPayValue == effecttivePrice);
	}

	private static boolean checkedWebElementDisplayed(WebElement webElement) {
		return (webElement.isDisplayed());
	}
}
