package Animales;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
public class Animal {
    private String raza;
    private String especie;
    private String nombre;
    private int edad;
    private String estadoDeSalud;
    private String descripcion;
    private int id;
    private static int idCounter = 1;
    public Animal(int id,String raza, String especie, String nombre, int edad, String estadoDeSalud, String descripcion) {
        this.id = id;
        this.raza = raza;
        this.especie = especie;
        this.nombre = nombre;
        this.edad = edad;
        this.estadoDeSalud = estadoDeSalud;
        this.descripcion = descripcion;
        idCounter++;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEstadoDeSalud() {
        return estadoDeSalud;
    }

    public void setEstadoDeSalud(String estadoDeSalud) {
        this.estadoDeSalud = estadoDeSalud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void mostrarAnimalDisponible() {
        System.out.println("ANIMAL DISPONIBLE " + getNombre() + ", Raza " + getRaza() + ", Edad " + getEdad() + ", Estado de salud " + getEstadoDeSalud() + ", Descripción " + getDescripcion());
    }

    public static void mostrarAnimalesDisponibles(List<Animal> animalesDisponibles) {
        System.out.println("Animales disponibles:");
        for (Animal animal : animalesDisponibles) {
            animal.mostrarAnimalDisponible();
        }
    }

    public static void registrarAnimalDisponible(Scanner scanner, List<Animal> animalesDisponibles) {
        System.out.println("Registrar un animal disponible:");

        int id = idCounter;
        idCounter++;

        System.out.print("Raza: ");
        String raza = scanner.nextLine();

        System.out.print("Especie: ");
        String especie = scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Estado de salud: ");
        String estadoDeSalud = scanner.nextLine();

        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();

        Animal animal = new Animal(id,raza, especie, nombre, edad, estadoDeSalud, descripcion);
        animalesDisponibles.add(animal);


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
            }
            int rowIndex = sheet.getLastRowNum() + 1;

            Row row = sheet.createRow(rowIndex);
            row.createCell(0).setCellValue(animal.getId());
            row.createCell(1).setCellValue(animal.getRaza());
            row.createCell(2).setCellValue(animal.getEspecie());
            row.createCell(3).setCellValue(animal.getNombre());
            row.createCell(4).setCellValue(animal.getEdad());
            row.createCell(5).setCellValue(animal.getEstadoDeSalud());
            row.createCell(6).setCellValue(animal.getDescripcion());

            FileOutputStream fileOut = new FileOutputStream("TiendaDA.xls");
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            System.out.println("Datos guardados en Excel");

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    }


