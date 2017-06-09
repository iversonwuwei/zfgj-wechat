package com.dlfc.services.load.service;

import java.io.IOException;

/**
 * Created by K on 2017/6/9.
 */
public interface ClassfyUploadService<T> {

    Object upload(T t) throws IOException;
}
