import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Gestion {
	
	public static void main(String[] args) {

		ArrayList<Cliente> clients = new ArrayList<Cliente>();
			try {
				
				FileInputStream fis = new FileInputStream("./clientes.txt");
				InputStreamReader isr = new InputStreamReader(fis, "UTF8");
				BufferedReader br = new BufferedReader(isr);

				String linea = br.readLine();
				String [] campos = null;

				while(linea != null) {
					
					Cliente cliente = new Cliente();
					Direccion direccion = new Direccion();
					campos = linea.split("#");
					String distri = campos[0];
					String [] campos2 = distri.split(",");
					cliente.setNombre(campos2[0]);
					cliente.setApellido(campos2[1]);
					cliente.setDni(campos2[2]);
					distri = campos[1];
					campos2 = distri.split(",");
					direccion.setCiudad(campos2[0]);
					int entero = Integer.parseInt(campos2[1]);
					direccion.setCodigoPostal(entero);
					direccion.setCalle(campos2[2]);
					entero = Integer.parseInt(campos2[3]);
					direccion.setNumero(entero);
					cliente.setDireccion(direccion);
					distri = campos[2];
					campos2 = distri.split(",");
					double doble = Double.parseDouble(campos2[0]);
					cliente.setNum_socio(doble);
					doble = Double.parseDouble(campos2[1]);
					cliente.setDto(doble);

					clients.add(cliente);
					linea = br.readLine();
				}

				for (int i=0;i<clients.size() ;i++ ) {
					Direccion direccion = new Direccion();

					System.out.println("\ncliente nº: " + (i + 1));
					System.out.println("<><><><><><><><><><><><><><><><><><><><>");
					System.out.println("\nNombre: " + (clients.get(i).getNombre()));
					System.out.println("\nNombre: " + (clients.get(i).getApellido()));
					System.out.println("\nDni: " + (clients.get(i).getDni()));
					System.out.println("\nnumero de socio: " + (clients.get(i).getNum_socio()));
					System.out.println("\ndescuento: " + (clients.get(i).getDto()));
					direccion = clients.get(i).getDireccion();
					System.out.println("\tCiudad: " + direccion.getCiudad());
					System.out.println("\tCod.postal: " + direccion.getCodigoPostal());
					System.out.println("\tCalle: " + direccion.getCalle());
					System.out.println("\tCalle: " + direccion.getNumero());

				}


			}catch(Exception e) {
					System.out.println(e);
			}

	}
}