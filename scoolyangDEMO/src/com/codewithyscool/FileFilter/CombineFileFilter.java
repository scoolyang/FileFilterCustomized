package com.codewithyscool.FileFilter;

import java.io.File;

public class CombineFileFilter implements FileFilterInterface {
    private FilterTypeParam thisParam;

    public CombineFileFilter(FilterTypeParam ftp) {
        this.thisParam = ftp;
    }

    @Override
    public boolean filt(File fileName) {
        FileFilterNode curRoot = thisParam.getRoot();
        return fileFilterDFSHelper(fileName, curRoot);
    }

    private boolean fileFilterDFSHelper(File fileName, FileFilterNode root) {
        if (root == null) {
            return true;
        }
        boolean ans = false;
        if (root.isOperatorNode()) {
            boolean left = fileFilterDFSHelper(fileName, root.left);
            boolean right = fileFilterDFSHelper(fileName, root.right);
            ans = root.operator.check(left, right);
        } else
            ans = root.filter.filt(fileName);
        return ans;
    }
}
