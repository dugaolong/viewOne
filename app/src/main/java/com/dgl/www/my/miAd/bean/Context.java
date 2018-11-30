package com.dgl.www.my.miAd.bean;

/**
 * Created by dugaolong on 17/3/31.
 */

public class Context {
    private String did;
    private Ds ds;
    private String token;


    public class Ds{
        private int ov;
        private String abis;
        private int advc;
        private String advn;
        private Ass ass;

        public int getOv() {
            return ov;
        }

        public void setOv(int ov) {
            this.ov = ov;
        }

        public String getAbis() {
            return abis;
        }

        public void setAbis(String abis) {
            this.abis = abis;
        }

        public int getAdvc() {
            return advc;
        }

        public void setAdvc(int advc) {
            this.advc = advc;
        }

        public String getAdvn() {
            return advn;
        }

        public void setAdvn(String advn) {
            this.advn = advn;
        }

        public Ass getAss() {
            return ass;
        }

        public void setAss(Ass ass) {
            this.ass = ass;
        }
    }

    public class Ass{
        private int cv;
        private String ck;
        private int tv;
        private String ct;

        public int getCv() {
            return cv;
        }

        public void setCv(int cv) {
            this.cv = cv;
        }

        public String getCk() {
            return ck;
        }

        public void setCk(String ck) {
            this.ck = ck;
        }

        public int getTv() {
            return tv;
        }

        public void setTv(int tv) {
            this.tv = tv;
        }

        public String getCt() {
            return ct;
        }

        public void setCt(String ct) {
            this.ct = ct;
        }
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public Ds getDs() {
        return ds;
    }

    public void setDs(Ds ds) {
        this.ds = ds;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}



