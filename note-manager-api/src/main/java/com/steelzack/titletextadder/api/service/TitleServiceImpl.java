package com.steelzack.titletextadder.api.service;

import com.steelzack.titletextadder.api.dao.TitleDao;
import com.steelzack.titletextadder.api.model.Title;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("titleService")
@Component
public class TitleServiceImpl implements TitleService {
	private static TitleDao titleDao;

	public TitleServiceImpl() {
		titleDao = new TitleDao();
	}

	@Override
	public void persist(Title entity) {
		titleDao.persist(entity);
	}

	@Override
	public void update(Title entity) {
		titleDao.update(entity);
	}

	@Override
	public void delete(Title title) {
		titleDao.delete(title);
	}

	@Override
	public TitleDao titleDao() {
		return titleDao;
	}
}
