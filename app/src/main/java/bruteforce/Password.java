package bruteforce;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Password {
    private int cracklength = 8; // Gewünschte Passwordlaenge (raten)
    private int passwordlength = 1; // Tatsaechliche Passwordlaenge
    public char[] crack; // Cracktes Password (Char array)
    private String crackStr; // Cracktes Password (String)
    private Time time;

    public Password() {
        this.crack = new char[cracklength];
        this.time = new Time();
    }
}
