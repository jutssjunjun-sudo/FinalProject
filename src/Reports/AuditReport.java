package Reports;
import File.FileHandler;
public class AuditReport {
	    public static void show() {

	        System.out.println("\n=== AUDIT REPORT ===");
	        FileHandler.displayFile("database/audit.txt");
	    }
	}

