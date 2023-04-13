package VideoProject.video.videostore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class MemoryVideoRepository implements VideoRepository {
    private static Map<String, Video> store = new HashMap<>();
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public void signUpVideo(Video video) {
        store.put(video.getName(), video);
    }

    @Override
    public Video findByVideo(String name) {
        return Optional.ofNullable(store.get(name))
                .map(video -> {
                    log.info(String.valueOf(video));
                    return video;
                })
                .orElseGet(() -> {
                    log.info("**** 검색한 비디오가 없습니다. ****");
                    return null;
                });
    }

    @Override
    public Collection<Video> findByAllVideo() {
        return Optional.ofNullable(store.values())
                .map(values -> {
                    if (values.isEmpty()) {
                        log.info("**** 비디오 목록이 비어 있습니다. ****");
                    } else {
                        values.forEach(video -> log.info(String.valueOf(video)));
                    }
                    return values;
                })
                .orElse(Collections.emptyList());
    }
}
