package pizza.idat.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="ingrediente")
public class Ingredientes {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idingrediente;
	private String nombre;
	private String descripcion;
	
	


	public Ingredientes(Integer idingrediente, String nombre, String descripcion, List<Pizza> pizzas) {
		super();
		this.idingrediente = idingrediente;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.pizzas = pizzas;
	}

	
	



	public Ingredientes() {
		super();
	}

	
	





	public Integer getIdingrediente() {
		return idingrediente;
	}






	public void setIdingrediente(Integer idingrediente) {
		this.idingrediente = idingrediente;
	}






	public String getNombre() {
		return nombre;
	}






	public void setNombre(String nombre) {
		this.nombre = nombre;
	}






	public String getDescripcion() {
		return descripcion;
	}






	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}






	public List<Pizza> getPizzas() {
		return pizzas;
	}






	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}








	@ManyToMany( cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(
			name="Ingredientes_pizza",
			joinColumns = @JoinColumn(
					name = "idingrediente",
					nullable = false,
					unique = true,
					foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(idingrediente) references ingrediente(idingrediente)")
					),
			inverseJoinColumns = @JoinColumn(
					name = "idpizza",
					nullable = false,
					unique = true,
					foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(idpizza) references pizza(idpizza)")
					)
			)
	private List<Pizza> pizzas = new ArrayList<>();
}
