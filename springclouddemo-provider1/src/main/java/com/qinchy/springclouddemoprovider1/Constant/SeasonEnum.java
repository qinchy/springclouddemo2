package com.qinchy.springclouddemoprovider1.Constant;

public enum SeasonEnum {
    SPRING(1), SUMMER(2), AUTUMN(2), WINTER(4);

    private int seq;

    SeasonEnum(int seq) {
        this.seq = seq;
    }

    public int getSeq() {
        return seq;
    }
}
