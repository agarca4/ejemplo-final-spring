package mde.rest;

import java.time.Instant;
import java.util.List;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import mde.entidades.Cliente;
import mde.entidades.Producto;
import mde.repositorios.ClienteDAO;
import mde.repositorios.ProductoDAO;

@RepositoryRestController
@RequestMapping(path = "/clientes")
public class ClienteController {

	private ClienteDAO clienteDAO;

	public ClienteController(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	@GetMapping("/search/con-fecha-nacimiento-posterior-a")
	@ResponseBody
	public CollectionModel<PersistentEntityResource> getClientesConFechaPosterior(@RequestParam("fecha") Instant fecha,
			PersistentEntityResourceAssembler assembler) {

		List<Cliente> clientes = clienteDAO.getClientesConFechaPosterior(fecha);

		return assembler.toCollectionModel(clientes);
	}

	@GetMapping("/search/con-fecha-nacimiento-anterior-a")
	@ResponseBody
	public CollectionModel<PersistentEntityResource> getClientesConFechaAnterior(@RequestParam("fecha") Instant fecha,
			PersistentEntityResourceAssembler assembler) {

		List<Cliente> clientes = clienteDAO.getClientesConFechaAnterior(fecha);

		return assembler.toCollectionModel(clientes);
	}

	@GetMapping("/{id}/search/activos")
	@ResponseBody
	public CollectionModel<PersistentEntityResource> getProductosDelClienteActivos(@PathVariable Long id,
			PersistentEntityResourceAssembler assembler) {

		List<Producto> productos = clienteDAO.getProductosDelClienteActivos(id);

		return assembler.toCollectionModel(productos);
	}

}
