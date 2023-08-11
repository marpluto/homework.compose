import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoviePosterManagerSaveTest {
    MoviePoster poster1 = new MoviePoster(1, "The Gentlemen", "action");
    MoviePoster poster2 = new MoviePoster(2, "Onward", "animation");
    MoviePoster poster3 = new MoviePoster(3, "The Invisible Man", "horror");

    MoviePosterManager manager = new MoviePosterManager();

    @Test
    public void saveNewOnePosterTest() {
        manager.save(poster1);

        MoviePoster[] expected = {poster1};
        MoviePoster[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void saveNewThreePostersFirstSequenceTest() {
        manager.save(poster1);
        manager.save(poster2);
        manager.save(poster3);

        MoviePoster[] expected = {poster1, poster2, poster3};
        MoviePoster[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void saveNewThreePostersAnotherSequenceTest() {
        manager.save(poster3);
        manager.save(poster2);
        manager.save(poster1);

        MoviePoster[] expected = {poster3, poster2, poster1};
        MoviePoster[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

}