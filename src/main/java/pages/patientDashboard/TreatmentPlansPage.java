package pages.patientDashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import java.util.List;


public class TreatmentPlansPage {

	@FindBy(xpath = "//i[text()='Create']")
	private WebElement creatBtn;
	@FindBy(xpath = "//i[text()='Products+']")
	private WebElement productBtn;
	@FindBy(xpath = "//a[text()='Findings']")
	private WebElement findings;
	@FindBy(xpath = "//a[text()='New Teeth']")
	private WebElement NewTeeth;
	@FindBy(xpath = "//i[@class='ng-binding']")
	private WebElement noRecordMsg;
	@FindBy(xpath = "//b[text()='All Teeth']")
	private WebElement AllTeethBtn;
	@FindBy(xpath = "//b[text()='By Quadrant']")
	private WebElement ByQuadrantBtn;
	@FindBy(xpath = "//b[text()='By Arch']")
	private WebElement byArchBtn;
	@FindBy(xpath = "//h1[text()='Treatment Plans']")
	private WebElement header;
	@FindBy(xpath = "//button[@class='close']/span[@class='cmnicons yes-mdl']" ) // changed the xpath from "//div[@id='confirmbox']//button[@class='btn btn-warning confirmBtn']")
	private WebElement yesOnMultiselect;
	// ------------webelement of the popup after selected teeth image------
	@FindBy(xpath = "//h4[contains(@class,'modal-title')]/span[contains(text(),'Findings')]")
	private WebElement titleOfPopup;
	@FindBy(xpath = "//div[@id='tgrouppopupheader']//button[@aria-label='Close']")
	private WebElement closeBtn;
	@FindBy(xpath = "//a[text()='Treatment Groups']")
	private WebElement treatmentGroups;
	@FindBy(xpath = "//div[contains(@class,'searchTreatmentBox')]/input")
	private WebElement searchBox;
	@FindBy(xpath = "//button[@ng-click='treatmentSave()']")
	private WebElement saveBtn;
	@FindBy(xpath = "//div[contains(text(),'Consultations / X-Rays')]")
	private WebElement consultation_XRays;
	@FindBy(xpath = "//div[contains(text(),'Endo')]")
	private WebElement endo;;
	@FindBy(xpath = "//div[contains(text(),'Minor Oral Surgery')]")
	private WebElement minorOralSurgery;
	@FindBy(xpath = "//div[contains(text(),'Extractions')]")
	private WebElement extractions;
	@FindBy(xpath = "//div[contains(text(),'Prostho (Except Crowns)')]")
	private WebElement prosthoExceptCrowns;
	@FindBy(xpath = "//div[text()='Crowns ']")
	private WebElement crowns;
	@FindBy(xpath = "//div[contains(text(),'Implant Crowns')]")
	private WebElement implantCrowns;
	@FindBy(xpath = "//div[contains(text(),'Ortho')]")
	private WebElement ortho;
	@FindBy(xpath = "//div[contains(text(),'Perio')]")
	private WebElement perio;
	@FindBy(xpath = "//div[contains(text(),'Aligners (LMB)')]")
	private WebElement alignersLMB;
	@FindBy(xpath = "//div[contains(text(),'Aligners (Others)')]")
	private WebElement alignersOthers;
	@FindBy(xpath = "//div[contains(text(),'Pedo')]")
	private WebElement pedo;
	@FindBy(xpath = "//div[contains(text(),'Implants (AB)')]")
	private WebElement implantsAB;
	@FindBy(xpath = "//div[contains(text(),'Implants (Nobel)')]")
	private WebElement implantsNobel;
	@FindBy(xpath = "//div[contains(text(),'Implant (Others)')]")
	private WebElement implantOthers;
	@FindBy(xpath = "//div[contains(text(),'Bone Graft/ Membrane / PRF')]")
	private WebElement boneGraftAndMembranesPRF;;
	@FindBy(xpath = "//div[contains(text(),'Lasers')]")
	private WebElement lasers;
	@FindBy(xpath = "//div[contains(text(),'IP/ CDOP/ Bank')]")
	private WebElement ip_CDOP_Bank;
	@FindBy(xpath = "//div[contains(text(),'Membership')]")
	private WebElement membership;
	@FindBy(xpath = "//div[text()='Others ']")
	private WebElement others;
	@FindBy(xpath = "//div[@class='contentBx']//span[@class='ng-binding']")
	private List<WebElement> treatments;
	@FindBy(css = "span[class='glyphicon glyphicon-pencil']")
	private WebElement oralExamBtn;
	@FindBy(xpath = "//span[contains(text(),'Please select a treatment before clicking on save!')]")
	private WebElement withoutTreatmentMsg;
	@FindBy(xpath = "//div[@for='bridge']" ) // "//div[@for='bridge']")
	private WebElement partOfBridgeChkBx;

	// ----------------webElement of oral exam popup after selecting pencil in
	// treatment popup----------------------
	@FindBy(xpath = "//div[@id='obpopupmodalheader']/../preceding-sibling::div//span[@class='cmnicons cncl-mdl']")
	private WebElement closeBtnOralExam;
	@FindBy(xpath = "//div[@id='obpopupmodalheader']/../preceding-sibling::div//span[@class='cmnicons sv-mdl']")
	private WebElement saveBtnOralExam;
	@FindBy(xpath = "//div[contains(@ng-click,'addToothStissueItem')]//h5[text()='Lip']")
	private WebElement lip;
	@FindBy(xpath = "//div[contains(@ng-click,'addToothStissueItem')]//h5[text()='Cheek']")
	private WebElement cheek;
	@FindBy(xpath = "//div[contains(@ng-click,'addToothStissueItem')]//h5[text()='Tongue']")
	private WebElement Tongue;
	@FindBy(xpath = "//div[contains(@ng-click,'addToothStissueItem')]//h5[text()='Floor of Mouth']")
	private WebElement FloorOfMouth;
	@FindBy(xpath = "//div[contains(@ng-click,'addToothStissueItem')]//h5[text()='Palate']")
	private WebElement Palate;
	@FindBy(xpath = "//div[contains(@ng-click,'addToothStissueItem')]//h5[text()='Gingiva']")
	private WebElement Gingiva;
	@FindBy(xpath = "//div[contains(@ng-click,'addToothStissueItem')]//h5[text()='Vestibule']")
	private WebElement Vestibule;
	@FindBy(xpath = "//div[contains(@ng-click,'addToothStissueItem')]//h5[text()='Frenum']")
	private WebElement Frenum;
	@FindBy(xpath = "//div[contains(@ng-click,'addToothStissueItem')]//h5[text()='Salivary Gland']")
	private WebElement SalivaryGland;
	@FindBy(xpath = "//div[contains(@ng-click,'addToothStissueItem')]//h5[text()='Lymph Nodes']")
	private WebElement LymphNodes;
	@FindBy(xpath = "//div[contains(@ng-click,'removeToothSoftTissueItems')]//a[@class='remove-button']")
	private List<WebElement> provisionalRemoveBtnSoftTissue;

	// -------------------------------IOPAR webelement on treatment on treatment
	// plan------------
	@FindBy(xpath = "//i[text()='IOPAR']")
	private WebElement IOPARBtn;
	@FindBy(id = "ioprRemark")
	private WebElement IOPARNotes;
	@FindBy(xpath = "//div[@class='content']")
	private List<WebElement> Provisinals;
	@FindBy(xpath = "//a[text()='Selected Treatment']")
	private WebElement selectedTreatment;

	// -----------webElement after added in input list of treatment page
	@FindBy(xpath = "//p[text()='Do you want to delete the selected treatment?']/../..//span[@class='cmnicons yes-mdl']")
	private WebElement yesForDelete;
	@FindBy(xpath = "//span[text()='Treatment deleted successfully!']")
	private WebElement deleteSuccessMessage;
	@FindBy(xpath = "//table[@id='treatmentplanedittable']//span[@class='actn-icn edit dashboardEditIcon']")
	private WebElement editBtnTreatmentInputList;
	@FindBy(xpath = "//table[@id='treatmentplanedittable']/following-sibling::div//span[@class='cmnicons sv-mdl']")
	private WebElement SaveBtnOnInputList;
	@FindBy(xpath = "//div[@id='cubeboxwrapper']//span[text()='Buccal']")
	private WebElement Buccal;

	// --------------webelement and funtions of discount
	@FindBy(xpath = "//span[contains(text(),'Please Select Coupon(s) Basis')]")
	private WebElement withoutCouponMsg;

	// -------------webelement treatment input list------------------------//
	@FindBy(xpath = "//table[@id='treatmentplanedittable']//th[text()='Source']")
	private WebElement sourceInputList;
	@FindBy(xpath = "//table[@id='treatmentplanedittable']//th[text()='Start']")
	private WebElement startInputList;
	@FindBy(xpath = "//table[@id='treatmentplanedittable']//th[text()='Treatment']")
	private WebElement treatmentInputList;
	@FindBy(xpath = "//table[@id='treatmentplanedittable']//th[text()='Type']")
	private WebElement typeInputList;
	@FindBy(xpath = "//table[@id='treatmentplanedittable']//th[text()='Unit Cost']")
	private WebElement unitCostInputList;
	@FindBy(xpath = "//table[@id='treatmentplanedittable']//th[text()='Net Amt.']")
	private WebElement netAmtInputList;
	@FindBy(xpath = "//table[@id='treatmentplanedittable']//th[text()='Coupon']")
	private WebElement couponInputList;
	@FindBy(xpath = "//table[@id='treatmentplanedittable']//th[text()='Amt. Pay.']")
	private WebElement AmtPayInputList;
	@FindBy(xpath = "//table[@id='treatmentplanedittable']//th[text()='Coupon Basis']")
	private WebElement couponBasisInputList;
	@FindBy(xpath = "//table[@id='treatmentplanedittable']//th[text()='Action']")
	private WebElement actionInputList;
	@FindBy(xpath = "//td[contains(@data-ng-class,'Treatment.tr_name_emphasis')]")
	private List<WebElement> treatmentsInputList;
	@FindBy(xpath = "//td[contains(@data-ng-class,'Treatment.tr_name_emphasis')]/preceding-sibling::td//label[@class='assign_area']")
	private List<WebElement> checkBoxInputList;
	@FindBy(xpath = "//td[contains(@data-ng-class,'Treatment.tr_name_emphasis')]/following-sibling::td//select[@ng-model='tretChildOne.Treatment.treatmenttype']")
	private List<WebElement> treatmentTypeInputList;
	@FindBy(xpath = "//td[contains(@data-ng-class,'Treatment.tr_name_emphasis')]/following-sibling::td//span[contains(@ng-class,'tretChildOne.Treatment.unit_price')]")
	private List<WebElement> unitPriceNetPriceInputlist;
	@FindBy(xpath = "//td[contains(@data-ng-class,'Treatment.tr_name_emphasis')]/following-sibling::td//select[@ng-model='tretChildOne.Treatment.discount_type']")
	private List<WebElement> discountTypeInputList;
	@FindBy(xpath = "//td[contains(@data-ng-class,'Treatment.tr_name_emphasis')]/following-sibling::td//input[@ng-model='tretChildOne.Treatment.discount']")
	private List<WebElement> discountValueInputList;
	@FindBy(xpath = "//td[contains(@data-ng-class,'Treatment.tr_name_emphasis')]/following-sibling::td//input[@ng-model='tretChildOne.Treatment.discount']")
	private List<WebElement> discountInputList;
	@FindBy(xpath = "//td[contains(@data-ng-class,'Treatment.tr_name_emphasis')]/following-sibling::td//span[contains(@ng-class,'tretChildOne.Treatment.new_fee')]")
	private List<WebElement> amountPayInputList;
	@FindBy(xpath = "//td[contains(@data-ng-class,'Treatment.tr_name_emphasis')]/following-sibling::td//select[@ng-model='tretChildOne.Treatment.remarks']")
	private List<WebElement> couponsInputList;
	@FindBy(xpath = "//td[contains(@data-ng-class,'Treatment.tr_name_emphasis')]/following-sibling::td//a[contains(@class,'trtDeleteIcn')]")
	private List<WebElement> singleTrtDeleteInputList;
	@FindBy(xpath = "//td[contains(@data-ng-class,'Treatment.tr_name_emphasis')]/..")
	private List<WebElement> treatmentsDetail;
	@FindBy(xpath = "//div[contains(@class,'modal-tooth-tissue-box ng-scope')]//span")
	private List<WebElement> provisional;
	@FindBy(xpath = "//span[text()='Treatment(s) could not be started. Please update patient Covid-19 Declaration!']")
	private WebElement covidUpdateAlert;
	public WebElement getCreatBtn() {
		return creatBtn;
	}
	public WebElement getProductBtn() {
		return productBtn;
	}
	public WebElement getFindings() {
		return findings;
	}
	public WebElement getNewTeeth() {
		return NewTeeth;
	}
	public WebElement getNoRecordMsg() {
		return noRecordMsg;
	}
	public WebElement getAllTeethBtn() {
		return AllTeethBtn;
	}
	public WebElement getByQuadrantBtn() {
		return ByQuadrantBtn;
	}
	public WebElement getByArchBtn() {
		return byArchBtn;
	}
	public WebElement getHeader() {
		return header;
	}
	public WebElement getYesOnMultiselect() {
		return yesOnMultiselect;
	}
	public WebElement getTitleOfPopup() {
		return titleOfPopup;
	}
	public WebElement getCloseBtn() {
		return closeBtn;
	}
	public WebElement getTreatmentGroups() {
		return treatmentGroups;
	}
	public WebElement getSearchBox() {
		return searchBox;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getConsultation_XRays() {
		return consultation_XRays;
	}
	public WebElement getEndo() {
		return endo;
	}
	public WebElement getMinorOralSurgery() {
		return minorOralSurgery;
	}
	public WebElement getExtractions() {
		return extractions;
	}
	public WebElement getProsthoExceptCrowns() {
		return prosthoExceptCrowns;
	}
	public WebElement getCrowns() {
		return crowns;
	}
	public WebElement getImplantCrowns() {
		return implantCrowns;
	}
	public WebElement getOrtho() {
		return ortho;
	}
	public WebElement getPerio() {
		return perio;
	}
	public WebElement getAlignersLMB() {
		return alignersLMB;
	}
	public WebElement getAlignersOthers() {
		return alignersOthers;
	}
	public WebElement getPedo() {
		return pedo;
	}
	public WebElement getImplantsAB() {
		return implantsAB;
	}
	public WebElement getImplantsNobel() {
		return implantsNobel;
	}
	public WebElement getImplantOthers() {
		return implantOthers;
	}
	public WebElement getBoneGraftAndMembranesPRF() {
		return boneGraftAndMembranesPRF;
	}
	public WebElement getLasers() {
		return lasers;
	}
	public WebElement getIp_CDOP_Bank() {
		return ip_CDOP_Bank;
	}
	public WebElement getMembership() {
		return membership;
	}
	public WebElement getOthers() {
		return others;
	}
	public List<WebElement> getTreatments() {
		return treatments;
	}
	public WebElement getOralExamBtn() {
		return oralExamBtn;
	}
	public WebElement getWithoutTreatmentMsg() {
		return withoutTreatmentMsg;
	}
	public WebElement getPartOfBridgeChkBx() {
		return partOfBridgeChkBx;
	}
	public WebElement getCloseBtnOralExam() {
		return closeBtnOralExam;
	}
	public WebElement getSaveBtnOralExam() {
		return saveBtnOralExam;
	}
	public WebElement getLip() {
		return lip;
	}
	public WebElement getCheek() {
		return cheek;
	}
	public WebElement getTongue() {
		return Tongue;
	}
	public WebElement getFloorOfMouth() {
		return FloorOfMouth;
	}
	public WebElement getPalate() {
		return Palate;
	}
	public WebElement getGingiva() {
		return Gingiva;
	}
	public WebElement getVestibule() {
		return Vestibule;
	}
	public WebElement getFrenum() {
		return Frenum;
	}
	public WebElement getSalivaryGland() {
		return SalivaryGland;
	}
	public WebElement getLymphNodes() {
		return LymphNodes;
	}
	public List<WebElement> getProvisionalRemoveBtnSoftTissue() {
		return provisionalRemoveBtnSoftTissue;
	}
	public WebElement getIOPARBtn() {
		return IOPARBtn;
	}
	public WebElement getIOPARNotes() {
		return IOPARNotes;
	}
	public List<WebElement> getProvisinals() {
		return Provisinals;
	}
	public WebElement getSelectedTreatment() {
		return selectedTreatment;
	}
	public WebElement getYesForDelete() {
		return yesForDelete;
	}
	public WebElement getDeleteSuccessMessage() {
		return deleteSuccessMessage;
	}
	public WebElement getEditBtnTreatmentInputList() {
		return editBtnTreatmentInputList;
	}
	public WebElement getSaveBtnOnInputList() {
		return SaveBtnOnInputList;
	}
	public WebElement getBuccal() {
		return Buccal;
	}
	public WebElement getWithoutCouponMsg() {
		return withoutCouponMsg;
	}
	public WebElement getSourceInputList() {
		return sourceInputList;
	}
	public WebElement getStartInputList() {
		return startInputList;
	}
	public WebElement getTreatmentInputList() {
		return treatmentInputList;
	}
	public WebElement getTypeInputList() {
		return typeInputList;
	}
	public WebElement getUnitCostInputList() {
		return unitCostInputList;
	}
	public WebElement getNetAmtInputList() {
		return netAmtInputList;
	}
	public WebElement getCouponInputList() {
		return couponInputList;
	}
	public WebElement getAmtPayInputList() {
		return AmtPayInputList;
	}
	public WebElement getCouponBasisInputList() {
		return couponBasisInputList;
	}
	public WebElement getActionInputList() {
		return actionInputList;
	}
	public List<WebElement> getTreatmentsInputList() {
		return treatmentsInputList;
	}
	public List<WebElement> getCheckBoxInputList() {
		return checkBoxInputList;
	}
	public List<WebElement> getTreatmentTypeInputList() {
		return treatmentTypeInputList;
	}
	public List<WebElement> getUnitPriceNetPriceInputlist() {
		return unitPriceNetPriceInputlist;
	}
	public List<WebElement> getDiscountTypeInputList() {
		return discountTypeInputList;
	}
	public List<WebElement> getDiscountValueInputList() {
		return discountValueInputList;
	}
	public List<WebElement> getDiscountInputList() {
		return discountInputList;
	}
	public List<WebElement> getAmountPayInputList() {
		return amountPayInputList;
	}
	public List<WebElement> getCouponsInputList() {
		return couponsInputList;
	}
	public List<WebElement> getSingleTrtDeleteInputList() {
		return singleTrtDeleteInputList;
	}
	public List<WebElement> getTreatmentsDetail() {
		return treatmentsDetail;
	}
	public List<WebElement> getProvisional() {
		return provisional;
	}
	public WebElement getCovidUpdateAlert() {
		return covidUpdateAlert;
	}



}
