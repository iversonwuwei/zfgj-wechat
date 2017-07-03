package com.dlfc.services.collect.convertor;

import com.dlfc.services.collect.dto.CollectDTO;
import com.dlfc.zfw.wechat.entities.entity.UsrHouCollection;
import com.housecenter.dlfc.commons.bases.convertor.AbstractConvertor;
import org.springframework.stereotype.Component;

/**
 * Created by walden on 17-6-28.
 */
@Component
public class CollectConvertor extends AbstractConvertor<UsrHouCollection, CollectDTO> {
    @Override
    public UsrHouCollection toModel(CollectDTO collectDTO) {
        return null;
    }

    @Override
    public CollectDTO toDTO(UsrHouCollection s, Object... objects) {
        CollectDTO collectDTO = new CollectDTO();
        collectDTO.setUid(s.getUid());
        collectDTO.setHid(s.getHid());
        if (objects.length > 0) {
            collectDTO.setId((String) objects[0]);
        }
        return collectDTO;
    }
}
