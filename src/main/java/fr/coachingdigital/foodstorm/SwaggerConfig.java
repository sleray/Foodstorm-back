package fr.coachingdigital.foodstorm;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig  {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)  
                .select()                                  
                .apis(RequestHandlerSelectors.any())  
                //.paths(PathSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error")))
                .build()                
                .apiInfo(apiInfo()); 
             
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfo(
          "Foodstorm rest API", 
          "Documentation for the Foodstorm backend API", 
          "API TOS", 
          "Terms of service : only called by Foodstorm front", 
          new Contact("Sylvain Leray", "www.coachingdigital.fr/foodstorm/", "syleray@gmail.com"), 
          "License of API", "Not licensed yet !", Collections.emptyList());
   }
 
}
