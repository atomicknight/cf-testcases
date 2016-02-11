package org.example;

import org.checkerframework.checker.nullness.qual.Nullable;

public class ResultWrapper<T> {
	private @Nullable T result = null;

	private T getResult() {
		return result;
	}
}
