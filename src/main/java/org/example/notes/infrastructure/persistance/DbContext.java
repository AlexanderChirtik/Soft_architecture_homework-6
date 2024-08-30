package org.example.notes.infrastructure.persistance;

public abstract class DbContext {

    protected Database database;

    public DbContext(Database database) {
        this.database = database;
    }

    public boolean saveChanges(){
        //TODO: Сохранение изменений в БД
        return true;
    }

    protected abstract void onModelCreating(ModelBuilder builder);
}

class ModelBuilder{
    public ModelBuilder applyConfiguration(ModelConfiguration configuration){
        //TODO: Добавление конфигурации мапинга объекта некоторого типа к структуре таблицы БД
        return this;
    }
}

