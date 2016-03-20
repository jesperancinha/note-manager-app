package com.steelzack.titletextadder.service;

import com.steelzack.titletextadder.dao.TitleDao;
import com.steelzack.titletextadder.model.Title;

public class TitleService {
	private static TitleDao titleDao;

	public TitleService() {
		titleDao = new TitleDao();
	}

	public void persist(Title entity) {
		titleDao.openCurrentSessionwithTransaction();
		titleDao.persist(entity);
		titleDao.closeCurrentSessionwithTransaction();
	}

	public void update(Title entity) {
		titleDao.openCurrentSessionwithTransaction();
		titleDao.update(entity);
		titleDao.closeCurrentSessionwithTransaction();
	}

	public void delete(Title title) {
		titleDao.openCurrentSessionwithTransaction();
		titleDao.delete(title);
		titleDao.closeCurrentSessionwithTransaction();
	}

	public TitleDao titleDao() {
		return titleDao;
	}
}
