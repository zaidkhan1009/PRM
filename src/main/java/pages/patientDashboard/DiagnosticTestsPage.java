package pages.patientDashboard;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DiagnosticTestsPage {


	/* webelement of the diagnostic add page */
	@FindBy(xpath = "//div[contains(@class,'sideNavigation hidden-xs visible-sm visible-md visible-lg')]//i[contains(text(),'Treatment')]")
	private WebElement treatmentButton;
	@FindBy(xpath = "//div[contains(@class,'sideNavigation hidden-xs visible-sm visible-md visible-lg')]//i[contains(text(),'Oral Exam')]")
	private WebElement oralExamButton;
	@FindBy(xpath = "//div[contains(@class,'sideNavigation hidden-xs visible-sm visible-md visible-lg')]//i[contains(text(),'File')]")
	private WebElement fileButton;
	@FindBy(xpath = "//button[contains(text(),'IOPAR')]")
	private WebElement ioparButton;
	@FindBy(xpath = "//button[contains(text(),'Imaging')]")
	private WebElement imagingButton;
	@FindBy(xpath = "//button[contains(text(),'Blood')]")
	private WebElement bloodButton;
	@FindBy(xpath = "//button[contains(text(),'Urine')]")
	private WebElement urineButton;
	@FindBy(xpath = "//button[contains(text(),'Bio- Chemical')]")
	private WebElement biochemicalButton;
	@FindBy(xpath = "//button[contains(text(),'Markers')]")
	private WebElement markersButton;
	@FindBy(xpath = "//span[@class='cmnicons sv-mdl']")
	private WebElement saveButton;
	@FindBy(xpath = "//button[@type='submit']/following-sibling::button[@class='close']")
	private WebElement closeButton;
	@FindBy(id = "testRemark")
	private WebElement diagnosticsNotes;
	@FindBy(xpath = "//span[contains(@class,'notestext')]")
	private WebElement notesLimitMsg;
//	@FindBy(xpath = "//div[contains(@class,'modal-header')]/h4[contains(@class,'modal-title')]")
//	private WebElement headerDiagnosis;
	
	@FindBy(xpath = "//div[contains(@class,'modal-header')]/..//h4")
	private WebElement headerDiagnosis;

	/* IOPAR Webelements */
	@FindBy(xpath = "//a[text()='Pedo']")
	private WebElement pedo;
	@FindBy(xpath = "//a[text()='Adult']")
	private WebElement adult;
	@FindBy(xpath = "//a[text()='Mixed']")
	private WebElement mixed;
	@FindBy(xpath = "//a[text()='Adult']/..")
	private WebElement selectedAdult;
	@FindBy(xpath = "//a[text()='Pedo']/..")
	private WebElement selectedPedo;
	@FindBy(xpath = "//a[text()='Mixed']/..")
	private WebElement selectedMixed;
	@FindBy(xpath = "//div[contains(@ng-include,'adultIOPAR.shtml')]//li")
	private List<WebElement> adultTeeths;
	@FindBy(xpath = "//div[contains(@ng-include,'pedoIOPAR.shtml')]//li")
	private List<WebElement> pedoTeeths;
	@FindBy(xpath = "//div[contains(@ng-include,'mixedIOPAR.shtml')]//li")
	private List<WebElement> mixedTeeths;

	/* Imaging WebElements */
	@FindBy(xpath = "//span[@class='ng-binding' and contains(text(),'OPG')]")
	private WebElement opg;
	@FindBy(xpath = "//span[@class='ng-binding' and contains(text(),'Lateral Cephalogram')]")
	private WebElement lateralCephalogram;
	@FindBy(xpath = "//span[@class='ng-binding' and contains(text(),'CBCT')]")
	private WebElement cBCT;
	@FindBy(xpath = "//span[@class='ng-binding' and contains(text(),'CECT')]")
	private WebElement cECT;
	@FindBy(xpath = "//span[@class='ng-binding' and contains(text(),'Bitewing')]")
	private WebElement bitewing;
	@FindBy(xpath = "//span[@class='ng-binding' and contains(text(),'Occlusal')]")
	private WebElement occlusal;
	@FindBy(xpath = "//span[@class='ng-binding' and contains(text(),'USG')]")
	private WebElement uSG;
	@FindBy(xpath = "//span[@class='ng-binding' and contains(text(),'Submentovertex')]")
	private WebElement submentovertex;
	@FindBy(xpath = "//span[@class='ng-binding' and contains(text(),'PA View')]")
	private WebElement pAView;
	@FindBy(xpath = "//span[@class='ng-binding' and contains(text(),'Occipeto-mental')]")
	private WebElement occipetoMental;

	/* Blood WebElements */
	@FindBy(xpath = "//span[text()='MCH']")
	private WebElement mCH;
	@FindBy(xpath = "//span[text()='MPV']")
	private WebElement mPV;
	@FindBy(xpath = "//span[text()='MCV']")
	private WebElement mCV;
	@FindBy(xpath = "//span[text()='MCHC']")
	private WebElement mCHC;
	@FindBy(xpath = "//span[text()='BT/CT']")
	private WebElement bT_CT;
	@FindBy(xpath = "//span[text()='Hematocrit']")
	private WebElement hematocrit;
	@FindBy(xpath = "//span[text()='Hemoglobin']")
	private WebElement hemoglobin;
	@FindBy(xpath = "//span[text()='Platlet Count']")
	private WebElement platletCount;
	@FindBy(xpath = "//span[text()='PT-INR']")
	private WebElement pT_INR;
	@FindBy(xpath = "//span[text()='RBC']")
	private WebElement rBC;
	@FindBy(xpath = "//span[text()='WBC']")
	private WebElement wBC;
	@FindBy(xpath = "//span[text()='RBS']")
	private WebElement rBS;
	@FindBy(xpath = "//span[text()='TLC']")
	private WebElement tLC;
	@FindBy(xpath = "//span[text()='DLC']")
	private WebElement dLC;
	@FindBy(xpath = "//span[text()='HbA1C']")
	private WebElement hbA1C;
	@FindBy(xpath = "//span[text()='Blood Sugar-Fasting']")
	private WebElement bloodSugarFasting;
	@FindBy(xpath = "//span[text()='Blood Sugar-PP']")
	private WebElement bloodSugarPP;

	/* Urine WebElements */
	@FindBy(xpath = "//span[text()='Urine Routine']")
	private WebElement urineRoutine;
	@FindBy(xpath = "//span[text()='Urine Microscopic']")
	private WebElement urineMicroscopic;

	/* Bio chemical WebElements */
	@FindBy(xpath = "//span[text()='LFT']")
	private WebElement lFT;
	@FindBy(xpath = "//span[text()='ALP']")
	private WebElement aLP;
	@FindBy(xpath = "//span[text()='ALT']")
	private WebElement aLT;
	@FindBy(xpath = "//span[text()='AST']")
	private WebElement aSt;
	@FindBy(xpath = "//span[text()='Bilirubin']")
	private WebElement bilirubin;
	@FindBy(xpath = "//span[text()='GGT']")
	private WebElement gGT;
	@FindBy(xpath = "//span[text()='Colour']")
	private WebElement colour;
	@FindBy(xpath = "//span[text()='Density']")
	private WebElement density;
	@FindBy(xpath = "//span[text()='P.H']")
	private WebElement pH;
	@FindBy(xpath = "//span[text()='Albumin']")
	private WebElement albumin;

	/* markers WebElements */
	@FindBy(xpath = "//span[text()='C-RP']")
	private WebElement C_RP;
	@FindBy(xpath = "//span[text()='Viral Antibodies (HIV&EBV)']")
	private WebElement ViralAntibodies;
	@FindBy(xpath = "//span[text()='Biopsy']")
	private WebElement biopsy;
	@FindBy(xpath = "//span[text()='Culture & Sensitivity']")
	private WebElement culture_Sensitivity;
	@FindBy(xpath = "//span[text()='Throat Swab']")
	private WebElement throatSwab;
	@FindBy(xpath = "//span[text()='PCR']")
	private WebElement pCR;

	/* input list and alert webelement */
	@FindBy(xpath = "//span[contains(text(),'Investigation(s) updated successfully')]")
	private WebElement diagnosisAddSuccessAlertMsg;
	@FindBy(xpath = "//span[contains(text(),'Please select an Investigation')]")
	private WebElement diagnosisSelectAlertMsg;
	@FindBy(xpath = "//span[contains(text(),'Please select a Tooth')]")
	private WebElement ioparToothSelectAlertMsg;
	@FindBy(xpath = "//table[@id='diagnoInputList']//th[text()='Category']")
	private WebElement categoryDiagnosisInputList;
	@FindBy(xpath = "//table[@id='diagnoInputList']//th[text()='Investigation']")
	private WebElement investigationDiagnosisInputList;
	@FindBy(xpath = "//table[@id='diagnoInputList']//th[text()='Notes']")
	private WebElement notesDiagnosisInputList;
	@FindBy(xpath = "//table[@id='diagnoInputList']//th[text()='Action']")
	private WebElement actionDiagnosisInputList;
	@FindBy(xpath = "//span[@class='cmnicons yes-mdl']")
	private WebElement yesDeleteBtn;
	@FindBy(xpath = "//span[@class='cmnicons cncl-mdl']")
	private WebElement noDeleteBtn;
	@FindBy(xpath = "//p[contains(text(),'Do you want to delete the selected Diagnostic(s) category')]")
	private WebElement deleteCategoryMsg;
	@FindBy(xpath = "//p[contains(text(),'Do you want to delete this investigation')]")
	private WebElement deleteInvestigationMsg;
	@FindBy(xpath = "//span[contains(text(),'Investication(s) deleted successfully')]")
	private WebElement diagnosisDeleteSuccessAlertMsg;
	
	
	
	public WebElement getTreatmentButton() {
		return treatmentButton;
	}
	public WebElement getOralExamButton() {
		return oralExamButton;
	}
	public WebElement getFileButton() {
		return fileButton;
	}
	public WebElement getIoparButton() {
		return ioparButton;
	}
	public WebElement getImagingButton() {
		return imagingButton;
	}
	public WebElement getBloodButton() {
		return bloodButton;
	}
	public WebElement getUrineButton() {
		return urineButton;
	}
	public WebElement getBiochemicalButton() {
		return biochemicalButton;
	}
	public WebElement getMarkersButton() {
		return markersButton;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	public WebElement getCloseButton() {
		return closeButton;
	}
	public WebElement getDiagnosticsNotes() {
		return diagnosticsNotes;
	}
	public WebElement getNotesLimitMsg() {
		return notesLimitMsg;
	}
	public WebElement getHeaderDiagnosis() {
		return headerDiagnosis;
	}
	public WebElement getPedo() {
		return pedo;
	}
	public WebElement getAdult() {
		return adult;
	}
	public WebElement getMixed() {
		return mixed;
	}
	public WebElement getSelectedAdult() {
		return selectedAdult;
	}
	public WebElement getSelectedPedo() {
		return selectedPedo;
	}
	public WebElement getSelectedMixed() {
		return selectedMixed;
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
	public WebElement getOpg() {
		return opg;
	}
	public WebElement getLateralCephalogram() {
		return lateralCephalogram;
	}
	public WebElement getcBCT() {
		return cBCT;
	}
	public WebElement getcECT() {
		return cECT;
	}
	public WebElement getBitewing() {
		return bitewing;
	}
	public WebElement getOcclusal() {
		return occlusal;
	}
	public WebElement getuSG() {
		return uSG;
	}
	public WebElement getSubmentovertex() {
		return submentovertex;
	}
	public WebElement getpAView() {
		return pAView;
	}
	public WebElement getOccipetoMental() {
		return occipetoMental;
	}
	public WebElement getmCH() {
		return mCH;
	}
	public WebElement getmPV() {
		return mPV;
	}
	public WebElement getmCV() {
		return mCV;
	}
	public WebElement getmCHC() {
		return mCHC;
	}
	public WebElement getbT_CT() {
		return bT_CT;
	}
	public WebElement getHematocrit() {
		return hematocrit;
	}
	public WebElement getHemoglobin() {
		return hemoglobin;
	}
	public WebElement getPlatletCount() {
		return platletCount;
	}
	public WebElement getpT_INR() {
		return pT_INR;
	}
	public WebElement getrBC() {
		return rBC;
	}
	public WebElement getwBC() {
		return wBC;
	}
	public WebElement getrBS() {
		return rBS;
	}
	public WebElement gettLC() {
		return tLC;
	}
	public WebElement getdLC() {
		return dLC;
	}
	public WebElement getHbA1C() {
		return hbA1C;
	}
	public WebElement getBloodSugarFasting() {
		return bloodSugarFasting;
	}
	public WebElement getBloodSugarPP() {
		return bloodSugarPP;
	}
	public WebElement getUrineRoutine() {
		return urineRoutine;
	}
	public WebElement getUrineMicroscopic() {
		return urineMicroscopic;
	}
	public WebElement getlFT() {
		return lFT;
	}
	public WebElement getaLP() {
		return aLP;
	}
	public WebElement getaLT() {
		return aLT;
	}
	public WebElement getaSt() {
		return aSt;
	}
	public WebElement getBilirubin() {
		return bilirubin;
	}
	public WebElement getgGT() {
		return gGT;
	}
	public WebElement getColour() {
		return colour;
	}
	public WebElement getDensity() {
		return density;
	}
	public WebElement getpH() {
		return pH;
	}
	public WebElement getAlbumin() {
		return albumin;
	}
	public WebElement getC_RP() {
		return C_RP;
	}
	public WebElement getViralAntibodies() {
		return ViralAntibodies;
	}
	public WebElement getBiopsy() {
		return biopsy;
	}
	public WebElement getCulture_Sensitivity() {
		return culture_Sensitivity;
	}
	public WebElement getThroatSwab() {
		return throatSwab;
	}
	public WebElement getpCR() {
		return pCR;
	}
	public WebElement getDiagnosisAddSuccessAlertMsg() {
		return diagnosisAddSuccessAlertMsg;
	}
	public WebElement getDiagnosisSelectAlertMsg() {
		return diagnosisSelectAlertMsg;
	}
	public WebElement getIoparToothSelectAlertMsg() {
		return ioparToothSelectAlertMsg;
	}
	public WebElement getCategoryDiagnosisInputList() {
		return categoryDiagnosisInputList;
	}
	public WebElement getInvestigationDiagnosisInputList() {
		return investigationDiagnosisInputList;
	}
	public WebElement getNotesDiagnosisInputList() {
		return notesDiagnosisInputList;
	}
	public WebElement getActionDiagnosisInputList() {
		return actionDiagnosisInputList;
	}
	public WebElement getYesDeleteBtn() {
		return yesDeleteBtn;
	}
	public WebElement getNoDeleteBtn() {
		return noDeleteBtn;
	}
	public WebElement getDeleteCategoryMsg() {
		return deleteCategoryMsg;
	}
	public WebElement getDeleteInvestigationMsg() {
		return deleteInvestigationMsg;
	}
	public WebElement getDiagnosisDeleteSuccessAlertMsg() {
		return diagnosisDeleteSuccessAlertMsg;
	}
	


	

}
