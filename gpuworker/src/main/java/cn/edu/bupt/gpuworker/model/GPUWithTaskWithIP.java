package cn.edu.bupt.gpuworker.model;

public class GPUWithTaskWithIP {
    private String GPU_Server_IP;
    private GPUWithTask[] GPU_Details;


    public GPUWithTask[] getGPU_Details() {
        return GPU_Details;
    }

    public void setGPU_Details(GPUWithTask[] tasks) {
        this.GPU_Details = tasks;
    }

    public String getGPU_Server_IP() {
        return GPU_Server_IP;
    }

    public void setGPU_Server_IP(String GPU_Server_IP) {
        this.GPU_Server_IP = GPU_Server_IP;
    }
}
