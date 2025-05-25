package com.spring_start_here;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
  "com.spring_start_here.services",
  "com.spring_start_here.repositories",
  "com.spring_start_here.proxies"
})
public class Config {}
