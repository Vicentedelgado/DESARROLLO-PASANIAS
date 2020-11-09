package spi.mvc.com.data.util;

import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import spi.mvc.com.data.model.AsignacionPeriferico;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component("/views/admin/perifericoasignacion/Listarasignacionperiferico")
public class ListarActaPerf extends AbstractPdfView{
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		@SuppressWarnings("unused")
		Date hoy = new Date();
		@SuppressWarnings("unused")
		DateFormat formatohoy = new SimpleDateFormat("EEEE, d MMMM, yyyy");
		@SuppressWarnings("unused")
		DateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
		
		@SuppressWarnings("unchecked")
		List<AsignacionPeriferico> listadoAsignacionP = (List<AsignacionPeriferico>) model.get("asignacionperiferico");
		
		
		  @SuppressWarnings("unchecked") 
		List<AsignacionPeriferico> listadoAsignacionPe  = (List<AsignacionPeriferico>) model.get("asignacionpe");
		 
		//ENCABEZADO
		PdfPTable tablatitulo= new PdfPTable(1);
		PdfPCell celda=null;
		PdfPTable tablatitulo1= new PdfPTable(1);
		PdfPCell titulo1=null;
		PdfPTable tablatitulo2= new PdfPTable(1);
		PdfPCell titulo2=null;
		PdfPTable tablatitulo3= new PdfPTable(1);
		PdfPCell titulo3=null;
		PdfPTable tablafechaactual= new PdfPTable(1);
		PdfPCell fechaactual=null;
		PdfPTable tabladatos= new PdfPTable(1);
		PdfPCell titulodatos=null;
		PdfPTable tablad= new PdfPTable(1);
		PdfPCell titulod=null;

		/* Fuentes*/
		Font fuente=FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Color.black);
		Font fuentetitulocolumna= FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Color.black);
		Font fuenteceldas= FontFactory.getFont(FontFactory.COURIER,10,Color.black);
		
		/*Titulos*/
		celda = new PdfPCell(new Phrase("SECRETARÍA DE DERECHOS HUMANOS", fuente));
		celda.setBorder(0);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		
		titulo1 = new PdfPCell(new Phrase("DIRECCIÓN DE TECNOLOGÍAS DE LA INFORMACIÓN Y COMUNICACIONES", fuente));
		titulo1.setBorder(0);
		titulo1.setHorizontalAlignment(Element.ALIGN_CENTER);
		titulo1.setVerticalAlignment(Element.ALIGN_CENTER);
		
		titulo2 = new PdfPCell(new Phrase("Equipos Tecnológicos", fuente));
		titulo2.setBorder(0);
		titulo2.setHorizontalAlignment(Element.ALIGN_CENTER);
		titulo2.setVerticalAlignment(Element.ALIGN_CENTER);
		
		titulo3 = new PdfPCell(new Phrase("", fuente));
		titulo3.setBorder(0);
		titulo3.setHorizontalAlignment(Element.ALIGN_CENTER);
		titulo3.setVerticalAlignment(Element.ALIGN_CENTER);
		
		fechaactual = new PdfPCell(new Phrase(formatohoy.format(hoy), fuentetitulocolumna));
		fechaactual.setBorder(0);
		fechaactual.setHorizontalAlignment(Element.ALIGN_RIGHT);
		fechaactual.setVerticalAlignment(Element.ALIGN_RIGHT);
		
		titulodatos = new PdfPCell(new Phrase("ACTA DE ENTREGA", fuente));
		titulodatos.setBackgroundColor(new Color(207,236,254));
		titulodatos.setBorder(0);
		titulodatos.setHorizontalAlignment(Element.ALIGN_CENTER);
		titulodatos.setVerticalAlignment(Element.ALIGN_CENTER);
		titulodatos.setPadding(10);
		
		titulod = new PdfPCell(new Phrase("DATOS EQUIPO", fuente));
		titulod.setBackgroundColor(new Color(207,236,254));
		titulod.setBorder(0);
		titulod.setHorizontalAlignment(Element.ALIGN_CENTER);
		titulod.setVerticalAlignment(Element.ALIGN_CENTER);
		titulod.setPadding(10);
		
		/*Añadiendo dtos a tablas*/
		tablatitulo.addCell(celda);
		tablatitulo1.addCell(titulo1);
		tablatitulo2.addCell(titulo2);
		tablatitulo3.addCell(titulo3);
		tablatitulo3.setSpacingAfter(30);
		tablafechaactual.addCell(fechaactual);
		tabladatos.addCell(titulodatos);
		tablad.addCell(titulod);
	
		
		/*SUBTITULO*/
		PdfPTable tablaSub = new PdfPTable(1);
		PdfPCell celda1 =null;
		celda1 = new PdfPCell(new Phrase("",fuente));
		celda1.setBorder(0);
		celda1.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda1.setVerticalAlignment(Element.ALIGN_CENTER);
		celda1.setPadding(20);
		
		tablaSub.addCell(celda1);
		
/////////////////////////////////////////////////////////////
		
		  PdfPTable tablaAPeriferico= new PdfPTable(2); tablaAPeriferico.setWidths(new
		  float[] {0.4f,2f});
		  
		  for(AsignacionPeriferico asignacionpe : listadoAsignacionP){ celda = new
		  PdfPCell(new Phrase("Nombres:",fuentetitulocolumna)); celda.setBorder(0);
		  celda.setPadding(3); tablaAPeriferico.addCell(celda); celda=new PdfPCell(new
		  Phrase(asignacionpe.getIdusuario().getNombres().toString(),fuenteceldas));
		  celda.setBorder(0); celda.setPadding(2); tablaAPeriferico.addCell(celda);
		  
		  celda = new PdfPCell(new Phrase("Apellidos:",fuentetitulocolumna));
		  celda.setBorder(0); celda.setPadding(3); tablaAPeriferico.addCell(celda);
		  celda=new PdfPCell(new
		  Phrase(asignacionpe.getIdusuario().getApellidos().toString(),fuenteceldas));
		  celda.setBorder(0); celda.setPadding(2); tablaAPeriferico.addCell(celda);
		  
		  celda = new PdfPCell(new Phrase("Cédula:",fuentetitulocolumna));
		  celda.setBorder(0); celda.setPadding(3); tablaAPeriferico.addCell(celda);
		  celda=new PdfPCell(new
		  Phrase(asignacionpe.getIdusuario().getCedula().toString(),fuenteceldas));
		  celda.setBorder(0); celda.setPadding(2); tablaAPeriferico.addCell(celda); }
		  ///////////////////////////////////////////////////////////
		 
		
			PdfPTable tablaPeriferico = new PdfPTable(6); 
			tablaPeriferico.setWidths(new float[] {2f,3f,3f,3.2f,3f,3.2f});
			
			celda = new PdfPCell(new Phrase("Nombre Periférico", fuentetitulocolumna));
			celda.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda.setVerticalAlignment(Element.ALIGN_CENTER);
			celda.setBackgroundColor(Color.lightGray);
			celda.setPadding(10);
			tablaPeriferico.addCell(celda);
			
			celda = new PdfPCell(new Phrase("Serie Periférico", fuentetitulocolumna));
			celda.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda.setVerticalAlignment(Element.ALIGN_CENTER);
			celda.setBackgroundColor(Color.lightGray);
			celda.setPadding(10);
			tablaPeriferico.addCell(celda);
			
			celda = new PdfPCell(new Phrase("Modelo Periférico", fuentetitulocolumna));
			celda.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda.setVerticalAlignment(Element.ALIGN_CENTER);
			celda.setBackgroundColor(Color.lightGray);
			celda.setPadding(10);
			tablaPeriferico.addCell(celda);
			
			celda = new PdfPCell(new Phrase("Marca", fuentetitulocolumna));
			celda.setBackgroundColor(Color.lightGray);
			celda.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda.setVerticalAlignment(Element.ALIGN_CENTER);
			celda.setPadding(10);
			tablaPeriferico.addCell(celda);
			
			
			celda = new PdfPCell(new Phrase("Observaciones", fuentetitulocolumna));
			celda.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda.setVerticalAlignment(Element.ALIGN_CENTER);
			celda.setBackgroundColor(Color.lightGray);
			celda.setPadding(10);
			tablaPeriferico.addCell(celda);
			
			
			  celda = new PdfPCell(new Phrase("Estado", fuentetitulocolumna));
			  celda.setHorizontalAlignment(Element.ALIGN_CENTER);
			  celda.setVerticalAlignment(Element.ALIGN_CENTER);
			  celda.setBackgroundColor(Color.lightGray); celda.setPadding(10);
			  tablaPeriferico.addCell(celda);
			
			for(AsignacionPeriferico asignacionperiferico : listadoAsignacionP) {

			/*NOMBRE EQUIPO*/
			celda = new PdfPCell(new Phrase(asignacionperiferico.getIdperiferico().getNombreperiferico().toString(),fuenteceldas));
			celda.setPadding(5);
			celda.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda.setVerticalAlignment(Element.ALIGN_CENTER);
			tablaPeriferico.addCell(celda);
			
			/*SERIE*/
			celda = new PdfPCell(new Phrase(asignacionperiferico.getIdperiferico().getSerie().toString(),fuenteceldas));
			celda.setPadding(5);
			celda.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda.setVerticalAlignment(Element.ALIGN_CENTER);
			tablaPeriferico.addCell(celda);
			
			/*MODELO*/
			celda = new PdfPCell(new Phrase(asignacionperiferico.getIdperiferico().getModelo().toString(),fuenteceldas));
			celda.setPadding(5);
			celda.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda.setVerticalAlignment(Element.ALIGN_CENTER);
			tablaPeriferico.addCell(celda);
			@SuppressWarnings("unused")
			String cadena = new String("");
			
			/*MARCA*/
			celda = new PdfPCell(new Phrase(asignacionperiferico.getIdperiferico().getMarca().toString(),fuenteceldas));
			celda.setPadding(5);
			celda.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda.setVerticalAlignment(Element.ALIGN_CENTER);
			tablaPeriferico.addCell(celda);
			
			/*OBSERVACIONES*/
			celda = new PdfPCell(new Phrase(asignacionperiferico.getIdperiferico().getObservaciones().toString(),fuenteceldas));
			celda.setPadding(5);
			celda.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda.setVerticalAlignment(Element.ALIGN_CENTER);
			tablaPeriferico.addCell(celda);
			
			/*ESTADO*/
			
			  celda = new PdfPCell(new
			  Phrase(asignacionperiferico.getIdperiferico().getEstado().toString(),
			  fuenteceldas)); celda.setPadding(5);
			  celda.setHorizontalAlignment(Element.ALIGN_CENTER);
			  celda.setVerticalAlignment(Element.ALIGN_CENTER);
			  tablaPeriferico.addCell(celda);
			 
			
			}
			
			/*LINEAS Y FIRMAS*/
			PdfPTable tablalinea= new PdfPTable(2);
			tablalinea.setWidths(new float[] {2f,2f});
			tablalinea.setSpacingBefore(60);
			PdfPCell linea=null;
			
			for (int i = 0; i < 1; i++) {
				linea = new PdfPCell(new Phrase("________________________________", fuente));
				linea.setBorder(0);
				linea.setHorizontalAlignment(Element.ALIGN_CENTER);
				linea.setVerticalAlignment(Element.ALIGN_CENTER);
				tablalinea.addCell(linea);
				
				
				linea = new PdfPCell(new Phrase("________________________________", fuente));
				linea.setBorder(0);
				linea.setHorizontalAlignment(Element.ALIGN_CENTER);
				linea.setVerticalAlignment(Element.ALIGN_CENTER);
				tablalinea.addCell(linea);
			}
			
			PdfPTable tablafirma= new PdfPTable(2);
			tablafirma.setWidths(new float[] {2f,2f});
			tablafirma.setSpacingBefore(10);
			
			PdfPCell firma=null;
			
			for (int i = 0; i < 1; i++) {
				firma = new PdfPCell(new Phrase("Entrega el periférico", fuente));
				firma.setBorder(0);
				firma.setHorizontalAlignment(Element.ALIGN_CENTER);
				firma.setVerticalAlignment(Element.ALIGN_CENTER);
				tablafirma.addCell(firma);
				
				firma = new PdfPCell(new Phrase("Receptor", fuente));
				firma.setBorder(0);
				firma.setHorizontalAlignment(Element.ALIGN_CENTER);
				firma.setVerticalAlignment(Element.ALIGN_CENTER);
				tablafirma.addCell(firma);
			
			}		

			// Añadir escrito al documento
			document.add(tablatitulo);
			document.add(tablatitulo1);
			document.add(tablatitulo2);
			document.add(tablatitulo3);
			document.add(tablafechaactual);
			document.add(tabladatos);
			document.add(tablaAPeriferico); 
			document.add(tablad);
			document.add(tablaPeriferico);
			document.add(tablalinea);
			document.add(tablafirma);	
		
	}
}
