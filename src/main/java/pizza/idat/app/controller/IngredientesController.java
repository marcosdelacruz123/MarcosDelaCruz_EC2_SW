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

import pizza.idat.app.model.Ingredientes;
import pizza.idat.app.service.IngredientesService;

@RestController
@RequestMapping("/ingredientes")
public class IngredientesController {

	@Autowired
	private IngredientesService service;
	
	
	@RequestMapping(path= "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Ingredientes>> listar(){
		List<Ingredientes> listaingre = service.listar();
		return new ResponseEntity<List<Ingredientes>>(listaingre,HttpStatus.OK);
		
	}

	@RequestMapping(path= "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<?>buscarporid(@PathVariable Integer id){
		Ingredientes ingredientes = service.obtener(id);
		if (ingredientes!= null) {
			return new ResponseEntity<>(ingredientes,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(ingredientes,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<?> registrar(@RequestBody Ingredientes ingredientes){
		service.guardar(ingredientes);
		return new ResponseEntity<>(ingredientes,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@RequestBody Ingredientes p,@PathVariable Integer id){
		Ingredientes ingredientes = service.obtener(p.getIdingrediente());
		if (ingredientes!= null) {
			service.actualizar(ingredientes);
			return new ResponseEntity<>(ingredientes,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(ingredientes,HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id){
		Ingredientes ingredientes = service.obtener(id);
		if (ingredientes!= null) {
			service.eliminar(id);
			return new ResponseEntity<>(id,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(id,HttpStatus.NOT_FOUND);
		}
	}
	
}
