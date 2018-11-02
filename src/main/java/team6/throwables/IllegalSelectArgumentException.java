package team6.throwables;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "illegal select argument")
public class IllegalSelectArgumentException extends RuntimeException {
}
