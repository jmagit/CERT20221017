package com.example.tipos;

import java.util.List;
import java.util.Optional;

public interface Repository<T, K> {

	List<T> getAll();

	Optional<T> getOne(K id);

	T add(T item);

	T modify(T item);

	void delete(T item);

	void deleteById(K id);

}