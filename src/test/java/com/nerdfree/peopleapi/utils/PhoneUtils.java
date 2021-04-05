package com.nerdfree.peopleapi.utils;

import com.nerdfree.peopleapi.enums.PhoneType;
import com.nerdfree.peopleapi.model.Phone;

public class PhoneUtils {

	private final static long PHONE_ID = 1L;
	private final static PhoneType PHONE_TYPE = PhoneType.MOBILE;
	private final static String PHONE_NUMBER = "75983101948";

	public static Phone criarTelefoneFake() {

		return Phone.builder()
				.id(PHONE_ID)
				.type(PHONE_TYPE)
				.number(PHONE_NUMBER)
				.build();
	}

}
