package com.thoughtclan.todo_movies;

import com.thoughtclan.todo_movies.model.Movie;
import com.thoughtclan.todo_movies.model.User;
import com.thoughtclan.todo_movies.repository.MovieRepository;
import com.thoughtclan.todo_movies.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner init(MovieRepository movieRepository, UserRepository userRepository, BCryptPasswordEncoder encoder) {
        return args -> {
            // create two users
            if (userRepository.findByUsername("user1").isEmpty()) {
                User u1 = new User();
                u1.setUsername("user1");
                u1.setPassword(encoder.encode("password1"));
                userRepository.save(u1);
            }
            if (userRepository.findByUsername("user2").isEmpty()) {
                User u2 = new User();
                u2.setUsername("user2");
                u2.setPassword(encoder.encode("password2"));
                userRepository.save(u2);
            }

            if (movieRepository.count() == 0) {
                List<Movie> movies = new ArrayList<>();

                movies.add(newMovie("Youth in Revolt","Comedy","The Weinstein Company",68,2010,"https://www.movies.com/1"));
                movies.add(newMovie("You Will Meet a Tall Dark Stranger","Comedy","Independent",43,2010,"https://www.movies.com/1"));
                movies.add(newMovie("When in Rome","Comedy","Disney",15,2010,"https://www.movies.com/1"));
                movies.add(newMovie("What Happens in Vegas","Comedy","Fox",28,2008,"https://www.movies.com/1"));
                movies.add(newMovie("Water For Elephants","Drama","20th Century Fox",60,2011,"https://www.movies.com/1"));
                movies.add(newMovie("WALL-E","Animation","Disney",96,2008,"https://www.movies.com/1"));
                movies.add(newMovie("Waitress","Romance","Independent",89,2007,"https://www.movies.com/1"));
                movies.add(newMovie("Waiting For Forever","Romance","Independent",6,2011,"https://www.movies.com/1"));
                movies.add(newMovie("Valentine's Day","Comedy","Warner Bros.",17,2010,"https://www.movies.com/1"));
                movies.add(newMovie("Tyler Perry's Why Did I get Married","Romance","Independent",46,2007,"https://www.movies.com/1"));
                movies.add(newMovie("Twilight: Breaking Dawn","Romance","Independent",26,2011,"https://www.movies.com/1"));
                movies.add(newMovie("Twilight","Romance","Summit",49,2008,"https://www.movies.com/1"));
                movies.add(newMovie("The Ugly Truth","Comedy","Independent",14,2009,"https://www.movies.com/1"));
                movies.add(newMovie("The Twilight Saga: New Moon","Drama","Summit",27,2009,"https://www.movies.com/1"));
                movies.add(newMovie("The Time Traveler's Wife","Drama","Paramount",38,2009,"https://www.movies.com/1"));
                movies.add(newMovie("The Proposal","Comedy","Disney",43,2009,"https://www.movies.com/1"));
                movies.add(newMovie("The Invention of Lying","Comedy","Warner Bros.",56,2009,"https://www.movies.com/1"));
                movies.add(newMovie("The Heartbreak Kid","Comedy","Paramount",30,2007,"https://www.movies.com/1"));
                movies.add(newMovie("The Duchess","Drama","Paramount",60,2008,"https://www.movies.com/1"));
                movies.add(newMovie("The Curious Case of Benjamin Button","Fantasy","Warner Bros.",73,2008,"https://www.movies.com/1"));
                movies.add(newMovie("The Back-up Plan","Comedy","CBS",20,2010,"https://www.movies.com/1"));
                movies.add(newMovie("Tangled","Animation","Disney",89,2010,"https://www.movies.com/1"));
                movies.add(newMovie("Something Borrowed","Romance","Independent",15,2011,"https://www.movies.com/1"));
                movies.add(newMovie("She's Out of My League","Comedy","Paramount",57,2010,"https://www.movies.com/1"));
                movies.add(newMovie("Sex and the City Two","Comedy","Warner Bros.",15,2010,"https://www.movies.com/1"));
                movies.add(newMovie("Sex and the City 2","Comedy","Warner Bros.",15,2010,"https://www.movies.com/1"));
                movies.add(newMovie("Sex and the City","Comedy","Warner Bros.",49,2008,"https://www.movies.com/1"));
                movies.add(newMovie("Remember Me","Drama","Summit",28,2010,"https://www.movies.com/1"));
                movies.add(newMovie("Rachel Getting Married","Drama","Independent",85,2008,"https://www.movies.com/1"));
                movies.add(newMovie("Penelope","Comedy","Summit",52,2008,"https://www.movies.com/1"));
                movies.add(newMovie("P.S. I Love You","Romance","Independent",21,2007,"https://www.movies.com/1"));
                movies.add(newMovie("Over Her Dead Body","Comedy","New Line",15,2008,"https://www.movies.com/1"));
                movies.add(newMovie("Our Family Wedding","Comedy","Independent",14,2010,"https://www.movies.com/1"));
                movies.add(newMovie("One Day","Romance","Independent",37,2011,"https://www.movies.com/1"));
                movies.add(newMovie("Not Easily Broken","Drama","Independent",34,2009,"https://www.movies.com/1"));
                movies.add(newMovie("No Reservations","Comedy","Warner Bros.",39,2007,"https://www.movies.com/1"));
                movies.add(newMovie("Nick and Norah's Infinite Playlist","Comedy","Sony",73,2008,"https://www.movies.com/1"));
                movies.add(newMovie("New Year's Eve","Romance","Warner Bros.",8,2011,"https://www.movies.com/1"));
                movies.add(newMovie("My Week with Marilyn","Drama","The Weinstein Company",83,2011,"https://www.movies.com/1"));
                movies.add(newMovie("Music and Lyrics","Romance","Warner Bros.",63,2007,"https://www.movies.com/1"));
                movies.add(newMovie("Monte Carlo","Romance","20th Century Fox",38,2011,"https://www.movies.com/1"));
                movies.add(newMovie("Miss Pettigrew Lives for a Day","Comedy","Independent",78,2008,"https://www.movies.com/1"));
                movies.add(newMovie("Midnight in Paris","Romence","Sony",93,2011,"https://www.movies.com/1"));
                movies.add(newMovie("Marley and Me","Comedy","Fox",63,2008,"https://www.movies.com/1"));
                movies.add(newMovie("Mamma Mia!","Comedy","Universal",53,2008,"https://www.movies.com/1"));
                movies.add(newMovie("Mamma Mia!","Comedy","Universal",53,2008,"https://www.movies.com/1"));
                movies.add(newMovie("Made of Honor","Comdy","Sony",13,2008,"https://www.movies.com/1"));
                movies.add(newMovie("Love Happens","Drama","Universal",18,2009,"https://www.movies.com/1"));
                movies.add(newMovie("Love & Other Drugs","Comedy","Fox",48,2010,"https://www.movies.com/1"));
                movies.add(newMovie("Life as We Know It","Comedy","Independent",28,2010,"https://www.movies.com/1"));
                movies.add(newMovie("License to Wed","Comedy","Warner Bros.",8,2007,"https://www.movies.com/1"));
                movies.add(newMovie("Letters to Juliet","Comedy","Summit",40,2010,"https://www.movies.com/1"));
                movies.add(newMovie("Leap Year","Comedy","Universal",21,2010,"https://www.movies.com/1"));
                movies.add(newMovie("Knocked Up","Comedy","Universal",91,2007,"https://www.movies.com/1"));
                movies.add(newMovie("Killers","Action","Lionsgate",11,2010,"https://www.movies.com/1"));
                movies.add(newMovie("Just Wright","Comedy","Fox",45,2010,"https://www.movies.com/1"));
                movies.add(newMovie("Jane Eyre","Romance","Universal",85,2011,"https://www.movies.com/1"));
                movies.add(newMovie("It's Complicated","Comedy","Universal",56,2009,"https://www.movies.com/1"));
                movies.add(newMovie("I Love You Phillip Morris","Comedy","Independent",71,2010,"https://www.movies.com/1"));
                movies.add(newMovie("High School Musical 3: Senior Year","Comedy","Disney",65,2008,"https://www.movies.com/1"));
                movies.add(newMovie("He's Just Not That Into You","Comedy","Warner Bros.",42,2009,"https://www.movies.com/1"));
                movies.add(newMovie("Good Luck Chuck","Comedy","Lionsgate",3,2007,"https://www.movies.com/1"));
                movies.add(newMovie("Going the Distance","Comedy","Warner Bros.",53,2010,"https://www.movies.com/1"));
                movies.add(newMovie("Gnomeo and Juliet","Animation","Disney",56,2011,"https://www.movies.com/1"));
                movies.add(newMovie("Gnomeo and Juliet","Animation","Disney",56,2011,"https://www.movies.com/1"));
                movies.add(newMovie("Ghosts of Girlfriends Past","Comedy","Warner Bros.",27,2009,"https://www.movies.com/1"));
                movies.add(newMovie("Four Christmases","Comedy","Warner Bros.",26,2008,"https://www.movies.com/1"));
                movies.add(newMovie("Fireproof","Drama","Independent",40,2008,"https://www.movies.com/1"));
                movies.add(newMovie("Enchanted","Comedy","Disney",93,2007,"https://www.movies.com/1"));
                movies.add(newMovie("Dear John","Drama","Sony",29,2010,"https://www.movies.com/1"));
                movies.add(newMovie("Beginners","Comedy","Independent",84,2011,"https://www.movies.com/1"));
                movies.add(newMovie("Across the Universe","romance","Independent",54,2007,"https://www.movies.com/1"));
                movies.add(newMovie("A Serious Man","Drama","Universal",89,2009,"https://www.movies.com/1"));
                movies.add(newMovie("A Dangerous Method","Drama","Independent",79,2011,"https://www.movies.com/1"));
                movies.add(newMovie("27 Dresses","Comedy","Fox",40,2008,"https://www.movies.com/1"));
                movies.add(newMovie("(500) Days of Summer","Comedy","Fox",87,2009,"https://www.movies.com/1"));

                movieRepository.saveAll(movies);
            }
        };
    }

    private Movie newMovie(String title, String genre, String studio, int rt, int year, String poster) {
        Movie m = new Movie();
        m.setTitle(title);
        m.setGenre(genre);
        m.setStudio(studio);
        m.setRottenTomatoes(rt);
        m.setReleaseYear(year);
        m.setPosterUrl(poster);
        return m;
    }
}
