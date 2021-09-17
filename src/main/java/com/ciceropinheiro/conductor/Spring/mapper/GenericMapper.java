package com.ciceropinheiro.conductor.Spring.mapper;

//T = Class
// U = Request
// V = Response

public interface GenericMapper <T,U,V>{





    T requestForEntity (U u);


    V entityForResponse (T t);

}
