package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Hotel;

@Repository
public class HotelRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;

	private final RowMapper<Hotel> HOTEL_ROW_MAPPER = (rs, i) -> {
		Hotel hotel = new Hotel();
		hotel.setId(rs.getInt("id"));
		hotel.setAreaName(rs.getString("area_name"));
		hotel.setHotelName(rs.getString("hotel_name"));
		hotel.setAddress(rs.getString("address"));
		hotel.setNearestStation(rs.getString("nearest_station"));
		hotel.setPrice(rs.getInt("price"));
		hotel.setParking(rs.getString("parking"));
		return hotel;
	};

	/**
	 * findByPriceメソッド 入力金額以下のホテル一覧を返すメソッド 検索結果なしの場合はnullを返す
	 * 
	 * @param price
	 * @return List<Hotel>
	 */
	public List<Hotel> findByPrice(Integer price) {
		String sql = "SELECT * FROM hotels WHERE price <= :price ORDER BY price";
		SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
		List<Hotel> hotelList = template.query(sql, param, HOTEL_ROW_MAPPER);
		return hotelList;

	}

	/**
	 * findAllメソッド
	 * 
	 * @return List<Hotel>
	 */
	public List<Hotel> findAll() {
		String sql = "SELECT * FROM hotels ORDER BY price";
		List<Hotel> hotelList = template.query(sql, HOTEL_ROW_MAPPER);
		return hotelList;

	}

}
