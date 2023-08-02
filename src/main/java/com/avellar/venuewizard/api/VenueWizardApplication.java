package com.avellar.venuewizard.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class VenueWizardApplication {

	public static void main(String[] args) {
		SpringApplication.run(VenueWizardApplication.class, args);
	}

}
