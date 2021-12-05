package RizkiRamadhanJmartPK.jmart_android.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account extends Serializable implements java.io.Serializable {

    public static final String REGEX_EMAIL = "(?!.*[@]{2})(?!.*[.]{2})[A-Za-z0-9.&_*~]{5,}[@]{1}[A-Za-z0-9]{3,}[.]{1}[A-Za-z0-9-]{3,}$";
    public static final String REGEX_PASSWORD = "(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])[A-Za-z0-9]{8,}$";
    public String name;
    public String email;
    public String password;
    public Store store;
    public int accountId;
    public double balance;

    public Account(String name, String email, String password, double balance)
    {
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }

    public boolean validate() {
        Pattern pattern = Pattern.compile(REGEX_EMAIL);
        Matcher matcher = pattern.matcher(email);
        boolean foundEmail = matcher.find();

        Pattern pattern2 = Pattern.compile(REGEX_PASSWORD);
        Matcher matcher2 = pattern2.matcher(password);
        boolean foundPassword = matcher2.find();

        return (foundEmail && foundPassword);
    }
}
