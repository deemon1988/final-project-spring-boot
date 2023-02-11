package org.example.service;

import jakarta.annotation.PostConstruct;
import org.example.exceptions.DoctorNotFoundException;
import org.example.exceptions.PatientNotFoundException;
import org.example.model.Doctor;
import org.example.model.Patient;
import org.example.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository repo;

    /* @PostConstruct
     public void init() {
         repo.save(new Doctor("Dr. Sanders", "General"));
         repo.save(new Doctor("Dr. Goldberg", "General"));
     }*/
    public Patient getPatientWithDoctors(Long id){
        return null;
        // return DoctorMapper.INSTANCE.toModel(doctorRepository.getDoctorByIdWithPatients(id));
    }
    public List<Patient> getPatients() {
        return repo.findAll();
    }

    public void savePatient(Patient newPatient) {
        repo.save(newPatient);
    }

    public Patient readPatient(Long id) {
        return repo.findById(id).orElseThrow(() -> new PatientNotFoundException(id.toString()));
    }

    public void deletePatient(Long id) {
        repo.deleteById(id);
    }
    public boolean update(Long id, Patient newPatient) {
        if (repo.existsById(id)) {
            newPatient.setId(id);
            repo.save(newPatient);
            return true;
        }
        return false;

    }
}


