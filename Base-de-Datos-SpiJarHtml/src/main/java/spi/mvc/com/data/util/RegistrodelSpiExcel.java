package spi.mvc.com.data.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

import spi.mvc.com.data.model.RegistrodelSpi;

@Component("/views/RegistroDelSpi/registrosdelspi.xlsx")
public class RegistrodelSpiExcel extends AbstractXlsxView{
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition", "attachment; filename=\"RegistrosBienesdelosSPI.xlsx\"");
		Sheet hoja = workbook.createSheet("Registros de los SPI");
		DateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
		
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
		box3.setCellValue("LISTA DE BIENES BIENES DE LOS SPI");
		
		Row filadatos=hoja.createRow(5);
		String[] columnasdatosspi = {"ID","Bien","SPI","Pertenencia del Bien", "Estado", "Cantidad","Cantidad Requerida","Cantidad faltante del bien","Prioridad","Acción realizada","Periodo", "Fecha"};
		
		for (int i = 0; i < columnasdatosspi.length; i++) {
			box =filadatos.createCell(i);
			box.setCellValue(columnasdatosspi[i]);
			
		}
		
		@SuppressWarnings("unchecked")
		List<RegistrodelSpi> listaregistrodelspi= (List<RegistrodelSpi>) model.get("listaregistrodelspi");
		
		int numfila=6;
		for (RegistrodelSpi registrosspi : listaregistrodelspi) {
			filadatos =hoja.createRow(numfila);
			
			filadatos.createCell(0).setCellValue(registrosspi.getIdregistro());
			filadatos.createCell(1).setCellValue(registrosspi.getIdactivo().getNombre());
			filadatos.createCell(2).setCellValue(registrosspi.getIdspi().getNombre());
			filadatos.createCell(3).setCellValue(registrosspi.getIdinstitucion().getNombre());
			filadatos.createCell(4).setCellValue(registrosspi.getEstado());
			filadatos.createCell(5).setCellValue(registrosspi.getCantidad());
			filadatos.createCell(6).setCellValue(registrosspi.getCantidadrequerida());
			filadatos.createCell(7).setCellValue(registrosspi.getHolguradecantidad());
			filadatos.createCell(8).setCellValue(registrosspi.getPrioridad());
			filadatos.createCell(9).setCellValue(registrosspi.getAccionrealizada());
			filadatos.createCell(10).setCellValue(registrosspi.getPeriodo());
			filadatos.createCell(11).setCellValue(formatofecha.format(registrosspi.getFechaaccion()));
			numfila ++;
			
		}
    }
}
