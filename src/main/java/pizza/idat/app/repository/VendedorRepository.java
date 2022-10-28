package pizza.idat.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pizza.idat.app.model.Vendedor;

public interface VendedorRepository  extends JpaRepository<Vendedor, Integer>{

}
