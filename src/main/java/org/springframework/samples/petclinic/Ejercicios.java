package org.springframework.samples.petclinic;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.owner.PetType;

public class Ejercicios {

	public static void ejercicio1(Connection connection, Statement statement) throws SQLException {
		// 1. btener todos los clientes de la clinica y mostrar sus datos por pantalla
		statement = connection.createStatement();
		String sql = "SELECT * FROM owners;";
		ResultSet rs = statement.executeQuery(sql);

		while (rs.next()) {
			int id = rs.getInt("id");
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			String address = rs.getString("address");
			String city = rs.getString("city");
			String telephone = rs.getString("telephone");
			System.out.println("Id: " + id);
			System.out.println(", Nombre: " + firstName);
			System.out.println(", Apellidos: " + lastName);
			System.out.println(", Adresss: " + address);
			System.out.println(", City: " + city);
			System.out.println(", Telephone: " + telephone);

		}

		rs.close();
	}

	public static void ejercicio2(Connection connection, Statement statement) throws SQLException {
		// 2. Insertarnos a nosotros como nuevo propietario de una mascota
		statement = connection.createStatement();
		String sql = "INSERT INTO owners VALUES (null,'Joao','Rafael','Santarem','Santarem','1231231')";
		statement.executeUpdate(sql);

	}

	public static void ejercicio3(Connection connection, Statement statement) throws SQLException {
		// 3. Modificar nuestra ciudad por Sevilla
		statement = connection.createStatement();
		String sql = "UPDATE owners SET city = 'Sevilla' WHERE id = 11";
		statement.executeUpdate(sql);

	}

	public static void ejercicio4(Connection connection) throws SQLException {
		// 4. Crear una variable de tipo String y buscar todos los Owner que coincidan
		// en nombre o apellido.
		PreparedStatement preparedStatement = null;
		String name = "Maria";
		String sql = "SELECT * FROM owners WHERE first_name=? OR last_name=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, name);
		ResultSet rs = preparedStatement.executeQuery();

		while (rs.next()) {
			int id = rs.getInt("id");
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			System.out.println("Id: " + id);
			System.out.println(", Nombre: " + firstName);
			System.out.println(", Apellidos: " + lastName);

		}

		rs.close();
	}

	public static void ejercicio5(Connection connection) throws SQLException {
		// 5. Crear a partir de las variables nombre, apellido, direccion, ciudad y
		// teléfono (todas de tipo
		// String), un nuevo owner
		String nombre = "JOJO";
		String apellido = "jejeje";
		String direccion = "cima";
		String ciudad = "Lisboa";
		String telefono = "0909090";
		String sql = "INSERT INTO owners VALUES (null,?,?,?,?,?)";
		PreparedStatement preparedStatement = null;
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, nombre);
		preparedStatement.setString(2, apellido);
		preparedStatement.setString(3, direccion);
		preparedStatement.setString(4, ciudad);
		preparedStatement.setString(5, telefono);
		preparedStatement.executeUpdate();

	}

	public static void reto(Connection connection, Statement statement) throws SQLException {
		Owner ze = new Owner();
		Pet perro = new Pet();
		

		Date data = new Date(1550/2/4);

		ze.setId(null);
		ze.setFirstName("ZeZe");
		ze.setLastName("Camarinha");
		ze.setAddress("Rua 232323");
		ze.setCity("Vale de Santarem");
		ze.setTelephone("949494");

		perro.setId(null);
		perro.setBirthDate(data);
		perro.setName("Bolinhas");

		String sql = "INSERT INTO owners VALUES (null,?,?,?,?,?)";
		PreparedStatement preparedStatement = null;
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, ze.getFirstName());
		preparedStatement.setString(2, ze.getLastName());
		preparedStatement.setString(3, ze.getAddress());
		preparedStatement.setString(4, ze.getCity());
		preparedStatement.setString(5, ze.getTelephone());
		preparedStatement.executeUpdate();

		statement = connection.createStatement();
		String sql2 = "SELECT * FROM owners WHERE first_name='ZeZe' AND last_name='Camarinha'";
		ResultSet rs = statement.executeQuery(sql2);
		int id = 0;

		while (rs.next()) {
			id = rs.getInt("id");
		}

		String sql3 = "INSERT INTO pets VALUES (null,?,?,?,?)";
		preparedStatement = connection.prepareStatement(sql3);
		preparedStatement.setString(1, perro.getName());
		preparedStatement.setDate(2, data);
		preparedStatement.setInt(3, id);
		preparedStatement.setInt(4, 5);
		preparedStatement.executeUpdate();

		/*
		 * sql = "DELETE * FROM owners WHERE id=?"; preparedStatement =
		 * connection.prepareStatement(sql); preparedStatement.setInt(1, id);
		 * preparedStatement.execute(sql);
		 */

	}

}
