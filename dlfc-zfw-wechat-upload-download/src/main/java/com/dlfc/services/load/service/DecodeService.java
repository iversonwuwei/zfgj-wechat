package com.dlfc.services.load.service;

import java.io.IOException;

/**
 * Created by K on 7/1/17.
 */
public interface DecodeService {
    void decode(String filePath, String fileCode) throws IOException;
}
