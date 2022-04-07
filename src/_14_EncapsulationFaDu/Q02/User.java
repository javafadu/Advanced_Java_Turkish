package _14_EncapsulationFaDu.Q02;

public class User {
    private int it;
    private String username;
    private String password;
    private boolean active;
    private boolean signedIn;

    public User(int it, String username, String password, boolean active, boolean signedIn) {
        this.it = it;
        this.username = username;
        this.password = password;
        this.active = active;
        this.signedIn = signedIn;
    }
}
