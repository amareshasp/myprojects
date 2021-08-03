package com.amareshasp.njbatchprocessing.step;

import com.amareshasp.njbatchprocessing.model.NewsItemDTO;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.util.List;

public class RssReader implements ItemReader<FeedMessage> {
    RSSFeedParser parser ;
    Feed feed;
    List<FeedMessage> messages;
    public RssReader() {
        initialize();
    }
    private int count =0;

    public void initialize(){
         parser = new RSSFeedParser(
                "https://www.thehindu.com/sport/football/feeder/default.rss");
         feed = parser.readFeed();
        messages = feed.getMessages();;
    }

    @Override
    public FeedMessage read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        FeedMessage nextFeed = null;

        if(count< messages.size()){
            nextFeed = messages.get(count);
            count++;
        }else{
            count=0;
        }
        return nextFeed;
    }
}
