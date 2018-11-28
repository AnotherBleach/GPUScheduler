package cn.edu.bupt.gpuworker.job;

import cn.edu.bupt.gpuworker.model.GPUWithTask;
import cn.edu.bupt.gpuworker.model.GPUWithTaskWithIP;
import cn.edu.bupt.gpuworker.service.GPUService;
import cn.edu.bupt.gpuworker.util.RedisUtil;
import cn.edu.bupt.gpuworker.util.Shell;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class GPUJob {

    private final static String[] IpQuery = {"/bin/sh", "-c", "ip route get 8.8.8.8 |head -1|awk '{print $7}'|tr -d '\n'"};

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    GPUService gpuService;

    @Scheduled(fixedRate = 1000*10)
    public void setGPUData() throws InterruptedException {

        GPUWithTask[] gpuWithTasks = gpuService.getGPUWithTasks();
        GPUWithTaskWithIP result = new GPUWithTaskWithIP();
        result.setGPU_Details(gpuWithTasks);
        result.setGPU_Server_IP(Shell.execute(IpQuery).trim());
        redisUtil.setData(result.getGPU_Server_IP(), new Gson().toJson(result));

    }

}
