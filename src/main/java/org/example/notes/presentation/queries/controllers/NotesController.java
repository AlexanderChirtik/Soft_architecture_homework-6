package org.example.notes.presentation.queries.controllers;

import org.example.notes.core.application.interfaces.INoteEditor;
import org.example.notes.core.domain.Note;

public class NotesController extends Controller{

    private final INoteEditor noteEditor;

    public NotesController(INoteEditor noteEditor) {
        this.noteEditor = noteEditor;
    }

    public void routeAddNote(Note note){
        this.noteEditor.add(note);
    }

    public void routeGetAll(){
        this.noteEditor.getAll();
    }

    public void routeRemoveNote(Note note){
        this.noteEditor.remove(note);
    }
}
