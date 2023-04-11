package VideoProject.video.videostore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemoryVideoRepository implements VideoRepository {
    private static Map<String, Video> store = new HashMap<>();
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public void signUpVideo(Video video) {
        store.put(video.getName(), video);
    }

    @Override
    public Video findByVideo(String name) {
        log.info(String.valueOf(store.get(name)));
        return store.get(name);
    }

    @Override
    public Collection<Video> findByAllVideo() {
        for (Video data : store.values()) {
            log.info(String.valueOf(data));
        }
        return store.values();
    }

}
