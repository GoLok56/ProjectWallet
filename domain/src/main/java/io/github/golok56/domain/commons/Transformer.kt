package io.github.golok56.domain.commons

import io.reactivex.ObservableTransformer

abstract class Transformer<T> : ObservableTransformer<T, T>