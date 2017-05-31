package com.dlfc.services.commons.service;

import java.util.List;

public interface AreaService<T> {

    List<T> findAll();

    List<T> findBy(Object object);
}
