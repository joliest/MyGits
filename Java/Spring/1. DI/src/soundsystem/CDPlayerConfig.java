package soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan //enables component scanning in Spring
               //equivalent to <context:component-scan base-package="soundsystem" /> in XML
public class CDPlayerConfig {

}
