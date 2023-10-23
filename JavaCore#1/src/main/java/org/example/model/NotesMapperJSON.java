package org.example.model;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotesMapperJSON implements NotesMapper{

    @Override
    public String map(List<Notes> list) {
        List<Map> result = new ArrayList<>();
        Gson gson = new Gson();

        for (Notes notes : list) {
            Map map = new HashMap<>();
            map.put("id", notes.getId());
            map.put("head", notes.getHead());
            map.put("text", notes.getText());
            result.add(map);
        }
        return gson.toJson(result);
    }

    @Override
    public List<Notes> map(String text) throws Exception{
        Gson gson = new Gson();
        List<Notes> list = new ArrayList<>();
        List<Map> listGSON = null;

        try {
            listGSON = gson.fromJson(text, ArrayList.class);

            if (listGSON == null) {
                return  list;
            }

            for (Map map : listGSON) {
                String id = (String) map.get("id");
                String head = (String) map.get("head");
                String textNote = (String) map.get("text");

                Notes notes = new Notes(id, head, textNote);
                list.add(notes);
            }
        } catch (Exception e) {
            throw new Exception("Invalid file");
        }

        return list;
    }
}
