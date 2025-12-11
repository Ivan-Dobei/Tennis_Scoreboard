package org.tennisApp.util;

import jakarta.servlet.http.HttpServletResponse;
import org.tennisApp.DTO.ErrorMessage;
import org.tennisApp.mapper.JsonMapper;

import java.io.PrintWriter;

public class ErrorResponseUtil {

    public static void handleError(PrintWriter writer, HttpServletResponse response, String message, int status) {
        ErrorMessage errorMessage = new ErrorMessage(message);

        writer.write(JsonMapper.toJson(errorMessage));
        response.setStatus(status);
    }
}
