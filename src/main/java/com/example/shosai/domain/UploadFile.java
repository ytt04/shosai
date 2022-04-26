/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.shosai.domain;

import com.example.shosai.domain.CrudProductos;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.example.shosai.Dao.ProductosDao;
import com.sun.rowset.internal.Row;
import java.io.IOException;
import com.example.shosai.controller.productosController;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.streaming.SXSSFRow.CellIterator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author Mahecha Ortiz
 */

public class UploadFile {

	@Autowired
	CrudProductos crudproductos;

	public List<CrudProductos> guardarFile(MultipartFile path) throws IOException, CsvValidationException {
		List<CrudProductos> lstProductos = new ArrayList<>();

		String ruta = "D:/" + path.getOriginalFilename();
		File localFile = new File(ruta);
		path.transferTo(localFile);

		CSVReader csvReader = new CSVReader(new FileReader(ruta));
		String[] fila = null;
		csvReader.readNext();
		while ((fila = csvReader.readNext()) != null) {
			CrudProductos p = new CrudProductos();
			p.setIdproducto(Integer.parseInt(fila[0]));
			p.setNombreproducto(fila[1]);
			p.setCantidadproducto(Integer.parseInt(fila[2]));
			p.setPrecioproducto(Integer.parseInt(fila[3]));
			p.setInventarios(new Inventarios(Integer.parseInt(fila[4])));
			lstProductos.add(p);
		}
		csvReader.close();
		return lstProductos;
	}
}
