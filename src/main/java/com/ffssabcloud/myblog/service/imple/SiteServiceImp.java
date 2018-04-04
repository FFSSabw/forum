package com.ffssabcloud.myblog.service.imple;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffssabcloud.myblog.domain.Archive;
import com.ffssabcloud.myblog.domain.Article;
import com.ffssabcloud.myblog.domain.ArticleExample;
import com.ffssabcloud.myblog.domain.ArticleExample.Criteria;
import com.ffssabcloud.myblog.domain.Meta;
import com.ffssabcloud.myblog.domain.MetaExample;
import com.ffssabcloud.myblog.domain.dao.ArticleMapper;
import com.ffssabcloud.myblog.domain.dao.MetaMapper;
import com.ffssabcloud.myblog.service.SiteService;
import com.ffssabcloud.myblog.utils.DateUtils;

@Service
public class SiteServiceImp implements SiteService{
    
    @Autowired
    ArticleMapper articleMapper;
    
    @Autowired
    MetaMapper metaMapper;
    
    @Override
    public List<Archive> getArchives() {
        List<Archive> archives = getArchivesWithoutArticles();
        if(archives != null) {
            for(Archive archive : archives) {
                ArticleExample example = new ArticleExample();
                Criteria criteria = example.createCriteria();
                example.setOrderByClause("createAt desc");
                String strDate = archive.getDate();
                Date date = DateUtils.fmtStrDate(strDate, "yyyy-MM");
                int start = DateUtils.getUnixTimeByDate(date);
                int end = DateUtils.getUnixTimeByDate(
                        DateUtils.addDate(date, DateUtils.MONTH, 1));
                criteria.andCreateatGreaterThan(start);
                criteria.andCreateatLessThan(end);
                List<Article> articles = articleMapper.selectByExample(example);
                archive.setArticles(articles);
            }
        }
        return archives;
    }

    @Override
    public List<Archive> getArchivesWithoutArticles() {
        return articleMapper.selectArchives();
    }

    @Override
    public List<Meta> getMetas(String type) {
        MetaExample example = new MetaExample();
        example.createCriteria().andTypeEqualTo(type);
        List<Meta> metas = metaMapper.selectByExample(example);
        
        return metas;
    }

}
