package org.jesperancinha.titletextadder.api.service;

import org.jesperancinha.titletextadder.api.dao.TitleDao;
import org.jesperancinha.titletextadder.api.model.TitleEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("titleService")
@Component
public class TitleServiceImpl {
	private static TitleDao titleDao;

	public TitleServiceImpl() {
		titleDao = new TitleDao();
	}

	public void persist(TitleEntity entity) {
		titleDao.persist(entity);
	}

	public void update(TitleEntity entity) {
		titleDao.update(entity);
	}

	public void delete(TitleEntity titleEntity) {
		titleDao.delete(titleEntity);
	}

	public TitleDao titleDao() {
		return titleDao;
	}
}
