package com.ilyachuvaev.config;

import javax.wsdl.xml.WSDLReader;
import javax.wsdl.xml.WSDLWriter;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;


@Configuration
@PropertySource(value = "classpath:application.yml")
@EnableWs
@ComponentScan(basePackages = "com.ilyachuvaev")
public class WebServiceConfig extends WsConfigurerAdapter {

  @Bean
  public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
    return new PropertySourcesPlaceholderConfigurer();
  }

  @Bean
  public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
    MessageDispatcherServlet servlet = new MessageDispatcherServlet();
    servlet.setApplicationContext(applicationContext);
    servlet.setTransformWsdlLocations(true);
    return new ServletRegistrationBean(servlet, "/ws/*");
  }

  @Bean(name = "contacts")
  public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema contactSchema) {
    DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
    wsdl11Definition.setPortTypeName("Contacts");
    wsdl11Definition.setLocationUri("/ws");
    wsdl11Definition.setTargetNamespace("http://localhost:8080/soapservice");
    wsdl11Definition.setSchema(contactSchema);
    return wsdl11Definition;
  }

  @Bean
  public XsdSchema contactSchema(){
    return new SimpleXsdSchema(new ClassPathResource("xsd/contacts.xsd"));
  }

  @Bean
  public InternalResourceViewResolver jspViewResolver() {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setOrder(1);
    viewResolver.setPrefix("/resources/view/");
    viewResolver.setSuffix(".jsp");
    return viewResolver;
  }

}
