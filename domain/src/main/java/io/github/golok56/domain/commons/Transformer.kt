package io.github.golok56.domain.commons

import io.reactivex.SingleTransformer

abstract class Transformer<T> : SingleTransformer<T, T>