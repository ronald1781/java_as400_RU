
package configura;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    
      Connection con;
   public Connection getConnection(){
       String url="jdbc:as400://IP/LIBT";
       String user="USUARIO";
       String pass="CLAVE";
       try{
       Class.forName("com.ibm.as400.access.AS400JDBCDriver");
       con=DriverManager.getConnection(url, user, pass);
       }catch(Exception e){
           System.out.println("Error al conectar a BD " + e);
       }
   return con;
   
   }
    public static void escribir()
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
        	fichero = new FileWriter("asest/server1.txt");
           	pw = new PrintWriter(fichero);
 
           	System.out.println("Escribiendo en el archivo.txt");
           	for (int i = 0; i < 10; i++)
        	   pw.println("Linea " + i);
 
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
        	try {
    			// Nuevamente aprovechamos el finally para 
        		// asegurarnos que se cierra el fichero.
        		if (null != fichero)
        			fichero.close();
        	} catch (Exception e2) {
        		e2.printStackTrace();
        	}
        }
    }
 
    public static void leer()
    {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
 
        try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File ("archivo.txt");
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);
 
			// Lectura del fichero
			System.out.println("Leyendo el contendio del archivo.txt");
			String linea;
			while((linea=br.readLine())!=null)
				System.out.println(linea);
        }
        catch(Exception e){
           e.printStackTrace();
        }finally{
                      try{
              if( null != fr ){
                 fr.close();
              }
           }catch (Exception e2){
              e2.printStackTrace();
           }
        }
    } 
}
