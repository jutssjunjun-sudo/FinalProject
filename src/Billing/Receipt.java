package Billing;

public class Receipt {
	
	    public static void print(int ticket, String plate, double fee, double discount, double total) {

	        System.out.println("\n===== RECEIPT =====");
	        System.out.println("Ticket: " + ticket);
	        System.out.println("Plate: " + plate);
	        System.out.println("Fee: " + fee);
	        System.out.println("Discount: " + discount);
	        System.out.println("Total: " + total);
	        System.out.println("===================");
	    }
	}

