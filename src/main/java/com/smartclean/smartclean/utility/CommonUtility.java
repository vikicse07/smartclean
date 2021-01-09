package com.smartclean.smartclean.utility;

import java.util.UUID;

public class CommonUtility {
	private CommonUtility() {
	}

	public static String getUniqueId() {
		UUID uuid = UUID.randomUUID();

		return uuid.toString();
	}
}
