package bruteforce;

public class Time {
    private long start, finish; // Zeitstoppung
    private double finalTime; // Sekunden mit Nachkomma

    public Time() {
        this.start = -1;
        this.finish = -1;
    }

    public void setStart() {
        this.start = System.currentTimeMillis();
    }

    //finalTime wird implizit beim setFinish berechnet
    //Wird auch bei einem weiteren Aufruf einfach neu berechnet mit dem ersten start Wert
    public void setFinish() {
        this.finish = System.currentTimeMillis();
        this.finalTime = ((double)(finish - start)) / 1000;
    }

    public double getFinalTime() throws FinaleTimeException{
        if(finish == -1){
            throw new FinaleTimeException("Time hasn't been stoped yet");
        }
        return finalTime;
    }

}
