package com.ilyachuvaev.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;

public class WebServiceConfigTest {

  public static ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
    MessageDispatcherServlet servlet = new MessageDispatcherServlet();
    servlet.setApplicationContext(applicationContext);
    return new ServletRegistrationBean(servlet, "/soapservice/ws/*");
  }

  public static Wsdl11Definition defaultWsdl11Definition() {
    SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
    wsdl11Definition.setWsdl(new ClassPathResource("xsd/contacts.wsdl"));
    return wsdl11Definition;
  }

  public static InternalResourceViewResolver jspViewResolver() {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setOrder(1);
    viewResolver.setPrefix("/resources/view/");
    viewResolver.setSuffix(".jsp");
    return viewResolver;
  }
}
