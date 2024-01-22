package pageActions.patientDashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import base.BaseClass;
import pages.patientDashboard.OralExamsPage;
import java.util.List;

/**
 * 
 * @author Ajit Yadav
 *
 */
public class OralExamsPageActions extends BaseClass {

	static OralExamsPage oralExamsPage = PageFactory.initElements(driver, OralExamsPage.class);

	public static void clickOnchiefComplaintsAddBtn() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getChiefComplaintsAddBtn());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		oralExamsPage.getChiefComplaintsAddBtn().click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void verifyUiOralExamPage() {
		BaseClass.waitForModalOverlayToDisappear();
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(oralExamsPage.getTeeth(),4000);
		Assert.assertTrue(checkedElementDisplayed(oralExamsPage.getTeeth()) && checkedElementDisplayed(oralExamsPage.getTissue())
				&& checkedElementDisplayed(oralExamsPage.getAdult()) && checkedElementDisplayed(oralExamsPage.getPedo()) && checkedElementDisplayed(oralExamsPage.getMixed())
				&& checkedElementDisplayed(oralExamsPage.getChiefComplaints())
				&& checkedElementDisplayed(oralExamsPage.getAllTeeth()) && checkedElementDisplayed(oralExamsPage.getDiagnostic())
				&& checkedElementDisplayed(oralExamsPage.getTreatment()) && checkedElementDisplayed(oralExamsPage.getFile()));
	}

//	public static void verifyUiOralExamPage() {
//		BaseClass.waitForPageLoad();
//		BaseClass.waitForElementToBeClickable(oralExamsPage.getAllTeeth());
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		Assert.assertTrue(checkedElementDisplayed(oralExamsPage.getTeeth()) && checkedElementDisplayed(oralExamsPage.getTissue())
//				&& checkedElementDisplayed(oralExamsPage.getAdult()) && checkedElementDisplayed(oralExamsPage.getPedo()) && checkedElementDisplayed(oralExamsPage.getMixed())
//				&& checkedElementDisplayed(oralExamsPage.getChiefComplaints()) && checkedElementDisplayed(oralExamsPage.getChiefComplaintsAddBtn())
//				&& checkedElementDisplayed(oralExamsPage.getAllTeeth()) && checkedElementDisplayed(oralExamsPage.getDiagnostic())
//				&& checkedElementDisplayed(oralExamsPage.getTreatment()) && checkedElementDisplayed(oralExamsPage.getFile()));
//	}

	public static void clickOnTissue() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getTissue());
		oralExamsPage.getTissue().click();
	}

	public static void clickOnPedo() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getPedo());
		oralExamsPage.getPedo().click();
	}

	public static void clickOnAdult() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getAdult());
		oralExamsPage.getAdult().click();
	}

	public static void clickOnMixed() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getMixed());
		oralExamsPage.getMixed().click();
	}

	public static void verifyAdultsTeeths() {
		BaseClass.visibilityOfListLocated(oralExamsPage.getAdultTeeths());
		Assert.assertTrue(oralExamsPage.getAdultTeeths().size() == 32);
	}
	
	public static void verifyPedoTeeths() {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(oralExamsPage.getPedoTeeths().get(1), 4000);
		Assert.assertTrue(oralExamsPage.getPedoTeeths().size() == 20);
	}

//	public static void verifyPedoTeeths() {
//		BaseClass.waitForPageLoad();
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Assert.assertTrue(oralExamsPage.getPedoTeeths().size() == 20);
//	}
	
	public static void verifyMixedTeeths() {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementVisibility(oralExamsPage.getMixedTeeths().get(1), 4000);
		Assert.assertTrue(oralExamsPage.getMixedTeeths().size() == 52);
	}

//	public static void verifyMixedTeeths() {
//		BaseClass.waitForPageLoad();
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Assert.assertTrue(oralExamsPage.getMixedTeeths().size() == 52);
//	}

	public static void verifyWebElementInHardTissue() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getSoft());
		Assert.assertTrue(
				(checkedElementDisplayed(oralExamsPage.getHard()) && checkedElementDisplayed(oralExamsPage.getSoft())) == (oralExamsPage.getHardProvisionals().size() == 8));
	}

	public static void verifyWebElementInSoftTissue() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getSoft());
		Assert.assertTrue(
				(checkedElementDisplayed(oralExamsPage.getHard()) && checkedElementDisplayed(oralExamsPage.getSoft())) == (oralExamsPage.getSoftProvisionals().size() == 10));
	}
	
	public static void clickOnHardTissue() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getHard());
		oralExamsPage.getHard().click();
		BaseClass.waitForElementVisibility(oralExamsPage.getMandibularAngle(),4000);
	}

//	public static void clickOnHardTissue() {
//		BaseClass.waitForPageLoad();
//		BaseClass.waitForElementToBeClickable(oralExamsPage.getHard());
//		oralExamsPage.getHard().click();
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public static void removeToothSiteProvisionals() {
		BaseClass.waitForPageLoad();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BaseClass.waitForElementToBeClickable(oralExamsPage.getToothObservationRemark());
		for (int i = 0; oralExamsPage.getProvisionalRemoveBtnToothSite().size() > i; i++) {
			oralExamsPage.getProvisionalRemoveBtnToothSite().get(i).click();
		}
	}

	public static void enterOralExamNotes(String note) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getToothObservationRemark());
		oralExamsPage.getToothObservationRemark().sendKeys(note);
	}

	public static void clickOnSaveBtn() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getSaveBtn());
		oralExamsPage.getSaveBtn().click();
		BaseClass.waitForElementToDisappear(By.xpath("//span[contains(text(),'Oral Exam findings added successfully!')]"));
	}

	public static void selectedToothAndSiteProvisionalDisplayedBelow() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getSoftTissue());
		Assert.assertTrue(oralExamsPage.getProvisionalRemoveBtnToothSite().size() == 1 || oralExamsPage.getProvisionalRemoveBtnToothSite().size() == 2
				|| oralExamsPage.getProvisionalRemoveBtnToothSite().size() == 3 || oralExamsPage.getProvisionalRemoveBtnToothSite().size() == 4
				|| oralExamsPage.getProvisionalRemoveBtnToothSite().size() == 5 || oralExamsPage.getProvisionalRemoveBtnToothSite().size() == 6
				|| oralExamsPage.getProvisionalRemoveBtnToothSite().size() == 7);
	}
	
	public static void clickOnToothSiteAndPerioProvisinals() {
		    BaseClass.waitForSpinnerToDisappear();
			driver.findElement(By.xpath("(//div[@class='content'])[1]")).click();
	}

//	public static void clickOnToothSiteAndPerioProvisinals() {
//		BaseClass.waitForPageLoad();
//		try {
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("(//div[@class='content'])[1]")).click();
//		} catch (StaleElementReferenceException | InterruptedException e) {
//			driver.findElement(By.xpath("(//div[@class='content'])[1]")).click();
//		}
//	}

	public static void verifyProvisinalIsSelected(String name) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getSoftTissue());
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='" + name + "']/.."))
				.getAttribute("class").contains("selected"));
	}

	public static void verifyToothObservationRemark() {
		BaseClass.waitForElementToBeClickable(oralExamsPage.getToothObservationRemark());
		boolean result = oralExamsPage.getToothObservationRemark().isDisplayed();
		Assert.assertTrue(result
				&& (oralExamsPage.getToothObservationRemark().getAttribute("maxlength").contains("768")
						&& oralExamsPage.getToothObservationRemark().getAttribute("placeholder").contains("» enter notes")
						&& oralExamsPage.getNotesWordlimitMsg().getText().contains("768 Character(s) left")));
	}

	public static void verifyIoparBtn() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getIOPARBtn());
		Assert.assertTrue(checkedElementDisplayed(oralExamsPage.getIOPARBtn()));
	}

	public static void verifyIOPARNotes() {
		BaseClass.waitForElementVisibility(oralExamsPage.getIOPARNotes(),4000);
		BaseClass.waitForElementToBeClickable(oralExamsPage.getIOPARNotes());
		boolean result = oralExamsPage.getIOPARNotes().isDisplayed();
		Assert.assertTrue(result
				&& oralExamsPage.getIOPARNotes().getAttribute("placeholder").contains("» IOPAR notes")
				&& oralExamsPage.getIoparWordlimitMsg().getText().contains("768 Character(s) left"));
	}

	public static void clickOnIOPARBtn() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getIOPARBtn());
		oralExamsPage.getIOPARBtn().click();
	}

	public static void ioparNotesDisable() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getIOPARBtn());
		List<WebElement> web = driver
				.findElements(By.xpath("//div[@id='toothViewPopup']//span[contains(text(),'Character left')]"));
		Assert.assertTrue(web.size() == 1);
	}
	
	public static void clickOnBuccal() {
		BaseClass.waitForElementVisibility(oralExamsPage.getBuccal(),4000);
		BaseClass.waitForElementToBeClickable(oralExamsPage.getBuccal());
		oralExamsPage.getBuccal().click();
		BaseClass.waitForSpinnerToDisappear();
	}

//	public static void clickOnBuccal() {
//		BaseClass.waitForPageLoad();
//		try {
//			Thread.sleep(3000);
//			BaseClass.waitForElementToBeClickable(oralExamsPage.getBuccal());
//			oralExamsPage.getBuccal().click();
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public static void clickOnDistal() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getDistal());
		oralExamsPage.getDistal().click();
	}

	public static void clickOnMesial() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getMesial());
		oralExamsPage.getMesial().click();
	}

	public static void clickOnOcclusal() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getOcclusal());
		oralExamsPage.getOcclusal().click();
	}

	public static void clickOnPalatal() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getPalatal());
		oralExamsPage.getPalatal().click();
	}

	public static void clickOnAllSurface() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getAllSurface());
		oralExamsPage.getAllSurface().click();
	}

	public static void clickOnPerio() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getPerio());
		oralExamsPage.getPerio().click();
	}

	public static void verifyProvisinals() {
		BaseClass.waitForSpinnerToDisappear();
		Assert.assertTrue(oralExamsPage.getProvisinals().size() > 0);
	}

	public static void removeSoftTissueProvisionals() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getToothObservationRemark());
		for (int i = 0; oralExamsPage.getProvisionalRemoveBtnSoftTissue().size() > i; i++) {
			oralExamsPage.getProvisionalRemoveBtnSoftTissue().get(i).click();
		}
	}

	public static void selectedSoftTissueProvisionalDisplayedBelow() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getToothSitePerio());
		Assert.assertTrue(oralExamsPage.getProvisionalRemoveBtnSoftTissue().size() == 1 || oralExamsPage.getProvisionalRemoveBtnSoftTissue().size() == 2
				|| oralExamsPage.getProvisionalRemoveBtnSoftTissue().size() == 3 || oralExamsPage.getProvisionalRemoveBtnSoftTissue().size() == 4
				|| oralExamsPage.getProvisionalRemoveBtnSoftTissue().size() == 5 || oralExamsPage.getProvisionalRemoveBtnSoftTissue().size() == 6
				|| oralExamsPage.getProvisionalRemoveBtnSoftTissue().size() == 7 || oralExamsPage.getProvisionalRemoveBtnSoftTissue().size() == 8
				|| oralExamsPage.getProvisionalRemoveBtnSoftTissue().size() == 9 || oralExamsPage.getProvisionalRemoveBtnSoftTissue().size() == 10);
	}
	
	public static void clickOnSoftTissueProvisinals() {
		BaseClass.waitForSpinnerToDisappear();
			driver
					.findElement(By.xpath("(//div[contains(@ng-click,'softDiagno.ProvisionalDiagnostic.bsId')])[1]"))
					.click();
	}

//	public static void clickOnSoftTissueProvisinals() {
//		BaseClass.waitForPageLoad();
//		try {
//			Thread.sleep(2000);
//			driver
//					.findElement(By.xpath("(//div[contains(@ng-click,'softDiagno.ProvisionalDiagnostic.bsId')])[1]"))
//					.click();
//		} catch (StaleElementReferenceException | InterruptedException e) {
//			driver
//					.findElement(By.xpath("(//div[contains(@ng-click,'softDiagno.ProvisionalDiagnostic.bsId')])[1]"))
//					.click();
//		}
//	}

	public static void provisionalIsSelectedOfSoftTissue(String name) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getToothSitePerio());
		Assert.assertTrue(driver
				.findElement(By.xpath("//div[contains(@ng-click,'addToothStissueItem')]//h5[text()='" + name + "']"))
				.getAttribute("class").contains("selected"));
	}
	
	public static void verifySoftProvisinals() {
		BaseClass.waitForSpinnerToDisappear();
		Assert.assertTrue(oralExamsPage.getSoftTissueProvisinals().size() > 0);
	}

//	public static void verifySoftProvisinals() {
//		BaseClass.waitForPageLoad();
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Assert.assertTrue(oralExamsPage.getSoftTissueProvisinals().size() > 0);
//	}

	public static void clickOnLip() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getLip());
		oralExamsPage.getLip().click();
	}

	public static void clickOnCheek() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getCheek());
		oralExamsPage.getCheek().click();
	}

	public static void clickOnTongue() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getTongue());
		oralExamsPage.getTongue().click();
	}

	public static void clickOnFloorOfMouth() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getFloorOfMouth());
		oralExamsPage.getFloorOfMouth().click();
	}

	public static void clickOnPalate() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getPalate());
		oralExamsPage.getPalate().click();
	}

	public static void clickOnGingiva() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getGingiva());
		oralExamsPage.getGingiva().click();
	}

	public static void clickOnVestibule() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getVestibule());
		oralExamsPage.getVestibule().click();
	}

	public static void clickOnFrenum() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getFrenum());
		oralExamsPage.getFrenum().click();
	}

	public static void clickOnSalivaryGland() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getSalivaryGland());
		oralExamsPage.getSalivaryGland().click();
	}

	public static void clickOnLymphNodes() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getLymphNodes());
		oralExamsPage.getLymphNodes().click();
	}
	
	public static void clickOnSoftTissueOnPopup() {
		BaseClass.waitForElementVisibility(oralExamsPage.getSoftTissue(), 4000);
		BaseClass.waitForModalOverlayToDisappear();
		oralExamsPage.getSoftTissue().click();
	}


//	public static void clickOnSoftTissueOnPopup() {
//		try {
//			Thread.sleep(2500);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		oralExamsPage.getSoftTissue().click();
//	}

	public static void removeHardTissueProvisionals() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getToothObservationRemark());
		for (int i = 0; oralExamsPage.getProvisionalRemoveBtnHardTissue().size() > i; i++) {
			oralExamsPage.getProvisionalRemoveBtnHardTissue().get(i).click();
		}
	}

	public static void selectedHardTissueProvisionalDisplayedBelow() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getToothSitePerio());
		Assert.assertTrue(oralExamsPage.getProvisionalRemoveBtnHardTissue().size() == 1 || oralExamsPage.getProvisionalRemoveBtnHardTissue().size() == 2
				|| oralExamsPage.getProvisionalRemoveBtnHardTissue().size() == 3 || oralExamsPage.getProvisionalRemoveBtnHardTissue().size() == 4
				|| oralExamsPage.getProvisionalRemoveBtnHardTissue().size() == 5 || oralExamsPage.getProvisionalRemoveBtnHardTissue().size() == 6
				|| oralExamsPage.getProvisionalRemoveBtnHardTissue().size() == 7 || oralExamsPage.getProvisionalRemoveBtnHardTissue().size() == 8);
	}
	
	public static void clickOnHardTissueProvisinals() {
	BaseClass.waitForSpinnerToDisappear();
	driver
	.findElement(By.xpath("(//div[contains(@ng-click,'hDiadgnos.ProvisionalDiagnostic.id')])[1]"))
	.click();
	}

//	public static void clickOnHardTissueProvisinals() {
//		BaseClass.waitForPageLoad();
//		try {
//			Thread.sleep(1000);
//			driver
//					.findElement(By.xpath("(//div[contains(@ng-click,'hDiadgnos.ProvisionalDiagnostic.id')])[1]"))
//					.click();
//		} catch (StaleElementReferenceException | InterruptedException e) {
//			driver
//					.findElement(By.xpath("(//div[contains(@ng-click,'hDiadgnos.ProvisionalDiagnostic.id')])[1]"))
//					.click();
//		}
//	}

	public static void provisionalIsSelectedOfHardTissue(String name) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getSoftTissue());
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='" + name + "']/.."))
				.getAttribute("class").contains("selected"));
	}

	public static void clickOnMandibularAngle() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getMandibularAngle());
		oralExamsPage.getMandibularAngle().click();
	}

	public static void clickOnMandibularBody() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getMandibularBody());
		oralExamsPage.getMandibularBody().click();
	}

	public static void clickOnMaxillaryTuberosity() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getMaxillaryTuberosity());
		oralExamsPage.getMaxillaryTuberosity().click();
	}

	public static void clickOnPosteriorMaxilla() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getPosteriorMaxilla());
		oralExamsPage.getPosteriorMaxilla().click();
	}

	public static void clickOnPreMaxilla() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getPreMaxilla());
		oralExamsPage.getPreMaxilla().click();
	}

	public static void clickOnMaxillarySinus() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getMaxillarySinus());
		oralExamsPage.getMaxillarySinus().click();
	}

	public static void clickOnMandibularSymphysis() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getMandibularSymphysis());
		oralExamsPage.getMandibularSymphysis().click();
	}

	public static void clickOnTMJoint() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getTMJoint());
		oralExamsPage.getTMJoint().click();
	}
	
	public static void clickOnMandibularAngleOnPopup() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getMandibularAngleOnPopup());
		oralExamsPage.getMandibularAngleOnPopup().click();
	}

	public static void clickOnMandibularBodyOnPopup() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getMandibularBodyOnPopup());
		oralExamsPage.getMandibularBodyOnPopup().click();
	}

	public static void clickOnMaxillaryTuberosityOnPopup() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getMaxillaryTuberosityOnPopup());
		oralExamsPage.getMaxillaryTuberosityOnPopup().click();
	}

	public static void clickOnPosteriorMaxillaOnPopup() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getPosteriorMaxillaOnPopup());
		oralExamsPage.getPosteriorMaxillaOnPopup().click();
	}

	public static void clickOnPreMaxillaOnPopup() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getPreMaxillaOnPopup());
		oralExamsPage.getPreMaxillaOnPopup().click();
	}

	public static void clickOnMaxillarySinusOnPopup() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getMaxillarySinusOnPopup());
		oralExamsPage.getMaxillarySinusOnPopup().click();
	}

	public static void clickOnMandibularSymphysisOnPopup() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getMandibularSymphysisOnPopup());
		oralExamsPage.getMandibularSymphysisOnPopup().click();
	}

	public static void clickOnTMJointOnPopup() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getTMJointOnPopup());
		oralExamsPage.getTMJointOnPopup().click();
	}

	public static void clickOnHardTissueInPopup() {
		BaseClass.waitForElementVisibility(oralExamsPage.getHardTissueOnPopUp(),4000);
		BaseClass.waitForModalOverlayToDisappear();
		oralExamsPage.getHardTissueOnPopUp().click();
	}
	
	public static void verifyHardProvisionals() {
		BaseClass.waitForSpinnerToDisappear();
		Assert.assertTrue(oralExamsPage.getHardProvisinalsInPopup().size() > 0);
	}

//	public static void verifyHardProvisionals() {
//		BaseClass.waitForPageLoad();
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Assert.assertTrue(oralExamsPage.getHardProvisinalsInPopup().size() > 0);
//	}
	
	public static void verifyTitleOfPopup(String typeTeeth, String tabName) {
		BaseClass.waitForElementVisibility(oralExamsPage.getCloseBtnOnTeethPopup(),4000);
		BaseClass.WaitTillElementIsPresent(oralExamsPage.getTitlePopup());
		String title = "Oral Exam >" + typeTeeth + " > " + tabName;
		Assert.assertTrue(oralExamsPage.getTitlePopup().getText().contains(title));
	}

//	public static void verifyTitleOfPopup(String typeTeeth, String tabName) {
//		BaseClass.waitForPageLoad();
//		BaseClass.WaitTillElementIsPresent(oralExamsPage.getTitlePopup());
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String title = "Oral Exam >" + typeTeeth + " > " + tabName;
//		Assert.assertTrue(oralExamsPage.getTitlePopup().getText().contains(title));
//	}

	public static void clickOnTeethImage(String toothType, String teethNo) {
		BaseClass.waitForPageLoad();
		executionDelay();
		String toothNO = "tooth" + teethNo;
		BaseClass.waitForElementToBeClickable(driver.findElement(By.xpath("//*[text()='New Teeth']")));
		driver.findElement(By.xpath("//*[text()='New Teeth']")).click();
		
		if (toothType.equals("Adult")) {
			BaseClass.waitForElementToBeClickable(oralExamsPage.getAdult());
			BaseClass.waitForModalOverlayToDisappear();
			driver.findElement(By.xpath("//div[@id='adult']//span[contains(@class,'" + toothNO + "')]")).click();
		} else if (toothType.equals("Pedo")) {
			oralExamsPage.getPedo().click();
			BaseClass.waitForElementToBeClickable(oralExamsPage.getMixed());
			driver.findElement(By.xpath("//div[@id='pedo']//span[contains(@class,'" + toothNO + "')]")).click();
		} else if (toothType.equals("Mixed")) {
			oralExamsPage.getMixed().click();
			BaseClass.waitForElementVisibility(oralExamsPage.getPedo(), 4000);
			BaseClass.waitForElementToBeClickable(oralExamsPage.getPedo());
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			WebElement ele =driver.findElement(By.xpath("//div[@id='mixed']//a//span[contains(@data-ng-click,'" + teethNo + "')]"));
			BaseClass.waitForElementVisibility(ele, 5000);
			ele.click();
		}
	}
	
	public static void clickOnTeethImageFromTreatmentList(String toothType, String teethNo) {
		BaseClass.waitForPageLoad();
		String toothNO = "tooth" + teethNo;
		if(!oralExamsPage.getNewTeethList().isDisplayed()) {
			oralExamsPage.getNewTeethHeader().click();
			BaseClass.waitForSpinnerToDisappear();
			BaseClass.waitForElementVisibility(oralExamsPage.getPedo(), 4000);
		}
		if (toothType.equals("Adult")) {
			driver.findElement(By.xpath("//div[@id='adult']//span[contains(@class,'" + toothNO + "')]")).click();
		} else if (toothType.equals("Pedo")) {
			oralExamsPage.getPedo().click();
			BaseClass.waitForElementToBeClickable(oralExamsPage.getMixed());
			driver.findElement(By.xpath("//div[@id='pedo']//span[contains(@class,'" + toothNO + "')]")).click();
		} else if (toothType.equals("Mixed")) {
			oralExamsPage.getMixed().click();
			BaseClass.waitForElementVisibility(oralExamsPage.getPedo(), 4000);
			BaseClass.waitForElementToBeClickable(oralExamsPage.getPedo());
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			WebElement ele =driver.findElement(By.xpath("//div[@id='mixed']//a//span[contains(@data-ng-click,'" + teethNo + "')]"));
			BaseClass.waitForElementVisibility(ele, 5000);
			ele.click();
		}
	}

	public static void selectMultipleTeeth(String toothType, String teethNo) {
		BaseClass.waitForPageLoad();
		if (toothType.equals("Adult")) {
			driver.findElement(By.xpath("//div[@id='adult']//span[text()='" + teethNo + "']")).click();
		} else if (toothType.equals("Pedo")) {
			oralExamsPage.getPedo().click();
			BaseClass.waitForElementToBeClickable(oralExamsPage.getMixed());
			WebElement web = driver
					.findElement(By.xpath("//div[@id='pedo']//span[text()='" + teethNo + "']"));
			BaseClass.waitForElementToBeClickable(web);
			web.click();
		} else if (toothType.equals("Mixed")) {
			oralExamsPage.getMixed().click();
			WebElement web = driver
					.findElement(By.xpath("//div[@id='mixed']//span[text()='" + teethNo + "']"));
			web.click();
		}
	}

	public static void selectedInRespective(String toothType, String teethNo) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getTissue());
		if (toothType.equals("Adult")) {
			Assert.assertTrue(
					driver.findElement(By.xpath("//div[@id='adult']//span[text()='" + teethNo + "']"))
							.getAttribute("class").contains("selected"));
		} else if (toothType.equals("Pedo")) {
			oralExamsPage.getPedo().click();
			Assert.assertTrue(
					driver.findElement(By.xpath("//div[@id='pedo']//span[text()='" + teethNo + "']"))
							.getAttribute("class").contains("selected"));
		} else if (toothType.equals("Mixed")) {
			oralExamsPage.getMixed().click();
			Assert.assertTrue(
					driver.findElement(By.xpath("//div[@id='mixed']//span[text()='" + teethNo + "']"))
							.getAttribute("class").contains("selected"));
		}
	}

	public static void deSelectedInRespective(String toothType, String teethNo) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getTissue());
		if (toothType.equals("Adult")) {
			Assert.assertTrue(
					!driver.findElement(By.xpath("//div[@id='adult']//span[text()='" + teethNo + "']"))
							.getAttribute("class").contains("selected"));
		} else if (toothType.equals("Pedo")) {
			oralExamsPage.getPedo().click();
			Assert.assertTrue(
					!driver.findElement(By.xpath("//div[@id='pedo']//span[text()='" + teethNo + "']"))
							.getAttribute("class").contains("selected"));
		} else if (toothType.equals("Mixed")) {
			oralExamsPage.getMixed().click();
			Assert.assertTrue(
					!driver.findElement(By.xpath("//div[@id='mixed']//span[text()='" + teethNo + "']"))
							.getAttribute("class").contains("selected"));
		}
	}

	public static void selectedAfterClickOnEdit(String toothType, String teethNo) {
		BaseClass.waitForSpinnerToDisappear();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getTissue());
		BaseClass.waitForElementVisibility(oralExamsPage.getTissue(), 4000);
		if (toothType.equals("Adult")) {
			Assert.assertTrue(
					driver.findElement(By.xpath("//div[@id='adult']//span[text()='" + teethNo + "']"))
							.getAttribute("class").contains("selected"));
		} else if (toothType.equals("Pedo")) {
			Assert.assertTrue(
					driver.findElement(By.xpath("//div[@id='pedo']//span[text()='" + teethNo + "']"))
							.getAttribute("class").contains("selected"));
		} else if (toothType.equals("Mixed")) {
			Assert.assertTrue(
					driver.findElement(By.xpath("//div[@id='mixed']//span[text()='" + teethNo + "']"))
							.getAttribute("class").contains("selected"));
		}
	}

	public static void clickOnCloseBtn() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getCloseBtnOnTeethPopup());
		oralExamsPage.getCloseBtnOnTeethPopup().click();
	}

	public static void clickOnYes() {
		BaseClass.waitForSpinnerToDisappear();;
		BaseClass.waitForElementVisibility(oralExamsPage.getYesOnMultiselect(),4000);
		oralExamsPage.getYesOnMultiselect().click();
		BaseClass.waitForElementToDisappear((By.xpath("//div[@id='confirmbox']//span[@class='cmnicons yes-mdl']")));
	}

	public static void verifySelectedTeethOnPopup(String teeth, int no) {
		BaseClass.waitForElementVisibility(oralExamsPage.getCloseBtnOnTeethPopup(),4000);
		BaseClass.waitForElementToBeClickable(oralExamsPage.getCloseBtnOnTeethPopup());
		Assert.assertTrue(driver
				.findElement(By.xpath("(//ul[@id='observationpopupul']//span[@class='ng-binding'])[" + no + "]"))
				.getText().contains(teeth));
	}

	public static void clickOnEditOfChiefComplaint() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getChiefComplaintEditBtn());
		oralExamsPage.getChiefComplaintEditBtn().click();
	}

	public static void checkedDeletedChiefComplaints(String chiefComplaint) {
		BaseClass.waitForSpinnerToDisappear();;
		List<WebElement> webElement = driver
				.findElements(By.xpath("//span[text()='" + chiefComplaint + "']/following-sibling::a"));
		Assert.assertTrue(webElement.size() == 0);
	}
	
	public static void removeChiefComplaintsOnOralExam(String chiefComplaint) {
		BaseClass.waitForModalOverlayToDisappear();
		WebElement webElement = driver
				.findElement(By.xpath("//span[text()='" + chiefComplaint + "']/following-sibling::a"));
		BaseClass.waitForElementToBeClickable(webElement);
		webElement.click();
		BaseClass.waitForElementToDisappear(By.xpath("//span[contains(text(),'Chief Complaint deleted successfully')]"));
	}

//	public static void removeChiefComplaintsOnOralExam(String chiefComplaint) {
//		BaseClass.waitForPageLoad();
//		BaseClass.waitForElementToDisappear(By.xpath("//span[contains(text(),'Chief Complaint deleted successfully')]"));
//		WebElement webElement = driver
//				.findElement(By.xpath("//span[text()='" + chiefComplaint + "']/following-sibling::a"));
//		BaseClass.waitForElementToBeClickable(webElement);
//		webElement.click();
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public static void checkedChiefComplaintsOnOralExam(String chiefComplaint) {
		BaseClass.waitForPageLoad();
		WebElement webElement = driver
				.findElement(By.xpath("//span[text()='" + chiefComplaint + "']/following-sibling::a"));
		BaseClass.waitForElementToBeClickable(webElement);
		Assert.assertTrue(checkedElementDisplayed(webElement));
	}

	public static void clickOnAllTeeth() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getAllTeeth());
		oralExamsPage.getAllTeeth().click();
		BaseClass.waitForPageLoad();
	}

	public static void allTeethButtonDeselected() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getAllTeeth());
		Assert.assertTrue(
				!oralExamsPage.getAllTeeth().getAttribute("class").contains("selected") && oralExamsPage.getAllTeethText().getText().contains("All Teeth"));
	}

	public static void allTeethButtonSelected() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getAllTeeth());
		Assert.assertTrue(
				oralExamsPage.getAllTeeth().getAttribute("class").contains("selected") && oralExamsPage.getAllTeethText().getText().contains("Undo All"));
	}

	public static void verifyInputListWebElement() {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getSoftTissueInputList());
		Assert.assertTrue(checkedElementDisplayed(oralExamsPage.getToothNo()) && checkedElementDisplayed(oralExamsPage.getToothSitePerioInputList())
				&& checkedElementDisplayed(oralExamsPage.getSoftTissueInputList()) && checkedElementDisplayed(oralExamsPage.getHardTissueInputList())
				&& checkedElementDisplayed(oralExamsPage.getNotesInputList()) && checkedElementDisplayed(oralExamsPage.getActionInputList()));
	}

	public static void verifyProvisinalsInputList(String teethNo, int NoProvisinals) {
		BaseClass.waitForElementVisibility(oralExamsPage.getSoftTissueInputList(),4000);
		List<WebElement> webelement2 = driver.findElements(By.xpath("//span[contains(text(),'"+teethNo+"')]/../../..//td//span[@class='ng-binding ng-scope']"));
		int size = webelement2.size();
		System.out.println("The Size is"+size);
		Assert.assertTrue(size== NoProvisinals);
	}

	public static void provisinalsInputListOfMultipleTeeth(String teethNo1, String teethNo2, int NoProvisinals) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getSoftTissueInputList());
		List<WebElement> webelement2 = driver.findElements(By.xpath("//span[contains(text(),'" + teethNo1
				+ "," + teethNo2
				+ "')] /../../..//td//span[@class='ng-binding ng-scope']"));
		BaseClass.visibilityOfListLocated(webelement2);
		Assert.assertTrue(webelement2.size() == NoProvisinals);
	}

	public static void verifyNoteInputList(String teethNo, String notes) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getSoftTissueInputList());
		Assert.assertTrue(driver
				.findElement(By.xpath("//span[contains(text(),'" + teethNo
						+ "')]/../../following-sibling::td/div[@class='textDataVisualizer tdvNotes ng-binding']"))
				.getText().contains(notes));
	}
	
	public static void clickOnEditBtnTeethNo(String teethNo) {
		try {
			Thread.sleep(2000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		BaseClass.scrollToView(oralExamsPage.getActionInputList());
		WebElement wb = driver.findElement(By.xpath("//span[contains(text(),'" + teethNo
				+ "')]/../../following-sibling::td//a[contains(@data-ng-click,'oeEditInputList')]"));
		BaseClass.scrollToView(wb);
		BaseClass.waitForElementVisibility(wb,4000);
		wb.click();
	}

//	public static void clickOnEditBtnTeethNo(String teethNo) {
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		BaseClass.waitForPageLoad();
//		driver.findElement(By.xpath("//span[contains(text(),'" + teethNo
//				+ "')]/../../following-sibling::td//a[contains(@data-ng-click,'oeEditInputList')]")).click();
//	}

	public static void verifyActionBtnOfTeethNo(String teethNo) {
		BaseClass.waitForPageLoad();
		BaseClass.waitForElementToBeClickable(oralExamsPage.getSoftTissueInputList());
		Assert.assertTrue(driver
				.findElement(By.xpath("//span[contains(text(),'" + teethNo
						+ "')]/../../following-sibling::td//a[contains(@data-ng-click,'oeEditInputList')]"))
				.isDisplayed()
				&& driver
						.findElement(By.xpath("//span[contains(text(),'" + teethNo
								+ "')]/../../following-sibling::td//a[contains(@data-ng-click,'oeSingleDelete')]"))
						.isDisplayed());
	}
	
	public static void alertMsgOnNotSelectProvisional() {
		BaseClass.waitForPageLoad();
		BaseClass.softAssert().assertTrue((driver
				.findElement(By.cssSelector("div[class='alert ng-isolate-scope alert-danger alert-dismissable']"))
				.getText().contains("Please select a provisional diagnosis to add as Oral Exam finding(s)")));
		BaseClass.waitForElementToDisappear(((By.xpath("//span[contains(text(),'Please select a provisional diagnosis to add as Oral Exam finding(s)')]"))));
	}

//	public static void alertMsgOnNotSelectProvisional() {
//		BaseClass.waitForPageLoad();
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		BaseClass.softAssert().assertTrue((driver
//				.findElement(By.cssSelector("div[class='alert ng-isolate-scope alert-danger alert-dismissable']"))
//				.getText().contains("Please select a provisional diagnosis to add as Oral Exam finding(s)")));
//	}

	public static void hardcodeWait() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean checkedElementDisplayed(WebElement webElement) {
		return (webElement.isDisplayed());
	}
}
