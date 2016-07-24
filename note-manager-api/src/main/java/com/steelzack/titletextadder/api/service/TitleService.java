package com.steelzack.titletextadder.api.service;

import com.steelzack.titletextadder.api.dao.TitleDao;
import com.steelzack.titletextadder.api.model.TitleEntity;

/**
 * Created by joaofilipesabinoesperancinha on 05-04-16.
 */
public interface TitleService {
    void persist(TitleEntity entity);

    void update(TitleEntity entity);

    void delete(TitleEntity titleEntity);

    TitleDao titleDao();
}
