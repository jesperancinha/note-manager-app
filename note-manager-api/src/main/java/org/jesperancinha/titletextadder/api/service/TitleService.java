package org.jesperancinha.titletextadder.api.service;

import org.jesperancinha.titletextadder.api.dao.TitleDao;
import org.jesperancinha.titletextadder.api.model.TitleEntity;

/**
 * Created by joaofilipesabinoesperancinha on 05-04-16.
 */
public interface TitleService {
    void persist(TitleEntity entity);

    void update(TitleEntity entity);

    void delete(TitleEntity titleEntity);

    TitleDao titleDao();
}
