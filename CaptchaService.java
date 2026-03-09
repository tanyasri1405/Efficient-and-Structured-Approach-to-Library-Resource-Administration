
package backend;

import java.util.Random;

public class CaptchaService {

    public String generateCaptcha() {

        String chars = "ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz23456789";
        String captcha = "";
        Random rand = new Random();

        for(int i=0;i<6;i++){
            captcha += chars.charAt(rand.nextInt(chars.length()));
        }

        return captcha;
    }

    public boolean verifyCaptcha(String generated, String entered) {
        return generated.equalsIgnoreCase(entered);
    }
}
