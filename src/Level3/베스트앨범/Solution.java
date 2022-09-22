package Level3.베스트앨범;

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        ArrayList<Song> songList = new ArrayList<>();
        HashMap<String, Integer> genreMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            songList.add(new Song(i, genres[i], plays[i]));
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        // System.out.println(songList);
        Collections.sort(songList, (a, b) -> {
            if (a.play != b.play) {
                return b.play - a.play;
            } else {
                return a.num - b.num;
            }
        });
        // System.out.println(songList);

        List<Genre> genreList = new ArrayList<>();
        for (String key : genreMap.keySet()) {
            genreList.add(new Genre(key, genreMap.get(key)));
        }
        Collections.sort(genreList, (a, b) -> {
            return b.play - a.play;
        });
        // System.out.println(genreList);
        ArrayList<String> genreRankList = new ArrayList<>();
        for (Genre g : genreList) {
            genreRankList.add(g.genre);
        }

        ArrayList<ArrayList<Integer>> album = new ArrayList<>();
        for (int i = 0; i < genreList.size(); i++) {
            album.add(new ArrayList<Integer>());
        }

        HashMap<String, Integer> answerCheck = new HashMap<>();
        for (int i = 0; i < songList.size(); i++) {

            Song tmp = songList.get(i);
            if (answerCheck.get(tmp.genre) == null || answerCheck.get(tmp.genre) < 2) {
                // album.add
                int genreIndex = genreRankList.indexOf(tmp.genre);
                album.get(genreIndex).add(tmp.num);
                answerCheck.put(tmp.genre, answerCheck.getOrDefault(tmp.genre, 0) + 1);
            }

        }

        int answerSize = 0;
        for (ArrayList<Integer> list : album) {
            for (Integer i : list) {
                answerSize++;
            }
        }
        answer = new int[answerSize];
        int answerIndex = 0;
        for (ArrayList<Integer> list : album) {
            for (Integer i : list) {
                answer[answerIndex++] = i;
            }
        }

        return answer;
    }
}

class Song {
    int num;
    String genre;
    int play;

    Song(int num, String genre, int play) {
        this.num = num;
        this.genre = genre;
        this.play = play;
    }

    @Override
    public String toString() {
        return "{ num : " + num + " / gen : " + genre + " / play : " + play + " }";
    }
}

class Genre {
    String genre;
    int play;

    Genre(String genre, int play) {
        this.genre = genre;
        this.play = play;
    }

    @Override
    public String toString() {
        return "[ genre : " + genre + " / play : " + play + " ]";
    }
}

// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.Comparator;
// import java.util.HashMap;
// import java.util.LinkedList;
// import java.util.List;
// import java.util.Map;
// import java.util.Map.Entry;

// class Solution {
//     public int[] solution(String[] genres, int[] plays) {
//         int[] answer = {};
//         List<Song> album = new LinkedList<>();
// 		Map<String, Integer> map = new HashMap<>();
// 		for (int i = 0; i < genres.length; i++) {
// 			album.add(new Song(i, genres[i], plays[i]));
// 			map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
// 		}

// 		Comparator<Song> comparator = new Comparator<Song>() {

// 			@Override
// 			public int compare(Song o1, Song o2) {
// 				return o2.getNumberOfPlay() - o1.getNumberOfPlay();
// 			}

// 		};

// 		Collections.sort(album, comparator);

// 		List<Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
// 		Collections.sort(list, (o1, o2) -> (o2.getValue().compareTo(o1.getValue())));

// 		String[] genreRank = new String[list.size()];
// 		for (int i = 0; i < genreRank.length; i++)
// 			genreRank[i] = list.get(i).getKey();

// 		List<Integer> albumList = new LinkedList<>();
// 		for (int i = 0; i < genreRank.length; i++) {
// 			int num = 0;
// 			for (int j = 0; j < album.size(); j++) {
// 				if (album.get(j).getGenre().equals(genreRank[i])) {
// 					albumList.add(album.get(j).getNumber());
// 					num++;
// 				}
// 				if (num == 2)
// 					break;
// 			}
// 		}

// 		answer = new int[albumList.size()];
// 		for (int i = 0; i < albumList.size(); i++)
// 			answer[i] = albumList.get(i);
//         return answer;
//     }
// }

// class Song /* implements Comparable */ {
// 	private int number;
// 	private String genre;
// 	private int numberOfPlay;

// 	public int getNumber() {
// 		return number;
// 	}

// 	public void setNumber(int number) {
// 		this.number = number;
// 	}

// 	public String getGenre() {
// 		return genre;
// 	}

// 	public void setGenre(String genre) {
// 		this.genre = genre;
// 	}

// 	public int getNumberOfPlay() {
// 		return numberOfPlay;
// 	}

// 	public void setNumberOfPlay(int numberOfPlay) {
// 		this.numberOfPlay = numberOfPlay;
// 	}

// 	public Song(int number, String genre, int numberOfPlay) {
// 		this.number = number;
// 		this.genre = genre;
// 		this.numberOfPlay = numberOfPlay;
// 	}

// 	@Override
// 	public String toString() {
// 		return "Song [number=" + number + ", genre=" + genre + ", numberOfPlay=" + numberOfPlay + "]";
// 	}

// }
