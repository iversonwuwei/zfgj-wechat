package com.dlfc.services.load.service;

/**
 * Created by K on 2017/6/8.
 */
public interface UploadService<T> {
    String upload(T t, int type);

    String validate(T t, int type);
}
