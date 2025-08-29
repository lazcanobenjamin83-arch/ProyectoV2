package proyectosiav2;
import java.io.*;

public class ProyectoSIAv2 {
    
    public static void main(String[] args) throws IOException {
        Veterinaria veterinaria = new Veterinaria();
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        // Cargar datos iniciales
        veterinaria.cargarDatosIniciales();
        
        int opcion = 0;
        do {
            System.out.println("===== MENU GESTION DE MASCOTAS =====");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Agregar mascota a cliente");
            System.out.println("3. Agregar servicio a mascota");
            System.out.println("4. Listar clientes y mascotas");
            System.out.println("0. Salir");
            System.out.print("Ingrese opcion: ");
            try {
                opcion = Integer.parseInt(lector.readLine());
            } catch (Exception e) {
                opcion = -1;
            }

            switch(opcion) {
                //AGREGAR CLIENTE
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = lector.readLine();
                    System.out.print("RUT: ");
                    String rut = lector.readLine();
                    System.out.print("Teléfono: ");
                    String telefono = lector.readLine();
                    System.out.print("Direccion: ");
                    String direccion = lector.readLine();
                    
                    // Usando sobrecarga de método de Clinica
                    if(veterinaria.agregarCliente(nombre, rut, telefono, direccion)){
                        System.out.println("Cliente agregado.");
                    }
                    break;
                    
                //AGREGAR MASCOTA
                case 2:
                    System.out.print("RUT del dueno: ");
                    rut = lector.readLine();
                    Cliente dueno = veterinaria.buscarClientePorRut(rut);
                    if (dueno != null) {
                        System.out.print("Nombre mascota: ");
                        String nombreM = lector.readLine();
                        System.out.print("Tipo: ");
                        String tipo = lector.readLine();
                        System.out.print("Raza: ");
                        String raza = lector.readLine();
                        System.out.print("Edad: ");
                        int edad = Integer.parseInt(lector.readLine());
                        
                        // Usando sobrecarga de método de Cliente
                        dueno.agregarMascota(nombreM, tipo, raza, edad);
                        System.out.println("Mascota agregada.");
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;
                    
                //AGREGAR SERVICIO
                case 3:
                    System.out.print("RUT del dueno: ");
                    rut = lector.readLine();
                    dueno = veterinaria.buscarClientePorRut(rut);
                    if (dueno != null) {
                        System.out.print("Nombre de la mascota: ");
                        String nombreM = lector.readLine();
                        Mascota encontrada = dueno.buscarMascotaPorNombre(nombreM);
                        if (encontrada != null) {
                            System.out.print("Tipo de servicio: ");
                            String tipoServ = lector.readLine();
                            System.out.print("Fecha-hora: ");
                            String fecha = lector.readLine();
                            System.out.print("Descripcion: ");
                            String desc = lector.readLine();
                            System.out.print("Precio: ");
                            int precio = Integer.parseInt(lector.readLine());
                            System.out.print("Estado: ");
                            String estado = lector.readLine();
                            
                            // Usando sobrecarga de método de Mascota
                            encontrada.agregarServicio(tipoServ, fecha, desc, precio, estado);
                            System.out.println("Servicio agregado.");
                        } else {
                            System.out.println("Mascota no encontrada.");
                        }
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;
                    
                //LISTAR CLIENTES Y MASCOTAS
                case 4:
                    veterinaria.mostrarClientesMascotas();
                    break;
                //PARA LOS CASOS DEFAULT Y SALIDA
                case 0:
                    System.out.println("Hasta pronto");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
            System.out.println();
        } while (opcion != 0);
        
        lector.close();
    }
}