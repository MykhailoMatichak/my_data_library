package com.pet_project.my_data_library;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class MyDataLibraryApplication implements  CommandLineRunner {

	public static void main(String[] args) {
		new SpringApplicationBuilder(MyDataLibraryApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
	}


	@Override
	public void run(String... args) throws Exception {

	}
}
