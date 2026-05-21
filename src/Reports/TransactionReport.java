package Reports;
import File.FileHandler;
public class TransactionReport {

	    public static void show() {

	        System.out.println("\n=== TRANSACTION REPORT ===");
	        FileHandler.displayFile("database/transactions.txt");
	    }
	}

