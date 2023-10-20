package Animales;
import Usuarios.Adopcion;
import Usuarios.Empleados;
import Usuarios.Administrador;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import Tools.Menu;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Scanner;


public class Animal {
 private boolean disponible;
    private String raza;
    private String especie;
    private String nombre;
    private int edad;
    private String estadoDeSalud;
    private String descripcion;

    public Animal(String raza, String especie, String nombre, int edad, String estadoDeSalud, String descripcion) {
        this.raza = raza;
        this.especie = especie;
        this.nombre = nombre;
        this.edad = edad;
        this.estadoDeSalud = estadoDeSalud;
        this.descripcion = descripcion;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
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

    public void mostrarAnimalDisponible() {
        System.out.println("ANIMAL DISPONIBLE " + getNombre() + ", Raza " + getRaza() + ", Edad " + getEdad() + ", Estado de salud " + getEstadoDeSalud() + ", Descripción " + getDescripcion());
    }

    public static void mostrarAnimalesDisponibles() {
        System.out.println("Animales disponibles:");

    }


    public static void registrarAnimalDisponible(Scanner scanner, List<Animal>animalesDisponibles) {
        System.out.println("Registrar un animal disponible:");
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

        Animal animal = new Animal(raza, especie, nombre, edad, estadoDeSalud, descripcion);
        animalesDisponibles.add(animal);
        guardarAnimalesEnExcel(animalesDisponibles);
        System.out.println("Animales.Animal registrado con éxito.");
    }

    public static void guardarAnimalesEnExcel(List<Animal> animalesDisponibles) {
        try {
            Workbook workbook = new HSSFWorkbook();
            Sheet sheet = workbook.createSheet("Animales Disponibles");

            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Raza");
            headerRow.createCell(1).setCellValue("Especie");
            headerRow.createCell(2).setCellValue("Nombre");
            headerRow.createCell(3).setCellValue("Edad");
            headerRow.createCell(4).setCellValue("Estado de salud");
            headerRow.createCell(4).setCellValue("Descripcion");

            int rowNum = 1;

            for (Animal animal : animalesDisponibles) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(animal.getRaza());
                row.createCell(1).setCellValue(animal.getEspecie());
                row.createCell(2).setCellValue(animal.getNombre());
                row.createCell(3).setCellValue(animal.getEdad());
                row.createCell(4).setCellValue(animal.getEstadoDeSalud());
                row.createCell(5).setCellValue(animal.getDescripcion());
            }
            FileOutputStream outputStream = new FileOutputStream("AnimalesDisponibles.xlsx");
            workbook.write(outputStream);

            System.out.println("Datos guardados correctamente");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
