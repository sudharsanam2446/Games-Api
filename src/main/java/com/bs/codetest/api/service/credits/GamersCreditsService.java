package com.bs.codetest.api.service.credits;

import com.bs.codetest.api.exception.RecoverableException;
import com.bs.codetest.api.model.GamersCredits;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

import java.util.List;
import java.util.Optional;

public interface GamersCreditsService {

    @Retryable(
            maxAttempts=3,
            value= RecoverableException.class,
            backoff = @Backoff(
                    delay = 3000,
                    multiplier = 2,
                    maxDelay = 9000
            )
    )
    GamersCredits persistCreditInfo(GamersCredits gamersCredits);

    Optional<List<GamersCredits>> getGamersMaxCreditByLevel(String levelId);

    @Recover
    public GamersCredits recoveryHook(RecoverableException e, GamersCredits gamersCredits);


}
