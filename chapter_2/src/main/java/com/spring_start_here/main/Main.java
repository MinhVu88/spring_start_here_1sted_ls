package com.spring_start_here.main;

import java.util.function.Supplier;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring_start_here.config.Config0;
import com.spring_start_here.config.Config1;
import com.spring_start_here.config.Config2;

public class Main {
	public static void main(String[] args) {
		try(
			var ctx0 = new AnnotationConfigApplicationContext(Config0.class);
			var ctx1 = new AnnotationConfigApplicationContext(Config1.class);
			var ctx2 = new AnnotationConfigApplicationContext(Config2.class)
		) {
			// beans added to Spring context | approach 1: @Bean
			Person p = ctx0.getBean("Möstresticator", Person.class);
			System.out.println(p.getName());
			System.out.println(ctx0.getBean(Person.class).getName());

			String g = ctx0.getBean(String.class);
			System.out.println(g);

			System.out.println(ctx0.getBean(Integer.class));

			System.out.println("---------------------------------------------");

			// approach 2: stereotype annotations (@Component & @ComponentScan)
			Job j = ctx1.getBean(Job.class);
			// j.setTitle("programmer");
			System.out.println(j.getTitle());

			System.out.println("---------------------------------------------");

			// approach 3: programmatically (registerBean)
			Book b = new Book();
			b.setNumberOfPages(27);

			Supplier<Book> bookSupplier = () -> b;

			ctx2.registerBean(
				"book0", 
				Book.class, 
				bookSupplier,
				primaryBean -> primaryBean.setPrimary(true)
			);

			System.out.println(ctx2.getBean(Book.class).getNumberOfPages());
		} catch(BeansException e) {
			e.printStackTrace();
		}
	}
}