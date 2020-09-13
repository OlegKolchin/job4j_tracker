package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User user = null;
        int index = 0;
        for (index = 0; index < users.length; index++) {
            if (users[index].getUsername().equals(login)) {
                user = users[index];
                break;
            }
        }
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        return user;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.isValid() != true || user.getUsername().length() < 3) {
            throw new UserInvalidException("User is not valid");
        }
        return user.isValid() && user.getUsername().length() > 3;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ea) {
            ea.printStackTrace();
        } catch (UserNotFoundException eb) {
            eb.printStackTrace();
        }
    }
}
