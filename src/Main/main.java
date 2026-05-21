package Main;
import Billing.*;
import File.FileHandler;
import Login.logInSystem;
import Menu.menu;
import Parking.ParkingManager;
import Validation.inputValidator;
import Vehicles.vehilceType;
import Utilities.Intro;
import java.util.Scanner;
import Reports.*;
public class main {

	public class Main {

		public static void main(String[] args) {

		        Intro.show();

		        Scanner sc = new Scanner(System.in);
		        logInSystem login = new logInSystem();

		        if(login.login()) {

		            while(true) {

		                menu.show();
		                System.out.print("Choice: ");
		                int c = sc.nextInt();
		                sc.nextLine();

		                switch(c) {

		                    case 1:

		                        if(ParkingManager.isFull()) {
		                            System.out.println("PARKING FULL");
		                            break;
		                        }

		                        System.out.print("Plate: ");
		                        String plate = sc.nextLine().toUpperCase();

		                        if(!inputValidator.validatePlate(plate)) {
		                            System.out.println("Invalid Plate");
		                            break;
		                        }

		                        System.out.println("Color: 1 Red 2 White 3 Black 4 Others");
		                        int col = sc.nextInt();
		                        sc.nextLine();

		                        String color = switch(col) {
		                            case 1 -> "Red";
		                            case 2 -> "White";
		                            case 3 -> "Black";
		                            default -> "Others";
		                        };

		                        System.out.println("Discount: 1 PWD 2 Senior 0 None");
		                        int disc = sc.nextInt();
		                        sc.nextLine();

		                        System.out.println("Vehicle: 1 Motor 2 Four 3 Truck 4 EV");
		                        int t = sc.nextInt();
		                        sc.nextLine();

		                        vehilceType type = switch(t) {
		                            case 1 -> vehilceType.MOTORCYCLE;
		                            case 2 -> vehilceType.FOUR_WHEEL;
		                            case 3 -> vehilceType.TRUCK;
		                            default -> vehilceType.E_VEHICLE;
		                        };

		                        long inTime = System.currentTimeMillis();
		                        int ticket = ParkingManager.generateTicket();

		                        FileHandler.write("database/vehicles.txt",
		                            plate + "," + color + "," + type + "," + inTime + "," + ticket);

		                        ParkingManager.addSlot(plate);

		                        System.out.println("TICKET: " + ticket);
		                        break;

		                    case 2:

		                        System.out.print("Plate: ");
		                        String exit = sc.nextLine();

		                        long outTime = System.currentTimeMillis();
		                        long inFake = outTime - (60 * 60 * 1000);

		                        vehilceType vt = FileHandler.getType(exit);

		                        BillinSystem bill = new BillinSystem();

		                        double fee = bill.calculateFee(vt, inFake, outTime);

		                        System.out.println("Discount? 1 PWD 2 Senior 0 None");
		                        int dt = sc.nextInt();
		                        sc.nextLine();

		                        bill.setDiscountType(dt);

		                        double discount = bill.applyDiscount(fee);
		                        double total = fee - discount;

		                        int exitTicket = ParkingManager.generateTicket();

		                        Receipt.print(exitTicket, exit, fee, discount, total);

		                        FileHandler.write("database/transactions.txt",
		                            exit + "," + total);

		                        ParkingManager.removeSlot(exit);

		                        break;

		                    case 3:
		                        ParkingManager.showGrid();
		                        break;

		                    case 4:
		                        SalesReport.show();
		                        break;

		                    case 5:
		                        TransactionReport.show();
		                        break;

		                    case 6:
		                        AuditReport.show();
		                        break;

		                    case 7:
		                        System.out.println("SYSTEM CLOSED");
		                        System.exit(0);
		                }
		            }
		        }
		}
	}
}

		

	        
	    
	

