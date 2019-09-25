package com.sdstc.elsearch.service;

import com.sdstc.elsearch.document.NewsDoc;

public interface NewsDocService {
    public  void  saveUpdate(NewsDoc newsDoc);

    public void search(String queryText);
}
