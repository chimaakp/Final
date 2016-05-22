package rocketBase;

import static org.junit.Assert.*;

import org.junit.Test;

import rocketBase.RateBLL;
public class rate_test {

	//TODO - RocketBLL rate_test
	//		Check to see if a known credit score returns a known interest rate
	
	//TODO - RocketBLL rate_test
	//		Check to see if a RateException is thrown if there are no rates for a given
	//		credit score
	@Test
	public void rate_test(){
		double t1;
		try{
			
		
		t1= RateBLL.getRate(700);}
		
		catch(Exception e){
			
		}
		assertTrue( t1 == 4);
	}

}
