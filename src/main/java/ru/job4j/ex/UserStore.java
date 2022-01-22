package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        int index = -1;
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUsername().equals(login)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new UserNotFoundException("User not found");
        }
        return users[index];
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.isValid() && user.getUsername().length() >= 3) {
            return true;
        } else {
            throw new UserInvalidException("User is not valid");
        }
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
        } catch (UserNotFoundException ea) {
            ea.printStackTrace();
        }
    }
}
