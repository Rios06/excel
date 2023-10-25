package Tools;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Excel {

    public void createExcelFile() {
        Workbook workbook;
        try {
            workbook = WorkbookFactory.create(new File("TiendaDA.xls"));
        } catch (Exception e) {
            workbook = new HSSFWorkbook();
        }
        Sheet sheetAnimales = workbook.createSheet("Animales");
        Row rowAnimales = sheetAnimales.createRow(sheetAnimales.getLastRowNum() + 1);

        rowAnimales.createCell(0).setCellValue("Raza");
        rowAnimales.createCell(1).setCellValue("Especie");
        rowAnimales.createCell(2).setCellValue("Nombre");
        rowAnimales.createCell(3).setCellValue("edad");
        rowAnimales.createCell(4).setCellValue("estado de salud");
        rowAnimales.createCell(5).setCellValue("Descripcion");


        Sheet sheetAdoptantes = workbook.createSheet("Adoptantes");
        Row rowAdoptantes = sheetAdoptantes.createRow(sheetAdoptantes.getLastRowNum() + 1);

        rowAdoptantes.createCell(0).setCellValue("nombre");
        rowAdoptantes.createCell(1).setCellValue("contraseña");
        rowAdoptantes.createCell(2).setCellValue("edad");
        rowAdoptantes.createCell(3).setCellValue("direccion");
        rowAdoptantes.createCell(4).setCellValue("numero contacto");

        Sheet sheetEmpleados = workbook.createSheet("Empleados");
        Row rowEmpleados = sheetEmpleados.createRow(sheetEmpleados.getLastRowNum() + 1);

        rowEmpleados.createCell(0).setCellValue("nombre");
        rowEmpleados.createCell(1).setCellValue("edad");
        rowEmpleados.createCell(2).setCellValue("Direccion");
        rowEmpleados.createCell(3).setCellValue("Numero de contacto");
        rowEmpleados.createCell(4).setCellValue("Rol");
        rowEmpleados.createCell(5).setCellValue("fecha contratacion");

        try {
            FileOutputStream fileOut = new FileOutputStream("TiendaDA.xls");
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            System.out.println("libro creado con exito");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }


