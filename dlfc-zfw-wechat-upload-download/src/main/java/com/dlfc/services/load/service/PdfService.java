package com.dlfc.services.load.service;

import com.dlfc.services.load.dto.ContractDTO;

/**
 * Created by K on 6/28/17.
 */
public interface PdfService {
    String generate(ContractDTO contractDTO);
}
