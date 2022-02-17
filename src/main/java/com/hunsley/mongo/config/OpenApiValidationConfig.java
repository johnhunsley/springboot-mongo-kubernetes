package com.hunsley.mongo.config;

import com.atlassian.oai.validator.springmvc.OpenApiValidationFilter;
import com.atlassian.oai.validator.springmvc.OpenApiValidationInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Filter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Configuration
public class OpenApiValidationConfig {
  @Bean
  public Filter validationFilter() {
    return new OpenApiValidationFilter(
        true, // enable request validation
        false  // enable response validation
    );
  }

  @Bean
  public WebMvcConfigurer addOpenApiValidationInterceptor(@Value("classpath:snacks-oai-3.0.0.json")
              final Resource apiSpecification) throws IOException {
    final EncodedResource specResource = new EncodedResource(apiSpecification, StandardCharsets.UTF_8);
    final OpenApiValidationInterceptor openApiValidationInterceptor = new OpenApiValidationInterceptor(specResource);
    return new WebMvcConfigurer() {
      @Override
      public void addInterceptors(final InterceptorRegistry registry) {
        registry.addInterceptor(openApiValidationInterceptor);
      }
    };
  }
}
