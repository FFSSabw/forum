package com.ffssabcloud.myblog.service;

import java.util.List;

import com.ffssabcloud.myblog.domain.Archive;
import com.ffssabcloud.myblog.domain.Meta;

public interface SiteService {
    public List<Meta> getMetas(String type);
    public List<Archive> getArchives();
    public List<Archive> getArchivesWithoutArticles();
}
