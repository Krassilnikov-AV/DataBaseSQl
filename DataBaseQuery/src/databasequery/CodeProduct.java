package databasequery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Класс описывает представление о коде товара и отражает соответствующую
 * таблицу базы данных Sample (таблица PRODUCT_CODE).
 *
 */
public class CodeProduct {

    /**
     * Код товара
     */
    private String code;
    /**
     * Кода скидки
     */
    private char discountCode;
    /**
     * Описание
     */
    private String description;

    /**
     * Основной конструктор типа {@link CodeProduct}
     *
     * @param code код товара
     * @param discountCode код скидки
     * @param description описание
     */
    public CodeProduct(String code, char discountCode, String description) {
        this.code = code;
        this.discountCode = discountCode;
        this.description = description;
    }

    /**
     * Инициализирует объект значениями из переданного {@link ResultSet}
     *
     * @param set {@link ResultSet}, полученный в результате запроса,
     * содержащего все поля таблицы PRODUCT_CODE базы данных Sample.
     */
    private CodeProduct(ResultSet set) {
        /*
         * TODO #05 реализуйте конструктор класса CodeProduct
         */
        try {
            code = set.getString("PROD_CODE");
            discountCode = set.getString("DISCOUNT_CODE").charAt(0);
            description = set.getString("DESCRIPTION");
        } catch (SQLException ex) {
            System.out.println("Ошибка создания ProductCode из Resultset");
        }
    }
    /**
     * Возвращает код товара
     *
     * @return Объект типа {@link String}
     */
    public String getCode() {
        return code;
    }

    /**
     * Устанавливает код товара
     *
     * @param code код товара
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Возвращает код скидки
     *
     * @return Объект типа {@link String}
     */
    public char getDiscountCode() {
        return discountCode;
    }

    /**
     * Устанавливает код скидки
     *
     * @param discountCode код скидки
     */
    public void setDiscountCode(char discountCode) {
        this.discountCode = discountCode;
    }

    /**
     * Возвращает описание
     *
     * @return Объект типа {@link String}
     */
    public String getDescription() {
        return description;
    }

    /**
     * Устанавливает описание
     *
     * @param description описание
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Хеш-функция типа {@link CodeProduct}.
     *
     * @return Значение хеш-кода объекта типа {@link CodeProduct}
     */
    @Override
    public int hashCode() {
        /*
         * TODO #06 Реализуйте метод hashCode
         */
        return Objects.hash(code, discountCode, description);
    }

    /**
     * Сравнивает некоторый произвольный объект с текущим объектом типа
     * {@link CodeProduct}
     *
     * @param obj Объект, с которым сравнивается текущий объект.
     * @return если объект obj тождественен текущему объекту - true. В обратном
     * случае - false.
     */
    @Override
    public boolean equals(Object obj) {

// boolean a = false;
//        if (obj instanceof CodeProduct) {
//            if (obj.toString().equals(this.toString())) {
//                a = true;
//            }
//        } else {
//            a = false;
//        }
//        return a;

        /*2-ой вариант сравнения*/
        if (this == obj) {
            return true;
        }
        if (obj instanceof CodeProduct) {
            CodeProduct other = (CodeProduct) obj;
            return (this.code.equals(other.code))
                    && (this.discountCode == other.discountCode)
                    && (this.description.equals(other.description));
        }
        return false;
        /*
         * TODO #07 Реализуйте метод equals
         */
    }

    /**
     * Возвращает строковое представление кода товара.
     *
     * @return Объект типа {@link String}
     */
    @Override
    public String toString() {
/*1ый вариант*/
//        return "Product_Code{" + "code=" + code + ", discountCode=" + discountCode + ", description=" + description + "}";
/*2ой вариант*/
//     return "Code: " + code + " | Discount code: " + discountCode + " | Description: " + description;
        return "Код товара " + this.getCode();
        /*
         * TODO #08 Реализуйте метод toString
         */
    }

    /**
     * Возвращает запрос на выбор всех записей из таблицы PRODUCT_CODE базы
     * данных Sample
     *
     * @param connection действительное соединение с базой данных
     * @return Запрос в виде объекта класса {@link PreparedStatement}
     */
    public static PreparedStatement getSelectQuery(Connection connection) throws SQLException {

//        String query = "SELECT * FROM PRODUCT_CODE";    // формирование запроса
//        PreparedStatement pst = connection.prepareStatement(query);
//        System.out.println("Выбраны все коды базы данных...");
//        return pst;
//        PreparedStatement preparedStatement = QueriesManager.getPreparedStatement(connection, "selectAll");
//        return preparedStatement;
//
        String SQL = "Select * from PRODUCT_CODE";
        System.out.println("Выбраны все коды базы данных...");
        return connection.prepareStatement(SQL);
        /*
         * TODO #09 Реализуйте метод getSelectQuery
         */
    }

    /**
     * Возвращает запрос на добавление записи в таблицу PRODUCT_CODE базы данных
     * Sample
     *
     * @param connection действительное соединение с базой данных
     * @return Запрос в виде объекта класса {@link PreparedStatement}
     */
    public static PreparedStatement getInsertQuery(Connection connection) throws SQLException {

//          String query = "insert into PRODUCT_CODE(PROD_CODE, DISCOUNT_CODE, DESCRIPTION) " + "values(?, ?, ?)";
//        PreparedStatement pst = connection.prepareStatement(query);
//        System.out.println("Добавлены все коды базы данных...");
//        return pst;      
        String SQL = "Insert into PRODUCT_CODE (PROD_CODE, DISCOUNT_CODE, DESCRIPTION) values (?,?,?)";
        System.out.println("Добавлены все коды базы данных...");
        return connection.prepareStatement(SQL);
        /*
         * TODO #10 Реализуйте метод getInsertQuery
         */
    }

    /**
     * Возвращает запрос на обновление значений записи в таблице PRODUCT_CODE
     * базы данных Sample
     *
     * @param connection действительное соединение с базой данных
     * @return Запрос в виде объекта класса {@link PreparedStatement}
     */
    public static PreparedStatement getUpdateQuery(Connection connection) throws SQLException {

//        String query = "UPDATE PRODUCT_CODE SET DISCOUNT_CODE = ?, DESCRIPTION = ? WHERE  PROD_CODE = ?";
//        PreparedStatement pst = connection.prepareStatement(query);
//       return pst;
        String SQL = "Update PRODUCT_CODE SET DISCOUNT_CODE = ?,  DESCRIPTION = ? WHERE  PROD_CODE = ? values (?,?,?)";
        System.out.println("Все значения обновлены....");
        return connection.prepareStatement(SQL);

        /*
         * TODO #11 Реализуйте метод getUpdateQuery
         */
    }

    /**
     * Преобразует {@link ResultSet} в коллекцию объектов типа
     * {@link CodeProduct}
     *
     * @param set {@link ResultSet}, полученный в результате запроса,
     * содержащего все поля таблицы PRODUCT_CODE базы данных Sample
     * @return Коллекция объектов типа {@link CodeProduct}
     * @throws SQLException
     */
    public static Collection<CodeProduct> convert(ResultSet set) throws SQLException {
        /*1-ый вариант*/
//        Collection<CodeProduct> collection = new LinkedList<>();
//        while (set.next()) {
//            collection.add(new CodeProduct(set));
//        }
//        return collection;
/*2-ой вариант
- конструктор уже создан*/
//        Collection<CodeProduct> collection = new LinkedList<>();
//        while (set.next()) {
//            String code = set.getString("PROD_CODE");
//            String discountCode = set.getString("DISCOUNT_CODE");
//            String description = set.getString("DESCRIPTION");
//            collection.add(new CodeProduct(code, discountCode.charAt(0), description));
//        }
//        return new ArrayList<CodeProduct>(collection);
/*3-ий вариант*/
        Collection<CodeProduct> prodType = new ArrayList<>();
        while (set.next()) {
            prodType.add(new CodeProduct(set));
        }
        System.out.println("Все данные преобразовались в коллекцию объектов типа CodeProduct.");
        return new ArrayList<>(prodType);
        /*
         * TODO #12 Реализуйте метод convert
         */
    }

    /**
     * Сохраняет текущий объект в базе данных.
     * <p>
     * Если запись ещё не существует, то выполняется запрос типа INSERT.
     * <p>
     * Если запись уже существует в базе данных, то выполняется запрос типа
     * UPDATE.
     *
     * @param connection действительное соединение с базой данных
     */
    public void save(Connection connection) throws SQLException {
/*1ый вариант*/
//        System.out.println("Соединение в save: " + connection);
//        Statement st = null;
//        try {
//            st = connection.createStatement();
//        } catch (SQLException ex) {
//            System.out.println("Ошибка создания st " + ex.getMessage());
//        }
//        ResultSet rs = null;
//        PreparedStatement pst = null;
//        rs = st.executeQuery("SELECT * FROM PRODUCT_CODE WHERE PROD_CODE =  'code'"); //           Logger.getLogger(ProductCode.class.getName()).log(Level.SEVERE, null, ex);
//        try {
//           
//            if (rs.next()) {
//                // есть такой продукт - делаем UPDATE
//                pst = getUpdateQuery(connection);
//                pst.setString(1, code);
//                pst.setString(2, String.valueOf(discountCode)); // .setDouble(2, discountCode);
//                pst.setString(3, description);
//            } else {
//                // нет такого в базе - делаем INSERT
//                pst = getInsertQuery(connection);
//                pst.setString(1, code);
//                pst.setString(2, String.valueOf(discountCode));
//                pst.setString(3, description);
//            }
//            pst.executeUpdate();
//            pst.close();
//            st.close();
//        } catch (SQLException ex) {
//            System.out.println("Ошибка в ...." + ex.getMessage());
//        }
        if (all(connection).contains(this)) {
            System.out.println("Update");
            PreparedStatement ps = getUpdateQuery(connection);
            ps.setString(1, code);
            ps.setString(2, description);
            ps.setString(3, Character.toString(discountCode));

        } else {
            PreparedStatement ps = getInsertQuery(connection);
            ps.setString(1, code);
            ps.setString(2, description);
            ps.setString(3, Character.toString(discountCode));
        }
        /*
         * TODO #13 Реализуйте метод save
         */
    }

    /**
     * Возвращает все записи таблицы PRODUCT_CODE в виде коллекции объектов типа
     * {@link CodeProduct}
     *
     * @param connection действительное соединение с базой данных
     * @return коллекция объектов типа {@link CodeProduct}
     * @throws SQLException
     */
    public static Collection<CodeProduct> all(Connection connection) throws SQLException {
        PreparedStatement statement = getSelectQuery(connection);
        {
            try (ResultSet result = statement.executeQuery()) {
                return convert(result);
            }
        }
    }
}
