package exceptions;
 import rocketDomain.RateDomainModel;
public class RateException extends Exception {

	private RateDomainModel RateDM;

	//	TODO - RocketBLL RateException - RateDomainModel should be an attribute of RateException
	//	* Add RateRomainModel as an attribute
	//	* Create a constructor, passing in RateDomainModel
	//	* Create a getter (no setter, set value only in Constructor)
	public RateException( RateDomainModel RateDM){
		this.RateDM = RateDM;
	}
	
	public RateDomainModel getRateDomainModel(){
		return RateDM;
	}
	
}
