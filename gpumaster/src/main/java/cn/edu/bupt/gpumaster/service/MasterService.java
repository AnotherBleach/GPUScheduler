package cn.edu.bupt.gpumaster.service;


import cn.edu.bupt.gpumaster.model.GPUWithTask;
import cn.edu.bupt.gpumaster.model.GPUWithTaskWithIP;
import cn.edu.bupt.gpumaster.model.Worker;
import com.google.gson.Gson;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

@Service
public class MasterService {

    @Autowired
    private RedisTemplate redisTemplate;
    private OkHttpClient client = new OkHttpClient();
    private Gson gson = new Gson();

    public Worker[] getServers() {

        Set<String> result = redisTemplate.keys("*");
        System.out.println(result.size());
        Worker[] workers = new Worker[result.size()];
        int index = 0;
        for (Iterator<String> iterator = result.iterator(); iterator.hasNext(); ) {
            String details = iterator.next();
            workers[index] = new Worker();
            workers[index].setIp(details);
            index++;
        }
        return workers;

    }


    public GPUWithTaskWithIP getGPUWithTaskWithIP(String ip, int port) {
        String details = redisTemplate.opsForValue().get(ip).toString();
        return gson.fromJson(details, GPUWithTaskWithIP.class);
    }

    public GPUWithTaskWithIP[] getGPUWithTaskWithIPS() {

        Worker[] workers = getServers();
        GPUWithTaskWithIP[] gpuWithTaskWithIPS = new GPUWithTaskWithIP[workers.length];
        for (int i = 0; i < workers.length; i++) {
            gpuWithTaskWithIPS[i] = getGPUWithTaskWithIP(workers[i].getIp(), workers[i].getPort());
        }

        return gpuWithTaskWithIPS;
    }

}
