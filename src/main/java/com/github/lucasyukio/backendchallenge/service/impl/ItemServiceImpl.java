package com.github.lucasyukio.backendchallenge.service.impl;

import com.github.lucasyukio.backendchallenge.dto.request.ItemRequest;
import com.github.lucasyukio.backendchallenge.model.Item;
import com.github.lucasyukio.backendchallenge.model.Pedido;
import com.github.lucasyukio.backendchallenge.repository.ItemRepository;
import com.github.lucasyukio.backendchallenge.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void salvarItens(Pedido pedido, List<ItemRequest> itensRequest) {
        for(ItemRequest itemRequest : itensRequest)
            itemRepository.save(new Item(itemRequest.getDescricao(), itemRequest.getPrecoUnitario(),
                    itemRequest.getQtd(), pedido));
    }

}
