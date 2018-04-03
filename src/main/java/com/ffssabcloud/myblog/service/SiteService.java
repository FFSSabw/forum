package com.ffssabcloud.myblog.service;

import java.util.List;

import com.ffssabcloud.myblog.domain.Archive;

public interface SiteService {
    public List<Archive> getArchives();
    public List<Archive> getArchivesWithoutArticles();
}
