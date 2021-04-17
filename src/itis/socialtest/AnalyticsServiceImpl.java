package itis.socialtest;

import itis.socialtest.entities.Post;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnalyticsServiceImpl implements AnalyticsService {
    @Override
    public List<Post> findPostsByDate(List<Post> posts, String date) {
        return posts
                .stream()
                .filter(element -> element.getDate().split("T")[0].equals(date))
                .collect(Collectors.toList());
    }

    @Override
    public String findMostPopularAuthorNickname(List<Post> posts) {
        HashMap<String, Long> authors = new HashMap<>();
        for (Post post : posts) {
            if (authors.containsKey(post.getAuthor().getNickname())) {
                authors.put(post.getAuthor().getNickname(), authors.get(post.getAuthor().getNickname()) + post.getLikesCount());
            } else {
                authors.put(post.getAuthor().getNickname(), post.getLikesCount());
            }
        }
        long max = -1;
        String nick = "";
        for (Map.Entry<String, Long> entry : authors.entrySet()) {
            if (entry.getValue() > max) {
                nick = entry.getKey();
            }
        }
        return nick;
    }

    @Override
    public Boolean checkPostsThatContainsSearchString(List<Post> posts, String searchString) {
        return posts
                .stream()
                .anyMatch(element -> element.getContent().contains(searchString));
    }

    @Override
    public List<Post> findAllPostsByAuthorNickname(List<Post> posts, String nick) {
        return posts
                .stream()
                .filter(element -> element.getAuthor().getNickname().equals(nick))
                .collect(Collectors.toList());
    }

}
