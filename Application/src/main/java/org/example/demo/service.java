package org.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class service{
    private List<String> dataList = new ArrayList<>();

    public List<String> getAllData() {
        return dataList;
    }

    public String getDataById(int id) {
        if (id >= 0 && id < dataList.size()) {
            return dataList.get(id);
        }
        return null;
    }

    public void addData(String data) {
        dataList.add(data);
    }

    public void updateData(int id, String data) {
        if (id >= 0 && id < dataList.size()) {
            dataList.set(id, data);
        }
    }

    public void deleteData(int id) {
        if (id >= 0 && id < dataList.size()) {
            dataList.remove(id);
        }
    }
}