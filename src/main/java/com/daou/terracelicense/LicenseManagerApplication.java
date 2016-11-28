package com.daou.terracelicense;

import com.daou.terracelicense.util.DataBaseMigration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LicenseManagerApplication {
	public static void main(String[] args) {
		SpringApplication.run(LicenseManagerApplication.class, args);
		/*DataBaseMigration dbm = new DataBaseMigration();
		dbm.setPartTable();*/
	}
}
