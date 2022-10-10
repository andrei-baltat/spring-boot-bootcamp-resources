package com.ltp.globalsuperstore.services;

import com.ltp.globalsuperstore.Constants;
import com.ltp.globalsuperstore.Item;
import com.ltp.globalsuperstore.repository.ItemRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ItemService {

    ItemRepository itemRepository = new ItemRepository();

    public Item getItem(int index) {
        return itemRepository.getItem(index);
    }

    public void addItem(Item item) {
        itemRepository.addItem(item);
    }

    public void updateItem(int index, Item item) {
        itemRepository.setItem(index, item);
    }


    public int getIndexFromId(String id) {
        for (int i = 0; i < itemRepository.getItems().size(); i++) {
            if (itemRepository.getItem(i).getId().equals(id)) return i;
        }
        return Constants.NOT_FOUND;
    }

    public boolean within5Days(Date newDate, Date oldDate) {
        long diff = Math.abs(newDate.getTime() - oldDate.getTime());
        return (int) (TimeUnit.MILLISECONDS.toDays(diff)) <= 5;
    }

    public Item getAttributeValue(int index) {
        return index == Constants.NOT_FOUND ? new Item() : this.getItem(index);
    }

    public String getStatus(Item item, int index) {
        String status = Constants.SUCCESS_STATUS;
        if (index == Constants.NOT_FOUND) {
            this.addItem(item);
        } else if (this.within5Days(item.getDate(), this.getItem(index).getDate())) {
            this.updateItem(index, item);
        } else {
            status = Constants.FAILED_STATUS;
        }
        return status;
    }
}
