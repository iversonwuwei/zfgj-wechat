package com.dlfc.services.message.dto;

import com.housecenter.dlfc.commons.bases.dto.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MessageDTO extends AbstractDTO {

    private Short type;

    private String title;

    private String content;

    private Date date;
}
