package Parking;
import java.io.*;
import java.util.Random;
public class ParkingManager {
	
	    private static final int MAX = 50;

	    public static int countSlots() {
	        int c = 0;
	        try {
	            BufferedReader br =
	                new BufferedReader(new FileReader("database/slots.txt"));

	            while(br.readLine() != null) c++;

	            br.close();
	        } catch(Exception e) {}
	        return c;
	    }

	    public static boolean isFull() {
	        return countSlots() >= MAX;
	    }

	    public static int generateTicket() {
	        return new Random().nextInt(90000) + 10000;
	    }

	    public static void addSlot(String plate) {
	        try {
	            FileWriter fw =
	                new FileWriter("database/slots.txt", true);
	            fw.write(plate + "\n");
	            fw.close();
	        } catch(Exception e) {}
	    }

	    public static void removeSlot(String plate) {
	        try {
	            File input = new File("database/slots.txt");
	            File temp = new File("database/temp.txt");

	            BufferedReader br =
	                new BufferedReader(new FileReader(input));

	            FileWriter fw = new FileWriter(temp);

	            String line;
	            while((line = br.readLine()) != null) {
	                if(!line.equalsIgnoreCase(plate)) {
	                    fw.write(line + "\n");
	                }
	            }

	            br.close();
	            fw.close();

	            input.delete();
	            temp.renameTo(input);

	        } catch(Exception e) {}
	    }

	    public static void showGrid() {

	        System.out.println("\n=== PARKING GRID (50 SLOTS) ===");

	        int used = countSlots();

	        for(int i=1;i<=50;i++) {

	            if(i <= used) System.out.print("[X] ");
	            else System.out.print("[" + i + "] ");

	            if(i % 10 == 0) System.out.println();
	        }

	        System.out.println();
	    }
	}

