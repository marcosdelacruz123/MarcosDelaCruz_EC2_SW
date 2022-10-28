package pizza.idat.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;





@Entity
@Table(name="vendedor")
public class Vendedor {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idvendedor;
	private String nombre;
	private String celular;
	
	
	
	
	
	public Vendedor(Integer idvendedor, String nombre, String celular, List<Pizza> listapizzas) {
		super();
		this.idvendedor = idvendedor;
		this.nombre = nombre;
		this.celular = celular;
		this.listapizzas = listapizzas;
	}


	



	public Vendedor() {
		super();
	}

	





	public Integer getIdvendedor() {
		return idvendedor;
	}






	public void setIdvendedor(Integer idvendedor) {
		this.idvendedor = idvendedor;
	}






	public String getNombre() {
		return nombre;
	}






	public void setNombre(String nombre) {
		this.nombre = nombre;
	}






	public String getCelular() {
		return celular;
	}






	public void setCelular(String celular) {
		this.celular = celular;
	}






	public List<Pizza> getListapizzas() {
		return listapizzas;
	}






	public void setListapizzas(List<Pizza> listapizzas) {
		this.listapizzas = listapizzas;
	}







	@ManyToMany(mappedBy = "vendedores", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Pizza> listapizzas;

}
