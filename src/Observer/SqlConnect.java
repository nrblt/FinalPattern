package Observer;
import java.sql.*;

public class SqlConnect {

    public void insertScore(String name,int score) {
        ResultSet resultSet = null;
        try {
            // Code here.
            Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/demodb", "postgres", "1234");
            String sql = "insert into scores(username,score) "+" values(?,?)";
            PreparedStatement preparedStatement =connection.prepareStatement(sql);

            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,score);
            preparedStatement.executeUpdate();

//            preparedStatement.createStatement().execute(query);

//            Statement statement = connection.createStatement();
//            resultSet = statement.executeQuery(sql);
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString(2) );
//            }
            // Handle any errors that may have occurred.
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet allUsers() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/demodb", "postgres", "1234");
        String sql="select * from users";
        Statement statement = connection.createStatement();
        return statement.executeQuery(sql);
    }
    public int messages(String name) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/demodb", "postgres", "1234");
        String sql="select * from user_messages where current_user= ?";
        PreparedStatement preparedStatement =connection.prepareStatement(sql);
        preparedStatement.setString(1,name);
        return preparedStatement.executeUpdate();
//        Statement statement = connection.createStatement();
//        return statement.executeQuery(sql);
    }
    public void insertUser(String name){
        ResultSet resultSet = null;
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/demodb", "postgres", "1234");
            resultSet = allUsers();
            while (resultSet.next()) {
                if(resultSet.getString(2).equals(name)){
                    System.out.println("This username is already used");
                    break;
                }
            }
            String sql2 = "insert into users(name) "+" values(?)";
            PreparedStatement preparedStatement =connection.prepareStatement(sql2);

            preparedStatement.setString(1,name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertMessage(String messageTo,String winnerName,int score) {
        ResultSet resultSet = null;
        try {
            // Code here.
            Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/demodb", "postgres", "1234");
            String sql = "insert into user_messages(current_username,winner_username,score) "+" values(?,?,?)";
            PreparedStatement preparedStatement =connection.prepareStatement(sql);

            preparedStatement.setString(1,messageTo);
            preparedStatement.setString(2,winnerName);
            preparedStatement.setInt(3,score);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

