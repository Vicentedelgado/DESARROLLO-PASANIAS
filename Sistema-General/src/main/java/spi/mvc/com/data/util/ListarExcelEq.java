package spi.mvc.com.data.util;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spi.mvc.com.data.model.Equipo;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

@Component("/views/admin/equipo/Listarequipo.xlsx")
public class ListarExcelEq extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.setHeader("Content-Disposition", "attachment; filename=\"reporte-equipos.xlsx\"");
		Sheet hoja = workbook.createSheet("Equipos");
	
			Row filatitulo = hoja.createRow(0);
			Cell celda = filatitulo.createCell(0);
			celda.setCellValue("REPORTE DE ESTADO DE EQUIPOS");
			
			Row filadata = hoja.createRow(2);
			String[] columnas = {"Zonal", "Nombre Equipo", "Estado", "Marca", "Modelo"};
			
			for(int i=0; i < columnas.length; i++ ) {
				celda = filadata.createCell(i);
				celda.setCellValue(columnas[i]);
			}
			@SuppressWarnings("unchecked")
			List<Equipo> listadoEquipo = (List<Equipo>) model.get("equipo");
			
			int numFila = 3;
			for(Equipo equipo : listadoEquipo) {
				filadata = hoja.createRow(numFila);
				filadata.createCell(0).setCellValue(equipo.getZona().getNombre());
				filadata.createCell(1).setCellValue(equipo.getNombreequipo());
				filadata.createCell(2).setCellValue(equipo.getEstado());
				filadata.createCell(3).setCellValue(equipo.getMarca());
				filadata.createCell(4).setCellValue(equipo.getModelo());
				
				numFila ++;
			}
	}

}
