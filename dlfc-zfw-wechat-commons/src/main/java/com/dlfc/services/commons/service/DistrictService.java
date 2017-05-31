package com.dlfc.services.commons.service;

import java.util.List;

public interface DistrictService<T> {

    List<T> findAll();

    List<T> findBy(Object obj);
}
