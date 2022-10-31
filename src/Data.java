import java.util.Objects;

public class Data {
    private String login;
    private String password;
    private String confirmPassword;

    public Data(String login, String password, String confirmPassword) {
        setLogin(login);

        setPassword(password);

        if (confirmPassword != null && !confirmPassword.isEmpty() && !confirmPassword.isBlank()) {
            this.confirmPassword = confirmPassword;
        }
    }

    public String getLogin() {
        return Objects.requireNonNullElse(login, "ОШИБКА");
    }

    public String getPassword() {
        return Objects.requireNonNullElse(password, "ОШИБКА");
    }

    public String getConfirmPassword() {
        return Objects.requireNonNullElse(confirmPassword, "ОШИБКА");
    }

    public void setLogin(String login) {
        if (login != null && !login.isEmpty() && !login.isBlank()) {
            this.login = login;
        } else {
            System.out.println("Имя пользователя указано неверно");
        }
    }

    public void setPassword(String password) {
        if (password != null && !password.isEmpty() && !password.isBlank()) {
            this.password = password;
        } else {
            System.out.println("Необходимо указать пароль");
        }
    }

    public static boolean check(Data data) throws WrongLoginException, WrongPasswordException {
        if (!data.getLogin().matches("\\w*")) {
            throw new WrongLoginException("В имени пользователя использованы недопустимые символы или имя пользователя не указано", new IllegalArgumentException());
        } else if (data.getLogin().length() < 1 || data.getLogin().length() > 20) {
            throw new WrongLoginException("Длина имени пользователя превышает допустимую величину");
        } else if (!data.getPassword().matches("\\w*")) {
            throw new WrongPasswordException("В пароле использованы недопустимые символы или пароль не указан", new IllegalArgumentException());
        } else if (data.getPassword().length() < 1 || data.getPassword().length() > 20) {
            throw new WrongPasswordException("Длина пароля превышает допустимую величину");
        } else if (!data.getPassword().equals(data.getConfirmPassword())) {
            throw new WrongPasswordException("Пароль и подтверждение пароля не совпадают");
        }
        return true;
    }

    public static void checkAuthorization(Data data) {
        try {
            check(data);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Имя пользователя " + data.getLogin() + ", пароль " + data.getPassword() + ", пароли совпадают " + data.getConfirmPassword().equals(data.getPassword()));
        }
    }
}
