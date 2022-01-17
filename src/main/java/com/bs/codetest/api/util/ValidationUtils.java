package com.bs.codetest.api.util;

import com.bs.codetest.api.exception.InvalidRequestBodyException;
import com.bs.codetest.api.model.GamersInfo;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidationUtils {

    private static final Logger logger = LoggerFactory.getLogger(ValidationUtils.class);

    private ValidationUtils() {
    }

    public static void validateGamersRequest(GamersInfo gamersInfo) {
        //todo: add to constants
        if(StringUtils.isBlank(gamersInfo.getName())) {
            logger.error("Missing name property in the request");
            throw new InvalidRequestBodyException("Missing name property in the request");
        }

        if(null != gamersInfo.getGender() && !EnumUtils.isValidEnum(Gender.class, gamersInfo.getGender())) {
            logger.error("Missing name property in the request");
            throw new InvalidRequestBodyException("Missing or Invalid Gender property in the request");
        }

        if(null != gamersInfo.getGeo() && !EnumUtils.isValidEnum(Geo.class, gamersInfo.getGeo())) {
            logger.error("Missing Geo property in the request");
            throw new InvalidRequestBodyException("Missing or Invalid Geo property in the request");
        }
    }
}
