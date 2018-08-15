package test_wujing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.Random;
import java.util.Calendar;

import java.text.SimpleDateFormat;

import org.apache.commons.lang.RandomStringUtils;

public class CreateData {

    public static void main(String[] args) throws IOException {

       // File file = new File("/data/a.txt");
        File file = new File("C:\\Users\\li\\Desktop\\数栈第二阶段\\data\\a.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
        BufferedWriter out = new BufferedWriter(osw);
        Random r = new Random();
        String str = "a0A0b1B2c1C3d2D1e3E2f4F3g5G7h4H6i5Ij4J9k5K6l6Lm7M7n8N8o9Op0PqQrRsStTuUv9VwWxXy8YzZ";
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式
        long i = 0L;
        while(i<100L){
            i++;
            out.write(Long.toString(i));
            out.write(",");
            out.write(Integer.toString(r.nextInt(1000)));
            out.write(",");
            out.write(Integer.toString(r.nextInt(1000)));
            out.write(",");
            out.write(RandomStringUtils.random(6, str));
            out.write(",");
            out.write(Integer.toString(r.nextInt(1000)));
            out.write(",");
            out.write(RandomStringUtils.random(6, str));
            out.write(",");
            out.write(dateFormat.format( now ));
            out.write(",");
            out.write(Double.toString(r.nextDouble()));
            out.write(",");
            out.write(Double.toString(r.nextDouble()));
            out.write(",");
            out.write(Double.toString(r.nextDouble()));
            out.write(",");
            out.write(Integer.toString(r.nextInt(1000)));
            out.write(",");
            out.write(RandomStringUtils.random(6, str));
            out.write(",");
            out.write(RandomStringUtils.random(6, str));
            out.write(",");
            out.write(RandomStringUtils.random(6, str));
            out.write(",");
            out.write(RandomStringUtils.random(6, str));
            out.write(",");
            out.write(RandomStringUtils.random(6, str));
            out.write(",");
            out.write(RandomStringUtils.random(6, str));
            out.write(",");
            out.write(RandomStringUtils.random(6, str));
            out.write(",");
            out.write(RandomStringUtils.random(6, str));
            out.write(",");
            out.write(RandomStringUtils.random(6, str));
            out.write(",");
            out.write(RandomStringUtils.random(6, str));
            out.write(",");
            out.write(RandomStringUtils.random(6, str));
            out.write(",");
            out.write(RandomStringUtils.random(6, str));
            out.write(",");
            out.write(RandomStringUtils.random(6, str));
            out.write(",");
            out.write(RandomStringUtils.random(6, str));
            out.newLine();
            if(i%100000 ==0){
                out.flush();
            }
        }
        out.close();
        System.out.println("数据生成到"+file);
    }
}
