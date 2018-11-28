package cn.edu.bupt.gpuworker.util;

import cn.edu.bupt.gpuworker.model.*;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GPUUtil {


    public static GPUWithTask[] getGPUWithTasks() throws InterruptedException {


        int index = 0;
        GPUWithTask[] gpuWithTasks = null;
        GPU[] gpus = null;
        String result = Shell.execute("nvidia-smi -q -x", 2);//执行shell命令，获取输出结果
        //System.out.println(result);

        try {

            Document document = DocumentHelper.parseText(result);//将数据转化为Java对象
            Element nvidia_smi_log = document.getRootElement();//获取根节点

            gpus = new GPU[Integer.parseInt(nvidia_smi_log.elementText("attached_gpus"))];//获取gpu数量并初始化数组
            gpuWithTasks = new GPUWithTask[gpus.length];//初始化结果数组

            Iterator gpus_iterator = nvidia_smi_log.elementIterator("gpu");//获取gpu的迭代器


            while ((gpus_iterator.hasNext())) {//依次遍历每一块GPU

                gpuWithTasks[index] = new GPUWithTask();

                gpus[index] = new GPU();

                Element gpu = (Element) gpus_iterator.next();///获取到GPU元素
                gpus[index].setName(gpu.elementText("product_name"));//gpu 名称
                gpus[index].setUuid(gpu.elementText("uuid"));//gpu - uuid
                gpus[index].setFan(NumberUtils.toFloat(gpu.elementText("fan_speed")));

                Element temperature = (Element) gpu.element("temperature");
                gpus[index].setTemp(temperature.elementText("gpu_temp"));

                Element fb_memory_usage = (Element) gpu.element("fb_memory_usage");
                gpus[index].setUseOfMemory(NumberUtils.toInteger(fb_memory_usage.elementText("used")));
                gpus[index].setCapOfMemory(NumberUtils.toInteger(fb_memory_usage.elementText("total")));


                Element power_readings = (Element) gpu.element("power_readings");
                gpus[index].setPerf(power_readings.elementText("power_state"));
                gpus[index].setUsageOfPower(NumberUtils.toFloat(power_readings.elementTextTrim("power_draw")));
                gpus[index].setCapOfPower(NumberUtils.toFloat(power_readings.elementTextTrim("power_limit")));


                String gpu_util = gpu.element("utilization").elementText("gpu_util");
                // gpu_util = gpu_util.substring(0,gpu_util.length()-1);
                gpus[index].setGpuUsage(gpu_util);

                String minor_numer = gpu.elementText("minor_number");
                if (minor_numer.trim().equals("N/A")) minor_numer = "0";
                gpus[index].setId(Integer.parseInt(minor_numer));


                List<Task> lists = new ArrayList<>();
                Element processes = gpu.element("processes");
                int size = 0;
                Iterator<Element> process_iterator = processes.elementIterator("process_info");
                while (process_iterator.hasNext()) {//依次获取属于该GPU的每一项任务
                    Element process = process_iterator.next();
                    Task temp = new Task();
                    temp.setPid(Integer.parseInt(process.elementText("pid")));
                    temp.setProcess_name(process.elementText("process_name"));

                    String user_result = Shell.execute("ps -u -p " + temp.getPid(), 1);
                    String userName = user_result.split(" ")[0];
                    User user = new User();
                    user.setName(userName);
                    temp.setOwner(user);
                    String start_time = Shell.execute("ps -p " + temp.getPid() + "  -o lstart", 1).trim();
                    String run_time = Shell.execute("ps -p " + temp.getPid() + " -o etime", 1).trim();
                    temp.setStartTime(new StartingTime(start_time));
                    temp.setRunningTime(new RunningTime(run_time));

                    String useOfMemory = process.elementText("used_memory");
                    useOfMemory = useOfMemory.substring(0, useOfMemory.length() - 3).trim();
                    temp.setUseOfMemory(Integer.parseInt(useOfMemory));
                    lists.add(temp);
                    size++;
                }
                Task[] tasks = new Task[lists.size()];
                lists.toArray(tasks);
                gpuWithTasks[index].setGpu(gpus[index]);
                gpuWithTasks[index].setTasks(tasks);

                index++;

            }


        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return gpuWithTasks;

    }


}
