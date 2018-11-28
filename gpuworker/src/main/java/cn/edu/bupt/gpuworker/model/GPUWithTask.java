package cn.edu.bupt.gpuworker.model;

public class GPUWithTask {


    private GPU gpu;
    private Task[] tasks;

    public GPU getGpu() {
        return gpu;
    }

    public void setGpu(GPU gpu) {
        this.gpu = gpu;
    }

    public Task[] getTasks() {
        return tasks;
    }

    public void setTasks(Task[] tasks) {
        this.tasks = tasks;
    }


}
