package com.ffssabcloud.myblog.service;

import java.util.Collection;
import java.util.List;

import com.ffssabcloud.myblog.domain.Archive;
import com.ffssabcloud.myblog.domain.Meta;

public interface SiteService {
    public List<Meta> getMetas(String type);
    public void setMeta(String type, String name);
    public void setMetas(String type, Collection<String> names);
    public void updateMetaCount(String type, String name, Integer count);
    public void updateMetaCount(String type, Collection<String> names, Integer count);
    public void updateMetaName(String type, Integer metaId, String name);
    public List<Archive> getArchives();
    public List<Archive> getArchivesWithoutArticles();
    public boolean checkMetaExist(String type, String name);
}
