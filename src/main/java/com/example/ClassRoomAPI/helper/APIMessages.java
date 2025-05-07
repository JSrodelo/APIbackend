package com.example.ClassRoomAPI.helper;

public enum APIMessages {

    ERROR_USER_NOT_FOUND("El usuario buscado no está en la base de datos"),
    ERROR_TEACHER_NOT_FOUND("El profesor buscado no está en la base de datos"),
    ERROR_STUDENT_NOT_FOUND("El estudiante buscado no está en la base de datos"),
    ERROR_REGISTRATION_NOT_FOUND("La inscripción buscada no está en la base de datos"),
    ERROR_SUBJECT_NOT_FOUND("La asignatura buscada no está en la base de datos"),
    ERROR_QUALIFICATION_NOT_FOUND("La calificación buscada no está en la base de datos"),
    ERROR_COURSE_NOT_FOUND("El curso buscado no está en la base de datos"),
    ERROR_ATTENDANCE_NOT_FOUND("La asistencia buscada no está en la base de datos"),

    ;

    private String message;

    APIMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
