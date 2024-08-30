package org.example.notes.core.application;

import org.example.notes.core.application.interfaces.INoteEditor;
import org.example.notes.core.application.interfaces.INotesDatabaseContext;
import org.example.notes.core.application.interfaces.INotesPresenter;
import org.example.notes.core.domain.Note;

import java.util.Collection;
import java.util.Optional;

public class ConcreteNoteEditor implements INoteEditor {

    private final INotesDatabaseContext dbContext;
    private final INotesPresenter notesPresenter;

    public ConcreteNoteEditor(INotesDatabaseContext dbContext, INotesPresenter notesPresenter) {
        this.dbContext = dbContext;
        this.notesPresenter = notesPresenter;
    }

    @Override
    public boolean add(Note item) {
        dbContext.getAll().add(item);
        return dbContext.saveChanges();
    }

    @Override
    public boolean edit(Note item) {
        if (item == null)
            return false;
        Optional<Note> note = getById(item.getId());
        if (note.isEmpty())
            return false;
        note.get().setTitle(item.getTitle());
        note.get().setDetails(item.getDetails());
        note.get().setEditDate(item.getEditDate());
        return dbContext.saveChanges();
    }

    @Override
    public boolean remove(Note item) {
        dbContext.getAll().remove(item);
        return dbContext.saveChanges();
    }

    @Override
    public Optional<Note> getById(Integer id) {
        return dbContext.getAll().stream().filter(p -> p.getId() == id).findFirst();
    }

    @Override
    public Collection<Note> getAll() {
        return null;
    }

    @Override
    public void printAll() {
        notesPresenter.printAll(getAll());
    }
}
