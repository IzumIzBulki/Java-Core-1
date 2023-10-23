package org.example.model;

import java.util.List;

public class RepositoryJSON implements Repository{

    private NotesMapper mapper = new NotesMapperJSON();
    private FileOperate fileOperate;

    public RepositoryJSON(NotesMapper mapper, FileOperate fileOperate) {
        this.mapper = mapper;
        this.fileOperate = fileOperate;
    }

    public RepositoryJSON(FileOperate fileOperate) {
        this(new NotesMapperJSON(), fileOperate);
    }

    @Override
    public List<Notes> getAllNotes() throws Exception {
        String text = fileOperate.readText();
        List<Notes> notes = mapper.map(text);
        return notes;
    }

    @Override
    public String createNotes(Notes notes) throws Exception {
        List<Notes> note = getAllNotes();
        int maxId = 0;
        for (Notes currentNotes : note) {
            int id = Integer.parseInt(currentNotes.getId());
            if (maxId < id){
                maxId = id;
            }
        }
        int newId = maxId + 1;
        String id = String.format("%d", newId);
        notes.setId(id);
        note.add(notes);

        String text = mapper.map(note);
        fileOperate.saveText(text);
        return id;
    }

    @Override
    public void updateNotes(Notes notes, Fields field, Object param) throws Exception {
        if (field == Fields.HEAD){
            notes.setHead((String) param);
        } else if (field == Fields.TEXT) {
            notes.setText((String) param);
        }
        saveNotes(notes);
    }

    @Override
    public void deleteNotes(Notes notes) throws Exception {
        List<Notes> list = getAllNotes();
        int findIndex = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(notes.getId())){
                findIndex = i;
                break;
            }
        }
        if (findIndex > -1){
            list.remove(findIndex);
        }
        String text = mapper.map(list);
        fileOperate.saveText(text);
    }

    @Override
    public void saveNotes(Notes notes) throws Exception {
        if (notes == null){
            return;
        }
        List<Notes> list = getAllNotes();
        for (int i = 0; i < list.size(); i++) {
            Notes currentNote = list.get(i);
            if (currentNote.getId().equals(notes.getId())){
                list.set(i, notes);
                break;
            }
        }

        String text = mapper.map(list);
        fileOperate.saveText(text);
    }
}
