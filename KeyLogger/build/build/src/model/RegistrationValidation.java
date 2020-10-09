package model;

public class RegistrationValidation {
	public static boolean isEmptyField(String uname, String pwd, String confPwd, String nickName, String childhoodFrnd) {
		if(uname.isEmpty() || pwd.isEmpty() || confPwd.isEmpty() || nickName.isEmpty() || childhoodFrnd.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean isPwdconfPwdSame(String pwd, String confPwd) {
		if(pwd.trim().equalsIgnoreCase(confPwd)) {
			return true;
		}
		else {
			return false;
		}
	}
}
