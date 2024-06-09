package sistemabalanza;

import java.time.LocalDateTime;
import java.util.Scanner;
import logica.Categoria_prod;
import logica.Empresa;
import logica.Producto;
import logica.Ticket_pesaje;

public class SistemaBalanza {

    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);

        boolean seguir = true; 

        while (seguir) {
            System.out.println("______________________________________________");
            System.out.println("MENU PRINCIPAL - Sistema de Balanza");
            System.out.println("______________________________________________");
            System.out.println("1. Agregar Empresa");
            System.out.println("2. Agregar Producto");
            System.out.println("3. Agregar Categoría de Producto");
            System.out.println("4. Agregar Ticket de Pesaje Camión Vacío");
            System.out.println("5. Agregar Ticket de Pesaje Camión Cargado");
            System.out.println("6. Salir");
            System.out.println("______________________________________________");
            System.out.print("Elige una opción: ");
            
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Código de Empresa: ");
                    int codigo_emp = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Razón Social: ");
                    String razon_social = scanner.nextLine(); 
                    System.out.print("Domicilio: ");
                    String domicilio = scanner.nextLine(); 
                    System.out.print("CUIT: ");
                    String cuit = scanner.nextLine(); 
                    System.out.print("Teléfono: ");
                    String tel = scanner.nextLine(); 
                    System.out.print("Mail: ");
                    String mail = scanner.nextLine(); 
                    System.out.print("Página Web: ");
                    String web = scanner.nextLine(); 
                    System.out.print("Ciudad: ");
                    String cdad = scanner.nextLine(); 
                    System.out.print("Provincia: ");
                    String pcia = scanner.nextLine(); 
                                    
                    Empresa emp = new Empresa(codigo_emp,razon_social,domicilio,cuit,tel,mail,web,cdad,pcia);
                    
                    System.out.println("La empresa fue agregada con éxito");                  
                  
                }

                case 2 -> {
                    System.out.print("Código de Producto: ");
                    int codigo_prod = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Descripción: ");
                    String descrip = scanner.nextLine();
                    System.out.print("Código de Categoría: ");
                    int codigo_cat = scanner.nextInt();
                    Producto prod = new Producto(codigo_prod,descrip,codigo_cat);
                                        
                    System.out.println("El producto fue agregado con éxito");                    
                                       
                }
                case 3 -> {
                    
                    System.out.print("Código de Categoría: ");
                    int codigo_cat = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Descripción: ");
                    String descrip_cat = scanner.nextLine();
                                        
                    Categoria_prod cat = new Categoria_prod(codigo_cat,descrip_cat);
                                        
                    System.out.println("La Categoría fue agregada con éxito");                 
                   
                }
                case 4 -> {
                 
                    System.out.print("Código de Ticket de Pesaje: ");
                    int codigo_ticket = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Código de Balanza: ");
                    int codigo_bal = scanner.nextInt(); 
                    System.out.print("Patente de Camión: ");
                    String patente_c = scanner.nextLine(); 
                    scanner.nextLine();
                    System.out.print("Peso Camión Vacío: ");
                    double peso_v = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Observaciones: ");
                    String obs = scanner.nextLine(); 
                 
                    LocalDateTime fecha = LocalDateTime.now();
                
                    Ticket_pesaje ticket = new Ticket_pesaje(codigo_ticket,codigo_bal,0,0,fecha,patente_c,"",peso_v,0.00,obs);
 
                    System.out.println("El ticket de pesaje del camión vacío fue agregado con éxito");                 
                    
                }
                
                case 5 -> {
                 
                    System.out.print("Código de Ticket de Pesaje: ");
                    int codigo_ticket = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Código de Balanza: ");
                    int codigo_bal = scanner.nextInt(); 
                    System.out.print("Patente de Acoplado: ");
                    String patente_a = scanner.nextLine(); 
                    scanner.nextLine();                    
                    System.out.print("Código de Empresa: ");
                    int codigo_emp = scanner.nextInt();
                    scanner.nextLine();                    
                    System.out.print("Código de Producto: ");
                    int codigo_prod = scanner.nextInt();
                    scanner.nextLine();                    
                    System.out.print("Peso Camión Cargado: ");
                    double peso_ll = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Observaciones: ");
                    String obs = scanner.nextLine(); 
                 
                    LocalDateTime fecha = LocalDateTime.now();
                
                    Ticket_pesaje ticket = new Ticket_pesaje(codigo_ticket,codigo_bal,codigo_prod,codigo_emp,fecha,"",patente_a,0.00,peso_ll,obs);
 
                    System.out.println("El ticket de pesaje del camión cargado fue agregado con éxito");                 
                    
                }
                
                case 6 -> {
                 
                    System.out.print("Programa Finalizado");
                    seguir = false;
                }
                               
               default -> System.out.println("Opción no válida, vuelva a intentar");
            }
        }
                
    }
    
}
