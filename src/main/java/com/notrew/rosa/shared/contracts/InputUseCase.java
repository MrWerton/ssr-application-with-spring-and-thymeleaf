package com.notrew.rosa.shared.contracts;

public interface DefaultUseCase<In, Out> {
    Out call(In data);
}
