package com.rbena;

/** The object model for the data we are sending through endpoints */
public class ByteBean {

    private byte[] myData;

    public byte[] getData() {
        return myData;
    }

    public void setData(byte[] data) {
        myData = data;
    }
}
