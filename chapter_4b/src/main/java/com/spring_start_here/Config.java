package com.spring_start_here;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
  "com.spring_start_here.service",
  "com.spring_start_here.repo",
  "com.spring_start_here.proxy"
})
public class Config {}
