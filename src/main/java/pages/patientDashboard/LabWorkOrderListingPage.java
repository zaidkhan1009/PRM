package pages.patientDashboard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LabWorkOrderListingPage {
	
	

	/*Web Elements in LWO listing*/
	@FindBy(xpath="//i[text()='No Record Found!']")
	private WebElement noRecordMsg;
	@FindBy(xpath="//h1[contains(@class,'btmTitle')]")
	private WebElement headerOfPage;
	@FindBy(xpath="//i[text()='DashBoard']")
	private WebElement dashBoardBtn;
	@FindBy(xpath = "//span[contains(text(),'Lab Work Order updated successfully!')]")
	private WebElement successfullMsg;
	@FindBy(xpath = "//span[contains(text(),'Reorder has been created successfully')]")
	private WebElement successfullMsgForReWork;

	/*WebElements in View modal*/
	@FindBy(xpath="//h4[@class='modal-title col-sm-6 col-md-2 col-lg-2 text-left hidden-xs']")
	private WebElement headingView;
	@FindBy(xpath="//div[contains(@class,'nogap text-center hidden-sm ')]")
	private WebElement patientNameInView;
	@FindBy(xpath="//div[@class='col-xs-12 col-md-3 col-lg-3 nogap hidden-sm']")
	private WebElement labNoView;
	@FindBy(xpath="(//div[contains(@class,'text-right hidden-xs')])[2]")
	private WebElement dateInView;
	@FindBy(xpath="(//div[@class='modal-body viewInfo lwoViewStyle']/h4)[1]")
	private WebElement workDeatilHeadView;
	@FindBy(xpath="//b[text()='Lab']")
	private WebElement labView;
	@FindBy(xpath="//b[text()='Order Type']")
	private WebElement orderTypeView;
	@FindBy(xpath="//b[text()='Work Details']")
	private WebElement workDeatilView;
	@FindBy(xpath="//b[text()='Other Info']")
	private WebElement otherInfoView;
	@FindBy(xpath="//b[text()='Source']")
	private WebElement sourceView;
	@FindBy(xpath="//b[text()='Item(s) Sent']")
	private WebElement itemSentView;
	@FindBy(xpath="//h4[text()='Additional Details']")
	private WebElement additionalDeatilsHeadView;
	@FindBy(xpath="//b[text()='Require']")
	private WebElement requireView;
	@FindBy(xpath="//b[text()='Shade']")
	private WebElement shadeView;
	@FindBy(xpath="//b[text()='Stains Internal']")
	private WebElement stainsInternalView;
	@FindBy(xpath="//b[text()='Stains External']")
	private WebElement stainsExternalView;
	@FindBy(xpath="//b[text()='Translucency']")
	private WebElement translucencyView;
	@FindBy(xpath="//b[text()='Texture']")
	private WebElement textureView;
	@FindBy(xpath="//b[text()='Configurations']")
	private WebElement configurationView;
	@FindBy(xpath="//b[text()='Surface Details']")
	private WebElement surfaceDetailsView;
	@FindBy(xpath="//b[text()='Notes']")
	private WebElement notesView;
	@FindBy(xpath="//h4[text()='Notes and Attachments']")
	private WebElement notesAttachView;
	@FindBy(xpath="//h4[text()='Timeline']")
	private WebElement timelineView;
	@FindBy(xpath="(//div[text()='Draft'])[1]")
	private WebElement draftView;
	@FindBy(xpath="(//div[text()='Submitted To Lab'])[1]")
	private WebElement submittedView;
	@FindBy(xpath="(//div[text()='Treatment Completed'])[1]")
	private WebElement treatCompletedView;
	@FindBy(xpath="(//div[text()='Payment Completed'])[1]")
	private WebElement payCompletedView;
	@FindBy(xpath="(//div[text()='Payable'])[1]")
	private WebElement payableView;
	@FindBy(xpath="(//div[@class='graphPointer active draft'])[1]")
	private WebElement checkDraftActive;
	@FindBy(xpath="(//div[@class='graphPointer active submitted'])[1]")
	private WebElement checkPaymentCompletedActive;
	@FindBy(xpath="//span[@class='ng-binding ng-scope']")
	private WebElement configDataView;
	@FindBy(xpath="//h4[text()='Revision Details']")
	private WebElement revisionDetailsHeadView;
	@FindBy(xpath="//b[text()='Revision No']")
	private WebElement revisionNoHeadView;
	@FindBy(xpath="//b[text()='Revision No']/../following-sibling::div")
	private WebElement revisionNoView;
	@FindBy(xpath="//b[text()='Revision Date']")
	private WebElement revisionDateHeadView;
	@FindBy(xpath="//b[text()='Revision Date']/../following-sibling::div")
	private WebElement revisionDateView;
	@FindBy(xpath="//b[text()='Current Status']")
	private WebElement currentStatusHeadView;
	@FindBy(xpath="//b[text()='Current Status']/../following-sibling::div")
	private WebElement currentStatusView;
	@FindBy(xpath="//h4[contains(@class,'labviewhdr ng-binding ng-scope')]")
	private WebElement treatmentNameView;
	@FindBy(xpath="//span[@class='cmnicons cncl-mdl']")
	private WebElement closeViewScreen;
	
	
	public WebElement getNoRecordMsg() {
		return noRecordMsg;
	}
	public WebElement getHeaderOfPage() {
		return headerOfPage;
	}
	public WebElement getDashBoardBtn() {
		return dashBoardBtn;
	}
	public WebElement getSuccessfullMsg() {
		return successfullMsg;
	}
	public WebElement getSuccessfullMsgForReWork() {
		return successfullMsgForReWork;
	}
	public WebElement getHeadingView() {
		return headingView;
	}
	public WebElement getPatientNameInView() {
		return patientNameInView;
	}
	public WebElement getLabNoView() {
		return labNoView;
	}
	public WebElement getDateInView() {
		return dateInView;
	}
	public WebElement getWorkDeatilHeadView() {
		return workDeatilHeadView;
	}
	public WebElement getLabView() {
		return labView;
	}
	public WebElement getOrderTypeView() {
		return orderTypeView;
	}
	public WebElement getWorkDeatilView() {
		return workDeatilView;
	}
	public WebElement getOtherInfoView() {
		return otherInfoView;
	}
	public WebElement getSourceView() {
		return sourceView;
	}
	public WebElement getItemSentView() {
		return itemSentView;
	}
	public WebElement getAdditionalDeatilsHeadView() {
		return additionalDeatilsHeadView;
	}
	public WebElement getRequireView() {
		return requireView;
	}
	public WebElement getShadeView() {
		return shadeView;
	}
	public WebElement getStainsInternalView() {
		return stainsInternalView;
	}
	public WebElement getStainsExternalView() {
		return stainsExternalView;
	}
	public WebElement getTranslucencyView() {
		return translucencyView;
	}
	public WebElement getTextureView() {
		return textureView;
	}
	public WebElement getConfigurationView() {
		return configurationView;
	}
	public WebElement getSurfaceDetailsView() {
		return surfaceDetailsView;
	}
	public WebElement getNotesView() {
		return notesView;
	}
	public WebElement getNotesAttachView() {
		return notesAttachView;
	}
	public WebElement getTimelineView() {
		return timelineView;
	}
	public WebElement getDraftView() {
		return draftView;
	}
	public WebElement getSubmittedView() {
		return submittedView;
	}
	public WebElement getTreatCompletedView() {
		return treatCompletedView;
	}
	public WebElement getPayCompletedView() {
		return payCompletedView;
	}
	public WebElement getPayableView() {
		return payableView;
	}
	public WebElement getCheckDraftActive() {
		return checkDraftActive;
	}
	public WebElement getCheckPaymentCompletedActive() {
		return checkPaymentCompletedActive;
	}
	public WebElement getConfigDataView() {
		return configDataView;
	}
	public WebElement getRevisionDetailsHeadView() {
		return revisionDetailsHeadView;
	}
	public WebElement getRevisionNoHeadView() {
		return revisionNoHeadView;
	}
	public WebElement getRevisionNoView() {
		return revisionNoView;
	}
	public WebElement getRevisionDateHeadView() {
		return revisionDateHeadView;
	}
	public WebElement getRevisionDateView() {
		return revisionDateView;
	}
	public WebElement getCurrentStatusHeadView() {
		return currentStatusHeadView;
	}
	public WebElement getCurrentStatusView() {
		return currentStatusView;
	}
	public WebElement getTreatmentNameView() {
		return treatmentNameView;
	}
	public WebElement getCloseViewScreen() {
		return closeViewScreen;
	}

	
	
}
