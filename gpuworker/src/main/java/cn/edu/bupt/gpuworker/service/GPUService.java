package cn.edu.bupt.gpuworker.service;

import cn.edu.bupt.gpuworker.model.GPUWithTask;

public interface GPUService {
    //int getGPUNums();

    GPUWithTask[] getGPUWithTasks() throws InterruptedException;


}
