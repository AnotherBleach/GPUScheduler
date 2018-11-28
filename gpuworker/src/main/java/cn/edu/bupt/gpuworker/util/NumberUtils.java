package cn.edu.bupt.gpuworker.util;

public class NumberUtils {

    public static Integer toInteger(String number) {


        try {
            number = number.trim();

            if (number.toLowerCase().endsWith("mib"))
                number = number.substring(0, number.length() - 3).trim();
            else if (number.toLowerCase().endsWith("w"))
                number = number.substring(0, number.length() - 1).trim();

            int x = Integer.parseInt(number);
            //   System.out.println(x);
            return x;
        } catch (NumberFormatException e) {

            return -404;
        }


    }

    public static Float toFloat(String number) {

        try {
            number = number.trim();

            if (number.toLowerCase().endsWith("mib"))
                number = number.substring(0, number.length() - 3).trim();
            else if (number.toLowerCase().endsWith("w"))
                number = number.substring(0, number.length() - 1).trim();

            float x = Float.parseFloat(number);
            // System.out.println(x);
            return x;
        } catch (NumberFormatException e) {
            return -404.0f;
        }


    }

}
