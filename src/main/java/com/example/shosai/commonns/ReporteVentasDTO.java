/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.shosai.commonns;
 
import java.io.ByteArrayInputStream;
 
/**
 *
 * @author Andrea Gonzáles
 */
public class ReporteVentasDTO {
 
	private String fileName;
	private ByteArrayInputStream stream;
	private int length;
 
	public String getFileName() {
		return fileName;
	}
 
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
 
	public ByteArrayInputStream getStream() {
		return stream;
	}
 
	public void setStream(ByteArrayInputStream stream) {
		this.stream = stream;
	}
 
	public int getLength() {
		return length;
	}
 
	public void setLength(int length) {
		this.length = length;
	}
 
}