
package backend;

import java.util.HashMap;

public class OTPService {

    HashMap<String, String> otpStore = new HashMap<>();

    public String generateOTP(String username) {
        String otp = String.valueOf((int)(100000 + Math.random()*900000));
        otpStore.put(username, otp);
        return otp;
    }

    public boolean verifyOTP(String username, String enteredOTP) {
        return otpStore.containsKey(username) &&
               otpStore.get(username).equals(enteredOTP);
    }
}
