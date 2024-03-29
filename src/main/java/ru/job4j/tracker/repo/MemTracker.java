package ru.job4j.tracker.repo;

import ru.job4j.tracker.Item;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class MemTracker implements Store {
    private Connection cn;

    private List<Item> items = new ArrayList<>();
    private int ids = 1;

    public MemTracker() {
    }

    public MemTracker(Connection cn) {
        this.cn = cn;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findAll() {
        return List.copyOf(items);
    }

    public List<Item> findByName(String key) {
        List<Item> res = new ArrayList<>();
        for (Item i : items) {
            if (key.equals(i.getName())) {
                res.add(i);
            }
        }
        return res;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items.set(index, item);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items.remove(index);
        }
        return rsl;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }
}