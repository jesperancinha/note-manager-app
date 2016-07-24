package com.steelzack.titletextadder.api.service;

import com.steelzack.titletextadder.api.dao.TitleDao;
import com.steelzack.titletextadder.api.model.TitleEntity;
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
	public void persist(TitleEntity entity) {
		titleDao.persist(entity);
	}

	@Override
	public void update(TitleEntity entity) {
		titleDao.update(entity);
	}

	@Override
	public void delete(TitleEntity titleEntity) {
		titleDao.delete(titleEntity);
	}

	@Override
	public TitleDao titleDao() {
		return titleDao;
	}
}
