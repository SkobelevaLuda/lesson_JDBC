package org.example;

import java.sql.*;

public class Application {
    public static void main(String[] args) {


        final String user = "postgres";
        final String password = "$Skobel2804";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        // Создаем соединение с базой с помощью Connection
        // Формируем запрос к базе с помощью PreparedStatement
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee")) {

            // Делаем запрос к базе и результат кладем в ResultSet
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                // С помощью методов getInt и getString получаем данные из resultSet
                long id = resultSet.getLong("id");
                String age = resultSet.getString("age");
                String name = resultSet.getString(" name");
                String surname = resultSet.getString("surname");
                //int age = resultSet.getInt(4);

                // Выводим данные в консоль
                System.out.println(id);
                System.out.println(name);
                System.out.println(surname);
                System.out.println("Возраст: " + age);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}

