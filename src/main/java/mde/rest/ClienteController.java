package mde.rest;

import java.util.List;

import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mde.entidades.Cliente;
import mde.repositorios.ClienteDAO;

@RepositoryRestController
@RequestMapping(path = "/clientes/search")
public class ClienteController {
	private ClienteDAO clienteDAO;

	public ClienteController(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	@GetMapping("/por-fecha")
	@ResponseBody
	public CollectionModel<PersistentEntityResource> getClientesConFechaPosterior(
			PersistentEntityResourceAssembler assembler) {

		List<Cliente> clientes = clienteDAO.getClientesConFechaPosterior();

		return assembler.toCollectionModel(clientes);
	}

}
