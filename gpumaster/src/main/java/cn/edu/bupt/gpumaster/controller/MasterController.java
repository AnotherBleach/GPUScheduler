package cn.edu.bupt.gpumaster.controller;

import cn.edu.bupt.gpumaster.model.Worker;
import cn.edu.bupt.gpumaster.service.MasterService;
import cn.edu.bupt.gpumaster.service.MasterService;
import cn.edu.bupt.gpumaster.model.GPUWithTaskWithIP;
import okhttp3.Call;
import okhttp3.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/master")
public class MasterController {


    @Autowired
    MasterService masterService;


    @RequestMapping("/getGPUDetails")
    public GPUWithTaskWithIP[] gpuWithTaskWithIPS() {

        return masterService.getGPUWithTaskWithIPS();
    }

    @RequestMapping("/getServers")
    public Worker[] getServers() {

        return masterService.getServers();

    }

    @RequestMapping("/getGPUDetailByIp")
    public GPUWithTaskWithIP gpuWithTaskWithIP(@RequestParam String ip, @RequestParam int port) {

        return masterService.getGPUWithTaskWithIP(ip, port);

    }

}
