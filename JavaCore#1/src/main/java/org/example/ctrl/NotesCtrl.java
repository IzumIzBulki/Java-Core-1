package org.example.ctrl;

import org.example.model.Fields;
import org.example.model.Notes;
import org.example.model.Repository;

import java.util.List;

public class NotesCtrl {

    private final Repository repository;

    public NotesCtrl(Repository repository){
        this.repository = repository;
    }

    public void saveNotes(Notes notes) throws Exception{
        repository.createNotes(notes);
    }

    public void deleteNotes(String noteId) throws Exception{
        Notes noteFind = getNotesById(noteId);
        if (noteFind == null){
            throw new Exception("Note are not found");
        }
        repository.deleteNotes(noteFind);
    }

    public void updateNotes(Notes notes, Fields fields, Object param) throws Exception{
        repository.updateNotes(notes, fields, param);
    }

    public Notes readNotes(String noteId) throws Exception{
        Notes notesFind = getNotesById(noteId);
        if (notesFind == null){
            throw new Exception("Note is not found");
        }
        return notesFind;
    }

    public List<Notes> getNotes() throws Exception{
        return repository.getAllNotes();
    }

    public Notes getNotesById(String notesId) throws Exception{
        List<Notes> notes = repository.getAllNotes();
        Notes notesFind = null;
        for (Notes note : notes) {
            if (note.getId().equals(notesId)) {
                notesFind = note;
                break;
            }
        }
        return notesFind;
    }
}
