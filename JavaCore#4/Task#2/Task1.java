package JavaCore#4.Task#2;

import java.util.regex.Pattern;

public class Task1 {

 private static final String REGEX = "^.*(?=.*[a-zA-Z])(?=.*\\d)(?=.*_)^.{3,19}$.*$";

  public static boolean checkUser(String login, String password, String confirmPassword) {
    try {
      Pattern pattern = Pattern.compile(REGEX);
      if (!pattern.matcher(login).matches()) {
        throw new WrongLoginException(String.format("Логин - %s - должен быть короче 20 символов и содержать только " +
            "латинские буквы, цифры и знак подчеркивания", login));
      } else if (!pattern.matcher(password).matches() || !password.equals(confirmPassword)) {
        throw new WrongPasswordException(String.format("Пароль - %s - должен быть короче 20 символов и содержать только " +
            "латинские буквы, цифры и знак подчеркивания. Пароли должны совпадать.", password));
      }
    } catch (WrongLoginException | WrongPasswordException e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }
}
