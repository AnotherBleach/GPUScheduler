package cn.edu.bupt.gpuworker.model;

public class GPU {
    int id;//GPU编号
    String name;//GPU型号
    String pattern;//持续模式的状态
    float Fan;//风扇转速
    String temp;//温度
    String gpuUsage;//GPU使用率
    String perf;//性能状态
    float usageOfPower;//使用瓦数
    float capOfPower;//总瓦数
    int useOfMemory;//已使用显存
    int capOfMemory;//总显存
    String uuid;//GPU-id，唯一性
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public float getFan() {
        return Fan;
    }

    public void setFan(float fan) {
        Fan = fan;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getGpuUsage() {
        return gpuUsage;
    }

    public void setGpuUsage(String gpuUsage) {
        this.gpuUsage = gpuUsage;
    }

    public String getPerf() {
        return perf;
    }

    public void setPerf(String perf) {
        this.perf = perf;
    }

    public float getUsageOfPower() {
        return usageOfPower;
    }

    public void setUsageOfPower(float usageOfPower) {
        this.usageOfPower = usageOfPower;
    }

    public float getCapOfPower() {
        return capOfPower;
    }

    public void setCapOfPower(float capOfPower) {
        this.capOfPower = capOfPower;
    }

    public int getUseOfMemory() {
        return useOfMemory;
    }

    public void setUseOfMemory(int useOfMemory) {
        this.useOfMemory = useOfMemory;
    }

    public int getCapOfMemory() {
        return capOfMemory;
    }

    public void setCapOfMemory(int capOfMemory) {
        this.capOfMemory = capOfMemory;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
