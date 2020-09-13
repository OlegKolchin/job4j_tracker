package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        int index = 0;
        for (index = 0; index < users.length; index++) {
            if (users[index].getUsername().equals(login)) {
                break;
            }
        }
        return users[index];
    }

    public static boolean validate(User user) throws UserInvalidException {
        return user.isValid() != true && user.getUsername().length() < 3;

    }

    public static void main(String[] args) {
        try {
            User[] users = {
                    new User("Petr Arsentev", true)
            };
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e) {
            System.out.println("Invalid user");
            e.printStackTrace();
        } catch (UserNotFoundException e) {
            System.out.println("User name not found");
            e.printStackTrace();
        }
    }
}
