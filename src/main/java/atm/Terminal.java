package atm;

import java.util.Random;

public class Terminal implements ITerminal {

    private final TerminalServer server;
    private final PinValidator pinValidator;

    public Terminal(TerminalServer server, PinValidator pinValidator) {
        this.server = server;
        this.pinValidator = pinValidator;
    }

    @Override
    public int getBankAccountState(String token) throws SessionExpiredException {
        if (token == null) throw new SessionExpiredException();
        return 1_000_000;

    }

    @Override
    public boolean withdrawMoney(String token, int summ) throws SessionExpiredException, AmountMultipleException, ShortFundsException {
        if (summ % 100 != 0) throw new AmountMultipleException();
        if (summ > getBankAccountState(token)) throw new ShortFundsException();
        return true;
    }

    @Override
    public boolean putMoney(String token, int summ) throws AmountMultipleException {
        if (summ % 100 != 0) throw new AmountMultipleException();
        return true;
    }

    @Override
    public String auth(int accountId, int pinCode) throws IncorrectPinCodeException {
        return server.getToken( accountId, pinCode );
    }
}
