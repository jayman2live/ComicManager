import java.util.*;

// Abstract class representing a generic Comic
abstract class Comic {
    private String title;
    private int volume;
    private List<String> creators;
    private boolean isBorrowed;

    public Comic(String title, int volume, List<String> creators) {
        this.title = title;
        this.volume = volume;
        this.creators = creators;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getCreators() {
        return creators;
    }

    public void borrow() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is already borrowed.");
        }
    }

    public void returnComic() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println(title + " has been returned.");
        } else {
            System.out.println(title + " was not borrowed.");
        }
    }

    @Override
    public String toString() {
        return "Comic Title: " + title + ", Volume: " + volume + ", Creators: " + creators;
    }
}

// Concrete class for Superhero comics
class SuperheroComic extends Comic {
    private int popularity;

    public SuperheroComic(String title, int volume, List<String> creators, int popularity) {
        super(title, volume, creators);
        this.popularity = popularity;
    }
}

// Concrete class for Manga comics
class Manga extends Comic {
    private boolean isTranslated;

    public Manga(String title, int volume, List<String> creators, boolean isTranslated) {
        super(title, volume, creators);
        this.isTranslated = isTranslated;
    }
}

// ComicCatalog class to manage a collection of comics
class ComicCatalog {
    private List<Comic> comics;

    public ComicCatalog() {
        comics = new ArrayList<>();
    }

    public void addComic(Comic comic) {
        comics.add(comic);
    }

    public void displayAllComics() {
        for (Comic comic : comics) {
            System.out.println(comic);
        }
    }

    public Comic findByTitle(String title) {
        for (Comic comic : comics) {
            if (comic.getTitle().equalsIgnoreCase(title)) {
                return comic;
            }
        }
        System.out.println("Comic with title \"" + title + "\" not found.");
        return null;
    }

    public List<Comic> findByCreator(String creator) {
        List<Comic> result = new ArrayList<>();
        for (Comic comic : comics) {
            if (comic.getCreators().contains(creator)) {
                result.add(comic);
            }
        }
        if (result.isEmpty()) {
            System.out.println("No comics found by creator: " + creator);
        }
        return result;
    }
}

// Main class
public class ComicManager {
    public static void main(String[] args) {
        // Create instances of comics
        Comic superheroComic = new SuperheroComic(
            "Justice Warriors",
            1,
            Arrays.asList("John Doe", "Jane Smith"),
            90
        );
        
        Comic manga = new Manga(
            "Samurai Legends",
            5,
            Arrays.asList("Hiroshi Tanaka"),
            true
        );

        // Create the comic catalog
        ComicCatalog catalog = new ComicCatalog();
        catalog.addComic(superheroComic);
        catalog.addComic(manga);

        // Display all comics
        System.out.println("All Comics:");
        catalog.displayAllComics();

        // Search by title
        Comic foundComic = catalog.findByTitle("Justice Warriors");
        if (foundComic != null) {
            System.out.println("Found Comic: " + foundComic.getTitle());
        }

        // Borrow and return a comic
        superheroComic.borrow();
        superheroComic.returnComic();

        // Search by creator
        System.out.println("Comics by Hiroshi Tanaka:");
        for (Comic comic : catalog.findByCreator("Hiroshi Tanaka")) {
            System.out.println(comic.getTitle());
        }
    }
}
