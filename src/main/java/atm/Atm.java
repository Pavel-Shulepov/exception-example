package atm;

import java.util.Random;
import java.util.Scanner;

public class Atm {

    private static final int attempts = 3;

    public static void main(String[] args) throws IncorrectPinCodeException, InterruptedException, SessionExpiredException, AmountMultipleException, ShortFundsException {

        Terminal terminal = new Terminal(new TerminalServer(), new PinValidator());
        String token = null;
        boolean lockAccount = false;

        Scanner scanner = new Scanner(System.in);

        while (true){
            for (int i = 0; i < attempts; i++) {

                System.out.println("Enter PIN");

                int pinCode = scanner.nextInt();

                Random random = new Random();

                try{
                    token = terminal.auth( random.nextInt(), pinCode );
                } catch (Exception e){
                    e.printStackTrace(System.out);
                }

                if (token!=null) break;

            }

            if (token == null) {
                System.out.println("YOUR ACCOUNT LOCK!!! WAIT 5 sec.");
                lockAccount = true;
                Thread.sleep(5000);
                lockAccount = false;
            } else break;
        }

        System.out.println("\u001b[2J");

        while (true){
            System.out.println("Select the operation:");
            System.out.println("[1] Balance");
            System.out.println("[2] Withdraw Money");
            System.out.println("[3] Put Money");
            System.out.println("[4] Exit");

            int command = scanner.nextInt();

            if (command == 1) System.out.println(terminal.getBankAccountState(token));
            if (command == 2) {
                System.out.println("Summ:");
                int summ = scanner.nextInt();
                try {
                    if (terminal.withdrawMoney(token, summ)) System.out.println("Take your check");
                } catch (Exception e){
                    e.printStackTrace(System.out);
                }
            }
            if (command == 3){
                System.out.println("Summ:");
                int summ = scanner.nextInt();
                try {
                    terminal.putMoney(token, summ);
                } catch (Exception e){
                    e.printStackTrace(System.out);
                }
            }
            if (command == 4) break;

        }

        System.out.println("GoodBye!!!");

    }

}
