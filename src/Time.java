package bruteforce;

public class Time {
    private long start, finish; // time stopping
    private double finalTime; // seconds with decimal

    public Time() {
        this.start = -1;
        this.finish = -1;
    }

    public void setStart() {
        this.start = System.currentTimeMillis();
    }

    // finalTime will implizitly be calculated at setFinish
    // will be freshly calculated after every call with the starting time
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
