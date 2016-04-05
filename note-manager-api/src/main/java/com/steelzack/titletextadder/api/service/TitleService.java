package com.steelzack.titletextadder.api.service;

import com.steelzack.titletextadder.api.dao.TitleDao;
import com.steelzack.titletextadder.api.model.Title;

/**
 * Created by joaofilipesabinoesperancinha on 05-04-16.
 */
public interface TitleService {
    void persist(Title entity);

    void update(Title entity);

    void delete(Title title);

    TitleDao titleDao();
}
