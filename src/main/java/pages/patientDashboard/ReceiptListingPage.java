package pages.patientDashboard;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReceiptListingPage {

	/*Receipt Listing WebElements*/
	@FindBy(id = "urgentPatientNamePid")
	private WebElement patientNameReceiptListing;
	@FindBy(xpath = "//div[@id='noRecordFound']//i[contains(text(),'No Record Found')]")
	private WebElement NoRecordFoundMsg;
	@FindBy(xpath="//h1[@class='btmTitle pull-left wdthFull headerCenter pos-abs dis-block']")
	private WebElement headerReceiptListing;
	@FindBy(id = "sendReceipts")
	private WebElement sendReceiptBtn;
	@FindBy(css	= "span[class='cmnicons srch']")
	private WebElement searchBtn;
	@FindBy(id = "fromDate")
	private WebElement fromDateField;
	@FindBy(id = "toDate")
	private WebElement toDateField;
	@FindBy(xpath="//span[text()='Show Details']")
	private WebElement showDetailsBtn;
	@FindBy(xpath = "//div[@class='amtDueAdv']//b[text()='Amount Due Rs.']")
	private WebElement AmountDueText;
	@FindBy(xpath= "//div[@class='amtDueAdv']")
	private WebElement dueAmount;
	@FindBy(xpath = "//div[@class='amtDueAdv']//b[text()='Advance Rs.']")
	private WebElement AdvanceAmountText;
	@FindBy(id= "rcpttotalAdvanceAmount")
	private WebElement advanceAmount;
	@FindBy(xpath="//table[@id='receiptsListTable']/tbody/tr")
	private List<WebElement> rowTreatmentColumn;
	@FindBy(xpath= "//table[@id='receiptsListTable']//th[text()='Date']")
	private WebElement dateHead;
	@FindBy(xpath= "//table[@id='receiptsListTable']//th[contains(text(),'Receipt')]")
	private WebElement receiptHead;
	@FindBy(xpath= "//table[@id='receiptsListTable']//th[contains(text(),'Invoice')]")
	private WebElement invoiceHead;
	@FindBy(xpath= "//table[@id='receiptsListTable']//th[text()='Amount Paid']")
	private WebElement amountPaidHead;
	@FindBy(xpath= "//table[@id='receiptsListTable']//th[text()='Payment Method']")
	private WebElement paymentMethodHead;
	@FindBy(xpath= "//table[@id='receiptsListTable']//th[text()='Void Ptr Id/Status']")
	private WebElement ptrIdAndStatusHead;
	@FindBy(xpath= "//table[@id='receiptsListTable']//th[text()='Doctor']")
	private WebElement doctorHead;
	@FindBy(xpath= "//table[@id='receiptsListTable']//th[text()='Action']")
	private WebElement actionHead;
	@FindBy(xpath = "//div[@id='receiptView']//span[contains(@class,'cmnicons cncl-mdl')]")
	private WebElement closeViewModal;
	//web element of Receipt view modal
	@FindBy(xpath = "//h4[text()='Receipt Details']")
	private WebElement receiptHeaderInView;
	@FindBy(id = "urgentPatientName")
	private WebElement patientNameViewModal;
	@FindBy(id = "urgentPatientPID")
	private WebElement patientIdViewModal;
	@FindBy(xpath = "//div[contains(text(),'Info')]")
	private WebElement infoHeadInView;
	@FindBy(xpath = "//b[text()='Receipt no.']")
	private WebElement receiptNoHeadInView;
	@FindBy(xpath = "//b[text()='Receipt Date']")
	private WebElement receiptDateHeadInView;
	@FindBy(xpath = "//div[contains(text(),'Payment Details')]")
	private WebElement paymentDetailsHeadInView;
	@FindBy(xpath = "//b[text()='Amount Received']")
	private WebElement amountReceivedHeadInView;
	@FindBy(xpath = "//b[text()='Mode Of Payment']")
	private WebElement modePaymentHeadInView;
	@FindBy(xpath = "//b[text()='Received As']")
	private WebElement receivedAsHeadInView;
	@FindBy(xpath = "//div[contains(text(),'Notes')]")
	private WebElement notesHeadInView;
	@FindBy(xpath = "//b[text()='Receipt no.']/../following-sibling::span")
	private WebElement receiptNumViewModal;
	@FindBy(xpath = "//b[text()='Receipt Date']/../following-sibling::span")
	private WebElement receiptDate;
	@FindBy(xpath = "//b[text()='Amount Received']/../following-sibling::div")
	private WebElement amountReceive;
	@FindBy(xpath = "//b[text()='Mode Of Payment']/../following-sibling::div")
	private WebElement modePayment;
	@FindBy(xpath = "//b[text()='Received As']/../following-sibling::div")
	private WebElement receivedAs;
	@FindBy(xpath = "//div[contains(text(),'Notes')]/following-sibling::div/div[@id='receiptPopUpNotes']")
	private WebElement notes;
	/*Delete Pop up */
	@FindBy(xpath = "//div[text()='Delete Receipt']")
	private WebElement deleteReasonHead;
	@FindBy(id = "deleteSelect")
	private WebElement reasonDrpDwn;
	@FindBy(xpath="//button[contains(@class,'yesDeleteButton')]//span[@class='cmnicons sv-mdl']")
	private WebElement reasonSaveBtn;
	@FindBy(xpath = "//div[contains(text(),'Receipt deleted successfully!')]")
	private WebElement successfullMsg;
	@FindBy(xpath = "//span[@class='cmnicons payInvoice']")
	private WebElement payInvoiceBtn;
	public WebElement getPatientNameReceiptListing() {
		return patientNameReceiptListing;
	}
	public WebElement getNoRecordFoundMsg() {
		return NoRecordFoundMsg;
	}
	public WebElement getHeaderReceiptListing() {
		return headerReceiptListing;
	}
	public WebElement getSendReceiptBtn() {
		return sendReceiptBtn;
	}
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	public WebElement getFromDateField() {
		return fromDateField;
	}
	public WebElement getToDateField() {
		return toDateField;
	}
	public WebElement getShowDetailsBtn() {
		return showDetailsBtn;
	}
	public WebElement getAmountDueText() {
		return AmountDueText;
	}
	public WebElement getDueAmount() {
		return dueAmount;
	}
	public WebElement getAdvanceAmountText() {
		return AdvanceAmountText;
	}
	public WebElement getAdvanceAmount() {
		return advanceAmount;
	}
	public List<WebElement> getRowTreatmentColumn() {
		return rowTreatmentColumn;
	}
	public WebElement getDateHead() {
		return dateHead;
	}
	public WebElement getReceiptHead() {
		return receiptHead;
	}
	public WebElement getInvoiceHead() {
		return invoiceHead;
	}
	public WebElement getAmountPaidHead() {
		return amountPaidHead;
	}
	public WebElement getPaymentMethodHead() {
		return paymentMethodHead;
	}
	public WebElement getPtrIdAndStatusHead() {
		return ptrIdAndStatusHead;
	}
	public WebElement getDoctorHead() {
		return doctorHead;
	}
	public WebElement getActionHead() {
		return actionHead;
	}
	public WebElement getCloseViewModal() {
		return closeViewModal;
	}
	public WebElement getReceiptHeaderInView() {
		return receiptHeaderInView;
	}
	public WebElement getPatientNameViewModal() {
		return patientNameViewModal;
	}
	public WebElement getPatientIdViewModal() {
		return patientIdViewModal;
	}
	public WebElement getInfoHeadInView() {
		return infoHeadInView;
	}
	public WebElement getReceiptNoHeadInView() {
		return receiptNoHeadInView;
	}
	public WebElement getReceiptDateHeadInView() {
		return receiptDateHeadInView;
	}
	public WebElement getPaymentDetailsHeadInView() {
		return paymentDetailsHeadInView;
	}
	public WebElement getAmountReceivedHeadInView() {
		return amountReceivedHeadInView;
	}
	public WebElement getModePaymentHeadInView() {
		return modePaymentHeadInView;
	}
	public WebElement getReceivedAsHeadInView() {
		return receivedAsHeadInView;
	}
	public WebElement getNotesHeadInView() {
		return notesHeadInView;
	}
	public WebElement getReceiptNumViewModal() {
		return receiptNumViewModal;
	}
	public WebElement getReceiptDate() {
		return receiptDate;
	}
	public WebElement getAmountReceive() {
		return amountReceive;
	}
	public WebElement getModePayment() {
		return modePayment;
	}
	public WebElement getReceivedAs() {
		return receivedAs;
	}
	public WebElement getNotes() {
		return notes;
	}
	public WebElement getDeleteReasonHead() {
		return deleteReasonHead;
	}
	public WebElement getReasonDrpDwn() {
		return reasonDrpDwn;
	}
	public WebElement getReasonSaveBtn() {
		return reasonSaveBtn;
	}
	public WebElement getSuccessfullMsg() {
		return successfullMsg;
	}
	public WebElement getPayInvoiceBtn() {
		return payInvoiceBtn;
	}

}
