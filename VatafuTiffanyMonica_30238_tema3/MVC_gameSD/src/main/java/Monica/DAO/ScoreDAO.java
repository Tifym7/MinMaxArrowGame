package Monica.DAO;

import Monica.Connection.ConnectionF;
import Monica.Model.Score;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;

public class ScoreDAO extends AbstractDAO<Score> {
    public ScoreDAO() {

    }
    public void inserScore (Score score) {insert(score);}
    public List<Score> find10ScoresBetter (int value,int level) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM score WHERE value > ? AND LEVEL = ? LIMIT 10";
        try{
            connection = ConnectionF.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, value);
            statement.setInt(2, level);
            System.out.println(statement);
            resultSet = statement.executeQuery();

            return createObjects(resultSet);
        }catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ScoreDAO:find10ScoresBetter " + e.getMessage());
        }finally {
            ConnectionF.close(resultSet);
            ConnectionF.close(statement);
            ConnectionF.close(connection);
        }
        return null;
    }
}
