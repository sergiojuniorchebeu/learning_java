package fr.sergio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Programme {


		public static void main(String[] args) {
		
		
		try {
			String url = "jdbc:mysql://localhost:3306/supermarche";
			String user= "root";
			String password = "";
			String insertion ="INSERT INTO clients (nom, email) VALUES ('Nemi','Michèlenemi@gmail.com')";
			String read= "Select* from clients";
			//chargement des pilotes
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Success de chargement des pilotes");
			Connection c = DriverManager.getConnection(url, user, password);
			System.out.println("Connexion à la BD réuissie");
			Statement st = c.createStatement();
			try {
				ResultSet repose = st.executeQuery(read);
				if (repose.next() == true ) {
					System.out.println("Selection réuissie");
					System.out.println("Numéro : "+ " "+repose.getInt(1)+ " "+"Nom :"+ " " + repose.getString(2)+ " "+ "email : " + " " + repose.getString(3));
				}
			} catch (Exception e) {
				System.out.println("Erreur lors dr la récupération des données"+ e.getMessage());
			}
			try {
				//st.executeUpdate(insertion); 
			} catch (Exception e) {
				System.out.println("Erreur lors de l'insertion des données"+ " "+" " +e.getMessage());
			}
			try {
				
			} catch (Exception e) {
				System.out.println("Erreur lors de la récuprération des données"+ " "+ e.getMessage());
			}
		} catch (Exception e) {
			System.out.println("Erreur de Connexion"+" "+ e.getMessage());
		}
	}
		

	
	

}
