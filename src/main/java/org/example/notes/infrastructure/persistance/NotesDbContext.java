package org.example.notes.infrastructure.persistance;

import org.example.database.NotesDatabase;
import org.example.database.NotesRecord;
import org.example.notes.core.application.interfaces.INotesDatabaseContext;
import org.example.notes.core.domain.Note;
import org.example.notes.infrastructure.persistance.configurations.NoteConfiguration;

import java.util.ArrayList;
import java.util.Collection;

public class NotesDbContext extends DbContext implements INotesDatabaseContext {

    @Override
    public Collection<Note> getAll() {
        Collection<Note> noteList = new ArrayList<>();

        for (NotesRecord record : ((NotesDatabase)database).getNotesTable().getRecords()){
            noteList.add(new Note(record.getId(), record.getUserId(), record.getTitle(), record.getDetails(), record.getCreationDate()));
        }
        return noteList;
    }

    public NotesDbContext(Database database) {
        super(database);
    }

    @Override
    protected void onModelCreating(ModelBuilder builder) {
        builder.applyConfiguration(new NoteConfiguration());
    }


}
