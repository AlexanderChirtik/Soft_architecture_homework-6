package org.example.notes.presentation.queries.views;

import org.example.notes.core.application.interfaces.INotesPresenter;
import org.example.notes.core.domain.Note;

import java.util.Collection;

public class NotesConsolePresenter implements INotesPresenter {
    @Override
    public void printAll(Collection<Note> notes) {
        for (Note note: notes){
            System.out.println(note);
        }
    }
}
