public class MoviePosterManager {
    private MoviePoster[] moviePosters = new MoviePoster[0];
    private int lastMoviePostersLength;

    public MoviePosterManager(int lastMoviePostersLength) {
        if (lastMoviePostersLength <= 0) {
            this.lastMoviePostersLength = 1;
        } else {
            this.lastMoviePostersLength = lastMoviePostersLength;
        }
    }

    public MoviePosterManager() {
        this.lastMoviePostersLength = 5;
    }

    public void save(MoviePoster poster) {
        MoviePoster[] tmp = new MoviePoster[moviePosters.length + 1];
        for (int i = 0; i < moviePosters.length; i++) {
            tmp[i] = moviePosters[i];
        }
        tmp[tmp.length - 1] = poster;
        moviePosters = tmp;
    }

    public MoviePoster[] findAll() {
        return moviePosters;
    }

    public MoviePoster[] findLast() {
        int resultLength;
        if (moviePosters.length <= lastMoviePostersLength) {
            resultLength = moviePosters.length;
        } else {
            resultLength = lastMoviePostersLength;
        }
        MoviePoster[] result = new MoviePoster[resultLength];
        for (int i = 0; i < result.length; i++) {
            result[i] = moviePosters[moviePosters.length - 1 - i];
        }
        return result;
    }
}