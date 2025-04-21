package com.example.shosai.commonns;
 
import com.example.shosai.Dao.ReporteVentasServiceAPI;
 
 
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
 
import javax.sql.DataSource;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
 
import net.sf.jasperreports.engine.JRException;
 

/**
 *
 * @author djped
 */
@Service
public class ReporteVentasServiceImpl implements ReporteVentasServiceAPI {
 
	@Autowired
	private JasperReportManager reportManager;
 
	@Autowired
	private DataSource dataSource;
 

        /**
         *
         * @author djped
         */
	@Override
	public ReporteVentasDTO obtenerReporteVentas(Map<String, Object> params)
			throws JRException, IOException, SQLException {
		String fileName = "ReporteMensualVenta";
		ReporteVentasDTO dto = new ReporteVentasDTO();
		String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx"
				: ".pdf";
		dto.setFileName(fileName + extension);
 
		ByteArrayOutputStream stream = reportManager.export(fileName, params.get("tipo").toString(), params,
				dataSource.getConnection());
 
		byte[] bs = stream.toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);
 
		return dto;
	}
        @Override
	public ReporteVentasDTO obtenerReporteVentas1(Map<String, Object> params)
			throws JRException, IOException, SQLException {
		String fileName = "Ventas_Fecha";
		ReporteVentasDTO dto = new ReporteVentasDTO();
		String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx"
				: ".pdf";
		dto.setFileName(fileName + extension);
 
		ByteArrayOutputStream stream = reportManager.export(fileName, params.get("tipo").toString(), params,
				dataSource.getConnection());
 
		byte[] bs = stream.toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);
 
		return dto;
	}
          @Override
	public ReporteVentasDTO obtenerReporteInventario(Map<String, Object> params)
			throws JRException, IOException, SQLException {
		String fileName = "Producto_Inventario";
		ReporteVentasDTO dto = new ReporteVentasDTO();
		String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx"
				: ".pdf";
		dto.setFileName(fileName + extension);
 
		ByteArrayOutputStream stream = reportManager.export(fileName, params.get("tipo").toString(), params,
				dataSource.getConnection());
 
		byte[] bs = stream.toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);
 
		return dto;
	}
            @Override
	public ReporteVentasDTO obtenerReporteInventario1(Map<String, Object> params)
			throws JRException, IOException, SQLException {
		String fileName = "Inventario_Actual1";
		ReporteVentasDTO dto = new ReporteVentasDTO();
		String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx"
				: ".pdf";
		dto.setFileName(fileName + extension);
 
		ByteArrayOutputStream stream = reportManager.export(fileName, params.get("tipo").toString(), params,
				dataSource.getConnection());
 
		byte[] bs = stream.toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);
 
		return dto;
	}
           @Override
	public ReporteVentasDTO obtenerReporteUsuario(Map<String, Object> params)
			throws JRException, IOException, SQLException {
		String fileName = "usuario";
		ReporteVentasDTO dto = new ReporteVentasDTO();
		String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx"
				: ".pdf";
		dto.setFileName(fileName + extension);
 
		ByteArrayOutputStream stream = reportManager.export(fileName, params.get("tipo").toString(), params,
				dataSource.getConnection());
 
		byte[] bs = stream.toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);
 
		return dto;
	}



 
}