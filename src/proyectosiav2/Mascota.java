//CLASE MASCTOA REVISADA 26-08
package proyectosiav2;

import java.util.ArrayList;

public class Mascota {
    private String nombre;
    private String tipo;
    private String raza;
    private int edad;
    private ArrayList<Servicio> servicios = new ArrayList<>();

//============================ CONSTRUCTORES ===================================
    public Mascota(){
    }
    
    public Mascota(String nombre, String tipo, String raza, int edad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.raza = raza;
        this.edad = edad;
    }

//=========================== GETTER Y SETTER ==================================
    public String getNombre() {
        return nombre; 
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre; 
    }
    
    public String getTipo() {
        return tipo; 
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo; 
    }
    
    public String getRaza() {
        return raza; 
    }
    
    public void setRaza(String raza) {
        this.raza = raza; 
    }
    
    public int getEdad() {
        return edad; 
    }
    
    public void setEdad(int edad) {
        this.edad = edad; 
    }

    public ArrayList<Servicio> getServicios() {
        return servicios; 
    }
    
//================================ METODOS =====================================   
    public void agregarServicio(Servicio servicio) {
        servicios.add(servicio); 
    }
    
    public void agregarServicio(String tipoServicio, String fechaHora, String descripcion, int precio, String estado){
        servicios.add(new Servicio(tipoServicio, fechaHora, descripcion, precio, estado));
    }

    public Servicio buscarServicioPorTipo(String tipo) {
        for (Servicio servicio : servicios) {
            if (servicio.getTipoServicio().equalsIgnoreCase(tipo)){ 
                return servicio;
            }
        }
        return null;
    }
}