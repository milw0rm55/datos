import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.io.*;

public class putamierda {

	public static void muestraContenido(String archivo) throws FileNotFoundException, IOException {
		String cadena;
		FileReader f = new FileReader(archivo);
		BufferedReader b = new BufferedReader(f);
		while ((cadena = b.readLine()) != null) {
			System.out.println(cadena);
		}
		b.close();
	}

	public static void whenAppendStringUsingBufferedWritter_thenOldContentShouldExistToo(String nombre, String clase,
			String lvl) throws IOException {

		BufferedWriter writer = new BufferedWriter(new FileWriter("src/hola.txt", true));

		writer.append("\n\n" + "nombre=" + nombre + "\n");
		writer.append("clase=" + clase + "\n");
		writer.append("lvl=" + lvl);

		writer.close();
	}

//	public void Consulta(String query, int columna) {
//		try {
//			Statement stmt = Conexion.createStatement();
//			ResultSet rset = stmt.executeQuery(query);
//			System.out.println("HOST - USER");
//			while (rset.next()) {
//				System.out.print(rset.getString(1));
//				System.out.println(" - " + rset.getString(2));
//			}
//			rset.close();
//			stmt.close();
//		} catch (SQLException s) {
//			s.printStackTrace();
//		}
//	} 

	private String nombre;
	private String clase;
	private String lvl;

	public static void main(String[] args) throws IOException {
		
		Connection conexion;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:8080/acceso_a_datos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			conexion = DriverManager.getConnection(url, "root", "fpi6x540asha");
			if (conexion != null)
				System.out.println("Conexi�n establecida");
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("Select * from user");
//			conexion.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("No he cargado el driver");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Otros errores");
			e.printStackTrace();
		}

		Scanner sc = new Scanner(System.in);
		boolean salir = false;
		int opcion = 0;
		while (!salir) {

			System.out.println("1. Mostrar contenido del fichero");
			System.out.println("2. escribir ccontenido en fichero");
			System.out.println("3. Leer de la base de datos");
			System.out.println("4. Escribir en la base de datos");
			System.out.println("5. Escribir en la base de datos");
			System.out.println("6. Salir");

			System.out.println("Escribe una de las opciones");
			opcion = Integer.parseInt(sc.nextLine());

			switch (opcion) {
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
				System.out.println("leer de la base de datos");
				break;
			case 4:
				System.out.println("");
				break;
			case 5:
				System.out.println("");
				break;
			case 6:
				salir = true;
				break;
			default:
				System.out.println("Solo números entre 1 y 6");
			}
		}
		// muestraContenido("/home/milw0rm/hola.txt");

	}

}