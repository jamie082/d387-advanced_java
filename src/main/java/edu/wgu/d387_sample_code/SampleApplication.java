package edu.wgu.d387_sample_code;

import edu.wgu.d387_sample_code.translations.DisplayWelcomeMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Locale;

@SpringBootApplication
public class SampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);


        // Create threads for each welcome message.

        //English message
        DisplayWelcomeMessage displayWelcomeMessageEnglish = new DisplayWelcomeMessage(Locale.US);
        Thread englishMessage = new Thread(displayWelcomeMessageEnglish);
        englishMessage.start();

        //French message
        DisplayWelcomeMessage displayWelcomemessageFrench = new DisplayWelcomeMessage((Locale.CANADA_FRENCH));
        Thread frenchmessage = new Thread(displayWelcomemessageFrench);
        frenchmessage.start();




    }
}
/*
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
                InputStream stream = new ClassPathResource("welcoome_fr_CA.properties").getInputStream();
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
*/