import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoviePosterManagerFindLastTest {
    MoviePoster poster1 = new MoviePoster(1, "The Gentlemen", "action");
    MoviePoster poster2 = new MoviePoster(2, "Onward", "animation");
    MoviePoster poster3 = new MoviePoster(3, "The Invisible Man", "horror");
    MoviePoster poster4 = new MoviePoster(4, "Bloodshot", "action");
    MoviePoster poster5 = new MoviePoster(5, "Belgrade Hotel", "comedy");
    MoviePoster poster6 = new MoviePoster(6, "Tolls World Tour", "animation");
    MoviePoster poster7 = new MoviePoster(7, "Number One", "comedy");

    @Test
    public void findLastStandardEqualPostersAndLength() {
        MoviePosterManager manager = new MoviePosterManager();

        manager.save(poster1);
        manager.save(poster2);
        manager.save(poster3);
        manager.save(poster4);
        manager.save(poster5);

        MoviePoster[] expected = {poster5, poster4, poster3, poster2, poster1};
        MoviePoster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastStandardMorePostersThanLength() {
        MoviePosterManager manager = new MoviePosterManager();

        manager.save(poster1);
        manager.save(poster2);
        manager.save(poster3);
        manager.save(poster4);
        manager.save(poster5);
        manager.save(poster6);

        MoviePoster[] expected = {poster6, poster5, poster4, poster3, poster2};
        MoviePoster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastStandardLessPostersThanLength() {
        MoviePosterManager manager = new MoviePosterManager();

        manager.save(poster1);
        manager.save(poster2);
        manager.save(poster3);
        manager.save(poster4);

        MoviePoster[] expected = {poster4, poster3, poster2, poster1};
        MoviePoster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastWrongCustomLessPostersThanLength() {
        MoviePosterManager manager = new MoviePosterManager(-1);

        manager.save(poster1);
        manager.save(poster2);
        manager.save(poster3);

        MoviePoster[] expected = {poster3};
        MoviePoster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastCustomZeroLessPostersThanLength() {
        MoviePosterManager manager = new MoviePosterManager(0);

        manager.save(poster1);
        manager.save(poster2);
        manager.save(poster3);

        MoviePoster[] expected = {poster3};
        MoviePoster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastLowerCustomEqualPostersAndLength() {
        MoviePosterManager manager = new MoviePosterManager(1);

        manager.save(poster1);

        MoviePoster[] expected = {poster1};
        MoviePoster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastLowerCustomMorePostersThanLength() {
        MoviePosterManager manager = new MoviePosterManager(1);

        manager.save(poster1);
        manager.save(poster2);
        manager.save(poster3);

        MoviePoster[] expected = {poster3};
        MoviePoster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastCustomLessThanStandardLessPostersThanLength() {
        MoviePosterManager manager = new MoviePosterManager(3);

        manager.save(poster1);
        manager.save(poster2);

        MoviePoster[] expected = {poster2, poster1};
        MoviePoster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastCustomEqualStandardMorePostersThanLength() {
        MoviePosterManager manager = new MoviePosterManager(5);

        manager.save(poster1);
        manager.save(poster2);
        manager.save(poster3);
        manager.save(poster4);
        manager.save(poster5);
        manager.save(poster6);
        manager.save(poster7);

        MoviePoster[] expected = {poster7, poster6, poster5, poster4, poster3};
        MoviePoster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastCustomMoreThanStandardEqualPostersAndLength() {
        MoviePosterManager manager = new MoviePosterManager(6);

        manager.save(poster1);
        manager.save(poster2);
        manager.save(poster3);
        manager.save(poster4);
        manager.save(poster5);
        manager.save(poster6);

        MoviePoster[] expected = {poster6, poster5, poster4, poster3, poster2, poster1};
        MoviePoster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastCustomUpperStandardMorePostersThanLength() {
        MoviePosterManager manager = new MoviePosterManager(6);

        manager.save(poster1);
        manager.save(poster2);
        manager.save(poster3);
        manager.save(poster4);
        manager.save(poster5);
        manager.save(poster6);
        manager.save(poster7);

        MoviePoster[] expected = {poster7, poster6, poster5, poster4, poster3, poster2};
        MoviePoster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastCustomUpperStandardLessPostersThanLength() {
        MoviePosterManager manager = new MoviePosterManager(6);

        manager.save(poster1);
        manager.save(poster2);
        manager.save(poster3);

        MoviePoster[] expected = {poster3, poster2, poster1};
        MoviePoster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}