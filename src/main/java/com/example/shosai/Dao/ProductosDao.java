package com.example.shosai.Dao;

import com.example.shosai.domain.CrudProductos;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductosDao extends CrudRepository<CrudProductos, Integer> {

    @Query(value = "select A.* from productos A \n"
            + "LEFT JOIN material_has_productos B ON (A.idProducto=B.PRODUCTOS_id_producto)\n"
            + "LEFT JOIN productos_has_ventas C ON (A.idProducto=C.PRODUCTOS_id_producto)\n"
            + "WHERE  B.PRODUCTOS_id_producto is null and C.PRODUCTOS_id_producto is null", nativeQuery = true)
    public List<CrudProductos> listarProductosEliminar();

    @Query(value = "select A.* from productos A \n"
            + "INNER JOIN material_has_productos B ON (A.idProducto=B.PRODUCTOS_id_producto)\n"
            + "INNER JOIN productos_has_ventas C ON (A.idProducto=C.PRODUCTOS_id_producto)\n", nativeQuery = true)
    public List<CrudProductos> listarProductos();
    
    //public List<CrudProductos> saveAll(List<CrudProductos> listCrudProductos);


}
