package mde.repositorios;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

import mde.entidades.Cliente;


public interface ClienteDaoCustom {

	List<Cliente> getClientesConFechaPosterior(Instant fecha);

	
	
}
