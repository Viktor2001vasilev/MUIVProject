import java.sql.*;
import java.util.concurrent.Executor;

// CREATE TABLE table123 ( id INT(11), url VARCHAR(1000) );
// INSERT INTO table123 SET id = 0, url = 'asdfasdfasdfasdfasdfsdfsdfsdafa';
// SELECT * FROM table123;

public class DatabaseConnection {
    private static final String connectionUrl = "jdbc:mysql://sql11.freesqldatabase.com:3306/sql11456532"; //jdbc:mysql://хост:порт/название базы данных

    private static int generateTableId() {
        return 1+(int)(Math.random()* 400);
    }

    public static void executeQuery(String query) {
        try(Connection connection = DriverManager.getConnection(connectionUrl, "sql11456532", "ugleUQPDe7");
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery()) {

                while(resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String url = resultSet.getString("url");

                    System.out.println(id + " " + url);
                }
                connection.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static int createNewTable() {
        int tableId = generateTableId();
        try(Connection connection = DriverManager.getConnection(connectionUrl, "sql11456532", "ugleUQPDe7");
            PreparedStatement preparedStatement = connection.prepareStatement("CREATE TABLE table" + tableId + " ( id INT(11), url VARCHAR(1000) )");
            ResultSet resultSet = preparedStatement.executeQuery()) {

            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String url = resultSet.getString("url");

                System.out.println(id + " " + url);
            }
            connection.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
