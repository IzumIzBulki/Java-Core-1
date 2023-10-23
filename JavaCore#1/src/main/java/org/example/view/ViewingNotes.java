package org.example.view;

import org.example.ctrl.NotesCtrl;
import org.example.model.Fields;
import org.example.model.Notes;

import java.util.List;
import java.util.Scanner;

public class ViewingNotes {

    private final NotesCtrl notesCtrl;
    public ViewingNotes(NotesCtrl notesCtrl) {
        this.notesCtrl = notesCtrl;
    }
    public void run(){
        boolean isContinue = true;
        showHelp();
        while (isContinue){
            try{
                String command = prompt("Enter the command: ");
                Commands com = Commands.valueOf(command.toUpperCase());
                if (com == Commands.EXIT){
                    isContinue = false;
                    continue;
                }

                switch (com) {
                    case CREATE:
                        create();
                        break;
                    case READ:
                        read();
                        break;
                    case UPDATE:
                        update();
                        break;
                    case LIST:
                        list();
                        break;
                    case HELP:
                        showHelp();
                        break;
                    case DELETE:
                        delete();
                        break;
                }
            } catch (Exception e){
                System.out.println("Error!");
            }
        }
    }

    private void create() throws Exception{
        String head = prompt("Headline: ");
        String text = prompt("Text: ");
        Notes note = new Notes(head, text);
        notesCtrl.saveNotes(note);
    }

    private void read() throws Exception {
        String id = prompt("ID of the note: ");
        Notes note = notesCtrl.readNotes(id);
        System.out.println(note);
    }

    private void update() throws Exception {
        String id = prompt("ID of the note: ");
        String fieldName = prompt("Select field (HEAD, TEXT): ");
        String param = prompt("Input your changes: ");
        Notes note = notesCtrl.readNotes(id);
        notesCtrl.updateNotes(note, Fields.valueOf(fieldName.toUpperCase()), param);
    }

    private void list() throws Exception{
        List<Notes> notesList = notesCtrl.getNotes();
        for (Notes note : notesList) {
            System.out.println(note);
        }
    }

    private void showHelp() {
        System.out.println("Commands: ");
        for (Commands c : Commands.values()) {
            System.out.println(c);
        }
    }

    private void delete() throws Exception{
        String id = prompt("ID of the note: ");
        notesCtrl.deleteNotes(id);
    }

    private String prompt(String message){
        Scanner in = new Scanner(System.in);
        System.out.println(message);
        return  in.nextLine();
    }



}
