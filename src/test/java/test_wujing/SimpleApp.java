package test_wujing;

import org.apache.spark.api.java.*;
import org.apache.spark.api.java.function.Function;

public class SimpleApp {
    public static void main(String[] args) {
        String logFile = "file:////opt/dtstack/DTinsight/ThriftServer/mycode/wordcount/word.txt"; // Should be some file on your system
        JavaSparkContext sc = new JavaSparkContext("cluster", "Simple App",
                "file:////opt/dtstack/DTinsight/ThriftServer", new String[]{"target/simple-project-1.0.jar"});
        JavaRDD<String> logData = sc.textFile(logFile).cache();

        long numAs = logData.filter(new Function<String, Boolean>() {
            public Boolean call(String s) { return s.contains("a"); }
        }).count();

        long numBs = logData.filter(new Function<String, Boolean>() {
            public Boolean call(String s) { return s.contains("b"); }
        }).count();

        System.out.println("Lines with a: " + numAs + ", lines with b: " + numBs);
    }
}