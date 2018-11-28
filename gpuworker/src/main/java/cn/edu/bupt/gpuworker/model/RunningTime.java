package cn.edu.bupt.gpuworker.model;

public class RunningTime {
//    private int days;
//    private int hour;
//    private int minutes;
//    private int seconds;
//
//    public int getDays() {
//        return days;
//    }
//
//    public void setDays(int days) {
//        this.days = days;
//    }
//
//    public int getHour() {
//        return hour;
//    }
//
//    public void setHour(int hour) {
//        this.hour = hour;
//    }
//
//    public int getMinutes() {
//        return minutes;
//    }
//
//    public void setMinutes(int minutes) {
//        this.minutes = minutes;
//    }
//
//    public int getSeconds() {
//        return seconds;
//    }
//
//    public void setSeconds(int seconds) {
//        this.seconds = seconds;
//    }

    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public RunningTime(String result) {
        this.result = result;
    }
}
