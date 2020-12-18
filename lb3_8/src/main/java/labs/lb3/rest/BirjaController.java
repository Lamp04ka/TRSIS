package labs.lb3.rest;

import labs.lb3.service.BirjaService;
import labs.lb3.model.classBirja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BirjaController {

    private final BirjaService birjaService;

    @Autowired
    public BirjaController(BirjaService birjaService) {
        this.birjaService = birjaService;
    }

    @PostMapping(value = "/public/rest/company")
    public ResponseEntity<?> create(@RequestBody classBirja Object) {
        birjaService.create(Object);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/public/rest/company")
    public ResponseEntity<List<classBirja>> read() {
        final List<classBirja> Object = birjaService.readAll();

        return new ResponseEntity<>(Object, HttpStatus.OK);
    }

    @GetMapping(value = "/public/rest/company/{id}")
    public ResponseEntity<classBirja> read(@PathVariable(name = "id") int id) {
        final classBirja Object = birjaService.read(id);

        return Object != null
                ? new ResponseEntity<>(Object, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/public/rest/company/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody classBirja Object) {
        final boolean updated = birjaService.update(Object, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/public/rest/company/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = birjaService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
