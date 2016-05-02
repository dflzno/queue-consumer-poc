package jms.weatherqueue.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "jms.weatherqueue")
@ImportResource("classpath:/app-context.xml")
public class ApplicationConfiguration {

}