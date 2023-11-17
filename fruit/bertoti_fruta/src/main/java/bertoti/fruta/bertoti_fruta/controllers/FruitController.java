package bertoti.fruta.bertoti_fruta.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

import bertoti.fruta.bertoti_fruta.models.Fruit;

@RestController
@RequestMapping("/api/fruit")
@CrossOrigin(origins = "*") 
public class FruitController {
    private List<Fruit> fruits = new ArrayList<>();

    public FruitController() {
        super();
        fruits.add(new Fruit("Family1", "Name1", 1, 1.0));
        fruits.add(new Fruit("Family2", "Name2", 2, 2.0));
        fruits.add(new Fruit("Family3", "Name3", 3, 3.0));
        fruits.add(new Fruit("Family4", "Name4", 4, 4.0));
        fruits.add(new Fruit("Family5", "Name5", 5, 5.0));
    }

    @GetMapping
	public Iterable<Fruit> getFruits() {
		return fruits;
	}

	@GetMapping("/{id}")
	Optional<Fruit> getFruitById(@PathVariable String id) {
		return fruits
            .stream()
            .filter(f -> f.getId().equals(id))
            .findFirst();
	}

	@PostMapping
	public Fruit createFruit(@RequestBody Fruit fruit) {
		fruits.add(fruit);
		return fruit;
	}

	@PutMapping("/{id}")
	public ResponseEntity<Fruit> updateFruit(@PathVariable String id,
									 @RequestBody Fruit fruit) throws Exception {
		fruit.setId(id);
		
		int index = -1;
        for (Fruit f: fruits) {
            if (f.getId().equals(id)) {
                index = fruits.indexOf(f);
                fruits.set(index, fruit);
			}
		}

        if(index == -1) throw new Exception("Fruit not found");

        return new ResponseEntity<>(fruit, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public void deleteFruit(@PathVariable String id) {
		fruits.removeIf(c -> c.getId().equals(id));
	}
}
