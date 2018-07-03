package atm;

public interface ITerminal {

    int getBankAccountState ( String token ) throws SessionExpiredException;
    boolean withdrawMoney ( String token, int summ ) throws SessionExpiredException, AmountMultipleException, ShortFundsException;
    boolean putMoney ( String token, int summ ) throws AmountMultipleException;
    String auth ( int accountId, int pinCode ) throws IncorrectPinCodeException;

}
