package com.github.lucasyukio.backendchallenge.service;

import com.github.lucasyukio.backendchallenge.dto.request.ItemRequest;
import com.github.lucasyukio.backendchallenge.model.Pedido;

import java.util.List;

public interface ItemService {

    void salvarItens(Pedido pedido, List<ItemRequest> itensRequest);

}
