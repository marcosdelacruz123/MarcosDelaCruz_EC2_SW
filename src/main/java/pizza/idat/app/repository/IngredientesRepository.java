package pizza.idat.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pizza.idat.app.model.Ingredientes;

public interface IngredientesRepository  extends JpaRepository<Ingredientes, Integer>{

}
