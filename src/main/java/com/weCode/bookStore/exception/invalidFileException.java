package com.weCode.bookStore.exception;

import java.util.List;

public class invalidFileException extends RuntimeException{
    private static final long serialVersionUID=1l;


    public List<Cause> getC1() {
        return C1;
    }

    public void setC1(List<Cause> c1) {
        C1 = c1;
    }

    public invalidFileException(List<Cause> c1) {
        C1 = c1;
    }

    private List<Cause> C1;
}
