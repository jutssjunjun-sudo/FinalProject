package File;
import java.io.*;
import Vehicles.vehilceType;
public class FileHandler {

	    public static void write(String file, String data) {
	        try {
	            FileWriter fw = new FileWriter(file, true);
	            fw.write(data + "\n");
	            fw.close();
	        } catch(Exception e) {}
	    }

	    public static vehilceType getType(String plate) {
	        try {
	            BufferedReader br =
	                new BufferedReader(new FileReader("database/vehicles.txt"));

	            String line;

	            while((line = br.readLine()) != null) {

	                String[] d = line.split(",");

	                if(d[0].equalsIgnoreCase(plate)) {
	                    br.close();
	                    return vehilceType.valueOf(d[3]);
	                }
	            }

	            br.close();
	        } catch(Exception e) {}

	        return vehilceType.MOTORCYCLE;
	    }
	    public static void displayFile(String file) {
	        try {
	            BufferedReader br = new BufferedReader(new FileReader(file));

	            String line;

	            while ((line = br.readLine()) != null) {
	                System.out.println(line);
	            }

	            br.close();

	        } catch (Exception e) {
	            System.out.println("Error reading file.");
	        }
	    }
	}

