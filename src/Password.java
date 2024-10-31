package bruteforce;

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

    public int getCracklength() {
        return cracklength;
    }

    public void setCracklength(int cracklength) {
        this.cracklength = cracklength;
    }
    
    public int getPasswordlength() {
        return passwordlength;
    }
    
    public void setPasswordlength(int passwordlength) {
        this.passwordlength = passwordlength;
    }
    
    public String getCrackStr() {
        return crackStr;
    }
    
    public void setCrackStr(String crackStr) {
        this.crackStr = crackStr;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
