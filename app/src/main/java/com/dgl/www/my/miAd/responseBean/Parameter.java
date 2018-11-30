package com.dgl.www.my.miAd.responseBean;

/**
 * Created by dugaolong on 17/5/9.
 */

public class Parameter {
    private String dspname;

    public String getDspname() {
        return dspname;
    }

    public void setDspname(String dspname) {
        this.dspname = dspname;
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "dspname='" + dspname + '\'' +
                '}';
    }
}
