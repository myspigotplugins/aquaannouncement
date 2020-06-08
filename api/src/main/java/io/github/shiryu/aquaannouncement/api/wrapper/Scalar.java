package io.github.shiryu.aquaannouncement.api.wrapper;

import org.jetbrains.annotations.NotNull;

public interface Scalar<T> {

    @NotNull
    T value();
}
