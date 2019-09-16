package ajplarson.dealership.data;

import ajplarson.dealership.models.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class StateDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StateDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public State add(State state) {

        final String sql = "INSERT INTO state(abbr, name) VALUES(?,?);";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update((Connection conn) -> {

            PreparedStatement statement = conn.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, state.getAbbr());
            statement.setString(2, state.getName());
            return statement;

        }, keyHolder);

        state.setStateId(keyHolder.getKey().intValue());

        return state;
    }

    public List<State> getAll() {
        final String sql = "SELECT stateId, name, abbr FROM state;";
        return jdbcTemplate.query(sql, new StateMapper());
    }

    public State findById(int id) {

        final String sql = "SELECT stateId, name, abbr "
                + "FROM state WHERE stateId = ?;";

        return jdbcTemplate.queryForObject(sql, new StateMapper(), id);
    }
    
    public State findByName(String name) {
         final String sql = "SELECT stateId, name, abbr "
                + "FROM state WHERE name = ?;";

        return jdbcTemplate.queryForObject(sql, new StateMapper(), name);
    }

    public boolean update(State state) {

        final String sql = "UPDATE state SET "
                + "name = ?, "
                + "abbr = ? "
                + "WHERE stateId = ?;";

        return jdbcTemplate.update(sql,
                state.getName(),
                state.getAbbr(),
                state.getStateId()) > 0;
    }

    public boolean deleteById(int id) {
        final String sql = "DELETE FROM state WHERE stateId = ?;";
        return jdbcTemplate.update(sql, id) > 0;
    }
    
     private static final class StateMapper implements RowMapper<State> {

        @Override
        public State mapRow(ResultSet rs, int index) throws SQLException {
            State state = new State();
            state.setName(rs.getString("name"));
            state.setAbbr(rs.getString("abbr"));
            state.setStateId(rs.getInt("stateId"));
            return state;
        }
    }
}
