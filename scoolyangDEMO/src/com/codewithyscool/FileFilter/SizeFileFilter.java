package com.codewithyscool.FileFilter;

import java.io.File;

public class SizeFileFilter implements FileFilterInterface {
    private FilterTypeParam thisParam;

    public SizeFileFilter(FilterTypeParam ftp) {
        this.thisParam = ftp;
    }

    @Override
    public boolean filt(File fileName) {
        if (fileName.getName().length() < thisParam.getSize()) {
            return true;
        }
        return false;
    }
}
