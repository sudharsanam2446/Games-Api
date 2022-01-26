package com.bs.codetest.api.service.gamers;

import com.bs.codetest.api.exception.RecoverableException;
import com.bs.codetest.api.model.GamersInfo;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

public interface GamersService {

    @Retryable(
            maxAttempts = 3,
            value = RecoverableException.class,
            backoff = @Backoff(
                    delay = 3000,
                    multiplier = 2,
                    maxDelay = 9000
            )
    )
    GamersInfo persistGamers(GamersInfo GamersInfo);

    @Recover
    public GamersInfo recoveryHook(RecoverableException e, GamersInfo gamersInfo);

}
