package com.hunsley.mongo.api;

import com.atlassian.oai.validator.report.ValidationReport;
import com.atlassian.oai.validator.springmvc.InvalidRequestException;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

  @ExceptionHandler(InvalidRequestException.class)
  public ResponseEntity<ErrorValidationReport> handle(final InvalidRequestException invalidRequestException) {
    final ErrorValidationReport report = new ErrorValidationReport(invalidRequestException
        .getValidationReport().getMessages());
    return new ResponseEntity<>(report, HttpStatus.BAD_REQUEST);
  }

  public static class ErrorValidationReport {
    private String errorDescription = "";

    public ErrorValidationReport(final List<ValidationReport.Message> messages) {
      StringBuilder builder = new StringBuilder();
      for (ValidationReport.Message msg  :messages) {
        builder.append(msg.getMessage()).append("\n");
      }

      errorDescription = builder.toString();
    }

    public String getErrorDescription() {
      return errorDescription;
    }
  }
}
