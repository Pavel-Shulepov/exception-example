package atm;

public class IncorrectPinCodeException extends Exception {

    public IncorrectPinCodeException(){
        System.out.println("Incorrect Pin Code!");
    }

}
