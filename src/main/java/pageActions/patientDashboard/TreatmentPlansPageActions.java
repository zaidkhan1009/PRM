package pageActions.patientDashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import base.BaseClass;
import pages.patientDashboard.OralExamsPage;
import pages.patientDashboard.TreatmentPlansPage;
import java.util.List;

public class TreatmentPlansPageActions extends BaseClass{

	static TreatmentPlansPage treatmentPlansPage = PageFactory.initElements(driver, TreatmentPlansPage.class);
	static OralExamsPage oralExamsPage  = PageFactory.initElements(driver, OralExamsPage.class);
	
	public static void startCheckBoxInputListNotPresent() {
		BaseClass.waitForSpinnerToDisappear();
		if(treatmentPlansPage.getCheckBoxInputList().size() > 0) {
			System.out.println("Patient alreday has/have"+treatmentPlansPage.getCheckBoxInputList().size()+"old treatmentPlansPage.getTreatments()");
			Reporter.log("Patient alreday has/have\"+treatmentPlansPage.getCheckBoxInputList().size()+\"old treatmentPlansPage.getTreatments()");
		}
		else {
			Assert.assertEquals(treatmentPlansPage.getCheckBoxInputList().size(), 0);
		}
	}
	
	public static void selectedTreamentInIputList(String fullName) {
		BaseClass.waitForPageLoad();
		int j = 0;
		for (int i = 0; treatmentPlansPage.getTreatmentsInputList().size() > i; i++) {
			if (treatmentPlansPage.getTreatmentsInputList().get(i).getText().contains(fullName)) {
				if (!treatmentPlansPage.getTreatmentsDetail().get(i).getAttribute("class").contains("deleted")) {
					Assert.assertTrue(checkedWebElementDisplayed(treatmentPlansPage.getTreatmentsInputList().get(i))
							&& checkedWebElementDisplayed(treatmentPlansPage.getTreatmentTypeInputList().get(i - j))
							&& (treatmentPlansPage.getUnitPriceNetPriceInputlist().size() == treatmentPlansPage.getTreatmentsInputList().size() * 2)
							&& checkedWebElementDisplayed(treatmentPlansPage.getDiscountTypeInputList().get(i - j))
							&& checkedWebElementDisplayed(treatmentPlansPage.getDiscountInputList().get(i - j))
							&& checkedWebElementDisplayed(treatmentPlansPage.getAmountPayInputList().get(i))
							&& checkedWebElementDisplayed(treatmentPlansPage.getCouponsInputList().get(i - j))
							&& checkedWebElementDisplayed(treatmentPlansPage.getSingleTrtDeleteInputList().get(i - j)));
					break;
				}
			} else {
				j++;
			}
		}
	}

//	public static void selectedTreamentInIputList(String fullName) {
//		BaseClass.waitForPageLoad();
//		int j = 0;
//		for (int i = 0; treatmentPlansPage.getTreatmentsInputList().size() > i; i++) {
//			if (treatmentPlansPage.getTreatmentsInputList().get(i).getText().contains(fullName)) {
//				if (!treatmentPlansPage.getTreatmentsDetail().get(i).getAttribute("class").contains("deleted")) {
//					Assert.assertTrue(checkedWebElementDisplayed(treatmentPlansPage.getTreatmentsInputList().get(i))
//							&& checkedWebElementDisplayed(treatmentPlansPage.getCheckBoxInputList().get(i - j))
//							&& checkedWebElementDisplayed(treatmentPlansPage.getTreatmentTypeInputList().get(i - j))
//							&& (treatmentPlansPage.getUnitPriceNetPriceInputlist().size() == treatmentPlansPage.getTreatmentsInputList().size() * 2)
//							&& checkedWebElementDisplayed(treatmentPlansPage.getDiscountTypeInputList().get(i - j))
//							&& checkedWebElementDisplayed(treatmentPlansPage.getDiscountInputList().get(i - j))
//							&& checkedWebElementDisplayed(treatmentPlansPage.getAmountPayInputList().get(i))
//							&& checkedWebElementDisplayed(treatmentPlansPage.getCouponsInputList().get(i - j))
//							&& checkedWebElementDisplayed(treatmentPlansPage.getSingleTrtDeleteInputList().get(i - j)));
//					break;
//				}
//			} else {
//				j++;
//			}
//		}
//	}

	public static void selectTreatmentInputList(String treatment) {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(5000);
			WebElement web = driver.findElement(
					By.xpath("//*[text()[contains(.,'" + treatment + "')]]/../preceding-sibling::td//label"));
			web.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void setCovidUpdateAlert() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getCovidUpdateAlert());
		Assert.assertTrue(checkedWebElementDisplayed(treatmentPlansPage.getCovidUpdateAlert()));
	}
	
	
	public static void checkedInputListDataName() {
		    BaseClass.waitForSpinnerToDisappear();
			BaseClass.WaitTillElementIsPresent(treatmentPlansPage.getSourceInputList());
			Assert.assertTrue(checkedWebElementDisplayed(treatmentPlansPage.getSourceInputList()) && checkedWebElementDisplayed(treatmentPlansPage.getStartInputList())
					&& checkedWebElementDisplayed(treatmentPlansPage.getTreatmentInputList()) && checkedWebElementDisplayed(treatmentPlansPage.getTypeInputList())
					&& checkedWebElementDisplayed(treatmentPlansPage.getUnitCostInputList()) && checkedWebElementDisplayed(treatmentPlansPage.getNetAmtInputList())
					&& checkedWebElementDisplayed(treatmentPlansPage.getCouponInputList()) && checkedWebElementDisplayed(treatmentPlansPage.getCouponBasisInputList())
					&& checkedWebElementDisplayed(treatmentPlansPage.getActionInputList()));
	}

//	public static void checkedInputListDataName() {
//		BaseClass.waitForPageLoad();
//		try {
//			Thread.sleep(3000);
//			BaseClass.WaitTillElementIsPresent(treatmentPlansPage.getSourceInputList());
//			Assert.assertTrue(checkedWebElementDisplayed(treatmentPlansPage.getSourceInputList()) && checkedWebElementDisplayed(treatmentPlansPage.getStartInputList())
//					&& checkedWebElementDisplayed(treatmentPlansPage.getTreatmentInputList()) && checkedWebElementDisplayed(treatmentPlansPage.getTypeInputList())
//					&& checkedWebElementDisplayed(treatmentPlansPage.getUnitCostInputList()) && checkedWebElementDisplayed(treatmentPlansPage.getNetAmtInputList())
//					&& checkedWebElementDisplayed(treatmentPlansPage.getCouponInputList()) && checkedWebElementDisplayed(treatmentPlansPage.getCouponBasisInputList())
//					&& checkedWebElementDisplayed(treatmentPlansPage.getActionInputList()));
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public static void checkEditSaveInputList(String teethNo) {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedWebElementDisplayed(driver
				.findElement(By.xpath("//table[@id='treatmentplanedittable']//span[text()='" + teethNo
						+ "']/../following-sibling::td//a[contains(@ng-click,'openTreatmentEditPopup')]")))
				&& checkedWebElementDisplayed(treatmentPlansPage.getSaveBtnOnInputList()));
	}

	public static void checkDeleteInputList(String teethNo) {
		BaseClass.waitForPageLoad();
		Assert.assertTrue(checkedWebElementDisplayed(driver
				.findElement(By.xpath("//table[@id='treatmentplanedittable']//span[text()='" + teethNo
						+ "']/../following-sibling::td//a[contains(@ng-click,'treatmentToothGroupDelete')]")))
				&& checkedWebElementDisplayed(treatmentPlansPage.getSaveBtnOnInputList()));
	}

	public static void clickOnCreatebtn() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getCreatBtn());
		treatmentPlansPage.getCreatBtn().click();
	}

	public static void verifyHeader() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getHeader());
		Assert.assertTrue(checkedWebElementDisplayed(treatmentPlansPage.getHeader()));
	}

	public static void allTeethByQuadrantAndByArchIsPresent() {
//		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getAllTeethBtn());
		Assert.assertTrue(checkedWebElementDisplayed(treatmentPlansPage.getAllTeethBtn()) && checkedWebElementDisplayed(treatmentPlansPage.getByArchBtn())
				&& checkedWebElementDisplayed(treatmentPlansPage.getByQuadrantBtn()));
	}

	public static void allTeethAndByQuadrantIsPresent() {
//		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getAllTeethBtn());
		Assert.assertTrue(checkedWebElementDisplayed(treatmentPlansPage.getAllTeethBtn()) && checkedWebElementDisplayed(treatmentPlansPage.getByQuadrantBtn()));
	}

	public static void verifyNoRecordMsg() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getNoRecordMsg());
		Assert.assertTrue(treatmentPlansPage.getNoRecordMsg().getText().contains("No Record Found"));
	}

	public static void verifyCreateBtnIsPresent() {
//		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getCreatBtn());
		Assert.assertTrue(checkedWebElementDisplayed(treatmentPlansPage.getCreatBtn()));
	}

	public static void verifyProductAddBtnIsPresent() {
//		BaseClass.waitForPageLoad();
		BaseClass.waitForElementVisibility(treatmentPlansPage.getProductBtn(), 4000);
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getProductBtn());
		Assert.assertTrue(checkedWebElementDisplayed(treatmentPlansPage.getProductBtn()));
	}

	public static void clickOnYes() {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		treatmentPlansPage.getYesOnMultiselect().click();
	}
	
	public static void clickOnNewTeethBtn() {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForPageToBecomeActive();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getNewTeeth());
		BaseClass.waitForModalOverlayToDisappear();
		treatmentPlansPage.getNewTeeth().click();
	}
	
	public static void clickOnFindingsBtn() {
		BaseClass.waitForPageToBecomeActive();
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(treatmentPlansPage.getFindings(),4000);
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getFindings());
		treatmentPlansPage.getFindings().click();
	}

//	public static void clickOnFindingsBtn() {
//		BaseClass.waitForPageLoad();
//		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getFindings());
//		try {
//			Thread.sleep(4000);
//			treatmentPlansPage.getFindings().click();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public static void clickOnTreatmentGroups() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getTreatmentGroups());
		treatmentPlansPage.getTreatmentGroups().click();
	}
	
	public static void clickOnOralExamBtn() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getOralExamBtn());
		treatmentPlansPage.getOralExamBtn().click();
	}

//	public static void clickOnOralExamBtn() {
//		BaseClass.waitForPageLoad();
//		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getOralExamBtn());
//		try {
//			treatmentPlansPage.getOralExamBtn().click();
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}

	public static void clickOnConsultationXRays() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getConsultation_XRays());
		treatmentPlansPage.getConsultation_XRays().click();
	}

	public static void clickOnEndo() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getEndo());
		treatmentPlansPage.getEndo().click();
	}

	public static void clickOnExtractions() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getExtractions());
		treatmentPlansPage.getExtractions().click();
	}

	public static void clickOnMinorOralSurgery() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getMinorOralSurgery());
		treatmentPlansPage.getMinorOralSurgery().click();
	}

	public static void clickOnProsthoExceptCrowns() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getProsthoExceptCrowns());
		treatmentPlansPage.getProsthoExceptCrowns().click();
	}

	public static void clickOnCrowns() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getCrowns());
		treatmentPlansPage.getCrowns().click();
	}

	public static void clickOnImplantCrowns() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getImplantCrowns());
		treatmentPlansPage.getImplantCrowns().click();
	}

	public static void clickOnOrtho() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getOrtho());
		treatmentPlansPage.getOrtho().click();
	}

	public static void clickOnPerio() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getPerio());
		treatmentPlansPage.getPerio().click();
	}

	public static void clickOnAlignersLMB() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getAlignersLMB());
		treatmentPlansPage.getAlignersLMB().click();
	}

	public static void clickOnAlignersOthers() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getAlignersOthers());
		treatmentPlansPage.getAlignersOthers().click();
	}

	public static void clickOnPedo() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getPedo());
		treatmentPlansPage.getPedo().click();
	}

	public static void clickOnImplantsAB() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getImplantsAB());
		treatmentPlansPage.getImplantsAB().click();
	}

	public static void clickOnImplantsNobel() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getImplantsNobel());
		treatmentPlansPage.getImplantsNobel().click();
	}

	public static void clickOnImplantOthers() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getImplantOthers());
		treatmentPlansPage.getImplantOthers().click();
	}

	public static void clickOnBoneGraftAndMembranes() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getBoneGraftAndMembranesPRF());
		treatmentPlansPage.getBoneGraftAndMembranesPRF().click();
	}

	public static void clickOnLasers() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getLasers());
		treatmentPlansPage.getLasers().click();
	}

	public static void clickOnIpCDOPBank() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getIp_CDOP_Bank());
		treatmentPlansPage.getIp_CDOP_Bank().click();
	}

	public static void clickOnMembership() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getMembership());
		treatmentPlansPage.getMembership().click();
	}

	public static void clickOnOthers() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getOthers());
		treatmentPlansPage.getOthers().click();
	}

	public static void clickOnSearchField(String treatName) {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(3000);
			treatmentPlansPage.getSearchBox().sendKeys(treatName);
			treatmentPlansPage.getSearchBox().click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void verifyTreatments() {
    BaseClass.waitForSpinnerToDisappear();
	BaseClass.visibilityOfListLocated(treatmentPlansPage.getTreatments());
	Assert.assertTrue(treatmentPlansPage.getTreatments().size() > 0);
}
	
	

//	public static void verifyTreatments() {
//		BaseClass.waitForPageLoad();
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		BaseClass.visibilityOfListLocated(treatmentPlansPage.getTreatments());
//		Assert.assertTrue(treatmentPlansPage.getTreatments().size() > 0);
//	}

	public static void checkWebElementsOfPopup() {
//		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getSearchBox());
		Assert.assertTrue(checkedWebElementDisplayed(treatmentPlansPage.getTreatmentGroups()) && checkedWebElementDisplayed(treatmentPlansPage.getSearchBox())
				&& checkedWebElementDisplayed(treatmentPlansPage.getSaveBtn()) && checkedWebElementDisplayed(treatmentPlansPage.getCloseBtn())
				&& treatmentPlansPage.getTitleOfPopup().getText().contains("Findings"));
	}
	
	public static void saveTreatment() {
		BaseClass.waitForElementVisibility(treatmentPlansPage.getSaveBtn(),4000);
		treatmentPlansPage.getSaveBtn().click();
		BaseClass.waitForModalOverlayToDisappear();
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(treatmentPlansPage.getTypeInputList(), 4000);
	}
	
	public static void saveTreatmentWithMessage() {
		BaseClass.waitForElementVisibility(treatmentPlansPage.getSaveBtn(),4000);
		treatmentPlansPage.getSaveBtn().click();
	}

//	public static void saveTreatment() {
//		BaseClass.waitForPageLoad();
//		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getSaveBtn());
//		treatmentPlansPage.getSaveBtn().click();
//		BaseClass.waitForPageLoad();
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public static void closeTreatmentPopup() {
			treatmentPlansPage.getCloseBtn().click();
			BaseClass.waitForSpinnerToDisappear();
	}

//	public static void closeTreatmentPopup() {
//		try {
//			Thread.sleep(1500);
//			BaseClass.waitForElementToBeClickable(treatmentPlansPage.getCloseBtn());
//			treatmentPlansPage.getCloseBtn().click();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
	
	public static void verifySeletecdTeethOnPopup(String teeth) {
		BaseClass.waitForSpinnerToDisappear();
		try {
			BaseClass.waitForElementToBeClickable(treatmentPlansPage.getTitleOfPopup());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(checkedWebElementDisplayed(driver
					.findElement(By.xpath("//div[@id='tgrouppopupheader']//span[contains(text(),'" + teeth + "')]")))
					&& treatmentPlansPage.getTitleOfPopup().getText().contains("Findings"));
	}

//	public static void verifySeletecdTeethOnPopup(String teeth) {
//		BaseClass.waitForPageLoad();
//		try {
//			Thread.sleep(5000);
//			BaseClass.waitForElementToBeClickable(treatmentPlansPage.getTitleOfPopup());
//			Assert.assertTrue(checkedWebElementDisplayed(driver
//					.findElement(By.xpath("//div[@id='tgrouppopupheader']//span[contains(text(),'" + teeth + "')]")))
//					&& treatmentPlansPage.getTitleOfPopup().getText().contains("Findings"));
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}

	public static void deselectedTreatment(String shortNameTreatment) {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(1000);
			List<WebElement> web = driver.findElements(By.xpath("//div[@class='content-trtmnt']"));
			List<WebElement> web1 = driver.findElements(By.xpath("//div[@class='content-trtmnt']"));
			for (int i = 0; web.size() > i; i++) {
				if (web.get(i).getText().contains(shortNameTreatment)) {
					Assert.assertFalse(web1.get(i).getAttribute("class").contains("selected"));
				} else {
					continue;
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void verifyWithoutTreatmentMsg() {
		Assert.assertTrue(checkedWebElementDisplayed(treatmentPlansPage.getWithoutTreatmentMsg()));
	}

//	public static void verifyWithoutTreatmentMsg() {
//		BaseClass.waitForPageLoad();
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Assert.assertTrue(checkedWebElementDisplayed(treatmentPlansPage.getWithoutTreatmentMsg()));
//	}

	public static void clickOnSaveOralBtn() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getSaveBtnOralExam());
		treatmentPlansPage.getSaveBtnOralExam().click();
	}

	public static void selectedSoftTissueProvisionalDisplayedBelow() {
		
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getToothSitePerio());
		Assert.assertTrue(treatmentPlansPage.getProvisionalRemoveBtnSoftTissue().size() == 1 || treatmentPlansPage.getProvisionalRemoveBtnSoftTissue().size() == 2
				|| treatmentPlansPage.getProvisionalRemoveBtnSoftTissue().size() == 3 || treatmentPlansPage.getProvisionalRemoveBtnSoftTissue().size() == 4
				|| treatmentPlansPage.getProvisionalRemoveBtnSoftTissue().size() == 5 || treatmentPlansPage.getProvisionalRemoveBtnSoftTissue().size() == 6
				|| treatmentPlansPage.getProvisionalRemoveBtnSoftTissue().size() == 7 || treatmentPlansPage.getProvisionalRemoveBtnSoftTissue().size() == 8
				|| treatmentPlansPage.getProvisionalRemoveBtnSoftTissue().size() == 9 || treatmentPlansPage.getProvisionalRemoveBtnSoftTissue().size() == 10);
	}

	public static void clickOnSoftTissueProvisinals() {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(2000);
			driver
					.findElement(By.xpath("(//div[contains(@ng-click,'softDiagno.ProvisionalDiagnostic.bsId')])[1]"))
					.click();
		} catch (StaleElementReferenceException | InterruptedException e) {
			driver
					.findElement(By.xpath("(//div[contains(@ng-click,'softDiagno.ProvisionalDiagnostic.bsId')])[1]"))
					.click();
		}
	}

	public static void provisionalIsSelectedOfSoftTissue(String name) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getToothSitePerio());
		Assert.assertTrue(driver
				.findElement(By.xpath("//div[contains(@ng-click,'addToothStissueItem')]//h5[text()='" + name + "']"))
				.getAttribute("class").contains("selected"));
	}

	public static void clickOnLip() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getLip());
		treatmentPlansPage.getLip().click();
	}

	public static void clickOnCheek() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getCheek());
		treatmentPlansPage.getCheek().click();
	}

	public static void clickOnTongue() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getTongue());
		treatmentPlansPage.getTongue().click();
	}

	public static void clickOnFloorOfMouth() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getFloorOfMouth());
		treatmentPlansPage.getFloorOfMouth().click();
	}

	public static void clickOnPalate() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getPalate());
		treatmentPlansPage.getPalate().click();
	}

	public static void clickOnGingiva() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getGingiva());
		treatmentPlansPage.getGingiva().click();
	}

	public static void clickOnVestibule() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getVestibule());
		treatmentPlansPage.getVestibule().click();
	}

	public static void clickOnFrenum() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getFrenum());
		treatmentPlansPage.getFrenum().click();
	}

	public static void clickOnSalivaryGland() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getSalivaryGland());
		treatmentPlansPage.getSalivaryGland().click();
	}

	public static void clickOnLymphNodes() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getLymphNodes());
		treatmentPlansPage.getLymphNodes().click();
	}

	public static void clickOnCloseBtnOralExam() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getCloseBtnOralExam());
		treatmentPlansPage.getCloseBtnOralExam().click();
	}

	public static void clickOnSelectedTreatment() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getSelectedTreatment());
		treatmentPlansPage.getSelectedTreatment().click();
	}

	public static void verifyIoparBtn() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getIOPARBtn());
		Assert.assertTrue(checkedWebElementDisplayed(treatmentPlansPage.getIOPARBtn()));
	}

	public static void verifyIOPARNotes() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getIOPARNotes());
		Assert.assertTrue(
				checkedWebElementDisplayed(treatmentPlansPage.getIOPARNotes()) && treatmentPlansPage.getIOPARNotes().getAttribute("maxlength").contains("768"));
	}

	public static void clickOnIOPARBtn() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getIOPARBtn());
		treatmentPlansPage.getIOPARBtn().click();
	}

	public static void verifyProvisinals() {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(treatmentPlansPage.getProvisinals().size() > 0);
	}

	public static void removeTreatmentFromSelectedTreatmentTab(String treatment) {
		BaseClass.waitForPageLoad();
		WebElement web = driver.findElement(By.xpath(
				"//span[contains(text(),'" + treatment + "')]/following-sibling::div//span[@class='deletebtn']"));
		BaseClass.waitForElementToBeClickable(web);
		web.click();
	}
	
	public static void clickOnSaveBtnTreatmentInputList() {
		BaseClass.waitForElementVisibility(treatmentPlansPage.getSaveBtnOnInputList(),4000);
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getSaveBtnOnInputList());
		treatmentPlansPage.getSaveBtnOnInputList().click();
		BaseClass.waitForSpinnerToDisappear();
	}

//	public static void clickOnSaveBtnTreatmentInputList() {
//		BaseClass.waitForPageLoad();
//		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getSaveBtnOnInputList());
//		try {
//			Thread.sleep(2500);
//			treatmentPlansPage.getSaveBtnOnInputList().click();
//			Thread.sleep(2500);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public static void clickOnEditBtnTreatmentInputList() {
		BaseClass.waitForModalOverlayToDisappear();
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(treatmentPlansPage.getEditBtnTreatmentInputList(),4000);
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getEditBtnTreatmentInputList());
		treatmentPlansPage.getEditBtnTreatmentInputList().click();
	}

	public static void verifyDeleteSuccessMsg() {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(1000);
			Assert.assertTrue(checkedWebElementDisplayed(treatmentPlansPage.getDeleteSuccessMessage()));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void clickOnYesForDelete() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getYesForDelete());
		treatmentPlansPage.getYesForDelete().click();
	}
	
	public static void clickOnTreatments(String shortNameTreatment) {
		BaseClass.waitForSpinnerToDisappear();
			List<WebElement> web = driver.findElements(By.xpath("//div[@class='content-trtmnt']"));
			for (int i = 0; web.size() > i; i++) {
				if (web.get(i).getText().contains(shortNameTreatment)) {
					web.get(i).click();
				} else {
					continue;
				}
			}
	}

//	public static void clickOnTreatments(String shortNameTreatment) {
//		BaseClass.waitForPageLoad();
//		try {
//			Thread.sleep(1500);
//			List<WebElement> web = driver.findElements(By.xpath("//div[@class='content-trtmnt']"));
//			for (int i = 0; web.size() > i; i++) {
//				if (web.get(i).getText().contains(shortNameTreatment)) {
//					web.get(i).click();
//				} else {
//					continue;
//				}
//			}
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public static void checkTreatmentsIsSelectedAsBridgeable(String treatment) {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement ele = driver.findElement(By.xpath("//span[contains(normalize-space(),'"+treatment+"')]"));
		Assert.assertTrue(checkedWebElementDisplayed(ele));
	}

	public static void clickPartOfBridge() {
		BaseClass.waitForPageLoad();
		treatmentPlansPage.getPartOfBridgeChkBx().click();

	}

	public static void deleteTreatment(String treatmentName) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getFindings());
		for (int i = 0; treatmentPlansPage.getTreatmentsInputList().size() > i; i++) {
			if (treatmentPlansPage.getTreatmentsInputList().get(i).getText().contains(treatmentName)) {
				treatmentPlansPage.getSingleTrtDeleteInputList().get(i).click();
			} else {
				continue;
			}
		}
	}

	public static void verifyAfterDelete(String treatment) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getFindings());
		for (int i = 0; treatmentPlansPage.getTreatmentsInputList().size() > i; i++) {
			if (treatmentPlansPage.getTreatmentsInputList().get(i).getText().contains(treatment)) {
				Assert.assertTrue(treatmentPlansPage.getTreatmentsDetail().get(i).getAttribute("class").contains("deleted"));
				break;
			} else {
				continue;
			}
		}
	}

	public static void clickOnProvisionals(String provisinals) {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(2000);
			for (int i = 0; treatmentPlansPage.getProvisional().size() > i; i++) {
				if (treatmentPlansPage.getProvisional().get(i).getText().contains(provisinals)) {
					treatmentPlansPage.getProvisional().get(i).click();
				} else {
					continue;
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void verifySelectedProvisinalsIntreatmentPopup(String provisinals) {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(1000);
			WebElement web = driver
					.findElement(By.xpath("//a/span[contains(text(),'" + provisinals + "')]"));
			BaseClass.waitForElementToBeClickable(web);
			Assert.assertTrue(checkedWebElementDisplayed(web));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void clickOnBuccalForMultipleTeeth() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(treatmentPlansPage.getBuccal());
		treatmentPlansPage.getBuccal().click();
	}

	public static void verifyToothOnFinding(String teethNo) {
		BaseClass.waitForPageLoad();
		String str = "toothBind tooth" + teethNo;
		WebElement web = driver.findElement(By.xpath("//div[contains(@class,'" + str + "')]"));
		BaseClass.waitForElementToBeClickable(web);
		Assert.assertTrue(checkedWebElementDisplayed(web));
	}

	public static void verifyTissuesInFinding(String teethNo, String Tissues) {
		BaseClass.waitForPageLoad();
		String str = "toothBind tooth" + teethNo;
		WebElement web = driver
				.findElement(By.xpath("//div[contains(@class,'" + str
						+ "')]//ancestor::div[@id='softTissue_left']/following-sibling::div//span[contains(text(),'"
						+ Tissues + "')]"));
		BaseClass.waitForElementToBeClickable(web);
		Assert.assertTrue(checkedWebElementDisplayed(web));
	}

	public static void verifyProvisionalsInFinding(String teethNo, String provisinals) {
		BaseClass.waitForPageLoad();
		String str = "toothBind tooth" + teethNo;
		WebElement web = driver
				.findElement(By.xpath("//div[contains(@class,'" + str
						+ "')]//ancestor::div[@id='softTissue_left']/following-sibling::div//span[contains(text(),'"
						+ provisinals + "')]"));
		BaseClass.waitForElementToBeClickable(web);
		Assert.assertTrue(checkedWebElementDisplayed(web));
	}

	public static void verifySelectBtn(String teethNo) {
		BaseClass.waitForPageLoad();
		String str = "toothBind tooth" + teethNo;
		WebElement web = driver.findElement(By.xpath("//div[contains(@class,'" + str
				+ "')]//ancestor::div[@id='softTissue_left']/following-sibling::div//span[contains(@class,'inputSelectionView chkB')]"));
		BaseClass.waitForElementToBeClickable(web);
		Assert.assertTrue(checkedWebElementDisplayed(web));
	}

	public static void selectTeethInFindings(String teethNo) {
		BaseClass.waitForPageLoad();
		String str = "toothBind tooth" + teethNo;
		WebElement web = driver.findElement(By.xpath("//div[contains(@class,'" + str
				+ "')]//ancestor::div[@id='softTissue_left']/following-sibling::div//b[contains(text(),'Select')]"));
		BaseClass.waitForElementToBeClickable(web);
		BaseClass.executeScript(web);
	}
	
	public static void intiallyBothPriceSameDiscount(String fullname) {
		BaseClass.waitForPageLoad();
		String netAmountPrice, amountPayablePrice;
		for (int i = 0; treatmentPlansPage.getTreatmentsInputList().size() > i; i++) {
			if (treatmentPlansPage.getTreatmentsInputList().get(i).getText().contains(fullname)) {
				Select select = new Select(treatmentPlansPage.getTreatmentTypeInputList().get(i));
				netAmountPrice = treatmentPlansPage.getUnitPriceNetPriceInputlist().get(i * 2).getText();
				amountPayablePrice = treatmentPlansPage.getAmountPayInputList().get(i).getText();
				Assert.assertTrue(select.getFirstSelectedOption().getText().contains("Recommended")
						&& netAmountPrice.equals(amountPayablePrice));
				break;
			}
		}
	}
	

//	public static void intiallyBothPriceSameDiscount(String fullname) {
//		BaseClass.waitForPageLoad();
//		String netAmountPrice, amountPayablePrice;
//		for (int i = 0; treatmentPlansPage.getTreatmentsInputList().size() > i; i++) {
//			if (treatmentPlansPage.getTreatmentsInputList().get(i).getText().contains(fullname)) {
//				Select select = new Select(treatmentPlansPage.getTreatmentTypeInputList().get(i));
//				netAmountPrice = treatmentPlansPage.getUnitPriceNetPriceInputlist().get(i * 2).getText();
//				amountPayablePrice = treatmentPlansPage.getAmountPayInputList().get(i).getText();
//				Select sel = new Select(treatmentPlansPage.getDiscountTypeInputList().get(i));
//     			String discountValue = discountValueInputList.get(i).getText();
//				Assert.assertTrue(select.getFirstSelectedOption().getText().contains("Recommended")
//						&& netAmountPrice.equals(amountPayablePrice)
//						&& sel.getFirstSelectedOption().getText().contains("%") && discountValue.contains("0.00"));
//				break;
//			}
//		}
//	}

	public static void couponBasis(String fullname) {
		BaseClass.waitForPageLoad();
		for (int i = 0; treatmentPlansPage.getTreatmentsInputList().size() > i; i++) {
			if (treatmentPlansPage.getTreatmentsInputList().get(i).getText().contains(fullname)) {
				BaseClass.selectFromDropDownByIndex(treatmentPlansPage.getCouponsInputList().get(i), 2);
				break;
			}
		}
	}

	public static void checkFunctionalityOfPercentageDis(String fullname, float inPercentage) {
		BaseClass.waitForPageLoad();
		String actualPrice, amountPayablePrice;
		float actual;
		for (int i = 0; treatmentPlansPage.getTreatmentsInputList().size() > i; i++) {
			if (treatmentPlansPage.getTreatmentsInputList().get(i).getText().contains(fullname)) {
				actualPrice = treatmentPlansPage.getUnitPriceNetPriceInputlist().get(i * 2).getText();
				amountPayablePrice = treatmentPlansPage.getAmountPayInputList().get(i).getText();
				if (actualPrice.contains(",")) {
					String[] str = actualPrice.split(",");
					String actualStr1 = str[0];
					String actualStr2 = str[1];
					int indexOfLast = actualStr2.lastIndexOf(".");
					String newString = actualStr2;
					if (indexOfLast >= 0)
						newString = actualStr2.substring(0, indexOfLast);
					String actualStr3 = actualStr1 + newString;
					actual = Float.parseFloat(actualStr3);
				} else {
					actual = Float.parseFloat(actualPrice);
				}
				float discount;
				if (amountPayablePrice.contains(",")) {
					String[] discountStr = amountPayablePrice.split(",");
					String discountStr1 = discountStr[0];
					String discountStr2 = discountStr[1];
					int indexOfLast1 = discountStr2.lastIndexOf(".");
					String newString1 = discountStr2;
					if (indexOfLast1 >= 0)
						newString1 = discountStr2.substring(0, indexOfLast1);
					String discountStr3 = discountStr1 + newString1;
					discount = Float.parseFloat(discountStr3);
				} else {
					discount = Float.parseFloat(amountPayablePrice);
				}
				float effectivePrice = (actual * inPercentage) / 100;
				float PriceOnDiscount = actual - effectivePrice;
				Assert.assertTrue(discount == PriceOnDiscount);
			}
		}
	}

	public static void checkFunctionalityOfAmountDis(String fullname, float inAmount) {
		BaseClass.waitForPageLoad();
		String actualPrice, amountPrice;
		float actual;
		for (int i = 0; treatmentPlansPage.getTreatmentsInputList().size() > i; i++) {
			if (treatmentPlansPage.getTreatmentsInputList().get(i).getText().contains(fullname)) {
				actualPrice = treatmentPlansPage.getUnitPriceNetPriceInputlist().get(i * 2).getText();
				amountPrice = treatmentPlansPage.getAmountPayInputList().get(i).getText();
				if (actualPrice.contains(",")) {
					String[] str = actualPrice.split(",");
					String actualStr1 = str[0];
					String actualStr2 = str[1];
					int indexOfLast = actualStr2.lastIndexOf(".");
					String newString = actualStr2;
					if (indexOfLast >= 0)
						newString = actualStr2.substring(0, indexOfLast);
					String actualStr3 = actualStr1 + newString;
					actual = Float.parseFloat(actualStr3);
				} else {
					actual = Float.parseFloat(actualPrice);
				}
				float discount;
				if (amountPrice.contains(",")) {
					String[] discountStr = amountPrice.split(",");
					String discountStr1 = discountStr[0];
					String discountStr2 = discountStr[1];
					int indexOfLast1 = discountStr2.lastIndexOf(".");
					String newString1 = discountStr2;
					if (indexOfLast1 >= 0)
						newString1 = discountStr2.substring(0, indexOfLast1);
					String discountStr3 = discountStr1 + newString1;
					discount = Float.parseFloat(discountStr3);
				} else {
					discount = Float.parseFloat(amountPrice);
				}
				float PriceOnDiscount = actual - inAmount;
				Assert.assertTrue(discount == PriceOnDiscount);
			}
		}
	}

	public static void enterDiscountValue(String fullname, String discount) {
		BaseClass.waitForPageLoad();
		for (int i = 0; treatmentPlansPage.getTreatmentsInputList().size() > i; i++) {
			if (treatmentPlansPage.getTreatmentsInputList().get(i).getText().contains(fullname)) {
				treatmentPlansPage.getDiscountInputList().get(i).clear();
				treatmentPlansPage.getDiscountInputList().get(i).sendKeys(discount);
				break;
			}
		}
	}

	public static void discountInPercentage(String fullname) {
		BaseClass.waitForPageLoad();
		for (int i = 0; treatmentPlansPage.getTreatmentsInputList().size() > i; i++) {
			if (treatmentPlansPage.getTreatmentsInputList().get(i).getText().contains(fullname)) {
				BaseClass.selectFromDropDownByIndex(treatmentPlansPage.getDiscountTypeInputList().get(i), 0);;
				break;
			}
		}
	}

	public static void discountInAmount(String fullname) {
		BaseClass.waitForPageLoad();
		for (int i = 0; treatmentPlansPage.getTreatmentsInputList().size() > i; i++) {
			if (treatmentPlansPage.getTreatmentsInputList().get(i).getText().contains(fullname)) {
				BaseClass.selectFromDropDownByIndex(treatmentPlansPage.getDiscountTypeInputList().get(i), 1);;
				break;
			}
		}
	}

	public static void verifyMsgWithoutCoupon() {
		BaseClass.waitForElementVisibility(treatmentPlansPage.getWithoutCouponMsg(), 2000);
		Assert.assertTrue(checkedWebElementDisplayed(treatmentPlansPage.getWithoutCouponMsg()));
		BaseClass.waitForElementToDisappear((By.xpath("//span[contains(text(),'Please Select Coupon(s) Basis')]")));
	}

	public static void clickOnByArch() {
		BaseClass.waitForPageLoad();
		treatmentPlansPage.getByArchBtn().click();
	}

	public static void clickOnByQuadrant() {
		BaseClass.waitForPageLoad();
		treatmentPlansPage.getByQuadrantBtn().click();
	}

	private static boolean checkedWebElementDisplayed(WebElement webElement) {
		return (webElement.isDisplayed());
	}

}
