package pizza.idat.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pizza.idat.app.model.Pizza;
import pizza.idat.app.repository.PizzaRepository;

@Service
public class PizzaServiceImpl implements PizzaService{

	@Autowired
	private PizzaRepository repositorio;
	
	@Override
	public void guardar(Pizza pizza) {
		repositorio.save(pizza);
	}

	@Override
	public void actualizar(Pizza pizza) {
		repositorio.saveAndFlush(pizza);
	}

	@Override
	public void eliminar(Integer id) {
		repositorio.deleteById(id);
	}

	@Override
	public List<Pizza> listar() {
		return repositorio.findAll() ;
	}

	@Override
	public Pizza obtener(Integer id) {
		return repositorio.findById(id).orElse(null);
	}

}
