package com.dlfc.services.house.convertor.base;

import com.housecenter.dlfc.commons.bases.dto.ListResultDTO;
import com.housecenter.dlfc.commons.exception.CustomRuntimeException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractConvertor<Entity, DTO> {

    public final List<DTO> toResultDTO(List<Entity> modelList) throws CustomRuntimeException {
        List<DTO> dtoList = this.toListDTO(modelList);
        return dtoList;
    }

    public final List<DTO> toListDTO(List<Entity> modelList) {
        List<DTO> dtoList = this.toDtoList(modelList);
        return dtoList;
    }

    public abstract Entity toModel(DTO var1);

    public DTO toDTO(Entity model) {
        return this.toDTO(model, "");
    }

    public abstract DTO toDTO(Entity var1, Object... var2);

    private final List<DTO> toDtoList(List<Entity> modelList) {
        List<DTO> dtoList = new ArrayList();
        Iterator i$ = modelList.iterator();

        while(i$.hasNext()) {
            Entity entity = (Entity) i$.next();
            dtoList.add(this.toDTO(entity, ""));
        }

        return dtoList;
    }
}
