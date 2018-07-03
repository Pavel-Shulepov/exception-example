package atm;

public class SessionExpiredException extends Exception {

    public SessionExpiredException() {
        System.out.println("Your session has expired!");
    }

}
