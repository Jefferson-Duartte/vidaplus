package com.jefferson.vidaplus.exceptions;

import java.time.LocalDateTime;

public record ExceptionResponse (LocalDateTime timestamp, String message, String path, int statusCode) {}