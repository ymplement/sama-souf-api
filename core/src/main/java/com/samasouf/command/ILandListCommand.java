package com.samasouf.command;

import com.samasouf.criteria.LandCriteria;
import com.samasouf.dto.response.LandListResponse;

public interface ILandListCommand {
    LandListResponse execute(LandCriteria criteria);
}
