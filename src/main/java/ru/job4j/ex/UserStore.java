package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        int index = -1;
        int counter = 0;
        for (User use : users) {
            if (use.equals(login)) {
                index = counter;
                break;
            }
            counter++;
        }
        if (index == -1) {
            throw new UserNotFoundException("User not found");
        }
        return users[index];
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() && user.getUsername().length() < 3) {
            throw new UserInvalidException("User is not valid");
        }
        return true;
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
