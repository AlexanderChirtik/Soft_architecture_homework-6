package org.example.notes.presentation.queries.controllers;

import org.example.notes.presentation.queries.views.IPresenter;

public abstract class Controller {

    public <T extends IPresenter> void view(T presenter){

    }
}
