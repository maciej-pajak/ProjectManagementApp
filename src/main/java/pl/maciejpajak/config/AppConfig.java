package pl.maciejpajak.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("pl.maciejpajak")
@Import({ WebMvcConfig.class, PersistenceConfig.class })
public class AppConfig {
    
    
    
    

}
