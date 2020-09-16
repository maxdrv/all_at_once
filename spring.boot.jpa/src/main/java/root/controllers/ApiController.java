package root.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import root.model.Organization;
import root.respositories.OrganizationRepository;

import java.util.List;

@RestController
public class ApiController {

    private OrganizationRepository repository;

    @Autowired
    public ApiController(OrganizationRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Organization>> getAll() {
        List<Organization> all = repository.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

}
