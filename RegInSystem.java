public interface RegInSystem {

    boolean isRegistredUser(String email);

    boolean signUp(String eMail, String firstName, String lastName);

    int logIn(String eMail);

    void updateUser(int id, String firstName, String lastName, String city, String address, int phoneNumber);

    void deleteUser(int id);

}
