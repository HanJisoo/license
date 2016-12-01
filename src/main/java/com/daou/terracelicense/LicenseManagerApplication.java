package com.daou.terracelicense;

import com.daou.terracelicense.util.DataBaseMigration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class LicenseManagerApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LicenseManagerApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(LicenseManagerApplication.class, args);
		/*DataBaseMigration dbm = new DataBaseMigration();
		dbm.setLicenseTableForLocal();*/
	}
}
