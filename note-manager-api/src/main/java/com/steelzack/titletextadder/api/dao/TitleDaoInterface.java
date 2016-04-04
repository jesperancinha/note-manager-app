package com.steelzack.titletextadder.api.dao;

public interface TitleDaoInterface<T> {

	public void persist(T entity);

	public void update(T entity);

	public void delete(T entity);

}