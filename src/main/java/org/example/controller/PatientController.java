package org.example.controller;

import org.example.model.Doctor;
import org.example.model.Patient;
import org.example.service.DoctorService;
import org.example.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping("/patients")
    public List<Patient> getAll() {
        return patientService.getPatients();
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<Patient> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.readPatient(id));
    }

    @PostMapping("/patient")
    public ResponseEntity<Patient> add(@RequestBody Patient patient) {
        patientService.savePatient(patient);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/patients/{id}")
    public void delete(@PathVariable Long id) {
        patientService.deletePatient(id);
    }

    @PutMapping("/patient/{id}")
    public ResponseEntity<Patient> update(@PathVariable Long id, @RequestBody Patient patient) {
        boolean updated = patientService.update(id, patient);

        return updated ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);

    }
}
