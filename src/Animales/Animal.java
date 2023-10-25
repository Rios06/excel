package Animales;
import Usuarios.Adopcion;
import Usuarios.Empleados;
import Usuarios.Administrador;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import Tools.Menu;
import Tools.Excel;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.FileOutputStream;

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



    public static void mostrarAnimalesDisponibles(List<Animal>animalesDisponibles) {
        System.out.println("Animales disponibles:");
        for (Animal animal : animalesDisponibles) {
            animal.mostrarAnimalDisponible();


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
        System.out.println("Animales.Animal registrado con éxito.");
    }

}
