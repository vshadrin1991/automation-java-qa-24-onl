package lecture_21;

import lombok.SneakyThrows;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lecture_21 {
    Connection connection;
    Statement statement;

    @SneakyThrows
    @BeforeTest
    public void connect() {
        connection = DriverManager.getConnection("jdbc:mysql://db4free.net/testqa07?user=testqa07&password=testqa07");
        statement = connection.createStatement();
    }

    @Test(priority = 1)
    public void selectTest() {
        print("SELECT * FROM user");
    }

    @Test(priority = 2)
    public void selectLikeTest() {
        print("SELECT * FROM user WHERE first_name LIKE '%test%'");
    }

    @Test(priority = 3)
    public void selectInTest() {
        print("SELECT * FROM user WHERE age IN (22, 25, 32)");
    }

    @Test(priority = 4)
    public void selectBetweenTest() {
        print("SELECT * FROM user WHERE age BETWEEN 22 AND 32");
    }

    @SneakyThrows
    @Test(priority = 5)
    public void updateTest() {
        print("SELECT * FROM user WHERE id=3");
        statement.executeUpdate("UPDATE user SET first_name='AQA' WHERE id=3");
        print("SELECT * FROM user WHERE id=3");
    }

    @SneakyThrows
    @Test(priority = 6)
    public void insertTest() {
        print("SELECT * FROM user");
        statement.executeUpdate("INSERT INTO user (id, first_name, last_name) VALUES (1000, 'SUPER USER', 'SUPER QA')");
        Assert.assertEquals(print("SELECT * FROM user").stream().filter(data -> data.get("id").equals("1000")).collect(Collectors.toList()).get(0).get("first_name"), "SUPER USER");
    }

    @SneakyThrows
    @Test(priority = 7)
    public void deleteTest() {
        print("SELECT * FROM user");
        statement.executeUpdate("DELETE FROM user WHERE id=1000");
        print("SELECT * FROM user");
    }


    @SneakyThrows
    @AfterClass
    public void closeConnection() {
        statement.close();
    }


    /*
       |id|last_name|first_name|
       |7 |teshk    |User 4    |
       |6 |797      |User 5    |
               .....
               */
    @SneakyThrows
    public List<Map<String, String>> print(String query) {
        ResultSet resultSet = statement.executeQuery(query);
        ResultSetMetaData data = resultSet.getMetaData();
        List<Map<String, String>> table = new ArrayList<>();
        while (resultSet.next()) {
            Map<String, String> result = new HashMap<>();
            for (int i = 1; i <= data.getColumnCount(); i++) {
                result.put(data.getColumnName(i), resultSet.getString(i));
            }
            table.add(result);
        }
        System.out.println(query);
        table.forEach(System.out::println);
        System.out.println("\n");
        return table;
    }
}
