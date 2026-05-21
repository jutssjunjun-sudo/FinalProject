package Login;
import java.util.Scanner;
public class logInSystem {

	    public boolean login() {

	        Scanner sc = new Scanner(System.in);

	        System.out.print("User: ");
	        String u = sc.nextLine();

	        System.out.print("Pass: ");
	        String p = sc.nextLine();

	        return u.equals("admin") && p.equals("1234");
	    }
	}

