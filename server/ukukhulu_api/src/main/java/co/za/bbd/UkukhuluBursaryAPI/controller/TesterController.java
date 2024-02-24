package co.za.bbd.UkukhuluBursaryAPI.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.za.bbd.UkukhuluBursaryAPI.model.Tester;
import co.za.bbd.UkukhuluBursaryAPI.repository.TesterRepoImpl;

@RestController
@RequestMapping("/api")
public class TesterController {
  @Autowired
  TesterRepoImpl testerRepoImpl;

  @PostMapping("/tester")
  public ResponseEntity<String> createTester(@RequestBody Tester tester) {
    try {
      testerRepoImpl.save(new Tester(tester.getFeels(), tester.getWorking(), tester.getPush()));
      return new ResponseEntity<>("Tester was created successfully.", HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
