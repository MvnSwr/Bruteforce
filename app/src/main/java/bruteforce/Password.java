package bruteforce;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Password {
    private int cracklength = 8; // wished password length (guess)
    private int passwordlength = 1; // actual password length
    public char[] crack; // cracked password (char array)
    private String crackStr; // cracked password (string)
    private Time time;

    public Password() {
        this.crack = new char[cracklength];
        this.time = new Time();
    }
}
