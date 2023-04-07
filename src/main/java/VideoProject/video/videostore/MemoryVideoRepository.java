package VideoProject.video.videostore;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MemoryVideoRepository implements VideoRepository {
    private static Map<String, Video> store = new HashMap<>();

    @Override
    public void signUpVideo(Video video) {
        store.put(video.getName(), video);
    }

    @Override
    public Video findByVideo(String name) {
        System.out.println(store.get(name));
        return store.get(name);
    }

    @Override
    public Collection<Video> findByAllVideo() {
        for (Video data : store.values()) {
            System.out.println(data);
        }
        return store.values();
    }

}
