package pizza.idat.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pizza.idat.app.model.Pizza;

public interface PizzaRepository  extends JpaRepository<Pizza, Integer>{

}
