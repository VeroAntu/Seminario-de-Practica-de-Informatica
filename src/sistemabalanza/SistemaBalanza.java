package sistemabalanza;

import java.time.LocalDateTime;
import java.util.Scanner;
import logica.Producto;
import logica.Ticket_pesaje;
import persistencia.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import logica.Categoria_prod;
import logica.Empresa;

public class SistemaBalanza {
   
    public static void main(String[] args) throws SQLException {       
        
        Scanner scanner = new Scanner(System.in);
       
        boolean seguir = true; 

        while (seguir) {
            System.out.println("______________________________________________");
            System.out.println("MENU PRINCIPAL - Sistema de Balanza");
            System.out.println("______________________________________________");
            System.out.println("1. Módulo Empresas");
            System.out.println("2. Módulo Productos");
            System.out.println("3. Módulo Categorías de Productos");
            System.out.println("4. Módulo Tickets de Pesajes");
            System.out.println("5. Salir");
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
                    Empresa emp = new Empresa();
                    emp.insertarEmpresa( razon_social, pcia, cuit, tel, mail, web, cdad, pcia);                                        
                    System.out.println("La empresa fue agregada con éxito");   
                   
                }

                case 2 -> {
                    
                   boolean seguir_submenu = true;
                   
                   while (seguir_submenu) {
                   
                    System.out.println("______________________________________________");
                    System.out.println("MENU Productos");
                    System.out.println("______________________________________________");
                    System.out.println("1. Agregar Producto");
                    System.out.println("2. Modificar Descripción Producto");
                    System.out.println("3. Eliminar Producto");
                    System.out.println("4. Listar Productos");
                    System.out.println("5. Salir");
                    System.out.println("______________________________________________");
                    System.out.print("Elige una opción: ");

                    int subopcion = scanner.nextInt();        

                    switch (subopcion) {
                        case 1 -> {
                            System.out.print("Código de Categoría: ");
                            int categ_id = scanner.nextInt(); 
                            System.out.print("Descripción: ");
                            scanner.nextLine();
                            String descrip = scanner.nextLine(); 
                                                
                            Producto prod = new Producto();
                            prod.insertarProd(categ_id, descrip);
                          
                        }

                        case 2 -> {
                            
                            System.out.print("Ingrese el código del Producto a modificar: ");
                            int prod_id = scanner.nextInt();                            
                            System.out.print("Ingrese la nueva descripción: ");   
                            scanner.nextLine();
                            String descrip = scanner.nextLine();                              
                            
                            Producto prod = new Producto();                            
                            prod.modificarProd(prod_id, descrip);
                        }
                        case 3 -> {

                            System.out.print("Ingrese el código del Producto a eliminar: ");
                            int prod_id = scanner.nextInt();  
                            
                            Producto prod = new Producto();
                            prod.eliminarProd(prod_id);

                        }
                        case 4 -> {
                                         
                            Producto prod = new Producto();
                            prod.listarProd();                            
                        }
                        
                        case 5 -> {

                            seguir_submenu = false;
                        }

                       default -> System.out.println("Opción no válida, vuelva a intentar");
                    }
                }
                   
            }// case 2                                   
                
                case 3 -> {                    
                
                   boolean seguir_submenu = true;
                   
                   while (seguir_submenu) {
                   
                    System.out.println("______________________________________________");
                    System.out.println("MENU Categorías de Productos");
                    System.out.println("______________________________________________");
                    System.out.println("1. Agregar Categoría");
                    System.out.println("2. Modificar Categoría");
                    System.out.println("3. Eliminar Categoría");
                    System.out.println("4. Listar Categorías");
                    System.out.println("5. Salir");
                    System.out.println("______________________________________________");
                    System.out.print("Elige una opción: ");

                    int subopcion = scanner.nextInt();        

                    switch (subopcion) {
                        case 1 -> {
                            System.out.println("Ingrese los datos de la Categoría: ");
                            scanner.nextLine();
                            System.out.print("Descripción: ");
                            String descrip_cat = scanner.nextLine();
                            
                            Categoria_prod cat = new Categoria_prod();
                            cat.insertarCateg(descrip_cat);                          
                        }
                        case 2 -> {
                            scanner.nextLine();
                            System.out.println("Ingrese el código de la Categoría: ");
                            int categ_id = scanner.nextInt();                            
                            System.out.print("Ingrese la nueva descripción: ");   
                            scanner.nextLine();
                            String descrip_cat = scanner.nextLine();                              
                            
                            Categoria_prod cat = new Categoria_prod();                            
                            cat.modificarCateg(categ_id, descrip_cat);
                        }
                        case 3 -> {

                            System.out.println("Ingrese el código de Categoría: ");
                            scanner.nextLine();
                            int categ_id = scanner.nextInt();
                            
                            Categoria_prod cat = new Categoria_prod();
                            cat.eliminarCateg(categ_id);
                        }
                        case 4 -> {
                                         
                            Categoria_prod cat = new Categoria_prod();
                            cat.listarCateg();                            
                        }                        
                        case 5 -> {

                            seguir_submenu = false;
                        }

                       default -> System.out.println("Opción no válida, vuelva a intentar");
                    }
                }
               }// case 3
                        case 4 -> {                   
                           
                           boolean seguir_submenu = true;
                   
                   while (seguir_submenu) {
                   
                    System.out.println("______________________________________________");
                    System.out.println("MENU Tickets de Pesajes");
                    System.out.println("______________________________________________");
                    System.out.println("1. Agregar Ticket de Pesaje Camión Vacío");
                    System.out.println("2. Agregar Ticket de Pesaje Camión Cargado");
                    System.out.println("3. Listar Tickets de Pesajes");
                    System.out.println("4. Salir");
                    System.out.println("______________________________________________");
                    System.out.print("Elige una opción: ");

                    int subopcion = scanner.nextInt();        

                    switch (subopcion) {
                        case 1 -> {
                            
                            System.out.print("Código de Balanza: ");
                            int codigo_bal = scanner.nextInt(); 
                            System.out.print("Código de Empresa: ");
                            int codigo_emp = scanner.nextInt();
                            scanner.nextLine();                    
                            System.out.print("Patente de Camión: ");
                            String patente_c = scanner.nextLine(); 
                            System.out.print("Peso Camión Vacío: ");
                            double peso_v = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.print("Observaciones: ");
                            String obs = scanner.nextLine();    
                            LocalDateTime fecha = LocalDateTime.now();
                                                
                            Ticket_pesaje tp = new Ticket_pesaje();
                            tp.registrar_ticket_camion_v(codigo_bal, codigo_emp, fecha, patente_c, peso_v, obs);
                          
                        }

                        case 2 -> {
                            
                            System.out.print("Ingrese el número de Ticket para completar el pesaje: ");
                            int tp_id = scanner.nextInt();
                            scanner.nextLine();  
                            System.out.print("Patente de Acoplado: ");
                            String patente_a = scanner.nextLine(); 
                            System.out.print("Código de Producto: ");
                            int codigo_prod = scanner.nextInt();
                            scanner.nextLine();                    
                            System.out.print("Peso Camión Cargado: ");
                            double peso_ll = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.print("Observaciones: ");
                            String obs = scanner.nextLine();                                                                  
                            
                            Ticket_pesaje tp = new Ticket_pesaje();                            
                            tp.registrar_ticket_camion_ll(tp_id, codigo_prod, patente_a, peso_ll, obs);
                        }
                        case 3 -> {

                            Ticket_pesaje tp = new Ticket_pesaje();
                            tp.listarTickets();             

                        }                 
                        case 4 -> {

                            seguir_submenu = false;
                        }
                       default -> System.out.println("Opción no válida, vuelva a intentar");
                    }
                }
              }
                        case 5 -> {

                            System.out.print("Programa Finalizado");
                            seguir = false;
                        }

                       default -> System.out.println("Opción no válida, vuelva a intentar");
                    }
        }// while
    }
}