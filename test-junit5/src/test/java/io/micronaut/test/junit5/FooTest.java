package io.micronaut.test.junit5;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import jakarta.inject.Singleton;
import java.util.stream.Stream;

@MicronautTest(resolveParameters = false)
class FooTest {
    static Stream<Arguments> fooArgs() {
        return Stream.of(Arguments.of(new Foo()));
    }

    @ParameterizedTest
    @MethodSource("fooArgs")
    void foo(Foo arg) { // <1>
        Assertions.assertNotNull(arg);
    }

    @Test
    @Disabled("Doesn't work with resolverParameters set to false") // <2>
    void bar(Foo arg) {
        Assertions.assertNotNull(arg);
    }

    @Singleton
    static class Foo {
    }
}

