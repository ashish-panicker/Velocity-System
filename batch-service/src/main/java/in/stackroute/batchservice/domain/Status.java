package in.stackroute.batchservice.domain;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {
    ACTIVE("active"), COMPLETED("completed"), SUSPENDED("suspended");

    private String status;

    private Status(String status) {
        this.status = status;
    }

    @JsonValue
    public String getStatus() {
        return status;
    }
}
