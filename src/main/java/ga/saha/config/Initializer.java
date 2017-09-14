package ga.saha.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("ga.saha")
public class Initializer {
        public static void main(String[] args) {
            SpringApplication.run(Initializer.class, args);
        }
}
