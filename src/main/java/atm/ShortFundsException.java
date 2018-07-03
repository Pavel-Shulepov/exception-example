package atm;

public class ShortFundsException extends Exception {
    public ShortFundsException(){
        System.out.println("Your account is short of funds!");
    }
}
