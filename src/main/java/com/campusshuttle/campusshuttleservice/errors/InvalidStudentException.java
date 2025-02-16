package com.campusshuttle.campusshuttleservice.errors;

// Extending RuntimeException to make it an unchecked exception
public class InvalidStudentException extends RuntimeException {

    // Default constructor
    public InvalidStudentException() {
        super();
    }

    // Constructor with a custom message
    public InvalidStudentException(String message) {
        super(message);
    }

    // Constructor with a custom message and a cause
    public InvalidStudentException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor with only a cause
    public InvalidStudentException(Throwable cause) {
        super(cause);
    }
}


// package errors;

// public class InvalidStudentException extends Exception {

//     // Default constructor
//     public InvalidStudentException() {
//         super();
//     }

//     // Constructor with a custom message
//     public InvalidStudentException(String message) {
//         super(message);
//     }

//     // Constructor with a custom message and a cause
//     public InvalidStudentException(String message, Throwable cause) {
//         super(message, cause);
//     }

//     // Constructor with only a cause
//     public InvalidStudentException(Throwable cause) {
//         super(cause);
//     }

//     // Constructor with advanced options
//     protected InvalidStudentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
//         super(message, cause, enableSuppression, writableStackTrace);
//     }
// }
