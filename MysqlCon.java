import java.sql.*;
import java.util.Scanner;

class MysqlCon {  
public static void main(String args[]) {  
  
  try{  
    Scanner sc = new Scanner(System.in);
    Class.forName("com.mysql.jdbc.Driver");  
    Connection con=DriverManager.getConnection(  
    "jdbc:mysql://10.0.10.3:3306/baza","KAlbiniak","password");
    String sql = "CREATE TABLE IF NOT EXISTS tabela ((id int(10), name varchar(40), age int(3));";
    Statement stmt=con.createStatement();
    stmt.executeUpdate(sql);
    sql = "INSERT INTO tabel (id, name, age) VALUES (1, 'Krystian', 21), (2, 'name2', 34), (3, 'name3', 96)";
    stmt=con.createStatement();
    stmt.executeUpdate(sql);
    System.out.println("Wybierz: 1-Dodaj uzytkownika, 2-Wyswietl");
    int i = sc.nextInt();
    if(i.equals(1))
    {
      sql = "INSERT INTO tabela" + "(id, name, age) VALUES" + "(?,?,?)";
      PreparedStatement preparedStatement = con.prepareStatement(sql);
      System.out.print("ID: ");
      int id = sc.nextInt();
      preparedStatement.setInt(1, id);
      System.out.print("Imie: ");
      String name = sc.nextLine();
      preparedStatement.setString(2, name);
      System.out.print("Wiek: ");
      String age = sc.nextLine();
      preparedStatement.setInt(3, age);
      preparedStatement .executeUpdate();
    } else if(i.equals(2))
    {
      ResultSet rs=stmt.executeQuery("select * from tabela");
      while(rs.next())
      System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "rs.getInt(3));
    } else
    {
      System.out.println("Nie ma takiej opcji!");
    }
    
    con.close();  
    }catch(Exception e){ 
    System.out.println(e);
    }  
  }  
}  
