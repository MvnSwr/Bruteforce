package bruteforce;

public class BruteForce {
    public static Password hacking(String str) {
        String password = str;
        int count;
        Password pw = new Password();

        System.out.println("Start hacking...");

        pw.getTime().setStart();
        do {
            pw.crack[pw.getCracklength() - 1]++;
            for (count = 0; count < pw.getPasswordlength(); count++) {

                // condition if char goes over 58 / "9"
                if (pw.crack[pw.getCracklength() - count - 1] == 58) {
                    pw.crack[pw.getCracklength() - count - 1] = 65;
                }

                // condition if chat goes over 91 / "Z"
                if (pw.crack[pw.getCracklength() - count - 1] == 91) {
                    pw.crack[pw.getCracklength() - count - 1] = 97;
                }

                // condition if char goes over 123 / "z" (over the last char)
                if (pw.crack[pw.getCracklength() - count - 1] == 123) {

                    // if position of array is 0 and on the last char? exit code
                    if (pw.getCracklength() - count - 1 == 0 && pw.crack[pw.getCracklength() - count - 1] == 123) {
                        System.out.println("Passwort leider nicht gefunden");
                        System.exit(0);
                    }

                    pw.crack[pw.getCracklength() - count - 1] = 48;

                    // checks if position is initialized
                    if (pw.crack[pw.getCracklength() - count - 2] < 48) {
                        pw.crack[pw.getCracklength() - count - 2] = 48;
                        pw.setPasswordlength(pw.getPasswordlength() + 1);
                    } else {
                        pw.crack[pw.getCracklength() - count - 2]++;
                    }
                }
            }

            pw.setCrackStr(new String(pw.crack));

            // since the Array is not empty in the front rows, we have to build a substring
            try {
                pw.setCrackStr(
                        pw.getCrackStr()
                        .substring(pw.getCracklength() - pw.getPasswordlength(), pw.getCracklength()));
            } catch (Exception e) {
                System.out.println("Fehler");
                System.exit(1);
            }
            // System.out.println(crackStr); lack of performance

        } while (!password.equals(pw.getCrackStr()));

        pw.getTime().setFinish();

        try {
            System.out.println("The Password is: " + pw.getCrackStr());
            System.out.println("It took " + pw.getTime().getFinalTime() + " Seconds!");   
        } catch (FinaleTimeException e) {
            e.printStackTrace();
        }

        return pw;
    }
}