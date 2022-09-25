import java.util.*;

public class BestAlbum{

    static class Song implements Comparable<Song>{
        int plays;
        int index;

        public Song(int plays, int index) {
            this.plays = plays;
            this.index = index;
        }

        @Override
        public int compareTo(Song o) {
            // 내림차순으로 비교할 수 있도록 한다
            return o.plays-this.plays;
        }
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        Map<String, Queue<Song>> albums = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            if(albums.containsKey(genre)){
                // 만약 해당 장르를 갖고있다면
                Queue<Song> queue = albums.get(genre);
                Song song = new Song(plays[i], i);
                queue.add(song); // 큐에 삽입
                albums.put(genre, queue); // 다시 해시맵에 저장
            }
            else{
                // 만약 해당 장르를 갖고있지 않다면 새롭게 추가
                Queue<Song> queue = new PriorityQueue<>(); // 내림차순으로 만들어준다
                Song song = new Song(plays[i], i);
                queue.add(song);
                albums.put(genre, queue);
            }
        }

        // 리스트에서 오름차순으로 정렬 시키기 위해
        List<Map.Entry<String, Queue<Song>>> entries = new LinkedList<>(albums.entrySet()); // 초기값으로 앨범에 있는 값들을 삽입

        entries.sort((o1, o2) -> o2.getValue().stream().mapToInt(song -> song.plays).sum()
        -o1.getValue().stream().mapToInt(song -> song.plays).sum());
        List<Integer> ret = new ArrayList<>();
        for (Map.Entry<String, Queue<Song>> entry : entries) {
            Queue<Song> q = albums.get(entry.getKey());
            if(q.size() >= 2){
                for(int i=0; i<2; i++){
                    ret.add(q.poll().index);
                }
            }
            else{
                ret.add(q.poll().index);
            }
        }


    }
}
