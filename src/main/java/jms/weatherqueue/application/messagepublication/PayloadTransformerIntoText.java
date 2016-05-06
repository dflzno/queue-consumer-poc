package jms.weatherqueue.application.messagepublication;

import java.util.Optional;
import java.util.function.Function;

public interface PayloadTransformerIntoText<T> extends Function<T, Optional<String>> {

}
