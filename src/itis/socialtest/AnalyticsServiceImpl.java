package itis.socialtest;

import itis.socialtest.entities.Post;

import java.util.List;

public class AnalyticsServiceImpl implements AnalyticsService {
    @Override
    public List<Post> findPostsByDate(List<Post> posts, String date) {
        return null;
    }

    @Override
    public String findMostPopularAuthorNickname(List<Post> posts) {
        return null;
    }

    @Override
    public Boolean checkPostsThatContainsSearchString(List<Post> posts, String searchString) {
        return null;
    }

    @Override
    public List<Post> findAllPostsByAuthorNickname(List<Post> posts, String nick){
        return null;
    }
}
