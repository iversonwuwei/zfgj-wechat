package com.dlfc.services.load.service;

import java.io.IOException;

/**
 * Created by K on 2017/5/5.
 */
public interface ImageService {
    String generateLeaseImage(String srcFilePath, int wmType) throws IOException;
}
