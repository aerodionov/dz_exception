public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        String myLogin = "login";
        String myPassword = "myPasswordmyPassword";
        String myConfirmPassword = "myPasswordmyPassword";
        System.out.println("checkCorrectRegData - " + checkCorrectRegData(myLogin, myPassword, myConfirmPassword));


    }
    public static boolean checkCorrectRegData (String login, String password, String confirmPassword) {
        try {
            if (login.toCharArray().length > 20) {
                throw new WrongLoginException("Слишком длинны логин");
            }
            if (password.toCharArray().length > 20) {
                throw new WrongLoginException("Слишком длинны пароль");
            }
            if (!login.matches("\\w{1,20}")) {
                throw new WrongLoginException("Логин не соответствует условиям");
            }
            if (!password.matches("\\w{1,20}")) {
                throw new WrongPasswordException("Пароль не соответствует условиям");
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Подтверждение пароля не совпадает с паролем");
            }
        } catch (WrongLoginException | WrongPasswordException exception) {
            System.out.println(exception.getMessage());
            return false;
        }
        return true;
    }
}