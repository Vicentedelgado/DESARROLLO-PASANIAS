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

import spi.mvc.com.data.model.SpiDatos;

@Component("/views/SpiDatos/spidatos.xlsx")
public class SpiDatosExcel extends AbstractXlsxView{
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition", "attachment; filename=\"RegistroDatosSPI.xlsx\"");
		Sheet hoja = workbook.createSheet("Registros de datos SPI");
		
		Row filatitulo= hoja.createRow(0);
		Cell box =filatitulo.createCell(2);
		box.setCellValue("SECRETARÍA DE DERECHOS HUMANOS");
		Row filatitulo1= hoja.createRow(1);
		Cell box1 =filatitulo1.createCell(2);
		box1.setCellValue("DIRECCIÓN ADMINISTRATIVA");
		Row filatitulo2= hoja.createRow(2);
		Cell box2 =filatitulo2.createCell(2);
		box2.setCellValue("MODELO DE GESTIÓN ADMINISTRATIVA SPI");
		Row filatitulo3= hoja.createRow(3);
		Cell box3 =filatitulo3.createCell(1);
		box3.setCellValue("LISTA SPI DATOS");
		
		Row filadatos=hoja.createRow(5);
		String[] columnasdatosspi = {"ID","SPI","Zona","Institución Donde Funciona","Dirección", "Número teléfonico", "Número de oficina","Convenio","Da servicio a","Observaciones"};
		
		for (int i = 0; i < columnasdatosspi.length; i++) {
			box =filadatos.createCell(i);
			box.setCellValue(columnasdatosspi[i]);
			
		}
		
		@SuppressWarnings("unchecked")
		List<SpiDatos> listaspidatos= (List<SpiDatos>) model.get("listaspidatos");
		
		int numfila=6;
		for (SpiDatos registrospidatos: listaspidatos) {
			filadatos =hoja.createRow(numfila);
			
			filadatos.createCell(0).setCellValue(registrospidatos.getIdspi());
			filadatos.createCell(1).setCellValue(registrospidatos.getNombre());
			filadatos.createCell(2).setCellValue(registrospidatos.getIdzona().getNombre());
			filadatos.createCell(3).setCellValue(registrospidatos.getIdinstitucion().getNombre());
			filadatos.createCell(4).setCellValue(registrospidatos.getDireccion());
			filadatos.createCell(5).setCellValue(registrospidatos.getTelefono());
			filadatos.createCell(6).setCellValue(registrospidatos.getNumerodeoficina());
			filadatos.createCell(7).setCellValue(registrospidatos.getConvenio());
			filadatos.createCell(8).setCellValue(registrospidatos.getDaservicioa());
			filadatos.createCell(9).setCellValue(registrospidatos.getObservaciones());	
			numfila ++;
			
		}
	}

}
