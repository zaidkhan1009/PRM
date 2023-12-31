package pages.patientDashboard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

/**
 * @Author:-Ajit Yadav
 * email:-ajit.yadav@instantsys.com
 * Date:-15-05-20
 */
public class InvoiceListingPage {
	

	/*--webElement of Invoice List page------*/
	@FindBy(xpath = "//a[contains(@href,'receiptsList')]//i[text()='Receipts']")
	private WebElement receiptsListBtn;
	@FindBy(xpath = "//h1[contains(@class,'btmTitle')]")
	private WebElement headerPage;
	@FindBy(xpath = "//span[contains(@class,'mdl-hdr-text')]")
	private WebElement userName;
	@FindBy(id = "Status")
	private WebElement treatmentStatusDropDown;
	@FindBy(id = "Invoice Status")
	private WebElement invoiceStatusDropDown;
	@FindBy(xpath = "//input[@id='showInvoiceDeleted']/following-sibling::label[text()='Show Details']")
	private WebElement showDetailCheckBox;
	@FindBy(xpath = "//span[@class='cmnicons srch']/../following-sibling::i[text()='Search']")
	private WebElement invoiceListSearchBtn;
	@FindBy(xpath = "//span[@class='cmnicons rst']/../following-sibling::i[text()='Reset']")
	private WebElement resetBtn;
	@FindBy(xpath = "(//div[@class='amtDueAdv']/p/span[@class='txt_orng ng-binding'])[1]")
	private WebElement totalDueAmount;
	@FindBy(xpath = "(//div[@class='amtDueAdv']/p/span[@class='txt_orng ng-binding'])[2]")
	private WebElement totalAdvanceAmount;
	@FindBy(xpath = "(//span[@class='btnLabel ng-binding'])[1]")
	private WebElement collectAdvanceBtn;
	@FindBy(xpath = "(//span[@class='actn-icn pay'])[1]")
	private WebElement collectPaymentBtn;
	@FindBy(xpath = "//i[text()='No Record Found']")
	private WebElement noRecordFoundText;
	@FindBy(className = "dashboardViewIcon")
	private WebElement invoiceViewIcon;
	@FindBy(className = "dashboardDiscountIcon")
	private WebElement invoiceDiscountIcon;
	@FindBy(className = "dashboardPaymentIcon")
	private WebElement invoicePaymentIcon;
	@FindBy(className = "dashboardRecieptIcon1")
	private WebElement invoiceListRecieptIcon;
	@FindBy(className = "dashboardDeleteIcon")
	private WebElement invoiceDeleteIcon;
	@FindBy(className = "dashboardPrintIcon")
	private WebElement invoicePrintIcon;
	// table column name
	@FindBy(xpath = "//table[@class='table table-striped']/thead/tr/th[text()='Date']")
	private WebElement date;
	@FindBy(xpath = "//table[@class='table table-striped']/thead/tr/th[text()='Invoice #']")
	private WebElement invoice;
	@FindBy(xpath = "//table[@class='table table-striped']/thead/tr/th[text()='Trt. Status']")
	private WebElement treatmentStatus;
	@FindBy(xpath = "//table[@class='table table-striped']/thead/tr/th[text()='Net. Amt.']")
	private WebElement netAmount;
	@FindBy(xpath = "//table[@class='table table-striped']/thead/tr/th[text()='Cpn. Amt.']")
	private WebElement couponAmount;
	@FindBy(xpath = "//table[@class='table table-striped']/thead/tr/th[text()='Amt. Due']")
	private WebElement amountDue;
	@FindBy(xpath = "//table[@class='table table-striped']/thead/tr/th[text()='Amt. Paid']")
	private WebElement amountPaid;
	@FindBy(xpath = "//table[@class='table table-striped']/thead/tr/th[text()='Doctor']")
	private WebElement doctor;
	@FindBy(xpath = "//table[@class='table table-striped']/thead/tr/th[text()='Action']")
	private WebElement actionBtn;
	@FindBy(xpath = "//table[@class='table table-striped']/thead/tr/th[text()='Correction Note(s)']")
	private WebElement correctionNotes;
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr")
	private List<WebElement> allRowsInvoices;

	//web element of invoice view modal
	@FindBy(xpath = "//h4[text()='Invoice Details']")
	private WebElement headerViewModal;
	@FindBy(xpath = "//form[@id='invoiceViewForm']//span[contains(@class,'txt_medgry')]")
	private WebElement patientNameViewModal;
	@FindBy(xpath = "//form[@id='invoiceViewForm']//span[contains(@class,'txt_medgry')]/following-sibling::span")
	private WebElement patientIdViewModal;
	@FindBy(xpath = "//form[@id='invoiceViewForm']//span[contains(@class,'cmnicons sv-mdl')]")
	private WebElement saveBtnViewModal;
	@FindBy(xpath = "//form[@id='invoiceViewForm']//span[contains(@class,'cmnicons cncl-mdl')]")
	private WebElement viewModalCloseModal;
	@FindBy(xpath = "//b[text()='Invoice No.']/ancestor::div/following-sibling::span")
	private WebElement invoiceNoViewModal;
	@FindBy(xpath = "//b[text()='Invoice Date']/ancestor::div/following-sibling::span")
	private WebElement invoiceDateViewModal;
	@FindBy(xpath = "//b[text()='Total Due on invoice']/../..")
	private WebElement totalDueViewModal;
	@FindBy(xpath = "//div[contains(text(),'Item Details')]")
	private WebElement headerItemDetails;
	@FindBy(xpath = "//form[@id='invoiceViewForm']//table/thead//th[text()='Treatment Name']")
	private WebElement treatmentNameColumnViewModal;
	@FindBy(xpath = "//form[@id='invoiceViewForm']//table/thead//th[text()='Unit Cost']")
	private WebElement unitCostColumnViewModal;
	@FindBy(xpath = "//form[@id='invoiceViewForm']//table/thead//th[text()='Source(s)']")
	private WebElement sourceColumnViewModal;
	@FindBy(xpath = "//form[@id='invoiceViewForm']//table/thead//th[text()='Net. Amt.']")
	private WebElement netAmtColumnViewModal;
	@FindBy(xpath = "//form[@id='invoiceViewForm']//table/thead//th[text()='Cpn. Val.']")
	private WebElement cpnValColumnViewModal;
	@FindBy(xpath = "//form[@id='invoiceViewForm']//table/thead//th[text()='Coupon Basis']")
	private WebElement couponBasisColumnViewModal;
	@FindBy(xpath = "//form[@id='invoiceViewForm']//table/thead//th[text()='Amt. Pay.']")
	private WebElement AmtPayColumnViewModal;
	@FindBy(xpath = "//div[contains(text(),'Item Details')]/following-sibling::div//tbody/tr")
	private List<WebElement> itemDetailTreatmentViewModal;
	@FindBy(xpath = "//div[contains(text(),'Item Details')]/following-sibling::div//tfoot/tr")
	private List<WebElement> amountIndicate;
	@FindBy(xpath = "//strong[contains(text(),'Total Amount Payable:')]//../following-sibling::td")
	private WebElement totalPayableAmountViewModal;
	//web element of correction notes
	@FindBy(xpath = "//div[contains(text(),'Correction Details')]")
	private WebElement headerCorrectionDetails;
	@FindBy(xpath = "//div[contains(text(),'Correction Details')]/following-sibling::div//tbody/tr")
	private List<WebElement> rowCorrectionDetailsTreatment;
	//web element of the notes
	@FindBy(xpath = "//textarea[@id='invoicenotes']/../../preceding-sibling::div[contains(text(),'Notes')]")
	private List<WebElement> noteHeader;
	@FindBy(xpath = "//textarea[@id='invoicenotes']/../../preceding-sibling::div[contains(text(),'Notes and Notes History')]")
	private List<WebElement> noteHeader_entered;
	@FindBy(id = "invoicenotes")
	private WebElement noteTextFields;
	@FindBy(xpath = "//textarea[@id='invoicenotes']/following-sibling::span[text()='Max. 64 characters left']")
	private WebElement maxCharMsg;
	@FindBy(xpath = "//div[text()='Enter notes!']")
	private WebElement errorNoteMsg;
	@FindBy(xpath = "//tr[@data-ng-repeat='list in invNotesData']/../preceding-sibling::thead//th[text()='Date']")
	private WebElement notesDateColumn;
	@FindBy(xpath = "//tr[@data-ng-repeat='list in invNotesData']/../preceding-sibling::thead//th[text()='Created By']")
	private WebElement notesCreatedByColumn;
	@FindBy(xpath = "//tr[@data-ng-repeat='list in invNotesData']/../preceding-sibling::thead//th[text()='Notes']")
	private WebElement notesNotesColumn;
	@FindBy(xpath = "//table[@class='table table-striped']//tr[@data-ng-repeat='list in invNotesData']")
	private  List<WebElement> notesRow;
	//coupon amount web element
	@FindBy(xpath = "//h4[text()='Apply/Re-Apply Coupon']")
	private WebElement headerCouponModal;
	@FindBy(xpath = "//span[contains(@class,'pnameid')]")
	private WebElement patientNameCoupon;
	@FindBy(xpath = "//div[contains(text(),'Info')]")
	private WebElement headerInfo;
	@FindBy(xpath = "//b[text()='Invoice No.']/../following-sibling::span")
	private WebElement invoiceNoCouponModal;
	@FindBy(xpath = "//b[text()='Invoice Date']/../following-sibling::span")
	private WebElement invoiceDateCouponModal;
	@FindBy(xpath = "//b[text()='Remaining Amt. Due']/../following-sibling::span[@class='ng-binding']")
	private WebElement remainingAmountDueCouponModal;
	@FindBy(xpath = "//form[@id='invoiceCouponForm']//div[contains(text(),'Treatment')]")
	private WebElement treatmentCouponModal;
	@FindBy(xpath = "//div[contains(@class,'col-xs')]//thead/tr/th[text()='Source']")
	private WebElement sourceCouponColumn;
	@FindBy(xpath = "//div[contains(@class,'col-xs')]//thead/tr/th[text()='Name']")
	private WebElement treatmentCouponColumn;
	@FindBy(xpath = "//div[contains(@class,'col-xs')]//thead/tr/th[text()='Unit Cost']")
	private WebElement unitCostCouponColumn;
	@FindBy(xpath = "//div[contains(@class,'col-xs')]//thead/tr/th[text()='Net Amt.']")
	private WebElement netAmountCouponColumn;
	@FindBy(xpath = "//div[contains(@class,'col-xs')]//thead/tr/th[text()='Type']")
	private WebElement typeCouponColumn;
	@FindBy(xpath = "//div[contains(@class,'col-xs')]//thead/tr/th[text()='Coupon(By Amt)']")
	private WebElement cpnValCouponColumn;
	@FindBy(xpath = "//div[contains(@class,'col-xs')]//thead/tr/th[text()='Amt. Due']")
	private WebElement AmtPayCouponColumn;
	@FindBy(xpath = "//div[contains(@class,'col-xs')]//thead/tr/th[text()='Coupon Basis']")
	private WebElement couponBasisCouponColumn;
	@FindBy(xpath = "//div[contains(@class,'col-xs')]//tbody/tr[contains(@data-ng-repeat,'invoiceCouponData')]")
	private List<WebElement> rowTreatmentColumn;
	@FindBy(xpath = "//div[contains(text(),'Coupon Correction Notes')]")
	private WebElement couponAdjustmentNotes;
	@FindBy(id = "cpn_notes")
	private WebElement couponNoteTextFields;
	@FindBy(xpath = "//textarea[@id='cpn_notes']/following-sibling::span[text()='768 characters left']")
	private WebElement couponAdjustmentCahrLimit;
	@FindBy(xpath = "//span[@class='cmnicons sv-mdl']")
	private WebElement saveBtnModal;
	@FindBy(xpath = "//span[@class='cmnicons cncl-mdl']")
	private WebElement closeBtnBtn;
	@FindBy(xpath = "//strong[contains(text(),'Total Amount Payable')]/../following-sibling::td")
	private WebElement amountPayableTabular;
	@FindBy(xpath = "//span[contains(text(),'Please select Coupon(s) basis!')]")
	private WebElement couponBasisMandatoryMsg;
	@FindBy(xpath = "//span[contains(text(),'There is no changes to save!')]")
	private WebElement msgWithoutChanges;
	@FindBy(xpath = "//span[contains(text(),'Please update Coupon value or Coupon Basis to add Coupon Correction Notes!')]")
	private WebElement updateCouponValueCouponBasAddCouponAdjustmentNotes;
	//web element of the delete modal
	@FindBy(xpath = "//h4[text()='Invoice Delete']")
	private WebElement headerDelete;
	@FindBy(xpath = "//h4[text()='Invoice Delete']/following-sibling::span")
	private WebElement patientNameDelete;
	@FindBy(xpath = "//b[text()='Total Due on Invoice']/../following-sibling::span[@class='ng-binding']")
	private WebElement totalDueInvoiceDeleteModal;
	@FindBy(xpath = "//form[@id='deleteReasonForm']//span[@class='cmnicons sv-mdl']")
	private WebElement saveBtnDeleteModal;
	@FindBy(xpath = "//form[@id='deleteReasonForm']//span[@class='cmnicons cncl-mdl']")
	private WebElement closeBtnDeleteModal;
	@FindBy(xpath = "//div[contains(text(),'Info')]")
	private WebElement headerInfoDeleteModal;
	@FindBy(xpath = "//div[contains(text(),'Invoice/Treatment(s) Deletion Reason')]")
	private WebElement headerDeletionReason;
	@FindBy(xpath = "//label[contains(text(),'Reasons')]")
	private WebElement reasonDrpDwnHeader;
	@FindBy(id = "reasons")
	private WebElement reasonDrpdwn;
	@FindBy(xpath = "//form[@id='deleteReasonForm']//thead/tr/th//div[@class='cstm_rdb_ckb']")
	private WebElement invoiceDeleteCheckbox;
	@FindBy(xpath = "//form[@id='deleteReasonForm']//thead/tr/th[text()='Name']")
	private WebElement nameColumnDeleteModal;
	@FindBy(xpath = "//form[@id='deleteReasonForm']//thead/tr/th[text()='Unit Cost']")
	private WebElement unitCostColumnDeleteModal;
	@FindBy(xpath = "//form[@id='deleteReasonForm']//thead/tr/th[text()='Source(s)']")
	private WebElement sourceColumnDeleteModal;
	@FindBy(xpath = "//form[@id='deleteReasonForm']//thead/tr/th[text()='Net Amt.']")
	private WebElement netAmountColumnDeleteModal;
	@FindBy(xpath = "//form[@id='deleteReasonForm']//thead/tr/th[text()='Cpn. Amt.']")
	private WebElement cpnAmountColumnDeleteModal;
	@FindBy(xpath = "//form[@id='deleteReasonForm']//thead/tr/th[text()='Cpn. Basis']")
	private WebElement cpnBasisColumnDeleteModal;
	@FindBy(xpath = "//form[@id='deleteReasonForm']//thead/tr/th[text()='Amt. Pay.']")
	private WebElement amountPayColumnDeleteModal;
	@FindBy(xpath = "//form[@id='deleteReasonForm']//tbody/tr")
	private List<WebElement> rowDeleteModal;
	@FindBy(xpath = "//div[text()='Select Reason!']")
	private WebElement reasonErrorMsg;
	@FindBy(xpath = "//span[contains(text(),'Please select Treatment(s) to delete!')]")
	private WebElement msgTreatmentNotSelected;
	@FindBy(xpath = "//span[contains(text(),'Invoice/Trt deleted successfully!']")
	private WebElement deleteSuccessMsg;
	@FindBy(xpath = "(//span[@class='txt_orng ng-binding'])[1]")
	private WebElement dueAmnt;
	@FindBy(xpath = "(//span[@class='txt_orng ng-binding'])[2]")
	private WebElement advAmt;
	@FindBy(xpath = "(//span[contains(text(),'Coupon')])[1]")
	private WebElement cupn;
	@FindBy(xpath = "//span[@class='actn-icn delete']")
	private WebElement deleteBtn;
	@FindBy(xpath = "//div[@class='alert ng-isolate-scope alert-success alert-dismissable']")
	private WebElement alertMessage;
	
	
	public WebElement getReceiptsListBtn() {
		return receiptsListBtn;
	}
	public WebElement getHeaderPage() {
		return headerPage;
	}
	public WebElement getUserName() {
		return userName;
	}
	public WebElement getTreatmentStatusDropDown() {
		return treatmentStatusDropDown;
	}
	public WebElement getInvoiceStatusDropDown() {
		return invoiceStatusDropDown;
	}
	public WebElement getShowDetailCheckBox() {
		return showDetailCheckBox;
	}
	public WebElement getInvoiceListSearchBtn() {
		return invoiceListSearchBtn;
	}
	public WebElement getResetBtn() {
		return resetBtn;
	}
	public WebElement getTotalDueAmount() {
		return totalDueAmount;
	}
	public WebElement getTotalAdvanceAmount() {
		return totalAdvanceAmount;
	}
	public WebElement getCollectAdvanceBtn() {
		return collectAdvanceBtn;
	}
	public WebElement getCollectPaymentBtn() {
		return collectPaymentBtn;
	}
	public WebElement getNoRecordFoundText() {
		return noRecordFoundText;
	}
	public WebElement getInvoiceViewIcon() {
		return invoiceViewIcon;
	}
	public WebElement getInvoiceDiscountIcon() {
		return invoiceDiscountIcon;
	}
	public WebElement getInvoicePaymentIcon() {
		return invoicePaymentIcon;
	}
	public WebElement getInvoiceListRecieptIcon() {
		return invoiceListRecieptIcon;
	}
	public WebElement getInvoiceDeleteIcon() {
		return invoiceDeleteIcon;
	}
	public WebElement getInvoicePrintIcon() {
		return invoicePrintIcon;
	}
	public WebElement getDate() {
		return date;
	}
	public WebElement getInvoice() {
		return invoice;
	}
	public WebElement getTreatmentStatus() {
		return treatmentStatus;
	}
	public WebElement getNetAmount() {
		return netAmount;
	}
	public WebElement getCouponAmount() {
		return couponAmount;
	}
	public WebElement getAmountDue() {
		return amountDue;
	}
	public WebElement getAmountPaid() {
		return amountPaid;
	}
	public WebElement getDoctor() {
		return doctor;
	}
	public WebElement getActionBtn() {
		return actionBtn;
	}
	public WebElement getCorrectionNotes() {
		return correctionNotes;
	}
	public List<WebElement> getAllRowsInvoices() {
		return allRowsInvoices;
	}
	public WebElement getHeaderViewModal() {
		return headerViewModal;
	}
	public WebElement getPatientNameViewModal() {
		return patientNameViewModal;
	}
	public WebElement getPatientIdViewModal() {
		return patientIdViewModal;
	}
	public WebElement getSaveBtnViewModal() {
		return saveBtnViewModal;
	}
	public WebElement getViewModalCloseModal() {
		return viewModalCloseModal;
	}
	public WebElement getInvoiceNoViewModal() {
		return invoiceNoViewModal;
	}
	public WebElement getInvoiceDateViewModal() {
		return invoiceDateViewModal;
	}
	public WebElement getTotalDueViewModal() {
		return totalDueViewModal;
	}
	public WebElement getHeaderItemDetails() {
		return headerItemDetails;
	}
	public WebElement getTreatmentNameColumnViewModal() {
		return treatmentNameColumnViewModal;
	}
	public WebElement getUnitCostColumnViewModal() {
		return unitCostColumnViewModal;
	}
	public WebElement getSourceColumnViewModal() {
		return sourceColumnViewModal;
	}
	public WebElement getNetAmtColumnViewModal() {
		return netAmtColumnViewModal;
	}
	public WebElement getCpnValColumnViewModal() {
		return cpnValColumnViewModal;
	}
	public WebElement getCouponBasisColumnViewModal() {
		return couponBasisColumnViewModal;
	}
	public WebElement getAmtPayColumnViewModal() {
		return AmtPayColumnViewModal;
	}
	public List<WebElement> getItemDetailTreatmentViewModal() {
		return itemDetailTreatmentViewModal;
	}
	public List<WebElement> getAmountIndicate() {
		return amountIndicate;
	}
	public WebElement getTotalPayableAmountViewModal() {
		return totalPayableAmountViewModal;
	}
	public WebElement getHeaderCorrectionDetails() {
		return headerCorrectionDetails;
	}
	public List<WebElement> getRowCorrectionDetailsTreatment() {
		return rowCorrectionDetailsTreatment;
	}
	public List<WebElement> getNoteHeader() {
		return noteHeader;
	}
	public List<WebElement> getNoteHeader_entered() {
		return noteHeader_entered;
	}
	public WebElement getNoteTextFields() {
		return noteTextFields;
	}
	public WebElement getMaxCharMsg() {
		return maxCharMsg;
	}
	public WebElement getErrorNoteMsg() {
		return errorNoteMsg;
	}
	public WebElement getNotesDateColumn() {
		return notesDateColumn;
	}
	public WebElement getNotesCreatedByColumn() {
		return notesCreatedByColumn;
	}
	public WebElement getNotesNotesColumn() {
		return notesNotesColumn;
	}
	public List<WebElement> getNotesRow() {
		return notesRow;
	}
	public WebElement getHeaderCouponModal() {
		return headerCouponModal;
	}
	public WebElement getPatientNameCoupon() {
		return patientNameCoupon;
	}
	public WebElement getHeaderInfo() {
		return headerInfo;
	}
	public WebElement getInvoiceNoCouponModal() {
		return invoiceNoCouponModal;
	}
	public WebElement getInvoiceDateCouponModal() {
		return invoiceDateCouponModal;
	}
	public WebElement getRemainingAmountDueCouponModal() {
		return remainingAmountDueCouponModal;
	}
	public WebElement getTreatmentCouponModal() {
		return treatmentCouponModal;
	}
	public WebElement getSourceCouponColumn() {
		return sourceCouponColumn;
	}
	public WebElement getTreatmentCouponColumn() {
		return treatmentCouponColumn;
	}
	public WebElement getUnitCostCouponColumn() {
		return unitCostCouponColumn;
	}
	public WebElement getNetAmountCouponColumn() {
		return netAmountCouponColumn;
	}
	public WebElement getTypeCouponColumn() {
		return typeCouponColumn;
	}
	public WebElement getCpnValCouponColumn() {
		return cpnValCouponColumn;
	}
	public WebElement getAmtPayCouponColumn() {
		return AmtPayCouponColumn;
	}
	public WebElement getCouponBasisCouponColumn() {
		return couponBasisCouponColumn;
	}
	public List<WebElement> getRowTreatmentColumn() {
		return rowTreatmentColumn;
	}
	public WebElement getCouponAdjustmentNotes() {
		return couponAdjustmentNotes;
	}
	public WebElement getCouponNoteTextFields() {
		return couponNoteTextFields;
	}
	public WebElement getCouponAdjustmentCahrLimit() {
		return couponAdjustmentCahrLimit;
	}
	public WebElement getSaveBtnModal() {
		return saveBtnModal;
	}
	public WebElement getCloseBtnBtn() {
		return closeBtnBtn;
	}
	public WebElement getAmountPayableTabular() {
		return amountPayableTabular;
	}
	public WebElement getCouponBasisMandatoryMsg() {
		return couponBasisMandatoryMsg;
	}
	public WebElement getMsgWithoutChanges() {
		return msgWithoutChanges;
	}
	public WebElement getUpdateCouponValueCouponBasAddCouponAdjustmentNotes() {
		return updateCouponValueCouponBasAddCouponAdjustmentNotes;
	}
	public WebElement getHeaderDelete() {
		return headerDelete;
	}
	public WebElement getPatientNameDelete() {
		return patientNameDelete;
	}
	public WebElement getTotalDueInvoiceDeleteModal() {
		return totalDueInvoiceDeleteModal;
	}
	public WebElement getSaveBtnDeleteModal() {
		return saveBtnDeleteModal;
	}
	public WebElement getCloseBtnDeleteModal() {
		return closeBtnDeleteModal;
	}
	public WebElement getHeaderInfoDeleteModal() {
		return headerInfoDeleteModal;
	}
	public WebElement getHeaderDeletionReason() {
		return headerDeletionReason;
	}
	public WebElement getReasonDrpDwnHeader() {
		return reasonDrpDwnHeader;
	}
	public WebElement getReasonDrpdwn() {
		return reasonDrpdwn;
	}
	public WebElement getInvoiceDeleteCheckbox() {
		return invoiceDeleteCheckbox;
	}
	public WebElement getNameColumnDeleteModal() {
		return nameColumnDeleteModal;
	}
	public WebElement getUnitCostColumnDeleteModal() {
		return unitCostColumnDeleteModal;
	}
	public WebElement getSourceColumnDeleteModal() {
		return sourceColumnDeleteModal;
	}
	public WebElement getNetAmountColumnDeleteModal() {
		return netAmountColumnDeleteModal;
	}
	public WebElement getCpnAmountColumnDeleteModal() {
		return cpnAmountColumnDeleteModal;
	}
	public WebElement getCpnBasisColumnDeleteModal() {
		return cpnBasisColumnDeleteModal;
	}
	public WebElement getAmountPayColumnDeleteModal() {
		return amountPayColumnDeleteModal;
	}
	public List<WebElement> getRowDeleteModal() {
		return rowDeleteModal;
	}
	public WebElement getReasonErrorMsg() {
		return reasonErrorMsg;
	}
	public WebElement getMsgTreatmentNotSelected() {
		return msgTreatmentNotSelected;
	}
	public WebElement getDeleteSuccessMsg() {
		return deleteSuccessMsg;
	}
	public WebElement getDueAmnt() {
		return dueAmnt;
	}
	public WebElement getAdvAmt() {
		return advAmt;
	}
	public WebElement getCupn() {
		return cupn;
	}
	public WebElement getDeleteBtn() {
		return deleteBtn;
	}
	public WebElement getAlertMessage() {
		return alertMessage;
	}


	
	
}
