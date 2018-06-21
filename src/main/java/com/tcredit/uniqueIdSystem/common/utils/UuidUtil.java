package com.tcredit.uniqueIdSystem.common.utils;

import java.util.UUID;

public final class UuidUtil {

	// 生成UUID
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
//		String s = UUID.randomUUID().toString();
//		// 去掉“-”符号
//		return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);

	}
}
