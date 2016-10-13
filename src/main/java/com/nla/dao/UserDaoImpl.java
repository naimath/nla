package com.nla.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nla.model.Person;

@Repository
public class UserDaoImpl implements UserDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public Person findByName(String name) {

		Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", name);

		String sql = "SELECT * FROM users WHERE name=:name";

        Person result = namedParameterJdbcTemplate.queryForObject(
                    sql,
                    params,
                    new PersonMapper());

        //new BeanPropertyRowMapper(Customer.class));

        return result;

	}

	@Override
	public List<Person> findAll() {

		Map<String, Object> params = new HashMap<String, Object>();

		String sql = "SELECT * FROM person";

        List<Person> result = namedParameterJdbcTemplate.query(sql, params, new PersonMapper());

        return result;

	}

	private static final class PersonMapper implements RowMapper<Person> {

		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setPhone(rs.getInt("phone"));
			person.setEmail(rs.getString("email"));
			return person;
		}
	}

}
