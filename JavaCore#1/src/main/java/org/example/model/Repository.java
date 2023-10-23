package org.example.model;

import java.util.List;

public interface Repository {

    List<Notes> getAllNotes() throws Exception;
    String createNotes(Notes notes) throws Exception;
    void updateNotes(Notes notes, Fields field, Object param) throws Exception;
    void deleteNotes(Notes notes) throws Exception;
    void saveNotes(Notes notes) throws Exception;
}
