package com.example.onlinestore.service;

import com.example.onlinestore.component.Basket;
import com.example.onlinestore.model.Item;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StoreService {

    private final Map<Integer, Item> items = new HashMap<>();
    private final Basket basket;

    public StoreService(Basket basket) {
        this.basket = basket;
    }

    @PostConstruct
            public void init(){
        items.put(1, new Item(1, "Аквариумный фильтр", 3000));
        items.put(1, new Item(1, "Сухой корм для рыб", 500));
        items.put(1, new Item(1, "Декор Замок", 5000));
        items.put(1, new Item(1, "Лампа для аквариума", 1000));
        items.put(1, new Item(1, "Замороженный мотыль", 100));
    }

    public List<Item> get(){
        return basket.get();

    }

    public void add(List<Integer> ids) {
        basket.add(
                ids.stream()
                        .map(items::get)
                        .collect(Collectors.toList())
        );
    }
}
