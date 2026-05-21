package Reports;
import File.FileHandler;
public class VehicleReport {
	    public static void show() {

	        System.out.println("\n=== VEHICLE REPORT ===");
	        FileHandler.displayFile("database/vehicles.txt");
	    }
	}

