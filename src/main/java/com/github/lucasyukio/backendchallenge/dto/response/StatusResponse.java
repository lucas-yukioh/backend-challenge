package com.github.lucasyukio.backendchallenge.dto.response;

import com.github.lucasyukio.backendchallenge.shared.Status;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public class StatusResponse {

    private String pedido;
    private List<Status> status;

    public StatusResponse(String pedido, List<Status> status) {
        this.pedido = pedido;
        this.status = status;
    }

    public StatusResponse(String pedido, Status status) {
        this.pedido = pedido;
        this.status = Arrays.asList(status);
    }

}
