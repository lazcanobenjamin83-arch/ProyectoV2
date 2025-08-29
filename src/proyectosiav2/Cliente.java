//CLASE CLIENTE REVISADA 26-08
package proyectosiav2;
import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private String rut;
    private String telefono;
    private String direccion;
    private ArrayList<Mascota> mascotas = new ArrayList<>();
    
//============================ CONSTRUCTORES ===================================
    public Cliente(){      
    } 
    
    public Cliente(String nombre, String rut, String telefono, String direccion) {
        this.nombre = nombre;
        this.rut = rut;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    
//=========================== GETTER Y SETTER ==================================
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    } 
    
    public String getRut() {
        return rut;
    }
    
    public void setRut(String rut) {
        this.rut = rut;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono; 
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }
    
//================================ METODOS =====================================
    public void agregarMascota(Mascota mascota) {
        mascotas.add(mascota); 
    }
    
    public void agregarMascota(String nombre, String tipo, String raza, int edad) {
        mascotas.add(new Mascota(nombre, tipo, raza, edad));
    }
    
    public Mascota buscarMascotaPorNombre(String nombre) {
        for (Mascota mascota : mascotas) {
            if (mascota.getNombre().equalsIgnoreCase(nombre)){
                return mascota;
            }
        }
        return null;
    }
    
}