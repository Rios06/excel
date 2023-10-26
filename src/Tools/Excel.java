package Tools;

import Animales.Animal;
import Usuarios.Adoptante;
import Usuarios.Empleados;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.CellType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

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

        rowAnimales.createCell(0).setCellValue("ID");
        rowAnimales.createCell(1).setCellValue("Raza");
        rowAnimales.createCell(2).setCellValue("Especie");
        rowAnimales.createCell(3).setCellValue("Nombre");
        rowAnimales.createCell(4).setCellValue("edad");
        rowAnimales.createCell(5).setCellValue("estado de salud");
        rowAnimales.createCell(5).setCellValue("Descripcion");


        Sheet sheetAdoptantes = workbook.createSheet("Adoptantes");
        Row rowAdoptantes = sheetAdoptantes.createRow(sheetAdoptantes.getLastRowNum() + 1);

        rowAdoptantes.createCell(0).setCellValue("ID");
        rowAdoptantes.createCell(1).setCellValue("nombre");
        rowAdoptantes.createCell(2).setCellValue("contraseña");
        rowAdoptantes.createCell(3).setCellValue("edad");
        rowAdoptantes.createCell(4).setCellValue("direccion");
        rowAdoptantes.createCell(5).setCellValue("numero contacto");

        Sheet sheetEmpleados = workbook.createSheet("Empleados");
        Row rowEmpleados = sheetEmpleados.createRow(sheetEmpleados.getLastRowNum() + 1);

        rowEmpleados.createCell(0).setCellValue("ID");
        rowEmpleados.createCell(1).setCellValue("nombre");
        rowEmpleados.createCell(2).setCellValue("edad");
        rowEmpleados.createCell(3).setCellValue("Direccion");
        rowEmpleados.createCell(4).setCellValue("Numero de contacto");
        rowEmpleados.createCell(5).setCellValue("Rol");
        rowEmpleados.createCell(6).setCellValue("fecha contratacion");

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

    public static void cargarAdoptanteDesdeExcel(List<Adoptante> adoptantes) {
        try {
            FileInputStream fileIn = new FileInputStream("TiendaDA.xls");
            Workbook workbook = WorkbookFactory.create(fileIn);
            Sheet sheet = workbook.getSheet("Adoptantes");

            for (Row row : sheet) {
                if (row.getCell(0) != null && row.getCell(1) != null && row.getCell(2) != null && row.getCell(3) != null && row.getCell(4) != null && row.getCell(5) != null) {
                    int id = (int) row.getCell(0).getNumericCellValue();
                    String nombreUsuario = row.getCell(1).getStringCellValue();
                    String Contrasena = row.getCell(2).getStringCellValue();
                    int edad = (int) row.getCell(3).getNumericCellValue();
                    String direccion = row.getCell(4).getStringCellValue();
                    long numeroContacto = (long) row.getCell(5).getNumericCellValue();

                    Adoptante adoptante = new Adoptante(id, nombreUsuario, Contrasena, edad, direccion, numeroContacto);
                    adoptantes.add(adoptante);
                }
            }

            fileIn.close();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cargarEmpleadosDesdeExcel(List<Empleados> empleados) {
        try {
            FileInputStream fileIn = new FileInputStream("TiendaDA.xls");
            Workbook workbook = WorkbookFactory.create(fileIn);
            Sheet sheet = workbook.getSheet("Empleados");

            for (Row row : sheet) {
                if (row.getCell(0) != null && row.getCell(1) != null && row.getCell(2) != null && row.getCell(3) != null && row.getCell(4) != null && row.getCell(5) != null) {
                    int id = (int) row.getCell(6).getNumericCellValue();
                    String nombre = row.getCell(0).getStringCellValue();
                    int edad = (int) row.getCell(1).getNumericCellValue();
                    String direccion = row.getCell(2).getStringCellValue();
                    long numeroContacto = (long) row.getCell(3).getNumericCellValue();
                    String rol = row.getCell(4).getStringCellValue();
                    String fechaContratacion = row.getCell(5).getStringCellValue();


                    Empleados empleado = new Empleados(id, nombre, edad, direccion, numeroContacto, rol, fechaContratacion);
                    empleados.add(empleado);
                }
            }

                fileIn.close();
                workbook.close();
            } catch(IOException e){
                e.printStackTrace();
            }
        }


    public static void editarEmpleados(Scanner scanner, List<Empleados> empleados) {
        System.out.println("Editar empleado:");
        System.out.print("Ingrese el nombre del empleado que desea editar: ");
        String nombreEmpleado = scanner.nextLine();

        for (Empleados empleado : empleados) {
            if (empleado.getNombre().equals(nombreEmpleado)) {
                System.out.print("Edad (" + empleado.getEdad() + "): ");
                int edad = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Dirección (" + empleado.getDireccion() + "): ");
                String direccion = scanner.nextLine();

                System.out.print("Número de contacto (" + empleado.getNumeroContacto() + "): ");
                long numeroContacto = Long.parseLong(scanner.nextLine());

                System.out.print("Rol (" + empleado.getRol() + "): ");
                String rol = scanner.nextLine();

                System.out.print("Fecha de contratación (" + empleado.getFechaContratacion() + "): ");
                String fechaContratacion = scanner.nextLine();

                empleado.setEdad(edad);
                empleado.setDireccion(direccion);
                empleado.setNumeroContacto(numeroContacto);
                empleado.setRol(rol);
                empleado.setFechaContratacion(fechaContratacion);

                guardarEmpleadosEnExcel(empleados);
                System.out.println("Empleado " + nombreEmpleado + " actualizado con éxito.");
                return;
            }
        }
        System.out.println("No se encontró ningún empleado con el nombre proporcionado.");
    }

    public static void eliminarEmpleados(Scanner scanner, List<Empleados> empleados) {
        System.out.println("Eliminar empleado:");
        System.out.println("Lista de empleados: ");
        for (Empleados empleado : empleados) {
            System.out.println("Nombre: " + empleado.getNombre());
        }
        System.out.print("Ingrese el nombre del empleado que desea eliminar: ");
        String nombreEmpleado = scanner.nextLine();

        for (int i = 0; i < empleados.size(); i++) {
            Empleados empleado = empleados.get(i);
            if (empleado.getNombre().equals(nombreEmpleado)) {
                empleados.remove(i);
                guardarEmpleadosEnExcel(empleados);
                System.out.println("Empleado " + nombreEmpleado + " eliminado con éxito.");
                return;
            }
        }
        System.out.println("No se encontró ningún empleado con el nombre proporcionado.");
    }

    private static void guardarEmpleadosEnExcel(List<Empleados> empleados) {
        try {
            File file = new File("TiendaDA.xls");
            Workbook workbook;
            if (file.exists()) {
                FileInputStream fileIn = new FileInputStream(file);
                workbook = WorkbookFactory.create(fileIn);
                fileIn.close();
            } else {
                workbook = new HSSFWorkbook();
            }

            Sheet sheet = workbook.getSheet("Empleados");
            if (sheet == null) {
                sheet = workbook.createSheet("Empleados");
            } else {
                workbook.removeSheetAt(workbook.getSheetIndex(sheet));
                sheet = workbook.createSheet("Empleados");
            }

            for (int i = 0; i < empleados.size(); i++) {
                Empleados empleado = empleados.get(i);
                Row row = sheet.createRow(i);

                row.createCell(0).setCellValue(empleado.getId());
                row.createCell(1).setCellValue(empleado.getNombre());
                row.createCell(2).setCellValue(empleado.getEdad());
                row.createCell(3).setCellValue(empleado.getDireccion());
                row.createCell(4).setCellValue(empleado.getNumeroContacto());
                row.createCell(5).setCellValue(empleado.getRol());
                row.createCell(6).setCellValue(empleado.getFechaContratacion());
            }

            FileOutputStream fileOut = new FileOutputStream("TiendaDA.xls");
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            System.out.println("Datos guardados en Excel");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void eliminarAnimalDisponible(Scanner scanner, List<Animal>animalesDisponibles){
        System.out.println("Eliminar animal disponible:");
        System.out.println("Lista de animales disponibles: ");
        for (Animal animal : animalesDisponibles) {
            System.out.println("ID: " + animal.getId() + ", Nombre: " + animal.getNombre());
        }
        System.out.print("Ingrese el ID del animal que desea eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < animalesDisponibles.size(); i++) {
            Animal animal = animalesDisponibles.get(i);
            if (animal.getId() == id) {
                animalesDisponibles.remove(i);
                guardarAnimalesEnExcel(animalesDisponibles);
                System.out.println("Animal con ID " + id + " eliminado con éxito.");
                return;
            }
        }
        System.out.println("No se encontró ningún animal con el ID proporcionado.");
    }


    private static void guardarAnimalesEnExcel(List<Animal> animalesDisponibles) {
        try {
            File file = new File("TiendaDA.xls");
            Workbook workbook;
            if (file.exists()) {
                FileInputStream fileIn = new FileInputStream(file);
                workbook = WorkbookFactory.create(fileIn);
                fileIn.close();
            } else {
                workbook = new HSSFWorkbook();
            }

            Sheet sheet = workbook.getSheet("Animales");
            if (sheet == null) {
                sheet = workbook.createSheet("Animales");
            } else {
                workbook.removeSheetAt(workbook.getSheetIndex(sheet));
                sheet = workbook.createSheet("Animales");
            }

            for (int i = 0; i < animalesDisponibles.size(); i++) {
                Animal animal = animalesDisponibles.get(i);
                Row row = sheet.createRow(i);
                row.createCell(0).setCellValue(animal.getId());
                row.createCell(1).setCellValue(animal.getRaza());
                row.createCell(2).setCellValue(animal.getEspecie());
                row.createCell(3).setCellValue(animal.getNombre());
                row.createCell(4).setCellValue(animal.getEdad());
                row.createCell(5).setCellValue(animal.getEstadoDeSalud());
                row.createCell(6).setCellValue(animal.getDescripcion());
            }

            FileOutputStream fileOut = new FileOutputStream("TiendaDA.xls");
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            System.out.println("Datos guardados en Excel");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void editarAnimalDisponible(Scanner scanner, List<Animal> animalesDisponibles) {
        System.out.println("Editar animal disponible:");
        System.out.println("Lista de animales disponibles: ");
        for (Animal animal : animalesDisponibles) {
            System.out.println("ID: " + animal.getId() + ", Nombre: " + animal.getNombre());
        }
        System.out.print("Ingrese el ID del animal que desea editar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Animal animal : animalesDisponibles) {
            if (animal.getId() == id) {
                System.out.print("Raza (" + animal.getRaza() + "): ");
                String raza = scanner.nextLine();

                System.out.print("Especie (" + animal.getEspecie() + "): ");
                String especie = scanner.nextLine();

                System.out.print("Nombre (" + animal.getNombre() + "): ");
                String nombre = scanner.nextLine();

                System.out.print("Edad (" + animal.getEdad() + "): ");
                int edad = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Estado de salud (" + animal.getEstadoDeSalud() + "): ");
                String estadoDeSalud = scanner.nextLine();

                System.out.print("Descripción (" + animal.getDescripcion() + "): ");
                String descripcion = scanner.nextLine();

                animal.setRaza(raza);
                animal.setEspecie(especie);
                animal.setNombre(nombre);
                animal.setEdad(edad);
                animal.setEstadoDeSalud(estadoDeSalud);
                animal.setDescripcion(descripcion);

                guardarAnimalesEnExcel(animalesDisponibles);
                System.out.println("Animal con ID " + id + " actualizado con éxito.");
                return;
            }
        }
        System.out.println("No se encontró ningún animal con el ID proporcionado.");
    }


    public static void cargarAnimalesDesdeExcel(List<Animal> animalesDisponibles) {
        try {
            FileInputStream fileIn = new FileInputStream("TiendaDA.xls");
            Workbook workbook = WorkbookFactory.create(fileIn);
            Sheet sheet = workbook.getSheet("Animales");

            for (Row row : sheet) {
                int id = (int) row.getCell(0).getNumericCellValue();
                String raza = row.getCell(1).getStringCellValue();
                String especie = row.getCell(2).getStringCellValue();
                String nombre = row.getCell(3).getStringCellValue();
                int edad = (int) row.getCell(4).getNumericCellValue();
                String estadoDeSalud = row.getCell(5).getStringCellValue();
                String descripcion = row.getCell(6).getStringCellValue();

                Animal animal = new Animal(id, raza, especie, nombre, edad, estadoDeSalud, descripcion);
                animalesDisponibles.add(animal);
            }

            fileIn.close();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }


