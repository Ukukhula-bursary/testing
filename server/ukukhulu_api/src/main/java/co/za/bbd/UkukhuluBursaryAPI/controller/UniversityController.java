package co.za.bbd.UkukhuluBursaryAPI.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
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
import co.za.bbd.UkukhuluBursaryAPI.model.University;
import co.za.bbd.UkukhuluBursaryAPI.repository.TesterRepoImpl;
import co.za.bbd.UkukhuluBursaryAPI.repository.UniversityRepoImpl;

@RestController
public class UniversityController {

    @Autowired
    UniversityRepoImpl universityRepoImpl;

    @PostMapping("/add-university")
    public ResponseEntity<String> addUniversity(@RequestBody University university) {
        try {
            universityRepoImpl.addUniversity(new University(university.getUniversityName(), university.defaultIsActiveId()));
            return new ResponseEntity<>("University '" + university.getUniversityName() + "' was added successfully." , HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


//   private final UniversityService universityService;

//   private final UniversityModelAssembler assembler;

//   UniversityController(UniversityModelAssembler assembler, UniversityService universityService) {
//     this.assembler = assembler;
//     this.universityService = universityService;
//   }

//   @GetMapping("/universities")
//   public CollectionModel<EntityModel<University>> all() {

//     List<EntityModel<University>> universities = universityService.getAllUniversities().stream()
//         .map(assembler::toModel)
//         .collect(Collectors.toList());

//     return CollectionModel.of(universities, linkTo(methodOn(UniversityController.class).all()).withSelfRel());
//   }

//   @PostMapping("/universities")
//   public ResponseEntity<?> newUniversity(@RequestBody University newUniversity) {
//     EntityModel<University> entityModel = assembler.toModel(universityService.addUniversity(newUniversity.getName()));

//     return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
//         .body(entityModel);
//   }

//   @GetMapping("/universities/{id}")
//   public EntityModel<University> one(@PathVariable int id) {

//     University university = universityService.getUniversityById(id);
//     return assembler.toModel(university);
//   }
}
