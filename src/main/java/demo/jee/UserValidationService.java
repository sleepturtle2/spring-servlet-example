package demo.jee;

public class UserValidationService {
	public boolean isUserValid(String user, String password) {
		if(user.equals("sleepturtle") && password.equals("dummy"))
			return true; 
		else 
			return false; 
	}
}
