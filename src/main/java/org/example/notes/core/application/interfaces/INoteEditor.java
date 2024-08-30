package org.example.notes.core.application.interfaces;

import org.example.notes.core.domain.Note;

public interface INoteEditor extends IEditor<Note, Integer> {

    void printAll();
}
