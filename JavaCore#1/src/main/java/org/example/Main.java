package org.example;

import org.example.ctrl.NotesCtrl;
import org.example.model.*;
import org.example.view.ViewingNotes;

public class Main {
    public static void main(String[] args) {
        FileOperate fileOperate = new FileOperateJSON("notes.txt");
        Repository repository = new RepositoryJSON(new NotesMapperJSON(), fileOperate);
        NotesCtrl ctrl = new NotesCtrl(repository);
        ViewingNotes viewing = new ViewingNotes(ctrl);
        viewing.run();
    }
}
