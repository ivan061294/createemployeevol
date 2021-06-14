package com.service.employe.Models;

import java.util.Dictionary;

public class ResponseHeader {
 private String Estado;
 private String Mensaje;
 public ResponseHeader() {
	
}
//private Dictionary<String,Object>detalle =new Dictionary<String, Object>();
public String getEstado() {
	return Estado;
}
public void setEstado(String estado) {
	Estado = estado;
}
public String getMensaje() {
	return Mensaje;
}
public void setMensaje(String mensaje) {
	Mensaje = mensaje;
}
}
