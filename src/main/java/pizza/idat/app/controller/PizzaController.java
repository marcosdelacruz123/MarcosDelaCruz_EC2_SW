package pizza.idat.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pizza.idat.app.model.Pizza;
import pizza.idat.app.service.PizzaService;

@RestController
@RequestMapping("/pizza")
public class PizzaController {

	@Autowired
	private PizzaService service;
	
	
	@RequestMapping(path= "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Pizza>> listar(){
		List<Pizza> listapizzas = service.listar();
		return new ResponseEntity<List<Pizza>>(listapizzas,HttpStatus.OK);
		
	}

	@RequestMapping(path= "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<?>buscarporid(@PathVariable Integer id){
		Pizza pizza = service.obtener(id);
		if (pizza!= null) {
			return new ResponseEntity<>(pizza,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(pizza,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<?> registrar(@RequestBody Pizza pizza){
		service.guardar(pizza);
		return new ResponseEntity<>(pizza,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@RequestBody Pizza p,@PathVariable Integer id){
		Pizza pizza = service.obtener(p.getIdpizza());
		if (pizza!= null) {
			service.actualizar(pizza);
			return new ResponseEntity<>(pizza,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(pizza,HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id){
		Pizza pizza = service.obtener(id);
		if (pizza!= null) {
			service.eliminar(id);
			return new ResponseEntity<>(id,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(id,HttpStatus.NOT_FOUND);
		}
	}
	
}
