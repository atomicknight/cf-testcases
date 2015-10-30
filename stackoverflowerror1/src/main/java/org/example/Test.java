package org.example;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import org.checkerframework.checker.nullness.qual.Nullable;

public class Test<M> {
	// Okay
	public Test(@Nullable List<M> list) {
		if (list instanceof ArrayList<?>) {
		}
	}

	// Fails with StackOverflowError
	public Test(@Nullable AbstractList<M> list) {
		if (list instanceof ArrayList<?>) {
		}
	}
}
