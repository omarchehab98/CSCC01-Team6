package team6.throwables;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Report not found")

public class ReportNotFoundException extends RuntimeException{

}
