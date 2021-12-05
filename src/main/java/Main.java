import GUI.Interface;


// запуск программы
public class Main {
    public static void main(String[] args){
       // Interface mainInterface = new Interface();
        DatabaseConnection.executeQuery("SELECT * FROM table123;");
    }
}
