package com.bs.codetest.api.service.base;

import com.bs.codetest.api.exception.NonRecoverableException;
import com.bs.codetest.api.exception.RecoverableException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.ConcurrencyFailureException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.RecoverableDataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.transaction.TransactionException;

public interface BaseServiceDelegateInterface<M> {

    Logger logger = LoggerFactory.getLogger(BaseServiceDelegateInterface.class);

     default M processEntity(M modelClass, String entityName) {
        try {
            logger.info("Going to process the entity {} ", entityName);
            return persistMessage(modelClass);
        } catch (CannotGetJdbcConnectionException | RecoverableDataAccessException | ConcurrencyFailureException | TransactionException recoverable) {
            logger.warn("Connection to the database failed, while processing the entity {}. No worries it will be retried !", entityName);
            throw new RecoverableException("Connection to the database failed, while processing the event. No worries it will be retried !", recoverable);
        } catch (DataAccessException nonRecoverable) {
            logger.error("Failed while trying to update the database for the entity {} ", entityName);
            throw new NonRecoverableException("Failed while trying to update the database for the  event", nonRecoverable);

        }
    }

    M persistMessage(M modelClass);

}
