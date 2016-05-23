package rocketServer;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import netgame.common.Hub;
import rocketBase.RateBLL;
import rocketData.LoanRequest;


public class RocketHub extends Hub {

	private RateBLL _RateBLL = new RateBLL();
	
	public RocketHub(int port) throws IOException {
		super(port);
	}

	@Override
	protected void messageReceived(int ClientID, Object message) {
		System.out.println("Message Received by Hub");
		
		if (message instanceof LoanRequest) {
			resetOutput();
			
			LoanRequest lq = (LoanRequest) message;
			double serverRate = 0;
			
			try{
				
			int serverCS;
			serverCS = lq.getiCreditScore();
			
			serverRate = RateBLL.getRate(serverCS);
			}
			catch(Exception RateException){
				RateException.printStackTrace();
				break;
				
			}
			double ServerPMT = RateBLL.getPayment(serverRate, lq.getiTerm(), lq.getdAmount(), 0,true);
			lq.setdPayment(ServerPMT);
		}
			
		//	TODO - RocketHub.messageReceived

			//	You will have to:
			//	Determine the rate with the given credit score (call RateBLL.getRate)
			//		If exception, show error message, stop processing
			//		If no exception, continue
			//	Determine if payment, call RateBLL.getPayment
			//	
			//	you should update lq, and then send lq back to the caller(s)
			
			sendToAll(lq);
		}
	}
}
