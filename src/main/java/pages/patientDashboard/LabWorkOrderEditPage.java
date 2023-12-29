package pages.patientDashboard;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LabWorkOrderEditPage {
	
	/*Web Elements in Edit screen*/
	@FindBy(xpath="//h1[@class='pull-left ng-binding']")
	private WebElement headerOfPage;
	
	@FindBy(xpath="//h1[@class='pull-left']")
	private WebElement headerOfReWorkPage;

	/*Work Details Panel WebElements*/
	/*Work Details Panel WebElements*/
	
	@FindBy(xpath="//span[contains(text(),'Work Details')]")
	private WebElement workDetailsPanel;
	@FindBy(xpath="//label[@for='clinicName']")
	private WebElement clinicNameInEdit;
	@FindBy(xpath="//div[contains(@class,'source_txt wrd-brk-all')]")
	private WebElement sourceInEdit;
	@FindBy(xpath="//div[contains(@class,'lab_txt')]")
	private WebElement labNoInEdit;
	@FindBy(xpath="//label[@for='Lab']")
	private WebElement labInEdit;
	@FindBy(id="Lab")
	private WebElement labDrpDwn;
	@FindBy(xpath="//label[@for='OrderType']")
	private WebElement orderTypeInEdit;
	@FindBy(xpath="//label[text()='Order Type']/following-sibling::div")
	private WebElement orderTypeTxtBxInEdit;
	@FindBy(xpath="//label[text()='Work Details']/following-sibling::div")
	private WebElement workDetailsTxtBxInEdit;
	@FindBy(xpath="//label[@for='WorkDetails']")
	private WebElement workDetailsInEdit;
	@FindBy(xpath="//label[@for='OtherInfo']")
	private WebElement otherInfoInEdit;
	@FindBy(xpath="//label[text()='Other Info']/following-sibling::div")
	private WebElement otherInfoTxtBxInEdit;
	@FindBy(xpath="//label[text()='Item(s) Send']")
	private WebElement itemSendInEdit;
	@FindBy(className="dropdown-toggle")
	private WebElement itemSendDrpDwn;
	@FindBy(id="updationReason")
	private WebElement updateReasonTxtBx;
	@FindBy(xpath="//span[text()='Add File(s)']")
	private WebElement AddfilesBtnInEdit;
	@FindBy(xpath="//span[@class='cmnicons yes-mdl']")
	private WebElement yesOnDelete;

	/*Additional Panel WebElements */
	@FindBy(xpath="//span[contains(text(),'Additional Details')]")
	private WebElement additionalDetailsPanel;
	@FindBy(xpath="//label[text()='Require']")
	private WebElement requireInEdit;
	@FindBy(id="require")
	private WebElement requireDrpDwn;
	@FindBy(xpath="//label[@for='Shade']")
	private WebElement shadeInEdit;
	@FindBy(xpath="//label[@for='classic']")
	private WebElement classicInEdit;
	@FindBy(id="shade")
	private WebElement shadeDrpDwn;
	@FindBy(xpath="//label[@for='3d']")
	private WebElement threeDInEdit;
	@FindBy(xpath="//label[@for='na']")
	private WebElement naInEdit;
	@FindBy(xpath="//label[text()='Stains Internal']")
	private WebElement stainsInternalInEdit;
	@FindBy(id="Stains Internal")
	private WebElement stainsInternalDrpDwn;
	@FindBy(xpath="//label[text()='Stains External']")
	private WebElement stainsExternalInEdit;
	@FindBy(id="Stains External")
	private WebElement stainsExternalDrpDwn;
	@FindBy(xpath="//label[text()='Translucency']")
	private WebElement translucencyInEdit;
	@FindBy(id="address")
	private WebElement translucencyTxtBx;
	@FindBy(xpath="//label[text()='Texture']")
	private WebElement textureInEdit;
	@FindBy(id="texture")
	private WebElement textureTxtBx;
	@FindBy(xpath="//label[text()='Configurations']")
	private WebElement configurationsInEdit;
	@FindBy(xpath="//label[text()='Individual']")
	private WebElement individualInEdit;
	@FindBy(xpath="//label[text()='Splinted (Joined)']")
	private WebElement splintedJoinedInEdit;
	@FindBy(xpath = "//span[text()='Buccal']")
	private WebElement Buccal;
	@FindBy(xpath = "//span[text()='Distal']")
	private WebElement Distal;
	@FindBy(xpath = "//span[text()='Mesial']")
	private WebElement Mesial;
	@FindBy(xpath = "//span[text()='Lingual']")
	private WebElement Lingual;
	@FindBy(xpath = "//div[@class='content']")
	private List<WebElement> Provisinals;
	@FindBy(xpath = "//div[contains(@ng-click,'removeSelectedConfiguration')]//a[@class='remove-button']")
	private List<WebElement> provisionalRemoveBtnToothSite;
	@FindBy(xpath="//label[text()='Notes']")
	private WebElement notesInEdit;
	@FindBy(id="crownnotes")
	private WebElement notesTxtBx;

	/*Buttons in LabWorkOrder Edit Screen*/
	@FindBy(xpath="(//i[text()='Save as Draft'])[1]")
	private WebElement saveAsDraftInEdit;
	@FindBy(xpath="(//i[text()='Submit to Lab'])[1]")
	private WebElement submittedToLabInEdit;
	@FindBy(xpath="(//i[text()='Reset'])[1]")
	private WebElement resetInEdit;
	@FindBy(xpath="(//i[text()='Cancel'])[1]")
	private WebElement cancelInEdit;
	
	
	public WebElement getWorkDetailsPanel() {
		return workDetailsPanel;
	}
	public WebElement getClinicNameInEdit() {
		return clinicNameInEdit;
	}
	public WebElement getSourceInEdit() {
		return sourceInEdit;
	}
	public WebElement getLabNoInEdit() {
		return labNoInEdit;
	}
	public WebElement getLabInEdit() {
		return labInEdit;
	}
	public WebElement getLabDrpDwn() {
		return labDrpDwn;
	}
	public WebElement getOrderTypeInEdit() {
		return orderTypeInEdit;
	}
	public WebElement getOrderTypeTxtBxInEdit() {
		return orderTypeTxtBxInEdit;
	}
	public WebElement getWorkDetailsTxtBxInEdit() {
		return workDetailsTxtBxInEdit;
	}
	public WebElement getWorkDetailsInEdit() {
		return workDetailsInEdit;
	}
	public WebElement getOtherInfoInEdit() {
		return otherInfoInEdit;
	}
	public WebElement getOtherInfoTxtBxInEdit() {
		return otherInfoTxtBxInEdit;
	}
	public WebElement getItemSendInEdit() {
		return itemSendInEdit;
	}
	public WebElement getItemSendDrpDwn() {
		return itemSendDrpDwn;
	}
	public WebElement getUpdateReasonTxtBx() {
		return updateReasonTxtBx;
	}
	public WebElement getAddfilesBtnInEdit() {
		return AddfilesBtnInEdit;
	}
	public WebElement getYesOnDelete() {
		return yesOnDelete;
	}
	public WebElement getAdditionalDetailsPanel() {
		return additionalDetailsPanel;
	}
	public WebElement getRequireInEdit() {
		return requireInEdit;
	}
	public WebElement getRequireDrpDwn() {
		return requireDrpDwn;
	}
	public WebElement getShadeInEdit() {
		return shadeInEdit;
	}
	public WebElement getClassicInEdit() {
		return classicInEdit;
	}
	public WebElement getShadeDrpDwn() {
		return shadeDrpDwn;
	}
	public WebElement getThreeDInEdit() {
		return threeDInEdit;
	}
	public WebElement getNaInEdit() {
		return naInEdit;
	}
	public WebElement getStainsInternalInEdit() {
		return stainsInternalInEdit;
	}
	public WebElement getStainsInternalDrpDwn() {
		return stainsInternalDrpDwn;
	}
	public WebElement getStainsExternalInEdit() {
		return stainsExternalInEdit;
	}
	public WebElement getStainsExternalDrpDwn() {
		return stainsExternalDrpDwn;
	}
	public WebElement getTranslucencyInEdit() {
		return translucencyInEdit;
	}
	public WebElement getTranslucencyTxtBx() {
		return translucencyTxtBx;
	}
	public WebElement getTextureInEdit() {
		return textureInEdit;
	}
	public WebElement getTextureTxtBx() {
		return textureTxtBx;
	}
	public WebElement getConfigurationsInEdit() {
		return configurationsInEdit;
	}
	public WebElement getIndividualInEdit() {
		return individualInEdit;
	}
	public WebElement getSplintedJoinedInEdit() {
		return splintedJoinedInEdit;
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
	public WebElement getLingual() {
		return Lingual;
	}
	public List<WebElement> getProvisinals() {
		return Provisinals;
	}
	public List<WebElement> getProvisionalRemoveBtnToothSite() {
		return provisionalRemoveBtnToothSite;
	}
	public WebElement getNotesInEdit() {
		return notesInEdit;
	}
	public WebElement getNotesTxtBx() {
		return notesTxtBx;
	}
	public WebElement getSaveAsDraftInEdit() {
		return saveAsDraftInEdit;
	}
	public WebElement getSubmittedToLabInEdit() {
		return submittedToLabInEdit;
	}
	public WebElement getResetInEdit() {
		return resetInEdit;
	}
	public WebElement getCancelInEdit() {
		return cancelInEdit;
	}

	public WebElement getHeaderOfPage() {
		return headerOfPage;
	}
	public WebElement getHeaderOfReWorkPage() {
		return headerOfReWorkPage;
	}
	
}
