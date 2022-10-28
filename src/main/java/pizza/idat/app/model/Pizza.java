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
@Table(name="pizza")
public class Pizza {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idpizza;
	private String pizza;
	private String descripcion;
	





	public Pizza(Integer idpizza, String pizza, String descripcion, List<Vendedor> vendedores,
			List<Ingredientes> listaingredientes) {
		super();
		this.idpizza = idpizza;
		this.pizza = pizza;
		this.descripcion = descripcion;
		this.vendedores = vendedores;
		this.listaingredientes = listaingredientes;
	}
	
	


	public Pizza() {
		super();
	}
	
	




	public Integer getIdpizza() {
		return idpizza;
	}




	public void setIdpizza(Integer idpizza) {
		this.idpizza = idpizza;
	}




	public String getPizza() {
		return pizza;
	}




	public void setPizza(String pizza) {
		this.pizza = pizza;
	}




	public String getDescripcion() {
		return descripcion;
	}




	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}




	public List<Vendedor> getVendedores() {
		return vendedores;
	}




	public void setVendedores(List<Vendedor> vendedores) {
		this.vendedores = vendedores;
	}




	public List<Ingredientes> getListaingredientes() {
		return listaingredientes;
	}




	public void setListaingredientes(List<Ingredientes> listaingredientes) {
		this.listaingredientes = listaingredientes;
	}






	@ManyToMany( cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(
			name="vendedor_pizza",
			joinColumns = @JoinColumn(
					name = "idpizza",
					nullable = false,
					unique = true,
					foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(idpizza) references pizza(idpizza)")
					),
			inverseJoinColumns = @JoinColumn(
					name = "idvendedor",
					nullable = false,
					unique = true,
					foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(idvendedor) references vendedor(idvendedor)")
					)
			)
	private List<Vendedor> vendedores = new ArrayList<>();
	
	
	@ManyToMany(mappedBy = "pizzas", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Ingredientes> listaingredientes;

}
