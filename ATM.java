
import java.util.Scanner;

public class ATM {
	public static void main(String[] args) {
		App atm = new App(); 
		atm.initiate();
	}
}

class IncorrectPinException extends Exception{
	public String getMessage() {
		return "INCORRECT PIN";
	}
}
class User{
	int pin = 1234;
	
	public int acceptInput(String str) {
		Scanner scan = new Scanner(System.in);
		System.out.println(str);
		int entered = scan.nextInt();
		return entered;
	}
	public void verify(int entered) throws IncorrectPinException{
		if(entered != pin) {
			IncorrectPinException in = new IncorrectPinException();
			System.out.println(in.getMessage());
			throw in;
		}
		else {
			System.out.println("Pin validated ! you are allowed to deposit or witrhdraw. ");
		}
	}
}
class App{
	public void initiate() {
		User a = new User();
		
		try {
			int en = a.acceptInput("Welcome ! Please enter your pin. ");
			a.verify(en);
		}
		catch(Exception e) {
			try {
				int en = a.acceptInput("2 attempts left !!");
				a.verify(en);
			}
			catch(Exception ae) {
				try {
					int en = a.acceptInput("1 attempt left !!");
					a.verify(en);
				}
				catch(Exception ea) {
					System.out.println("Please try again later !");
					System.exit(0);
				}
			}
		}
	}
}

// if in try block you a have fully checked exception, only then you can make use of fully checked exception in catch block	
//try with resources