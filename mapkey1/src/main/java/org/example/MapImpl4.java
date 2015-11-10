package org.example;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.checkerframework.checker.nullness.qual.KeyFor;
import org.checkerframework.checker.nullness.qual.Nullable;

public class MapImpl4 implements Map<String, String> {
	private final Map<String, String> delegate = new HashMap<>();

	@Override
	public Set<@KeyFor({"this", "this.delegate"}) String> keySet() {
		return delegate.keySet();
	}

	@Override
	public Set<Map.Entry<@KeyFor({"this", "this.delegate"}) String, String>> entrySet() {
		return delegate.entrySet();
	}



	// Other methods (not relevant)
	@Override
	public int size() {
		return delegate.size();
	}

	@Override
	public boolean isEmpty() {
		return delegate.isEmpty();
	}

	@Override
	public boolean containsKey(@Nullable Object key) {
		return delegate.containsKey(key);
	}

	@Override
	public boolean containsValue(@Nullable Object value) {
		return delegate.containsValue(value);
	}

	@Override
	public @Nullable String get(@Nullable Object key) {
		return delegate.get(key);
	}

	@Override
	public @Nullable String put(String key, String value) {
		return delegate.put(key, value);
	}

	@Override
	public @Nullable String remove(@Nullable Object key) {
		return delegate.remove(key);
	}

	@Override
	public void putAll(Map<? extends String, ? extends String> m) {
		delegate.putAll(m);
	}

	@Override
	public void clear() {
		delegate.clear();
	}

	@Override
	public Collection<String> values() {
		return delegate.values();
	}
}
