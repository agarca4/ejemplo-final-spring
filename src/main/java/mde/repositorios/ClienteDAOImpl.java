package mde.repositorios;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import mde.entidades.Cliente;

@Transactional(readOnly = true)
public class ClienteDAOImpl implements ClienteDaoCustom {

	@Autowired
	ClienteDAO clienteDAO;

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Cliente> getClientesConFechaPosterior() {
		List<Cliente> clientes = clienteDAO.findAll().stream()
				.filter(j -> j.getFechaNacimiento().isAfter(LocalDateTime.of(1990, 1, 1, 00, 00, 00)))
				.collect(Collectors.toList());

		return clientes;
	}

}
