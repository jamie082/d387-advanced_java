package edu.wgu.d387_sample_code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

@SpringBootApplication
public class SampleApplication {
    static ExecutorService messageExecutor=newFixedThreadPool(5);
    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);
        Properties properties=new Properties();
        messageExecutor.execute(()-> {
            try {
                InputStream stream = new ClassPathResource("welcoome_es_MX.properties").getInputStream();
                properties.load(stream);
                System.out.println(properties.getProperty("welcome"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        messageExecutor.execute(()-> {
            try {
                InputStream stream = new ClassPathResource("welcoome_en_US.properties").getInputStream();
                properties.load(stream);
                System.out.println(properties.getProperty("welcome"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}
