package pages.patientDashboard;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;


public class NewReceiptPage {
	
	/*New Receipts WebElements*/

	@FindBy(xpath="//h1[text()='New Receipts ']")
	private WebElement headerNewReceipt;
	@FindBy(xpath = "//h1[text()='New Receipts (Advance)']")
	private WebElement headerAdvanceNewReceipt;
	@FindBy(xpath="//h1[text()='Edit Receipts ']")
	private WebElement headerEditReceipt;
	@FindBy(xpath="//label[text()='Mode']")
	private WebElement modeHead;
	@FindBy(xpath="//label[text()='Cash']")
	private WebElement cashBtn;
	@FindBy(xpath="//label[text()='Card']")
	private WebElement cardBtn;
	@FindBy(xpath="//label[text()='Cheque']")
	private WebElement chequeBtn;

	@FindBy(xpath="//label[text()='Others']")
	private WebElement OthersBtn;
	@FindBy(xpath="//label[text()='NetBanking']")
	private WebElement netBankingBtn;
	@FindBy(xpath="//label[text()='Wallet']")
	private WebElement walletBtn;

	@FindBy(xpath="//label[text()='Others']")
	private WebElement othersBtn;
	@FindBy(xpath="//label[text()='Sub Type']")
	private WebElement subTypeHead;
	@FindBy(id="type")
	private WebElement subTypeDrpDwn;
	@FindBy(xpath="//label[@for = 'Ptr id']")
	private WebElement ptrIdHead;
	@FindBy(id="ptrId")
	private WebElement ptrIdTextField;

	@FindBy(xpath="//label[@for = 'txnId']")
	private WebElement txnIdHead;
	@FindBy(id="txnId")
	private WebElement txnIdTextField;
	@FindBy(xpath="//label[@for='paymentReferenceId']")
	private WebElement chequeNumberHead;
	@FindBy(id="paymentReferenceId")
	private WebElement chequeNoAndTxnRefIdTextfield;
	@FindBy(xpath="//label[text()='Bank Name']")
	private WebElement bankNameHead;
	@FindBy(id="bankName")
	private WebElement bankNameTextfield;
	@FindBy(xpath="//label[text()='Txn Ref Id']")
	private WebElement txnRefIdHead;
	@FindBy(xpath="//label[text()='Amount']")
	private WebElement amountHead;
	@FindBy(id="amount")
	private WebElement amountTextField;
	@FindBy(xpath="//label[@class='statLabel ng-binding' and contains(text(),'Collect from Advance')]")
	private WebElement collectAdvanceForBtn;
	@FindBy(xpath="//label[text()='Notes:']")
	private WebElement notesHead;
	@FindBy(id="notes")
	private WebElement notesTextField;
	@FindBy(xpath="//a[@class='buttonAdd' and contains(@data-ng-click,'drafts')]")
	private WebElement addButton;
	@FindBy(xpath="//a[@class='buttonAdd' and contains(@data-ng-click,'Advance')]")
	private WebElement addButtonForAdvance;
	@FindBy(xpath = "//span[contains(text(),'Payment mode added successfully!')]")
	private WebElement successfullMsg;
	@FindBy(xpath = "(//i[text()='Save'])[1]")
	private WebElement saveBtn;

	@FindBy(className= "cmnicons srch")
	private WebElement searchBtn;

	@FindBy(xpath = "//a[@class='buttonAdd']")
	private WebElement addBtn;
	@FindBy(xpath = "//a[contains(@data-ng-click,'advance')]/i[text()='Save & Continue']")
	private WebElement saveContinueBtn;
	@FindBy(xpath = "(//i[text()='Reset'])[1]")
	private WebElement resetBtnForDraft;
	@FindBy(xpath = "(//i[text()='Cancel'])[1]")
	private WebElement cancelBtn;
	@FindBy(xpath = "(//i[text()='Dashboard'])[1]")
	private WebElement dashboardBtn;
	@FindBy(xpath = "//div[@class='txt_orng pull-right ng-binding']")
	private WebElement receiptNoInEdit;

	@FindBy(xpath = "//span[@class='cmnicons payAdvance']")
	private WebElement collectAdvanceBtn;

	/*---------------------Validation Message-------*/
	@FindBy(xpath = "//div[text()='Please select mode!']")
	private WebElement errorModeMsg;
	@FindBy(xpath = "//div[text()='Please enter amount!']")
	private WebElement errorAmountMsg;
	@FindBy(xpath = "//div[text()='Please select type!']")
	private WebElement errorSubTypeMsg;
	@FindBy(xpath = "//div[contains(text(),'Enter cheque number!')]")
	private WebElement errorChequeNoMsg;
	@FindBy(xpath = "//div[text() ='Enter bank name!']")
	private WebElement errorBankNameMsg;
	@FindBy(xpath = "//div[contains(text(),'Enter txn id!')]")
	private WebElement errorTransactionNoMsg;
	@FindBy(xpath = "//div[contains(text(),'Enter txn id!')]")
	private WebElement errorTxnIdMsg;
	@FindBy(xpath = "//h4[text()='Invoice No.#']")
	private WebElement invoiceNumberColumnName;
	@FindBy(xpath = "//div[text()='Total Amount']")
	private WebElement totalAmountColumnName;
	@FindBy(xpath = "//div[text()='Coupon']")
	private WebElement couponColumnName;
	@FindBy(xpath = "//div[text()='Amt. Pay.']")
	private WebElement amountPayableColumnName;
	@FindBy(xpath = "//div[text()='Amt. Paid']")
	private WebElement amtPaidColumnName;
	@FindBy(xpath = "//div[text()='Amt. Due']")
	private WebElement amountDueColumnName;
	@FindBy(xpath = "//div[text()='Collected']")
	private WebElement collectedAmount;
	@FindBy(xpath = "//div[@class='jumbotronCont']//div[contains(@data-ng-class,'receiptid')]")
	private List<WebElement> invoiceNumber;
	@FindBy(xpath = "//span[text()='Please select invoice(s)!']")
	private WebElement msgInvoiceNotSelected;
	@FindBy(xpath = "//span[text()='You have not applied any amount!']")
	private WebElement paymentNotAppliedMsg;
	//payment details web element
	@FindBy(xpath = "//tr[contains(@data-ng-repeat,'paymentDetailList')]")
	private List<WebElement> paymentDetailsRow;
	@FindBy(xpath = "//h4[text()='Payment Details']")
	private WebElement paymentDetailsHeader;
	@FindBy(xpath = "//tr[contains(@data-ng-repeat,'paymentDetailList')]/../preceding-sibling::thead//th[text()='Mode']")
	private WebElement modeColumnName;
	@FindBy(xpath = "//tr[contains(@data-ng-repeat,'paymentDetailList')]/../preceding-sibling::thead//th[text()='Type']")
	private WebElement typeColumnName;
	@FindBy(xpath = "//tr[contains(@data-ng-repeat,'paymentDetailList')]/../preceding-sibling::thead//th[text()='Amount']")
	private WebElement amountColumnName;
	@FindBy(xpath = "//tr[contains(@data-ng-repeat,'paymentDetailList')]/../preceding-sibling::thead//th[text()='Status']")
	private WebElement statusColumnName;
	@FindBy(xpath = "//tr[contains(@data-ng-repeat,'paymentDetailList')]/../preceding-sibling::thead//th[text()='Other Info']")
	private WebElement otherInfoColumnName;
	@FindBy(xpath = "//tr[contains(@data-ng-repeat,'paymentDetailList')]/../preceding-sibling::thead//th[text()='Notes']")
	private WebElement notesColumnName;
	@FindBy(xpath = "//tr[contains(@data-ng-repeat,'paymentDetailList')]/../preceding-sibling::thead//th[text()='Action']")
	private WebElement actionColumnName;
	@FindBy(xpath = "(//span[@class='nomrgn pdLR20 ng-binding'])[1]")
	private WebElement totalReceiptsAmount;
	@FindBy(xpath = "(//span[@class='nomrgn pdLR20 ng-binding'])[2]")
	private WebElement remainingAmountDueInvoice;
	@FindBy(xpath = "//div[contains(text(),'Remaining Amount Due on Invoice(s)')]/following-sibling::div/a[contains(text(),'Payment')]")
	private WebElement applyPaymentButton;
	@FindBy(xpath = "//a[text()='Apply Payment']")
	private WebElement applyPaymentBTn_invoiceFoot;
	@FindBy(xpath = "//label[contains(text(),'Notes')]/../following-sibling::div/a[contains(@data-ng-click,'drafts')]")
	private WebElement draftButton;
	@FindBy(xpath = "//div[contains(text(),'Total Due On Invoice(s) / Total Collection')]/span[@class='separator_title']")
	private WebElement totalDue_TotalCollection;
	@FindBy(xpath = "//span[@class='cmnicons yes-mdl']")
	private WebElement yesDeleteReceipt;
	@FindBy(xpath = "//span[@class='cmnicons cncl-mdl']")
	private WebElement noDeleteReceipt;
	@FindBy(xpath = "(//div[contains(text(),'Advance to be created for amount')]/span)[1]")
	private WebElement advaceToBeCreated;

	@FindBy(xpath = "(//div[@class='mainTableHeader']/h4)[1]")
	private WebElement draftPaymentHeading;

	@FindBy(xpath = "//h4[contains(text(),'Payment(s) Collected in Draft')]/../.././/td[@class='text-right ng-binding']")
	private WebElement addedDraftAmount;

	
	public WebElement getHeaderNewReceipt() {
		return headerNewReceipt;
	}

	public WebElement getHeaderAdvanceNewReceipt() {
		return headerAdvanceNewReceipt;
	}

	public WebElement getHeaderEditReceipt() {
		return headerEditReceipt;
	}

	public WebElement getModeHead() {
		return modeHead;
	}

	public WebElement getCashBtn() {
		return cashBtn;
	}

	public WebElement getCardBtn() {
		return cardBtn;
	}

	public WebElement getChequeBtn() {
		return chequeBtn;
	}

	public WebElement getNetBankingBtn() {
		return netBankingBtn;
	}

	public WebElement getWalletBtn() {
		return walletBtn;
	}

	public WebElement getOthersBtn() {
		return othersBtn;
	}

	public WebElement getSubTypeHead() {
		return subTypeHead;
	}

	public WebElement getSubTypeDrpDwn() {
		return subTypeDrpDwn;
	}

	public WebElement getPtrIdHead() {
		return ptrIdHead;
	}

	public WebElement getPtrIdTextField() {
		return ptrIdTextField;
	}

	public WebElement getTxnIdHead() {
		return txnIdHead;
	}

	public WebElement getTxnIdTextField() {
		return txnIdTextField;
	}

	public WebElement getChequeNumberHead() {
		return chequeNumberHead;
	}

	public WebElement getChequeNoAndTxnRefIdTextfield() {
		return chequeNoAndTxnRefIdTextfield;
	}

	public WebElement getBankNameHead() {
		return bankNameHead;
	}

	public WebElement getBankNameTextfield() {
		return bankNameTextfield;
	}

	public WebElement getTxnRefIdHead() {
		return txnRefIdHead;
	}

	public WebElement getAmountHead() {
		return amountHead;
	}

	public WebElement getAmountTextField() {
		return amountTextField;
	}

	public WebElement getCollectAdvanceForBtn() {
		return collectAdvanceForBtn;
	}

	public WebElement getNotesHead() {
		return notesHead;
	}

	public WebElement getNotesTextField() {
		return notesTextField;
	}

	public WebElement getAddButton() {
		return addButton;
	}

	public WebElement getAddButtonForAdvance() {
		return addButtonForAdvance;
	}

	public WebElement getSuccessfullMsg() {
		return successfullMsg;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getAddBtn() {
		return addBtn;
	}

	public WebElement getSaveContinueBtn() {
		return saveContinueBtn;
	}

	public WebElement getResetBtnForDraft() {
		return resetBtnForDraft;
	}

	public WebElement getCancelBtn() {
		return cancelBtn;
	}

	public WebElement getDashboardBtn() {
		return dashboardBtn;
	}

	public WebElement getReceiptNoInEdit() {
		return receiptNoInEdit;
	}

	public WebElement getCollectAdvanceBtn() {
		return collectAdvanceBtn;
	}

	public WebElement getErrorModeMsg() {
		return errorModeMsg;
	}

	public WebElement getErrorAmountMsg() {
		return errorAmountMsg;
	}

	public WebElement getErrorSubTypeMsg() {
		return errorSubTypeMsg;
	}

	public WebElement getErrorChequeNoMsg() {
		return errorChequeNoMsg;
	}

	public WebElement getErrorBankNameMsg() {
		return errorBankNameMsg;
	}

	public WebElement getErrorTransactionNoMsg() {
		return errorTransactionNoMsg;
	}

	public WebElement getErrorTxnIdMsg() {
		return errorTxnIdMsg;
	}

	public WebElement getInvoiceNumberColumnName() {
		return invoiceNumberColumnName;
	}

	public WebElement getTotalAmountColumnName() {
		return totalAmountColumnName;
	}

	public WebElement getCouponColumnName() {
		return couponColumnName;
	}

	public WebElement getAmountPayableColumnName() {
		return amountPayableColumnName;
	}

	public WebElement getAmtPaidColumnName() {
		return amtPaidColumnName;
	}

	public WebElement getAmountDueColumnName() {
		return amountDueColumnName;
	}

	public WebElement getCollectedAmount() {
		return collectedAmount;
	}

	public List<WebElement> getInvoiceNumber() {
		return invoiceNumber;
	}

	public WebElement getMsgInvoiceNotSelected() {
		return msgInvoiceNotSelected;
	}

	public WebElement getPaymentNotAppliedMsg() {
		return paymentNotAppliedMsg;
	}

	public List<WebElement> getPaymentDetailsRow() {
		return paymentDetailsRow;
	}

	public WebElement getPaymentDetailsHeader() {
		return paymentDetailsHeader;
	}

	public WebElement getModeColumnName() {
		return modeColumnName;
	}

	public WebElement getTypeColumnName() {
		return typeColumnName;
	}

	public WebElement getAmountColumnName() {
		return amountColumnName;
	}

	public WebElement getStatusColumnName() {
		return statusColumnName;
	}

	public WebElement getOtherInfoColumnName() {
		return otherInfoColumnName;
	}

	public WebElement getNotesColumnName() {
		return notesColumnName;
	}

	public WebElement getActionColumnName() {
		return actionColumnName;
	}

	public WebElement getTotalReceiptsAmount() {
		return totalReceiptsAmount;
	}

	public WebElement getRemainingAmountDueInvoice() {
		return remainingAmountDueInvoice;
	}

	public WebElement getApplyPaymentButton() {
		return applyPaymentButton;
	}

	public WebElement getApplyPaymentBTn_invoiceFoot() {
		return applyPaymentBTn_invoiceFoot;
	}

	public WebElement getDraftButton() {
		return draftButton;
	}

	public WebElement getTotalDue_TotalCollection() {
		return totalDue_TotalCollection;
	}

	public WebElement getYesDeleteReceipt() {
		return yesDeleteReceipt;
	}

	public WebElement getNoDeleteReceipt() {
		return noDeleteReceipt;
	}

	public WebElement getAdvaceToBeCreated() {
		return advaceToBeCreated;
	}

	public WebElement getDraftPaymentHeading() {
		return draftPaymentHeading;
	}

	public WebElement getAddedDraftAmount() {
		return addedDraftAmount;
	}
	
	
	
}
