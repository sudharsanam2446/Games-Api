package com.bs.codetest.api.util;

import com.bs.codetest.api.exception.InvalidRequestBodyException;
import com.bs.codetest.api.model.GamersInfo;
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
    }
}
