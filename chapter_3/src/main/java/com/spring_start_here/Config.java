package com.spring_start_here;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.spring_start_here.beans.Job0;
import com.spring_start_here.beans.Person0;
import com.spring_start_here.beans.Person1;

@Configuration
@ComponentScan(basePackages = "com.spring_start_here.beans")
public class Config {
	@Bean
	public Job0 job_0() {
		Job0 j = new Job0();
		j.setTitle("bug bounty hunter");
		return j;
	}

	@Bean
	public Job0 job_1() {
		Job0 j = new Job0();
		j.setTitle("malware analyst");
		return j;
	}

	@Bean
	public Job0 job_2() {
		Job0 j = new Job0();
		j.setTitle("cryptography engineer");
		return j;
	}

	@Bean
	public Person0 person0() {
		Person0 p = new Person0();
		p.setName("Elliot Alderson");
		p.setJob(job_0()); // approach 1: link the Job bean with the Person0 bean (direct wiring)
		return p;
	}

	@Bean
	public Person1 person1(@Qualifier("job_1") Job0 job) {
		Person1 p = new Person1();
		p.setName("Darlene Alderson");
		p.setJob(job); // approach 2
		return p;
	}
}
