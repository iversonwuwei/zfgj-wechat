package com.dlfc.services.feedback.dto;


import com.housecenter.dlfc.commons.bases.dto.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedbackDTO extends AbstractDTO {

    private String feedback;

    private String uid;

    private String name;

    private String phoneNumber;

    private String ip;
}
