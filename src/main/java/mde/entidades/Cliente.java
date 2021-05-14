package mde.entidades;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import mde.repositorios.ClienteListener;

@Entity
@EntityListeners(ClienteListener.class)
@Table(name = "CLIENTES")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	private long id;
	private String nombre;
	@Column(name = "FECHA_NACIMIENTO")
	private LocalDateTime fechaNacimiento;
	private boolean raza;
	@OneToMany(cascade = CascadeType.ALL, targetEntity = Producto.class, mappedBy = "cliente")
	private Collection<Producto> productos;

	public Cliente() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public boolean isRaza() {
		return raza;
	}

	public void setRaza(boolean raza) {
		this.raza = raza;
	}

	public Collection<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Collection<Producto> productos) {
		this.productos = productos;
	}

	public void addProducto(Producto producto) {
		getProductos().add(producto);
		producto.setCliente(this);
	}

}
