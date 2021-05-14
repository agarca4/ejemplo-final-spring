package mde.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import mde.entidades.Producto;

@RepositoryRestResource(path = "productos", itemResourceRel = "producto", collectionResourceRel = "productos")
public interface ProductoDAO extends JpaRepository<Producto, Long> {

}
