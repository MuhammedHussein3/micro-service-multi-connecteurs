package net.micro.config;

import lombok.RequiredArgsConstructor;
import net.micro.web.CustomerSoapService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CxfConfig {

    public final Bus bus;
    public final CustomerSoapService customerSoapService;

    @Bean
    public EndpointImpl endpoint()
    {
        EndpointImpl endpoint = new EndpointImpl(bus,customerSoapService);
        endpoint.publish("CustomerService");
        return endpoint;
    }
}
