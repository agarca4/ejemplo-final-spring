package mde.repositorios;

import java.time.Instant;
import java.util.List;
import mde.entidades.Cliente;
import mde.entidades.Producto;

public interface ClienteDaoCustom {

	List<Cliente> getClientesConFechaPosterior(Instant fecha);

	List<Cliente> getClientesConFechaAnterior(Instant fecha);

	List<Producto> getProductosDelClienteActivos(Long id);

}
