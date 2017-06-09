package com.dlfc.services.load.service;

import java.io.IOException;

/**
 * Created by K on 2017/6/8.
 */
public interface UploadService<T> {

    String validate(T t);

    String uploadTemp(T t) throws IOException;
}
