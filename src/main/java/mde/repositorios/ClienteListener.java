package mde.repositorios;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mde.entidades.Cliente;

@Component
public class ClienteListener {
	
	private Logger log = LoggerFactory.getLogger(ClienteListener.class);
	private ClienteDAO clienteDAO;

	@Autowired
	public void init(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	@PrePersist
	public void preGuardarCliente(Cliente cliente) {
		log.warn("Se va a guardar un cliente: " + cliente.getNombre());
	}

	@PreRemove
	public void preBorrar(Cliente cliente) {
		System.err.println("Se va a borrar un cliente: " + cliente.getNombre());

	}
}
