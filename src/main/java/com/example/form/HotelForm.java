package com.example.form;

import javax.validation.constraints.Pattern;

public class HotelForm {
	@Pattern(regexp = "\\d{0,6}", message = "金額は0〜100万円未満の間で入力してください")
	private String price;

	public Integer getIntPrice() {
		return Integer.parseInt(price);
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
