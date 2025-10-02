import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase principal para ejecutar la simulación de un evento con usuarios registrados.
 * Lee usuarios desde un archivo, los ordena, los agrega al evento y muestra rechazados.
 */
public class MainFilaVirtual {

    // Constante que define la capacidad del evento
    public static final int CAPACIDAD_EVENTO = 5;

    /**
     * Cuenta cuántas líneas tiene el archivo de entrada.
     * Sirve para dimensionar el arreglo de usuarios.
     *
     * @param rutaArchivo ruta del archivo .txt
     * @return número de líneas en el archivo
     */
    public static int contarUsuarios(String rutaArchivo) {
        int contador = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            while (br.readLine() != null) {
                contador++;
            }
        } catch (IOException e) {
            System.out.println("Error leyendo archivo: " + e.getMessage());
        }
        return contador;
    }

    /**
     * Carga usuarios desde un archivo con formato nombre_nivel_numeroLlegada.
     *
     * @param rutaArchivo  ruta al archivo de entrada
     * @param maxUsuarios  número máximo de usuarios a cargar
     * @return arreglo de usuarios cargados
     */
    public static Usuario[] cargarUsuariosDesdeArchivo(String rutaArchivo, int maxUsuarios) {
        Usuario[] usuarios  = new Usuario[maxUsuarios];
        int cont = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("_");
                //Usuario.Nivel nivel = Usuario.Nivel.valueOf(partes[1].toUpperCase());
                usuarios[cont] = new Usuario(partes[0], partes[1].toUpperCase(), Integer.parseInt(partes[2]));
                cont++;
            }
        } catch (IOException e) {
            System.out.println("Error leyendo archivo: " + e.getMessage());
        }

        return usuarios;
    }

    public static void main(String[] args) {
        String rutaArchivo = "usuarios.txt"; // Ruta al archivo
        int totalUsuarios = contarUsuarios(rutaArchivo);

        // 1. Crear evento con cupo limitado
        Evento evento = new Evento(CAPACIDAD_EVENTO);
        // 2. Cargar usuarios
        Usuario[] usuarios = cargarUsuariosDesdeArchivo(rutaArchivo, totalUsuarios);
        // 3. RESUELVE
        OrdenamientosCuadraticos.ordenar(1, usuarios);
        for (int i = 0; i < usuarios.length; i++) {
            evento.agregarUsuario(usuarios[i]);
        }

        OrdenamientosCuadraticos.imprimeArreglo(evento.getUsuariosAceptados());
    }
}
