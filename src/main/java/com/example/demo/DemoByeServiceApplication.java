package com.example.demo;

import java.io.FileReader;
import java.io.IOException;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class DemoByeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoByeServiceApplication.class, args);
	}
	
	@Bean
    public Docket api() throws IOException, XmlPullParserException {
      MavenXpp3Reader reader = new MavenXpp3Reader();
       Model model = reader.read(new FileReader("pom.xml"));
       return new Docket(DocumentationType.SWAGGER_2);              
    
    }
}
