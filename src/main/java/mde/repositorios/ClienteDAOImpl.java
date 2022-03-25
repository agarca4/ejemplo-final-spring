package mde.repositorios;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import mde.entidades.Cliente;
import mde.entidades.Producto;

@Transactional(readOnly = true)
public class ClienteDAOImpl implements ClienteDaoCustom {

	@Autowired
	ClienteDAO clienteDAO;

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Cliente> getClientesConFechaPosterior(Instant fecha) {
		List<Cliente> clientes = clienteDAO.findAll().stream().filter(j -> j.getFechaNacimiento().isAfter(fecha))
				.collect(Collectors.toList());

		return clientes;
	}

	@Override
	public List<Cliente> getClientesConFechaAnterior(Instant fecha) {

		List<Cliente> clientes = clienteDAO.findAll().stream().filter(j -> j.getFechaNacimiento().isBefore(fecha))
				.collect(Collectors.toList());

		return clientes;
	}

	@Override
	public List<Producto> getProductosDelClienteActivos(Long id) {
		List<Producto> productos = clienteDAO.findById(id).get().getProductos().stream()
				.filter(j -> j.getActivo() == true).collect(Collectors.toList());

		return productos;
	}

}
