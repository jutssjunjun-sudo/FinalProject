package Utilities;

public class Intro {
	    public static void show() {

	        String text = "AUTOMATED PARKING SYSTEM";

	        for(char c : text.toCharArray()) {
	            System.out.print(c);
	            try { Thread.sleep(120); } catch(Exception e) {}
	        }

	        System.out.println("\nLOADING SYSTEM...");

	        for(int i=0;i<=100;i+=10) {
	            System.out.print("[" + i + "%]\r");
	            try { Thread.sleep(200); } catch(Exception e) {}
	        }

	        System.out.println("\nSYSTEM READY!\n");
	    }
	}

