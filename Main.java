package backend;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserService userService = new UserService();
        OTPService otpService = new OTPService();
        CaptchaService captchaService = new CaptchaService();
        BookService bookService = new BookService();
        while(true){
            System.out.println("\n===== BOOK RECOMMENDATION SYSTEM =====");
            System.out.println("1. Admin Register");
            System.out.println("2. Admin Login");
            System.out.println("3. User Register");
            System.out.println("4. User Login");
            System.out.println("5. Reset Password");
            System.out.println("6. Exit");
            int choice=sc.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Username:");
                    String au=sc.next();
                    System.out.print("Password:");
                    String ap=sc.next();
                    System.out.print("Email:");
                    String ae=sc.next();
                    System.out.print("Phone:");
                    String aph=sc.next();
                    if(userService.register(au,ap,ae,aph)){
                        String otp=otpService.generateOTP(au);
                        System.out.println("OTP:"+otp);
                        System.out.print("Enter OTP:");
                        String o=sc.next();
                        if(otpService.verifyOTP(au,o))
                            System.out.println("Admin Registered");
                        else
                            System.out.println("OTP Failed");
                    }
                    else System.out.println("User exists");
                    break;
                case 2:
                case 4:
                    System.out.print("Username:");
                    String u=sc.next();

                    System.out.print("Password:");
                    String p=sc.next();

                    String captcha=captchaService.generateCaptcha();
                    System.out.println("Captcha:"+captcha);
                    System.out.print("Enter Captcha:");
                    String c=sc.next();

                    if(!captchaService.verifyCaptcha(captcha,c)){
                        System.out.println("Captcha Failed");
                        break;
                    }

                    if(userService.login(u,p)){

                        boolean session=true;

                        while(session){

                            System.out.println("1.Get Recommendation");
                            System.out.println("2.Logout");

                            int op=sc.nextInt();

                            if(op==1){

                                System.out.print("Topic:");
                                String topic=sc.next();

                                System.out.print("Genre:");
                                String genre=sc.next();

                                List<String> list=bookService.getBooks(topic,genre);

                                if(list.isEmpty())
                                    System.out.println("No books found");
                                else{
                                    System.out.println("Recommended Books:");
                                    for(String b:list)
                                        System.out.println(b);
                                }
                            }
                            else session=false;
                        }
                    }
                    else System.out.println("Login Failed");
                    break;
                case 3:
                    System.out.print("Username:");
                    String uu=sc.next();
                    System.out.print("Password:");
                    String up=sc.next();
                    System.out.print("Email:");
                    String ue=sc.next();
                    System.out.print("Phone:");
                    String uph=sc.next();
                    if(userService.register(uu,up,ue,uph)){
                        String otp=otpService.generateOTP(uu);
                        System.out.println("OTP:"+otp);
                        System.out.print("Enter OTP:");
                        String o=sc.next();
                        if(otpService.verifyOTP(uu,o))
                            System.out.println("User Registered");
                        else
                            System.out.println("OTP Failed");
                    }
                    else System.out.println("User exists");
                    break;
                case 5:
                    System.out.print("Username:");
                    String ru=sc.next();
                    System.out.print("Email:");
                    String re=sc.next();
                    System.out.print("Phone:");
                    String rp=sc.next();
                    if(userService.verifyUser(ru,re,rp)){
                        String otp=otpService.generateOTP(ru);
                        System.out.println("OTP:"+otp);
                        System.out.print("Enter OTP:");
                        String o=sc.next();
                        if(otpService.verifyOTP(ru,o)){
                            System.out.print("New Password:");
                            String np=sc.next();
                            userService.updatePassword(ru,np);
                            System.out.println("Password Updated");
                        }
                        else System.out.println("OTP Failed");
                    }
                    else System.out.println("User verification failed");
                    break;
                case 6:
                    return;
            }
        }
    }
}