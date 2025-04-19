/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.shosai.Dao;

import com.example.shosai.commonns.ReporteVentasDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
 import net.sf.jasperreports.engine.JRException;
/**
 *
 * @author HP
 */
public interface ReporteVentasServiceAPI {
    ReporteVentasDTO obtenerReporteVentas(Map<String, Object> params) throws JRException, IOException, SQLException;
        ReporteVentasDTO obtenerReporteVentas1 (Map<String, Object> params) throws JRException, IOException, SQLException;
        ReporteVentasDTO obtenerReporteInventario (Map<String, Object> params) throws JRException, IOException, SQLException;
        ReporteVentasDTO obtenerReporteInventario1 (Map<String, Object> params) throws JRException, IOException, SQLException;
        ReporteVentasDTO obtenerReporteUsuario (Map<String, Object> params) throws JRException, IOException, SQLException;
}
