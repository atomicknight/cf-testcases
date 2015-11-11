package org.example;

import org.checkerframework.checker.nullness.qual.Nullable;

public class Node<T> {
	private @Nullable T payload;

	public void clearPayload(Node node) {
		node.payload = null;
	}
}
