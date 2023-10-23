package org.example.model;

import java.util.List;

public interface NotesMapper {

    public String map(List<Notes> list);
    public List<Notes> map(String text) throws Exception;
}
