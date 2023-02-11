package org.example;

import org.example.model.Doctor;
import org.example.model.Patient;
import org.example.repository.DoctorRepository;
import org.example.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinalProjectSpringBootApplication implements CommandLineRunner {
@Autowired
private DoctorRepository repoDoctor;

	@Autowired
	private PatientRepository repoPatient;
	public static void main(String[] args) {
		SpringApplication.run(FinalProjectSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repoDoctor.save(new Doctor("Dr. Sanders", "General"));
		repoDoctor.save(new Doctor("Dr. Goldberg", "General"));

		repoPatient.save(new Patient( "J. Smalling"));
		repoPatient.save(new Patient( "Samantha Williams"));


		repoDoctor.findAll().forEach(System.out::println);
		repoPatient.findAll().forEach(System.out::println);
	}
}
