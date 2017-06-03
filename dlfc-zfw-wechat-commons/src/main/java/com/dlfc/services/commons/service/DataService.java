package com.dlfc.services.commons.service;

import java.util.List;

/**
 * Created by K on 2017/6/2.
 */
public interface DataService<T> {

    List<T> findBy(String param);

    List<T> findAll();
}
