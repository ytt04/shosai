package com.example.shosai.Dao;

import com.example.shosai.domain.CrudVentas;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface VentasDao extends CrudRepository<CrudVentas, Integer> {

    @Query(value = "select * from ventas inner join cliente on (ventas.CLIENTE_id_cliente = cliente.id_cliente) ", nativeQuery = true)
    public List<CrudVentas> listarVentasEliminar();

    @Query(value = "select * from ventas inner join cliente on (ventas.CLIENTE_id_cliente = cliente.id_cliente) ", nativeQuery = true)
    public List<CrudVentas> listarVentas();

    @Query(value = "select * from domicilios d inner join ventas v "
            + "(on d.id_domicilio = v.DOMICILIOS_id_domicilio\n"
            + "inner join cliente c on v.CLIENTE_id_cliente = c.id_cliente ) ", nativeQuery = true)
    public List<CrudVentas> DomiciliosVentas();
}
