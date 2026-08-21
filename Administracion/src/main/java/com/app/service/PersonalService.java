package com.app.service;

import java.util.List;

import com.app.model.Personal;

public interface PersonalService {

    Personal altaPersonal(Personal personal);

    List<Personal> listarPersonal();

}