package com.spring_start_here;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring_start_here.beans.CircularDependencySolver;
import com.spring_start_here.beans.Job1;
import com.spring_start_here.beans.Person0;
import com.spring_start_here.beans.Person1;
import com.spring_start_here.beans.Person2;
import com.spring_start_here.beans.Person3;
import com.spring_start_here.beans.Person4;
import com.spring_start_here.config.Config;

@SuppressWarnings("unused")
public class Main {
	public static void main(String[] args) {
		try(var ctx = new AnnotationConfigApplicationContext(Config.class)) {
			Person0 person0 = ctx.getBean(Person0.class);
			Person1 person1 = ctx.getBean(Person1.class);

			System.out.println(
				"\n. person0.getName() -> " + person0.getName() +
				" | person0.getJob() -> " + person0.getJob() +
				"\n. person1.getName() -> " + person1.getName() +
				" | person1.getJob() -> " + person1.getJob()
			);

			System.out.println("---------------------------------------------");

			Person2 person2 = ctx.getBean(Person2.class);
			Job1 job0 = ctx.getBean(Job1.class);

			person2.setName("Tyrell Wellick");
			job0.setTitle("pen tester");
			
			System.out.println(
				"person2.getName() -> " + person2.getName() + 
				" | person2.getJob() -> " + person2.getJob()
			);

			System.out.println("---------------------------------------------");

			// Circular Dependency solved by @Lazy (not recommended)
			// Person3 person3 = ctx.getBean(Person3.class);
			// System.out.println(person3.getName() + " | " + person3.getJob());

			// Circular Dependency solved by a 3rd entity that decouples Person3 from Job2 (recommended)
			CircularDependencySolver solver = ctx.getBean(CircularDependencySolver.class);
			System.out.println(solver);

			System.out.println("---------------------------------------------");

			System.out.println(
				"person4: " + ctx.getBean(Person4.class).getName() + 
				" | job: " + ctx.getBean(Person4.class).getJob()
			);

			System.out.println("---------------------------------------------");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
      for(String name : beanNames) {
        System.out.println("bean -> " + name);
      }
		} catch(BeansException e) {
			System.out.println("\ne.getMessage() -> " + e.getMessage());
		}
	}
}