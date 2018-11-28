package cn.edu.bupt.gpuworker.service;

import cn.edu.bupt.gpuworker.model.GPUWithTask;
import cn.edu.bupt.gpuworker.util.GPUUtil;
import org.springframework.stereotype.Service;

//单台服务器上的GPU信息
@Service
public class GPUServiceImpl implements GPUService {


    @Override
    public GPUWithTask[] getGPUWithTasks() throws InterruptedException {
        return GPUUtil.getGPUWithTasks();
    }

}
