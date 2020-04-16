package prbm_hashing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class BestAlbum {

	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
	
		solution(genres, plays);
	}
	
    public static int[] solution(String[] genres, int[] plays) {
    	ArrayList<Genre> genreArray = new ArrayList<>();
    	
    	Map<String, Integer> map1 = new HashMap<>();
    	Map<String, ArrayList<Song>> map2 = new HashMap<>();
    	
    	for(int i=0; i<genres.length; i++) {
    		map1.put(genres[i], map1.getOrDefault(genres[i], 0)+plays[i]);
    		ArrayList<Song> tempArray = map2.getOrDefault(genres[i], new ArrayList<Song>());
    		tempArray.add(new Song(i, plays[i]));
    		map2.put(genres[i], tempArray);
    		System.out.println(map2.get(genres[i]));
    	}
    	
    	for(String s : map1.keySet())
    		genreArray.add(new Genre(s, map1.get(s)));
    	
    	GenreComparator genreComparator = new GenreComparator();
    	SongComparator songComparator = new SongComparator();
    	genreArray.sort(genreComparator);

    	ArrayList<Integer> ansArray = new ArrayList<>();
    	for(Genre g : genreArray) {
    		ArrayList<Song> songArray = map2.get(g.genre);
    		songArray.sort(songComparator);
    		int size = songArray.size();
    		if(size>2) size=2;
    		for(int i=0; i<size; i++) ansArray.add(songArray.get(i).id);
    	}
    	
	   int[] answer = new int[ansArray.size()];
	    for (int i=0; i < answer.length; i++) {
	    	answer[i] = ansArray.get(i).intValue();
	    	System.out.println(answer[i]);
	    }
	    return answer;    	
    }
    

}
class Genre {
	String genre;
	int totalPlay;
	
	public Genre(String genre, int totalPlay) {
		this.genre=genre;
		this.totalPlay=totalPlay;
	}
}

class GenreComparator implements Comparator<Genre> {
	@Override
	public int compare(Genre o1, Genre o2) {
		return o2.totalPlay - o1.totalPlay;
	}
}

class Song {
	int play;
	int id;
	
	public Song(int id, int play) {
		this.id=id;
		this.play=play;
	}
	
}

class SongComparator implements Comparator<Song> {
	@Override
	public int compare(Song o1, Song o2) {
		if(o1.play==o2.play) return o1.id - o2.id;
		return o2.play - o1.play;
	}
}