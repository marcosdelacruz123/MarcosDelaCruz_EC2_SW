package pizza.idat.app.service;

import java.util.List;

import pizza.idat.app.model.Pizza;


public interface PizzaService {

	void guardar(Pizza pizza);
	void actualizar(Pizza pizza);
	void eliminar(Integer id);
	List<Pizza> listar();
	Pizza obtener(Integer id);
}
