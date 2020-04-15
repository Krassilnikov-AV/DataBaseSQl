package databasequery;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Properties;

/*

 included Class in the app
1. added the Java Db library!
*/


public class DataBaseQuery {

     private static final String CONFIG = "src\\resources\\config.properties";

    public static void main(String[] args) throws SQLException, IOException {
// создание сеанса с базой данных
        try (Connection connection = getConnection()) {
            System.out.println("есть соединение...");
            CodeProduct code = new CodeProduct("MJ", 'J', "MJovies");
            code.save(connection);
            printAllCodes(connection);

            code.setCode("MJ");
            code.save(connection);
            printAllCodes(connection);
        }
        /*
         * TODO #14 Средствами отладчика проверьте корректность работы программы
         */
    }

    /**
     * Выводит в консоль все коды товаров
     * @param connection действительное соединение с базой данных
     * @throws SQLException
     */
    private static void printAllCodes(Connection connection) throws SQLException {
        Collection<CodeProduct> codes = CodeProduct.all(connection);
        for (CodeProduct code : codes) {
            System.out.println(code);
        }
    }

    /**
     * Возвращает URL, описывающий месторасположение базы данных
     *
     * @return URL в виде объекта класса {@link String}
     */
    private static String getUrl() {       
        String url = "jdbc:derby://localhost:1527/sample";
        System.out.println("есть url...");
        return url; 
        /*
         * TODO #02 Реализуйте метод getUrl
         */
    }

    /**
     * Возвращает параметры соединения
     *
     * @return Объект класса {@link Properties}, содержащий параметры user и
     * password
     */
    private static Properties getProperties() throws IOException {
        /*
         * TODO #03 Реализуйте метод getProperties
         */
        Properties configs = new Properties();
        try (FileInputStream file = new FileInputStream(CONFIG)) {
            configs.load(file);
        } catch (IOException ex) {
            System.out.println("не получили данные..." + ex);
        }
        return configs;
    }

    /**
     * Возвращает соединение с базой данных Sample
     *
     * @return объект типа {@link Connection}
     * @throws SQLException
     */
    private static Connection getConnection() throws SQLException, IOException {
        /*
         * TODO #04 Реализуйте метод getConnection
         */
        String url = getUrl();
        Properties usnamePas = getProperties();

        String user = usnamePas.getProperty("database.user").trim();
        String password = usnamePas.getProperty("database.password").trim();   // от лишних пробелов

        return DriverManager.getConnection(url, user, password);
    }

}
