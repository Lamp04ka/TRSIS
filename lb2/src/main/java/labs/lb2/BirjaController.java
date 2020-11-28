package labs.lb2;

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

    @PostMapping(value = "/company")
    public ResponseEntity<?> create(@RequestBody ClassBirja Object) {
        birjaService.create(Object);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/company")
    public ResponseEntity<List<ClassBirja>> read() {
        final List<ClassBirja> Object = birjaService.readAll();

        return Object != null &&  !Object.isEmpty()
                ? new ResponseEntity<>(Object, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/company/{id}")
    public ResponseEntity<ClassBirja> read(@PathVariable(name = "id") int id) {
        final ClassBirja Object = birjaService.read(id);

        return Object != null
                ? new ResponseEntity<>(Object, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/company/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody ClassBirja Object) {
        final boolean updated = birjaService.update(Object, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/company/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = birjaService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
