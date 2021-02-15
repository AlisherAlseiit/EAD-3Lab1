package org.example.ATM;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("org.example.ATM")
@PropertySource("classpath:dataConnection.properties")
public class SpringConfig {

}
