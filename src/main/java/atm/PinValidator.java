package atm;

public class PinValidator {

    private static boolean getRandomBoolean() {
        return Math.random() < 0.5;
    }

    public static boolean isPinCorrect ( int accountId, int pinCode ){
        //Проверяем пинкод в базе данных пользователей банка
        //Для теста вернем случайно true либо false
        //return false; //
        return getRandomBoolean();
    }

}
