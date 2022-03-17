package mde.rest;

import java.time.Instant;
import java.time.LocalDateTime;
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
import mde.repositorios.ClienteDAO;

@RepositoryRestController
@RequestMapping(path = "/clientes/search")
public class ClienteController {
	private ClienteDAO clienteDAO;

	public ClienteController(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	@GetMapping("/con-fecha-nacimiento-posterior-a")
	@ResponseBody
	public CollectionModel<PersistentEntityResource> getClientesConFechaPosterior(@RequestParam("fecha") Instant fecha,
			PersistentEntityResourceAssembler assembler) {

		List<Cliente> clientes = clienteDAO.getClientesConFechaPosterior(fecha);

		return assembler.toCollectionModel(clientes);
	}

}
