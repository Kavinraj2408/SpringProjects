package com.kavindev.springjdbc.dao;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kavindev.springjdbc.entity.Alien;

@Repository
public class AlienDAO {
	
	private JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public void save(Alien alien) {
		String sql = "insert into alien (id, name, tech) values (?,?,?)";
		int rows = template.update(sql,alien.getId(),alien.getName(),alien.getTech());
		System.out.println(rows);
	}
	
	public List<Alien> getAllAliens(){
		String sql = "select * from alien";
		RowMapper<Alien> map = (rs, rowNum) -> {
				Alien alien = new Alien();
				alien.setId(rs.getInt(1));
				alien.setName(rs.getString(2));
				alien.setTech(rs.getString(3));
				
				return alien;
			};
		List<Alien> list = template.query(sql, map);
		return list;
	}
}
