/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginbasedatos;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 *
 * @author solera
 */
public class FuncionesComunes {
    
    static Statement  stmt;

        
        //Acceso a la base de datos y creacion  de objetos herramientas pos cada uno de los articulos de la base de datos
	public  void conectarBbdd(){
		int i=0;
        Connection conn;		
		try{
			conn = DriverManager.getConnection("jdbc:mysql://server:3306/midb","root", "");
			System.out.println("Conn OK!");
			

			stmt=conn.createStatement();			
			
			String sql = "SELECT * FROM productos;";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			String referencia, nombre, familia;
			float stock, precio;
		
			rs.last();
			int numeroRegistros = rs.getRow();
			rs.beforeFirst();
			
			
			Herramientas [] hr = new Herramientas[numeroRegistros];
			
			
			
			while(rs.next()){
				
				referencia = rs.getString("referencia");
				nombre = rs.getString("nombre");
				familia = rs.getString("familia");
				stock = rs.getFloat("stock");
				precio = rs.getFloat("precio");
			
				
				
				hr[i]=new Herramientas(referencia, nombre, familia, stock, precio);
				
				
				System.out.println(hr[i].getReferencia()+hr[i].getNombre()+hr[i].getFamilia()+hr[i].getStock()+hr[i].getPrecio());


				
				i++;
			}
			
			
		}
		catch(Exception e){
			System.out.println(e);
		}	
	
	}
	
	
          //Acceso a la base de datos y creacion  de objetos herramientas pos cada uno de los articulos de la base de datos
	public  void crearArrayUsuariosExistentes(){
		int i=0;
        Connection conn;
        
		try{
			conn = DriverManager.getConnection("jdbc:mysql://server:3306/midb","root", "");
			System.out.println("Conn OK!");
			

			stmt=conn.createStatement();			
			
			String sql = "SELECT * FROM usuarios;";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			String nombre, password, usuario, email;
			
		
			rs.last();
			int numeroRegistros = rs.getRow();
			rs.beforeFirst();
			
			
			Usuarios [] user = new Usuarios[numeroRegistros];
			
			
			while(rs.next()){
				
				nombre = rs.getString("nombre");
				password = rs.getString("contraseña");
                                usuario = rs.getString("usuario");
				email = rs.getString("email");
				
				user[i]=new Usuarios(nombre, password, usuario, email);
				
                                System.out.println(user[i].getNombre()+user[i].getPassword());
                                
				i++;
			}
			
			
		}
		catch(Exception e){
			System.out.println(e);
		}	
	
	}
        
        
        
        public void crearUsuarios(){
            
            int numeroUsuarios;
            String nombre, password,  usuario,  email;
            
            numeroUsuarios= Integer.valueOf((pregunta("introduce el numero de usuarios que vas a introducir ")));
            
            Usuarios [] usuariosLocales = new Usuarios[numeroUsuarios];
            int i=0;
            while(numeroUsuarios>1){
                nombre = pregunta("introduce tu nombre: ");
                password= pregunta("Introduce la contraseña: ");
                usuario= pregunta("Introduce el nombre de usuario: ");
                email= pregunta("Introduce tu email: ");

            
                numeroUsuarios--;
            
                usuariosLocales[i]=new Usuarios(nombre, password, usuario, email);
                i++;
            }
        }
        
        public void interfazLogin(){
            
            //************************INICIO****INTERFAZ**************************************************************************
            
		JFrame principal = new JFrame ("Juego Adivinanzas");
                //Colores
 
                
		JLabel tituloPrincipal = new JLabel ("Interfaz login");
		
		JButton nombreUsuario = new JButton ("Introduce tu nombre de usuario");
		JButton password = new JButton ("Introduce tu contraseña");
                
                JTextField nombreIn = new JTextField();
                JTextField passwordIn = new JTextField();


		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		
		//Asignamos la constante EXIT_ON_CLOSE, cierra la ventana al pulsar la X.
		principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Asignamos al JFrame el Layout que usaremos, GridBagLayout
		
		principal.setLayout (gridbag);
		
		//a�adir botones al layout
                
		gbc.gridx = 1;
		gbc.gridy = 0;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                gbc.weighty = 0.1; // La fila 0 debe estirarse, le ponemos un 1.0
                gbc.fill = GridBagConstraints.HORIZONTAL ;
                principal.add (tituloPrincipal,gbc);
		
                
                
		gbc.gridx = 1;
		gbc.gridy = 1;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                gbc.weighty = 0.1; // La fila 0 debe estirarse, le ponemos un 1.0
                gbc.fill = GridBagConstraints.HORIZONTAL ;
                principal.add (nombreUsuario,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                gbc.weighty = 0.1; // La fila 0 debe estirarse, le ponemos un 1.0
                gbc.fill = GridBagConstraints.HORIZONTAL ;
		principal.add (nombreIn,gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 1;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                gbc.weighty = 0.1; // La fila 0 debe estirarse, le ponemos un 1.0
                gbc.fill = GridBagConstraints.HORIZONTAL ;
		principal.add (password,gbc);
                
                gbc.gridx = 2;
		gbc.gridy = 2;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                gbc.weighty = 0.1; // La fila 0 debe estirarse, le ponemos un 1.0
                gbc.fill = GridBagConstraints.HORIZONTAL ;
		principal.add (passwordIn,gbc);
                
		//Hace visible el panel
		principal.setVisible(true);
		principal.setSize(650, 350);
		principal.setLocationRelativeTo(null); 
		principal.setResizable(false);
		//principal.pack();
                
                try{
			nombreIn.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
					
					
				}

			});
			}
			
			catch(Exception e){}
                
                
            
}
        
        
        
        
	//Eliminacion de un articulo de la base de datos
	public void borrar(String referencia){
		try {
			stmt.executeUpdate("delete from productos where referencia=('"+referencia+"')");
			System.out.println("BORRADO OK!");
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
    
        
        //inserta articulo a la base de datos
    public void insertar (String referencia, String nombre, String familia, float stock, float precio){
    	
    	String query;
    	
    	query = "INSERT INTO productos VALUES ("+referencia+","+nombre+","+familia+","+stock+","+precio+");";
    	try{
    		stmt.executeUpdate(query);
    	}catch(Exception e){}
    	
    }
    
    //Modifica un elemento de la tabla especificada 
    public void modificarDatos(String tabla, String referencia, String referenciaNueva, String nombre, String familia, float stock, float precio){
    	//primero modificar el array despues en la base de datos
    
    	try{
    		stmt.executeUpdate("UPDATE" + tabla + "set where "+referencia+"='"+referenciaNueva+"'");
    		stmt.executeUpdate("UPDATE" + tabla + "set where "+referencia+"='"+nombre+"'");
    		stmt.executeUpdate("UPDATE" + tabla + "set where "+referencia+"='"+familia+"'");
    		stmt.executeUpdate("UPDATE" + tabla + "set where "+referencia+"='"+stock+"'");
    		stmt.executeUpdate("UPDATE" + tabla + "set where "+referencia+"='"+precio+"'");

    		
			System.out.println("actualizado OK!");
    		
    		
    	}catch(Exception e){}
    	
    	
    }
	
    
    public String pregunta(String preg){
	
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner (System.in);
		System.out.print(preg);
		String leer= teclado.nextLine();
		
	    return (leer);
	
	  }
}

	