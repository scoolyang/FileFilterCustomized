package com.codewithyscool.FileFilter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileFilterProcessor {
    public static List<File> filterGo(File[] files, FilterTypeParam param) {
        List<File> res = new ArrayList<>();
        if (files == null || files.length == 0)
            return res;

        FileFilterInterface filter = getFilter(param);

        for (File f : files) {
            if (filter.filt(f))
                res.add(f);
        }
        return res;
    }

    private static FileFilterInterface getFilter(FilterTypeParam param) {
        FileFilterInterface curFilter = null;
        switch (param.getType()) {
            case SUFFIX:
                curFilter = new SuffixFileFilter(param);
                break;
            case SIZE:
                curFilter = new SizeFileFilter(param);
                break;
            case COMBINE:
                curFilter = new CombineFileFilter(param);
                break;
            default:
                throw new IllegalArgumentException("Unsupported type");
        }
        return curFilter;
    }
}
