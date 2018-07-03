package atm;

import java.security.SecureRandom;

public class TerminalServer {


    public String getToken(int accountId, int pinCode) throws IncorrectPinCodeException {

        if (!PinValidator.isPinCorrect(accountId, pinCode)) throw new IncorrectPinCodeException();

        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);

        return bytes.toString();

    }



}
