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

import pizza.idat.app.model.Vendedor;
import pizza.idat.app.service.VendedorService;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {

	@Autowired
	private VendedorService service;
	
	
	@RequestMapping(path= "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Vendedor>> listar(){
		List<Vendedor> listavendedores = service.listar();
		return new ResponseEntity<List<Vendedor>>(listavendedores,HttpStatus.OK);
		
	}

	@RequestMapping(path= "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<?>buscarporid(@PathVariable Integer id){
		Vendedor vendedor = service.obtener(id);
		if (vendedor!= null) {
			return new ResponseEntity<>(vendedor,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(vendedor,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<?> registrar(@RequestBody Vendedor vendedor){
		service.guardar(vendedor);
		return new ResponseEntity<>(vendedor,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@RequestBody Vendedor p,@PathVariable Integer id){
		Vendedor vendedor = service.obtener(p.getIdvendedor());
		if (vendedor!= null) {
			service.actualizar(vendedor);
			return new ResponseEntity<>(vendedor,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(vendedor,HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id){
		Vendedor vendedor = service.obtener(id);
		if (vendedor!= null) {
			service.eliminar(id);
			return new ResponseEntity<>(id,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(id,HttpStatus.NOT_FOUND);
		}
	}
	
}
