# SpringBoot_Assignment
This is a Spring Boot application that provides a simple movie listing and personal watchlist API. It uses Spring Security (Basic Auth) for authentication and an H2 in-memory database for storage.

Features

1. Retrieve a list of movies, with optional sorting by year and filtering by minimum rating.
2. Manage a personal movie watchlist: add, remove, and view movies.
3. Track how many users have added a movie to their watchlist.
4. Preloaded sample dataset of movies (inserted via DataLoader.java).
5. Basic authentication with demo users (user1, user2).
6. H2 in-memory database for quick testing.

API Endpoints

Movies
| Method | Endpoint                             | Description                                                                            |
| ------ | ------------------------------------ | -------------------------------------------------------------------------------------- |
| GET    | `/api/movies?sort=year&minRating=50` | Returns a list of all movies, optionally sorted by year and filtered by minimum rating.|

User Watchlist
| Method | Endpoint                   | Description                                              |
| ------ | -------------------------- | -------------------------------------------------------- |
| GET    | `/api/watchlist`           | Retrieves the authenticated user's movie watchlist.      |
| POST   | `/api/watchlist/{movieId}` | Adds a movie to the authenticated user's watchlist.      |
| DELETE | `/api/watchlist/{movieId}` | Removes a movie from the authenticated user's watchlist. |

Authentication
The application uses HTTP Basic Authentication.
| Username | Password  | Role |
| -------- | --------- | ---- |
| user1    | password1 | USER |
| user2    | password2 | USER |

H2 Database

This project uses H2 In-Memory Database.
You can inspect data through the H2 Console:
Run the application.
Open browser: http://localhost:8080/h2-console
Enter connection details:
JDBC URL: jdbc:h2:mem:moviesdb
User: user
Password: 0987

Example Usage Postman
Get Movies
GET http://localhost:8080/api/movies?sort=year&minRating=60

Add to Watchlist
POST http://localhost:8080/api/watchlist/1
Auth: Basic (user1 / password1)

Get Watchlist
GET http://localhost:8080/api/watchlist
Auth: Basic (user1 / password1)

Remove from Watchlist
DELETE http://localhost:8080/api/watchlist/1
Auth: Basic (user1 / password1)
