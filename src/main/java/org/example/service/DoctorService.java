package org.example.service;

import jakarta.annotation.PostConstruct;
import org.example.exceptions.DoctorNotFoundException;
import org.example.model.Doctor;
import org.example.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository repo;

   /* @PostConstruct
    public void init() {
        repo.save(new Doctor("Dr. Sanders", "General"));
        repo.save(new Doctor("Dr. Goldberg", "General"));
    }*/
    public Doctor getDoctorWithPatients(Long id){
return null;
       // return DoctorMapper.INSTANCE.toModel(doctorRepository.getDoctorByIdWithPatients(id));
    }
    public List<Doctor> getDoctors() {
        return repo.findAll();
    }

    public void saveDoctor(Doctor newDoctor) {
        repo.save(newDoctor);
    }

    public Doctor readDoctor(Long id) {
        return repo.findById(id).orElseThrow(() -> new DoctorNotFoundException(id.toString()));
    }

    public void deleteDoctor(Long id) {
        repo.deleteById(id);
    }
    public boolean update(Long id, Doctor newDoctor) {
        if (repo.existsById(id)) {
            newDoctor.setId(id);
            repo.save(newDoctor);
            return true;
        }
        return false;

    }
}


