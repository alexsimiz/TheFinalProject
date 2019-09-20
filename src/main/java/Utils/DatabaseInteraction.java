package Utils;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseInteraction {

    public ArrayList databaseQuery(String url, String user, String password, String query) {
        Connection connection = null;
        ResultSet resultSet = null;
        ArrayList<String> listOfDB = new ArrayList<String>();

        try {
            connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int numberOfColumns = rsmd.getColumnCount();
            String ownerDetails = "";
            while (resultSet.next()) {
                for(int i = 1; i <= numberOfColumns; i++){
                    ownerDetails += resultSet.getString(i) + " ";
                }
                listOfDB.add(ownerDetails);
                ownerDetails = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return listOfDB;
    }
}