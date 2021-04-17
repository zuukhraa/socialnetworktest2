package itis.socialtest;


import itis.socialtest.entities.Author;
import itis.socialtest.entities.Post;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/*
 * В папке resources находятся два .csv файла.
 * Один содержит данные о постах в соцсети в следующем формате: Id автора, число лайков, дата, текст
 * Второй содержит данные о пользователях  - id, никнейм и дату рождения
 *
 * Напишите код, который превратит содержимое файлов в обьекты в package "entities"
 * и осуществите над ними следующие опреации:
 *
 * 1. Выведите в консоль все посты в читабельном виде, с информацией об авторе.
 * 2. Выведите все посты за сегодняшнюю дату
 * 3. Выведите все посты автора с ником "varlamov"
 * 4. Проверьте, содержит ли текст хотя бы одного поста слово "Россия"
 * 5. Выведите никнейм самого популярного автора (определять по сумме лайков на всех постах)
 *
 * Для выполнения заданий 2-5 используйте методы класса AnalyticsServiceImpl (которые вам нужно реализовать).
 *
 * Требования к реализации: все методы в AnalyticsService должны быть реализованы с использованием StreamApi.
 * Использование обычных циклов и дополнительных переменных приведет к снижению баллов, но допустимо.
 * Парсинг файлов и реализация методов оцениваются ОТДЕЛЬНО
 *
 *
 * */

public class MainClass {

    private List<Post> allPosts;

    private AnalyticsService analyticsService = new AnalyticsServiceImpl();

    public static void main(String[] args) {
        new MainClass().run("src/itis/socialtest/resources/PostDatabase.csv", "src/itis/socialtest/resources/Authors.csv");
    }

    private void run(String postsSourcePath, String authorsSourcePath) {
        List<Author> authors = parseAuthors(authorsSourcePath);
        List<Post> posts = parsePosts(postsSourcePath, authors);
        // task 1
        printPosts(posts);
        AnalyticsService analyticsService = new AnalyticsServiceImpl();
        // task 2
        printPosts(analyticsService.findPostsByDate(posts, "17.04.2021"));
        // task 3
        printPosts(analyticsService.findAllPostsByAuthorNickname(posts, "varlamov"));
        // task 4
        System.out.println(analyticsService.checkPostsThatContainsSearchString(posts, "Россия"));
        // task 5
        System.out.println(analyticsService.findMostPopularAuthorNickname(posts));
    }

    private List<Author> parseAuthors(String authorsSourcePath) {
        List<Author> authors = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(new File(authorsSourcePath));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] authorData = line.split(", ");
                Long id = Long.parseLong(authorData[0]);
                String nickname = authorData[1];
                String birthdayDate = authorData[2];
                authors.add(new Author(id, nickname, birthdayDate));
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return authors;
    }

    private List<Post> parsePosts(String postsSourcePath, List<Author> authors) {
        List<Post> posts = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(new File(postsSourcePath));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] postData = line.split(", ", 4);
                String date = postData[2];
                String content = postData[3];
                Long likesCount = Long.parseLong(postData[1]);
                Long authorId = Long.parseLong(postData[0]);
                Author author = authors.stream().filter(element -> element.getId().equals(authorId)).findFirst().get();
                posts.add(new Post(date, content, likesCount, author));
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return posts;
    }

    private void printPosts(List<Post> posts) {
        for (Post post : posts) {
            System.out.println("Date: " + post.getDate());
            System.out.println("Likes: " + post.getLikesCount());
            System.out.println("Author: " + post.getAuthor().getNickname());
            System.out.println("Content: " + post.getContent() + "\n");
        }
    }

}
