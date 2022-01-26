package com.bs.codetest.api.service.games;

import com.bs.codetest.api.exception.RecoverableException;
import com.bs.codetest.api.model.GameInfo;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

public interface GamesService {

    @Retryable(
            maxAttempts = 3,
            value = RecoverableException.class,
            backoff = @Backoff(
                    delay = 3000,
                    multiplier = 2,
                    maxDelay = 9000
            )
    )
    GameInfo persistGame(GameInfo gameInfo);

    @Recover
    public GameInfo recoveryHook(RecoverableException e, GameInfo gamersInfo);

}
