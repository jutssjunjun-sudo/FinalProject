package Billing;
import Vehicles.vehilceType;
public class BillinSystem implements Discountable{
	
	    private int discountType = 0; // 0 none, 1 PWD, 2 Senior

	    public void setDiscountType(int type) {
	        discountType = type;
	    }

	    public double calculateFee(vehilceType type, long in, long out) {

	        double rate = switch(type) {
	            case MOTORCYCLE -> 50;
	            case FOUR_WHEEL -> 75;
	            case TRUCK -> 80;
	            case E_VEHICLE -> 40;
	        };

	        long minutes = (out - in) / (1000 * 60);

	        if(minutes <= 30) return 0;

	        double hours = (minutes - 30) / 60.0;

	        return rate * hours;
	    }

	    @Override
	    public double applyDiscount(double amount) {

	        // 🇵🇭 PWD / Senior Discount = 20%
	        if(discountType == 1 || discountType == 2) {
	            return amount * 0.20;
	        }

	        return amount * 0;
	    }
	}

