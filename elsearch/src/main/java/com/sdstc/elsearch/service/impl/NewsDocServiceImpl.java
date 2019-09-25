package com.sdstc.elsearch.service.impl;

import com.sdstc.elsearch.dao.NewsDocDao;
import com.sdstc.elsearch.document.NewsDoc;
import com.sdstc.elsearch.service.NewsDocService;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service("newsDocService")
public class NewsDocServiceImpl implements NewsDocService {

    @Autowired
    private NewsDocDao newsDocDao;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public void saveUpdate(NewsDoc newsDoc) {
        newsDocDao.save(newsDoc);
    }

    @Override
    public void search(String queryText) {

        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.preTags("<h1>");
        highlightBuilder.postTags("</h1>");
        highlightBuilder.field("content").field("title");

        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.multiMatchQuery(queryText, "title", "content"))
                .withHighlightBuilder(highlightBuilder)
                .withHighlightFields(highlightBuilder.fields().get(0), highlightBuilder.fields().get(1))
                .build();

        Page<NewsDoc> docPage = elasticsearchTemplate.queryForPage(searchQuery, NewsDoc.class, new SearchResultMapper() {
            @Override
            public <T> AggregatedPage<T> mapResults(SearchResponse response, Class<T> clazz, Pageable pageable) {
                SearchHits hits = response.getHits();
                List<T> newsDocs = new ArrayList<T>();
                for (SearchHit hit : hits) {

                    try {
                        T obj = clazz.newInstance();

                        String title = hit.getHighlightFields().get("title").fragments()[0].toString();
                        Method m1 = ReflectionUtils.findMethod(clazz, "setTitle", String.class);
                        ReflectionUtils.invokeMethod(m1, obj, title);

                        String content = hit.getHighlightFields().get("content").fragments()[0].toString();
                        Method m2 = ReflectionUtils.findMethod(clazz, "setContent", String.class);
                        ReflectionUtils.invokeMethod(m2, obj, content);
                        newsDocs.add(obj);
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }

                if (newsDocs.size() > 0) {
                    return new AggregatedPageImpl<T>(newsDocs);
                }

                return null;
            }
        });


        // Page<NewsDoc> docPage=newsDocDao.search(searchQuery);
        Iterator<NewsDoc> newsDocs = docPage.iterator();

        System.out.println("----start----");
        while (newsDocs.hasNext()) {
            NewsDoc newsDoc = newsDocs.next();
            System.out.println(newsDoc.getTitle());
            System.out.println(newsDoc.getContent());

        }
        System.out.println("----end----");

    }
}
