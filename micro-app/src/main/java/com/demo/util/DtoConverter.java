package com.demo.util;

import com.demo.dto.Currency;
import com.demo.entity.Devise;

public class DtoConverter {
	public static Currency deviseToCurrency(Devise d) {
		return new Currency(d.getCode(),d.getName(),d.getChange());
	}

}
