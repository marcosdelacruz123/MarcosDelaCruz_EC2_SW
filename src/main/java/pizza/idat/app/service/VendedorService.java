package pizza.idat.app.service;

import java.util.List;

import pizza.idat.app.model.Vendedor;


public interface VendedorService {

	void guardar(Vendedor vendedor);
	void actualizar(Vendedor vendedor);
	void eliminar(Integer id);
	List<Vendedor> listar();
	Vendedor obtener(Integer id);
}
