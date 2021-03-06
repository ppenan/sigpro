package utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.Cell;
import be.quodlibet.boxable.Row;


public class CPdf {
	/**
	 * variables de control de tama�o de celdas
	 * */
	
	private float celda_a=21;
	private float celda_b=(float)6.7;
	private float celda_c=6;
	private float font_size=7f;
	/*
	 * variables de texto
	 * */
	private String titulo ="";
	//private String anio="";
	//private int numero_columnas=13;
	float restante;
	/**
	 * Variables del documento
	 */
	private PDDocument doc;
	private PDPage page;
	
	
		public CPdf(String titulo){
			this.titulo=titulo;
			doc = new PDDocument();
			
		}
		public String ExportPdfMetasPrestamo(String [][]headers, String [][]datosMetas, int visualizacion){
			String path = "";
			try{	
			    String [] cabeceras = new String[headers[0].length];
			    System.arraycopy( headers[0], 0, cabeceras, 0, headers[0].length );
				String [][]cabeceras_fixed= configurarCabeceras(cabeceras,datosMetas[0],visualizacion);
				List <String[][]>tablas =divTablas(cabeceras_fixed,datosMetas,visualizacion);
				restante= visualizacion==2? (datosMetas[0].length % 12):(datosMetas[0].length % 13) ;
				PDFont font = PDType1Font.HELVETICA_BOLD;
				List<Float> altura= new ArrayList<Float>();
				for(int x=0;x<tablas.size();x++){
					page = new PDPage(new PDRectangle(PDRectangle.LETTER.getHeight(), PDRectangle.LETTER.getWidth()));
				    doc.addPage( page );
					PDPageContentStream contentStream = new PDPageContentStream(doc, page);
					
					if(x==0){
						contentStream.beginText();
						contentStream.setFont(font, 18);
						//definir x, y
						contentStream.newLineAtOffset(50, 550);
						contentStream.showText("Ministerio de Finanzas P�blicas");
						contentStream.endText();
						contentStream.beginText();
						contentStream.setFont(font, 12);
						//definir x, y
						contentStream.newLineAtOffset(50, 530);
						contentStream.showText("Reporte: "+titulo);
						contentStream.endText();
					}
					
					
					float margin = 50;
					float yStartNewPage = page.getMediaBox().getHeight() - (2 * margin);
					float tableWidth = page.getMediaBox().getWidth() - (2 * margin);

					boolean drawContent = true;
					//float yStart = yStartNewPage;
					float bottomMargin = 70;
					// y position is your coordinate of top left corner of the table
					//float yPosition = 525;
					
					String[][] tabla_tmp = tablas.get(x);
					BaseTable table_x= new BaseTable(525, yStartNewPage, bottomMargin, tableWidth, margin, doc, page, true, drawContent);
					boolean ultimo=x==tablas.size()-1;
					table_x.addHeaderRow(agregarCabecera(table_x,tabla_tmp[0],x,ultimo,visualizacion));
					//table_x.getRows().get(0).set
					Row<PDPage> row = table_x.createRow(12);
					
					table_x.addHeaderRow(
							agregarCabecera_pt2(row, tabla_tmp[1],x==0)
					);
					//agregamos los datos
					for(int i=2;i<tabla_tmp.length;i++){
						row= agregarFila(table_x,tabla_tmp[i], x==0,x==tablas.size()-1);
					}
					if(x==0){
						altura=obtenerAlturas(table_x);
					}else{
						for(int i=0; i<table_x.getRows().size(); i++){
							table_x.getRows().get(i).setHeight(altura.get(i));
						}
					}
					table_x.draw();
					contentStream.close();
				}
			    path = String.join("","/archivos/temporales/temp_",((Long) new Date().getTime()).toString(),".pdf");
				FileOutputStream out = new FileOutputStream(new File(path));
				doc.save(out);
				doc.close();
			}catch(Exception o){
				o.printStackTrace();
			}
			return path;
		}
		
		private List<Float> obtenerAlturas(BaseTable entrada){
			List <Float> ret = new ArrayList<Float>();
			for(int i=0; i<entrada.getRows().size();i++){
				ret.add(entrada.getRows().get(i).getHeight());
			}
			return ret;
			
		}
		public Row<PDPage> agregarFila(BaseTable table, String []datos, boolean primero, boolean ultimo){
			Row<PDPage> row = table.createRow(12);
			int cont=0;
			int tope= ultimo ? (int)restante: datos.length;
			if(primero){
				Cell<PDPage> cell = row.createCell(celda_a, datos[0]);
				cell.setFontSize(font_size);
				cell = row.createCell(celda_c, datos[1]);
				cell.setFontSize(font_size);
				cont=2;
			}
			for(int i=cont;i<tope;i++){
					Cell<PDPage> cell = row.createCell(celda_b, datos[i]);
					cell.setFontSize(font_size);
				
			}
			return row;
		}
		
		private Row<PDPage> agregarCabecera(BaseTable table,String cabecera[], int posicion, boolean ultimo, int visualizacion){
			Row<PDPage> headerRow = table.createRow(12);
			int corrimiento=0;
			float tam_celda=celda_b;
			Cell<PDPage> cell;			
			if(posicion==0){
				corrimiento=2;
				cell = headerRow.createCell(celda_a, "");
				cell = headerRow.createCell(celda_c, "");	
			}
			if(visualizacion==2){
				tam_celda=tam_celda*2;
				for(int i =corrimiento; i<cabecera.length;i++){
					if(cabecera[i]!=null&& !cabecera[i].isEmpty()&&i!=cabecera.length-1){
						cell = headerRow.createCell(tam_celda, cabecera[i]);
						cell.setHeaderCell(true);
					}
				}
			}else{
				for(int i =corrimiento; i<cabecera.length;i++){
					if(cabecera[i]!=null&& !cabecera[i].isEmpty()&&i!=cabecera.length){
						cell = headerRow.createCell(tam_celda, cabecera[i]);
						cell.setHeaderCell(true);
					}
				}
			}
			
			if(ultimo){
				cell = headerRow.createCell(celda_b, "");
				cell.setHeaderCell(true);
			}
			return headerRow;
			
		}
		private Row<PDPage> agregarCabecera_pt2(Row<PDPage> row,String cabecera[],boolean primero){
			Cell<PDPage> cell;
			int cont=0;
			if(primero){
				cell = row.createCell(celda_a, cabecera[0]);
				cell.setFontSize(cell.getFontSize()-1f);
				cell = row.createCell(celda_c,cabecera[1]);	
				cell.setFontSize(cell.getFontSize()-1f);
				cont=2;
			}
			for(int i =cont; i<cabecera.length;i++){
				if(cabecera[i]!=null&&!cabecera[i].isEmpty()){
					cell = row.createCell(celda_b, cabecera[i]);
					cell.setFontSize(cell.getFontSize()-1f);
				}
				
			}
			return row;
		}
		
		
		
		private String[][] configurarCabeceras(String []cabecera, String []subcabecera, int visualizacion){
			String [][]ret=new String [2][subcabecera.length];
			//primera l�nea.
			ret[0][0]=" ";
			ret[0][1]=" ";
			int cont=2;
			for(int i =2; i<cabecera.length-1;i++){
				if(!cabecera[i].isEmpty()&&cabecera[i].compareTo("null")!=0){
					ret[0][cont]=cabecera[i];
					cont++;
				}
			}
			ret[1][0]="Nombre";
			ret[1][1]="Meta Unidad Medida";
			int control =1;
			//segunda l�nea
			if(visualizacion==2){
				for(int i =0; i<subcabecera.length-3;i++){
					cont=i;
					if(control==2){
						control=1;
						ret[1][i+2]="Real";
					}else{
						control++;
						ret[1][i+2]="Planificado";
					}
				}
				ret[1][ret[1].length-1]="Meta Final";
			}else{
				String tipo= visualizacion==0? "planificado" : "Real";
				for(int i =0; i<subcabecera.length-3;i++){
					cont=i;
					ret[1][i+2]=tipo;
					
				}
				ret[1][ret[1].length-1]="Meta Final";
			}
			
			return ret;
		}
		
		
		
		private List<String [][]>divTablas(String [][]cabecera, String [][]datos, int visualizacion){
			List <String[][]>ret  = new ArrayList<String[][]>();
			int totalFilas= cabecera.length+datos.length;
			if(visualizacion==2){
				int num = (int)Math.ceil(
						((datos[0].length)/12)+((datos[0].length)% 12)*0.1
						);
				int num_col_data=datos[0].length;
				try{
					for(int x=0; x<num; x++){
						int tam_horizontal= num>1? 12: 13;
						String [][] tabla_tmp= new String[totalFilas][tam_horizontal];
						int medida= num_col_data-(12*x)>12? 12: num_col_data-(12*x);
						int tam_cab= x==0? 7: 6;
						int poscab= x==0? 0: (6*x)+1;
						for(int y=0; y<totalFilas;y++){
							if(y==0){
								System.arraycopy(cabecera[y],poscab, tabla_tmp[y], 0, tam_cab);
							}else if(y==1){
								System.arraycopy(cabecera[y], 12*x, tabla_tmp[y], 0, medida);
							}else{
								System.arraycopy( datos[y-2], 12*x, tabla_tmp[y], 0, medida);
							}
						}
						ret.add(tabla_tmp);
					}
					
				}catch(Exception o){
					o.printStackTrace();
				}
			}else{
				int num = (int)Math.ceil(
						((datos[0].length)/13)+((datos[0].length)% 13)*0.1
						);
				int num_col_data=datos[0].length;
				try{
					for(int x=0; x<num; x++){
						int tam_horizontal= 13;
						String [][] tabla_tmp= new String[totalFilas][tam_horizontal];
						int medida= num_col_data-(13*x)>13? 13: num_col_data-(13*x);
						for(int y=0; y<totalFilas;y++){
							if(y<2){
								System.arraycopy(cabecera[y],13*x, tabla_tmp[y], 0, medida);
							}else{
								System.arraycopy( datos[y-2], 13*x, tabla_tmp[y], 0, medida);
							}
						}
						ret.add(tabla_tmp);
					}
					
				}catch(Exception o){
					o.printStackTrace();
				}
			}
			return ret;
		}
		
		
}
