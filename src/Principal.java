import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.rowset.spi.SyncFactoryException;

public class Principal {


	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Declarar nuestras variables
		String matricula,nombre,genero,buscarPalabra,nombreAlumno,nombreGenero;

		long numcel;
		
		Scanner lectura = null;
		Alumnos alumno;
		
		List<Alumnos> registro = new ArrayList<Alumnos>();
		List<Alumnos> registroMostar = null;
		
		
		int menuPrincipal, subMenu, indice;
		
		do {
			System.out.println("Bienvenido al sistema");
			System.out.println("1--Alta");
			System.out.println("2-- Mostrar");
			System.out.println("3-- Buscar");
			System.out.println("4-- Editar"); // submenu: nombre y num cel
			System.out.println("5-- Eliminar");
			System.out.println("6-- Buscar por nombre");
			System.out.println("7-- Buscar por genero");
			System.out.println("8-- Eliminar alumnos buscando por nombre");
			System.out.println("9-- Salir");
			
			
			lectura = new Scanner(System.in);
			menuPrincipal = lectura.nextInt();
			
			switch (menuPrincipal) {
			case 1:
				try {
					System.out.println("Ingresa la matricula");
					lectura = new Scanner(System.in);
					matricula = lectura.nextLine();
					
					System.out.println("Ingresa el nombre");
					lectura = new Scanner(System.in);
					nombre = lectura.nextLine();
					
					System.out.println("Ingresa el numero de celular");
					lectura = new Scanner(System.in);
					numcel= lectura.nextLong();
					
					System.out.println("Ingresa el genero");
					lectura = new Scanner(System.in);
					genero = lectura.nextLine();
					
					alumno = new Alumnos(matricula,nombre,numcel,genero);
					registro.add(alumno);
					
					System.out.println("Se agrego el alumno");
				} catch (Exception e) {
					System.out.println("Error al guardar " + e.getMessage());
					System.out.println("\nPresiona ENTER para continuar...");
					lectura = new Scanner(System.in);
					lectura.nextLine();
				
				}
				break;

			case 2:
			    if(registro.size()==0) {
			    	System.out.println("No hay alumnos regisrados");
				    System.out.println("\nPresiona ENTER para continuar...");
				    lectura = new Scanner(System.in); // Asegura que esté limpio el buffer
				    lectura.nextLine(); // Espera a que el usuario presione Enter
			    }
			    else {
					System.out.println(registro);
				    System.out.println("\nPresiona ENTER para continuar...");
				    lectura = new Scanner(System.in); // Asegura que esté limpio el buffer
				    lectura.nextLine(); // Espera a que el usuario presione Enter			    	
			    }
			    break;
			case 3:
				try {
					if(registro.size()>0) {
					System.out.println("Ingrese el indice del registro que desea buscar");
					lectura = new Scanner(System.in);
					indice = lectura.nextInt();
					
					//buscar
					alumno = registro.get(indice);
					System.out.println("Se ecnontro el registro: "+ alumno);
					System.out.println("\nPresiona ENTER para continuar...");
					lectura = new Scanner(System.in);
					lectura.nextLine();
					
					}
					else {
						System.out.println("No hay registros");
						System.out.println("\nPresiona ENTER para continuar...");
						lectura = new Scanner(System.in);
						lectura.nextLine();
							
					}
					
				} catch (Exception e) {
					System.out.println("Valor no valido + " + e.getMessage());
					System.out.println("\nPresiona ENTER para continuar...");
					lectura = new Scanner(System.in);
					lectura.nextLine();
					// TODO: handle exception
				}
				break;
			case 4:
				try {
					if(registro.size()>0) {
						System.out.println("Ingrese el indice de registro para editar");
						lectura = new Scanner(System.in);
						indice = lectura.nextInt();
						
						//buscar
						alumno = registro.get(indice);
						System.out.println("Se enctro el alumno "+ alumno.getNombre());
						do {
							System.out.println("SUBMENU PARA EDITAR");
							System.out.println("1--Nombre");
							System.out.println("2--NUM. Celular");
							System.out.println("3--Regresar");
							lectura = new Scanner(System.in);
							subMenu = lectura.nextInt();
							
							switch (subMenu) {
							case 1:
								System.out.println("Ingrese el nuevo nombre:");
								lectura = new Scanner(System.in);
								nombre = lectura.nextLine();
								alumno.setNombre(nombre);
								System.out.println("Se realizo el cambio");
								System.out.println("\nPresiona ENTER para continuar...");
								lectura = new Scanner(System.in);
								lectura.nextLine();
								break;
							case 2:
								try {
								System.out.println("Ingrese el nuevo numero de celular:");
								lectura = new Scanner(System.in);
								numcel = lectura.nextLong();
								alumno.setNumcel(numcel);		
								System.out.println("Se realizo el cambio");
								System.out.println("\nPresiona ENTER para continuar...");
								lectura = new Scanner(System.in);
								lectura.nextLine();
							
								} catch (Exception e) {
									// TODO: handle exception
									System.out.println("Valor no valido + " + e.getMessage());
									System.out.println("\nPresiona ENTER para continuar...");
									lectura = new Scanner(System.in);
									lectura.nextLine();
									// TODO: handle exception
								}

								break;
							case 3:
								break;
							}
							
							}while(subMenu>3);
					}
					else {
						System.out.println("No hay registro");
						System.out.println("\nPresiona ENTER para continuar...");
						lectura = new Scanner(System.in);
						lectura.nextLine();
						
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Valor no valido + " + e.getMessage());
					System.out.println("\nPresiona ENTER para continuar...");
					lectura = new Scanner(System.in);
					lectura.nextLine();
				}
				break;
			case 5:
				try {
					if(registro.size()>0) {
					System.out.println("Ingrese el el indice que se desea eliminar");
					lectura = new Scanner(System.in);
					indice = lectura.nextInt();
					
					//eliminar
					registro.remove(indice);
					System.out.println("Se elimino el registro " + indice);
					System.out.println("\nPresiona ENTER para continuar...");
					lectura = new Scanner(System.in);
					lectura.nextLine();
					}
					else {
					System.out.println("No hay registro");
					System.out.println("\nPresiona ENTER para continuar...");
					lectura = new Scanner(System.in);
					lectura.nextLine();
					}
					
				} catch (Exception e) {
					System.out.println("Valor no valido + " + e.getMessage());
					System.out.println("\nPresiona ENTER para continuar...");
					lectura = new Scanner(System.in);
					lectura.nextLine();
				}
				break;
			case 6:
					try {
					System.out.println("Ingrese el nombre que desea buscar");
					lectura = new Scanner(System.in);
					buscarPalabra = lectura.nextLine();
					registroMostar = new ArrayList<Alumnos>();
					for(int i=0;i<registro.size();i++){
						nombreAlumno = registro.get(i).getNombre();
						if (nombreAlumno.equals(buscarPalabra)){
			                registroMostar.add(registro.get(i));
			            }
					}
					if (registroMostar.size()<1) {
			          System.out.println("No se encontraron coincidencias.");
			          System.out.println("\nPresiona ENTER para continuar...");
						lectura = new Scanner(System.in);
						lectura.nextLine();
					
			        } else {
			                System.out.println("Coincidencias encontradas:");
			                    System.out.println(registroMostar);
			                    System.out.println("\nPresiona ENTER para continuar...");
								lectura = new Scanner(System.in);
								lectura.nextLine();
							
			        }

					
					}catch (Exception e) {
						lectura.nextLine();
					
				}
				break;
			case 7:
				try {
				System.out.println("Ingrese el genero que desea buscar");
				lectura = new Scanner(System.in);
				buscarPalabra = lectura.nextLine();
				registroMostar = new ArrayList<Alumnos>();
				for(int i=0;i<registro.size();i++){
					nombreGenero = registro.get(i).getGenero();
					if (nombreGenero.equals(buscarPalabra)){
		                registroMostar.add(registro.get(i));
		            }
				}
				if (registroMostar.size()<1) {
		          System.out.println("No se encontraron coincidencias.");
		          System.out.println("\nPresiona ENTER para continuar...");
					lectura = new Scanner(System.in);
					lectura.nextLine();
				
		        } else {
		                System.out.println("Coincidencias encontradas:");
		                    System.out.println(registroMostar);
		                    System.out.println("\nPresiona ENTER para continuar...");
							lectura = new Scanner(System.in);
							lectura.nextLine();
						
		        }

				
			} catch (Exception e) {
				   System.out.println("Error al buscar el nombre.");
			}
				break;
			case 8:
				try {
					System.out.println("Ingrese el nombre que desea buscar");
					lectura = new Scanner(System.in);
					buscarPalabra = lectura.nextLine();
					registroMostar = new ArrayList<Alumnos>();
					for(int i=0;i<registro.size();i++){
						nombreAlumno = registro.get(i).getNombre();
						if (nombreAlumno.equals(buscarPalabra)){
			                registroMostar.add(registro.get(i));
			                registro.remove(i);      
			            }
					}
					if (registroMostar.size()<1) {
			          System.out.println("No se encontraron coincidencias.");
			          System.out.println("\nPresiona ENTER para continuar...");
						lectura = new Scanner(System.in);
						lectura.nextLine();
					
			        } else {
			                System.out.println("Se eliminaron los alumnos:");
			                    System.out.println(registroMostar);
			                    System.out.println("\nPresiona ENTER para continuar...");
								lectura = new Scanner(System.in);
								lectura.nextLine();
			        }

					
					}catch (Exception e) {
					   System.out.println("Error al buscar el nombre.");
				}
				break;
			}
			//Agregando la condicional que trabaja con valores booleanos
		}while(menuPrincipal < 9 || menuPrincipal > 9);
	}

}
