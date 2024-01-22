package pages.patientDashboard;

import utils.TestData;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

/**
 * 
 * @author Ajit Yadav
 *
 */
public class OralExamsPage {

	
	@FindBy(xpath = "//a[text()='Teeth']")
	private WebElement teeth;
	@FindBy(xpath = "//a[text()='Tissue']")
	private WebElement tissue;
	@FindBy(xpath = "//b[text()='Adult']")
	private WebElement adult;
	@FindBy(xpath = "//b[text()='Pedo']")
	private WebElement pedo;
	@FindBy(xpath = "//b[text()='Mixed']")
	private WebElement mixed;
	@FindBy(xpath = "//b[text()='Soft']")
	private WebElement soft;
	@FindBy(xpath = "//b[text()='Hard']")
	private WebElement hard;
	@FindBy(xpath = "//li[text()='Chief Complaint(s)']")
	private WebElement chiefComplaints;
	@FindBy(xpath = "//span[@alt='Add chief complaint(s)']")
	private WebElement chiefComplaintsAddBtn;
	@FindBy(id = "oralexamselectallbtn")
	private WebElement AllTeeth;
	@FindBy(xpath = "//div[contains(@class,'sideNavigation hidden-xs visible-sm visible-md visible-lg')]//i[contains(text(),'Diagnostic')]")
	private WebElement diagnostic;
	@FindBy(xpath = "//div[contains(@class,'sideNavigation hidden-xs visible-sm visible-md visible-lg')]//i[contains(text(),'Treatment')]")
	private WebElement treatment;
	@FindBy(xpath = "//div[contains(@class,'sideNavigation hidden-xs visible-sm visible-md visible-lg')]//i[contains(text(),'File')]")
	private WebElement file;
	@FindBy(css = "h1[class='btmTitle pull-left ng-binding']")
	private WebElement title;
	@FindBy(xpath = "//div[@id='adult']//li")
	private List<WebElement> adultTeeths;
	@FindBy(xpath = "//div[@id='pedo']//li")
	private List<WebElement> pedoTeeths;
	@FindBy(xpath = "//div[@id='mixed']//li")
	private List<WebElement> mixedTeeths;

	// ---------webelement in tissue------
	@FindBy(css = "li[ng-show=\"tissueCategory === 'HardTissue'\"]")
	private List<WebElement> hardProvisionals;
	@FindBy(css = "li[ng-show=\"tissueCategory === 'SoftTissue'\"]")
	private List<WebElement> softProvisionals;

	// ------------------webelements in the popup after seleting the tooth
	// image-----
	@FindBy(id = "obpopupmodalheader")
	private WebElement titlePopup;
	@FindBy(xpath = "//div[@id='toothViewPopup']//span[@class='cmnicons cncl-mdl']")
	private WebElement closeBtnOnTeethPopup;
	@FindBy(xpath = "//div[@id='confirmbox']//span[@class='cmnicons yes-mdl']")
	private WebElement yesOnMultiselect;
	@FindBy(xpath = "//ul[@id='observationpopupul']//span[@class='ng-binding']/following-sibling::span")
	private List<WebElement> removeBtn;
	@FindBy(xpath = "//div[@id='toothViewPopup']//a[text()='Tooth Site & Perio']")
	public WebElement toothSitePerio;
	@FindBy(xpath = "//span[text()='Buccal']")
	private WebElement Buccal;
	@FindBy(xpath = "//span[text()='Distal']")
	private WebElement Distal;
	@FindBy(xpath = "//span[text()='Mesial']")
	private WebElement Mesial;
	@FindBy(xpath = "//span[contains(text(),'Occlusal')]")
	private WebElement Occlusal;
	@FindBy(xpath = "//span[text()='Palatal']")
	private WebElement Palatal;
	@FindBy(xpath = "//span[text()='All Surface']")
	private WebElement AllSurface;
	@FindBy(xpath = "//span[text()='Perio']")
	private WebElement Perio;
	@FindBy(xpath = "//div[@class='content']")
	private List<WebElement> Provisinals;
	@FindBy(xpath = "//i[text()='IOPAR']")
	private WebElement IOPARBtn;
	@FindBy(id = "ioprRemark")
	private WebElement IOPARNotes;
	@FindBy(id = "toothObservationRemark")
	private WebElement toothObservationRemark;
	@FindBy(xpath = "//textarea[@id='ioprRemark']/following-sibling::span")
	private WebElement ioparWordlimitMsg;
	@FindBy(xpath = "//textarea[@id='toothObservationRemark']/following-sibling::span")
	private WebElement notesWordlimitMsg;
	@FindBy(xpath = "//div[@id='toothViewPopup']//span[@class='cmnicons sv-mdl']")
	private WebElement saveBtn;
	@FindBy(xpath = "//div[contains(@ng-click,'removetoothSitesItems')]//a[@class='remove-button']")
	private List<WebElement> provisionalRemoveBtnToothSite;

	// ------------------for soft tissue on popup--------
	@FindBy(xpath = "//div[@id='observationpopupbtn']/../../..//a[text()='Soft Tissue']")
	private WebElement softTissue;
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
	@FindBy(xpath = "//div[contains(@ng-click,'softDiagno.ProvisionalDiagnostic.bsId')]")
	private List<WebElement> SoftTissueProvisinals;
	@FindBy(xpath = "//div[contains(@ng-click,'removeToothSoftTissueItems')]//a[@class='remove-button']")
	private List<WebElement> provisionalRemoveBtnSoftTissue;

	// ------------------------webelement of hard tissue in popup---
	@FindBy(xpath = "//div[@id='toothViewPopup']//a[text()='Hard Tissue']")
	private WebElement HardTissueOnPopUp;
	@FindBy(xpath = "//span[text()='Mandibular Angle']")
	private WebElement MandibularAngle;
	@FindBy(xpath = "//div[@ng-click='addToothHardTissue(hTissues.id, hTissues.title)']//span[text()='Mandibular Body']")
	private WebElement MandibularBody;
	@FindBy(xpath = "//span[text()='Maxillary Tuberosity']")
	private WebElement MaxillaryTuberosity;
	@FindBy(xpath = "//span[text()='Posterior Maxilla']")
	private WebElement PosteriorMaxilla;
	@FindBy(xpath = "//span[text()='Pre-Maxilla']")
	private WebElement PreMaxilla;
	@FindBy(xpath = "//span[text()='Maxillary Sinus']")
	private WebElement MaxillarySinus;
	@FindBy(xpath = "//span[text()='Mandibular Symphysis']")
	private WebElement MandibularSymphysis;
	@FindBy(xpath = "//span[text()='TM Joint']")
	private WebElement TMJoint;
	@FindBy(xpath = "//div[contains(@ng-click,'hDiadgnos.ProvisionalDiagnostic.id')]")
	private List<WebElement> HardProvisinalsInPopup;
	@FindBy(xpath = "//div[contains(@ng-click,'removeToothHardTissueItems')]//a[@class='remove-button']")
	private List<WebElement> provisionalRemoveBtnHardTissue;

	
	//-----------------------------------------------------------------------------------------------------
	@FindBy(xpath = "//h5[text()='Mandibular Angle']" ) // changed the xpath from "//span[text()='Mandibular Angle']")
	private WebElement MandibularAngleOnPopup;
	@FindBy(xpath = "//h5[text()='Mandibular Body']")
	private WebElement MandibularBodyOnPopup;
	@FindBy(xpath = "//h5[text()='Maxillary Tuberosity']")
	private WebElement MaxillaryTuberosityOnPopup;
	@FindBy(xpath = "//h5[text()='Posterior Maxilla']")
	private WebElement PosteriorMaxillaOnPopup;
	@FindBy(xpath = "//h5[text()='Pre-Maxilla']")
	private WebElement PreMaxillaOnPopup;
	@FindBy(xpath = "//h5[text()='Maxillary Sinus']")
	private WebElement MaxillarySinusOnPopup;
	@FindBy(xpath = "//h5[text()='Mandibular Symphysis']")
	private WebElement MandibularSymphysisOnPopup;
	@FindBy(xpath = "//h5[text()='TM Joint']")
	private WebElement TMJointOnPopup;
	//-----------------------------------------------------------------------------------------------------

	// ---------------webelment of chief complaints on oral page-------------------
	@FindBy(xpath = "//span[@alt='Edit added chief complaint(s)']")
	private WebElement chiefComplaintEditBtn;

	// ------------------WebElement and function of teeth---------------------
	@FindBy(xpath = "//b[@class='ng-binding']")
	private WebElement AllTeethText;

	// ------------------webelement and reusable method of input list------------
	@FindBy(xpath = "//th[text()='Tooth No.']")
	private WebElement ToothNo;
	@FindBy(xpath = "//th[text()='Tooth Site & Perio']")
	private WebElement ToothSitePerioInputList;
	@FindBy(xpath = "//th[text()='Soft Tissue']")
	private WebElement SoftTissueInputList;
	@FindBy(xpath = "//th[text()='Hard Tissue']")
	private WebElement HardTissueInputList;
	@FindBy(xpath = "//th[text()='Notes']")
	private WebElement NotesInputList;
	@FindBy(xpath = "//th[text()='Action']")
	private WebElement ActionInputList;
	@FindBy(xpath = "//h5[contains(text(),'Mandibular Angle')]")
	private WebElement mandibularAngle;
	@FindBy(xpath = "//span[@class='tooth17 mrgnTop_7']")
	private WebElement newTeethList;
	@FindBy(xpath = "//a[contains(text(),'New Teeth')]")
	private WebElement newTeethHeader;
	
	private static final String TODAY_DATE =TestData.getInstance().getTodayDate();

	public WebElement getMandibularAngleOnPopup() {
		return MandibularAngleOnPopup;
	}
	
	public WebElement getMandibularBodyOnPopup() {
		return MandibularBodyOnPopup;
	}
	
	public WebElement getMaxillaryTuberosityOnPopup() {
		return MaxillaryTuberosityOnPopup;
	}
	
	public WebElement getPosteriorMaxillaOnPopup() {
		return PosteriorMaxillaOnPopup;
	}
	
	public WebElement getPreMaxillaOnPopup() {
		return PreMaxillaOnPopup;
	}
	
	public WebElement getMaxillarySinusOnPopup() {
		return MaxillarySinusOnPopup;
	}
	
	public WebElement getMandibularSymphysisOnPopup() {
		return MandibularSymphysisOnPopup;
	}
	
	public WebElement getTMJointOnPopup() {
		return TMJointOnPopup;
	}
	public WebElement getTeeth() {
		return teeth;
	}

	public WebElement getTissue() {
		return tissue;
	}

	public WebElement getAdult() {
		return adult;
	}

	public WebElement getPedo() {
		return pedo;
	}

	public WebElement getMixed() {
		return mixed;
	}

	public WebElement getSoft() {
		return soft;
	}

	public WebElement getHard() {
		return hard;
	}

	public WebElement getChiefComplaints() {
		return chiefComplaints;
	}

	public WebElement getChiefComplaintsAddBtn() {
		return chiefComplaintsAddBtn;
	}

	public WebElement getAllTeeth() {
		return AllTeeth;
	}

	public WebElement getDiagnostic() {
		return diagnostic;
	}

	public WebElement getTreatment() {
		return treatment;
	}

	public WebElement getFile() {
		return file;
	}

	public WebElement getTitle() {
		return title;
	}

	public List<WebElement> getAdultTeeths() {
		return adultTeeths;
	}

	public List<WebElement> getPedoTeeths() {
		return pedoTeeths;
	}

	public List<WebElement> getMixedTeeths() {
		return mixedTeeths;
	}

	public List<WebElement> getHardProvisionals() {
		return hardProvisionals;
	}

	public List<WebElement> getSoftProvisionals() {
		return softProvisionals;
	}

	public WebElement getTitlePopup() {
		return titlePopup;
	}

	public WebElement getCloseBtnOnTeethPopup() {
		return closeBtnOnTeethPopup;
	}

	public WebElement getYesOnMultiselect() {
		return yesOnMultiselect;
	}

	public List<WebElement> getRemoveBtn() {
		return removeBtn;
	}

	public WebElement getToothSitePerio() {
		return toothSitePerio;
	}

	public WebElement getBuccal() {
		return Buccal;
	}

	public WebElement getDistal() {
		return Distal;
	}

	public WebElement getMesial() {
		return Mesial;
	}

	public WebElement getOcclusal() {
		return Occlusal;
	}

	public WebElement getPalatal() {
		return Palatal;
	}

	public WebElement getAllSurface() {
		return AllSurface;
	}

	public WebElement getPerio() {
		return Perio;
	}

	public List<WebElement> getProvisinals() {
		return Provisinals;
	}

	public WebElement getIOPARBtn() {
		return IOPARBtn;
	}

	public WebElement getIOPARNotes() {
		return IOPARNotes;
	}

	public WebElement getToothObservationRemark() {
		return toothObservationRemark;
	}

	public WebElement getIoparWordlimitMsg() {
		return ioparWordlimitMsg;
	}

	public WebElement getNotesWordlimitMsg() {
		return notesWordlimitMsg;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public List<WebElement> getProvisionalRemoveBtnToothSite() {
		return provisionalRemoveBtnToothSite;
	}

	public WebElement getSoftTissue() {
		return softTissue;
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

	public List<WebElement> getSoftTissueProvisinals() {
		return SoftTissueProvisinals;
	}

	public List<WebElement> getProvisionalRemoveBtnSoftTissue() {
		return provisionalRemoveBtnSoftTissue;
	}

	public WebElement getHardTissueOnPopUp() {
		return HardTissueOnPopUp;
	}

	public WebElement getMandibularAngle() {
		return MandibularAngle;
	}

	public WebElement getMandibularBody() {
		return MandibularBody;
	}

	public WebElement getMaxillaryTuberosity() {
		return MaxillaryTuberosity;
	}

	public WebElement getPosteriorMaxilla() {
		return PosteriorMaxilla;
	}

	public WebElement getPreMaxilla() {
		return PreMaxilla;
	}

	public WebElement getMaxillarySinus() {
		return MaxillarySinus;
	}

	public WebElement getMandibularSymphysis() {
		return MandibularSymphysis;
	}

	public WebElement getTMJoint() {
		return TMJoint;
	}

	public List<WebElement> getHardProvisinalsInPopup() {
		return HardProvisinalsInPopup;
	}

	public List<WebElement> getProvisionalRemoveBtnHardTissue() {
		return provisionalRemoveBtnHardTissue;
	}

	public WebElement getChiefComplaintEditBtn() {
		return chiefComplaintEditBtn;
	}

	public WebElement getAllTeethText() {
		return AllTeethText;
	}

	public WebElement getToothNo() {
		return ToothNo;
	}

	public WebElement getToothSitePerioInputList() {
		return ToothSitePerioInputList;
	}

	public WebElement getSoftTissueInputList() {
		return SoftTissueInputList;
	}

	public WebElement getHardTissueInputList() {
		return HardTissueInputList;
	}

	public WebElement getNotesInputList() {
		return NotesInputList;
	}

	public WebElement getActionInputList() {
		return ActionInputList;
	}

	public WebElement getNewTeethList() {
		return newTeethList;
	}

	public WebElement getNewTeethHeader() {
		return newTeethHeader;
	}

	public static String getTodayDate() {
		return TODAY_DATE;
	}

	
	
	
	
}
