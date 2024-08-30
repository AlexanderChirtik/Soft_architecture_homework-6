package org.example.notes.core.application.interfaces;

import org.example.notes.core.domain.Note;

import java.util.Collection;

public interface INotesDatabaseContext {

    Collection<Note> getAll();
    boolean saveChanges();
}