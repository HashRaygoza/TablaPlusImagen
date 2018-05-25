/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.hash.fontsize.tablaplusimagen;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
 
public class Tablas {
     
    static public void main(String[] args)
    {
        Document document = new Document();
         
        try{
            PdfWriter.getInstance(document, new FileOutputStream("tablas.pdf"));
            document.open();
             
            // Este codigo genera una tabla de 3 columnas
            PdfPTable table = new PdfPTable(3);
            
            // addCell() agrega una celda a la tabla, el cambio de fila
            // ocurre automaticamente al llenar la fila
            table.addCell("Celda 1");
            table.addCell("Celda 2");
            table.addCell("Celda 3");
             
            table.addCell("Celda 4");
            table.addCell("Celda 5");
            table.addCell("Celda 6");
             
            table.addCell("Celda 7");
            table.addCell("Celda 8");
            table.addCell("Celda 9");
             
            // Si desea crear una celda de mas de una columna
            // Cree un objecto Cell y cambie su propiedad span
             
            PdfPCell celdaFinal = new PdfPCell(new Paragraph("Final de la tabla"));
             
            // Indicamos cuantas columnas ocupa la celda
            celdaFinal.setColspan(3);
            table.addCell(celdaFinal);
             
            // Agregamos la tabla al documento            
            document.add(table);
            
            // Creamos y agregamos la imagen
            Image imagen = Image.getInstance("qr.png");
            imagen.setAbsolutePosition(278f, 52f);
            
            document.add(imagen);
            
            document.close();
             
        }catch(Exception e)
        {
            System.err.println("Ocurrio un error al crear el archivo");
            System.exit(-1);
        }
    }
}