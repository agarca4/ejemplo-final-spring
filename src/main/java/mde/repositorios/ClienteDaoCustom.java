package mde.repositorios;

import java.util.List;

import mde.entidades.Cliente;


public interface ClienteDaoCustom {

	List<Cliente> getClientesConFechaPosterior();

	
	
}
