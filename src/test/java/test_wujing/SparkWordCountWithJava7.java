package test_wujing;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;

public class SparkWordCountWithJava7 {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf();
        conf.setMaster("yarn");
        conf.setAppName("WordCount");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> fileRdd = sc.textFile("hdfs://ns1/user/hive/warehouse/www.db/wc_in/65b01fab-7453-4471-b7de-0fb1cca04664");

        JavaRDD<String> wordRDD = fileRdd.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public Iterator<String> call(String line) throws Exception {
                return Arrays.asList(line.split(",")).iterator();
            }
        });

        JavaPairRDD<String, Integer> wordOneRDD = wordRDD.mapToPair(new PairFunction<String, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(String word) throws Exception {
                return new Tuple2<String, Integer>(word, 1);
            }
        });

        JavaPairRDD<String, Integer> wordCountRDD = wordOneRDD.reduceByKey(new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer i1, Integer i2) throws Exception {
                return i1 + i2;
            }
        });

        JavaPairRDD<Integer, String> count2WordRDD = wordCountRDD.mapToPair(new PairFunction<Tuple2<String, Integer>, Integer, String>() {
            @Override
            public Tuple2<Integer, String> call(Tuple2<String, Integer> tuple) throws Exception {
                return new Tuple2<Integer, String>(tuple._2, tuple._1);
            }
        });

        JavaPairRDD<Integer, String> sortRDD = count2WordRDD.sortByKey(false);

        JavaPairRDD<String, Integer> resultRDD = sortRDD.mapToPair(new PairFunction<Tuple2<Integer, String>, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(Tuple2<Integer, String> tuple) throws Exception {
                return new Tuple2<String, Integer>(tuple._2, tuple._1);
            }
        });

        resultRDD.saveAsTextFile("file:////opt/dtstack/b");

    }
}