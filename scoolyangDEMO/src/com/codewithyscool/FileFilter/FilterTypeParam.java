package com.codewithyscool.FileFilter;

public class FilterTypeParam {
    private Integer size;
    private String suffix;
    private FileFilterNode root;
    private FileType type;

    public FilterTypeParam(String suffix) {
        this.suffix = suffix;
        this.size = null;
        this.type = FileType.SUFFIX;
    }

    public FilterTypeParam(int size) {
        this.suffix = null;
        this.size = size;
        this.type = FileType.SIZE;
    }

    public FilterTypeParam(FileFilterNode node) {
        this.root = node;
        this.type = FileType.COMBINE;
    }

    public FileType getType() {
        return this.type;
    }
    public Integer getSize() {
        return this.size;
    }
    public FileFilterNode getRoot() {
        return this.root;
    }
    public String getSuffix() {
        return this.suffix;
    }
}
