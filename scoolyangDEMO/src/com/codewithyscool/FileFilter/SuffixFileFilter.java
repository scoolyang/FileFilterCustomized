package com.codewithyscool.FileFilter;

import java.io.File;

public class SuffixFileFilter implements FileFilterInterface {
    private FilterTypeParam thisParam;

    public SuffixFileFilter(FilterTypeParam ftp) {
        this.thisParam = ftp;
    }

    @Override
    public boolean filt(File fileName) {
        if (fileName.getName().endsWith(thisParam.getSuffix())) {
            return true;
        }
        return false;
    }
}