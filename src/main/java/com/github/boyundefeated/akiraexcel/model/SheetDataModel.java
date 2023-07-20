package com.github.boyundefeated.akiraexcel.model;

import com.github.boyundefeated.akiraexcel.utils.AkiraWriterFormatOptions;

import java.util.List;

public class SheetDataModel {
    private String sheetName;

    private List<?> data;

    private Class<?> clazz;

    private AkiraWriterFormatOptions options;

    public SheetDataModel() {
    }

    public SheetDataModel(String sheetName, List<?> data, Class<?> clazz, AkiraWriterFormatOptions options) {
        this.sheetName = sheetName;
        this.data = data;
        this.clazz = clazz;
        this.options = options;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public AkiraWriterFormatOptions getOptions() {
        return options;
    }

    public void setOptions(AkiraWriterFormatOptions options) {
        this.options = options;
    }
}

