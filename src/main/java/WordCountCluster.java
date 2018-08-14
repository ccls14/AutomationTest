import java.util.Arrays;
import java.util.Iterator;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.VoidFunction;

import scala.Tuple2;

public class WordCountCluster {
    public static void main(String[] args) {
        SparkConf conf =new SparkConf()
                .setAppName("WordCountCluster");
        JavaSparkContext sc =new JavaSparkContext(conf);
        JavaRDD<String> lines=sc.textFile("hdfs://ns1/user/hive/warehouse/www.db/wc_in/65b01fab-7453-4471-b7de-0fb1cca04664");
        JavaRDD<String> words = lines.flatMap(new FlatMapFunction<String,String>(){

            /**
             *
             */
            private static final long serialVersionUID = 1L;

            public Iterator<String> call(String line) throws Exception {

                return Arrays.asList(line.split(",")).iterator();
            }

        });
        JavaPairRDD<String,Integer> pairs =words.mapToPair(new PairFunction<String,String,Integer>(){

            /**
             *
             */
            private static final long serialVersionUID = 1L;

            public Tuple2<String, Integer> call(String word) throws Exception {


                return new Tuple2<String,Integer>(word,1);
            }

        });
        final JavaPairRDD<String,Integer> wordCounts =pairs.reduceByKey(new Function2<Integer,Integer,Integer>(){

            /**
             *
             */
            private static final long serialVersionUID = 1L;

            public Integer call(Integer v1, Integer v2) throws Exception {

                return v1+v2;
            }

        });
        wordCounts.saveAsTextFile("file:////opt/dtstack/a.txt");
        wordCounts.foreach(new VoidFunction<Tuple2<String,Integer>>(){

            /**
             *
             */
            private static final long serialVersionUID = 1L;

            public void call(Tuple2<String, Integer> wordcount) throws Exception {
                System.out.println(wordcount._1+" appeared "+wordcount._2+"times");

            }

        });
        sc.close();

    }
}
