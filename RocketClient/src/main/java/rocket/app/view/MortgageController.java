package rocket.app.view;

import eNums.eAction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import rocket.app.MainApp;
import rocketBase.RateBLL;
import rocketCode.Action;
import rocketData.LoanRequest;

public class MortgageController {

	private MainApp mainApp;
	@FXML
	public Label Income;
	@FXML
	public Label Expense;
	@FXML
	public Label CreditScore;
	@FXML
	public Label Term;
	@FXML
	public Label HouseCost;
	@FXML
	private TextField txtIncome;
	@FXML
	private TextField txtExpense;
	@FXML
	private TextField txtCreditScore;
	@FXML
	private TextField txtHouseCost;
	@FXML
	private TextField PMT;
	@FXML
	private ComboBox <String> cmbTerm;
	@FXML
	private Button btnPayment;
	@FXML
	private Label Errors;
	
	
	//	TODO - RocketClient.RocketMainController
	
	//	Create private instance variables for:
	//		TextBox  - 	txtIncome
	//		TextBox  - 	txtExpenses
	//		TextBox  - 	txtCreditScore
	//		TextBox  - 	txtHouseCost
	//		ComboBox -	loan term... 15 year or 30 year
	//		Labels   -  various labels for the controls
	//		Button   -  button to calculate the loan payment
	//		Label    -  to show error messages (exception throw, payment exception)

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	
	//	TODO - RocketClient.RocketMainController
	//			Call this when btnPayment is pressed, calculate the payment
	@FXML
	public void btnCalculatePayment(ActionEvent event)
	{
		Object message = null;
		//	TODO - RocketClient.RocketMainController
		
		Action a = new Action(eAction.CalculatePayment);
		LoanRequest lq = new LoanRequest();
		lq.setiTerm(Integer.parseInt(cmbTerm.getValue()));
		lq.setdAmount(Double.parseDouble(txtHouseCost.getText()));
		lq.setiCreditScore(Integer.parseInt(txtCreditScore.getText()));
		lq.setdRate(RateBLL.getRate(lq.getiCreditScore()));
		//	TODO - RocketClient.RocketMainController
		//			set the loan request details...  rate, term, amount, credit score, downpayment
		//			I've created you an instance of lq...  execute the setters in lq

		a.setLoanRequest(lq);
		
		//	send lq as a message to RocketHub		
		mainApp.messageSend(lq);
	}
	
	public void HandleLoanRequestDetails(LoanRequest lRequest)
	{
		
		//	TODO - RocketClient.HandleLoanRequestDetails
		//			lRequest is an instance of LoanRequest.
		//			after it's returned back from the server, the payment (dPayment)
		//			should be calculated.
		//			Display dPayment on the form, rounded to two decimal places
		double PITI = (lRequest.getIncome()) *.28;
		double PITII = (lRequest.getIncome()) * .36;
		double PITIII;
		if (PITI >= PITII){
			PITIII = PITII;
		}
		else{
		PITIII = PITI;}
		
		lRequest.setdPayment(PITIII);
		PMT.setText(lRequest.getdPayment("x = %.2f\n");
	}
}
