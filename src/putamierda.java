import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.io.*;
public class putamierda {
	
	private String login = "root";
	private String pwd = "";
	private String url = "jdbc:mysql://localhost:8080/acceso_a_datos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static Connection conexion;
	public  void TestConection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(url, login, pwd);
			// Quitamos esta instrucci�n: conexion.close();
			// System.out.println (" - Conexi�n con MySQL establecida -");
		} catch (Exception e) {
			// System.out.println (" � Error de Conexi�n con MySQL -");
			e.printStackTrace();
		}
	}
    
	public static void muestraContenido(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            System.out.println(cadena);
        }
        b.close();
    }
    public static void whenAppendStringUsingBufferedWritter_thenOldContentShouldExistToo(String nombre, String clase, String lvl) 
  		  throws IOException {
  		    
  		    BufferedWriter writer = new BufferedWriter(new FileWriter("src/hola.txt", true));
  		    
  		    writer.append("\n\n" + "nombre=" + nombre + "\n");
  		    writer.append("clase=" + clase + "\n");
  		    writer.append("lvl=" + lvl);
  		     
  		    writer.close();
  		}
    private String nombre;
    private String clase;
    private String lvl;
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	boolean salir = false;
    	int opcion = 0;
    	 while(!salir){
             
             System.out.println("1. Mostrar contenido del fichero");
             System.out.println("2. escribir ccontenido en fichero");
             System.out.println("3. Opcion 3");
             System.out.println("4. Salir");
              
             System.out.println("Escribe una de las opciones");
             opcion = Integer.parseInt(sc.nextLine());
              
             switch(opcion){
                 case 1:
                		muestraContenido("src/hola.txt");
                     break;
                 case 2:
                	 System.out.println(" ");
                     System.out.print("nombre=");
             		String nombre = sc.nextLine();
                     System.out.print("clase=");
             		String clase = sc.nextLine();
                     System.out.print("lvl=");
             		String lvl = sc.nextLine();
             		whenAppendStringUsingBufferedWritter_thenOldContentShouldExistToo(nombre, clase, lvl);
                     break;
                  case 3:
                     System.out.println("Has seleccionado la opcion 3");
                     break;
                  case 4:
                     salir=true;
                     break;
                  default:
                     System.out.println("Solo números entre 1 y 4");
             }
    	 }
    	//muestraContenido("/home/milw0rm/hola.txt");
       
    }
   
}