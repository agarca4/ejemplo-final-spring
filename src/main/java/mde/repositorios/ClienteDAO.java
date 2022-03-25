package mde.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import mde.entidades.Cliente;

@RepositoryRestResource(path = "clientes", itemResourceRel = "cliente", collectionResourceRel = "clientes")
public interface ClienteDAO extends JpaRepository<Cliente, Long>, ClienteDaoCustom{
	
	@RestResource(path="por-nombre")
    List<Cliente> findByNombreIgnoreCase(@Param("nombre")String txt);
	
//	@RestResource(exported = false)
//	void delete(Cliente cliente);
}
