package com.ffssabcloud.myblog.service;

import java.util.List;

import com.ffssabcloud.myblog.domain.Archive;
import com.ffssabcloud.myblog.domain.Meta;

public interface SiteService {
    public List<Meta> getMetas(String type);
    public void setMeta(String type, String name);
    public List<Archive> getArchives();
    public List<Archive> getArchivesWithoutArticles();
    public boolean checkMetaExist(String name);
}
