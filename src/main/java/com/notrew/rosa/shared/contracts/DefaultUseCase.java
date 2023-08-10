package com.notrew.rosa.shared.contracts;

public interface UseCase<In, Out> {
    Out call(In data);
}
