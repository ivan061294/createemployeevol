package com.service.employe.Controller;

import java.sql.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.employe.Interfaces.IEmployees;
import com.service.employe.Models.ResponseHeader;
import com.service.employe.Models.employeeModels;
import com.service.employe.utils.MyDataAcces;

@RestController
@RequestMapping("/employee")
public class EmployeeControler implements IEmployees{
	@GetMapping
	public employeeModels get() {
		employeeModels employee = new employeeModels();
		MyDataAcces con = new MyDataAcces();
		ResultSet res=null;
	     res=con.getQuery("select * from APPS.TS_HR_CARGA_COL_TMP");
	     try {
			while(res.next()) {
				employee.setFecha(res.getString("Fecha"));
				employee.setDatosemployee(res.getString("Nombre")+","+
						          res.getString("Nombre_segundo")+","+
						          res.getString("Ape_paterno")+","+
						          res.getString("Ape_materno"));
			     
			     employee.setRemuneracion(res.getDouble("Remuneracion"));
			     employee.setTipo_contratacion(res.getString("Tipo_contratacion"));
			     employee.setLinea_solicitante(res.getString("Linea_solicitante"));
			     employee.setPerfil_ebs(res.getString("Perfil_ebs"));
			     employee.setPlazo_contrato(res.getDouble("Plazo_contrato"));
			     employee.setUni_tiempo(res.getString("Uni_tiempo"));
			     employee.setCargo(res.getString("Cargo"));
			     
			     employee.setDomiciliado(res.getString("Domiciliado"));
			     employee.setDomicilio(res.getString("Domicilio"));
			     employee.setDni(res.getString("Dni"));
			     employee.setTipododocumento(res.getString("Tipodedocumento"));
			     employee.setCuenta_cts(res.getString("Cuenta_cts"));
			     employee.setDiscapacidad(res.getString("Discapacidad"));
			     employee.setRegimen_salud(res.getString("Regimen_salud"));
			     employee.setCuspp(res.getString("Cuspp"));
			     employee.setHcm(res.getString("Hcm"));
			     employee.setSexo(res.getString("Sexo"));
			     employee.setFecha_nacimiento(res.getString("Fecha_nacimiento"));
			     employee.setRegion(res.getString("V_Region"));
			     employee.setCountry(res.getString("Country"));
			     employee.setTitulo(res.getString("Titulo"));
			     employee.setEmail(res.getString("Email"));
			     employee.setStatus(res.getString("Status"));
			     employee.setReference(res.getString("V_Reference"));
			     employee.setType(res.getString("V_Type"));

			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     return employee;
	}

	@PostMapping("/create")
	public ResponseHeader CreateEmployee(@RequestBody employeeModels employee){
		 ResponseHeader res=new ResponseHeader();
		try {
    
     MyDataAcces con = new MyDataAcces();
     Connection conn =con.getconect();
     if (conn != null) {
  	   System.out.println("Conexion a base de datos  . . . Ok");
  			     
  	 }
     CallableStatement cstmt = conn.prepareCall("begin ts_hr_colaboradores_pkg.pr_lee_datos("
     		+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);end;");
     String[] textElements = employee.getDatosemployee().split(",");
     cstmt.registerOutParameter(1, Types.VARCHAR);
     cstmt.registerOutParameter(2, Types.VARCHAR);
     cstmt.setString(3, employee.getFecha());
     cstmt.setString(4, textElements[0]);
     cstmt.setString(5, textElements[1]);
     cstmt.setString(6, textElements[2]);
     cstmt.setString(7, textElements[3]);
     cstmt.setString(8, employee.getUni_tiempo());
     cstmt.setString(9, employee.getTipo_contratacion());
     cstmt.setString(10, employee.getLinea_solicitante());
     cstmt.setString(11, employee.getPerfil_ebs());
     cstmt.setDouble(12, employee.getPlazo_contrato());
     cstmt.setString(13, employee.getCargo());
     cstmt.setDouble(14, employee.getRemuneracion());
     cstmt.setString(15, employee.getDomiciliado());
     cstmt.setString(16, employee.getDomicilio());
     cstmt.setString(17, employee.getDni());
     cstmt.setString(18, employee.getTipododocumento());
     cstmt.setString(19, employee.getCuenta_cts());
     cstmt.setString(20, employee.getDiscapacidad());
     cstmt.setString(21, employee.getRegimen_salud());
     cstmt.setString(22, employee.getCuspp());
     cstmt.setString(23, employee.getHcm());
     cstmt.setString(24, employee.getEmail());
     cstmt.setString(25, employee.getRegion());
     cstmt.setString(26, employee.getCountry());
     cstmt.setString(27, employee.getTitulo());
     cstmt.setString(28, employee.getStatus());
     cstmt.setString(29, employee.getReference());
     cstmt.setString(30, employee.getType());
     cstmt.setString(31, employee.getSexo());
     cstmt.setString(32, employee.getFecha_nacimiento());
     cstmt.execute();
     res.setEstado(cstmt.getString(2));
     res.setMensaje(cstmt.getString(1));
     cstmt.close();
		}
		catch(SQLException e) {
			res.setEstado("2");
			res.setMensaje("Ocurrio un error en la Insercion");
			return res;
		}
		return res;
		
		
	}
	
 
}
