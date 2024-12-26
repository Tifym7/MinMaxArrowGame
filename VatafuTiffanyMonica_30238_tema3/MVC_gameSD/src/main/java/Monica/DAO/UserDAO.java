package Monica.DAO;

import Monica.Connection.ConnectionF;
import Monica.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

public class UserDAO extends AbstractDAO<User>{
    public UserDAO() {

    }
    public User insertUser (User user){
        return insert(user);
    }
    public User findByUserName(String username){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("name_user");
        try{
            connection = ConnectionF.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1,username);
            resultSet = statement.executeQuery();
            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "UserDAO:findByUsername " + e.getMessage());
        } catch(Throwable e){
            System.out.println("ceva nu ii place");
        }finally {
            ConnectionF.close(resultSet);
            ConnectionF.close(statement);
            ConnectionF.close(connection);
        }
        return null;

    }
}
