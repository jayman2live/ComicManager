import java.util.ArrayList;
import java.util.List;

public interface Searchable {
    Comic findByTitle(String title);
    List<Comic> findByCreator(String creator);
}

class ComicCatalog implements Searchable {
    private List<Comic> comics;

    public ComicCatalog() {
        this.comics = new ArrayList<>();
    }

    public void addComic(Comic comic) {
        comics.add(comic);
    }

    @Override
    public Comic findByTitle(String title) {
        for (Comic comic : comics) {
            if (comic.getTitle().equalsIgnoreCase(title)) {
                return comic;
            }
        }
        System.out.println("Comic with title '" + title + "' not found.");
        return null;
    }

    @Override
    public List<Comic> findByCreator(String creator) {
        List<Comic> result = new ArrayList<>();
        for (Comic comic : comics) {
            if (comic.getCreators().contains(creator)) {
                result.add(comic);
            }
        }
        return result;
    }

    public void displayAllComics() {
        for (Comic comic : comics) {
            System.out.println("Title: " + comic.getTitle());
        }
    }
}
