package cn.edu.bupt.gpuworker.util;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Shell {

    private static Runtime runtime = Runtime.getRuntime();

    private static Process process = null;

    public static String execute(String[] cmd) {
        // System.out.println("in exe: "+cmd);
        String result = "";
        try {
            process = runtime.exec(cmd);


            String tempLine = new String();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder sb = new StringBuilder();
            while ((tempLine = reader.readLine()) != null) {
                sb.append(tempLine + "\n");
            }
            // System.out.println("result = "+result);
            result = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;

    }

    public static String execute(String cmd) throws InterruptedException {
        System.out.println("in exe: " + cmd);
        String result = "";
        try {
            process = runtime.exec(cmd);
            String tempLine = new String();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder sb = new StringBuilder();
            while ((tempLine = reader.readLine()) != null) {
                sb.append(tempLine + "\n");
            }
            System.out.println("result = " + result);
            result = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;

    }

    public static String execute(String cmd, int excludeLine) {

        return execute(cmd, new long[]{excludeLine});
    }

    public static String execute(String cmd, long[] excludeLines) {
        Arrays.sort(excludeLines);
        String result = "";
        try {
            process = runtime.exec(cmd);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String tempLine = new String();
            long lineNumbers = 1;
            int pos = 0;
            StringBuilder sb = new StringBuilder();


            while ((tempLine = reader.readLine()) != null) {
                pos = Arrays.binarySearch(excludeLines, lineNumbers);
                if (pos < 0)
                    sb.append(tempLine + "\n");
                lineNumbers++;
            }
            result = sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;


    }

}
