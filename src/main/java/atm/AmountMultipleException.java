package atm;

public class AmountMultipleException extends Exception {
    public AmountMultipleException(){
        System.out.println("The amount must be a multiple of 100 !");
    }
}
