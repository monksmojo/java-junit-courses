package com.in28Minutes.junitExmple1.configuration;

import com.in28Minutes.junitExmple1.component.ExecuteListSum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Bootstrap implements CommandLineRunner {
    @Autowired
    private ExecuteListSum executeListSum;

    @Override
    public void run(String... args) throws Exception {
        executeListSum.getSum(new int[]{1,2,3,4} );
    }
}
