package com.global.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connect {
public static void main(String [] args)
{
	try
	{
		Class.forName("com.mysql.jdbc.Driver");		//chargement d'un driver
		System.out.println("Driver ok");
		String url="jdbc:mysql://localhost:3306/global";
		String user="root";
		String passwd="";
		// le driver tente d'instancier une connexion vers la base en utilisant le driver instacié précédement
		Connection conn=DriverManager.getConnection(url, user, passwd);
		System.out.println("Conection effective!");	
		Statement state=conn.createStatement();// Création d'un objet Statement
		ResultSet result= state.executeQuery("SELECT * FROM employe"); // les resulats de la quette sont dans l'objet result
		System.out.println("\n --------------------------------------------");
		while (result.next()) //parcurir les resultats 
		{
			
			System.out.print("\t"+result.getInt("id")+"\t |");
			System.out.print("\t"+result.getString("nom")+"\t |");
			System.out.print("\t"+result.getString("prenom")+"\t |");
			System.out.println("\n----------------------------------------------------------");
		}
		result.close();
		state.close();
			
	}
	catch (Exception e)
	{e.printStackTrace();}
	}

}
