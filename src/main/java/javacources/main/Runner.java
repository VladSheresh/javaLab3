package javacources.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("javacources")
public class Runner extends SpringBootServletInitializer {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Runner.class, args);
    }
}

