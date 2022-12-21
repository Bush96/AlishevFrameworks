package com.example.FirstRESTApp.util;

//бьекты этого класса будут отправляться в случаи если клиент запросит человека которого в бд не существует
public class PersonErrorResponse {
    private String message;
    private long timestamp;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public PersonErrorResponse(String message, long timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }
}
