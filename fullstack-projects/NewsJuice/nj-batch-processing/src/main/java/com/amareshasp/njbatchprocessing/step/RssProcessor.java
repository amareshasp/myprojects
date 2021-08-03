package com.amareshasp.njbatchprocessing.step;

import com.amareshasp.njbatchprocessing.model.NewsItemDTO;
import com.amareshasp.njbatchprocessing.model.NewsWriterItem;
import org.springframework.batch.item.ItemProcessor;

public class RssProcessor implements ItemProcessor<NewsItemDTO, NewsWriterItem> {
    @Override
    public NewsWriterItem process(NewsItemDTO newsItemDTO) throws Exception {
        final NewsWriterItem newsToWrite = new NewsWriterItem();

        return newsToWrite;
    }
}
