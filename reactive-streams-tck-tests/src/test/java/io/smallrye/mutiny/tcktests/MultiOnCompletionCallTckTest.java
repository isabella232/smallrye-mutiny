package io.smallrye.mutiny.tcktests;

import org.reactivestreams.Publisher;

import io.smallrye.mutiny.Uni;

public class MultiOnCompletionCallTckTest extends AbstractPublisherTck<Long> {

    @Override
    public Publisher<Long> createPublisher(long elements) {
        return upstream(elements)
                .onCompletion().call(() -> Uni.createFrom().nullItem());
    }

    @Override
    public Publisher<Long> createFailedPublisher() {
        return failedUpstream()
                .onCompletion().call(() -> Uni.createFrom().nullItem());
    }
}
