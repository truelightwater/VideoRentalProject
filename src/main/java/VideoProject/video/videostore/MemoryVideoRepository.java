package VideoProject.video.videostore;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemoryVideoRepository implements VideoRepository {

    private static Map<Long, Video> store = new HashMap<>();

    @Override
    public void signUpVideo(Video video) {
        store.put(video.getId(), video);
    }

    @Override
    public Video findByVideo(Long videoId) {
        return store.get(videoId);
    }

    @Override
    public Collection<Video> findByAllVideo() {
        return store.values();
    }

}
