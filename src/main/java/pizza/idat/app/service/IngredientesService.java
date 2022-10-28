package pizza.idat.app.service;

import java.util.List;

import pizza.idat.app.model.Ingredientes;


public interface IngredientesService {

	void guardar(Ingredientes ingredientes);
	void actualizar(Ingredientes ingredientes);
	void eliminar(Integer id);
	List<Ingredientes> listar();
	Ingredientes obtener(Integer id);
}
