package com.ciceropinheiro.conductor.Spring.mapper;

import org.mapstruct.Mapper;

//T = Class
// U = Request
// V = Response

public interface GenericMapper <T,U,V>{





    T requestForEntity (U u);


    V entityForResponse (T t);

}
