import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender

import java.nio.charset.Charset

import static ch.qos.logback.classic.Level.DEBUG
import static ch.qos.logback.classic.Level.INFO


def defaultCharset = Charset.forName("UTF-8")

appender("STDOUT", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        charset = defaultCharset
        pattern = "%d{HH:mm:ss.SSS} [%thread] %-5level %logger{5} - %msg%n"
    }
}

logger("com.test.testproject", INFO)
root(INFO, ["STDOUT"])