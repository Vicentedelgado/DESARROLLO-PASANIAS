package spi.mvc.com.data.util;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import spi.mvc.com.data.model.RRHH;

@Component("/views/DataSpi/RRHH/rrhh.xlsx")
public class RRHHExcel extends AbstractXlsxView{
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition", "attachment; filename=\"RegistrosdelRRHH.xlsx\"");
		Sheet hoja = workbook.createSheet("Registros de RRHH de los SPIs");
		
		Row filatitulo= hoja.createRow(0);
		Cell box =filatitulo.createCell(2);
		box.setCellValue("SECRETARÍA DE DERECHOS HUMANOS");
		Row filatitulo1= hoja.createRow(1);
		Cell box1 =filatitulo1.createCell(2);
		box1.setCellValue("DIRECCIÓN ADMINISTRATIVA");
		Row filatitulo2= hoja.createRow(2);
		Cell box2 =filatitulo2.createCell(2);
		box2.setCellValue("Coordinación General Administrativa Financiera");
		Row filatitulo3= hoja.createRow(3);
		Cell box3 =filatitulo3.createCell(2);
		box3.setCellValue("Base de Datos SPI");
		Row filatitulo4= hoja.createRow(4);
		Cell box4 =filatitulo4.createCell(1);
		box4.setCellValue("LISTA DE BIENES Y SERVICIOS DE LOS SPI");
		
		Row filadatos=hoja.createRow(6);
		String[] columnasdatosspi = {"ID","Nombres","Apellidos","Cédula","Zona", "SPI", "Cargo","Modalidad de trabajo","Unidad","Número telefónico","Email","Dirección de domicilio"};
		
		for (int i = 0; i < columnasdatosspi.length; i++) {
			box =filadatos.createCell(i);
			box.setCellValue(columnasdatosspi[i]);
			
		}
		
		@SuppressWarnings("unchecked")
		List<RRHH> listarrhh= (List<RRHH>) model.get("listarrhh");
		
		int numfila=7;
		for (RRHH registrosrrhh : listarrhh) {
			filadatos =hoja.createRow(numfila);
			
			filadatos.createCell(0).setCellValue(registrosrrhh.getIdusuario());
			filadatos.createCell(1).setCellValue(registrosrrhh.getNombres());
			filadatos.createCell(2).setCellValue(registrosrrhh.getApellidos());
			filadatos.createCell(3).setCellValue(registrosrrhh.getCedula());
			filadatos.createCell(4).setCellValue(registrosrrhh.getIdzona().getNombre());
			filadatos.createCell(5).setCellValue(registrosrrhh.getIdspi().getNombre());
			filadatos.createCell(6).setCellValue(registrosrrhh.getCargo());
			filadatos.createCell(7).setCellValue(registrosrrhh.getIdmodalidad().getNombre());
			filadatos.createCell(8).setCellValue(registrosrrhh.getIdunidad().getNombre());
			filadatos.createCell(9).setCellValue(registrosrrhh.getTelefono());
			filadatos.createCell(10).setCellValue(registrosrrhh.getEmail());
			filadatos.createCell(11).setCellValue(registrosrrhh.getDireccion());	
			numfila ++;
			
		}
	}

}
