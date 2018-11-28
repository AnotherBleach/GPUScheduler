package cn.edu.bupt.gpuworker.model;



public class Task {

    private String process_name;//任务进程名称
    private int pid;//进程pid
    private int useOfMemory;//进程占用的显存大小
    private User owner;//任务进程所属的用户
    private StartingTime startTime;//进程启动时间
    private RunningTime runningTime;//进程已运行时间

    public String getProcess_name() {
        return process_name;
    }

    public void setProcess_name(String process_name) {
        this.process_name = process_name;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getUseOfMemory() {
        return useOfMemory;
    }

    public void setUseOfMemory(int useOfMemory) {
        this.useOfMemory = useOfMemory;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public StartingTime getStartTime() {
        return startTime;
    }

    public void setStartTime(StartingTime startTime) {
        this.startTime = startTime;
    }

    public RunningTime getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(RunningTime runningTime) {
        this.runningTime = runningTime;
    }
}
