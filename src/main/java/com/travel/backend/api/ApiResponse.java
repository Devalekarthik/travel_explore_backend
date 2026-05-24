package com.travel.backend.api;

import java.time.Instant;

public record ApiResponse<T>(
	boolean success,
	String message,
	Instant timestamp,
	T data
) {
	public static <T> ApiResponse<T> ok(String message, T data) {
		return new ApiResponse<>(true, message, Instant.now(), data);
	}

	public static <T> ApiResponse<T> ok(T data) {
		return ok("OK", data);
	}
}

